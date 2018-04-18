package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.MyFileContentProvider;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomCreationBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class RoomCreationActivity extends AppCompatActivity {
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();     // Objeto da classe DialogFragmentCreator aonde estão ferramentas para criar Dialog Fragments
    AlertDialog dialog;
    Intent extra;
    Usuario usuarioLogado;
    ActivityRoomCreationBinding binding;
    SQLite sqLite;
    ImageView campoImagem;
    private byte[] byteArray;
    StorageReference storage;
    Uri buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_room_creation);
        campoImagem = (ImageView) findViewById(R.id.sala_imageView);
        sqLite = new SQLite(this);
        binding.setSalamodel(new SalaModel());
        storage = FirebaseStorage.getInstance().getReference();

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        extra = new Intent(this, RoomsMenu.class);

        binding.setCadevent(new Eventos() {
            @Override
            public void onClickCad() {

                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(RoomCreationActivity.this, loadingCircleDialog);

                    Uri uri;

                    if (byteArray != null){
                        uri = buffer;
                    }else {

                        uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
                    }
                    StorageReference path = storage.child("FotosSala").child(uri.getLastPathSegment());
                    path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            boolean foiInserido = false;
                            Uri uriCerta = taskSnapshot.getDownloadUrl();
                            Sala sala = new Sala(binding.getSalamodel().getNome(),binding.getSalamodel().getSenha(), usuarioLogado.getID(),
                                    binding.getSalamodel().getHistoria(), usuarioLogado.getNick());
                            if(binding.roomPasswordPlainText.getText().length() == 0){
                                sala.setSenha(" ");
                            }
                            sala.setUri(uriCerta.toString());
                            foiInserido = sqLite.insereDataSala(sala);
                            Sala sala1;
                            sala1 = sqLite.selecionarSala(binding.getSalamodel().getNome());
                            // System.out.println(usuarioLogado.getSalasID().toString());
                            int[] aux = new int[usuarioLogado.toIntArray(usuarioLogado.getSalasID()).length +1];
                            // System.out.println(Arrays.toString(usuarioLogado.toIntArray(usuarioLogado.getSalasID())));

                            for (int i = 0; i < usuarioLogado.toIntArray(usuarioLogado.getSalasID()).length; i++){
                                aux[i] = usuarioLogado.toIntArray(usuarioLogado.getSalasID())[i];
                            }
                            aux[usuarioLogado.toIntArray(usuarioLogado.getSalasID()).length] = sala1.getID();
                            // System.out.println(Arrays.toString(aux));
                            usuarioLogado.setSalasID(usuarioLogado.toIntList(aux));

                            sqLite.updateDataUsuario(usuarioLogado);
                            if(foiInserido == true){
                                geraDialog.fechaDialogFragment(dialog);
                                Toast.makeText(RoomCreationActivity.this, "Salvo", Toast.LENGTH_LONG).show();
                                extra.putExtra("usuarioLogado", usuarioLogado);
                                startActivity(extra);
                            }else{
                                geraDialog.fechaDialogFragment(dialog);
                                Toast.makeText(RoomCreationActivity.this, "Não Salvo", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            }
            @Override
            public void onClickLogin(){
                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //i.putExtra(MediaStore.EXTRA_OUTPUT, MyFileContentProvider.CONTENT_URI);
                startActivityForResult(i, 0);
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);


            if (data != null) {
                Bundle bundle = data.getExtras();

                // Recupera o Bitmap retornado pela c�mera
                Bitmap bitmap = (Bitmap) bundle.get("data");
                // Atualiza a imagem na tela
                buffer = getImageUri(this, bitmap);
                campoImagem.setImageBitmap(bitmap);

                try {
                    // Salva o array de bytes
                    ByteArrayOutputStream bArray = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bArray);
                    bArray.flush();
                    bArray.close();
                    this.byteArray = bArray.toByteArray();
                } catch (IOException ex) {

                }
            }
        }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}

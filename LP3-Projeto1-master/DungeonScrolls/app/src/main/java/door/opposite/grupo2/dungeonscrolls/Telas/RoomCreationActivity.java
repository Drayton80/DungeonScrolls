package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomCreationBinding;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class RoomCreationActivity extends AppCompatActivity {
    Intent extra;
    Usuario usuarioLogado;
    ActivityRoomCreationBinding binding;
    SQLite sqLite;
    ImageView campoImagem;
    private byte[] byteArray;
    StorageReference storage;

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

                    Uri uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
                    StorageReference path = storage.child("FotosSala").child(uri.getLastPathSegment());
                    path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            boolean foiInserido = false;
                            Uri uriCerta = taskSnapshot.getDownloadUrl();
                            Sala sala = new Sala(binding.getSalamodel().getNome(),binding.getSalamodel().getSenha(), usuarioLogado.getID(),
                                    binding.getSalamodel().getHistoria(), usuarioLogado.getNick());
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
                                Toast.makeText(RoomCreationActivity.this, "Salvo", Toast.LENGTH_LONG).show();
                                extra.putExtra("usuarioLogado", usuarioLogado);
                                startActivity(extra);
                            }else{
                                Toast.makeText(RoomCreationActivity.this, "Não Salvo", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            }
            @Override
            public void onClickLogin(){
                Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
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
}

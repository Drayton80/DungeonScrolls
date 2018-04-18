package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.commands.EventosFicha;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySheetBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

public class SheetActivity extends AppCompatActivity {
    ActivitySheetBinding binding;
    Usuario usuarioLogado;
    Sala salaUsada;
    Ficha fichaUsada;
    FichaModel fichaModel;
    Intent extra;
    SQLite sqLite;
    int[] salasID, fichasID;
    ImageView campoImagem;
    private byte[] byteArray;
    StorageReference storage;
    Uri buffer;
    Boolean mestre = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sheet);
        sqLite = new SQLite(this);
        campoImagem = (ImageView) findViewById(R.id.imageView);
        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        fichaUsada = (Ficha) extra.getSerializableExtra("fichaUsada");
        mestre =  extra.getBooleanExtra("mestre", mestre);

        storage = FirebaseStorage.getInstance().getReference();

        binding.setFichaElementos(new FichaModel(fichaUsada));
        if(fichaUsada.getImagem() != null) {
            Picasso.get().load(Uri.parse(fichaUsada.getImagem())).into(binding.imageView);
        }

        binding.setFichaButtons(new EventosFicha(){
            @Override
            public void onClickAparencia() {
                extra = new Intent(SheetActivity.this, SheetAppearanceActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickCombate() {
                extra = new Intent(SheetActivity.this, SheetBattleInformationActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickTalentosPericias() {
                extra = new Intent(SheetActivity.this, SheetFeatsSkillsActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickEquipamentos() {
                extra = new Intent(SheetActivity.this, SheetEquipmentItensActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickInfoMagias() {
                extra = new Intent(SheetActivity.this, SheetMagicInformationActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickPropriedadesEspeciais() {
                extra = new Intent(SheetActivity.this, SheetSpecialPropertiesActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickSalvarFicha() {
                fichaUsada.setNomePersonagem(binding.getFichaElementos().nomePersonagem);
                fichaUsada.setIdade(binding.getFichaElementos().idade);
                fichaUsada.setXp(binding.getFichaElementos().xp);
                fichaUsada.setRaca(binding.getFichaElementos().raca);
                fichaUsada.setClasseNivel(binding.getFichaElementos().classeNivel);
                fichaUsada.setForca(binding.getFichaElementos().forca);
                fichaUsada.setDestreza(binding.getFichaElementos().destreza);
                fichaUsada.setConstituicao(binding.getFichaElementos().constituicao);
                fichaUsada.setSabedoria(binding.getFichaElementos().sabedoria);
                fichaUsada.setInteligencia(binding.getFichaElementos().inteligencia);
                fichaUsada.setCarisma(binding.getFichaElementos().carisma);
                fichaUsada.setFortitude(binding.getFichaElementos().fortitude);
                fichaUsada.setFortitudeBase(binding.getFichaElementos().fortitudeBase);
                fichaUsada.setFortitudeOutros(binding.getFichaElementos().fortitudeOutros);
                fichaUsada.setReflexo(binding.getFichaElementos().reflexo);
                fichaUsada.setReflexoBase(binding.getFichaElementos().reflexoBase);
                fichaUsada.setReflexoOutros(binding.getFichaElementos().reflexoOutros);
                fichaUsada.setVontade(binding.getFichaElementos().vontade);
                fichaUsada.setVontadeBase(binding.getFichaElementos().vontadeBase);
                fichaUsada.setVontadeOutros(binding.getFichaElementos().vontadeOutros);
                fichaUsada.setCarctClasse(binding.getFichaElementos().carctClasse);

                Uri uri;

                if (byteArray != null){
                    uri = buffer;
                }else {

                    uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
                }
                StorageReference path = storage.child("FotosFicha").child(uri.getLastPathSegment());
                path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        boolean foiInserido = false;
                        Uri uriCerta = taskSnapshot.getDownloadUrl();

                        fichaUsada.setImagem(uriCerta.toString());
                    }
                });

                sqLite.updateDataFicha(fichaUsada);
                finish();
                startActivity(getIntent());
            }

            @Override
            public void onClickSalvarImagem() {
                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //i.putExtra(MediaStore.EXTRA_OUTPUT, MyFileContentProvider.CONTENT_URI);
                startActivityForResult(i, 0);

            }
        });
    }

    @Override
    public void onBackPressed() {
        extra = new Intent(SheetActivity.this, RoomActivity.class);
        extra.putExtra("usuarioLogado", usuarioLogado);
        extra.putExtra("salaUsada", salaUsada);
        mestre =  extra.getBooleanExtra("mestre", mestre);
        startActivity(extra);
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
            Uri uri;

            if (byteArray != null){
                uri = buffer;
            }else {

                uri = Uri.parse("android.resource://door.opposite.grupo2.dungeonscrolls/" + R.drawable.avatar);
            }
            StorageReference path = storage.child("FotosFicha").child(uri.getLastPathSegment());
            path.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    boolean foiInserido = false;
                    Uri uriCerta = taskSnapshot.getDownloadUrl();

                    fichaUsada.setImagem(uriCerta.toString());
                }
            });
            sqLite.updateDataFicha(fichaUsada);
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

}

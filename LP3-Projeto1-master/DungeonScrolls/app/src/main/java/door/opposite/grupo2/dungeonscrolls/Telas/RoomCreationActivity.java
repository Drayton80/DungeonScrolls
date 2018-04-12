package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_room_creation);
        campoImagem = (ImageView) findViewById(R.id.sala_imageView);
        sqLite = new SQLite(this);
        binding.setSalamodel(new SalaModel());

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        extra = new Intent(this, RoomsMenu.class);

        binding.setCadevent(new Eventos() {
            @Override
            public void onClickCad() {
                boolean foiInserido = false;
                Sala sala = new Sala(binding.getSalamodel().getNome(),binding.getSalamodel().getSenha(), usuarioLogado.getID(),
                        binding.getSalamodel().getHistoria(), usuarioLogado.getNick());
                if (byteArray != null) {
                    sala.setImagem(byteArray);
                }else{
                    Drawable d = campoImagem.getDrawable();
                    Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byteArray = stream.toByteArray();
                    sala.setImagem(byteArray);
                }
                foiInserido = sqLite.insereDataSala(sala);
                Sala sala1;
                sala1 = sqLite.selecionarSala(binding.getSalamodel().getNome());
                int[] aux = new int[usuarioLogado.getSalasID().length +1];

                for (int i = 0; i < usuarioLogado.getSalasID().length; i++){
                    aux[i] = usuarioLogado.getSalasID()[i];
                }
                aux[usuarioLogado.getSalasID().length] = sala1.getID();
                usuarioLogado.setSalasID(aux);
                
                sqLite.updateDataUsuario(usuarioLogado);
                if(foiInserido == true){
                    Toast.makeText(RoomCreationActivity.this, "Salvo", Toast.LENGTH_LONG).show();
                    extra.putExtra("usuarioLogado", usuarioLogado);
                    startActivity(extra);
                }else{
                    Toast.makeText(RoomCreationActivity.this, "Não Salvo", Toast.LENGTH_LONG).show();
                }
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
            }
            catch (IOException ex) {

            }
        }
    }
}

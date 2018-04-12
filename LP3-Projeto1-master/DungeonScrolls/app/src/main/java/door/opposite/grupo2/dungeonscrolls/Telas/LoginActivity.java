package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityLoginBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.Animations;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

public class LoginActivity extends Activity {
    Animations animacoes = new Animations();
    Intent it;
    Bundle bundle = new Bundle();
    ActivityLoginBinding binding;
    //List<Usuario> listaUsuario;
    SQLite sqLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setUsuariomodel(new UsuarioModel());
        sqLite = new SQLite(this);
        it = new Intent(this, RoomsMenu.class);
        //listaUsuario = sqLite.listaUsuario();

        binding.setCadevent(new Eventos() {
            @Override
            public void onClickCad() {

            }

            @Override
            public void onClickLogin() {
                Usuario usuario1;
                usuario1 = sqLite.selecionarUsuario(binding.getUsuariomodel().getNick());
                System.out.println(usuario1.getID());
                System.out.println(Arrays.toString(usuario1.getSalasID()));
                System.out.println(usuario1.getSenha() + " ======================================================================================");
                System.out.println(binding.getUsuariomodel().getSenha() + " ========================================================================================");
                if (usuario1.getSenha().equals(binding.getUsuariomodel().getSenha())){
                    Toast.makeText(LoginActivity.this, "Logou", Toast.LENGTH_LONG).show();
                    it.putExtra("usuarioLogado", usuario1);

                    // Construção e exibição do Dialago Fragment:
                    /*
                    android.support.v7.app.AlertDialog.Builder mBuilder = new android.support.v7.app.AlertDialog.Builder(LoginActivity.this);

                    View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                    mBuilder.setView(loadingCircleDialog);
                    android.support.v7.app.AlertDialog dialog = mBuilder.create();
                    dialog.show();

                    animacoes.loadingMagicCircle(LoginActivity.this);
                    animacoes.startLoadingAnimation();
                    */


                    startActivity(it);

                }else{
                    Toast.makeText(LoginActivity.this, "Senha incorreta", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}

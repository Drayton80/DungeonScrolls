package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.SQLite;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityLoginBinding;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

public class LoginActivity extends Activity {

    ActivityLoginBinding binding;
    //List<Usuario> listaUsuario;
    SQLite sqLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setUsuariomodel(new UsuarioModel());
        sqLite = new SQLite(this);
        //listaUsuario = sqLite.listaUsuario();

        binding.setCadevent(new Eventos() {
            @Override
            public void onClickCad() {

            }

            @Override
            public void onClickLogin() {
                Usuario usuario1;
                usuario1 = sqLite.selecionarUsuario(binding.getUsuariomodel().getNick());
                System.out.println(usuario1.getSenha() + " ======================================================================================");
                System.out.println(binding.getUsuariomodel().getSenha() + " ========================================================================================");
                if (usuario1.getSenha().equals(binding.getUsuariomodel().getSenha())){
                    Toast.makeText(LoginActivity.this, "Logou", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Senha incorreta", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}

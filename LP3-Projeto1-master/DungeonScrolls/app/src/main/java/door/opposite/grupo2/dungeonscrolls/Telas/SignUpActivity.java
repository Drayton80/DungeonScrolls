package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySignUpBinding;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

public class SignUpActivity extends Activity {

    ActivitySignUpBinding binding;
    SQLite sqLite;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sign_up);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        sqLite = new SQLite(this);
        binding.setUsuariomodel(new UsuarioModel());


        binding.setCadevent(new Eventos() {

            @Override
            public void onClickLogin(){}

            @Override
            public void onClickCad() {
                boolean foiInserido = false;
                sqLite.atualizaDataUsuario();
                foiInserido = sqLite.insereDataUsuario(new Usuario(binding.getUsuariomodel().getNick(),
                        binding.getUsuariomodel().getSenha(), binding.getUsuariomodel().getEmail()));



                if(foiInserido == true){
                    Toast.makeText(SignUpActivity.this, "Salvo", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUpActivity.this, "Não Salvo", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

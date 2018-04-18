package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySignUpBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

public class SignUpActivity extends Activity {
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();     // Objeto da classe DialogFragmentCreator aonde estão ferramentas para criar Dialog Fragments
    AlertDialog dialog;
    ActivitySignUpBinding binding;
    SQLite sqLite;
    Intent it;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        sqLite = new SQLite(this);
        binding.setUsuariomodel(new UsuarioModel());
        it = new Intent(this, MainActivity.class);


        binding.setCadevent(new Eventos() {

            @Override
            public void onClickLogin(){}

            @Override
            public void onClickCad() {
                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(SignUpActivity.this, loadingCircleDialog);

                try{
                    sqLite.selecionarUsuario(binding.getUsuariomodel().getNick());
                    Toast.makeText(SignUpActivity.this, "Nome de usuario existente", Toast.LENGTH_LONG).show();
                    geraDialog.fechaDialogFragment(dialog);
                }catch (Exception e) {
                    boolean foiInserido = false;
                    sqLite.atualizaDataUsuario();
                    foiInserido = sqLite.insereDataUsuario(new Usuario(binding.getUsuariomodel().getNick(),
                            binding.getUsuariomodel().getSenha(), binding.getUsuariomodel().getEmail()));


                    if (foiInserido == true) {
                        Toast.makeText(SignUpActivity.this, "Salvo", Toast.LENGTH_LONG).show();
                        startActivity(it);
                    } else {
                        Toast.makeText(SignUpActivity.this, "Não Salvo", Toast.LENGTH_LONG).show();
                        geraDialog.fechaDialogFragment(dialog);
                    }
                }
            }
        });


    }


    @Override
    protected void onStop() {
        super.onStop();
        // dialog só é null antes de ser instanciado, apenas por garantia para não dar erros
        if(dialog != null){
            // Usado para fechar o Dialog Fragment do Loading Magic Circle, é chamado no onStop() pois ele apenas ocorre quando outra activity é chamada
            // e essa sai de visualização, logo após não estar mais visível.
            geraDialog.fechaDialogFragment(dialog);
        }
    }
}

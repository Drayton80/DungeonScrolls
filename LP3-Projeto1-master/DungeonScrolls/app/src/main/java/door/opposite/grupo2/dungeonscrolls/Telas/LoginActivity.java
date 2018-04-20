package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Semaphore;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityLoginBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

public class LoginActivity extends Activity {
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();     // Objeto da classe DialogFragmentCreator aonde estão ferramentas para criar Dialog Fragments
    AlertDialog dialog;
    Intent it;
    Bundle bundle = new Bundle();
    ActivityLoginBinding binding;
    //List<Usuario> listaUsuario;
    SQLite sqLite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
        View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
        // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
        dialog = geraDialog.criaDialogFragmentLoadingCircle(LoginActivity.this, loadingCircleDialog);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        binding.setUsuariomodel(new UsuarioModel());
        sqLite = new SQLite(this);
        it = new Intent(this, RoomsMenu.class);
        //listaUsuario = sqLite.listaUsuario();
        sqLite.atualizaDataUsuario();
        sqLite.atualizaDataFicha();
        sqLite.atualizaDataSala();
        final String senhaInvalida = getResources().getString(R.string.toast_login_senhaInvalida);
        final String usuarioInexistente = getResources().getString(R.string.toast_login_usuarioInexistente);

        binding.setCadevent(new Eventos() {
            @Override
            public void onClickCad() {

            }

            @Override
            public void onClickLogin() {

                // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator e pega a referência para ele, além de rodar a animação de Loading
                dialog = geraDialog.criaDialogFragmentLoadingCircle(LoginActivity.this, loadingCircleDialog);

                try{

                    Usuario usuario1;

                    sqLite.atualizaDataUsuario();

                    usuario1 = sqLite.selecionarUsuario(binding.getUsuariomodel().getNick());

                    if (usuario1.getSenha().equals(binding.getUsuariomodel().getSenha())) {
                        it.putExtra("usuarioLogado", usuario1);

                        // Chama o método que gera a animação do loading
                        //animacoes.loadingMagicCircle(loadingCircleDialog);
                        // Método que inicia a animação
                        //animacoes.startLoadingAnimation();

                        startActivity(it);
                    } else {
                        Toast.makeText(LoginActivity.this, senhaInvalida, Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, usuarioInexistente, Toast.LENGTH_LONG).show();
                    geraDialog.fechaDialogFragment(dialog);
                }
            }
        });

        geraDialog.fechaDialogFragment(dialog);
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
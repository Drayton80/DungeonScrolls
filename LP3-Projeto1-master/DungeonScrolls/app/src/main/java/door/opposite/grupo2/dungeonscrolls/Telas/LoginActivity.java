package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
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
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

public class LoginActivity extends Activity {
    Animations animacoes = new Animations();                            // Objeto da classe Animations aonde estão todas as animações do projeto
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();     // Objeto da classe DialogFragmentCreator aonde estão ferramentas para criar Dialog Fragments
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
                try {
                    usuario1 = sqLite.selecionarUsuario(binding.getUsuariomodel().getNick());
                    if ((usuario1.getSenha().equals(binding.getUsuariomodel().getSenha()))) {
                        Toast.makeText(LoginActivity.this, "Logou", Toast.LENGTH_LONG).show();
                        it.putExtra("usuarioLogado", usuario1);


                        // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                        View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);

                        // Cria o Dialog Fragment através de um dos métodos da classe DialogFragmentCreator
                        geraDialog.criaFragmentDialogLoadingCircle(LoginActivity.this, loadingCircleDialog);
                        // Chama o método que gera a animação do loading
                        animacoes.loadingMagicCircle(loadingCircleDialog);
                        // Método que inicia a animação
                        animacoes.startLoadingAnimation();

                        startActivity(it);

                    } else {
                        Toast.makeText(LoginActivity.this, "Senha incorreta", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Usuário Inválido", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
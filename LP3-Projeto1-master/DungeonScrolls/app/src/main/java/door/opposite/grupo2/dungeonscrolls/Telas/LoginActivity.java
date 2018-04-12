package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    AnimationDrawable loadingAnimation;         // Objeto da classe AnimationDrawable para poder gerar as animações
    Animations animacoes = new Animations();    // Objeto da classe Animations aonde estão todas as animações do projeto
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

                    // Cria um Builder para poder manipular o Dialog
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);

                    // Cria uma referência para o dialogfragment_loadingcircle para poder gerar seu layout e referenciar aquilo que tem dentro dele
                    View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);

                    // Serve para referenciar a tela (layout) ao qual o Dialog Fragment será exibido em forma de pop-up
                    dialogBuilder.setView(loadingCircleDialog);
                    // Cria efetivamente o dialog
                    AlertDialog dialog = dialogBuilder.create();
                    // Definindo a cor do fundo do Dialog Fragment para transparente:
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    // Exibe o dialog
                    dialog.show();

                    // Chama o método que gera a animação do loading
                    animacoes.loadingMagicCircle(loadingCircleDialog);
                    // Método que inicia a animação
                    animacoes.startLoadingAnimation();

                    startActivity(it);

                }else{
                    Toast.makeText(LoginActivity.this, "Senha incorreta", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

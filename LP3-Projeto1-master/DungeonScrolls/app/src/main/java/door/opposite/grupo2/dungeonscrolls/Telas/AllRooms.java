package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.DialogFragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityAllRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragment;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragmentID;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class AllRooms extends AppCompatActivity implements NoticeDialogFragmentID.NoticeDialogListenerID{
    // Atributos relativos à parte visual do programa:
    // Atributos relativos à parte visual do programa:
    AlertDialog dialog;     // Um referenciador para Dialog Fragments, é possível fechar ou mostrar dialogs com ele
    DialogFragmentCreator geradorDialog = new DialogFragmentCreator();  // Cria um manipulador de Dialog Fragments, objeto da classe DialogFragmentCreator
    // Atributos relativos ao binding:
    ActivityAllRoomsBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;
    SalaModel salaModel, salaModelSelecionada;
    ArrayList<SalaModel> salaModelArrayList;
    SalaAdapter salaAdapter;
    int[] salasID;
    List<Sala> allSalasID;
    Sala salaUsada, salaSelecionada;
    String novoJogador;
    Boolean salaUsuario = false, mestre = false, continuar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cria uma View que referencia o layout dialogfragment_loadingcircle
        View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
        // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
        // referência para um AlertDialog chamado dialog
        dialog = geradorDialog.criaDialogFragmentLoadingCircle(this, loadingCircleDialog);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_rooms);
        sqLite = new SQLite(this);
        sqLite.atualizaDataSala();

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        novoJogador = usuarioLogado.getNick();

        allSalasID = sqLite.listaSala();

        salasID = usuarioLogado.toIntArray(usuarioLogado.getSalasID());
        salaModel = new SalaModel();
        salaModelArrayList = salaModel.getArrayListSala(sqLite.listaSala(), sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvRooms.setAdapter(salaAdapter);

        binding.lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
                // referência para um AlertDialog chamado dialog
                dialog = geradorDialog.criaDialogFragmentLoadingCircle(AllRooms.this, loadingCircleDialog);
                int salaPosicao = position;
                int i = 0;
                System.out.println("=================Sala Posição: " + salaPosicao);
                try {
                    salaModelSelecionada = salaModelArrayList.get(salaPosicao);
                }catch (Exception e){}
                for (i = 0; i < salasID.length; i++) {
                    try {
                        if (salasID[i + 1] == 0) {
                            System.out.println("=================Entrou aqui!!!!!!");
                        }else{
                            salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                            if (salaUsada.getNomeMestre().equals(salaModelSelecionada.getNomeMestre())) {
                                mestre = true;
                                System.out.println("=================Mesmo Mestre: " + salaModel.getMestre() + " == " + salaUsada.getMestre());
                                // Cria uma View que referencia o layout dialogfragment_loadingcircle


                                salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                                extra = new Intent(AllRooms.this, RoomActivity.class);
                                extra.putExtra("usuarioLogado", usuarioLogado);
                                extra.putExtra("salaUsada", salaUsada);
                                extra.putExtra("mestre", mestre);
                                salaUsuario = true;
                                startActivity(extra);
                            }
                        }
                    }catch(Exception e){}
                }
                if(salaUsuario == false){
                    if(salaModelSelecionada.getSenha().length() == 1){


                        salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
                        extra = new Intent(AllRooms.this, RoomActivity.class);
                        extra.putExtra("usuarioLogado", usuarioLogado);
                        extra.putExtra("salaUsada", salaUsada);
                        salaUsuario = true;
                        startActivity(extra);
                    }else{
                        showNoticeDialog();
                    }
                }
            }
        });

        // Usa um dos métodos de DialogFragmentCreator para fechar o loading dialog, passando como parâmetro a referência para
        // o próprio dialog retornado na criação com criaDialogFragmentLoadingCircle
        geradorDialog.fechaDialogFragment(dialog);
    }

    public void showNoticeDialog() {
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragmentID();
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String senha) {
        if(salaModelSelecionada.getSenha().equals(senha)){
            mestre = false;
            salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
            extra = new Intent(AllRooms.this, RoomActivity.class);
            extra.putExtra("usuarioLogado", usuarioLogado);
            extra.putExtra("salaUsada", salaUsada);
            extra.putExtra("mestre", mestre);
            startActivity(extra);
        }else{
            Toast.makeText(AllRooms.this, "Senha incorreta", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }

    public void onBackPressed(){
        extra = new Intent(AllRooms.this, RoomsMenu.class);
        extra.putExtra("usuarioLogado", usuarioLogado);
        finish();
        startActivity(extra);
    }

    @Override
    public void onPause() {
        super.onPause();
        continuar = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(continuar) {
            extra = new Intent(AllRooms.this, RoomsMenu.class);
            extra.putExtra("usuarioLogado", usuarioLogado);
            finish();
            startActivity(extra);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        // dialog só é null antes de ser instanciado, apenas por garantia para não dar erros
        if(dialog != null){
            // Usado para fechar o Dialog Fragment do Loading Magic Circle, é chamado no onStop() pois ele apenas ocorre quando outra activity é chamada
            // e essa sai de visualização, logo após não estar mais visível.
            geradorDialog.fechaDialogFragment(dialog);
        }
    }
}
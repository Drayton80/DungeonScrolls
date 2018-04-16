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

/**
 * Created by FHILIPE on 08/04/2018.
 */

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
    Boolean salaUsuario = false, salaNulla = false;

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

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");

        allSalasID = sqLite.listaSala();

        salasID = usuarioLogado.toIntArray(usuarioLogado.getSalasID());
        salaModel = new SalaModel();
        salaModelArrayList = salaModel.getArrayListSala(sqLite.listaSala(), sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvRooms.setAdapter(salaAdapter);

        binding.lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int salaPosicao = position;
                System.out.println("=================Sala Posição: " + salaPosicao);
                try {
                    salaModelSelecionada = salaModelArrayList.get(salaPosicao);
                    System.out.println("=================Sala Model Selecionada: " + salaModelSelecionada.getMestre());
                }catch (Exception e){}
                for (int i = 0; i < salasID.length; i++) {
                    try {
                        if (salasID[i + 1] == 0) {
                            System.out.println("=================Entrou aqui!!!!!!");
                        }else{
                            salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                            System.out.println("=================Sala Usada: " + salaUsada.getMestre());
                            if (salaUsada.getNomeMestre().equals(salaModelSelecionada.getNomeMestre())) {
                                System.out.println("=================Mesmo Mestre: " + salaModel.getMestre() + " == " + salaUsada.getMestre());
                                // Cria uma View que referencia o layout dialogfragment_loadingcircle
                                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                                // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
                                // referência para um AlertDialog chamado dialog
                                dialog = geradorDialog.criaDialogFragmentLoadingCircle(AllRooms.this, loadingCircleDialog);

                                salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                                extra = new Intent(AllRooms.this, RoomActivity.class);
                                extra.putExtra("usuarioLogado", usuarioLogado);
                                extra.putExtra("salaUsada", salaUsada);
                                //System.out.println("=================Entrou aqui, eu achei a sala!" + salaUsada.getNotas());
                                salaUsuario = true;
                                startActivity(extra);
                            }
                        }
                    }catch(Exception e){}
                }
                if(salaUsuario == false) {
                    showNoticeDialog();
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
        if(salaModelSelecionada.getSenha() == null){
            salaModelSelecionada.setSenha(" ");
            salaNulla = true;
        }
        if((senha == null) && salaNulla){
            salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
            extra = new Intent(AllRooms.this, RoomActivity.class);
            extra.putExtra("usuarioLogado", usuarioLogado);
            extra.putExtra("salaUsada", salaUsada);
            startActivity(extra);
        }
        if(salaModelSelecionada.getSenha().equals(senha)){
            salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
            extra = new Intent(AllRooms.this, RoomActivity.class);
            extra.putExtra("usuarioLogado", usuarioLogado);
            extra.putExtra("salaUsada", salaUsada);
            startActivity(extra);
        }else{
            Toast.makeText(AllRooms.this, "Senha incorreta", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }
}
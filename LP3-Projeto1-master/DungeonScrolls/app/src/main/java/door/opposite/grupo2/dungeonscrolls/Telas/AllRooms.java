package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityAllRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

/**
 * Created by FHILIPE on 08/04/2018.
 */

public class AllRooms extends AppCompatActivity {
    // Atributos relativos à parte visual do programa:
    DialogFragmentCreator geradorDialog = new DialogFragmentCreator();
    // Atributos relativos ao binding:
    ActivityAllRoomsBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;
    SalaModel salaModel;
    ArrayList<SalaModel> salaModelArrayList;
    SalaAdapter salaAdapter;
    List<Integer> salasID;
    Sala salaUsada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cria uma View que referencia o layout dialogfragment_loadingcircle
        View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
        // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
        // referência para um AlertDialog chamado dialog
        AlertDialog dialog = geradorDialog.criaDialogFragmentLoadingCircle(this, loadingCircleDialog);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_rooms);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");

        salasID = usuarioLogado.getSalasID();
        salaModel = new SalaModel();
        salaModelArrayList = salaModel.getArrayListSala(sqLite.listaSala(), sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvRooms.setAdapter(salaAdapter);

        // Usa um dos métodos de DialogFragmentCreator para fechar o loading dialog, passando como parâmetro a referência para
        // o próprio dialog retornado na criação com criaDialogFragmentLoadingCircle
        geradorDialog.fechaDialogFragment(dialog);
    }
}
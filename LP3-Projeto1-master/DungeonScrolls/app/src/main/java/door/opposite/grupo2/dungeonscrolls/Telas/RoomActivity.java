package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomBinding;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class RoomActivity extends AppCompatActivity {
    ActivityRoomBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;
    Sala salaUsada;
    SalaModel salaModel;
    FichaModel fichaModel;
    ArrayList<FichaModel> fichaModelArrayList;
    FichaAdapter fichaAdapter;
    int[] fichasID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        sqLite = new SQLite(this);

        binding.setItemSalaCompleta(new SalaModel(salaUsada));

        fichasID = usuarioLogado.getFichasID();
        fichaModel = new FichaModel();
        fichaModelArrayList = fichaModel.getArrayListaFicha(usuarioLogado.getFichasID(), sqLite);
        fichaAdapter = new FichaAdapter(this, fichaModelArrayList);
        binding.roomListViewFichas.setAdapter(fichaAdapter);


        binding.roomEditTextResumo.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                salaUsada.setHistoria(binding.roomEditTextResumo.getText().toString());
                sqLite.updateDataSala(salaUsada);
            }
        });

        binding.roomEditTextOutrasAnotacoes.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                salaUsada.setNotas(binding.roomEditTextOutrasAnotacoes.getText().toString());
                System.out.println("==============Texto: " + salaUsada.getNotas());
                sqLite.updateDataSala(salaUsada);
            }
        });

        ListView listViewFichas = (ListView) findViewById(R.id.room_listView_fichas);
        ArrayAdapter adapter = new RoomListViewFichaAdapter(this, adicionaFichas());
        listViewFichas.setAdapter(adapter);

        //listViewFichas.setOnItemSelectedListener();
    }

    // Método que efetivamente adiciona as fichas ao ListView:
    private ArrayList<RoomListViewFicha> adicionaFichas(){
        // Cria um ArrayLista para introduzir os elementos
        ArrayList<RoomListViewFicha> listaDeFichas = new ArrayList<RoomListViewFicha>();

        // Armando, é aqui que tu vai fazer o link com o banco de dados das fichas
        // Esse aqui abaixo é só um exemplo para vc ter como base:
        RoomListViewFicha ficha = new RoomListViewFicha("Nome 1", R.drawable.avatar);
        listaDeFichas.add(ficha);

        ficha.setNome("Nome 2");
        ficha.setImagem(R.drawable.avatar);
        listaDeFichas.add(ficha);
        // Fim do Exemplo :v


        // Retorna a lista toda já montada com cada elemento:
        return listaDeFichas;
    }

}

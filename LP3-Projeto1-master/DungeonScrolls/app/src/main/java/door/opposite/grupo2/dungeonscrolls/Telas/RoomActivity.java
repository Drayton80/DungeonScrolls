package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
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
    Ficha fichaUsada;
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

        fichasID = salaUsada.getFichasID();
        fichaModel = new FichaModel();
        fichaModelArrayList = fichaModel.getArrayListaFicha(salaUsada.getFichasID(), sqLite);
        fichaAdapter = new FichaAdapter(this, fichaModelArrayList);
        binding.roomListViewFichas.setAdapter(fichaAdapter);

        binding.roomListViewFichas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int fichaPosicao = position;
                for(int i = 0; i < salaUsada.getFichasID().length; i++){
                    if(i == fichaPosicao){
                        if (fichasID[i+1] == 0){
                        }else{
                            // System.out.println("=================Entrou aqui, eu achei a sala!");
                            fichaUsada = sqLite.selecionarFicha(fichasID[i+1]);
                            extra = new Intent(RoomActivity.this, SheetActivity.class);
                            extra.putExtra("usuarioLogado", usuarioLogado);
                            extra.putExtra("salaUsada", salaUsada);
                            extra.putExtra("fichaUsada", fichaUsada);
                            System.out.println("=================Entrou aqui, eu achei a sala!" + salaUsada.getNotas());
                            startActivity(extra);
                        }
                    }
                }
            }
        });

        binding.roomEditTextResumo.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s){}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                salaUsada.setHistoria(binding.roomEditTextResumo.getText().toString());
                sqLite.updateDataSala(salaUsada);
            }
        });

        binding.roomEditTextOutrasAnotacoes.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                salaUsada.setNotas(binding.roomEditTextOutrasAnotacoes.getText().toString());
                System.out.println("==============Texto: " + salaUsada.getNotas());
                sqLite.updateDataSala(salaUsada);
            }
        });
        /*
        ListView listViewFichas = (ListView) findViewById(R.id.room_listView_fichas);
        ArrayAdapter adapter = new RoomListViewFichaAdapter(this, adicionaFichas());
        listViewFichas.setAdapter(adapter);
        */

        //listViewFichas.setOnItemSelectedListener();
        binding.setAdicionaFicha(new Eventos() {
            @Override
            public void onClickCad() {
                sqLite.insereDataFicha(new Ficha("Nova Ficha", "",
                        "", "", "", "", "", "",
                        0, 0, 0, 20, 16, 0, 0,
                        0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0,
                        0, 0, 5, 12, 0,
                        0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, "", "", "", "",
                        "", "", "", "", "" ));

                int[] aux = new int[salaUsada.getFichasID().length +1];

                for (int i = 0; i < salaUsada.getFichasID().length; i++){
                    aux[i] = salaUsada.getFichasID()[i];
                }
                aux[salaUsada.getFichasID().length] = sqLite.ultimaFicha();
                salaUsada.setFichasID(aux);
                sqLite.updateDataSala(salaUsada);
                fichasID = salaUsada.getFichasID();
                fichaModel = new FichaModel();
                fichaModelArrayList = fichaModel.getArrayListaFicha(salaUsada.getFichasID(), sqLite);
                fichaAdapter = new FichaAdapter(RoomActivity.this, fichaModelArrayList);
                binding.roomListViewFichas.setAdapter(fichaAdapter);
            }

            @Override
            public void onClickLogin() {
            }
        });

    }
    /*
    // Método que efetivamente adiciona as fichas ao ListView::
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
    */
}

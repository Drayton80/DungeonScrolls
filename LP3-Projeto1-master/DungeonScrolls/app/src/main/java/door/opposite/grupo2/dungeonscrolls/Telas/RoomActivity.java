package door.opposite.grupo2.dungeonscrolls.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

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

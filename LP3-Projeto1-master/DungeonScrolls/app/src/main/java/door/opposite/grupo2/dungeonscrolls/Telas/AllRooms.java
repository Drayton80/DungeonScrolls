package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityAllRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityUserRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

/**
 * Created by FHILIPE on 08/04/2018.
 */

public class AllRooms extends AppCompatActivity {

    ActivityAllRoomsBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;
    SalaModel salaModel;
    ArrayList<SalaModel> salaModelArrayList;
    SalaAdapter salaAdapter;
    int[] salasID;
    Sala salaUsada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_rooms);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");

        salasID = usuarioLogado.getSalasID();
        salaModel = new SalaModel();
        salaModelArrayList = salaModel.getArrayListSala(sqLite.listaSala(), sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvRooms.setAdapter(salaAdapter);

/*
        ListView lista = (ListView) findViewById(R.id.lvRooms);
        ArrayAdapter adapter = new RoomAdapter(this, addRooms());
        lista.setAdapter(adapter);
        */
    }


/*
    private ArrayList<Room> addRooms() {
        ArrayList<Room> room = new ArrayList<Room>();

         //Adicionar imagem, senha, favorito? e outros atributos

        Room r = new Room("Sala 1", "Drayton", "D&D 3.5");
        room.add(r);

        r = new Room("Sala 2", "Drayton", "Rifts");
        room.add(r);

        r = new Room("Sala 3", "Drayton", "Hackmaster");
        room.add(r);

        r = new Room("Sala 4", "Drayton", "Pathfinder");
        room.add(r);

        return room;
    }
    */
}
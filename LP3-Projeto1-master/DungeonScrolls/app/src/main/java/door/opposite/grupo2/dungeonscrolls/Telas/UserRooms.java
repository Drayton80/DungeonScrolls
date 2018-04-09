package door.opposite.grupo2.dungeonscrolls.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


import door.opposite.grupo2.dungeonscrolls.R;

public class UserRooms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lvUserRooms);
        ArrayAdapter adapter = new RoomAdapter(this, addRooms());
        lista.setAdapter(adapter);
    }



    private ArrayList<Room> addRooms() {
        ArrayList<Room> room = new ArrayList<Room>();

        /** Adicionar imagem, senha, favorito? e outros atributos...*/

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
}

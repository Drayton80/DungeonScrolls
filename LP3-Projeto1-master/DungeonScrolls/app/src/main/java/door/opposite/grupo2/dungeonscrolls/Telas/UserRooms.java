package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityUserRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;

public class UserRooms extends AppCompatActivity {
    ActivityUserRoomsBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_rooms);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        extra = new Intent(this, RoomCreationActivity.class);

        ListView lista = (ListView) findViewById(R.id.lvUserRooms);
        ArrayAdapter adapter = new RoomAdapter(this, addRooms());
        lista.setAdapter(adapter);

        binding.setCriaSala(new Eventos() {
            @Override
            public void onClickCad() {
                extra.putExtra("usuarioLogado", usuarioLogado);
                startActivity(extra);
            }

            @Override
            public void onClickLogin() {
            }
        });
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

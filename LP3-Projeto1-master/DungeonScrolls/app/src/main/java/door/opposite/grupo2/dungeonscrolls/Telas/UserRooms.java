package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;


import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityUserRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class UserRooms extends AppCompatActivity {
    ActivityUserRoomsBinding binding;
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_rooms);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");

        salasID = usuarioLogado.getSalasID();
        salaModel = new SalaModel();
        salaModelArrayList = salaModel.getArrayListSala(usuarioLogado.getSalasID(), sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvUserRooms.setAdapter(salaAdapter);

        binding.lvUserRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int salaPosicao = position;
                for(int i = 0; i < usuarioLogado.getSalasID().length; i++){
                    if(i == salaPosicao){
                        if (salasID[i+1] == 0){
                         }else{
                           // System.out.println("=================Entrou aqui, eu achei a sala!");
                            salaUsada = sqLite.selecionarSala(salasID[i+1]);
                            extra = new Intent(UserRooms.this, RoomActivity.class);
                            extra.putExtra("usuarioLogado", usuarioLogado);
                            extra.putExtra("salaUsada", salaUsada);
                            System.out.println("=================Entrou aqui, eu achei a sala!" + salaUsada.getNotas());
                            startActivity(extra);
                        }
                    }
                }
            }
        });

        binding.setCriaSala(new Eventos() {
            @Override
            public void onClickCad() {
                extra = new Intent(UserRooms.this, RoomCreationActivity.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                startActivity(extra);
            }

            @Override
            public void onClickLogin() {
            }
        });
    }


    /*
    private ArrayList<Room> addRooms() {
        ArrayList<Room> room = new ArrayList<Room>();
        Room r;
        //salasID = usuarioLogado.getSalasID();
        //System.out.println("SalaID: " + salasID[0]);
        /** Adicionar imagem, senha, favorito? e outros atributos...*/
        /*
        if(salasID != null){
            for(int i = 0; i < usuarioLogado.getSalasID().length; i++){
                salaUsuario = sqLite.selecionarSala(salasID[i]);
                r = new Room(salaUsuario.getNome(), usuarioLogado.getNick(), "Nada ainda");
            }
        }


        r = new Room("Sala 1", "Drayton", "D&D 3.5");
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

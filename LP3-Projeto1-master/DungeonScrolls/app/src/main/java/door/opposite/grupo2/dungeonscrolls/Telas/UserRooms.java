package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.Arrays;


import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityUserRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class UserRooms extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    ActivityUserRoomsBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;
    SalaModel salaModel;
    ArrayList<SalaModel> salaModelArrayList;
    SalaAdapter salaAdapter;
    int[] salasID;
    Sala salaUsada;
    int posicaoDelete = 0;


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

        binding.lvUserRooms.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                PopupMenu menu = new PopupMenu(UserRooms.this ,view);
                menu.setOnMenuItemClickListener(UserRooms.this);
                menu.inflate(R.menu.menu_popup_salas);
                posicaoDelete = position;

                menu.show();

                return true;
            }
        });


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



    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_vincular:
                return true;
            case R.id.item_deleta:
                for(int i = 0; i < usuarioLogado.getSalasID().length; i++){
                    if(i == posicaoDelete){
                        if (salasID[i+1] == 0){
                            System.out.println("==========================================================");
                        }else{
                            // System.out.println("=================Entrou aqui, eu achei a sala!");
                            Sala sala = sqLite.selecionarSala(salasID[i+1]);
                            //----------comeca
                            int array_auxiliar[] = usuarioLogado.getSalasID();
                            array_auxiliar = achaElemento(array_auxiliar, sala.getID());
                            usuarioLogado.setSalasID(array_auxiliar);
                            //-----------ternina
                            sqLite.updateDataUsuario(usuarioLogado);
                            sqLite.deleteDataSala(sala);
                            finish();
                            extra = new Intent(UserRooms.this, RoomsMenu.class);
                            extra.putExtra("usuarioLogado", usuarioLogado);
                            startActivity(extra);
                        }
                    }
                }
                return true;
            default:
                return false;

        }


    }
    public static int[] achaElemento(int array_original[], int numero){
        int posicao = 0;
        boolean encontrou = false;
        for(int i = 0; i < array_original.length; i++){
            if(array_original[i] == numero){
                posicao = i;
                break;
            }
        }

        int array_novo[] = new int[array_original.length -1];
        for(int i = 0; i < array_novo.length; i++){
            if(i == posicao || encontrou == true) {
                array_novo[i] = array_original[i+1];
                encontrou = true;
            }
            else{
                array_novo[i] = array_original[i];
            }
        }

        return array_novo;
    }

}


package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.DialogFragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragment;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragmentUsuarios;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class RoomActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, NoticeDialogFragment.NoticeDialogListener, NoticeDialogFragmentUsuarios.NoticeDialogListenerUsuarios,
        NavigationView.OnNavigationItemSelectedListener{
    ActivityRoomBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado, usuarioOn;
    Sala salaUsada;
    Ficha fichaUsada;
    SalaModel salaModel;
    FichaModel fichaModel;
    ArrayList<FichaModel> fichaModelArrayList;
    FichaAdapter fichaAdapter;
    int[] fichasID, fichaSalaID;
    int posicaoDelete = 0;
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();
    AlertDialog dialog;
    boolean deletar = false, mestre;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout)findViewById(R.id.room_drawer_menu);
        toggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.common_open_on_phone, R.string.close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.design_navigation_view);

        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }


        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        mestre =  extra.getBooleanExtra("mestre", mestre);
        System.out.println("=================Mestre: " + mestre);
        sqLite = new SQLite(this);
        sqLite.atualizaDataFicha();
        sqLite.atualizaDataUsuario();
        sqLite.atualizaDataSala();

        binding.setItemSalaCompleta(new SalaModel(salaUsada));

        if(mestre != true){
            for(int i = 1; i < salaUsada.toIntArray(salaUsada.getJogadoresID()).length; i++){
                usuarioOn = sqLite.selecionarUsuario(salaUsada.toIntArray(salaUsada.getJogadoresID())[i]);
                if(usuarioLogado.getNick().equals(usuarioOn.getNick())){
                    deletar = true;
                }
            }
            if(deletar != true){
                int[] aux = new int[salaUsada.toIntArray(salaUsada.getJogadoresID()).length + 1];
                for (int i = 0; i < salaUsada.toIntArray(salaUsada.getJogadoresID()).length; i++){
                    aux[i] = salaUsada.toIntArray(salaUsada.getJogadoresID())[i];
                }
                //
                aux[salaUsada.toIntArray(salaUsada.getJogadoresID()).length] = usuarioLogado.getID();
                salaUsada.setJogadoresID(salaUsada.toIntList(aux));
                sqLite.updateDataSala(salaUsada);
            }
        }

        if(mestre == true){
            fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
            //sqLite.atualizaDataFicha(fichasID);
            fichaModel = new FichaModel();
            fichaModelArrayList = fichaModel.getArrayListaFicha(salaUsada.toIntArray(salaUsada.getFichasID()), sqLite);
            fichaAdapter = new FichaAdapter(this, fichaModelArrayList);
            binding.roomListViewFichas.setAdapter(fichaAdapter);
        }else{
            fichaSalaID = salaUsada.toIntArray(salaUsada.getFichasID());
            fichasID = usuarioLogado.toIntArray(usuarioLogado.getFichasID());
            int[] fichasNaSala = new int[usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length];
            for(int i = 0; i < usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length; i++){
                for(int j = 0; j < salaUsada.toIntArray(salaUsada.getFichasID()).length; j++){
                    if(fichaSalaID[j] == fichasID[i]){
                        fichasNaSala[i] = fichasID[i];
                    }
                }
            }
            //sqLite.atualizaDataFicha(fichasID);
            fichaModel = new FichaModel();
            fichaModelArrayList = fichaModel.getArrayListaFicha(fichasNaSala, sqLite);
            fichaAdapter = new FichaAdapter(this, fichaModelArrayList);
            binding.roomListViewFichas.setAdapter(fichaAdapter);
        }


        binding.roomListViewFichas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(mestre != true){
                    return true;
                }else{
                    PopupMenu menu = new PopupMenu(RoomActivity.this ,view);
                    menu.setOnMenuItemClickListener(RoomActivity.this);
                    menu.inflate(R.menu.menu_popup);
                    posicaoDelete = position;

                    menu.show();

                    return true;
                }
            }
        });

        binding.roomListViewFichas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int fichaPosicao = position;
                salaUsada.setHistoria(binding.roomEditTextResumo.getText().toString());
                salaUsada.setNotas(binding.roomEditTextOutrasAnotacoes.getText().toString());
                sqLite.updateDataSala(salaUsada);
                for(int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                    if(i == fichaPosicao){
                        if (fichasID[i+1] == 0){
                        }else{
                            // System.out.println("=================Entrou aqui, eu achei a sala!");
                            fichaUsada = sqLite.selecionarFicha(fichasID[i+1]);
                            extra = new Intent(RoomActivity.this, SheetActivity.class);
                            extra.putExtra("usuarioLogado", usuarioLogado);
                            extra.putExtra("salaUsada", salaUsada);
                            extra.putExtra("fichaUsada", fichaUsada);
                            extra.putExtra("mestre", mestre);
                            startActivity(extra);
                        }
                    }
                }
            }
        });

        binding.setAdicionaFicha(new Eventos() {
            @Override
            public void onClickCad() {
                if(mestre == true){
                    sqLite.insereDataFicha(new Ficha("Nova Ficha", "",
                            "", "", "", "", "", "",
                            0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, "", "", "", "",
                            "", "", "", "", "", "",
                            0, 0, 0, 0, "", "",
                            "", "","","", ""));

                    int[] aux = new int[salaUsada.toIntArray(salaUsada.getFichasID()).length +1];

                    for (int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                        aux[i] = salaUsada.toIntArray(salaUsada.getFichasID())[i];
                    }
                    aux[salaUsada.toIntArray(salaUsada.getFichasID()).length] = sqLite.ultimaFicha();

                    salaUsada.setFichasID(salaUsada.toIntList(aux));

                    sqLite.updateDataSala(salaUsada);

                    fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
                    fichaModel = new FichaModel();
                    fichaModelArrayList = fichaModel.getArrayListaFicha(salaUsada.toIntArray(salaUsada.getFichasID()), sqLite);
                    fichaAdapter = new FichaAdapter(RoomActivity.this, fichaModelArrayList);
                    binding.roomListViewFichas.setAdapter(fichaAdapter);
                }else{
                    sqLite.insereDataFicha(new Ficha("Nova Ficha", "",
                            "", "", "", "", "", "",
                            0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0,
                            0, 0, 0, 0, 0, 0, 0,
                            0, 0, 0, "", "", "", "",
                            "", "", "", "", "", "",
                            0, 0, 0, 0, "", "",
                            "", "","","", ""));

                    int[] aux = new int[usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length +1];
                    int[] aux2 = new int[salaUsada.toIntArray(salaUsada.getFichasID()).length +1];

                    for (int i = 0; i < usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length; i++){
                        aux[i] = usuarioLogado.toIntArray(usuarioLogado.getFichasID())[i];
                    }
                    for (int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                        aux2[i] = salaUsada.toIntArray(salaUsada.getFichasID())[i];
                    }

                    aux[usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length] = sqLite.ultimaFicha();
                    aux2[salaUsada.toIntArray(salaUsada.getFichasID()).length] = sqLite.ultimaFicha();

                    usuarioLogado.setFichasID(usuarioLogado.toIntList(aux));
                    salaUsada.setFichasID(salaUsada.toIntList(aux2));

                    sqLite.updateDataSala(salaUsada);
                    sqLite.updateDataUsuario(usuarioLogado);

                    fichaSalaID = salaUsada.toIntArray(salaUsada.getFichasID());
                    fichasID = usuarioLogado.toIntArray(usuarioLogado.getFichasID());
                    int[] fichasNaSala = new int[usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length];
                    for(int i = 0; i < usuarioLogado.toIntArray(usuarioLogado.getFichasID()).length; i++){
                        for(int j = 0; j < salaUsada.toIntArray(salaUsada.getFichasID()).length; j++){
                            if(fichaSalaID[j] == fichasID[i]){
                                fichasNaSala[i] = fichasID[i];
                            }
                        }
                    }
                    //sqLite.atualizaDataFicha(fichasID);
                    fichaModel = new FichaModel();
                    fichaModelArrayList = fichaModel.getArrayListaFicha(fichasNaSala, sqLite);
                    fichaAdapter = new FichaAdapter(RoomActivity.this, fichaModelArrayList);
                    binding.roomListViewFichas.setAdapter(fichaAdapter);
                }
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
                showNoticeDialogUsuarios();
                return true;
            case R.id.item_deleta:
                salaUsada.setHistoria(binding.roomEditTextResumo.getText().toString());
                salaUsada.setNotas(binding.roomEditTextOutrasAnotacoes.getText().toString());
                sqLite.updateDataSala(salaUsada);
                showNoticeDialog();
            default:
                return false;

        }


    }

    public void onBackPressed(){
        salaUsada.setHistoria(binding.roomEditTextResumo.getText().toString());
        salaUsada.setNotas(binding.roomEditTextOutrasAnotacoes.getText().toString());
        sqLite.updateDataSala(salaUsada);
        extra = new Intent(RoomActivity.this, RoomsMenu.class);
        extra.putExtra("usuarioLogado", usuarioLogado);
        startActivity(extra);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // dialog só é null antes de ser instanciado, apenas por garantia para não dar erros
        if(deletar == true){
            System.out.println("===========================Deletado!!!");
        }
    }

    public void showNoticeDialog() {
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragment();
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    public void showNoticeDialogUsuarios() {
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragmentUsuarios(usuarioLogado, salaUsada, fichaUsada, sqLite);
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
        for(int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
            if(i == posicaoDelete){
                if (fichasID[i+1] == 0){

                }else{
                    // System.out.println("=================Entrou aqui, eu achei a sala!");
                    Ficha ficha = sqLite.selecionarFicha(fichasID[i+1]);
                    //----------comeca
                    int array_auxiliar[] = salaUsada.toIntArray(salaUsada.getFichasID());
                    array_auxiliar = achaElemento(array_auxiliar, ficha.getId());
                    salaUsada.setFichasID(salaUsada.toIntList(array_auxiliar));
                    //-----------ternina
                    sqLite.updateDataSala(salaUsada);
                    sqLite.deleteDataFicha(ficha);
                    finish();
                    startActivity(getIntent());
                }
            }
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String senha) {
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
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


    @Override
    public void onDialogPositiveClickUsuarios(DialogFragment dialog, String nickUsuario) {
        fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
        for(int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
            if(i == posicaoDelete){
                if (fichasID[i+1] == 0){
                }else{
                    // System.out.println("=================Entrou aqui, eu achei a sala!");
                    Ficha ficha = sqLite.selecionarFicha(fichasID[i+1]);
                    usuarioOn = sqLite.selecionarUsuario(nickUsuario);

                    int[] aux = new int[usuarioOn.toIntArray(usuarioOn.getFichasID()).length + 1];
                    // System.out.println(Arrays.toString(usuarioLogado.toIntArray(usuarioLogado.getSalasID())));

                    for (int j = 0; j < usuarioOn.toIntArray(usuarioOn.getFichasID()).length; j++) {
                        aux[j] = usuarioOn.toIntArray(usuarioOn.getFichasID())[j];
                    }
                    aux[usuarioOn.toIntArray(usuarioOn.getFichasID()).length] = ficha.getId();
                    // System.out.println(Arrays.toString(aux));
                    usuarioOn.setFichasID((usuarioOn.toIntList(aux)));

                    sqLite.updateDataUsuario(usuarioOn);
                    dialog.dismiss();
                }
            }
        }

    }

    @Override
    public void onDialogNegativeClickUsuarios(DialogFragment dialog) {
        dialog.dismiss();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_navigationDrawer_item_listaDeSalas:
                extra = new Intent(RoomActivity.this, RoomsMenu.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                //extra.putExtra("salaUsada", salaUsada);
                //extra.putExtra("fichaUsada", fichaUsada);
                //extra.putExtra("mestre", mestre);
                startActivity(extra);
                return true;
            case R.id.menu_navigationDrawer_item_sairDaConta:
                extra = new Intent(RoomActivity.this, MainActivity.class);
                startActivity(extra);
                return true;
        }

        return true;
    }
}
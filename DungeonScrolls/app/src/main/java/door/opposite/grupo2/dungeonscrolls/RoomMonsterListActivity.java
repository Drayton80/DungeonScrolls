package door.opposite.grupo2.dungeonscrolls;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.Telas.RoomActivity;
import door.opposite.grupo2.dungeonscrolls.Telas.RoomsMenu;
import door.opposite.grupo2.dungeonscrolls.Telas.SheetActivity;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomMonsterlistBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragment;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragmentFichas;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class RoomMonsterListActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, NoticeDialogFragment.NoticeDialogListener, NoticeDialogFragmentFichas.NoticeDialogListenerFichas{
    ActivityRoomMonsterlistBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado, usuarioOn;
    Sala salaUsada;
    Ficha fichaUsada, fichaMonster;
    SalaModel salaModel;
    FichaModel fichaModel;
    ArrayList<FichaModel> fichaModelArrayList;
    FichaAdapter fichaAdapter;
    int[] fichasID, fichaSalaID, fichasMonsterID;
    int posicaoDelete = 0;
    DialogFragmentCreator geraDialog = new DialogFragmentCreator();
    AlertDialog dialog;
    boolean deletar = false, mestre, lock = false;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    DocumentReference docRef = FirebaseFirestore.getInstance().document("Data/App");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_monsterlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        /*
        // Área do Navigation Drawer
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
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.design_navigation_view_2);


        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }
        */

        // Pegando os dados que foram passados na Intent
        extra = getIntent();
        Usuario test = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        mestre =  extra.getBooleanExtra("mestre", mestre);

        // Criando Objeto da Classe SQLite
        sqLite = new SQLite(this);

        // Traz as coisas do servidor
        sqLite.atualizaDataFicha(this);
        sqLite.atualizaDataUsuario(this);
        sqLite.verSeDeletouFicha(this);
        //atualizaDataFicha(this);

        // Pega o usuário logado
        usuarioLogado = sqLite.selecionarUsuario(test.getID());

        binding.setItemSalaCompleta(new SalaModel(salaUsada));

        // Checa se o usuário é mestre, ou seja, tem as permissões necessárias dentro do escopo daquela sala
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
            System.out.println("-----------------------Eu sou mestre =D, é true == " + mestre);
            int[] fichasMonstersID = removePlayers();
            //sqLite.atualizaDataFicha(fichasID);
            fichaModel = new FichaModel();
            try {
                fichaModelArrayList = fichaModel.getArrayListaFicha(fichasMonstersID, sqLite);
                fichaAdapter = new FichaAdapter(this, fichaModelArrayList);
                binding.monsterListListView.setAdapter(fichaAdapter);
            }catch (Exception e){

            }
        }

        binding.setAdicionaFicha(new Eventos() {
            @Override
            public void onClickCad() {
                showNoticeDialogFichas();
            }

            @Override
            public void onClickLogin() {

            }
        });

        binding.monsterListListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int fichaPosicao = position;
                int[] fichasMonstersID = removePlayers();
                //sqLite.updateDataSala(salaUsada);
                for(int i = 0; i < fichasMonstersID.length; i++){
                    if(i == fichaPosicao){
                        if (fichasMonstersID[i] == 0){
                        }else{
                            fichaUsada = sqLite.selecionarFicha(fichasMonstersID[i]);
                            extra = new Intent(RoomMonsterListActivity.this, SheetActivity.class);
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

        binding.monsterListListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(mestre != true){
                    return false;
                }else{
                    PopupMenu menu = new PopupMenu(RoomMonsterListActivity.this ,view);
                    menu.setOnMenuItemClickListener(RoomMonsterListActivity.this);
                    menu.inflate(R.menu.menu_popup);
                    posicaoDelete = position;
                    menu.show();
                    return true;
                }
            }
        });
    }

    public boolean atualizaDataFicha(Activity activity) {
        docRef.collection("salas").addSnapshotListener(activity, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                    System.out.println("-----------------------Eu sou mestre =D, é true == " + mestre);
                    int[] fichasMonstersID = removePlayers();
                    //sqLite.atualizaDataFicha(fichasID);
                    fichaModel = new FichaModel();
                    try {
                        fichaModelArrayList = fichaModel.getArrayListaFicha(fichasMonstersID, sqLite);
                        fichaAdapter = new FichaAdapter(RoomMonsterListActivity.this, fichaModelArrayList);
                        binding.monsterListListView.setAdapter(fichaAdapter);
                    }catch (Exception ee){

                    }
                /*
                for (DocumentSnapshot doc : documentSnapshots) {
                    Sala sala = doc.toObject(Sala.class);
                    if(sala.getID() == salaUsada.getID()) {
                        salaUsada = sala;
                        //fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
                        fichaModelArrayList = fichaModel.getArrayListaFicha(fichaAtt, sqLite);
                        fichaAdapter = new FichaAdapter(RoomActivity.this, fichaModelArrayList);
                        binding.roomListViewFichas.setAdapter(fichaAdapter);
                    }

                }
                */
            }
        });
        return true;
    }

    public void showNoticeDialog() {
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragment();
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    public void showNoticeDialogFichas(){
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragmentFichas(usuarioLogado, salaUsada, fichaUsada, mestre, sqLite);
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    // onMenuItemClick é chamado toda vez que, ao pressionar por muito tempo uma ficha, um item do menu que aparece
    // é pressionado
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            // Caso o item seja Vincular:
            case R.id.item_vincular:
                return true;
            // Caso o item seja Deletar:
            case R.id.item_deleta:
                sqLite.updateDataSala(salaUsada);
                showNoticeDialog();
            default:
                return false;
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String senha) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogPositiveClickUsuarios(DialogFragment dialog, String nomeUsuario) {

    }

    @Override
    public void onDialogNegativeClickUsuarios(DialogFragment dialog) {

    }

    public int[] removePlayers(){
        fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
        fichasMonsterID = new int[fichasID.length];
        int monsterCont = 0;
        for(int cont = 0; cont < salaUsada.toIntArray(salaUsada.getFichasID()).length-1; cont++){
            if (fichasID[cont+1] == 0){
            }else {
                fichaMonster = sqLite.selecionarFicha(fichasID[cont + 1]);
                if (fichaMonster.getXpNecessario() == 2) {
                    System.out.println("---------------Monstro: " + fichaMonster.getXpNecessario());
                    fichasMonsterID[monsterCont] = fichaMonster.getId();
                    monsterCont++;
                }
            }
        }
        return fichasMonsterID;
    }

    public void onBackPressed(){
        //sqLite.updateDataSala(salaUsada);
        extra = new Intent(RoomMonsterListActivity.this, RoomActivity.class);
        extra.putExtra("usuarioLogado", usuarioLogado);
        extra.putExtra("salaUsada", salaUsada);
        extra.putExtra("fichaUsada", fichaUsada);
        extra.putExtra("mestre", mestre);
        startActivity(extra);
    }
}

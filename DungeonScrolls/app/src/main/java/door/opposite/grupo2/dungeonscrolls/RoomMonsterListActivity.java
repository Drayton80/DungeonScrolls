package door.opposite.grupo2.dungeonscrolls;

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
import android.widget.PopupMenu;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

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
            //sqLite.atualizaDataFicha(fichasID);
            fichaModel = new FichaModel();
            try {
                fichaModelArrayList = fichaModel.getArrayListaFicha(fichasMonsterID, sqLite);
                fichaAdapter = new FichaAdapter(this, fichaModelArrayList);
                binding.monsterListListView.setAdapter(fichaAdapter);
            }catch (Exception e){

            }
        }else if(mestre == false){
            System.out.println("-----------------------Não sou o mestre :c, é false == " + mestre);
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
            binding.monsterListListView.setAdapter(fichaAdapter);
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
    }

    public void showNoticeDialogFichas(){
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragmentFichas(usuarioLogado, salaUsada, fichaUsada, mestre, sqLite);
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
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
}

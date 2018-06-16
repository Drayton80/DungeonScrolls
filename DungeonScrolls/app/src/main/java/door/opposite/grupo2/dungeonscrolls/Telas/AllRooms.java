package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityAllRoomsBinding;
import door.opposite.grupo2.dungeonscrolls.graficAssets.DialogFragmentCreator;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragment;
import door.opposite.grupo2.dungeonscrolls.graficAssets.NoticeDialogFragmentID;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class AllRooms extends AppCompatActivity implements NoticeDialogFragmentID.NoticeDialogListenerID{
    // Atributos relativos à parte visual do programa:
    // Atributos relativos à parte visual do programa:
    AlertDialog dialog;     // Um referenciador para Dialog Fragments, é possível fechar ou mostrar dialogs com ele
    DialogFragmentCreator geradorDialog = new DialogFragmentCreator();  // Cria um manipulador de Dialog Fragments, objeto da classe DialogFragmentCreator
    // Atributos relativos ao binding:
    ActivityAllRoomsBinding binding;
    SQLite sqLite;
    Intent extra;
    Usuario usuarioLogado;
    SalaModel salaModel, salaModelSelecionada;
    ArrayList<SalaModel> salaModelArrayList;
    List<Sala> salas;
    DatabaseReference reference;
    FirebaseDatabase database;
    SalaAdapter salaAdapter;
    int[] salasID;
    List<Sala> allSalasID;
    Sala salaUsada, salaSelecionada;
    String novoJogador;
    Boolean salaUsuario = false, mestre = false, continuar = false;
    DocumentReference docRef = FirebaseFirestore.getInstance().document("Data/App");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cria uma View que referencia o layout dialogfragment_loadingcircle
        View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
        // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
        // referência para um AlertDialog chamado dialog
        dialog = geradorDialog.criaDialogFragmentLoadingCircle(this, loadingCircleDialog);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_rooms);
        sqLite = new SQLite(this);
        sqLite.atualizaDataFicha();
        sqLite.atualizaDataUsuario();
        sqLite.atualizaDataSala();
        sqLite.verSeDeletouSala();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        novoJogador = usuarioLogado.getNick();

        allSalasID = sqLite.listaSala();

        salasID = usuarioLogado.toIntArray(usuarioLogado.getSalasID());
        salaModel = new SalaModel();

        salas = sqLite.listaSala();
        salaModelArrayList = salaModel.getArrayListSala(salas, sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvRooms.setAdapter(salaAdapter);

        atualizaDataSala();



        binding.lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
                // referência para um AlertDialog chamado dialog
                dialog = geradorDialog.criaDialogFragmentLoadingCircle(AllRooms.this, loadingCircleDialog);
                int salaPosicao = position;
                int i = 0;
                try {
                    salaModelSelecionada = salaModelArrayList.get(salaPosicao);
                }catch (Exception e){}
                for (i = 0; i < salasID.length; i++) {
                    try {
                        if (salasID[i + 1] == 0) {
                        }else{
                            salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                            if (salaUsada.getNomeMestre().equals(salaModelSelecionada.getNomeMestre())) {
                                mestre = true;

                                salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                                extra = new Intent(AllRooms.this, RoomActivity.class);
                                extra.putExtra("usuarioLogado", usuarioLogado);
                                extra.putExtra("salaUsada", salaUsada);
                                extra.putExtra("mestre", mestre);
                                salaUsuario = true;
                                startActivity(extra);
                            }
                        }
                    }catch(Exception e){}
                }
                if(salaUsuario == false){
                    if(salaModelSelecionada.getSenha().length() == 1){


                        salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
                        extra = new Intent(AllRooms.this, RoomActivity.class);
                        extra.putExtra("usuarioLogado", usuarioLogado);
                        extra.putExtra("salaUsada", salaUsada);
                        salaUsuario = true;
                        startActivity(extra);
                    }else{
                        showNoticeDialog();
                    }
                }
            }
        });

        // Usa um dos métodos de DialogFragmentCreator para fechar o loading dialog, passando como parâmetro a referência para
        // o próprio dialog retornado na criação com criaDialogFragmentLoadingCircle
        geradorDialog.fechaDialogFragment(dialog);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        sqLite = new SQLite(this);
        sqLite.atualizaDataFicha();
        sqLite.atualizaDataUsuario();
        sqLite.atualizaDataSala();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        novoJogador = usuarioLogado.getNick();

        allSalasID = sqLite.listaSala();

        salasID = usuarioLogado.toIntArray(usuarioLogado.getSalasID());
        salaModel = new SalaModel();

        salas = sqLite.listaSala();
        salaModelArrayList = salaModel.getArrayListSala(salas, sqLite);
        salaAdapter = new SalaAdapter(this, salaModelArrayList);
        binding.lvRooms.setAdapter(salaAdapter);

        atualizaDataSala();



        binding.lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                View loadingCircleDialog = getLayoutInflater().inflate(R.layout.dialogfragment_loadingcircle, null);
                // Usa um dos métodos de DialogFragmentCreator para criar um dialog fragment do loading dialog e ao mesmo tempo passar sua
                // referência para um AlertDialog chamado dialog
                dialog = geradorDialog.criaDialogFragmentLoadingCircle(AllRooms.this, loadingCircleDialog);
                int salaPosicao = position;
                int i = 0;
                try {
                    salaModelSelecionada = salaModelArrayList.get(salaPosicao);
                }catch (Exception e){}
                for (i = 0; i < salasID.length; i++) {
                    try {
                        if (salasID[i + 1] == 0) {
                        }else{
                            salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                            if (salaUsada.getNomeMestre().equals(salaModelSelecionada.getNomeMestre())) {
                                mestre = true;

                                salaUsada = sqLite.selecionarSala(salasID[i + 1]);
                                extra = new Intent(AllRooms.this, RoomActivity.class);
                                extra.putExtra("usuarioLogado", usuarioLogado);
                                extra.putExtra("salaUsada", salaUsada);
                                extra.putExtra("mestre", mestre);
                                salaUsuario = true;
                                startActivity(extra);
                            }
                        }
                    }catch(Exception e){}
                }
                if(salaUsuario == false){
                    if(salaModelSelecionada.getSenha().length() == 1){


                        salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
                        extra = new Intent(AllRooms.this, RoomActivity.class);
                        extra.putExtra("usuarioLogado", usuarioLogado);
                        extra.putExtra("salaUsada", salaUsada);
                        salaUsuario = true;
                        startActivity(extra);
                    }else{
                        showNoticeDialog();
                    }
                }
            }
        });
    }

    public void showNoticeDialog() {
        // Cria uma instância para o Notice Dialog Fragment
        DialogFragment dialog = new NoticeDialogFragmentID();
        dialog.show(getFragmentManager(), "NoticeDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String senha) {
        if(salaModelSelecionada.getSenha().equals(senha)){
            mestre = false;
            salaUsada = sqLite.selecionarSala(salaModelSelecionada.getNome());
            extra = new Intent(AllRooms.this, RoomActivity.class);
            extra.putExtra("usuarioLogado", usuarioLogado);
            extra.putExtra("salaUsada", salaUsada);
            extra.putExtra("mestre", mestre);
            startActivity(extra);
        }else{
            Toast.makeText(AllRooms.this, "Senha incorreta", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        }
    }


    public boolean atualizaDataSala(){



        docRef.collection("salas").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                salas.clear();
                for (DocumentSnapshot doc: documentSnapshots){
                    Sala sala = doc.toObject(Sala.class);

                    salas.add(sala);
                    salaModelArrayList = salaModel.getArrayListSala(salas, sqLite);
                    salaAdapter = new SalaAdapter(AllRooms.this, salaModelArrayList);
                    binding.lvRooms.setAdapter(salaAdapter);
                }
            }
        });
/*
        reference.child("sala").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                salas.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Sala sala = new Sala();
                    GenericTypeIndicator<ArrayList<Integer>> t = new GenericTypeIndicator<ArrayList<Integer>>(){};
                    sala.setID(snapshot.child("id").getValue(int.class));
                    sala.setMestre(snapshot.child("mestre").getValue(int.class));
                    sala.setNome(snapshot.child("nome").getValue(String.class));
                    sala.setSenha(snapshot.child("senha").getValue(String.class));
                    sala.setHistoria(snapshot.child("historia").getValue(String.class));
                    sala.setJogadoresID(snapshot.child("jogadoresID").getValue(t));
                    sala.setFichasID(snapshot.child("fichasID").getValue(t));
                    sala.setNomeMestre(snapshot.child("nomeMestre").getValue(String.class));
                    sala.setNotas(snapshot.child("notas").getValue(String.class));
                    sala.setUri(snapshot.child("uri").getValue(String.class));
                    salas.add(sala);
                    salaModelArrayList = salaModel.getArrayListSala(salas, sqLite);
                    salaAdapter = new SalaAdapter(AllRooms.this, salaModelArrayList);
                    binding.lvRooms.setAdapter(salaAdapter);
                    boolean existe = sqLite.verSeTemEsseSala(sala.getID());
                    if (existe == true){
                        sqLite.updateDataSala(sala);
                    }
                    else{
                        sqLite.insereDataSala(sala);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        return true;
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }

    public void onBackPressed(){
        onRestart();
    }

    @Override
    public void onPause() {
        super.onPause();
        continuar = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        // dialog só é null antes de ser instanciado, apenas por garantia para não dar erros
        if(dialog != null){
            // Usado para fechar o Dialog Fragment do Loading Magic Circle, é chamado no onStop() pois ele apenas ocorre quando outra activity é chamada
            // e essa sai de visualização, logo após não estar mais visível.
            geradorDialog.fechaDialogFragment(dialog);
        }
    }
}
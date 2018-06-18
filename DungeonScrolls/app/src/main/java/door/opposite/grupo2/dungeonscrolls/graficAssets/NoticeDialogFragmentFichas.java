package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.BeforeSheetMonsterAutomaticallyActivity;
import door.opposite.grupo2.dungeonscrolls.BeforeSheetMonsterCreatedActivity;
import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.RoomMonsterListActivity;
import door.opposite.grupo2.dungeonscrolls.Telas.RoomActivity;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.JogadoresAdapter;
import door.opposite.grupo2.dungeonscrolls.commands.EventosEscolhaFichas;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

import static android.databinding.DataBindingUtil.setContentView;

/**
 * Created by ci on 17/04/18.
 */

@SuppressLint("ValidFragment")
public class NoticeDialogFragmentFichas extends DialogFragment {

    Usuario usuarioUsado, usuarioOn;
    Sala salaUsada;
    Ficha fichaUsada;
    FichaModel fichaModel;
    ArrayList<FichaModel> fichaModelArrayList;
    FichaAdapter fichaAdapter;
    Boolean lock = false, mestre;
    SQLite sqLite;
    ArrayList<String> jogadores;
    int[] fichasID, fichaSalaID;
    Button monstro;
    Button automatico;
    Button fichaVazia;
    Intent extra;
    int[] jogadoresID;
    private ListView jogadoresNaSala;
    ArrayList<UsuarioModel> usuarioModelArrayList;
    JogadoresAdapter usuariosAdapter;


    public NoticeDialogFragmentFichas(Usuario usuarioLogado, Sala salaUsada, Ficha fichaUsada, boolean mestre, SQLite sqLite) {
        this.usuarioUsado = usuarioLogado;
        this.salaUsada = salaUsada;
        this.fichaUsada = fichaUsada;
        this.mestre = mestre;
        this.sqLite = sqLite;
    }

    /* A Activity cria uma instância para o dialog fragmentThe activity that creates an instance of this dialog fragment must
     * e ela implementa essa interface para receber os "callbacks"
     * esse método é passado para o DialogFragment */
    public interface NoticeDialogListenerFichas {
        public void onDialogPositiveClickUsuarios(DialogFragment dialog, String nomeUsuario);
        public void onDialogNegativeClickUsuarios(DialogFragment dialog);
    }

    // Use essa instância da interface para enviar os eventos
    NoticeDialogFragmentFichas.NoticeDialogListenerFichas mensagem;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verifica se a Activity Host está implementando a interface de "Callback"
        try {
            mensagem = (NoticeDialogFragmentFichas.NoticeDialogListenerFichas) activity;
        } catch (ClassCastException e) {
            System.out.println("Implements NoticeDialogFragment nessa interface: " + getActivity().toString());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View fichaDialog = getActivity().getLayoutInflater().inflate(R.layout.dialogfragment_newmonstersheet_choices, null);

        monstro = (Button) fichaDialog.findViewById(R.id.monsterSheetChoice_button_monstroPronto);
        automatico = (Button) fichaDialog.findViewById(R.id.monsterSheetChoice_button_monstroAutomatico);
        fichaVazia = (Button) fichaDialog.findViewById(R.id.monsterSheetChoice_button_monstroNovo);

        monstro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                extra = new Intent(getActivity(), BeforeSheetMonsterCreatedActivity.class);
                extra.putExtra("usuarioLogado", usuarioUsado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                extra.putExtra("mestre", mestre);
                startActivity(extra);
            }
        });

        automatico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                extra = new Intent(getActivity(), BeforeSheetMonsterAutomaticallyActivity.class);
                extra.putExtra("usuarioLogado", usuarioUsado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                extra.putExtra("mestre", mestre);
                startActivity(extra);
            }
        });

        fichaVazia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                extra = new Intent(getActivity(), RoomMonsterListActivity.class);
                if(lock != true){
                    lock = true;
                    if(mestre == true){
                        sqLite.insereDataFicha(new Ficha("Novo Monstro", "",
                                "", "", "", "", "", "",
                                0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0,
                                0, 0, 2, "", "", "", "",
                                "", "", "", "", "", "",
                                0, 0, 0, 0, "", "",
                                "", "","","", "",
                                "", "", "", "", "", "", "",
                                0, 0, 0));

                        int[] aux = new int[salaUsada.toIntArray(salaUsada.getFichasID()).length +1];

                        for (int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                            aux[i] = salaUsada.toIntArray(salaUsada.getFichasID())[i];
                        }
                        aux[salaUsada.toIntArray(salaUsada.getFichasID()).length] = sqLite.ultimaFicha();

                        salaUsada.setFichasID(salaUsada.toIntList(aux));

                        sqLite.updateDataSala(salaUsada);

                        fichasID = salaUsada.toIntArray(salaUsada.getFichasID());
                        lock = false;
                        //getActivity().closeContextMenu();
                        //startActivity(getActivity().getIntent());
                        dismiss();
                        extra.putExtra("usuarioLogado", usuarioUsado);
                        extra.putExtra("salaUsada", salaUsada);
                        extra.putExtra("fichaUsada", fichaUsada);
                        extra.putExtra("mestre", mestre);
                        getActivity().finish();
                        startActivity(extra);
                    }else{
                        sqLite.insereDataFicha(new Ficha("Novo Monstro", "",
                                "", "", "", "", "", "",
                                0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0,
                                0, 0, 2, "", "", "", "",
                                "", "", "", "", "", "",
                                0, 0, 0, 0, "", "",
                                "", "","","", "",
                                "", "", "", "", "", "", "",
                                0, 0, 0));

                        int[] aux = new int[usuarioUsado.toIntArray(usuarioUsado.getFichasID()).length +1];
                        int[] aux2 = new int[salaUsada.toIntArray(salaUsada.getFichasID()).length +1];

                        for (int i = 0; i < usuarioUsado.toIntArray(usuarioUsado.getFichasID()).length; i++){
                            aux[i] = usuarioUsado.toIntArray(usuarioUsado.getFichasID())[i];
                        }
                        for (int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                            aux2[i] = salaUsada.toIntArray(salaUsada.getFichasID())[i];
                        }

                        aux[usuarioUsado.toIntArray(usuarioUsado.getFichasID()).length] = sqLite.ultimaFicha();
                        aux2[salaUsada.toIntArray(salaUsada.getFichasID()).length] = sqLite.ultimaFicha();

                        usuarioUsado.setFichasID(usuarioUsado.toIntList(aux));
                        salaUsada.setFichasID(salaUsada.toIntList(aux2));

                        sqLite.updateDataSala(salaUsada);
                        sqLite.updateDataUsuario(usuarioUsado);

                        fichaSalaID = salaUsada.toIntArray(salaUsada.getFichasID());
                        fichasID = usuarioUsado.toIntArray(usuarioUsado.getFichasID());
                        int[] fichasNaSala = new int[usuarioUsado.toIntArray(usuarioUsado.getFichasID()).length];
                        for(int i = 0; i < usuarioUsado.toIntArray(usuarioUsado.getFichasID()).length; i++){
                            for(int j = 0; j < salaUsada.toIntArray(salaUsada.getFichasID()).length; j++){
                                if(fichaSalaID[j] == fichasID[i]){
                                    fichasNaSala[i] = fichasID[i];
                                }
                            }
                        }
                        //sqLite.atualizaDataFicha(fichasID);
                        lock = false;
                        dismiss();
                        extra.putExtra("usuarioLogado", usuarioUsado);
                        extra.putExtra("salaUsada", salaUsada);
                        extra.putExtra("fichaUsada", fichaUsada);
                        extra.putExtra("mestre", mestre);
                        startActivity(extra);
                    }
                }
            }
        });

        //jogadoresNaSala = (ListView) usersDialog.findViewById(R.id.dialogFragmentListaJogadores_listView_jogadores);

        //jogadores = new ArrayList<>();
        //jogadoresID = new int[salaUsada.toIntArray(salaUsada.getJogadoresID()).length];
    /*
        for (int i = 0; i < salaUsada.toIntArray(salaUsada.getJogadoresID()).length; i++){
            jogadoresID[i] = salaUsada.toIntArray(salaUsada.getJogadoresID())[i];
        }

        for(int i = 0; i < salaUsada.toIntArray(salaUsada.getJogadoresID()).length; i++){
            if(jogadoresID[i] == 0){
            }else{
                usuarioOn = sqLite.selecionarUsuario(jogadoresID[i]);
                jogadores.add(usuarioOn.getNick());
            }
        }

*/
        //jogadoresID = salaUsada.toIntArray(salaUsada.getFichasID());
        //UsuarioModel usuarioModel = new UsuarioModel();
        //usuarioModelArrayList = usuarioModel.getArrayListaUsuario(salaUsada.toIntArray(salaUsada.getJogadoresID()), sqLite);
        //usuariosAdapter = new JogadoresAdapter(usersDialog.getContext(), usuarioModelArrayList);
        //jogadoresNaSala.setAdapter(usuariosAdapter);
/*
        jogadoresNaSala.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mensagem.onDialogPositiveClickUsuarios(NoticeDialogFragmentFichas.this, jogadores.get(position));
            }
        });

        builder.setMessage("Escolha um Jogador:")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click positivo de volta a Activity Host
                        mensagem.onDialogNegativeClickUsuarios(NoticeDialogFragmentFichas.this);
                    }
                });
*/
        builder.setView(fichaDialog);

        AlertDialog dialog = builder.create();

        dialog.setCanceledOnTouchOutside(false);

        return builder.create();
    }
}


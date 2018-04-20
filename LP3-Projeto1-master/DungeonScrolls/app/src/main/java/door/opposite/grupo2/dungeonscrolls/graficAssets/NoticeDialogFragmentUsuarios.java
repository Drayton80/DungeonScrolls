package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.JogadoresAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.DialogfragmentRoomListajogadoresBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

/**
 * Created by ci on 17/04/18.
 */

@SuppressLint("ValidFragment")
public class NoticeDialogFragmentUsuarios extends DialogFragment {

    Usuario usuarioUsado, usuarioOn;
    Sala salaUsada;
    Ficha fichaUsada;
    SQLite sqLite;
    ArrayAdapter<String> jogadoresOn;
    ArrayList<String> jogadores;
    int[] jogadoresID;
    private ListView jogadoresNaSala;
    ArrayList<UsuarioModel> usuarioModelArrayList;
    JogadoresAdapter usuariosAdapter;
    DialogfragmentRoomListajogadoresBinding binding;


    public NoticeDialogFragmentUsuarios(Usuario usuarioLogado, Sala salaUsada, Ficha fichaUsada, SQLite sqLite) {
        this.usuarioUsado = usuarioLogado;
        this.salaUsada = salaUsada;
        this.fichaUsada = fichaUsada;
        this.sqLite = sqLite;
    }

    /* A Activity cria uma instância para o dialog fragmentThe activity that creates an instance of this dialog fragment must
         * e ela implementa essa interface para receber os "callbacks"
         * esse método é passado para o DialogFragment */
    public interface NoticeDialogListenerUsuarios {
        public void onDialogPositiveClickUsuarios(DialogFragment dialog, String nomeUsuario);
        public void onDialogNegativeClickUsuarios(DialogFragment dialog);
    }

    // Use essa instância da interface para enviar os eventos
    NoticeDialogFragmentUsuarios.NoticeDialogListenerUsuarios mensagem;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verifica se a Activity Host está implementando a interface de "Callback"
        try {
            mensagem = (NoticeDialogFragmentUsuarios.NoticeDialogListenerUsuarios) activity;
        } catch (ClassCastException e) {
            System.out.println("Implements NoticeDialogFragment nessa interface: " + getActivity().toString());
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View usersDialog = getActivity().getLayoutInflater().inflate(R.layout.dialogfragment_room_listajogadores, null);

        jogadoresNaSala = (ListView) usersDialog.findViewById(R.id.dialogFragmentListaJogadores_listView_jogadores);

        jogadores = new ArrayList<>();
        jogadoresID = new int[salaUsada.toIntArray(salaUsada.getJogadoresID()).length];

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


        jogadoresID = salaUsada.toIntArray(salaUsada.getFichasID());
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModelArrayList = usuarioModel.getArrayListaUsuario(salaUsada.toIntArray(salaUsada.getJogadoresID()), sqLite);
        usuariosAdapter = new JogadoresAdapter(usersDialog.getContext(), usuarioModelArrayList);
        jogadoresNaSala.setAdapter(usuariosAdapter);

        jogadoresNaSala.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mensagem.onDialogPositiveClickUsuarios(NoticeDialogFragmentUsuarios.this, jogadores.get(position));
            }
        });

        builder.setMessage("Escolha um Jogador:")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click positivo de volta a Activity Host
                        mensagem.onDialogNegativeClickUsuarios(NoticeDialogFragmentUsuarios.this);
                    }
                });

        builder.setView(usersDialog);

        AlertDialog dialog = builder.create();

        dialog.setCanceledOnTouchOutside(false);

        return builder.create();
    }
}


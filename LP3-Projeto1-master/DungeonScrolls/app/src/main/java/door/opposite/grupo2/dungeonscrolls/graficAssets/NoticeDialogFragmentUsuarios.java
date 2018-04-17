package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.adapter.FichaAdapter;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

/**
 * Created by ci on 17/04/18.
 */

public class NoticeDialogFragmentUsuarios extends DialogFragment {

    /* A Activity cria uma instância para o dialog fragmentThe activity that creates an instance of this dialog fragment must
     * e ela implementa essa interface para receber os "callbacks"
     * esse método é passado para o DialogFragment */
    public interface NoticeDialogListenerUsuarios {
        public void onDialogPositiveClickUsuarios(DialogFragment dialog);
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

        builder.setView(usersDialog);
        
        AlertDialog dialog = builder.create();
        
        dialog.setCanceledOnTouchOutside(false);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        builder.setMessage("Escolha um usuário:")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click positivo de volta a Activity Host
                        mensagem.onDialogPositiveClickUsuarios(NoticeDialogFragmentUsuarios.this);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click negativo de volta a Activity Host
                        mensagem.onDialogNegativeClickUsuarios(NoticeDialogFragmentUsuarios.this);
                    }
                });
        return builder.create();
    }
}


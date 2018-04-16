package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.TextView;

public class NoticeDialogFragmentID extends DialogFragment {

    /* A Activity cria uma instância para o dialog fragmentThe activity that creates an instance of this dialog fragment must
     * e ela implementa essa interface para receber os "callbacks"
     * esse método é passado para o DialogFragment */
    public interface NoticeDialogListenerID {
        public void onDialogPositiveClick(DialogFragment dialog, String s);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use essa instância da interface para enviar os eventos
    NoticeDialogListenerID mensagem;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verifica se a Activity Host está implementando a interface de "Callback"
        try {
            mensagem = (NoticeDialogListenerID) activity;
        } catch (ClassCastException e) {
            System.out.println("Implements NoticeDialogFragment nessa interface: " + getActivity().toString());
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final EditText input = new EditText (getActivity());
        final EditText input2 = new EditText (getActivity());
        input.setHint("Senha");
        input.setTransformationMethod(PasswordTransformationMethod.getInstance());
        builder.setView(input);

        builder.setMessage("Digite a senha:")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click positivo de volta a Activity Host
                        System.out.println("==========Senha: " + input.getText().toString());
                            if(input.getText() != null){
                                mensagem.onDialogPositiveClick(NoticeDialogFragmentID.this, input.getText().toString());
                            }else{
                                mensagem.onDialogPositiveClick(NoticeDialogFragmentID.this, " ");
                            }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click negativo de volta a Activity Host
                        mensagem.onDialogNegativeClick(NoticeDialogFragmentID.this);
                    }
                });
        return builder.create();
    }
}

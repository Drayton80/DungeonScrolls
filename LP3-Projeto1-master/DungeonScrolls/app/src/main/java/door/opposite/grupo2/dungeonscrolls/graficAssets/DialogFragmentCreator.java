package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 *  Essa classe serve para gerar Dialog Fragments com facilidade apenas passando o contexto da view Java pertencente a classe aonde será gerado
 */


public class DialogFragmentCreator {
    Context contextoGeral;

    /** Descrição: esse método gera um Dialog Fragment relativo ao Loading
     *  Parâmetros:
     *      Context contexto - Contexto da classe Java relativa a View em que será exibida o Dialog Fragment
     *      View dialogView  - View a qual possuí a referência para o Dialog Fragment, que nesse caso é o dialogfragment_loadingcircle
     *
     * @param contexto
     * @param dialogView
     */
    public void criaFragmentDialogLoadingCircle(Context contexto, View dialogView){
        // Cria um Builder para poder manipular o Dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(contexto);
        // Serve para referenciar a tela (layout) ao qual o Dialog Fragment será exibido em forma de pop-up
        dialogBuilder.setView(dialogView);

        // Cria efetivamente o dialog
        AlertDialog dialog = dialogBuilder.create();
        // Definindo a cor do fundo do Dialog Fragment para transparente:
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // Exibe o dialog
        dialog.show();
    }
}
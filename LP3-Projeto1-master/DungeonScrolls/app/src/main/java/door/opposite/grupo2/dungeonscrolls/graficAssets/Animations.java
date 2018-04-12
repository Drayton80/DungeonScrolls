package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import door.opposite.grupo2.dungeonscrolls.R;

/**
 * Classe que possuí todas as animações do programa: sua criação, inicio e parada.
 *
 * Created by drayton on 11/04/18.
 */

public class Animations {
    AnimationDrawable loadingAnimation;

    /** Animação Circular Loading referente ao carregamento de telas, sendo ela no formato de um Círculo Mágico que constantemente pulsa do
     *  transparente para o preto e vice-versa
     *      Parâmetros de Entrada:
     *          View dialogFragmentLoadingCircle: Como o Widget do Image View está presente apenas na dialogfragment_loadingcircle é necessário
     *           receber a View que referência esse layout
     */
    public void loadingMagicCircle(View dialogFragmentLoadingCircle){
        // Pega a referência para o ID do ImageView que está no dialog_fragment_magigcircle e cria
        // um objeto dessa classe no Java
        ImageView loadingCircleImage = (ImageView) dialogFragmentLoadingCircle.findViewById(R.id.dialogFragmentLoading_imageView_loadingCircle);
        // Define o recurso da imagem como o arquivo .xml referente a animação
        loadingCircleImage.setImageResource(R.drawable.loading_magic_circle);

        // Instancia o objeto da classe AnimationDrawable que servirá para pdoer manipular o inicio e fim da animação
        loadingAnimation = (AnimationDrawable) loadingCircleImage.getDrawable();
    }

    // Inicia a animação de Loading
    public void startLoadingAnimation(){
        loadingAnimation.start();
    }

    // Para a animação de Loading
    public void stopLoadingAnimation(){
        loadingAnimation.stop();
    }
}

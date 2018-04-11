package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import door.opposite.grupo2.dungeonscrolls.R;

/**
 * Classe que possuí todas as animações do programa
 *
 * Created by drayton on 11/04/18.
 */

public class Animations {
    AnimationDrawable loadingAnimation;

    // Circular Loading em formato de Círculo Mágico que constantemente pulsa do
    // transparente para o preto e vice-versa
    public void loadingMagicCircle(Context contexto){
        // Cria um LayoutInflater inflater que serve para inflar, ou seja, adaptar algo em XML para uma Classe em Java
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Cria uma View que recebe a activity em XML para que seus atributos possam ser usados
        View dialogFragmentLoadingCircle = inflater.inflate(R.layout.dialogfragment_loadingcircle, null, false);

        // Pega a referência para o ID do ImageView que está no dialog_fragment_magigcircle e cria
        // um objeto dessa classe no Java
        ImageView loadingCircle = (ImageView) dialogFragmentLoadingCircle.findViewById(R.id.dialogFragmentLoading_imageView_loadingCircle);

        // Cria um objeto da classe AnimationDrawable que
        loadingAnimation = (AnimationDrawable) loadingCircle.getDrawable();
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

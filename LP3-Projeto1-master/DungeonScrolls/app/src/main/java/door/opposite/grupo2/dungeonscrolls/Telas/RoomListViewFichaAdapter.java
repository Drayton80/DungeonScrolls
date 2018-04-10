package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;

/**
 * Created by drayton on 10/04/18.
 */

public class RoomListViewFichaAdapter extends ArrayAdapter<RoomListViewFicha> {
    // Contexto que irá ser usado:
    private final Context contexto;
    // Dados ou elementos que serão usados:
    private final ArrayList<RoomListViewFicha> elementos;

    public RoomListViewFichaAdapter(Context contexto, ArrayList<RoomListViewFicha> elementos){
        super(contexto, R.layout.activity_room_listview_ficha, elementos);

        this.contexto  = contexto;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Cria um LayoutInflater inflater que serve para inflar, ou seja, adaptar algo em XML para uma Classe em Java
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Cria uma View que recebe a activity em XML para que seus atributos possam ser usados
        View rowView = inflater.inflate(R.layout.activity_room_listview_ficha, parent, false);

        // Atribuindo à classes em Java todos os Widgets do layout em XML que serão dinâmicos
        TextView nome = (TextView) rowView.findViewById(R.id.listviewFicha_textView_nome);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.listviewFicha_imageView_imagem);

        // Atribui o texto e a imagem referente ao elemento de determinada posição para que tais atributos preencham
        // o textView e o imageView de forma correta
        nome.setText(elementos.get(position).getNome());
        imagem.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }

}

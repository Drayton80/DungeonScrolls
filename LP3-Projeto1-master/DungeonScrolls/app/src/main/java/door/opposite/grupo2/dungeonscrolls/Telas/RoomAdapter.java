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
 * Created by FHILIPE on 09/04/2018.
 */

public class RoomAdapter extends ArrayAdapter<Room>{

    private final Context context;
    private final ArrayList<Room> elementos;

    public RoomAdapter(Context context, ArrayList<Room> elementos) {
        super(context, R.layout.room_line, elementos);
        this.context = context;
        this.elementos = elementos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.room_line, parent, false);

        TextView nomeDaSala = (TextView) rowView.findViewById(R.id.nomeDaSala);
        TextView nomeDoMestre = (TextView) rowView.findViewById(R.id.nomeDoMestre);
        TextView nomeDoSistema = (TextView) rowView.findViewById(R.id.nomeDoSistema);
        ImageView imagemDaSala = (ImageView) rowView.findViewById(R.id.imagemDaSala);

        /** Adicionar imagem, senha, favorito? e outros atributos...*/

        nomeDaSala.setText(elementos.get(position).getNome());
        nomeDoMestre.setText(elementos.get(position).getMestre());
        nomeDoSistema.setText(elementos.get(position).getSistema());

        return rowView;
    }
}

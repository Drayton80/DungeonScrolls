package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;

/**
 * Created by drayton on 07/04/18.
 */

public class SheetListViewPericiaAdapter extends ArrayAdapter<SheetListViewPericia> {
    private final Context contexto;
    private final ArrayList<SheetListViewPericia> elementos;

    public SheetListViewPericiaAdapter(Context contexto, ArrayList<SheetListViewPericia> elementos){
        super(contexto, R.layout.activity_sheet_feats_skills_listviewskill, elementos);

        this.contexto = contexto;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Cria um LayoutInflater inflater que serve para inflar, ou seja, adaptar algo em XML para uma Classe em Java
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Cria uma View que recebe a activity em XML para que seus atributos possam ser usados
        View rowView = inflater.inflate(R.layout.activity_sheet_feats_skills_listviewskill, parent, false);

        // Atribuindo à classes em Java todos os Widgets do layout em XML que serão dinâmicos
        TextView nomePericia           = (TextView) rowView.findViewById(R.id.sheetFS_lvs_textView_nome);
        Spinner habilidadeSpinner      = (Spinner) rowView.findViewById(R.id.sheetFS_lvs_spinner_habilidade);
        EditText total                 = (EditText) rowView.findViewById(R.id.sheetFS_lvs_editText_total);
        EditText modificadorHabilidade = (EditText) rowView.findViewById(R.id.sheetFS_lvs_editText_modificadorHabilidade);
        EditText graduacoes            = (EditText) rowView.findViewById(R.id.sheetFS_lvs_editText_graduacoes);
        EditText outros                = (EditText) rowView.findViewById(R.id.sheetFS_lvs_editText_outros);

        nomePericia.setText(elementos.get(position).getNomePericia());
        // Ainda falta coisa, à decidir com o pessoal se vai ser assim ou não


        return rowView;


    }


}

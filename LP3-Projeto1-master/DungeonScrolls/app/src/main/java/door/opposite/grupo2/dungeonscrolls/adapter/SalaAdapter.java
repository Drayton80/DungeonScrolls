package door.opposite.grupo2.dungeonscrolls.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.databinding.SalaLineBinding;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

/**
 * Created by ci on 10/04/18.
 */

public class SalaAdapter extends ArrayAdapter<SalaModel> {
    private ArrayList<SalaModel> salaModelArrayList;
    Context context1;

    public SalaAdapter(@NonNull Context context, ArrayList<SalaModel> salaModelArrayList)  {
        super(context, R.layout.sala_line, salaModelArrayList);
        this.context1 = context;
        this.salaModelArrayList = salaModelArrayList;
        System.out.println("To aqui: =================" + Arrays.toString(salaModelArrayList.toArray()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SalaLineBinding salaLineBinding = DataBindingUtil.inflate(layoutInflater, R.layout.sala_line, parent, false);
        salaLineBinding.setListaSala(salaModelArrayList.get(position));
        System.out.println("=====================Chegou!!");
        return salaLineBinding.getRoot();
    }
}

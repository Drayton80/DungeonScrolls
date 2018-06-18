package door.opposite.grupo2.dungeonscrolls.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.databinding.MonsterLineBinding;
import door.opposite.grupo2.dungeonscrolls.databinding.SalaLineBinding;
import door.opposite.grupo2.dungeonscrolls.viewmodel.NomesMonstros;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

/**
 * Created by ci on 10/04/18.
 */

public class MonstroAdapter extends ArrayAdapter<NomesMonstros> {
    private ArrayList<NomesMonstros> MonstrosModelArrayList;
    Context context1;

    public MonstroAdapter(@NonNull Context context, ArrayList<NomesMonstros> MonstrosModelArrayList)  {
        super(context, R.layout.monster_line, MonstrosModelArrayList);
        this.context1 = context;
        this.MonstrosModelArrayList = MonstrosModelArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        MonsterLineBinding monsterLineBinding = DataBindingUtil.inflate(layoutInflater, R.layout.monster_line, parent, false);
        monsterLineBinding.setMonstros(MonstrosModelArrayList.get(position));

        return monsterLineBinding.getRoot();
    }



}

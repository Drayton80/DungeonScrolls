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
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomListviewFichaBinding;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

/**
 * Created by ci on 11/04/18.
 */

public class FichaAdapter extends ArrayAdapter<FichaModel> {
    private ArrayList<FichaModel> fichaModelArrayList;
    Context context2;

    public FichaAdapter(@NonNull Context context, ArrayList<FichaModel> fichaModelArrayList)  {
        super(context, R.layout.activity_room_listview_ficha, fichaModelArrayList);
        this.context2 = context;
        this.fichaModelArrayList = fichaModelArrayList;
        System.out.println("To aqui: =================" + Arrays.toString(fichaModelArrayList.toArray()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ActivityRoomListviewFichaBinding activityRoomListviewFichaBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_room_listview_ficha, parent, false);
        activityRoomListviewFichaBinding.setFichas(fichaModelArrayList.get(position));
        System.out.println("=====================Chegou!!");
        return activityRoomListviewFichaBinding.getRoot();
    }}

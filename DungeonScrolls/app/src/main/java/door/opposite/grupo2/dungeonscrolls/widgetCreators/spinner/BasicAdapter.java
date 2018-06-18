package door.opposite.grupo2.dungeonscrolls.widgetCreators.spinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import door.opposite.grupo2.dungeonscrolls.R;

/**
 * Created by Drayton80 on 18/06/18.
 */

public class BasicAdapter extends ArrayAdapter<BasicItem> {
    public BasicAdapter(Context context, ArrayList<BasicItem> basicList){
        super(context, 0, basicList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    private View initialView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            /*convertView = LayoutInflater.from(getContext()).inflate(

            );
            */
        }

        return null;
    }
}

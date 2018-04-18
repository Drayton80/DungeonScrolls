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
import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomListviewFichaBinding;
import door.opposite.grupo2.dungeonscrolls.databinding.DialogfragmentRoomListajogadoresBinding;
import door.opposite.grupo2.dungeonscrolls.databinding.JogadoresLineBinding;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.UsuarioModel;

/**
 * Created by ci on 11/04/18.
 */

public class JogadoresAdapter extends ArrayAdapter<UsuarioModel> {
    private ArrayList<UsuarioModel> usuarioModelArrayList;
    Context context2;

    public JogadoresAdapter(@NonNull Context context, ArrayList<UsuarioModel> usuarioModelArrayList)  {
        super(context, R.layout.jogadores_line, usuarioModelArrayList);
        this.context2 = context;
        this.usuarioModelArrayList = usuarioModelArrayList;
        System.out.println("To aqui: =================" + Arrays.toString(usuarioModelArrayList.toArray()));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        JogadoresLineBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.jogadores_line, parent, false);
        binding.setJogadoresSala(usuarioModelArrayList.get(position));

        System.out.println("=====================Chegou aqui no usuario!!");
        return binding.getRoot();
    }
}

package door.opposite.grupo2.dungeonscrolls;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import door.opposite.grupo2.dungeonscrolls.adapter.MonstroAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityBeforesheetMonsterCreatedBinding;
import door.opposite.grupo2.dungeonscrolls.viewmodel.NomesMonstros;

public class BeforeSheetMonsterCreatedActivity extends AppCompatActivity {
    ActivityBeforesheetMonsterCreatedBinding binding;
    MonstroAdapter monstroAdapter;
    NomesMonstros nomesMonstros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_beforesheet_monster_created);
        nomesMonstros = new NomesMonstros("sei", "la");

        monstroAdapter = new MonstroAdapter(this, nomesMonstros.objetosMonstros());
        binding.monsterCreatedListListView.setAdapter(monstroAdapter);


        binding.monsterCreatedListListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }




}

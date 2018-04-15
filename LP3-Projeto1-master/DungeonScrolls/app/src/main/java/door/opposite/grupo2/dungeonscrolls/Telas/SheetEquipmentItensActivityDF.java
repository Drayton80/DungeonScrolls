package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.EventoSalvar;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySheetEquipmentItensDfBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

public class SheetEquipmentItensActivityDF extends AppCompatActivity {
    ActivitySheetEquipmentItensDfBinding binding;
    Usuario usuarioLogado;
    Sala salaUsada;
    Ficha fichaUsada;
    Intent extra;
    SQLite sqLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sheet_equipment_itens_df);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        fichaUsada = (Ficha) extra.getSerializableExtra("fichaUsada");

        binding.setFichaElementos(new FichaModel(fichaUsada));

        binding.setSalvarFicha(new EventoSalvar() {
            @Override
            public void onClickSalvar() {
                fichaUsada.setPc(binding.getFichaElementos().pc);
                fichaUsada.setPp(binding.getFichaElementos().pp);
                fichaUsada.setPo(binding.getFichaElementos().po);
                fichaUsada.setPl(binding.getFichaElementos().pl);
                fichaUsada.setInventario(binding.getFichaElementos().inventario);
                fichaUsada.setArmaduraEquip(binding.getFichaElementos().armaduraEquip);
                fichaUsada.setArmaEquip(binding.getFichaElementos().armaEquip);
                fichaUsada.setOutrosEquip(binding.getFichaElementos().outrosEquip);
                sqLite.updateDataFicha(fichaUsada);
                finish();
                startActivity(getIntent());
            }
        });
    }
}

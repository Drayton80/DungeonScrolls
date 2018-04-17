package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.EventoSalvar;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySheetBattleInformationDfBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

public class SheetBattleInformationActivityDF extends AppCompatActivity {
    ActivitySheetBattleInformationDfBinding binding;
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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sheet_battle_information_df);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        fichaUsada = (Ficha) extra.getSerializableExtra("fichaUsada");

        binding.setFichaElementos(new FichaModel(fichaUsada));

        binding.setSalvarFicha(new EventoSalvar() {
            @Override
            public void onClickSalvar() {
                fichaUsada.setPv(binding.getFichaElementos().pv);
                fichaUsada.setPvAtual(binding.getFichaElementos().pvAtual);
                fichaUsada.setArmadura(binding.getFichaElementos().armadura);
                fichaUsada.setArmaduraNatural(binding.getFichaElementos().armaduraNatural);
                fichaUsada.setCaOutros(binding.getFichaElementos().caOutros);
                fichaUsada.setReducaoDeDano(binding.getFichaElementos().reducaoDeDano);
                fichaUsada.setCaToque(binding.getFichaElementos().caToque);
                fichaUsada.setCaSurpresa(binding.getFichaElementos().caSurpresa);
                fichaUsada.setResMagica(binding.getFichaElementos().resMagica);
                fichaUsada.setResistenciaNatural(binding.getFichaElementos().resistenciaNatural);
                fichaUsada.setIniciativaOutros(binding.getFichaElementos().iniciativaOutros);
                fichaUsada.setDeslocamento(binding.getFichaElementos().deslocamento);
                fichaUsada.setAgarrarOutros(binding.getFichaElementos().agarrarOutros);
                fichaUsada.setBba(binding.getFichaElementos().bba);
                fichaUsada.setAtaques(binding.getFichaElementos().ataques);

                sqLite.updateDataFicha(fichaUsada);
                finish();
                startActivity(getIntent());
            }
        });
    }
}

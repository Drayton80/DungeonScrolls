package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.EventoSalvar;
import door.opposite.grupo2.dungeonscrolls.commands.EventosFicha;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySheetAppearanceDfBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

public class SheetAppearanceActivityDF extends AppCompatActivity {
    ActivitySheetAppearanceDfBinding binding;
    Usuario usuarioLogado;
    Sala salaUsada;
    Ficha fichaUsada;
    Intent extra;
    SQLite sqLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sheet_appearance_df);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        fichaUsada = (Ficha) extra.getSerializableExtra("fichaUsada");

        binding.setFichaElementos(new FichaModel(fichaUsada));

        binding.setSalvarFicha(new EventoSalvar() {
            @Override
            public void onClickSalvar() {
                fichaUsada.setAltura(binding.getFichaElementos().altura);
                fichaUsada.setPeso(binding.getFichaElementos().peso);
                fichaUsada.setTendencia(binding.getFichaElementos().tendencia);
                fichaUsada.setDivindade(binding.getFichaElementos().divindade);
                fichaUsada.setSexo(binding.getFichaElementos().sexo);
                fichaUsada.setTamanho(binding.getFichaElementos().tamanho);
                fichaUsada.setIdiomas(binding.getFichaElementos().idiomas);
                sqLite.updateDataFicha(fichaUsada);
                finish();
                startActivity(getIntent());
            }
        });

    }
}

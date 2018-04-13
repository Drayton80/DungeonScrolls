package door.opposite.grupo2.dungeonscrolls.Telas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.commands.Eventos;
import door.opposite.grupo2.dungeonscrolls.commands.EventosFicha;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivitySheetBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

public class SheetActivity extends FragmentActivity {
    ActivitySheetBinding binding;
    Usuario usuarioLogado;
    Sala salaUsada;
    Ficha fichaUsada;
    FichaModel fichaModel;
    Intent extra;
    SQLite sqLite;
    int[] salasID, fichasID;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sheet);
        sqLite = new SQLite(this);

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        fichaUsada = (Ficha) extra.getSerializableExtra("fichaUsada");

        binding.setFichaElementos(new FichaModel(fichaUsada));


        binding.setFichaButtons(new EventosFicha(){
            @Override
            public void onClickAparencia() {
                extra = new Intent(SheetActivity.this, SheetAppearanceActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickCombate() {
                extra = new Intent(SheetActivity.this, SheetBattleInformationActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickTalentosPericias() {
                extra = new Intent(SheetActivity.this, SheetFeatsSkillsActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickEquipamentos() {
                extra = new Intent(SheetActivity.this, SheetEquipmentItensActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickInfoMagias() {
                extra = new Intent(SheetActivity.this, SheetMagicInformationActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickPropriedadesEspeciais() {
                extra = new Intent(SheetActivity.this, SheetSpecialPropertiesActivityDF.class);
                extra.putExtra("usuarioLogado", usuarioLogado);
                extra.putExtra("salaUsada", salaUsada);
                extra.putExtra("fichaUsada", fichaUsada);
                startActivity(extra);
            }

            @Override
            public void onClickSalvarFicha() {
                fichaUsada.setNomePersonagem(binding.getFichaElementos().nomePersonagem);
                fichaUsada.setIdade(binding.getFichaElementos().idade);
                fichaUsada.setXp(binding.getFichaElementos().xp);
                fichaUsada.setRaca(binding.getFichaElementos().raca);
                fichaUsada.setClasseNivel(binding.getFichaElementos().classeNivel);
                fichaUsada.setForca(binding.getFichaElementos().forca);
                fichaUsada.setDestreza(binding.getFichaElementos().destreza);
                fichaUsada.setConstituicao(binding.getFichaElementos().constituicao);
                fichaUsada.setSabedoria(binding.getFichaElementos().sabedoria);
                fichaUsada.setInteligencia(binding.getFichaElementos().inteligencia);
                fichaUsada.setCarisma(binding.getFichaElementos().carisma);
                fichaUsada.setFortitude(binding.getFichaElementos().fortitude);
                fichaUsada.setFortitudeBase(binding.getFichaElementos().fortitudeBase);
                fichaUsada.setFortitudeOutros(binding.getFichaElementos().fortitudeOutros);
                fichaUsada.setReflexo(binding.getFichaElementos().reflexo);
                fichaUsada.setReflexoBase(binding.getFichaElementos().reflexoBase);
                fichaUsada.setReflexoOutros(binding.getFichaElementos().reflexoOutros);
                fichaUsada.setVontade(binding.getFichaElementos().vontade);
                fichaUsada.setVontadeBase(binding.getFichaElementos().vontadeBase);
                fichaUsada.setVontadeOutros(binding.getFichaElementos().vontadeOutros);
                sqLite.updateDataFicha(fichaUsada);
                finish();
                startActivity(getIntent());
            }
        });
    }
}

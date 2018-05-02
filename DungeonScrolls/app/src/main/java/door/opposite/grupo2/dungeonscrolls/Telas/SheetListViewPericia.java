package door.opposite.grupo2.dungeonscrolls.Telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import door.opposite.grupo2.dungeonscrolls.R;



public class SheetListViewPericia extends AppCompatActivity {
    private String nomePericia;
    private int habilidadeSpinner;
    private int total;
    private int modificadorHabilidade;
    private int graduacoes;
    private int outros;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    // Construtor:
    public SheetListViewPericia(String nomePericia, int habilidadeSpinner, int total,
                                int modificadorHabilidade, int graduacoes, int outros) {

        this.nomePericia = nomePericia;
        this.habilidadeSpinner = habilidadeSpinner;
        this.total = total;
        this.modificadorHabilidade = modificadorHabilidade;
        this.graduacoes = graduacoes;
        this.outros = outros;
    }

    // Métodos Gets e Sets:
    public String getNomePericia() {
        return nomePericia;
    }

    public void setNomePericia(String nomePericia) {
        this.nomePericia = nomePericia;
    }

    public int getHabilidadeSpinner() {
        return habilidadeSpinner;
    }

    public void setHabilidadeSpinner(int habilidadeSpinner) {
        this.habilidadeSpinner = habilidadeSpinner;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getModificadorHabilidade() {
        return modificadorHabilidade;
    }

    public void setModificadorHabilidade(int modificadorHabilidade) {
        this.modificadorHabilidade = modificadorHabilidade;
    }

    public int getGraduacoes() {
        return graduacoes;
    }

    public void setGraduacoes(int graduacoes) {
        this.graduacoes = graduacoes;
    }

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }
}

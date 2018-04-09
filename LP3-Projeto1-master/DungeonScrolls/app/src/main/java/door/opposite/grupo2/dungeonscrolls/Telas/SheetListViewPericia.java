package door.opposite.grupo2.dungeonscrolls.Telas;

/**
 * Created by drayton on 07/04/18.
 */

public class SheetListViewPericia {
    private String nomePericia;
    private int habilidadeSpinner;
    private int total;
    private int modificadorHabilidade;
    private int graduacoes;
    private int outros;

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

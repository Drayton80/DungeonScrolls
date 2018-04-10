package door.opposite.grupo2.dungeonscrolls.Telas;

/**
 * Created by Drayton on 10/04/18.
 */

public class RoomListViewFicha {
    private String nome;
    private int imagem;

    // Construtor(es) da Classe
    public RoomListViewFicha(String nome, int imagem){
        this.nome = nome;
        this.imagem = imagem;
    }

    // Métodos Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}


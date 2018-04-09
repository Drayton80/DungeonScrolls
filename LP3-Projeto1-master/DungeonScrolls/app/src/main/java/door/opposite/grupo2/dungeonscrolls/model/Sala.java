package door.opposite.grupo2.dungeonscrolls.model;

/**
 * Created by ci on 02/04/18.
 */

public class Sala {

    int ID;
    private String nome;
    String senha;
    String mestre;
    int[] jogadoresID;
    String historia;
    int[] FichasID;
    byte[] imagem;

    public Sala(int ID, String nome, String senha, String mestre, String historia, byte[] imagem){
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.mestre = mestre;
        this.historia = historia;
        this.imagem = imagem;
    }

    public Sala(int ID, String nome, String senha, String mestre, String historia){
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.mestre = mestre;
        this.historia = historia;
    }

    public Sala(int ID, String senha, String mestre, int[] jogadoresID, String historia, int[] fichasID, byte[] imagem) {
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.mestre = mestre;
        this.jogadoresID = jogadoresID;
        this.historia = historia;
        FichasID = fichasID;
        this.imagem = imagem;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMestre() {
        return mestre;
    }

    public void setMestre(String mestre) {
        this.mestre = mestre;
    }

    public int[] getJogadoresID() {
        return jogadoresID;
    }

    public void setJogadoresID(int[] jogadoresID) {
        this.jogadoresID = jogadoresID;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int[] getFichasID() {
        return FichasID;
    }

    public void setFichasID(int[] fichasID) {
        FichasID = fichasID;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

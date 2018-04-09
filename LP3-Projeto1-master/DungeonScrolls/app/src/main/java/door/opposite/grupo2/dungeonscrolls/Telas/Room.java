package door.opposite.grupo2.dungeonscrolls.Telas;

/**
 * Created by FHILIPE on 09/04/2018.
 */

public class Room {
    int ID;
    private String nome;
    String senha;
    String mestre;
    String sistema;
    boolean favorito;
    int[] jogadoresID;
    String historia;
    int[] FichasID;
    byte[] imagem;

    /** construtor provisorio*/

    /** Se a sala está ou não na tab userRooms, vai depender do atributo favorito, se for true para o usuario da posição X, ou do ID X, ela estara presente la*/

    public Room(String nome, String mestre, String sistema){
        this.nome = nome;
        this.mestre = mestre;
        this.sistema = sistema;
    }
    /**
     public Room(int ID, String nome, String senha, String mestre, String historia, String sistema, byte[] imagem, boolean favorito){
     this.nome = nome;
     this.ID = ID;
     this.senha = senha;
     this.mestre = mestre;
     this.historia = historia;
     this.imagem = imagem;
     this.sistema = sistema;
     this.favorito = favorito;
     }

     public Room(int ID, String nome, String senha, String mestre, String sistema, String historia, boolean favorito){
     this.nome = nome;
     this.ID = ID;
     this.senha = senha;
     this.mestre = mestre;
     this.historia = historia;
     this.favorito = favorito;

     }

     public Room(int ID, String senha, String mestre, int[] jogadoresID, String historia, int[] fichasID, byte[] imagem, String sistema, boolean favorito) {
     this.nome = nome;
     this.ID = ID;
     this.senha = senha;
     this.mestre = mestre;
     this.jogadoresID = jogadoresID;
     this.historia = historia;
     FichasID = fichasID;
     this.imagem = imagem;
     this.sistema = sistema;
     this.favorito = favorito;
     } */

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;

    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
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
}


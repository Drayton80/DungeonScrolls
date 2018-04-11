package door.opposite.grupo2.dungeonscrolls.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by ci on 02/04/18.
 */

public class Sala implements Serializable{

    int ID;
    private String nome;
    String senha;
    int mestre;
    int[] jogadoresID;
    String historia;
    int[] FichasID;
    byte[] imagem;
    Bitmap imagemTest;
    String nomeMestre;


    public Sala(int ID, String nome, String senha, int mestre, String historia, byte[] imagem, String nomeMestre){
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.mestre = mestre;
        this.historia = historia;
        this.imagem = imagem;
        this.nomeMestre = nomeMestre;
    }

    public Sala(int ID, String nome, String senha, int mestre, String historia, String nomeMestre){
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.mestre = mestre;
        this.historia = historia;
        this.nomeMestre = nomeMestre;
    }

    public Sala( String nome, String senha, int mestre, String historia, String nomeMestre){
        this.nome = nome;
        this.senha = senha;
        this.mestre = mestre;
        this.historia = historia;
        this.nomeMestre = nomeMestre;
    }

    public Sala(int ID, String senha, int mestre, int[] jogadoresID, String historia, int[] fichasID, byte[] imagem, String nomeMestre) {
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.mestre = mestre;
        this.jogadoresID = jogadoresID;
        this.historia = historia;
        FichasID = fichasID;
        this.imagem = imagem;
        this.nomeMestre = nomeMestre;
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

    public int getMestre() {
        return mestre;
    }

    public void setMestre(int mestre) {
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

    public Bitmap getBitmap() {
        if(imagem == null){
            return null;
        }
        // Cria o Bitmap necess�rio para exibir no ImageView
        Bitmap bitmap = BitmapFactory.decodeByteArray(imagem, 0, imagem.length);
        return bitmap;
    }

    public Bitmap getImagemTest() {
        return imagemTest;
    }

    public void setImagemTest(Bitmap imagemTest) {
        this.imagemTest = imagemTest;
    }

    public String getNomeMestre() {
        return nomeMestre;
    }

    public void setNomeMestre(String nomeMestre) {
        this.nomeMestre = nomeMestre;
    }
}

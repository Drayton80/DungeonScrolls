package door.opposite.grupo2.dungeonscrolls.viewmodel;

import android.databinding.BaseObservable;

import door.opposite.grupo2.dungeonscrolls.model.Sala;

/**
 * Created by ci on 02/04/18.
 */

public class SalaModel extends BaseObservable{
    public String nome;
    public int ID;
    public String senha;
    public String mestre;
    //public int[] jogadoresID;
    public String historia;
    //public int[] FichasID;
    public byte[] imagem;

    public SalaModel(){
    }

    public SalaModel(Sala sala){
        this.nome = sala.getNome();
        this.ID = sala.getID();
        this.senha = sala.getSenha();
        this.historia = sala.getHistoria();
        this.imagem = sala.getImagem();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}

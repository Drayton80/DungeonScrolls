package door.opposite.grupo2.dungeonscrolls.viewmodel;

import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.model.Sala;

/**
 * Created by ci on 02/04/18.
 */

public class SalaModel extends BaseObservable{
    public String nome;
    public int ID;
    public String senha;
    public int mestre;
    //public int[] jogadoresID;
    public String historia;
    //public int[] FichasID;
    public byte[] imagem;
    Bitmap imagemTest;



    public SalaModel(){
    }

    public SalaModel(byte[] imagem){
        this.imagem = imagem;
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
        notifyPropertyChanged(R.id.roomName_plainText);
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
        notifyPropertyChanged(R.id.roomPassword_plainText);
    }

    public int getMestre() {
        return mestre;
    }

    public void setMestre(int mestre) {
        this.mestre = mestre;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
        notifyPropertyChanged(R.id.history_plainText);
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
        notifyPropertyChanged(R.id.sala_imageView);
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


}

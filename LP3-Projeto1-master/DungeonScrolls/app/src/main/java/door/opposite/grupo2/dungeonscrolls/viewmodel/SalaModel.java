package door.opposite.grupo2.dungeonscrolls.viewmodel;

import android.databinding.BaseObservable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
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
    public Uri imagem;
    Drawable imagemModel;
    String nomeMestre;
    String notas;



    public SalaModel(){
    }

    public SalaModel(Uri imagem){
        this.imagem = imagem;
    }

    public SalaModel(Sala sala){
        this.nome = sala.getNome();
        this.ID = sala.getID();
        this.senha = sala.getSenha();
        this.historia = sala.getHistoria();
        this.imagem = Uri.parse(sala.getUri());
        this.nomeMestre = sala.getNomeMestre();
        this.notas = sala.getNotas();
        //Bitmap bitmap = BitmapFactory.decodeFile(sala.getUri());
        //this.imagemModel = new BitmapDrawable(bitmap);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        notifyPropertyChanged(R.id.options_editText_nome);
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
        // Xerxes/Armando, ajeitar isso aqui
        //notifyPropertyChanged(R.id.history_plainText);
    }

    public Uri getImagem() {
        return imagem;
    }

    public void setImagem(Uri imagem) {
        this.imagem = imagem;
        notifyPropertyChanged(R.id.sala_imageView);
    }


    public Drawable getImagemModel() {
        return imagemModel;
    }

    public void setImagemModel(Drawable imagemModel) {
        this.imagemModel = imagemModel;
    }

    public String getNomeMestre() {
        return nomeMestre;
    }

    public void setNomeMestre(String nomeMestre) {
        this.nomeMestre = nomeMestre;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public ArrayList<SalaModel> getArrayListSala(List<Sala> salas, SQLite sqLite){

        ArrayList<Sala> salasArray = new ArrayList<>(salas);
        ArrayList<SalaModel> salaModelArrayList = new ArrayList<>();

        for (int i = 0; i < salasArray.size(); i++){
            if(salasArray.get(i).getID() == 0){}
            else {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + i);
                SalaModel salaModel = new SalaModel(salasArray.get(i));
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + salaModel.getNome());
                salaModelArrayList.add(salaModel);
            }
        }

        return salaModelArrayList;
    }

    public ArrayList<SalaModel> getArrayListSala(int[] salasID, SQLite sqLite){

        ArrayList<SalaModel> salaModelArrayList = new ArrayList<>();

        for (int i = 0; i < salasID.length; i++){
            if(salasID[i] == 0){}
            else {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + i);
                SalaModel salaModel = new SalaModel(sqLite.selecionarSala(salasID[i]));
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + salaModel.getNome());
                salaModelArrayList.add(salaModel);
            }
        }

        return salaModelArrayList;
    }



}

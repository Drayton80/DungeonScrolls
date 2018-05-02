package door.opposite.grupo2.dungeonscrolls.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ci on 02/04/18.
 */

public class Sala implements Serializable{

    private int ID;
    private String nome;
    private String senha;
    private int mestre;
    private ArrayList<Integer> jogadoresID = new ArrayList<Integer>();
    private String historia;
    private ArrayList<Integer> fichasID = new ArrayList<Integer>();
    private String nomeMestre;
    private String notas;
    private String uri;

    public Sala() {
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

    public ArrayList<Integer> getJogadoresID() {
        return jogadoresID;
    }

    public void setJogadoresID(ArrayList<Integer> jogadoresID) {
        this.jogadoresID = jogadoresID;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public ArrayList<Integer> getFichasID() {
        return fichasID;
    }

    public void setFichasID(ArrayList<Integer> fichasID) {
        this.fichasID = fichasID;
    }

    //public byte[] pegaImagem() {
    //    return toArrayByte(pegaImagemDb());
   // }

    //public void mudaImagem(byte[] imagem) {

    //    this.mudaImagemDb(toListByte(imagem));
   // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   // public Bitmap getBitmap() {
      //  if(pegaImagem() == null){
      //      return null;
      //  }
      //  // Cria o Bitmap necess�rio para exibir no ImageView
     //   Bitmap bitmap = BitmapFactory.decodeByteArray(pegaImagem(), 0, pegaImagem().length);
     //   return bitmap;
   // }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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


    public int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];

        String[] aux = Arrays.toString(list.toArray()).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        for (int i=0; i < ret.length; i++)
        {
            ret[i] = Integer.parseInt(aux[i]);
        }

        return ret;
    }

    public ArrayList<Integer> toIntList(final int[] array)  {

        ArrayList<Integer> intList = new ArrayList<Integer>() {{ for (int i : array) add(i); }};


        return intList;
    }
/*
    public ArrayList<Byte> toListByte(byte[] imagem){
        ArrayList<Byte> list = new ArrayList<>();
        for (byte b : imagem) {
            list.add(b);
        }
        return list;
    }

    public byte[] toArrayByte(ArrayList<Byte> imagem){

        byte[] bytes = new byte[imagem.size()];
        for (int i = 0; i <imagem.size(); i++) {
            bytes[i] = imagem.get(i);
        }

        return bytes;
    }


    public ArrayList<Integer> imagemToListInt(ArrayList<Byte> bytes){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (byte b : bytes) {
            integers.add((int) b);
        }
        return integers;
    }


    public ArrayList<Byte> listIntToImagem(ArrayList<Integer> ints){

        int[] data = toIntArray(ints);
        ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(data);

        byte[] array = byteBuffer.array();
        return toListByte(array);
    }

*/

}

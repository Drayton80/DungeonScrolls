package door.opposite.grupo2.dungeonscrolls.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ci on 02/04/18.
 */

public class Usuario implements Serializable{
    private int ID;
    private String nick;
    private String senha;
    private String email;
    private ArrayList<Integer> fichasID = new ArrayList<Integer>();
    private ArrayList<Integer> salasID = new ArrayList<Integer>();


    public Usuario() {
    }

    public Usuario(String nick, String senha, String email){
        this.nick = nick;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(int ID, String nick, String senha, String email){
        this.ID = ID;
        this.nick = nick;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(int ID, String nick, String senha, String email, ArrayList<Integer> fichasID, ArrayList<Integer> salasID) {
        this.ID = ID;
        this.nick = nick;
        this.senha = senha;
        this.email = email;
        this.fichasID = fichasID;
        this.salasID = salasID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Integer> getFichasID() {
        return fichasID;
    }

    public void setFichasID(ArrayList<Integer> fichasID) {
        this.fichasID = fichasID;
    }

    public ArrayList<Integer> getSalasID() {
        return salasID;
    }

    public void setSalasID(ArrayList<Integer> salasID) {
        this.salasID = salasID;
    }


    public int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];

        String[] aux = Arrays.toString(list.toArray()).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        //System.out.println("Lista inicial = "+ list.toString());
        //System.out.println("tamanho da lista = "+ list.size());
        //System.out.println("Como a lista fica em Array = "+ list.toArray().toString());
        for (int i=0; i < ret.length; i++)
        {
           // System.out.println("onde esta o I = " + i);
            ret[i] = Integer.parseInt(aux[i]);
           // System.out.println("String que fou botado no I = " + Integer.parseInt(aux[0]));
        }

        //System.out.println("Lista virou array e saiu assim = " + Arrays.toString(ret));
        return ret;
    }

    public ArrayList<Integer> toIntList(final int[] array)  {
       // System.out.println("Array chegou assim = " + Arrays.toString(array));

        ArrayList<Integer> intList = new ArrayList<Integer>() {{ for (int i : array) add(i); }};

       // System.out.println("array virou lista e saiu assim = " + intList.toString());

        return intList;
    }
}

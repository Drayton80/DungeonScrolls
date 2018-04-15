package door.opposite.grupo2.dungeonscrolls.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ci on 02/04/18.
 */

public class Usuario implements Serializable{
    private int ID;
    private String nick;
    private String senha;
    private String email;
    private List<Integer> fichasID = new ArrayList<>(0);
    private List<Integer> salasID = new ArrayList<>(0);


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

    public Usuario(int ID, String nick, String senha, String email, List<Integer> fichasID, List<Integer> salasID) {
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

    public List<Integer> getFichasID() {
        return fichasID;
    }

    public void setFichasID(List<Integer> fichasID) {
        this.fichasID = fichasID;
    }

    public List getSalasID() {
        return Arrays.asList(salasID);
    }

    public void setSalasID(List<Integer> salasID) {
        this.salasID = salasID;
    }


    public int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e.intValue();
        return ret;
    }

    public List<Integer> toIntList(int[] array)  {

        List<Integer> intList = new ArrayList<Integer>();
        for (int i : array)
        {
            intList.add(i);
        }
        return intList;
    }
}

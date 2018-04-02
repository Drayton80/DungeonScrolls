package door.opposite.grupo2.dungeonscrolls.model;

/**
 * Created by ci on 02/04/18.
 */

public class Usuario {

    int ID;
    String nick;
    String senha;
    String email;
    int[] fichasID;
    int[] salasID;

    public Usuario(int ID, String nick, String senha, String email){
        this.ID = ID;
        this.nick = nick;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(int ID, String nick, String senha, String email, int[] fichasID, int[] salasID) {
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

    public int[] getFichasID() {
        return fichasID;
    }

    public void setFichasID(int[] fichasID) {
        this.fichasID = fichasID;
    }

    public int[] getSalasID() {
        return salasID;
    }

    public void setSalasID(int[] salasID) {
        this.salasID = salasID;
    }
}

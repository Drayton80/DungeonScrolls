package door.opposite.grupo2.dungeonscrolls.Cliente;

import java.net.*;
import java.io.*;

/**
 *
 * @author Douglas
 */

public class Comunicacao {
    private Socket servidor;
    private DataOutputStream saida;
    private DataInputStream entrada;
    
    public Comunicacao(Socket servidor){
        try{
        this.servidor = servidor;  
        saida = new DataOutputStream(servidor.getOutputStream());
        entrada = new DataInputStream(servidor.getInputStream());
        }catch(Exception ex){
            ex.printStackTrace();
        }
            
    }
    public void protocoloSaida(String mensagem){
        byte[] code = mensagem.getBytes();
        try{    
            for(int i = 0; i  < code.length; i++){
                char aux = (char) code[i];
                //while(true){
                saida.writeByte(aux);
                saida.flush();
                char sinal = (char) entrada.readByte(); //Fica esperando o sinal de retorno
                System.out.println(sinal);
                if(sinal != 'c'){//Sinal para continuar mandando
                    break;
                }
            }
            saida.writeByte(';');
            saida.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String protocoloEntrada(){
        try{
            String valor = "";
            while(true){
                char letra = (char) entrada.readByte();
                System.out.println(letra);
                if(letra == ';')break;
                valor += String.valueOf(letra);
            }
            return valor;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
      
    }
}

package Cliente;

/**
 *
 * @author Douglas
 */

import java.net.*;
import java.util.*;
import java.io.*;


 
public class Cliente {
    public static void main(String[] args) {
	    try{
		    Socket servidor = new Socket("localhost",50008);
                    DataOutputStream saida = new DataOutputStream(servidor.getOutputStream());
		    Comunicacao protocolo = new Comunicacao(servidor);
		    Scanner leitura = new Scanner(System.in);
                    
                    
		    byte acao = leitura.nextByte();
		    if(acao == 1){
		    	System.out.println("Pesquisa de monstro");
                        saida.writeByte('1'); //Faz o sinal de que é para o servidor fazer a pesquisa
                        saida.flush(); //Manda o sinal
		        protocolo.protocoloSaida("Abyssal Greater Basilisk"); //Diz a string do nome da criatura a ser pesquisada
		        String teste = protocolo.protocoloEntrada(); //Retorna a linha inteira no dataset referente aquela criatura
		        System.out.println(teste);
		    }
		    if(acao == 2){
		    	System.out.println("Determina monstro");
                        saida.writeByte('2'); //Faz o sinal de que é para o servidor determinar o monstro
                        saida.flush(); //Manda o sinal
                        protocolo.protocoloSaida("Undead,Huge,Underground,Chaotic Evil,"
                                + "3,5"); //String com os atributos que serão mandados, precisam estar nesse formato!
                        String teste = protocolo.protocoloEntrada(); //Pega todos os dados determinados daquela criatura
                        System.out.println(teste);
                        
		    }
	        servidor.close();
	    }catch(Exception ex){
	        ex.printStackTrace();
	    }
    }
}


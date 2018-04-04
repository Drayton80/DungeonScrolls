package door.opposite.grupo2.dungeonscrolls.model;

/**
 * Created by ci on 04/04/18.
 */

public class ListaSala {

    private Sala cabeca;
    private int nElemento;

    public ListaSala(){
        cabeca = null;
        nElemento = 0;
    }

    public boolean vazia(){
        if(nElemento == 0){
            return true;
        }
        else return false;
    }

    public int tamanho(){
        Sala aux = cabeca;
        int count = 0;
        while(aux != null){
            count++;
            aux = aux.getProx();
        }
        return count;
    }

    private void insereInicioLista(Sala NovoNo){
        Sala aux = cabeca;
        NovoNo.setProx(aux);
        cabeca = NovoNo;
        nElemento++;
    }

    private void insereMeioLista(Sala NovoNo, int pos){
        Sala aux = cabeca;
        for(int i = 0; i < pos - 1; i++){
            aux = aux.getProx();
        }

        Sala p = aux.getProx();
        NovoNo.setProx(p);
        aux.setProx(NovoNo);

        nElemento++;
    }

    private void insereFimLista(Sala NovoNo){
        Sala aux = cabeca;

        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        aux.setProx(NovoNo);
        nElemento++;
    }

    public void insere(Sala NovoNo){

        if(NovoNo.getID() == 0){
            insereInicioLista(NovoNo);
            System.out.println("Removeu no inicio");
        }
        else if(NovoNo.getID() == nElemento){
            insereFimLista(NovoNo);
            System.out.println("Removeu no meio");
        }
        else{
            insereMeioLista(NovoNo,NovoNo.getID());
            System.out.println("Removeu no fim");
        }

    }

    private void removeInicio(){
        Sala aux = cabeca;

        if(aux.getProx() == null) cabeca = null;
        else aux.setProx(aux.getProx());

        nElemento--;
    }


    private void removeMeio(int pos){
        Sala atual = null, antecessor = null;
        int dado = -1;
        int cont = 1;

        atual = cabeca;
        while((cont < pos) && (atual != null)){
            antecessor = atual;
            atual = atual.getProx();
            cont++;
        }

        if (atual == null) {
            return;
        }

        antecessor.setProx(atual.getProx());
        atual = null;
        nElemento--;

    }

    public void remove(Sala morto){
        if(vazia()){
            return;
        }

        if(morto.getID() == 0){
            removeInicio();
        }
        else{
            removeMeio(morto.getID());
        }
    }

    public Sala pesquisaId(int id){
        Sala aux = cabeca;

        if(aux == null){
            System.out.println("Id inválido");
            return null;
        }

        while(aux.getID() != id){
            aux = aux.getProx();

            if(aux == null){
                System.out.println("Id inválido");
                return null;
            }
        }

        return aux;
    }

    public Sala pesquisaNome(String nome){
        Sala aux = cabeca;

        if(aux == null){
            System.out.println("Id inválido");
            return null;
        }

        while(aux.getNome().equalsIgnoreCase(nome)) {
            aux = aux.getProx();
            if(aux == null) {
                System.out.println("Id inválido");
                return null;
            }
        }

        return aux;
    }
}

package door.opposite.grupo2.dungeonscrolls.model;

/**
 * Created by ci on 04/04/18.
 */

public class ListaFicha {

    private Ficha cabeca;
    private int nElemento;

    public ListaFicha(){
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
        Ficha aux = cabeca;
        int count = 0;
        while(aux != null){
            count++;
            aux = aux.getProx();
        }
        return count;
    }

    private void insereInicioLista(Ficha NovoNo){
        Ficha aux = cabeca;
        NovoNo.setProx(aux);
        cabeca = NovoNo;
        nElemento++;
    }

    private void insereMeioLista(Ficha NovoNo, int pos){
        Ficha aux = cabeca;
        for(int i = 0; i < pos - 1; i++){
            aux = aux.getProx();
        }

        Ficha p = aux.getProx();
        NovoNo.setProx(p);
        aux.setProx(NovoNo);

        nElemento++;
    }

    private void insereFimLista(Ficha NovoNo){
        Ficha aux = cabeca;

        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        aux.setProx(NovoNo);
        nElemento++;
    }

    public void insere(Ficha NovoNo){

        if(NovoNo.getId() == 0){
            insereInicioLista(NovoNo);
            System.out.println("Removeu no inicio");
        }
        else if(NovoNo.getId() == nElemento){
            insereFimLista(NovoNo);
            System.out.println("Removeu no meio");
        }
        else{
            insereMeioLista(NovoNo,NovoNo.getId());
            System.out.println("Removeu no fim");
        }

    }

    private void removeInicio(){
        Ficha aux = cabeca;

        if(aux.getProx() == null) cabeca = null;
        else aux.setProx(aux.getProx());

        nElemento--;
    }


    private void removeMeio(int pos){
        Ficha atual = null, antecessor = null;
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

    public void remove(Ficha morto){
        if(vazia()){
            return;
        }

        if(morto.getId() == 0){
            removeInicio();
        }
        else{
            removeMeio(morto.getId());
        }
    }

    public Ficha pesquisaId(int id){
        Ficha aux = cabeca;

        if(aux == null){
            System.out.println("Id inválido");
            return null;
        }

        while(aux.getId() != id){
            aux = aux.getProx();

            if(aux == null){
                System.out.println("Id inválido");
                return null;
            }
        }

        return aux;
    }

    public Ficha pesquisaNome(String nome){
        Ficha aux = cabeca;

        if(aux == null){
            System.out.println("Id inválido");
            return null;
        }

        while(aux.getNomeJogador().equalsIgnoreCase(nome)) {
            aux = aux.getProx();
            if(aux == null) {
                System.out.println("Id inválido");
                return null;
            }
        }

        return aux;
    }

}


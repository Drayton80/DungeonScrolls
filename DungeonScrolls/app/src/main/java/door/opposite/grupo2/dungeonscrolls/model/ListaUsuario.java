package door.opposite.grupo2.dungeonscrolls.model;

/**
 * Created by ci on 04/04/18.
 */

public class ListaUsuario {

    private Usuario cabeca;
    private int nElemento;

    public ListaUsuario(){
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
        Usuario aux = cabeca;
        int count = 0;
        while(aux != null){
            count++;
            aux = aux.getProx();
        }
        return count;
    }

    private void insereInicioLista(Usuario NovoNo){
        Usuario aux = cabeca;
        NovoNo.setProx(aux);
        cabeca = NovoNo;
        nElemento++;
    }

    private void insereMeioLista(Usuario NovoNo, int pos){
        Usuario aux = cabeca;
        for(int i = 0; i < pos - 1; i++){
            aux = aux.getProx();
        }

        Usuario p = aux.getProx();
        NovoNo.setProx(p);
        aux.setProx(NovoNo);

        nElemento++;
    }

    private void insereFimLista(Usuario NovoNo){
        Usuario aux = cabeca;

        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        aux.setProx(NovoNo);
        nElemento++;
    }

    public void insere(Usuario NovoNo){

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
        Usuario aux = cabeca;

        if(aux.getProx() == null) cabeca = null;
        else aux.setProx(aux.getProx());

        nElemento--;
    }


    private void removeMeio(int pos){
        Usuario atual = null, antecessor = null;
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

    public void remove(Usuario morto){
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

    public Usuario pesquisaId(int id){
        Usuario aux = cabeca;

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

    public Usuario pesquisaNome(String nome){
        Usuario aux = cabeca;

        if(aux == null){
            System.out.println("Id inválido");
            return null;
        }

        while(aux.nick.equalsIgnoreCase(nome)) {
            aux = aux.getProx();
            if(aux == null) {
                System.out.println("Id inválido");
                return null;
            }
        }

        return aux;
    }

}

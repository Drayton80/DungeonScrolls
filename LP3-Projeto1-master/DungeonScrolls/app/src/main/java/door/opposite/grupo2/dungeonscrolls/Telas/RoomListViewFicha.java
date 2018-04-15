package door.opposite.grupo2.dungeonscrolls.Telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import door.opposite.grupo2.dungeonscrolls.R;

/**
 * Created by Drayton on 10/04/18.
 */

public class RoomListViewFicha extends AppCompatActivity {
    private String nome;
    private int imagem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

        // Construtor(es) da Classe
    public RoomListViewFicha(String nome, int imagem){
        this.nome = nome;
        this.imagem = imagem;
    }

    // Métodos Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}


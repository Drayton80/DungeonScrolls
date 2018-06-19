package door.opposite.grupo2.dungeonscrolls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class BeforeSheetMonsterAutomaticallyActivity extends AppCompatActivity {

    EditText ambiente;
    EditText tipo;
    EditText ND;
    EditText NAjuste;
    EditText tamanho;
    EditText alinhamento;
    Button comfirma;
    Button cancelar;
    SQLite sqLite;

    Intent extra;
    Usuario usuarioLogado, usuarioOn;
    Sala salaUsada;
    Ficha fichaUsada, fichaMonster;
    SalaModel salaModel;
    FichaModel fichaModel;
    Boolean mestre = false;
    int[] fichasID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforesheet_monster_automatically);


        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        mestre =  extra.getBooleanExtra("mestre", mestre);
        sqLite = new SQLite(this);



        ambiente = (EditText)findViewById(R.id.roomNewSheetAutomatically_editText_ambiente);
        tipo = (EditText)findViewById(R.id.roomNewSheetAutomatically_editText_tipo);
        ND = (EditText)findViewById(R.id.roomNewSheetAutomatically_editText_nd);
        NAjuste = (EditText)findViewById(R.id.roomNewSheetAutomatically_editText_nivelAjuste);
        tamanho = (EditText)findViewById(R.id.roomNewSheetAutomatically_editText_tamanho);
        alinhamento = (EditText)findViewById(R.id.roomNewSheetAutomatically_editText_alinhamento);

        comfirma = (Button) findViewById(R.id.roomNewSheetAutomatically_button_continuar);
        cancelar = (Button) findViewById(R.id.roomNewSheetAutomatically_button_cancelar);

        comfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("==========================>>>>>>>>>>>> Click");
                new Thread((new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("==========================>>>>>>>>>>>> RUM");

                try {

                    Socket servidor = new Socket("10.0.2.2",50008);
                    System.out.println("==========================>>>>>>>>>>>> TRY");
                    DataOutputStream saida = new DataOutputStream(servidor.getOutputStream());
                    Cliente.Comunicacao protocolo = new Cliente.Comunicacao(servidor);


                    saida.writeByte('2'); //Faz o sinal de que é para o servidor determinar o monstro
                    saida.flush(); //Manda o sinal
                    protocolo.protocoloSaida(tipo.getText() +"," + tamanho.getText() + "," + ambiente.getText() + "," + alinhamento.getText()+","
                            + NAjuste.getText() +","+ ND.getText()); //String com os atributos que serão mandados, precisam estar nesse formato!

                    String monstroString = protocolo.protocoloEntrada();
                    System.out.println("==========================>>>>>>>>>>>>" + monstroString);
                    String[] monstroSeparado = monstroString.split(",");

                    for(int i = 0; i < monstroSeparado.length; i++){
                        System.out.println("==========================>>>>>>>>>>>>" + monstroSeparado[i]);
                    }

                    Ficha ficha = new Ficha("Monstro Artificial", "",
                            "", "",  monstroSeparado[19], "", "", monstroSeparado[1],
                            0, 0, 0, Integer.parseInt(monstroSeparado[11]), Integer.parseInt(monstroSeparado[13]), Integer.parseInt(monstroSeparado[12]), Integer.parseInt(monstroSeparado[14]),
                            Integer.parseInt(monstroSeparado[15]), Integer.parseInt(monstroSeparado[16]), 0, 0, 0,
                            0, 0, 0, 0, Integer.parseInt(monstroSeparado[5]), 0,
                            0, 0, Integer.parseInt(monstroSeparado[4]), Integer.parseInt(monstroSeparado[2]), 0, Integer.parseInt(monstroSeparado[3]),
                            0, Integer.parseInt(monstroSeparado[8]), 0, 0, Integer.parseInt(monstroSeparado[9]),
                            0, 0, Integer.parseInt(monstroSeparado[10]), 0, 0,  Integer.parseInt(monstroSeparado[6]),
                            0, 0, Integer.parseInt(monstroSeparado[7]), 0, 0, 0, 0,
                            0, 0, 2, "", "", "", "",
                            "", "", "", "", "", "",
                            0, 0, 0, 0, "", "",
                            "", "","","", "",
                            monstroSeparado[17], "", "", monstroSeparado[0], "", NAjuste.getText().toString(), "",
                            Integer.parseInt(monstroSeparado[18]), 0, 0);
                    /*
                    new Ficha("Monstro Artificial", monstroSeparado[0], monstroSeparado[1], Integer.parseInt(monstroSeparado[2]),
                            Integer.parseInt(monstroSeparado[3]), Integer.parseInt(monstroSeparado[4]), Integer.parseInt(monstroSeparado[5]),
                            Integer.parseInt(monstroSeparado[6]), Integer.parseInt(monstroSeparado[7]), Integer.parseInt(monstroSeparado[8]),
                            Integer.parseInt(monstroSeparado[9]),Integer.parseInt(monstroSeparado[10]),Integer.parseInt(monstroSeparado[11]),
                            Integer.parseInt(monstroSeparado[12]), Integer.parseInt(monstroSeparado[13]), Integer.parseInt(monstroSeparado[14]),
                            Integer.parseInt(monstroSeparado[15]), Integer.parseInt(monstroSeparado[16]), monstroSeparado[17],
                            Integer.parseInt(monstroSeparado[18]), monstroSeparado[19]);
                            */
                    sqLite.insereDataFicha(ficha);


                    int[] aux = new int[salaUsada.toIntArray(salaUsada.getFichasID()).length +1];

                    for (int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                        aux[i] = salaUsada.toIntArray(salaUsada.getFichasID())[i];
                    }
                    aux[salaUsada.toIntArray(salaUsada.getFichasID()).length] = sqLite.ultimaFicha();

                    salaUsada.setFichasID(salaUsada.toIntList(aux));

                    sqLite.updateDataSala(salaUsada);

                    fichasID = salaUsada.toIntArray(salaUsada.getFichasID());

                    servidor.close();

                    extra = new Intent(BeforeSheetMonsterAutomaticallyActivity.this, RoomMonsterListActivity.class);
                    extra.putExtra("usuarioLogado", usuarioLogado);
                    extra.putExtra("salaUsada", salaUsada);
                    extra.putExtra("fichaUsada", fichaUsada);
                    extra.putExtra("mestre", mestre);
                    finish();
                    startActivity(extra);

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("==========================>>>>>>>>>>>> kracho");
                }
                    }
                })).start();
            }
        });
    }
}

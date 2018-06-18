package door.opposite.grupo2.dungeonscrolls;

import android.databinding.generated.callback.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import door.opposite.grupo2.dungeonscrolls.Cliente.Comunicacao;

public class BeforeSheetMonsterAutomaticallyActivity extends AppCompatActivity {

    EditText ambiente;
    EditText tipo;
    EditText ND;
    EditText NAjuste;
    EditText tamanho;
    EditText alinhamento;
    Button comfirma;
    Button cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforesheet_monster_automatically);


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
                try {
                    Socket servidor = new Socket("localhost",50008);
                    DataOutputStream saida = new DataOutputStream(servidor.getOutputStream());
                    Comunicacao protocolo = new Comunicacao(servidor);


                    saida.writeByte('2'); //Faz o sinal de que é para o servidor determinar o monstro
                    saida.flush(); //Manda o sinal
                    protocolo.protocoloSaida(tipo.getText() +"," + tamanho.getText() + "," + ambiente.getText() + "," + alinhamento.getText()+","
                            + NAjuste.getText() +","+ ND.getText()); //String com os atributos que serão mandados, precisam estar nesse formato!

                    String monstroString = protocolo.protocoloEntrada();
                    String[] monstroSeparado = monstroString.split(",");

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }








}

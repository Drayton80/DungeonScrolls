package door.opposite.grupo2.dungeonscrolls;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import Cliente.Comunicacao;

import door.opposite.grupo2.dungeonscrolls.adapter.MonstroAdapter;
import door.opposite.grupo2.dungeonscrolls.adapter.SalaAdapter;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityBeforesheetMonsterCreatedBinding;
import door.opposite.grupo2.dungeonscrolls.model.Ficha;
import door.opposite.grupo2.dungeonscrolls.model.SQLite;
import door.opposite.grupo2.dungeonscrolls.model.Sala;
import door.opposite.grupo2.dungeonscrolls.model.Usuario;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;
import door.opposite.grupo2.dungeonscrolls.viewmodel.NomesMonstros;
import door.opposite.grupo2.dungeonscrolls.viewmodel.SalaModel;

public class BeforeSheetMonsterCreatedActivity extends AppCompatActivity {
    ActivityBeforesheetMonsterCreatedBinding binding;
    MonstroAdapter monstroAdapter;
    NomesMonstros nomesMonstros;

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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_beforesheet_monster_created);
        nomesMonstros = new NomesMonstros("sei", "la");

        extra = getIntent();
        usuarioLogado = (Usuario) extra.getSerializableExtra("usuarioLogado");
        salaUsada = (Sala) extra.getSerializableExtra("salaUsada");
        mestre =  extra.getBooleanExtra("mestre", mestre);
        sqLite = new SQLite(this);
        final ArrayList<NomesMonstros> nomes = nomesMonstros.objetosMonstros();
        monstroAdapter = new MonstroAdapter(this, nomes);
        binding.monsterCreatedListListView.setAdapter(monstroAdapter);


        binding.monsterCreatedListListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                final int monstroPosicao = position;


                new Thread((new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("==========================>>>>>>>>>>>> RUM");

                        try {

                            Socket servidor = new Socket("10.0.2.2",50008);
                            System.out.println("==========================>>>>>>>>>>>> TRY");
                            DataOutputStream saida = new DataOutputStream(servidor.getOutputStream());
                            Cliente.Comunicacao protocolo = new Comunicacao(servidor);


                            saida.writeByte('1'); //Faz o sinal de que é para o servidor determinar o monstro
                            saida.flush(); //Manda o sinal
                            protocolo.protocoloSaida(nomes.get(monstroPosicao).getNome()); //String com os atributos que serão mandados, precisam estar nesse formato!

                            String monstroString = protocolo.protocoloEntrada();
                            System.out.println("==========================>>>>>>>>>>>>" + monstroString);
                            String[] monstroSeparado = monstroString.split(",");

                            for(int i = 0; i < monstroSeparado.length; i++){
                                System.out.println("==========================>>>>>>>>>>>>" + monstroSeparado[i]);
                            }

                            //String[] deslocamento = monstroSeparado[7].split("|"); //pegar só o primeiro numero - deslocamento

                            //int deslocamentoTerra = Integer.parseInt(deslocamento[0]);
                            //monstroSeparado[12]
                            //monstroSeparado[13]
                            //monstroSeparado[15] //os 3 ataques aki
                            String ataques = "Ataques normais\n" + monstroSeparado[12] + "\n\n\n" + "Ataques Completos\n" + monstroSeparado[13] + "\n\n\n" + "Ataques Especiais\n" + monstroSeparado[15];

                            //String[] spaceEReach = monstroSeparado[14].split("|");//monstroSeparado[14] //dividir entre espaço e alcance
                            //int espaco = Integer.parseInt(spaceEReach[0]);
                            //int alcance = Integer.parseInt(spaceEReach[1]);
                            Ficha ficha = new Ficha(monstroSeparado[1], "",
                                    "", "", monstroSeparado[31], "", "", monstroSeparado[4],
                                    0, 0, 0, Integer.parseInt(monstroSeparado[20]), Integer.parseInt(monstroSeparado[22]), Integer.parseInt(monstroSeparado[21]), Integer.parseInt(monstroSeparado[23]),
                                    Integer.parseInt(monstroSeparado[24]), Integer.parseInt(monstroSeparado[25]), 0, 0, 0,
                                    0, 0, 0, 0, Integer.parseInt(monstroSeparado[9]), 0,
                                    0, 0, Integer.parseInt(monstroSeparado[8]), Integer.parseInt(monstroSeparado[5]), 0, Integer.parseInt(monstroSeparado[6]),
                                    0, Integer.parseInt(monstroSeparado[17]), 0, 0, Integer.parseInt(monstroSeparado[18]),
                                    0, 0, Integer.parseInt(monstroSeparado[19]), 0, 0,  Integer.parseInt(monstroSeparado[10]),
                                    0, 0,  Integer.parseInt(monstroSeparado[11]), 0, 0, 0, 0,
                                    0, 0, 2, "", monstroSeparado[30], ataques, "",
                                    "", "", "", monstroSeparado[27], "", monstroSeparado[26],
                                    0, 0, 0, 0, "", "",
                                    "", "","", monstroSeparado[16], "",
                                    monstroSeparado[28], "", monstroSeparado[33], monstroSeparado[2], monstroSeparado[3], monstroSeparado[32], "",
                                    Float.parseFloat(monstroSeparado[29]), 0, 0);

                            sqLite.insereDataFicha(ficha);
                                    //Integer.parseInt(monstroSeparado[18])

                            int[] aux = new int[salaUsada.toIntArray(salaUsada.getFichasID()).length +1];

                            for (int i = 0; i < salaUsada.toIntArray(salaUsada.getFichasID()).length; i++){
                                aux[i] = salaUsada.toIntArray(salaUsada.getFichasID())[i];
                            }
                            aux[salaUsada.toIntArray(salaUsada.getFichasID()).length] = sqLite.ultimaFicha();

                            salaUsada.setFichasID(salaUsada.toIntList(aux));

                            sqLite.updateDataSala(salaUsada);

                            fichasID = salaUsada.toIntArray(salaUsada.getFichasID());

                            servidor.close();

                            extra = new Intent(BeforeSheetMonsterCreatedActivity.this, RoomMonsterListActivity.class);
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

package door.opposite.grupo2.dungeonscrolls.Telas;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import door.opposite.grupo2.dungeonscrolls.R;

@SuppressWarnings("deprecation")

public class RoomsMenu extends TabActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_menu);

        TabHost host = (TabHost) findViewById(android.R.id.tabhost);

        // Nota: getResources().getString() é usado pois os parametros de saída do R.string.* são números
        //       que referenciam as palavras no XML string
        createTab(this, host, "tabAllRooms", getResources().getString(R.string.allRooms_activity_tabAllRooms_title), AllRooms.class);
        createTab(this, host, "tabUserRooms", getResources().getString(R.string.userRooms_activity_tabUserRooms_title), UserRooms.class);

    }

    /** setNewTab
     *      Descrição: cria uma tab no programa ao serem passadas suas especificações nos parâmetros
     */
    private void createTab(Context context, TabHost tabhost, String tag, String title, Class tabView){
        // Instancia um objeto TabSpec que engloba as especificações de uma Taba e instancia um Intent
        // que representará a Activity que será chamada na exibição da Tab
        TabHost.TabSpec specifications = tabhost.newTabSpec(tag);
        Intent intent = new Intent(context, tabView);

        // Define as especificações da Tab
        specifications.setIndicator(title)
                .setContent(intent);

        // Faz a tab ser executada
        tabhost.addTab(specifications);
    }
}
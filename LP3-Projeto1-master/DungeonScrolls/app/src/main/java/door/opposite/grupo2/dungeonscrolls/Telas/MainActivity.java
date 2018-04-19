package door.opposite.grupo2.dungeonscrolls.Telas;

import android.Manifest;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TabHost;

import door.opposite.grupo2.dungeonscrolls.R;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    private static final int  PERMISSIONS_MULTIPLE_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{ Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE },
                PERMISSIONS_MULTIPLE_REQUEST);


        TabHost host = (TabHost) findViewById(android.R.id.tabhost);

        // Nota: getResources().getString() é usado pois os parametros de saída do R.string.* são números
        //       que referenciam as palavras no XML string
        createTab(this, host, "tabLogin", getResources().getString(R.string.login_activity_tabLogin_title), LoginActivity.class);
        createTab(this, host, "tabSignUp", getResources().getString(R.string.login_activity_tabSignUp_title), SignUpActivity.class);


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
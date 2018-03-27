package door.opposite.grupo2.dungeonscrolls;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        TabHost tabhost = getTabHost();

        TextView tv1 = (TextView) tabhost.getTabWidget().findViewById(R.id.tabEntrar);
        tv1.setText("Entrar");

        TextView tv2 = (TextView) tabhost.getTabWidget().findViewById(R.id.tabCadastrar);
        tv2.setText("Criar Conta");

        /*
        Resources resources = getResources();

        TabHost host = getTabHost();

        //Intent intent1 = new Intent(this, LoanCalculator.class);

        //Bundle loanBundle1
        //        = LoanBundler.makeLoanInfoBundle(100000, 7.5, 120);

        //intent1.putExtras(loanBundle1);

        TabSpec tabEntrar = host.newTabSpec("Tab Entrar")
                                .setIndicator("Entrar");
                                //.setContent(intent1);

        host.addTab(tabEntrar);

        TabSpec tabCadastrar = host.newTabSpec("Tab Cadastrar")
                .setIndicator("Criar Conta");
        //.setContent(intent1);

        host.addTab(tabEntrar);
        */
    }
}
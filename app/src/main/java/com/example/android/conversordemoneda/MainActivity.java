package com.example.android.conversordemoneda;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText monto;
    CheckBox dolar, euro, sol, real, pChile, pColombia, bolivar, yen;
    TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monto = (EditText) findViewById(R.id.edit_text_monto);
        dolar = (CheckBox) findViewById(R.id.check_dolar);
        euro = (CheckBox) findViewById(R.id.check_euro);
        sol = (CheckBox) findViewById(R.id.check_sol);
        real = (CheckBox) findViewById(R.id.check_reales);
        pChile = (CheckBox) findViewById(R.id.check_chilenos);
        pColombia = (CheckBox) findViewById(R.id.check_colombia);
        bolivar = (CheckBox) findViewById(R.id.check_venezuela);
        yen = (CheckBox) findViewById(R.id.check_yenes);
        textTotal = (TextView) findViewById(R.id.text_total);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    * Este metodo convertira el monto en Bs a las diferentes monedas*/
    public void calcular(View view){
        double valDolar = 6.95, valEuro = 7.83, valSol = 2.09, valReal = 1.99, valChile = 0.01, valColombia = 0.002318, valBolivar = 0.000695, valYen = 0.06;
        int valMonto =  Integer.parseInt(monto.getText().toString());
        String total = "El monto: " + monto.getText().toString() + " equivale a: \n";
        if(dolar.isChecked()){
            total = total + "En Dolares: " + (float)(valMonto / valDolar)+"\n";
        }
        if(euro.isChecked()){
            total = total + "En Euros: " + (float)(valMonto / valEuro)+"\n";
        }
        if(sol.isChecked()){
            total = total + "En Soles: " + (float)(valMonto / valSol)+"\n";
        }
        if(real.isChecked()){
            total = total + "En Reales: " + (float)(valMonto / valReal)+"\n";
        }
        if(pChile.isChecked()){
            total = total + "En pesos Chilenos: " + (float)(valMonto / valChile)+"\n";
        }
        if(pColombia.isChecked()){
            total = total + "En pesos Colombianos: " + (float)(valMonto / valColombia)+"\n";
        }
        if(bolivar.isChecked()){
            total = total + "En Bolivares: " + (float)(valMonto / valBolivar)+"\n";
        }
        if(yen.isChecked()){
            total = total + "En Yenes: " + (float)(valMonto / valYen)+"\n";
        }
        resultado(total);
    }

    /*
    * Este metodo envia el resutado final */
    public void resultado(String total){
        textTotal.setText(total);
    }
}

package com.example.android.conversordemoneda;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText monto;
    CheckBox dolar, euro, sol, real, pChile, pColombia, boliviano, yen;
    TextView textTotal;
    Spinner spinner;
    double valDolar=1, valEuro=1, valSol=1, valReal=1, valChile=1, valColombia=1, valBolivia=1, valYen=1;


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
        boliviano = (CheckBox) findViewById(R.id.check_bolivia);
        yen = (CheckBox) findViewById(R.id.check_yenes);
        spinner = (Spinner) findViewById(R.id.spinner_moneda);
        String [] opciones = {"Dolar", "Euro", "Sol", "Real", "Peso Chile", "Peso Colombia", "Boliviano", "Yen"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);
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
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent i = new Intent(this,SegundaActivity.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    * Este metodo escoje de que moneda a que moneda convertir*/

    public void convertir (View view){
        String selec = spinner.getSelectedItem().toString();
        if(selec.equals("Dolar")){
            valDolar = 1; valEuro = 0.89; valSol = 3.31; valReal = 3.55; valChile = 672.51; valColombia = 2.949; valBolivia = 6.95; valYen = 110.51;
        }
        if(selec.equals("Euro")){
            valDolar = 1.13; valEuro = 1; valSol = 3.73; valReal = 4.00; valChile = 757.84; valColombia = 3.323; valBolivia = 8.00; valYen = 124.53;
        }
        if(selec.equals("Sol")){
            valDolar = 0.30; valEuro = 0.27; valSol = 1; valReal = 1.07; valChile = 203.03; valColombia = 890.50; valBolivia = 2.14; valYen = 33.36;
        }
        if(selec.equals("Real")){
            valDolar = 0.28; valEuro = 0.25; valSol =  0.93; valReal = 1; valChile = 189.36; valColombia = 830.54; valBolivia = 2.00; valYen = 31.12;
        }
        if(selec.equals("Peso Chile")){
            valDolar = 0.001487; valEuro = 0.001320; valSol = 0.004925; valReal = 0.005281; valChile = 1; valColombia = 4.39; valBolivia = 0.01; valYen = 0.16;
        }
        if(selec.equals("Peso Colombia")){
            valDolar = 0.000339; valEuro = 0.000301; valSol = 0.001123; valReal = 0.001204; valChile = 0.23; valColombia = 1; valBolivia = 0.002406; valYen = 0.04;
        }
        if(selec.equals("Boliviano")){
            valDolar = 6.95; valEuro = 7.83; valSol = 2.09; valReal = 1.99; valChile = 0.01; valColombia = 0.002318; valBolivia = 1; valYen = 0.06;
        }
        if(selec.equals("Yen")){
            valDolar = 0.009049; valEuro = 0.008030; valSol = 0.03; valReal = 0.03; valChile = 6.09; valColombia = 26.69; valBolivia = 0.06; valYen = 1;
        }
        calcular();
    }
    /*
    * Este metodo convertira el monto en Bs a las diferentes monedas*/
    public void calcular(){
        if(!monto.getText().toString().equals("")){
        double valMonto = Double.parseDouble(monto.getText().toString());
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
        if(boliviano.isChecked()){
            total = total + "En Bolivianos: " + (float)(valMonto / valBolivia)+"\n";
        }
        if(yen.isChecked()){
            total = total + "En Yenes: " + (float)(valMonto / valYen)+"\n";
        }
        resultado(total);
        }else{
            Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    * Este metodo envia el resutado final */

    public void resultado(String total){
        textTotal.setText(total);
    }
}

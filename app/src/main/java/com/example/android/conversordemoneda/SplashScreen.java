package com.example.android.conversordemoneda;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       Thread timerTread = new Thread(){
           public void run(){
               try{
                   sleep(2000);
               }
               catch (InterruptedException e){
                   e.printStackTrace();
               } finally {
                   Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                   startActivity(intent);
               }
           }
       };
       timerTread.start();
   }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
}

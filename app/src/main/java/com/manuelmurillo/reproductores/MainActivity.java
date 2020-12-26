package com.manuelmurillo.reproductores;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SoundPool variablesoundpool1;
    SoundPool variablesoundpool2;
    int i, j;

    float valorvolumen;


    MediaPlayer variablemediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // instanciamos la variable, indicando parámetros
        variablesoundpool1 = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        i = variablesoundpool1.load(this, R.raw.blade, 1);
        variablesoundpool2 = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        j = variablesoundpool2.load(this, R.raw.arandela, 1);
        valorvolumen = 0.0f;

    }

    public void funcionsoundpool1(View view) {

        variablesoundpool1.play(i, 1.0f, 1.0f, 1, 1, 1);
        Toast.makeText(this, "Reproduciendo", Toast.LENGTH_SHORT).show();

    }

    public void funcionsoundpool2(View view) {
        variablesoundpool2.play(j, 1.0f, 1.0f, 1, 3, 1);
        Toast.makeText(this, "Reproduciendo", Toast.LENGTH_SHORT).show();
    }

    public void funcionprepared(View view) {
        variablemediaplayer = MediaPlayer.create(this, R.raw.blade);
    }

    // verificamos que no la variable no esté vacía
    public void funcionstartpause(View view) {
       if(variablemediaplayer==null) Toast.makeText(this, "Cargue una cancion", Toast.LENGTH_SHORT).show();
       else {
           if (variablemediaplayer.isPlaying() == true) {
               Toast.makeText(this, "Procedemos apausar", Toast.LENGTH_SHORT).show();
               variablemediaplayer.pause();
           } else {
               Toast.makeText(this, "Procedemos a continuar", Toast.LENGTH_SHORT).show();
               variablemediaplayer.start();

           }
       }
    }

    public void funcionstop(View view) {
        // Si detenemos la canción, no podremos elegir Strat, puesto que la variable se encuentra vacia
        // y no tenemos acceso directo a start ni a pause

        if(variablemediaplayer!=null)
        {
            variablemediaplayer.stop();
        Toast.makeText(this, "Detenida", Toast.LENGTH_SHORT).show();
        variablemediaplayer.release();
        variablemediaplayer=null;
        }
    }

    public void funcionvolumen(View view) {
        valorvolumen +=0.1;
        variablemediaplayer.setVolume(valorvolumen, valorvolumen);
        Toast.makeText(this, "Nuevo volumen: "+valorvolumen, Toast.LENGTH_SHORT).show();

    }

    public void funcionduracion(View view) {
        int duracion;
        duracion = variablemediaplayer.getDuration();
        Log.i("miapp", "Duración en milisengundo: "+ duracion);
        Log.i("miapp", "Posicion actual: "+variablemediaplayer.getCurrentPosition());
    }

    public void funcionposicion(View view) {
        variablemediaplayer.seekTo(2000);
    }
}

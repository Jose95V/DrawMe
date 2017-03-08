package com.example.josedanilo.drawme;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //colores
    ImageButton negro;
    ImageButton blanco;
    ImageButton verde;
    ImageButton azul;
    ImageButton rojo;
    ImageButton amarillo;
    ImageButton marron;
    ImageButton gris;
    ImageButton naranja;
    ImageButton morado;
    ImageButton azulclaro;
    ImageButton acua;
    ImageButton fusia;
    ImageButton verdeclaro;
    ImageButton rosado;
    ImageButton naranjaoscuro;
    ImageButton rosadoclaro;
    ImageButton rojoclaro;
    ImageButton blanquito;
    ImageButton azuloscuro;

    private static Lienzo lienzo;

    //botones de accion
    ImageButton nuevo;
    ImageButton trazo;
    ImageButton borrar;
    ImageButton guardar;
    ImageButton salir;

    //tamaños de pincel
    float ppequeno;
    float pmediano;
    float pgrande;
    float pdefecto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //enlazando colores
        negro = (ImageButton) findViewById(R.id.colornegro);
        blanco = (ImageButton) findViewById(R.id.colorblanco);
        verde = (ImageButton) findViewById(R.id.colorverde);
        azul = (ImageButton) findViewById(R.id.colorazul);
        rojo = (ImageButton) findViewById(R.id.colorrojo);
        amarillo = (ImageButton) findViewById(R.id.coloramarillo);
        marron = (ImageButton) findViewById(R.id.colormarron);
        gris = (ImageButton) findViewById(R.id.colorgris);
        naranja = (ImageButton) findViewById(R.id.colornaranja);
        morado = (ImageButton) findViewById(R.id.colormorado);

        //mas gama de colores- mas_colores xml
        azulclaro = (ImageButton) findViewById(R.id.colorazulclaro);
        acua = (ImageButton) findViewById(R.id.coloracua);
        fusia = (ImageButton) findViewById(R.id.colorfusia);
        verdeclaro = (ImageButton) findViewById(R.id.colorverdeclaro);
        rosado = (ImageButton) findViewById(R.id.colorrosado);
        naranjaoscuro = (ImageButton) findViewById(R.id.colornaranjaosc);
        rosadoclaro = (ImageButton) findViewById(R.id.colorrosadoclaro);
        rojoclaro = (ImageButton) findViewById(R.id.colorrojoclaro);
        blanquito = (ImageButton) findViewById(R.id.colorblanquito);
        azuloscuro = (ImageButton) findViewById(R.id.colorazuloscuro);

        //enlazando botones de accion
        nuevo = (ImageButton) findViewById(R.id.nuevo);
        trazo = (ImageButton) findViewById(R.id.trazo);
        borrar = (ImageButton) findViewById(R.id.borrar);
        guardar = (ImageButton) findViewById(R.id.guardar);
        salir = (ImageButton) findViewById(R.id.salir);

        //Listenes botones de colores
        negro.setOnClickListener(this);
        blanco.setOnClickListener(this);
        verde.setOnClickListener(this);
        azul.setOnClickListener(this);
        rojo.setOnClickListener(this);
        amarillo.setOnClickListener(this);
        marron.setOnClickListener(this);
        gris.setOnClickListener(this);
        naranja.setOnClickListener(this);
        morado.setOnClickListener(this);
        //mas_colores
        azulclaro.setOnClickListener(this);
        acua.setOnClickListener(this);
        fusia.setOnClickListener(this);
        verdeclaro.setOnClickListener(this);
        rosado.setOnClickListener(this);
        naranjaoscuro.setOnClickListener(this);
        rosadoclaro.setOnClickListener(this);
        rojoclaro.setOnClickListener(this);
        blanquito.setOnClickListener(this);
        azuloscuro.setOnClickListener(this);
        //Listenes botones de accion
        nuevo.setOnClickListener(this);
        trazo.setOnClickListener(this);
        borrar.setOnClickListener(this);
        guardar.setOnClickListener(this);
        salir.setOnClickListener(this);


        lienzo = (Lienzo) findViewById(R.id.lienzo);

        //inicializando pinceles
        ppequeno = 10;
        pmediano = 20;
        pgrande = 30;
        pdefecto = pmediano;

    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder myBuild = new AlertDialog.Builder(this);
        myBuild.setMessage("DrawMe");
        myBuild.setMessage("Desea salir de la aplicacion");

        myBuild.setPositiveButton("Si", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        myBuild.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        AlertDialog dialog = myBuild.create();
        dialog.show();
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

    @Override
    public void onClick(View v) {

        String color = null ;

        switch (v.getId()){

            case R.id.colornegro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                    break;
            case R.id.colorblanco:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorazul:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorverde:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorrojo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.coloramarillo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colormarron:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorgris:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colornaranja:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colormorado:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;

            //mas_colores
            case R.id.colorazulclaro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.coloracua:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorfusia:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorverdeclaro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorrosado:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colornaranjaosc:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorrosadoclaro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorrojoclaro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorblanquito:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorazuloscuro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;

            //botones de accion
            case R.id.nuevo:

                break;

            case R.id.trazo:

                final Dialog tamanopunto = new Dialog(this);
                tamanopunto.setTitle(" Tamaño del punto: ");
                tamanopunto.setContentView(R.layout.tamano_punto);

                //LIsten for click on  tamaños de los botones

                RadioButton smallBtn = (RadioButton) tamanopunto.findViewById(R.id.tpequeno);
                smallBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(ppequeno);

                        tamanopunto.dismiss();
                    }
                });
                RadioButton mediumBtn = (RadioButton) tamanopunto.findViewById(R.id.tmediano);
                mediumBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(pmediano);

                        tamanopunto.dismiss();
                    }
                });
                RadioButton largeBtn = (RadioButton) tamanopunto.findViewById(R.id.tgrande);
                largeBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanoPunto(pgrande);

                        tamanopunto.dismiss();
                    }
                });

                tamanopunto.show();

                break;

            case R.id.borrar:

                final Dialog borrarpunto = new Dialog(this);
                borrarpunto.setTitle(" Tamaño del borrador: ");
                borrarpunto.setContentView(R.layout.borrar_punto);

                //LIsten for click on  tamaños de los botones

                RadioButton smallBtnborrar = (RadioButton) borrarpunto.findViewById(R.id.tpequeno);
                smallBtnborrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(ppequeno);

                        borrarpunto.dismiss();
                    }
                });
                RadioButton mediumBtnborrar = (RadioButton) borrarpunto.findViewById(R.id.tmediano);
                mediumBtnborrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(pmediano);

                        borrarpunto.dismiss();
                    }
                });
                RadioButton largeBtnborrar = (RadioButton) borrarpunto.findViewById(R.id.tgrande);
                largeBtnborrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(true);
                        Lienzo.setTamanoPunto(pgrande);

                        borrarpunto.dismiss();
                    }
                });
                RadioButton Btnborrar = (RadioButton) borrarpunto.findViewById(R.id.tborrar);
                Btnborrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        Lienzo.setBorrado(true);
                        lienzo.NuevoDibujo();

                        borrarpunto.dismiss();
                    }
                });

                borrarpunto.show();

                break;

            case R.id.guardar:

                break;

            case R.id.salir:

                onBackPressed();

                break;

            default:

                break;

        }

    }
}

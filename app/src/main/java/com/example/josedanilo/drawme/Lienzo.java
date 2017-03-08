package com.example.josedanilo.drawme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Jose Danilo on 04/03/2017.
 */

public class Lienzo extends View {


    private Path drawPath; // se utiliza para ir pintando las lineas
    private static Paint drawPaint;  // paint dibujar y paint canvas
    private  Paint canvasPaint;
    private static int paintColor = 0xFF000000; //color inicial
    private Canvas drawCanvas; //canvas
    private Bitmap canvasBitmap; //canvas para guardar

     static float TamanoPunto;
    private static boolean borrado = false;

    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();


    }

    private void setupDrawing() {

// configuracion de el area a pintar

        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);



        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    //Tamaño asignado a la vista
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
            super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);

    }

    //Pinta la vista, este sera llamado desde el onTouchEvent
    @Override
    protected void onDraw(Canvas canvas){

        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);
        canvas.drawPath(drawPath,drawPaint);
    }


    //Registra los Touch del usuario

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawPath.lineTo(touchX, touchY);
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;

            default:
                return false;
        }

        //repintar
        invalidate();
        return true;
    }

    //Actualiza el color
    public  void  setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);
    }

    //seleccionar tamaño del punto

    public static void setTamanoPunto(float nuevoTamano){

        drawPaint.setStrokeWidth(nuevoTamano);


    }
        //set borrado true or false
    public static void setBorrado(boolean estaborrado){

        borrado = estaborrado;
        if(borrado) {
            drawPaint.setColor(Color.WHITE);
            //drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        else {
            drawPaint.setColor(paintColor);
            //drawPaint.setXfermode(null);
        }
    }

    public void NuevoDibujo(){

        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

}


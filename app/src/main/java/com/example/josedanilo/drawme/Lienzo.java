package com.example.josedanilo.drawme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jose Danilo on 04/03/2017.
 */

public class Lienzo extends View {


    private Path drawPath; // se utiliza para ir pintando las lineas
    private Paint drawPaint, canvasPaint; // paint dibujar y paint canvas
    private int paintColor = 0xFF000000; //color inicial
    private Canvas drawCanvas; //canvas
    private Bitmap canvasBitmap; //canvas para guardar

    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    private void setupDrawing(){

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
}

package com.liquid.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * Created by neroshank on 8/19/2014.
 /**
*
* @author neroshan kalhara abeywickrama gunaratne
* email : gnerosh@gmail.com
*/
public class ParticlesHandler extends Drawable{

    public int width=30;
    public int height=30;
    public int top=0;
    public int left=0;
    
    public Bitmap bitmap;
    
    public Particle[] particles;
    public int h;
    
    public ParticlesHandler(Particle[] particles){
    	this.particles=particles;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint=new Paint();
        //paint.setColor(Color.CYAN);
        paint.setAntiAlias(true);

        //canvas.drawRect(left,top,(left+width),(top+height),paint);
        
        for(Particle particle : particles){
        	paint.setColor(particle.color);
        	//canvas.drawCircle(particle.left, particle.top, particle.width, paint);
        	canvas.drawRect(particle.left,particle.top,(particle.left+particle.width),(particle.top+particle.height),paint);
//        		canvas.rotate(15,(700)/2,(h)/2);
        	//Matrix matrix=new Matrix();
        	//matrix.setRotate(30);
        	//matrix.setScale((1*particle.width)/64, (1*particle.height)/64);
        	//canvas.drawBitmap(bitmap, matrix, paint);
        	//canvas.save();
        	//canvas.restore();
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 1;
    }
}

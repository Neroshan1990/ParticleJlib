package com.liquid.display;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.liquid.core.Particle;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

public class ParticlesGLsurfaceView extends GLSurfaceView{
	
	public int width;
	public int height;
	public Particle[] particles;

	public ParticlesGLsurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setRenderer(new ParticleRenderer());
	}
	
	public class ParticleRenderer implements GLSurfaceView.Renderer{

		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		}

		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
			
		}

		@Override
		public void onDrawFrame(GL10 gl) {
			GLES20.glViewport(0, 0, width, height);
			
		}
		
	}

}

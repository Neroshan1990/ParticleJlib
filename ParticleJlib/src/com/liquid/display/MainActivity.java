package com.liquid.display;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liquid.core.MotionPhyx;
import com.liquid.core.Particle;
import com.liquid.core.ParticlesHandler;

import java.text.DecimalFormat;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

	private final int NUMBER_OF_CORES = 1;
	// Runtime.getRuntime().availableProcessors();

	private EditText txtGravity;
	private EditText txtImapct;
	private EditText txtUy;
	private EditText txtUx;
	private EditText txtSx;
	private EditText txtSy;
	private Button gravity;
	private Button startAnim;
	// private Object object=new Object();
	private Thread[] particleThread;
	private Particle[] particles;

	private ThreadPoolExecutor tPoolExecutor;
	private LinkedBlockingQueue<Runnable> queueRunnables;
	
	private boolean collutionEnable=false;
	private Button switchCollution;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtGravity = (EditText) findViewById(R.id.editText);
		txtImapct = (EditText) findViewById(R.id.editText2);
		txtUx = (EditText) findViewById(R.id.editText4);
		txtUy = (EditText) findViewById(R.id.editText3);
		txtSx = (EditText) findViewById(R.id.editText6);
		txtSy = (EditText) findViewById(R.id.editText5);
		switchCollution = (Button) findViewById(R.id.button1);
		startAnim = (Button) findViewById(R.id.button2);
		txtGravity.setText("" + MotionPhyx.g);
		txtImapct.setText("" + impactRatio);
		txtUx.setText("" + ux);
		txtUy.setText("" + u);
		txtSx.setText("" + sx);
		txtSy.setText("" + s);

		queueRunnables = new LinkedBlockingQueue<Runnable>();
		tPoolExecutor = new ThreadPoolExecutor(NUMBER_OF_CORES,
				NUMBER_OF_CORES, 1, TimeUnit.SECONDS, queueRunnables);
		startAnim.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v1) {
				// TODO Neroshank IF HANDLE WITH
				// synchronized (object) {
				// object.notify();
				// }
				initiateAnim();

			}
		});
		switchCollution.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(collutionEnable){
					collutionEnable=false;
				}else{
					collutionEnable=true;
				}
				
			}
		});

	}

	private void intiateParticles() {
		particles = new Particle[24];
		particles[0] = new Particle(0, 0, 0, 0, t, h,0,2, 0, 600, 0,
				Color.CYAN);
		particles[1] = new Particle(0, 0, 0, 0, t, h, 0, 1, 0, 200, 0,
				Color.BLUE);
		particles[2] = new Particle(0, 0, 0, 0, t, h, 3, 1, 0, 500, 0,
				Color.DKGRAY);
		particles[3] = new Particle(0, 0, 0, 0, t, h, -10, 5, 0, 100, 0,
				Color.GRAY);
		particles[4] = new Particle(0, 0, 0, 0, t, h, -8, 3, 0, 160, 300,
				Color.GREEN);
		particles[5] = new Particle(0, 0, 0, 0, t, h, -15, 18, 0, 300, 0,
				Color.LTGRAY);
		particles[6] = new Particle(0, 0, 0, 0, t, h, 5, 5, 0, 500, 200,
				Color.MAGENTA);
		particles[7] = new Particle(0, 0, 0, 0, t, h, 2.8, 3, 0, 500, 300,
				Color.RED);
		particles[8] = new Particle(0, 0, 0, 0, t, h, 3, 1, 0, 500, 100,
				Color.WHITE);
		particles[9] = new Particle(0, 0, 0, 0, t, h, -10, -5, 0, 500, 360,
				Color.YELLOW);
		particles[10] = new Particle(0, 0, 0, 0, t, h, -8, -3, 0, 200, 100,
				Color.CYAN);
		particles[11] = new Particle(0, 0, 0, 0, t, h, -15, 6, 0, 160, 160,
				Color.MAGENTA);
		
		
		
		particles[12] = new Particle(0, 0, 0, 0, t, h, 3.6, 1, 0, 400, 0,
				Color.CYAN);
		particles[13] = new Particle(0, 0, 0, 0, t, h, 4.8, 2, 0, 300, 0,
				Color.BLUE);
		particles[14] = new Particle(0, 0, 0, 0, t, h, 2, 1, 0, 600, 0,
				Color.DKGRAY);
		particles[15] = new Particle(0, 0, 0, 0, t, h, -11, 7, 0, 0, 0,
				Color.GRAY);
		particles[16] = new Particle(0, 0, 0, 0, t, h, -9, 4, 0, 0, 0,
				Color.GREEN);
		particles[17] = new Particle(0, 0, 0, 0, t, h, -20, 19, 0, 0, 0,
				Color.LTGRAY);
		particles[18] = new Particle(0, 0, 0, 0, t, h, 7, 7, 0, 400, 500,
				Color.MAGENTA);
		particles[19] = new Particle(0, 0, 0, 0, t, h, 7.8, 5, 0, 100, 600,
				Color.RED);
		particles[20] = new Particle(0, 0, 0, 0, t, h, 5, 2, 0, 600, 100,
				Color.WHITE);
		particles[21] = new Particle(0, 0, 0, 0, t, h, -14, -3, 0, 0, 50,
				Color.YELLOW);
		particles[22] = new Particle(0, 0, 0, 0, t, h, -8, -3, 0, 100, 0,
				Color.CYAN);
		particles[23] = new Particle(0, 0, 0, 0, t, h, -13, 8, 0, 0, 180,
				Color.MAGENTA);
//		int c=0;
//		for(Particle particle :particles){
//			double tu=0;
//			double tux=0;
//			if(particle.u<0)
//				tu=(-1)*particle.u;
//			else
//				tu=particle.u;
//			
//			if(particle.ux<0)
//				tux=(-1)*particle.ux;
//			else
//				tux=particle.ux;
//			
//			particle.totXYspeed=tu+tux;
//			if(flasher==null){
//				flasher=particle;
//			}
//		    if(flasher.totXYspeed<=particle.totXYspeed){
//				particles[0]=particle;	
//				particles[c]=flasher;
//				flasher=particle;					
//			}
//			
//			c++;
//		}

	}
	
	private void initiateTimeCluster(){
		tCluster=(0.05/24)*particles.length;
		//tCluster=validateDoublePrecision(tCluster);
	}

	private void initiateAnim() {
		System.gc();
		double gt = Double.parseDouble(txtGravity.getText().toString());

		MotionPhyx.g = gt;
		resetEnviroment();

		Runnable[] runnables = new Runnable[queueRunnables.size()];
		// Runnable[] runnables=new Runnable[1];
		queueRunnables.toArray(runnables);

		 for(Runnable runnable : runnables){
			 Thread thread=((ParticleService)runnable).mThread;
			 if(thread!=null && thread.isAlive())
				 thread.interrupt();
		
		 }
		queueRunnables.clear();
		// for(Particle particle : particles){
		// ParticleService particleService=new ParticleService(particle);
		// queueRunnables.add(particleService);
		// }
		ParticleService particleService = new ParticleService(particles);
		queueRunnables.add(particleService);

		tPoolExecutor.prestartAllCoreThreads();

	}

	private void resetEnviroment() {
		try {
			for (Particle particle : particles) {
				particle.s = particle.reset_s;// Double.parseDouble(txtSy.getText().toString());
				particle.u =  Double.parseDouble(txtUy.getText().toString());
				particle.v = 0;
				particle.sx = particle.reset_sx;// Double.parseDouble(txtSx.getText().toString());
				particle.ux =  Double.parseDouble(txtUx.getText().toString());
				particle.impactSpeed = 0;
				particle.impactSpeedRoad = 0;
				particle.impactRatio = Double.parseDouble(txtImapct.getText()
						.toString());
				particle.statusInitialize=1;
				particle.status=1;
				//calculateMinimumImapctSpeed(particle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private double collutionOutForceSpeed(double force) {
		double u = MotionPhyx.impactReactionPhysx((force / impactDivider), m, (0),
				-1, t, false);
		return u;
	}

	private long waitScreen = 1000;
	private double u;
	private double ux;
	private double v;
	private double s;
	private double sx = 0;
	private double t = 1;
	private double h;
	private double impactRatio = 0.8;
	private double initForceAngle = (40);
	
	private Particle flasher;
	private double timeX=1;
	private double timeY=1;
	private double tCluster=0.5;

	private double validateDoublePrecision(double val) {
		DecimalFormat decimalFormat = new DecimalFormat("0.0000##");
		String valS = "" + val;
		if (valS.contains("E-")) {
			valS = valS.replace("E-", "");
			val = Double.parseDouble(valS);
			val = Double.parseDouble(decimalFormat.format(val));
		}
		return val;
	}

	class ParticleService implements Runnable {

		private Particle[] particles;
		public Thread mThread;

		public ParticleService(Particle particle) {
			particles = new Particle[1];
			particles[0] = particle;

		}

		public ParticleService(Particle[] particles) {
			this.particles = particles;
		}

		@Override
		public void run() {
			mThread = Thread.currentThread();

			//float[] xyForce = MotionPhyx.axisForce(initForceAngle, 50);
			int statuses = 1;
			while (statuses > 0) {
				//for(double it=tCluster;it<(1+tCluster);it+=tCluster){
			    //t=tCluster;
				statuses = 0;
				//int c=0;
				for (Particle particle : particles) {
					if (particle.statusInitialize == 1) {
						if (particle.u <= 0)
							particle.travelType = TRAVEL_DOWN;
						else
							particle.travelType = TRAVEL_UP;
						if (particle.ux >= 0)
							particle.travelTypeRoad = TRAVEL_RIGHT;
						else
							particle.travelTypeRoad = TRAVEL_LEFT;

						particle.statusInitialize = 0;
					}
					// Log.d("TTTTT","u="+u+" ux="+ux);

					if ((travellingDistance(particle) || travellingDistanceRoad(particle))
							&& particle.status > 0) {
						try {

						   
							boolean collide=false;
							if(collutionEnable){
							for(Particle particleCollution : particles){
								if(particleCollution == particle){
									continue;
								}
								boolean tLeft=((particle.s+particle.height)>=particleCollution.s && (particle.sx+particle.width)>=particleCollution.sx && particle.sx<=particleCollution.sx && particle.s<=particleCollution.s);
								boolean dLeft=((particle.s+particle.height)>=(particleCollution.s+particleCollution.height) && (particle.sx+particle.width)>=particleCollution.sx && particle.sx<=particleCollution.sx && particle.s<=(particleCollution.s+particleCollution.height));
								boolean tRight=((particle.s+particle.height)>=(particleCollution.s) && (particle.sx+particle.width)>=(particleCollution.sx+particleCollution.width) && particle.sx<=(particleCollution.sx+particleCollution.width) && particle.s<=(particleCollution.s));
								boolean dRight=((particle.s+particle.height)>=(particleCollution.s+particleCollution.height) && (particle.sx+particle.width)>=(particleCollution.sx+particleCollution.width) && particle.sx<=(particleCollution.sx+particleCollution.width) && particle.s<=(particleCollution.s+particleCollution.height));
								
						        if(tLeft ||
						           dLeft || 
						           tRight ||
						           dRight 
						          	   
						         ){
						        	
						        	collide=true;
						        	double dueY=0;
									double dueX=0;
									
						        	double xMatter=0;
						        	double yMatter=0;
						        	
						        	boolean specialCaseY=false;
						        	boolean specialCaseX=false;
						        	if(tLeft){
						        		xMatter=particleCollution.sx;
						        	    yMatter=particleCollution.s;
						        	    dueY=(particle.s+particle.height)-yMatter;
						        	    dueX=(particle.sx+particle.width)-xMatter;
						        	 
						        	}
						        	if(dLeft){
						        		xMatter=particleCollution.sx;
						        	    yMatter=particleCollution.s+particleCollution.height;						        	 
						        	    dueX=(particle.sx+particle.width)-xMatter;
						        	    dueY=yMatter-particle.s;
						        	}
						        	if(tRight){
						        		xMatter=particleCollution.sx+particleCollution.width;
						        	    yMatter=particleCollution.s;
						        	    dueY=(particle.s+particle.height)-yMatter;						        	    
						        	    dueX=xMatter-particle.sx;
						        	}
						        	if(dRight){
						        		xMatter=particleCollution.sx+particleCollution.width;
						        	    yMatter=particleCollution.s+particleCollution.height;
						        	    dueY=yMatter-particle.s;
						        	    dueX=xMatter-particle.sx;
						        	}
						        	//TODO neroshank speicalcases
//						        	 if((tLeft && dLeft) || (tLeft && tRight) || (tRight && dRight) || (dLeft && dRight)){
//							        	 if(dueY==0 || dueY==particle.height){
//							        	    	specialCaseY=true;
//							        	 }
//							        	 if(dueX==0 || dueX==particle.width){
//							        	    	specialCaseX=true;
//							        	 }
//						            }

						        	
										boolean directionSpeed=false;
																	
										double dueYZero=(yMatter)-particle.s;
										double dueXZero=(xMatter)-particle.sx;
										
//										if((tLeft) || (dLeft && particleCollution.sx>particlePiviotX) || 
//										    (tRight && particleCollution.s>particlePiviotY)){
//											dueY=(particle.s+particle.height)-yMatter;
//											dueX=(particle.sx+particle.width)-xMatter;
//										}
//										if((tRight && (particleCollution.sx+particleCollution.width)<particlePiviotX) || (dRight) || (dLeft && (particleCollution.s+particleCollution.height)<particlePiviotY)){
//											dueY=(yMatter)-particle.s;
//											dueX=(xMatter)-particle.sx;
//										}
										
										//TODO neroshank
										double relativeSpeedX=0;
										if(particle.travelTypeRoad!=particleCollution.travelTypeRoad){
											relativeSpeedX=particle.ux+particleCollution.ux;
										}else{
											relativeSpeedX=particle.ux-particleCollution.ux;
										}
										double impactRelativePC = MotionPhyx.impactPhysx2(-1, particleCollution.m,
												relativeSpeedX, particleCollution.sh);
										
										
										double relativeSpeedY=0;
										if(particle.travelType!=particleCollution.travelType){
											relativeSpeedY=particle.u+particleCollution.u;
										}else{
											relativeSpeedY=particle.u-particleCollution.u;
										}
										double impactRelativeYPC = MotionPhyx.impactPhysx2(-1, particleCollution.m,
												relativeSpeedY, particleCollution.sh);
										
										
										
										if(particle.travelTypeRoad!=particleCollution.travelTypeRoad){
											relativeSpeedX=particleCollution.ux+particle.ux;
										}else{
											relativeSpeedX=particleCollution.ux-particle.ux;
										}
										double impactRelativeP = MotionPhyx.impactPhysx2(-1, particleCollution.m,
												relativeSpeedX, particleCollution.sh);
										
										
										
										if(particle.travelType!=particleCollution.travelType){
											relativeSpeedY=particleCollution.u+particle.u;
										}else{
											relativeSpeedY=particleCollution.u-particle.u;
										}
										double impactRelativeYP = MotionPhyx.impactPhysx2(-1, particleCollution.m,
												relativeSpeedY, particleCollution.sh);
										
										int particleTravelRoadRelative=-1;
										int particleCollutionTravelRoadRelative=-1;
										
										int particleTravelRelative=-1;
										int particleCollutionTravelRelative=-1;

										if((dueY>=dueX  && dueY>=0 && dueX>=0) || specialCaseY ){
											//Log.d("TTE", ""+3);
											//right collution
											//TODO neroshank
											if(((particle.sx+particle.width)/2)<xMatter){
												particleTravelRoadRelative=TRAVEL_RIGHT;
												particleCollutionTravelRoadRelative=TRAVEL_LEFT;
											}
											//left collution
											if(((particle.sx+particle.width)/2)>xMatter){
												particleTravelRoadRelative=TRAVEL_LEFT;
												particleCollutionTravelRoadRelative=TRAVEL_RIGHT;
											}
											
											if(particle.travelTypeRoad==particleTravelRoadRelative){
												directionSpeed=true;
											}else{
												directionSpeed=false;
											}
																					
											particle.ux = MotionPhyx.impactReactionPhysx(
													(impactRelativeP / impactDivider), particle.m,
													(particle.ux * particle.impactRatio), -1, 1, directionSpeed);
											particle.travelTypeRoad=particleTravelRoadRelative;
											if(particle.ux>0){
												particle.travelTypeRoad=TRAVEL_RIGHT;
											}else{
												particle.travelTypeRoad=TRAVEL_LEFT;
											}
											//TODO neroshank
//											if(particle.ux>0){
//											    if(particleTravelRoadRelative==TRAVEL_RIGHT)particle.ux*=-1;
//										    }else{
//										    	if(particleTravelRoadRelative==TRAVEL_LEFT)particle.ux*=-1;
//										    }
											
											if(particleCollution.travelTypeRoad==particleCollutionTravelRoadRelative){
												directionSpeed=true;
											}else{
												directionSpeed=false;
											}
											
//											if(particle.travelTypeRoad==particleCollution.travelTypeRoad)
//												impactRelative*=-1;
											
											particleCollution.ux = MotionPhyx.impactReactionPhysx(
													(impactRelativePC / impactDivider), particle.m,
													(particleCollution.ux * particle.impactRatio), -1, 1, directionSpeed);
											particleCollution.travelTypeRoad=particleCollutionTravelRoadRelative;
											if(particleCollution.ux>0){
												particleCollution.travelTypeRoad=TRAVEL_RIGHT;
											}else{
												particleCollution.travelTypeRoad=TRAVEL_LEFT;
											}
											//TODO neroshank
//											if(particleCollution.ux>0){
//											    if(particleCollutionTravelRoadRelative==TRAVEL_RIGHT)particleCollution.ux*=-1;
//										    }else{
//										    	if(particleCollutionTravelRoadRelative==TRAVEL_LEFT)particleCollution.ux*=-1;
//										    }
											//TODO Test purpose
											//particle.ux*=-(0.99);
											//particleCollution.ux*=-(0.99);
										} if((dueY<=dueX && dueY>=0 && dueX>=0) || specialCaseX ){
											//Log.d("TTE", ""+4);
											//TODO neroshank
											if(((particle.s+particle.height)/2)<yMatter){
												particleTravelRelative=TRAVEL_UP;
												particleCollutionTravelRelative=TRAVEL_DOWN;
											}
											//down collution
											if(((particle.s+particle.height)/2)>yMatter){
												particleTravelRelative=TRAVEL_DOWN;
												particleCollutionTravelRelative=TRAVEL_UP;
											}
											
											if(particle.travelType==particleTravelRelative){
												directionSpeed=true;
											}else{
												directionSpeed=false;
											}
																					
											particle.u = MotionPhyx.impactReactionPhysx(
													(impactRelativeYP / impactDivider), particle.m,
													(particle.u * particle.impactRatio), -1, 1, directionSpeed);
											particle.travelType=particleTravelRelative;
											if(particle.u>0){
												particle.travelType=TRAVEL_UP;
											}else{
												particle.travelType=TRAVEL_DOWN;
											}
											//TODO neroshank
//											 if(particle.u>0){
//													if(particleTravelRelative==TRAVEL_UP)particle.u*=-1;
//												}else{
//													if(particleTravelRelative==TRAVEL_DOWN)particle.u*=-1;
//												}
											
											if(particleCollution.travelType==particleCollutionTravelRelative){
												directionSpeed=true;
											}else{
												directionSpeed=false;
											}
											
//											if(particle.travelType==particleCollution.travelType)
//												impactRelativeY*=-1;
																					
											particleCollution.u = MotionPhyx.impactReactionPhysx(
													(impactRelativeYPC / impactDivider), particle.m,
													(particleCollution.u * particle.impactRatio), -1, 1, directionSpeed);
											particleCollution.travelType=particleCollutionTravelRelative;
											if(particleCollution.u>0){
												particleCollution.travelType=TRAVEL_UP;
											}else{
												particleCollution.travelType=TRAVEL_DOWN;
											}
										//TODO neroshank	
//									    if(particleCollution.u>0){
//											if(particleCollutionTravelRelative==TRAVEL_UP)particleCollution.u*=-1;
//										}else{
//											if(particleCollutionTravelRelative==TRAVEL_DOWN)particleCollution.u*=-1;
//										}
											//TODO Test purpose
											//particle.u*=-(0.99);
											//particleCollution.u*=-(0.99);
										}
										double dueFix=0;
										if(tLeft){
											
											if((dueY>=dueX && dueY>=0 && dueX>=0 ) || specialCaseY ){
												dueFix=(particle.sx+particle.width)-(particleCollution.sx-0);
												if(particleCollution.sx>0)
													particleCollution.sx+=dueFix;
												else
													particleCollution.sx-=dueFix;
											}
											
											if((dueY<=dueX && dueY>=0 && dueX>=0) || specialCaseX ){
												dueFix=(particle.s+particle.height)-(particleCollution.s-0);
												if(particleCollution.s>0)
													particleCollution.s+=dueFix;
												else
													particleCollution.s-=dueFix;
												
											}
											//particleCollution.s=particle.s+particle.height;
										}
										else if(tRight){
											
											if((dueY>=dueX && dueY>=0 && dueX>=0) || specialCaseY ){
												dueFix=((particleCollution.sx+particleCollution.width)-0)-(particle.sx);
												if(particleCollution.sx>0)
													particleCollution.sx-=dueFix;
												else
													particleCollution.sx+=dueFix;
											}
											
											if((dueY<=dueX && dueY>=0 && dueX>=0) || specialCaseX ){
												dueFix=(particle.s+particle.height)-(particleCollution.s-0);
												if(particleCollution.s>0)
													particleCollution.s+=dueFix;
												else
													particleCollution.s-=dueFix;
												
											}
										}
										else if(dLeft){
											
											if((dueY>=dueX && dueY>=0 && dueX>=0) || specialCaseY ){
												dueFix=(particle.sx+particle.width)-(particleCollution.sx-0);
												if(particleCollution.sx>0)
													particleCollution.sx+=dueFix;
												else
													particleCollution.sx-=dueFix;
											}
											
											if((dueY<=dueX && dueY>=0 && dueX>=0) || specialCaseX ){
												dueFix=((particleCollution.s+particleCollution.height)-0)-particle.s;
												if(particleCollution.s>0)
													particleCollution.s-=dueFix;
												else
													particleCollution.s+=dueFix;
												
											}
										}
										else if(dRight){
											
											if((dueY>=dueX && dueY>=0 && dueX>=0) || specialCaseY ){
												dueFix=((particleCollution.sx+particleCollution.width)-0)-(particle.sx);
												if(particleCollution.sx>0)
													particleCollution.sx-=dueFix;
												else
													particleCollution.sx+=dueFix;
											}
											
											if((dueY<=dueX && dueY>=0 && dueX>=0) || specialCaseX ){
												dueFix=((particleCollution.s+particleCollution.height)-0)-particle.s;
												if(particleCollution.s>0)
													particleCollution.s-=dueFix;
												else
													particleCollution.s+=dueFix;
												
											}
										}
										
										
										
										//TODO neroshank fails multiple collution detection
										//break;
						        	
							    }
//									
							}
							}
						    particle.preS=particle.s;
						    particle.preSX=particle.sx;
							particle.v = MotionPhyx.vuatPhysx(-1, particle.u,
									t, false);
							double s1 = MotionPhyx.vu2asPhysx(particle.v,
									particle.u, -1, false);
							particle.u = particle.v;
							particle.s -= s1;
							double s2 = MotionPhyx.sutaHalfat2(-1, particle.ux,
									t, true);
							particle.sx += s2;
						    //c++;
							//if(s1>=1 || s2>=1)
							//	Log.d("TTE","s1="+s1+" s2="+s2);
							//if(particle.s<0 || particle.sx<0)
							//	Log.d("TTE","s="+particle.s+" sx="+particle.sx);
							

							
							particle.top = (int) particle.s;
							particle.left = (int) particle.sx;
							travellingDistance(particle);
							travellingDistanceRoad(particle);
							
							

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					statuses += particle.status;
					
				}
				//}
				
				try {
					
				    Thread.sleep((long)t);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							view.invalidate();
						}
					});
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	

	private void initParticlesDropDown(){
		particles=new Particle[300];
		int c=0;
		for(int y=0;y<20;y++){
			for(int x=0;x<15;x++){
				//if(x!=9){
					particles[c] = new Particle(0, 0, 0, 0, t, h, (0), (0), 0, ((y*20)), ((x*20)+20),
							Color.CYAN);
					particles[c].width=20;
					particles[c].height=20;
//				}else{
//					if(c==299){
//						particles[c] = new Particle(0, 0, 0, 0, t, h, 0, 0, 0, 400, 50,
//								Color.GREEN);
//						particles[c].width=100;
//						particles[c].height=100;
//						particles[c].m=1;
//					}//else{
//						particles[c] = new Particle(0, 0, 0, 0, t, h, 0, 5, 0, ((y*5)), ((x*5)+20),
//							Color.RED);
//						particles[c].m=1;
//					}
//				}
				
				c++;
			}
		}
		
	}

	private ParticlesHandler particlesHandler;
	private TextView view;

	@Override
	protected void onPause() {
		// if(particle.isAlive())
		// particle.interrupt();
		super.onPause();
	}

	@Override
	protected void onStart() {
		h = getWindowManager().getDefaultDisplay().getHeight() - 200;
		//intiateParticles();
		initParticlesDropDown();
		//initParticleWaterFall();
		//initiateTimeCluster();
		view = (TextView) findViewById(R.id.view);
		particlesHandler = new ParticlesHandler(particles);
		//Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.uncheck);
		//particlesHandler.bitmap=bitmap;
		//particlesHandler.h=(int) h;
		view.setBackgroundDrawable(particlesHandler);

		 initiateAnim();
		super.onStart();
	}

	public static final int TRAVEL_DOWN = 0;
	public static final int TRAVEL_UP = 1;
	public static final int TRAVEL_RIGHT = 2;
	public static final int TRAVEL_LEFT = 3;

	private int travelType = TRAVEL_DOWN;
	private int travelTypeRoad = TRAVEL_RIGHT;
	private double impactSpeed;
	private double impactSpeedRoad;
	private double minimumImpactSpeed;
	private double minimumImpactSpeedRoad;
	private double sh = 1;
	private double m = 1;
	private double impactDivider=1000;//100000000

//	private void calculateMinimumImapctSpeed(Particle particle) {
//		// TODO neroshnak research further percision calculation for this
//		// minimum impact
//		double tv = MotionPhyx.vu2asPhysx(-1, 0, 1, true);
//		double tImpact = MotionPhyx.impactPhysx(-1, particle.m, 1, particle.sh);
//		particle.minimumImpactSpeed = validateDoublePrecision(MotionPhyx
//				.impactReactionPhysx((tImpact / 100000000), particle.m,
//						(tv * particle.impactRatio), -1, t, false));
//		
//		tImpact = MotionPhyx.impactPhysx2(-1, particle.m, 1, particle.sh);
//		particle.minimumImpactSpeedRoad = validateDoublePrecision(MotionPhyx
//				.impactReactionPhysx((tImpact / 100000000), particle.m,
//						(1 * particle.impactRatio), -1, 1, false));
//
//		// Log.d("TTTTTTTT",""+minimumImpactSpeed);
//	}
	//left ux(-) right ux(+)
	private boolean travellingDistanceRoad(Particle particle) {
		double d = particle.sx;
		if (d < 0)
			d *= -1;
		boolean status = false;
		switch (particle.travelTypeRoad) {
		case TRAVEL_RIGHT:
			status = (particle.sx < particle.w);
			if (!status) {

				double impact = MotionPhyx.impactPhysx2(-1, particle.m,
						particle.ux, particle.sh);
				particle.ux = MotionPhyx.impactReactionPhysx(
						(impact / impactDivider), particle.m,
						(particle.ux * particle.impactRatio), -1, 1, false);
				// ux=Double.parseDouble(String.format("%.5f",ux));
				particle.impactSpeedRoad = particle.ux;
				if (particle.ux > 0)
					particle.ux *= -1;
				// Log.d("TTI",""+u);
				particle.travelTypeRoad = TRAVEL_LEFT;
			} else if (particle.sx < particle.minw) {
				// if(v<0)
				// v*=-1;
				// s=0;
				if (particle.ux < 0)
					particle.ux *= -1;
				double impact = MotionPhyx.impactPhysx2(-1, particle.m,
						particle.ux, particle.sh);
				particle.ux = MotionPhyx.impactReactionPhysx(
						(impact / impactDivider), particle.m,
						(particle.ux * particle.impactRatio), -1, 1, false);
				// ux=Double.parseDouble(String.format("%.5f",ux));
				particle.impactSpeedRoad = particle.ux;
				particle.travelTypeRoad = TRAVEL_LEFT;
				// Log.d("TTE",""+particle.sx);
			}
			break;
		case TRAVEL_LEFT:
			status = (particle.sx > particle.minw);
			if (particle.sx < particle.w)
				particle.travelTypeRoad = TRAVEL_RIGHT;

			break;
		}
		return status;
	}
	
	//up u(+) down u(-)
	private boolean travellingDistance(Particle particle) {
		double d = particle.s;
		if (d < 0)
			d *= -1;
		boolean status = false;
		switch (particle.travelType) {
		case TRAVEL_DOWN:
			status = (particle.s < particle.h);
			if (!status) {
				particle.s=particle.h;
				if (particle.v < 0)
					particle.v *= -1;
				double impact = MotionPhyx.impactPhysx(-1, particle.m, d, 1);
				particle.u = MotionPhyx.impactReactionPhysx(
						(impact / impactDivider), particle.m,
						(particle.v * particle.impactRatio), -1, 1, false);
				particle.impactSpeed = particle.u;
				// Log.d("TTI",""+u);
				particle.travelType = TRAVEL_UP;
			} else if (particle.s < particle.minh) {
				// if(v<0)
				// v*=-1;
				// s=0;
				particle.s=0;
				double impact = MotionPhyx.impactPhysx(-1, particle.m, (d), 1);
				particle.u = MotionPhyx.impactReactionPhysx(
						(impact / impactDivider), particle.m,
						(particle.v * particle.impactRatio), -1, 1, false);

				particle.impactSpeed = particle.u;
				if (particle.u > 0)
					particle.u *= -1;
				// Log.d("TTE",""+particle.s);
			}
			break;
		case TRAVEL_UP:
			status = (particle.s > particle.minh);
			if (particle.s < particle.h || particle.s > particle.h)
				particle.travelType = TRAVEL_DOWN;
			
			if (particle.s > particle.h)
				particle.s=particle.h;
			
			break;
		}
		return status;
	}

}

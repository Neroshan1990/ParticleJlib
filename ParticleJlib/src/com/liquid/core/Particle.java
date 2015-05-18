package com.liquid.core;

import android.graphics.Color;
/**
*
* @author neroshan kalhara abeywickrama gunaratne
* email : gnerosh@gmail.com
*/
public class Particle {
	public double u;
	public double ux;
	public double v;
	public double s;
	public double sx = 0;
	public double t = 1;
	public double h;
	public double w=700;
	public double sh=1;
	public double impactRatio = 0.8;
	public double initForceAngle = (40);
	public double impactSpeed;
	public double impactSpeedRoad;
	public double m=1;
	public double minimumImpactSpeed;
	public double minimumImpactSpeedRoad;
	public double reset_u;
	public double reset_ux;
	public double reset_v;
	public double reset_s;
	public double reset_sx = 0;
	
	public double preS=0;
	public double preSX=0;

	public int width = 40;
	public int height = 40;
	public int top = 0;
	public int left = 0;
	public int color=Color.CYAN;
	
	public int travelType;
	public int travelTypeRoad;
	
	public int status=1;
	public int statusInitialize=1;
	
	public double minh=0;
	public double minw=0;
	
	public double totXYspeed;
	
	public Particle(double s,double sx,double u,double ux,double t,double h,double reset_u,double reset_ux,double reset_v,double reset_s,double reset_sx,int color){
		this.s=s;
		this.sx=sx;
		this.u=u;
		this.ux=ux;
		this.t=t;
		this.h=h;
		this.reset_u=reset_u;
		this.reset_ux=reset_ux;
		this.reset_v=reset_v;
		this.reset_s=reset_s;
		this.reset_sx=reset_sx;
		this.color=color;
	}
	
	
}

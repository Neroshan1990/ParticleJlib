package com.liquid.core;

/**
 * Created by neroshank on 8/22/2014.
 */
public class MotionPhyx {
    public static double g=1;
    public MotionPhyx(){

    }
    //v=u+at
    public static double vuatPhysx(double v,double u,double t,boolean isGravityDown){
        double G=g;
        if(!isGravityDown)
            G*=-1;
        if(t==-1){

            //double upE=(v-u);
            return ((v-u)/G);

        }
        if(v==-1){
            return (u+(G*t));
        }
       return 0;
    }

    //v2=u2+2as
    public static double vu2asPhysx(double v,double u,double s,boolean isGravityDown){
        double G=g;
        if(!isGravityDown)
            G*=-1;
        if(v==-1){
            return (Math.sqrt(((u*u)+(2*G*s))));
        }
        if(s==-1){
            double upE=((v*v)-(u*u));
            return (upE/(2*G));
        }
        return 0;
    }

    //F=mgh/sh
    public static double impactPhysx(double F,double m,double s,double sh){
        if(F==-1){
            return (m*g*s)/sh;
        }
        return 0;
    }

    //F=(1/2)mv2sh
    public static double impactPhysx2(double F,double m,double v,double sh){
        if(F==-1){
            F=(m*v*v)/(2*sh);
            return F;
        }
        return 0;
    }

    //S=ut+(1/2)at2
    public static double sutaHalfat2(double s,double u,double t,boolean isZeroGravity){
        if(s==-1){
            double a=g;
            if(isZeroGravity)
                a=0;
            s=(u*t)+((1/2)*a*t*t);
            return s;
        }
        return 0;
    }

    //F=m(v+u)/t
    public static double impactReactionPhysx(double F,double m,double u,double v,double t,boolean oneDirection){
        if(v==-1){
            if(oneDirection)
                u*=-1;
            double upE=(F*t)+(m*u);
            double downE=m;

            return (upE/downE);
        }
        return 0;
    }

    public static float[] axisForce(double angle,double force){
        float xa=Float.parseFloat(String.format("%.4f",Math.sin(angle)));
        float ya=Float.parseFloat(String.format("%.4f",Math.cos(angle)));
        float xForce= (float) (force*xa);
        float yForce= (float) (force*ya);
        float[] xyForces={xForce,yForce};
        return xyForces;
    }
}

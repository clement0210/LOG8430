package ca.poly.aspect;

import org.aspectj.lang.JoinPoint;

import CH.ifa.draw.framework.Connector;

/*
 * Created by grivest
 * on 27-03-2014
 */

/**
 *  Aspect pour profiler la creation de ConnectionFigure et de Point dans le contexte de ConnectionFigure
 */
public aspect AspectProfiler 
{
	// R1 - R2 --------------------------------------------------
	pointcut initFigure():	
		execution( public CH.ifa.draw.framework.ConnectionFigure+.new( .. ) );
	
	after(): initFigure(){
		System.out.println("Initialisation d'une " + thisJoinPoint.getTarget().getClass().getName() );
	}
	
	// R3 --------------------------------------------------
	pointcut initPoint():
		call( public java.awt.Point.new( .. ) ) &&
		within( CH.ifa.draw.framework.ConnectionFigure+ );
	
	after(): initPoint(){
		System.out.println("Initialisation d'un point dans " + thisEnclosingJoinPointStaticPart.getSourceLocation().toString() );
	}
}

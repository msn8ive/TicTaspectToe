package mcCool.ticTaspectJoe;
import org.aspectj.lang.JoinPoint;
//import mcCool.ticTaspectJoe.*;

  public aspect referee {
  
  pointcut stripes (): execution (* *.printBoard()));
  
  after() : stripes(){
	  //TicTacToe.refCheck(p1Name, p2Name);
	  System.out.println(printBoard());
  	} 
  }
 
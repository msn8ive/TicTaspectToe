package mcCool.ticTaspectJoe;
import org.aspectj.lang.JoinPoint;
import mcCool.ticTaspectJoe.*;

  public aspect referee {
  
  pointcut stripes (): execution (* *.printBoard(char[][]));
  
  after() returning (char[][] board): stripes(){
	  //TicTacToe.refCheck(p1Name, p2Name);
	  System.out.println("Returned " + board);
  	} 
  }
 
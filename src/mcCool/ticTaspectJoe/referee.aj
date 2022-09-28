package mcCool.ticTaspectJoe;
import org.aspectj.lang.JoinPoint;
import mcCool.ticTaspectJoe.*;

  public aspect referee {
  
  pointcut stripes (): 
	call (void TicTacToe.printBoard(char[][])) || 
  	execution(int TicTacToe.refCheck(String, String));
  
  after() returning : stripes(){
	  //TicTacToe.refCheck(p1Name, p2Name);
	  System.out.println("ASPECTTTTTTT YOOOO ");
  	} 
  }
 
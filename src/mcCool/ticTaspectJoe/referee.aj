package mcCool.ticTaspectJoe;
import org.aspectj.lang.JoinPoint;
import mcCool.ticTaspectJoe.*;

  public aspect referee {
  
  pointcut stripes (): 
	call (int TicTacToe.chkWinner());
  
  after() returning(Object obj) : stripes(){
	  	if ((int) obj != 4)
	  System.out.println("ASPECTTTTTTT YOOOO " + obj);
  	} 
  }
 
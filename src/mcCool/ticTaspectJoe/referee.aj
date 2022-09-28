package mcCool.ticTaspectJoe;
import org.aspectj.lang.JoinPoint;
import mcCool.ticTaspectJoe.*;

  public aspect referee {
  
  pointcut stripes (String p1Name, String p2Name): 
	call (void TicTacToe.refCheck(String, String))
	&& args(p1Name, p2Name);
  
  after(String p1Name, String p2Name) returning : stripes(p1Name, p2Name){
	  	//TicTacToe.refCheck(p1Name, p2Name);
	  System.out.println("ASPECTTTTTTT YOOOO " + p1Name);
  	
  
  } 
  }
 
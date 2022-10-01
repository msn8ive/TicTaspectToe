package mcCool.ticTaspectJoe;
import org.aspectj.lang.JoinPoint;
import mcCool.ticTaspectJoe.*;

  public aspect referee {
  
  pointcut stripes (): 
	call (int TicTacToe.chkWinner());
  
  after() returning(Object obj) : stripes(){
	  System.out.println();
	  if ((int) obj != 4) {
	  		if ((int) obj == 1){
	            System.out.println("");
	            System.out.println("TIC-TAC-TOE!!  Player 1, you won!");
	            System.out.println("Game Over!");
	            System.exit(0);
	            

	        } else if ((int) obj == 2) {
	            System.out.println("");
	            System.out.println("TIC-TAC-TOE!! Player 2, you won!");
	            System.out.println("Game Over!");
	            System.exit(0);
	            
	        } else if ((int) obj == 3) {
	            System.out.println("");
	            System.out.println("It's a tie! Try again!");
	            System.out.println("Game Over!");
	            System.exit(0);
	           
	        }
	    	
	  	}
  	} 
  }
 
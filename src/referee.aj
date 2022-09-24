import org.aspectj.lang.JoinPoint;

  public aspect referee {
  
  pointcut stripes (String p1Name, String p2Name): execution (* *.printBoard(char[][])) && args(p1Name, p2Name));
  
  after (String p1Name, String p2Name): stripes(){TicTacToe.refCheck(p1Name, p2Name); 
  	} 
  }
 
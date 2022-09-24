

  public aspect referee {
  
  pointcut stripes (): execution (* *.printBoard(char[][]));
  
  after (String p1Name, String p2Name): stripes(){TicTacToe.refCheck(p1Name, p2Name); } }
 
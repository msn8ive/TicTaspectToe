
public aspect referee {
	
	pointcut stripes (): execution (* *.chkWinner());
	
	after (): stripes(){
		System.out.println("Zebra was just here!");
	}
}
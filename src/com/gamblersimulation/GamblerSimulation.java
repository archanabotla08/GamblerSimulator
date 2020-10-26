import java.util.*;
public class GamblerSimulation {
	public static final int  STAKE =100 ;
	public static final int  BET =1 ;
	public static int wins = 0;
	public static int loss = 0;
	public static void betting(){
		Random r = new Random();
		int number = r.nextInt(2);
		if(number == 1){
			wins +=1;
		}else{
			loss +=1;
		}
		System.out.println("Win : " + wins + " Loss :" + loss);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(stake +" "+bet);
		GamblerSimulation gs = new GamblerSimulation();
		gs.betting();
	} 

}

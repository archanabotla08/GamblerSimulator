import java.util.*;
public class GamblerSimulation {
	public static final int  STAKE = 100 ;
	public static final int  BET = 1 ;
	public static int cash,lossCondition,winCondition,totalAmount=0;
	public static void betting(){
		Random r = new Random();
		int number = r.nextInt(2);
		if(number == 1){
			cash +=1;
		}else{
			cash -=1;
		}
	}
	public int stopStake(){
		lossCondition = (int) Math.round(STAKE * 0.5);
		winCondition = (int) Math.round(STAKE + (STAKE * 0.5));
		boolean stop =true;
		while(stop == true){
			betting();
			if(cash == lossCondition){
				stop=false;
			}
			if(cash == winCondition){
				stop=false;
			}
		}
		return cash;
	}
	public int getTotalAmountWinorLoss(){
		int daysPlaying = 20;
		int day_stake =0;
		int day = 0;
		while(daysPlaying >0){
			day++;
			day_stake=stopStake();
			daysPlaying=daysPlaying - 1;
			totalAmount=totalAmount+day_stake;
		}
		System.out.println("Total Amount Earned or Loss by Gambler at end : " + totalAmount);
		return totalAmount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(stake +" "+bet);
		GamblerSimulation gs = new GamblerSimulation();
		System.out.println("Stake : " + gs.getTotalAmountWinorLoss());
	}

}

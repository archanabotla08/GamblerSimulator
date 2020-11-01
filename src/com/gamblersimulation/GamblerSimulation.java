import java.util.*;
public class GamblerSimulation {
	public static final int  STAKE = 100 ;
	public static final int  BET = 1 ;
	public static int cash,lossCondition,winCondition,totalAmount=0,daysLoss,daysWins;

	public static void betting(){
		Random r = new Random();
		int number = r.nextInt(2);
		if(number == 1){
			cash +=1;
		}else{
			cash -=1;
		}
	}
	public int stopStake(int day){
	        lossCondition = (int) Math.round(STAKE * 0.5);
		winCondition = (int) Math.round(STAKE + (STAKE * 0.5));
		boolean stop =true;
		cash = STAKE;
		while(stop == true){
			betting();
			if(cash == lossCondition){
				System.out.println( " Loss " +"Day : "+ day +" Earned : " + cash);
				stop=false;
			}
			if(cash == winCondition){
				System.out.println( " Win " +"Day : "+ day +" Earned : " + cash);
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
			day_stake=stopStake(day);
			daysPlaying=daysPlaying - 1;
			totalAmount=totalAmount+day_stake;
		System.out.println("Total Amount Win or Loss by Gambler at end : " + totalAmount);
		}
		return totalAmount;
	}
	public int calculateForMonth(){
		getTotalAmountWinorLoss();
		return totalAmount;
	}

	public void getDayForLuckyorUnlucky(){
		List<Integer> dayStake = new ArrayList<>();
		for(int day=1;day<=20;day++){
			dayStake.add(stopStake(day));
		}
		Collections.sort(dayStake);
		int size = dayStake.size();
		System.out.println("Luckiest Day With MAX Amount : " + dayStake.get(size-1));
		System.out.println("Unlucikest Day WIth MIN Amount: " + dayStake.get(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(stake +" "+bet);
		GamblerSimulation gs = new GamblerSimulation();
		//System.out.println("Stake : " + gs.getDayForLuckyorUnlucky());
		gs.getDayForLuckyorUnlucky();
	}

}

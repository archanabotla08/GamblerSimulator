import java.util.*;
public class GamblerSimulation {
	public static final int  STAKE = 100 ;
	public static final int  BET = 1 ;
	public static int cash,lossCondition,winCondition,totalAmount=0,daysLoss,daysWins;

	public static boolean betting(){
		Random r = new Random();
		int number = r.nextInt(2);
		if(number == 1){
			cash +=1;
			return true;
		}else{
			cash -=1;
			return false;
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
	public void checkPlay(){
		boolean result = betting();
		Scanner sc = new Scanner(System.in);
		if(result){
		System.out.println("Enter the Choice for Play() : "+"\n"+ "1 : continue to play"+"\n"+"2: stop play");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
			System.out.println("Continue the Play for next month : ");
			getDayForLuckyorUnlucky();
			break;
			case 2:
			System.out.println("Discontinue the play: ");
			break;
			default:
			System.out.println("Invalid Choice");
			break;
		}
		}
	}
	public void startPlay(){
		betting();
		stopStake(20);
		getTotalAmountWinorLoss();
		calculateForMonth();
		getDayForLuckyorUnlucky();
		checkPlay();
	}
	public static void main(String[] args) {
		GamblerSimulation gs = new GamblerSimulation();
		gs.startPlay();
	}

}


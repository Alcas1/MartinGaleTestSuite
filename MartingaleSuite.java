

import java.util.Random;

public class MartingaleSuite {

	static int money=1000;
	static int loseStreak=0;
	static int maxLoseStreak=0;
	static int totalLoseStreak=0;
	static int numBets=0;
	static int currentBetAmount=1;
	static int maxBank=money;
	static int currentMaxBank=money;
	static int maxBankTotals=0;
	static int minBets=0;
	public static void main(String args[])
	{

		int startMoney=money;



		int totalBets=0;
		int totalRuns=1000;
		for(int i=0;i<totalRuns;i++)
		{
			maxLoseStreak=0;
			currentMaxBank=startMoney;
			money=startMoney;
			numBets=0;
			currentBetAmount=1;
			betTillBankrupt();
			totalBets+=numBets;
		}
		System.out.println("Highest Money Sum:"+maxBank);
		System.out.println("Average Highest Money Sum:"+maxBankTotals/totalRuns);
		System.out.println("Average Bets till Bankrupt:"+totalBets/totalRuns);
		System.out.println("Average Lose Streak:"+totalLoseStreak/totalRuns);




	}

	public static void betTillBankrupt()
	{


		while(money>0)
		{
			if(money-currentBetAmount>0)
			{
				money-=currentBetAmount;
			}
			else
			{
				currentBetAmount=money;
				money=0;
			}
			//System.out.println(money);
			Random r = new Random();
			int result=r.nextInt(2);
			if(result==0)
			{
				//System.out.println("win:"+startMoney);
				loseStreak=0;
				money+=currentBetAmount*2;
				currentBetAmount=1;
			}
			else
			{
				//System.out.println("loss:"+startMoney);
				loseStreak++;
				currentBetAmount*=2;

			}
			numBets++;
			if(money>currentMaxBank)
			{
				if(money>maxBank)
				{
					maxBank=money;
				}
				currentMaxBank=money;
			}
			if(loseStreak>maxLoseStreak)
			{
				maxLoseStreak=loseStreak;
			}

		}

		//System.out.println("Bankrupt  Num Bets:"+numBets);
		totalLoseStreak+=maxLoseStreak;
		maxBankTotals+=currentMaxBank;
	}











}



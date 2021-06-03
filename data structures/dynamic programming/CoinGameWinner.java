/*
Question:
A and B are playing a game. At the beginning there are n coins. Given two more numbers x and y. In each move a player can pick x or y or 1 coins. A always starts the game. The player who picks the last coin wins the game or the person who is not able to pick any coin loses the game. For a given value of n, find whether A will win the game or not if both are playing optimally.

Examples: 

Input :  n = 5, x = 3, y = 4
Output : A
There are 5 coins, every player can pick 1 or
3 or 4 coins on his/her turn.
A can win by picking 3 coins in first chance.
Now 2 coins will be left so B will pick one 
coin and now A can win by picking the last coin.

Input : 2 3 4
Output : B
*/

import java.util.*;

public class CoinGameWinner {

    public static void main(String[] args)
    {     
        int n = 5;
        int x = 3;
        int y = 4;
        
        System.out.println(winner(n, x, y));
    }

	private static char winner(int n, int x, int y) {
		
		boolean[] dp = new boolean[n+1];
		
		dp[0] = false; // There are no coins and A can not pick any coins thus A loses
		dp[1] = true; // A will play the first move 
		
		for(int i=2; i<=n; i++) {
			// if previous move is false i.e. if A did not play the last move
			// then only A can play
			// then we have to check if A can play for 1 coin
			// if not we will check if A can play for x coins
			// if not we will check if A can play for y coins
			if (i - 1 >= 0 && dp[i - 1] == false)
                dp[i] = true;
            else if (i - x >= 0 && dp[i - x] == false)
                dp[i] = true;
            else if (i - y >= 0 && dp[i - y] == false)
                dp[i] = true;
			
			else {
				dp[i] = false;
			}
		}
		
		// if last move is played by A i.e. it is true then A wins
		if(dp[n]) {
			return 'A';
		}
		
		// Otherwise B wins
		return 'B';
	}
	 
}

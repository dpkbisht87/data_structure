package com.practice.dp;

public class MinimumCoinChange {
    private static int getMinCoinsToMakeSum(int[] coins, int sum) {
        int numberOfCoins = coins.length;
        if(numberOfCoins == 0 || sum <= 0){
            return 0;
        }
        
        int[][] arr = new int[numberOfCoins][sum + 1];
        for(int i =0; i<numberOfCoins; i++){
            arr[i][0] = 0;
        }
        
        for(int i = 0; i < numberOfCoins; i++){
            for(int j = 1; j <= sum; j++){
                int includingCurrentCoin = Integer.MAX_VALUE;
                int exculdingCurrentCoin = Integer.MAX_VALUE;;
                
                if(coins[i] <= j){
                    includingCurrentCoin = 1 + arr[i][j- coins[i]];
                }
                
                if( i > 0){
                    exculdingCurrentCoin = arr[i -1][j];
                }
                arr[i][j] = Math.min(includingCurrentCoin, exculdingCurrentCoin);
            }
        }
        return arr[numberOfCoins -1][sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println(getMinCoinsToMakeSum(coins, sum));
    }
    

}

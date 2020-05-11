package com.practice.dp;

public class CoinChange {
    
    private static int totalWaysOfCoinChange(int[] coins, int sum) {
        if(coins.length == 0 || sum == 0){
            return 0;
        }
        int[][] arr = new int[coins.length][sum + 1];
        
        for(int j = 0; j < coins.length; j++){
            arr[j][0] = 1;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= sum; j++){
                int includingCurrentCoin = 0;
                int exculdingCurrentCoin = 0;
                
                if(j >= coins[i]){
                    includingCurrentCoin = arr[i][j - coins[i]];
                }
                
                if(i > 0){
                    exculdingCurrentCoin = arr[i - 1][j];
                }
                arr[i][j] = includingCurrentCoin + exculdingCurrentCoin;
            }
        }
        return arr[coins.length - 1][sum];
    }
    
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        System.out.println(totalWaysOfCoinChange(coins, sum));
    }
    
    
}

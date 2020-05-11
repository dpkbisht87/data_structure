package com.practice.dp;

public class RodCuttingProblem {
    private static int getMaxProfit(int[] pieces, int[] pr, int rodLength) {
        if (pieces.length == 0 || pr.length == 0 || rodLength <= 0) {
            return 0;
        }
        
        int[][] arr = new int[pieces.length][rodLength + 1];
        
        for(int i = 0; i < pieces.length; i++){
            arr[i][0] = 0;
        }
        
        for (int i = 0; i < pieces.length; i++){
            for(int j = 0; j <= rodLength; j++){
                int includingCurrentProfit = 0;
                int excludingCurrentProfit = 0;
                
                if(pieces[i]<= j){
                    includingCurrentProfit = pr[i] + arr[i][j - pieces[i]];
                }
                
                if(i > 0){
                    excludingCurrentProfit = arr[i - 1][j];
                }
                arr[i][j] = Math.max(includingCurrentProfit, excludingCurrentProfit);
            }
        }
        return arr[pieces.length - 1][rodLength];
    }
    
    public static void main(String[] args) {
        int[] pieces = {1, 2, 3, 4, 5};
        int[] pr = {3, 5, 10, 11, 15};
        
        int rodLength = 5;
        
        System.out.println(getMaxProfit(pieces, pr, rodLength));
    }
    
    
}

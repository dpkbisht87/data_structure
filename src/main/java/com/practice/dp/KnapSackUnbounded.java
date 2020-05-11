package com.practice.dp;

public class KnapSackUnbounded {
    
    private static int getMaxProfit(int[] wt, int[] pr, int capacity) {
        if(wt.length == 0 || pr.length == 0 || capacity <= 0){
            return 0;
        }
        
        int[][] matrix = new int[wt.length][capacity + 1];

        
        for(int i = 0; i < wt.length; i++){
            for(int j = 1; j <= capacity; j++){
                int includeWeight = 0;
                int excludeWeight = 0;
                if(j >= wt[i]){
                    includeWeight = pr[i] + matrix[i][j- wt[i]];
                }
                if(i > 0){
                    excludeWeight = matrix[i -1][j];
                }
                matrix[i][j] = Math.max(excludeWeight, includeWeight);
            }
        }
        return matrix[wt.length -1][capacity];
    }
    
    public static void main(String[] args) {
        int[] wt = {1, 2, 3, 5};
        int[] pr = {1, 4, 7, 10};
        int capacity = 8;
    
        System.out.println(getMaxProfit(wt, pr, capacity));
    }
    
    
}

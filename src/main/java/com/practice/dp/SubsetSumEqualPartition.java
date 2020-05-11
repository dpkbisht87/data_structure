package com.practice.dp;

public class SubsetSumEqualPartition {

    public static boolean ifSubsetExistsWithEqualPartition(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        boolean[][] mat = new boolean[arr.length][half + 1];

/*        for (int i = 0; i < arr.length; i++) {
            mat[i][0] = true;
        }

        for (int j = 0; j < half; j++) {
            if (j == arr[0]) {
                mat[0][j] = true;
            }
        }*/

/*        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (mat[i - 1][j] == true) {
                    mat[i][j] = true;
                } else {
                    if (j >= arr[i]) {
                        mat[i][j] = mat[i - 1][j - arr[i]];
                    }
                }
            }
        }*/


        return mat[arr.length - 1][half];
    }

    public static int getMinDifferenceSubsetSumArrayPartition(int[] arr){
        if( arr.length == 0){
            return 0;
        }
        int sumArray = 0;
        for(int i: arr){
            sumArray += i;
        }
        int sum = sumArray / 2;

        boolean[][] mat = new boolean[arr.length][sum + 1];

        for(int i = 0; i < arr.length; i++){
            mat[i][0] = true;
        }

        for(int j = 0; j < sum; j++){
            if(j == arr[0]){
                mat[0][j] = true;
            }
        }

        for(int i = 1; i< arr.length; i++){
            for(int j = 1; j<= sum; j++){
                if(mat[i -1][j] == true){
                    mat[i][j] = true;
                }else{
                    if(j >= arr[i]){
                        mat[i][j] = mat[i - 1][j - arr[i]];
                    }
                }
            }
        }
        if(mat[arr.length -1][sum]){
            return 0;
        }
        int firstPartitionSum = -1;
        for(int j = sum; j >= 0; j--){
            if(mat[arr.length -1][j] == true){
                firstPartitionSum = j;
                break;
            }
        }
        int otherPartitionSum = sumArray - firstPartitionSum;
        System.out.println(firstPartitionSum);
        System.out.println(otherPartitionSum);

        return Math.abs(firstPartitionSum - otherPartitionSum);

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 5, 12};
        System.out.println(SubsetSumEqualPartition.ifSubsetExistsWithEqualPartition(arr));

        System.out.println(SubsetSumEqualPartition.getMinDifferenceSubsetSumArrayPartition(arr));


    }
}

package com.practice.techgig;

import java.util.Scanner;

public class PowerPuffGirls {
    public static void main(String args[] ) throws Exception {
        Scanner input = new Scanner(System.in);
        int ingredientCount = Integer.parseInt(input.nextLine());
        int[] quantityRequired = new int[ingredientCount];
        int[] quantityInLab = new int[ingredientCount];
        for(int i = 0; i < ingredientCount; i++){
            quantityRequired[i] = input.nextInt();
        }
        
        for(int i = 0; i < ingredientCount; i++){
            quantityInLab[i] = input.nextInt();
        }
        
        int[] result = new int[ingredientCount] ;
        int noOfGirls = Integer.MAX_VALUE;
        for(int i = 0; i < ingredientCount; i++){
            if(quantityInLab[i] >= quantityRequired[i]){
                result[i] = quantityInLab[i] / quantityRequired[i];
                if(noOfGirls > result[i]){
                    noOfGirls = result[i];
                }
            }
        }
        System.out.println(noOfGirls);
    }
}

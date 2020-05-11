package com.practice.dp;

public class MaxPiecesRetrievedAfterCuttingFullLengthPiece {
    
    public static int getMaxPieces(int[] pieces, int pieceLength){
        int numberOfPieces = pieces.length;
        if(numberOfPieces == 0 || pieceLength <= 0){
            return 0;
        }
        int[][] arr = new int[numberOfPieces][pieceLength + 1];
        
        for(int i = 0; i < numberOfPieces; i++) {
            for (int j = 0; j <= pieceLength; j++) {
                arr[i][j] = -1;
            }
        }
        for(int i = 0; i < numberOfPieces; i++){
            arr[i][0] = 0;
        }
        
        for(int i = 0; i < numberOfPieces; i++){
            for(int j = 1; j <= pieceLength; j++){
                int includeCurrentPiece = -1;
                int excludeCurrentPiece = -1;
                
                if(pieces[i] <= j && arr[i][j - pieces[i]] != -1){
                    includeCurrentPiece = 1 + arr[i][j - pieces[i]];
                }
                
                if( i > 0){
                    excludeCurrentPiece = arr[i - 1][j];
                }
                arr[i][j] = Math.max(includeCurrentPiece, excludeCurrentPiece);
            }
        }
        return arr[numberOfPieces -1][pieceLength];
    }
    
    public static void main(String[] args) {
        int[] pieces = {4, 2, 3, 5};
    
        int pieceLength = 7;
    
        System.out.println(MaxPiecesRetrievedAfterCuttingFullLengthPiece.getMaxPieces(pieces, pieceLength));
    
    }
}

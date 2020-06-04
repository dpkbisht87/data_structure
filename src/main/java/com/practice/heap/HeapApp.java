package com.practice.heap;
class HeapImpl {
    
    int size;
    int[] arr = new int[20];
    
    public void insertNewValue(int value){
        arr[size] = value;
        int index = size;
        int parent = (index -1)/2;
        
        while   (parent > 0 && arr[parent] < arr[index]) {
            int temp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = temp;
            
            t = parent;
            parent = (index - 1) / 2;
            index = t;
        }
    }
    
}
}

public class HeapApp {
    
    public static void main(String[] args) {
    
        HeapImpl a = new HeapImpl();
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
    
        a.insertNewValue(arr[0]);
        a.insertNewValue(arr[1]);
        a.insertNewValue(arr[2]);
    }
}

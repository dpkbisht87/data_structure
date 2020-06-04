package com.practice.binarytree2;


import java.util.*;

public class BinaryTree {
    
    
    private void topView(Node node){
        if(node == null){
            return;
        }
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.height;
            if(treemap.get(hd) == null){
                treemap.put(hd, temp.data);
            }
            
            if(temp.left != null){
                temp.left.height = hd - 1;
                q.add(temp.left);
            }
            
            if(temp.right != null){
                temp.right.height = hd + 1;
                q.add(temp.right);
            }
        }
        System.out.println(treemap.values());
    }
    
    private void bottomView(Node node){
        if(node == null){
            return;
        }
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.height;
            
            treemap.put(hd, temp.data);
            
            
            if(temp.left != null){
                temp.left.height = hd - 1;
                q.add(temp.left);
            }
            
            if(temp.right != null){
                temp.right.height = hd + 1;
                q.add(temp.right);
            }
        }
        System.out.println(treemap.values());
    }
    
    private void printVerticalOrder(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        TreeMap<Integer, List<Integer>> treeMap= new TreeMap<Integer, List<Integer>>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.height;
            List<Integer> data_list;
            if(treeMap.get(hd) == null){
                data_list = new ArrayList<Integer>();
                data_list.add(temp.data);
            }else {
                data_list = treeMap.get(hd);
                data_list.add(temp.data);
            }
            treeMap.put(hd, data_list);
    
            if(temp.left != null){
                temp.left.height = hd - 1;
                q.add(temp.left);
            }
    
            if(temp.right != null){
                temp.right.height = hd + 1;
                q.add(temp.right);
            }
        }
        System.out.println(treeMap.values());
        
    }
    public static void main(String[] args) {
        BinaryTree a = new BinaryTree();
    
        Node root =  new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);
       // a.topView(root);
        
        //a.bottomView(root);
        a.printVerticalOrder(root);
    }
}

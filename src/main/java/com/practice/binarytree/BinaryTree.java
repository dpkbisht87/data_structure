package com.practice.binarytree;

public class BinaryTree {
    
    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
    
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
    
    public int  getSumOfNodes(Node node){
        if(node == null){
            return 0;
        }
        
        return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
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
    
        System.out.print("Total Sum: " + a.getSumOfNodes(root));
    }
}

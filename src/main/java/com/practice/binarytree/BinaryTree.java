package com.practice.binarytree;

import javax.transaction.TransactionRequiredException;
import java.util.*;

public class BinaryTree {
    
    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    
    public int  getSumOfNodes(Node node){
        if(node == null){
            return 0;
        }
        
        return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
    }
    
    public int getNumberOfNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
    }
    
    public int noOfLeafNode(Node node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return noOfLeafNode(node.left) + noOfLeafNode(node.right);
    }
    
    public int getHeight(Node node){
        if(node == null){
            return 0;
        }else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
    
    public void nodesAtGivenHeight(Node node, int level){
        if(node == null){
            return;
        }
        
        if(level == 1){
            System.out.print(node.data + "   ");
            return;
        }
        
        nodesAtGivenHeight(node.left, level - 1);
        nodesAtGivenHeight(node.right, level - 1);
    }
    
    public void levelOrderTraversalUsingRecursion(Node node){
        if(node == null){
            return;
        }
        BinaryTree a = new BinaryTree();
    
        int height = a.getHeight(node);
        for(int i = 0; i <= height; i++){
            nodesAtGivenHeight(node, i + 1);
            System.out.println(" ");
        }
        
    }
    
    public void levelOrderTraversalWithoutRecursion(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        
        while(q.size() > 0){
            Node top = q.remove();
            System.out.print(top.data+ " ");
            if(top.left != null){
                q.add(top.left);
            }
            if(top.right != null) {
                q.add(top.right);
            }
            
        }
        System.out.println(" ");
    }
    
    
    public void reverseLevelOrderTraversalUsingRecursion(Node node){
        if(node == null){
            return;
        }
        
        BinaryTree a = new BinaryTree();
        int height = a.getHeight(node);
        
        for(int i = height; i >= 0; i--){
            nodesAtGivenHeight(node, i + 1);
            System.out.println();
        }
        
    }
    
    public void reverseLevelOrderTraversalWithoutRecursion(Node node){
        if(node == null){
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(q.size()> 0){
            Node top = q.remove();
            s1.push(top);
            if(top.right != null) {
                q.add(top.right);
            }
            if(top.left != null){
                q.add(top.left);
            }
        }
        while(!s1.isEmpty()){
            System.out.print(s1.pop().data+ " ");
        }
    }
    
    public void levelOrderTraversalUsingQueueLineByLine(Node node){
        if(node == null){
            return;
        }
        Queue<Node> a = new LinkedList<Node>();
        a.add(node);
        while(true){
            int queueSize = a.size();
            if(queueSize == 0){
                break;
            }
            while(queueSize > 0){
                Node temp = a.peek();
                System.out.print(temp.data + " ");
    
                a.remove();
    
                if(temp.left != null) {
                    a.add(temp.left);
                }
    
                if(temp.right != null) {
                    a.add(temp.right);
                }
    
                queueSize--;
            }
    
            System.out.println();
            }
        }
    
    
    int maxLevelRightView;
    public void rightViewOfTree(Node node, int level){
        if(node == null){
            return;
        }
        if(level >= maxLevelRightView){
            System.out.println(node.data);
            maxLevelRightView++;
        }
        rightViewOfTree(node.right, level + 1);
        rightViewOfTree(node.left, level + 1);
    }
    
    int maxLevelLeftView;
    public void leftViewOfTree(Node node, int level){
        if(node == null){
            return;
        }
        if(level >= maxLevelLeftView){
            System.out.println(node.data);
            maxLevelLeftView++;
        }
        leftViewOfTree(node.left, level + 1);
        leftViewOfTree(node.right, level + 1);
    }
    
    public void inOrderTraversalWithoutRecursion(Node node){
        Stack<Node> s1 = new Stack<Node>();
        s1.push(node);
        while(node.left != null){
            s1.push(node.left);
            node = node.left;
        }
        while(s1.size() > 0){
            Node curr = s1.pop();
            System.out.print(curr.data + " ");
            if(curr.right != null){
                Node temp = curr.right;
                while(temp != null){
                    s1.push(temp);
                    temp = temp.left;
                }
            }
        }
    }
    
    public void preOrderTraversalWithoutRecursion(Node node){
        if(node == null){
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        s1.push(node);
        
        while(s1.size() > 0){
            Node curr = s1.pop();
            System.out.print(curr.data + " ");
            
            if(curr.right != null){
                s1.push(curr.right);
            }
            if(curr.left != null){
                s1.push(curr.left);
            }
        }
    }
    
    public void postOrderTraversalWithoutRecursion(Node node){
        if(node == null){
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        s1.push(node);
        while(!s1.isEmpty()){
           Node curr = s1.pop();
           s2.push(curr);
            if(curr.left != null){
                s1.push(curr.left);
            }
            if(curr.right != null){
                s1.push(curr.right);
            }
            
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().data+ " ");
        }
    }
    
    public Node mirrorTree(Node node){
        if(node == null){
            return null;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirrorTree(node.left);
        mirrorTree(node.right);
        
        return node;
    }
    
    public Node deleteTree(Node node){
        if(node == null){
            return null;
        }
        node.left = deleteTree(node.left);
        node.right = deleteTree(node.right);
    
        System.out.println("Deleting node:"+node.data);
        node = null;
        return node;
    }
    
    public boolean preOrder(Node n1, Node n2){
        if(n1.data == n2.data){
            if(n1.left != null){
                preOrder(n1.left, n2.left);
            }if(n1.right != null) {
                preOrder(n1.right, n2.right);
            }
        }else{
            return false;
        }
        return true;
    }
    
    public boolean isIdentical(Node n1, Node n2){
        if(n1 == null && n2 == null){
            return true;
        }
        // Traverse in Preorder and compare each value.. break and come out if value does not match
        return preOrder(n1, n2);
        
    }
    
    
    private int getLevelOfNode(Node node, int value, int level){
        if(node == null){
            return 0;
        }
        if(node.data == value){
            return level;
        }
        int l = getLevelOfNode(node.left, value, level + 1);
        if(l != 0){
            return l;
        }
        l = getLevelOfNode(node.right, value, level + 1);
        
        return l;
    }
    
    private void printBoundary(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        printLeftBoundary(node.left);
        
        printLeaves(node.left);
        printLeaves(node.right);
        
        printRightBoundary(node.right);
    }
    
    private void printLeftBoundary(Node node){
        if(node == null){
            return;
        }
        if(node.left != null){
            System.out.println(node.data);
            printLeftBoundary(node.left);
        } else if(node.right != null){
            System.out.println(node.data);
            printLeftBoundary(node.right);
        }
    }
    
    private void printLeaves(Node node){
        if(node == null){
            return;
        }
        printLeaves(node.left);
        if(node.left == null && node.right == null){
            System.out.println(node.data + " ");
        }
        printLeaves(node.right);
    }
    
    private void printRightBoundary(Node node){
        if(node == null){
            return;
        }
        if(node.left != null){
            printRightBoundary(node.left);
            System.out.println(node.data);
        } else if(node.right != null){
            printRightBoundary(node.right);
            System.out.println(node.data);
        }
    }
    
    private void getSumLevelWise(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        
        while(true){
            int size = q.size();
            if(size == 0){
                break;
            }
            int sum = 0;
            while (size > 0){
                Node temp = q.remove();
                sum = sum + temp.data;
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                }
                size --;
            }
            System.out.println(sum);
        }
    }
    
    private boolean recursiveSearch(Node node, int val){
        if(node == null){
            return false;
        }
        if(node.data == val){
            return true;
        }else{
            return recursiveSearch(node.left, val) || recursiveSearch(node.right, val);
        }
    }
    
    private boolean iterativeSearch(Node node, int val){
        if(node == null){
            return false;
        }
        if(node.data == val){
            return true;
        }
        boolean isFound = false;
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp.data == val){
                isFound = true;
                break;
            }
            
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return isFound;
    }
    
    private void spiralOrderTraversal(Node node){
        if(node == null){
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        s1.push(node);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            if(s1.isEmpty() && s2.isEmpty()){
                break;
            }
            
            while(!s1.isEmpty()){
                Node temp = s1.pop();
                System.out.println(temp.data);
                if(temp.right != null){
                    s2.push(temp.right);
                }
                if(temp.left != null){
                    s2.push(temp.left);
                }
        
            }
    
            while(!s2.isEmpty()){
                Node temp = s2.pop();
                System.out.println(temp.data);
               
                if(temp.left != null){
                    s1.push(temp.left);
                }
                if(temp.right != null){
                    s1.push(temp.right);
                }
        
            }
        }
    }
    
    private void getMaximumWidth(Node node){
        if(node == null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        int max_width = 0;
        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
            
            int size = q.size();
            if(size > max_width){
                max_width = size;
            }
        }
        System.out.println(max_width);
    }
    
    
    
    
    private boolean ifMirrorImage(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.data == node2.data
                       && ifMirrorImage(node1.left, node2.right)
                       && ifMirrorImage(node1.right, node2.left);
        
    }
    
    private boolean ifMirrorStructureTree(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return ifMirrorStructureTree(node1.left, node2.right) && ifMirrorStructureTree(node1.right, node2.left);
    }
    
    private boolean ifSameStructure(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return ifSameStructure(node1.left, node2.left) && ifSameStructure(node1.right, node2.right);
    }
    
    private boolean isFoldable(Node node){
        if(node == null){
            return false;
        }
        return ifMirrorStructureTree(node.left, node.right);
    }
    
    private boolean isIsomorphic(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return (isIsomorphic(node1.left, node2.left) && isIsomorphic(node1.right, node2.right))
                || (isIsomorphic(node1.left, node2.right) && isIsomorphic(node1.right, node2.left));
    }
    
    private int getWidthOfLevel(Node node, int level){
        if(node == null){
            return 0;
        }
        if(level == 1){
            return 1;
        }
        return getWidthOfLevel(node.left, level - 1) + getWidthOfLevel(node.right, level - 1);
    }
    
    private void createDoubleTree(Node node){
        if(node == null){
            return;
        }
        createDoubleTree(node.left);
        createDoubleTree(node.right);
        
        Node newNode = new Node(node.data);
        newNode.left = node.left;
        node.left = newNode;
    }
    
    private Node buildTreeFromInOrderPreOrder(int[] preorderArray, int[] inorderArray, int start, int end){
        if(start > end){
            return null;
        }
        Node node = new Node(preorderArray[start]);
        if(start == end){
            return node;
        }
        int inOrderIndex = getInOrderIndex(node.data, inorderArray, start, end);
        
        node.left = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, start, inOrderIndex - 1);
        node.right = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, inOrderIndex +1, end);
        
        return node;
    }
    
    private int getInOrderIndex(int data, int[] arr, int start, int end){
        for(int i = start; i <= end; i++){
            if(arr[i] == data){
                return i;
            }
        }
        return -1;
    }
    
    private int heightIteratively(Node node){
        if(node == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        int height = 0;
        while(true){
            int size = q.size();
            if(size == 0){
                break;
            }
            while(size > 0){
                Node temp = q.remove();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
                size --;
            }
            height = height + 1;
        }return height;
    
    }
    int diameter;
    private int getDiameter(Node node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        int lh = getDiameter(node.left);
        int rh = getDiameter(node.right);
        diameter = Math.max(lh + rh + 1, diameter);
        return Math.max(lh, rh) + 1;
    }

    private int isHeightBalanced(Node node){
        if(node == null){
            return -1;
        }
        if(node.left == null && node.right == null){
            return 0;
        }
        int lh = isHeightBalanced(node.left);
        int rh = isHeightBalanced(node.right);
        
        if(lh == -1 || rh == -1 || Math.abs(lh- rh) > 1){
            return -1;
        }
        return Math.abs(lh - rh) + 1;
    }
    
    private boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
    
    private boolean checkIfRootToLeafSumMatches(Node node, int total){
        if(node == null){
            return false;
            
        }
        if(node.left != null && node.right != null && node.data == total)
        return true;
        
        return checkIfRootToLeafSumMatches(node.left, total - node.data) ||
                       checkIfRootToLeafSumMatches(node.right, total - node.data);
    }
    
    private void printRootToLeafEveryPath(Node node){
        if(node == null){
            return;
        }
        int[] arr = new int[10];
        printRootToLeafImpl(node, arr, 0);
    }
    
    private void printRootToLeafImpl(Node node, int[] arr, int index){
        if(node == null){
            return;
        }
        arr[index] = node.data;
        if(node.left != null && node.right != null){
            printArray(arr);
        }
        printRootToLeafImpl(node.left, arr, index + 1);
        printRootToLeafImpl(node.right, arr, index + 1);
    }
    
    private void printArray(int[] arr){
        for(int val: arr){
            System.out.println(val+ " ");
        }
    }
    int max = 0;
    public void getMaxSumFromRoofToLeaf(Node node, int sum){
        if(node == null){
            return;
        }
        if(node.left != null && node.right != null && sum + node.data > max){
            max = sum + node.data;
        }
        getMaxSumFromRoofToLeaf(node.left, sum + node.data);
        getMaxSumFromRoofToLeaf(node.right, sum + node.data);
    
    
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
    
        Node root2 =  new Node(2);
        root2.left = new Node(7);
        root2.right = new Node(5);
        root2.left.left = new Node(2);
        root2.left.right = new Node(6);
        root2.left.right.left = new Node(5);
        root2.left.right.right = new Node(11);
        root2.right.right = new Node(9);
        root2.right.right.left = new Node(4);

        Node root1 = new Node(8);
        root1.left = new Node(3);
        root1.right = new Node(10);
        root1.left.left = new Node(1);
        root1.left.right = new Node(6);
        root1.left.right.left = new Node(4);
        root1.left.right.right = new Node(7);
        root1.right.right = new Node(14);
        root1.right.right.left = new Node(13);
//
        
//        System.out.println("Total Sum: " + a.getSumOfNodes(root));
//        System.out.println("Total number of nodes: " + a.getNumberOfNodes(root));
//        System.out.println("Number of leaf nodes: " + a.noOfLeafNode(root));
//        System.out.println("Height of the tree: " + a.getHeight(root));
//
//        System.out.println("Nodes at a given height: ");
//        a.nodesAtGivenHeight(root, 3);
//
//        System.out.println("levelOrderTraversalUsingRecursion: ");
//        a.levelOrderTraversalUsingRecursion(root);
//
//        System.out.println("LevelOrderTraversalWithoutRecursion :");
//        a.levelOrderTraversalWithoutRecursion(root);
//
//        System.out.print("ReverseLevelOrderTraversalUsingRecursion :");
//        a.reverseLevelOrderTraversalUsingRecursion(root);
//
//        System.out.print("ReverseLevelOrderTraversalWithoutRecursion :");
//        a.reverseLevelOrderTraversalWithoutRecursion(root);
//
//        System.out.println("LevelOrderTraversal Line by line without recursion");
//        a.levelOrderTraversalUsingQueueLineByLine(root);
//
//        System.out.println("Left View of tree");
//        a.leftViewOfTree(root, 0);
//        System.out.println("Right view of tree :");
//        a.rightViewOfTree(root, 0);
//
//        System.out.println();
//        System.out.println("Inorder traversal without recursion");
//        b.inOrderTraversalWithoutRecursion(root1);
//
//        System.out.println();
//        System.out.println("Preorder traversal without recursion");
//        b.preOrderTraversalWithoutRecursion(root1);
//
//        System.out.println();
//        System.out.println("PostOrder traversal without recursion");
//        b.postOrderTraversalWithoutRecursion(root1);
//
//        System.out.println();
//        System.out.println("Mirror Tree:");
//        Node mirror = a.mirrorTree(root1);
//        a.inOrder(mirror);
//
//        root = a.deleteTree(root);

//        System.out.println(a.isIdentical(root, root1));
    
//        System.out.println("Get level of a given node");
//        System.out.println(a.getLevelOfNode(root, 7, 1));
    
        //a.printBoundary(root);
        //a.getSumLevelWise(root);
        //System.out.println(a.recursiveSearch(root, 5));
        //System.out.println(a.iterativeSearch(root, 11));
        //a.spiralOrderTraversal(root);
        //a.getMaximumWidth(root);
    
    
//        Node root4 = new Node(2);
//        root4.left = new Node(7);
//        root4.right = new Node(8);
//        root4.left.left = new Node(5);
//
//        Node root5 = new Node(2);
//        root5.left = new Node(8);
//        root5.right = new Node(7);
//        root5.right.right = new Node(5);
//
//        System.out.println(a.ifMirrorImage(root4, root5));
//        System.out.println(a.ifMirrorStructureTree(root4, root5));
//        System.out.println(a.ifSameStructure(root4, root5));
//        System.out.println(a.isFoldable(root));
//        System.out.println(a.isIsomorphic(root4, root5));
//        System.out.println(a.getWidthOfLevel(root, 3));
//        a.createDoubleTree(root);
//
//        int[] preorderArray = {2, 4, 7, 3, 8};
//        int[] inorderArray = {7, 4, 3, 2, 8};
    
//        root = a.buildTreeFromInOrderPreOrder(preorderArray, inorderArray, 0, inorderArray.length - 1);
//        System.out.println(a.heightIteratively(root));
//        a.getDiameter(root);
//        System.out.println(a.diameter);
//        System.out.println("is Height Balanced : "+ (a.isHeightBalanced(root) != -1));
//
//        int sum = 14;
//        a.checkIfRootToLeafSumMatches(root, sum);
//        a.printRootToLeafEveryPath(root);
        a.getMaxSumFromRoofToLeaf(root, 0);
        System.out.println(a.max);
    
    }
}


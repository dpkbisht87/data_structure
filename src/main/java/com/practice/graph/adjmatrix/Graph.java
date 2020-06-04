package com.practice.graph.adjmatrix;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVerts;
    private Stack<Integer> s;
    private Queue<Integer> q;
    
    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        s = new Stack<Integer>();
        q = new LinkedList<Integer>();
    }
    
    public void addVertex(char label){
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    
    private void displayVertex(int index){
        System.out.print(vertexList[index].label+ " ");
    }
    
    
    private int getAdjacentUnvisitedVertex(int v){
        for(int i = 0; i < nVerts; i++){
            if(adjMatrix[v][i] == 1 && !vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }
    
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        s.push(0);
        
        while(!s.isEmpty()){
            int v = getAdjacentUnvisitedVertex(s.peek());
            if(v == -1){
                s.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                s.push(v);
            }
        }
    }
    
    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        
        q.add(0);
        while(!q.isEmpty()){
            int i = q.remove();
            
            for(int j = 1; j < nVerts; j++){
                if(adjMatrix[i][j] == 1 && !vertexList[j].wasVisited){
                    q.add(j);
                    vertexList[j].wasVisited = true;
                    displayVertex(j);
                }
            }
        }
    }
    
    public void mst(){
        vertexList[0].wasVisited = true;
        s.push(0);
        
        while(!s.isEmpty()){
            int cur = s.peek();
            int v = getAdjacentUnvisitedVertex(cur);
            if(v == -1){
                s.pop();
            }else {
                vertexList[v].wasVisited = true;
                s.push(v);
                displayVertex(cur);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        
    }
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
    
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);
        theGraph.addEdge(4, 5);
        theGraph.addEdge(1, 3);
    
        System.out.println("Visits: ");
        
//        theGraph.dfs();
//        System.out.println();
        
//        theGraph.bfs();
        theGraph.mst();
    }
}

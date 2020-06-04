package com.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*class Graph{
    private List<List<Integer>> adjList;
    private boolean[] visited;
    int nodes;
    
    Graph(int nodes){
        visited = new boolean[nodes];
        adjList = new ArrayList<List<Integer>>();
        this.nodes = nodes;
        
        for(int i = 0; i < nodes;i ++){
            adjList.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
        
    }
    
   
    public void dfsRecursive(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        List<Integer> neighborList = adjList.get(node);
        for(int neighbor: neighborList) {
            if (!visited[neighbor]) {
                System.out.print(neighbor + " ");
                dfsRecursive(neighbor);
            }
        }
    }
    public int stronglyConnectedComponents(){
        int count = 0;
        for(int i =0;i < nodes;i++){
            if(!visited[i]) {
                dfsRecursive(i);
                count++;
            }
            
        }
        return count;
    }
}

public class ConnectedComponentsInAGraph {
    
    public static void main(String[] args) {
        int nodes = 7;
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(2, 4);
        a.addEdge(3, 5);
        a.addEdge(4, 5);
        a.addEdge(4, 6);
        
//        a.dfs();
        a.stronglyConnectedComponents();
    }
}*/

package com.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*class Graph{
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private int nodes;
    
    Graph(int nodes){
        adjList = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;

        for(int i = 0;i < nodes; i++){
            adjList.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
    
    public boolean ifUndirectedGraphHasCycle(){
        
        for(int i = 0; i < nodes; i++){
            if(ifCycleExists(0, -1)){
                return true;
            }
        }
        return false;
    }
     public boolean ifCycleExists(int index, int parent){
        visited[index] = true;
        
        List<Integer> neighborList = adjList.get(index);
        
        for(int neighbor: neighborList){
            if(!visited[neighbor]){
                ifCycleExists(neighbor, index);
            }else if(neighbor != parent){
                return true;
            
            }
        }
        return false;
     }
}
public class CheckCycleInUnDirectedGraph {
    
    public static void main(String[] args) {
        int nodes = 3;
    
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 0);
    
        System.out.println(a.ifUndirectedGraphHasCycle());
    }

}*/

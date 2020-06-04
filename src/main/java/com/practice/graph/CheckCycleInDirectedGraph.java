package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

/*class Graph{
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private boolean[] recursive;
    private int nodes;
    
    Graph(int nodes) {
        visited = new boolean[nodes];
        recursive = new boolean[nodes];
        this.nodes = nodes;
        
        for(int i = 0; i < nodes; i++){
            adjList.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
    }
    
    public boolean ifDirectedGraphHasCycle(){
        
        for (int i = 0; i < nodes; i++){
            
            if(ifCycleExists(i)){
                return true;
            }
        }
        return false;
    }
    
    public boolean ifCycleExists(int index){
        if(recursive[index]){
            return true;
        }
        if(visited[index]){
           return false;
        }
        List<Integer> neighborList = adjList.get(index);
        for(int neighbor: neighborList){
            if(ifCycleExists(neighbor)){
                return true;
            }
        }
        recursive[index] = false;
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
    
        System.out.println(a.ifDirectedGraphHasCycle());
    }

}*/

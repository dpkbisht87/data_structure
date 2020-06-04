package com.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*class Graph{
    List<List<Integer>> adjList;
    boolean[] visited;
    int nodes;
    
    Graph(int nodes){
        adjList = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;
        
        for(int i =0; i < nodes; i++){
            adjList.add(i, new ArrayList<Integer>());
        }
    }
    
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
    }
    
    public void dfs(int node){
        Stack<Integer> s1 = new Stack<>();
        s1.push(node);
        visited[node] = true;
        
        while(!s1.isEmpty()){
            int curr = s1.pop();
            List<Integer> neighborList = adjList.get(curr);
            for(int neighbor : neighborList){
                if(!visited[neighbor]){
                    s1.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    
    public void dfsRecursive(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        List<Integer> neighborList = adjList.get(node);
        for(int neighbor : neighborList){
            if(!visited[neighbor]){
                dfsRecursive(neighbor);
            }
        }
    }
    
    public boolean ifDirectedGraphStronglyConnected(){
        for(int i = 0; i < nodes; i++){
            dfs(i);
            
            for(int j = 0; j < nodes; j++){
                if(!visited[j]){
                    return false;
                }
            }
            Arrays.fill(visited, false);
        }
        return true;
    }
    
}
public class DirectedGraphStronglyConnected {
    
    public static void main(String[] args) {
        int nodes = 4;
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 0);
        a.addEdge(0, 3);
        a.addEdge(3, 2);
    
        System.out.println(a.ifDirectedGraphStronglyConnected());
    }
}*/

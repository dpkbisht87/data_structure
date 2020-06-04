package com.practice.graph.adjlist;

import java.util.*;

public class Graph {
    List<List<Integer>> graph;
    boolean[] visited;
    
    Graph(int nodes){
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        
        for(int i = 0; i < nodes; i++){
            graph.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    
    public void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
    
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            System.out.print(node + " ");
            
            List<Integer> neighbourList = graph.get(node);
            for(Integer neighbour: neighbourList){
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
    
    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            Integer node = queue.remove();
            System.out.print(node + " ");
            List<Integer> neighbourList = graph.get(node);
            
            for(Integer neighbour : neighbourList){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}

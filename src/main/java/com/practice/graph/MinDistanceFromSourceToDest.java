package com.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*class Graph{
    List<List<Integer>> adjList;
    boolean [] visited;
    int nodes;
    int size;
    int distance;
    
    Graph(int nodes){
        adjList = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;
        size = 0;
        distance = 0;
        for(int i = 0;i < nodes; i++){
            adjList.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
    
    public int minimumDistanceBetweenTwoNodes(int source, int destination){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        size = 1;
        distance = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size > 0){
                int curr = queue.remove();
                size--;
                List<Integer> neighborList = adjList.get(curr);
                for(Integer neighbor: neighborList){
                    if(neighbor == destination){
                        return ++distance;
                    }
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                
                }
                size ++;
            }
            distance++;
        }
        return -1;
    }
}

public class MinDistanceFromSourceToDest {
    public static void main(String[] args) {
        int nodes = 6;
    
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1);
        a.addEdge(0, 3);
        a.addEdge(1, 2);
        a.addEdge(3, 4);
        a.addEdge(2, 4);
        a.addEdge(4, 5);
    
        System.out.println(a.minimumDistanceBetweenTwoNodes(0, 5));
    }
}*/

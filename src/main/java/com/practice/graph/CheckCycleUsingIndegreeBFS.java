package com.practice.graph;

import java.util.*;

/*class Graph{
    List<List<Integer>> adjList;
    HashMap<Integer, Integer> incomingDegree;
    int visitedNodes;
    int nodes;
    Queue<Integer> sourceQueue;
    
    Graph(int nodes){
        adjList = new ArrayList<>();
        incomingDegree = new HashMap<>();
        visitedNodes = 0;
        sourceQueue = new LinkedList<>();
        
        for(int i = 0; i < nodes; i++){
            adjList.add(i, new ArrayList<>());
            incomingDegree.put(i, 0);
        }
    }
    
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
        incomingDegree.put(b, incomingDegree.get(b) + 1);
    }
    
    public boolean checkIfGraphHasCycle() {
        for(Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()){
            if(entry.getValue() == 0){
                sourceQueue.add(entry.getKey());
            }
        }
        
        while(!sourceQueue.isEmpty()){
            visitedNodes++;
            int source = sourceQueue.remove();
            
            List<Integer> neighborList = adjList.get(source);
            for(int neighbor: neighborList){
                incomingDegree.put(neighbor, incomingDegree.get(neighbor) - 1);
                if(incomingDegree.get(neighbor) == 0){
                    sourceQueue.add(neighbor);
                }
            }
        }
        return visitedNodes != nodes;
        
    }
    
}
public class CheckCycleUsingIndegreeBFS {
    public static void main(String[] args) {
        int nodes = 4;
    
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 0);
        a.addEdge(3, 0);
    
        System.out.println(a.checkIfGraphHasCycle());
    }
}*/

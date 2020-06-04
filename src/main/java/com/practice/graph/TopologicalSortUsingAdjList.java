package com.practice.graph;

import java.util.*;

/*class Graph{
    List<List<Integer>> adjList;
    HashMap<Integer, Integer> incomingDegree;
    int nodes;
    int visitedNodes;
    Queue<Integer> sourceQueue;
    
    Graph(int nodes){
        adjList = new ArrayList<>();
        incomingDegree = new HashMap<>();
        this.nodes = nodes;
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
    
    public List<Integer> topologicalSort() {
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()){
            if(entry.getValue() == 0){
                sourceQueue.add(entry.getKey());
            }
        }
        while(!sourceQueue.isEmpty()){
            visitedNodes++;
            int source = sourceQueue.remove();
            result.add(source);
            List<Integer> neighborList = adjList.get(source);
            for(int neighbor: neighborList){
                incomingDegree.put(neighbor, incomingDegree.get(neighbor) - 1);
                if(incomingDegree.get(neighbor) == 0){
                    sourceQueue.add(neighbor);
                }
            }
        }
        if(nodes != visitedNodes){
            System.out.println("Graph has cycle");
        }
        return result;
    }
}
public class TopologicalSortUsingAdjList {
    public static void main(String[] args) {
        int nodes = 6;
    
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(1, 4);
        a.addEdge(2, 4);
        a.addEdge(3, 5);
        a.addEdge(4, 5);
    
        System.out.println(a.topologicalSort());
    }
}*/

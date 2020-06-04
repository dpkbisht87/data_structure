package com.practice.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge{
    int distFromNode;
    int targetNode;
    
    public Edge(int distFromNode, int targetNode) {
        this.distFromNode = distFromNode;
        this.targetNode = targetNode;
    }
}

class Graph{
    List<List<Edge>> adjList;
    boolean[] visited;
    int[] mst;
    int nodes;
    
    
    Graph(int nodes){
        adjList = new ArrayList<>();
        this.nodes = nodes;
        visited = new boolean[nodes];
        for(int i = 0; i < nodes; i++){
            adjList.add(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int source, int destination, int distance){
        adjList.get(source).add(new Edge(distance, destination));
        adjList.get(destination).add(new Edge(distance, source));
    }
    
    public int mst(){
        int minCost = 0;
        for(int i = 0; i < nodes; i++){
            minCost = minCost + minimumSpanningTreeUnweightedGraph(i);
        }
        return minCost;
    }
    public int minimumSpanningTreeUnweightedGraph(int node){
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1, e2) -> e1.distFromNode - e2.distFromNode);
        List<Edge> neighborList = adjList.get(node);
        visited[node] = true;
        for(Edge neighbor: neighborList){
            if(!visited[neighbor.targetNode]){
                minHeap.add(neighbor);
            }
        }
        int minCost = 0;
        while(!minHeap.isEmpty()){
            Edge curr = minHeap.poll();
            if(visited[curr.targetNode]){
                continue;
            }
            visited[curr.targetNode] = true;
            minCost = minCost + curr.distFromNode;
            
            List<Edge> childList = adjList.get(curr.targetNode);
            for(Edge child: childList){
                if(!visited[child.targetNode]){
                    minHeap.add(child);
                }
            }
        }
        return minCost;
    }
}
public class PrimsAlgo {
    public static void main(String[] args) {
        int nodes = 5;
    
        Graph a = new Graph(nodes);
    
        a.addEdge(0, 1, 6);
        a.addEdge(0, 3, 4);
        a.addEdge(1, 2, 10);
        a.addEdge(1, 3, 7);
        a.addEdge(1, 4, 7);
        a.addEdge(2, 3, 8);
        a.addEdge(2, 4, 5);
        a.addEdge(3, 4, 12);
    
        System.out.println(a.mst());
    }
}

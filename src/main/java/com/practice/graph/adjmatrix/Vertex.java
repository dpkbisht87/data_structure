package com.practice.graph.adjmatrix;

public class Vertex {
    public char label;
    public boolean wasVisited;
    
    Vertex(char label){
        this.label = label;
        wasVisited = false;
    }
}

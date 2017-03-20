package com.java.datastructure;

import java.util.LinkedList;
import java.util.Queue;

//https://www.udemy.com/advanced-algorithms-in-java/learn/v4/t/lecture/2484016?start=0
//Time Complexity : O(V+E), V - Number of Vertices, E - Number of Edges
//Should print vertices by each row
public class BFS{
	public static void main(String[] args){
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);
		
		vertex1.addNeighbor(vertex2);
		vertex1.addNeighbor(vertex4);
		vertex4.addNeighbor(vertex5);
		vertex2.addNeighbor(vertex3);
		
		BFS bfs = new BFS();
		bfs.bfs(vertex1);
	}

	public void bfs(Vertex root){
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(root);
		root.setVisited(true);
		while(!queue.isEmpty()){
			Vertex vertex = queue.remove();
			System.out.println(vertex+"");
			for(Vertex v: vertex.getNeighborList()){
				if(!v.isVisited()){
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}




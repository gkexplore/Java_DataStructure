package com.java.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
		
		vertex1.addNeighborList(vertex2);
		vertex1.addNeighborList(vertex4);
		vertex4.addNeighborList(vertex5);
		vertex2.addNeighborList(vertex3);
		
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


class Vertex {
	
	public int data;
	public boolean visited;
	public List<Vertex> neighborList;
	
	Vertex(int data){
		this.data = data;
		this.neighborList = new ArrayList<Vertex>();
	}
	
	public void addNeighborList(Vertex vertext){
		neighborList.add(vertext);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighborList() {
		return neighborList;
	}

	public void setNeighborList(List<Vertex> neighborList) {
		this.neighborList = neighborList;
	}

	public String toString(){
		return data+"";
	}

}

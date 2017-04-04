package com.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.udemy.com/advanced-algorithms-in-java/learn/v4/t/lecture/3442528?start=0
//Time Complexity : O(V+E), V - Number of Vertices, E - Number of Edges
//Go till farthest node on the left/right and then backtrack
//Memory Complexity = O(Log N)
//
public class DFS {
	
	private Stack<Vertex> stack;
	
	public static void main(String[] args){
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		
		v1.addNeighbor(v2);
		v1.addNeighbor(v3);
		v3.addNeighbor(v4);
		v4.addNeighbor(v5);
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		
		DFS dfs = new DFS();
		dfs.dfs(vertexList);
	}
	
	public DFS(){
		 this.stack = new Stack<Vertex>();
	}
	
	public void dfs(List<Vertex> vertexList){
		for(Vertex v: vertexList){
			if(!v.isVisited()){
				v.setVisited(true);
				//dfsWithStack(v);
				dfsRecursive(v);
			}
		}
	}
	
	public void dfsWithStack(Vertex root){
	
		this.stack.push(root);
		root.setVisited(true);
		while(!this.stack.isEmpty()){
			Vertex actualVertex = this.stack.pop();
			System.out.println(actualVertex);
			for(Vertex v: actualVertex.getNeighborList()){
				if(!v.isVisited()){
					v.setVisited(true);
					this.stack.push(v);
				}
			}
		}
	}
	
	public void dfsRecursive(Vertex root){
		System.out.println(root);
		for(Vertex v: root.getNeighborList()){
			if(!v.isVisited()){
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}
}

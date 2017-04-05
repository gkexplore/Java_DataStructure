package com.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * https://www.udemy.com/advanced-algorithms-in-java/learn/v4/t/lecture/2484326?start=0
 * Dependency Management - Maven, Ant and Gradle
 * Continuous Integration Server - Tasks Dependency
 * Project Tasks
 * 
 *
 */
public class TopologicalOrdering {
	
	public static void main(String[] args){
		TopologicalOrdering to = new TopologicalOrdering();
		List<Vertex> graph = new ArrayList<Vertex>();
		
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		
		v2.addNeighbor(v3);
		v3.addNeighbor(v1);
		v4.addNeighbor(v0);
		v4.addNeighbor(v1);
		v5.addNeighbor(v0);
		v5.addNeighbor(v2);
		
		graph.add(v0);
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);
		
		for(Vertex v: graph){
			if(!v.isVisited())
				to.dfs(v);
		}
		
		for(Vertex v: graph){
			System.out.println(to.getStack().pop());
		}
		
		
	}
	
	private Stack<Vertex> stack;
	
	public TopologicalOrdering(){
		this.stack = new Stack<Vertex>();
	}
	
	public void dfs(Vertex root){
		root.setVisited(true);
		for(Vertex v: root.getNeighborList()){
			if(!v.isVisited()){
				dfs(v);
			}
		}
		this.stack.push(root);
	}
	
	public Stack<Vertex> getStack(){
		return stack;
	}
	
}

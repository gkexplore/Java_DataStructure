package com.java.datastructure;

import java.util.ArrayList;
import java.util.List;

/***
 * Cycle detection using dfs
 * https://www.udemy.com/advanced-algorithms-in-java/learn/v4/t/lecture/2484330?start=0
 *
 */
public class CycleDetection {
	
	public static void main(String[] args){
		
		CycleDetection cd = new CycleDetection();
		
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		
		v1.addNeighbor(v3);
		v1.addNeighbor(v2);
		v2.addNeighbor(v3);
		v4.addNeighbor(v1);
		v4.addNeighbor(v5);
		v5.addNeighbor(v6);
		v6.addNeighbor(v4);
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		
		cd.detectCycle(vertexList);
	}
	
	public void detectCycle(List<Vertex> vertexList){
		for(Vertex v: vertexList){
			if(!v.isVisited())
				dfs(v);
		}
	}
	
	public void dfs(Vertex vertex){
		System.out.println("Checking Vertex:"+vertex);
		vertex.setBeingVisited(true);
		//vertex.setVisited(false);
		for(Vertex v: vertex.getNeighborList()){
			if(v.isBeingVisited()){
				System.out.println("There is a cycle in the graph");
				return;
			}if(!v.isVisited()){
				v.setVisited(true);
				System.out.println("recurssing the vertex");
				dfs(v);
			}
		}
		System.out.println("done:"+vertex);
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}
	
}

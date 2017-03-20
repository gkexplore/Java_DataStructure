package com.java.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	public int data;
	public boolean visited;
	public List<Vertex> neighborList;
	
	Vertex(int data){
		this.data = data;
		this.neighborList = new ArrayList<Vertex>();
	}
	
	public void addNeighbor(Vertex vertext){
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
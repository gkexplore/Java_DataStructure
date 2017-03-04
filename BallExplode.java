package com.java.datastructure;
//This program is find the floor where the ball starts to explode
//Big O(log N)
public class BallExplode {
	public static void main(String[] args){
		int[] floors = new int[100];
		for(int i=0;i<100;i++){
			floors[i] = i;
		}
		System.out.println(findFloor(floors, 0, floors.length));
	}
	
	public static int findFloor(int[] floors, int low, int high){
		int mid = low + (high - low)/2;
		 System.out.println(low+"-"+mid+"-"+high);
		 if(high==low) 
		 		return mid;
		 if(checkIfBallExplode(floors[mid])){
				return findFloor(floors, low, mid);
		 }else{
				return findFloor(floors, mid+1, high);
		}
	}
	
	public static boolean checkIfBallExplode(int floor){
		if(floor>=60){
			return true;
		}else {
			return false;
		}
	}
}

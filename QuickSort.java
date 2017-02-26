package com.java.datastructure;

//Reference - https://www.youtube.com/watch?v=COk73cpQbFQ

//This program is to sort given array in ascending order using quick sort
//Time Complexity in Best case - Big O(n log n)
//Time Complexity in worst case - Big O(n2)
//Space complexity - Big O(log n)
public class QuickSort {
	public static void main(String[] args){
		String[] names = {"kumar", "karthik", "kannan", "Anbu", "Alagu"};
		int start = 0;
		int end = names.length-1;
		quickSort(names, start, end);
		for(String name: names){
			System.out.println(name);
		}
	}
	
	public static void quickSort(String[] listOfString, int start, int end){
		if(start < end){
			//finding pivot index
			int pIndex = partition(listOfString, start, end);
			quickSort(listOfString, start, pIndex-1);
			quickSort(listOfString, pIndex+1, end);
		}
	}
	
	public static int partition(String[] listOfString, int start, int end){
		
		String pivot = listOfString[end];
		int pIndex = start;
		for(int i=start;i<end;i++){
			if(listOfString[i].compareTo(pivot)<=0){
				swap(listOfString, i, pIndex);
				pIndex+=1;
			}
		}
		swap(listOfString, pIndex, end);
		
		return pIndex;
	}
	
	public static void swap(String[] listOfString, int i, int j){
		String temp = listOfString[i];
		listOfString[i] = listOfString[j];
		listOfString[j] = temp;
	}
	
}

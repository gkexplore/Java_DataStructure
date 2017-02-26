package com.java.datastructure;


//This program is to sort given array using merge sort
//Time complexity best case and worst case - Big O(n log n)
//space complexity - Big O(n)
public class MergeSort{
	
	public static void main(String[] args){
		String[] names = {"kumar", "karthik", "kannan", "Anbu", "Alagu"};
		mergeSort(names);
		for(String name: names){
			System.out.println(name);
		}
	}
	
	public static void mergeSort(String[] names){
		if(names.length>=2){
			String[] left = new String[names.length/2];
			String [] right = new String[names.length - left.length];
			
			for(int i=0;i<left.length;i++){
				left[i] = names[i];
			}
			
			for(int j=0;j<right.length;j++){
				right[j] = names[j + names.length/2];
			}
			
			mergeSort(left);
			mergeSort(right);
			merge(names, left, right);
		}
	}
	
	public static void merge(String[] names, String[] left, String[] right){
		int a = 0;
		int b = 0;
		
		for(int i=0; i<names.length;i++){
			if(b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)){
				names[i] = left[a];
				a++;
			}else{
				names[i] = right[b];
				b++;
			}
		}
	}
	
}

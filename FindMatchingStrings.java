package com.java.datastructure;

import java.util.Set;
import java.util.TreeSet;

//Amazon tech interview solved
//This program is to find matching string in two array. Also to merge two sorted array

public class FindMatchingStrings{
	
	public static void main(String[] args){

		String[] firstArray = {"m","c","b","a"};
		String[] secondArray = {"a", "c", "m", "b"};
		
		mergeSort(firstArray);
		mergeSort(secondArray);
        String[] mergedArray = new String[firstArray.length + secondArray.length];
        merge(mergedArray, firstArray, secondArray); 
        
        //print matched strings in both arrays
		for(String word: findMacthedWords(firstArray, secondArray)){
			System.out.println(word);
		}
		
		//print merged and sorted array
		System.out.println("Merged Array");
		for(String str: mergedArray){
			System.out.println(str);
		}
	}
	
	private static Set<String> findMacthedWords(String[] firstArray, String[] secondArray){
		
		Set<String> matchedList = new TreeSet<String>();
		if(firstArray.length < secondArray.length){
			for(int i=0;i<firstArray.length;i++){
				if(binarySearch(secondArray, firstArray[i]) >=0){
					matchedList.add(firstArray[i]);
				}
			}
		}else{
			for(int i=0;i<secondArray.length;i++){
				if(binarySearch(firstArray, secondArray[i]) >=0){
					matchedList.add(secondArray[i]);
				}
			}
		}
		return matchedList;
		
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
	
	private static int binarySearch(String[] a, String key){
		return binarySearch(a, key, 0, a.length);
	}
	
	private static int binarySearch(String[] a, String key, int low, int high){
		int mid = low + (high - low)/2;
		if(high <= low){
			return -1;
		}
		
		int cmp = a[mid].compareTo(key);
		if(cmp < 0){
			return binarySearch(a, key, mid+1, high);
		}else if(cmp > 0){
			return binarySearch(a, key, low, mid);
		}else{
			return mid;
		}
	}
	
}
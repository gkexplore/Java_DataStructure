package com.java.datastructure;

import java.util.Arrays;

//Starbucks interview
//http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
//Time Complexity for n x n matrix: Big O(n)
//Time Complexity for m x n matrix: Big O(m + n)

public class SearchInMatrix {
	public static void main(String[] args){
		int[][] a = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		System.out.println(search(a, a.length, 1));
	}
	
	public static boolean search(int[][] a, int n, int x){
		int i=0;
		int j=n-1;
		while(i<n && j >= 0){
			if(a[i][j] == x){
				System.out.println(i+"-"+j);
				return true;
			}else if(a[i][j] > x){
				j--;
			}else{
				i++;
			}
		}
		return false;
	}
}

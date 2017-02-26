package com.java.datastructure;
import java.util.Arrays;
import java.util.Collections;

//This program is to sort the given array using merge sort(O(n log n)) and search the given string using binary search
//O(log n)
public class BinarySearch {

	// return the index of the key in the sorted array a[]; -1 if not found
	public static int search(String key, String[] a) {
		return search(key, a, 0, a.length);
	}

	public static int search(String key, String[] a, int lo, int hi) {
		if (hi <= lo) 
			return -1;
		
		int mid = lo + (hi - lo) / 2;
		
		int cmp = a[mid].compareTo(key);
		if      (cmp > 0) 
			return search(key, a, lo, mid);
		else if (cmp < 0) 
			return search(key, a, mid+1, hi);
		else              
			return mid;
	}

	public static void main(String[] args) {
		
		String[] names = {"kumar", "karthik", "kannan", "Anbu", "Alagu"};
		mergeSort(names);
		System.out.println(Arrays.toString(names));
		System.out.println(search("Anbu", names));

	}

	public static void mergeSort(String[] names) {
		if (names.length >= 2) {
			String[] left = new String[names.length / 2];
			String[] right = new String[names.length - names.length / 2];

			for (int i = 0; i < left.length; i++) {
				left[i] = names[i];
			}

			for (int i = 0; i < right.length; i++) {
				right[i] = names[i + names.length / 2];
			}

			mergeSort(left);
			mergeSort(right);
			merge(names, left, right);
		}
	}

	public static void merge(String[] names, String[] left, String[] right) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < names.length; i++) {
			if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
				names[i] = left[a];
				a++;
			} else {
				names[i] = right[b];
				b++;
			}
		}
	}
}
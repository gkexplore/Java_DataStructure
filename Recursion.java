package com.java.datastructure;

//Recursion - best sample - factorial - https://www.youtube.com/watch?v=PORo1ut9kMs
//Recursion - best sample - fibonacci - https://www.youtube.com/watch?v=dsmBRUCzS7k
public class Recursion {
	
	public static void main(String[] args){
		Recursion recursion = new Recursion();
		System.out.println("***********************Factorial*************************");
		recursion.factorial(4);
		System.out.println("***********************Fibonacci*************************");
		int i = 0;
		while(i<8){
			System.out.println(recursion.fibonacci(i));
			i++;
		}
		recursion.fibonacci(7);
		System.out.println(recursion.reverseString("Karthik"));
	}
	
	public int factorial(int n){
		if(n==1){
			return 1;
		}else{
		    int result = n * factorial(n-1);
		    return result;
		}
	}
	
	public long fibonacci(int n){
		
		if(n==0){
			return 0;
		}
		if(n <=2 ){
			return 1;
		}
		
		long fib = fibonacci(n-1) + fibonacci(n-2);
		return fib;
	}
	
	public String reverseString(String str){
		if(str.length()==1)
			return str;
		else
			System.out.println(str.substring(1, str.length())+"+"+str.charAt(0));
			return reverseString(str.substring(1, str.length()))+str.charAt(0);
	}
}

package com.java.datastructure;
import java.util.*;


//implement queue using stack

public class Queue{
	
	Stack<Integer> originalStack;
	Stack<Integer> tempStack;
	
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
	}
	
    public Queue(){
    	this.originalStack = new Stack<Integer>();
    	this.tempStack = new Stack<Integer>();
    }
	
	public void enqueue(int data){
		if(originalStack.isEmpty()){
			this.originalStack.push(data); //1
		}else{
			while(!originalStack.isEmpty()){
				this.tempStack.push(this.originalStack.pop());//1,2,3,4
			}
			
			this.originalStack.push(data);//4
			
			while(!this.tempStack.isEmpty()){
				this.originalStack.push(this.tempStack.pop()); //4,3,2,1
			}
			
		}
	}
	
	public Integer dequeue(){
		return originalStack.pop();
	}
	
}


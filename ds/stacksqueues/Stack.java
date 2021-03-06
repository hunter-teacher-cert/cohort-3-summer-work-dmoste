/*
Since stacks are a LIFO structure, the list only ever gets accessed from one end.
This means we don't have to worry about shifting items as new items are added or removed.
So for ease, we chose to use an array list.
*/

import java.io.*;
import java.util.*;

public class Stack{

  // Place private instance variables here
  private ArrayList<Integer> data;
  private int stackSize;

  // Place constructors here - A constructor with no parameters
  public Stack(){
    data = new ArrayList<Integer>();
    stackSize = 0;
  }

  // Place methods here

  // void push(int value) - add value to the top of the stack
  public void push(int value){
    data.add(value);
    stackSize++;
  }

  // int pop() - remove and return the top value from the stack
  public int pop(){
    int value = -1;

    if(stackSize > 0){
      value = data.get(stackSize-1);
      data.remove(stackSize-1);
      stackSize--; 
    }

    return value;
  }

  // int top() - return but do not remove the top value from the stack
  public int top(){
    int value = -1;

    if(stackSize > 0){
      value = data.get(stackSize-1);
    }
    
    return value;
  }

  // boolean isEmpty() - return true of the stack is empty, false otherwise
  public boolean isEmpty(){
    if(stackSize < 1){
      return true;
    }

    return false;
  }

  // int size() - return the number of elements currently in the stack
  public int size(){
    return stackSize;
  }

  // boolean isFull() - returns true if the stack is full, false otherwise - only implement this if you use an array for implementation
  public boolean isFull(){
    return false;
  }

  public String toString(){
    String temp = "\n---Current State of Stack---\nTop of Stack\n";

    for(int i = stackSize-1; i >= 0; i--){
      temp += data.get(i) + "\n";
    }

    temp += "Bottom of Stack\n";
    
    return temp;
  }

}
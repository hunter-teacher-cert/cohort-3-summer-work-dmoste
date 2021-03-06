import java.io.*;
import java.util.*;

/**
For all attempted methods, make sensible decisions for error and
edge cases (such as indexing out of bounds).
Basic
-----
add(string value)
get(int index);
toString()
Intermediate (at least add, size + one of the other two)
------------
size()
add(int index,String value)
indexOf(String value);
toArray()
Challenge
--------
remove(int index);
*/

public class LinkedList{

  private Node head;

  public LinkedList(){
    head = null;
  }

  /**
  Parameters:
  value - the new string to add to the list
  Adds a new node containing value to the front of the list.
  */
  public void add(String value){
    head = new Node(value, head);
  }

  /**
  Returns the String in the node at location index.
  */
  public String get(int index){
    if(index >= 0){
      Node walker = head;
      
      for(int i = 0; i < index; i++){
        if(walker != null){
          walker = walker.getNext();
        }else{
          return "Index out of bounds";
        }
      }
      
      return walker.getData();
    }else{
      return "Indices must be positive";
    }
  }

  /**
  returns the number of elements in the lsit
  */
  public int size(){
    Node walker = head;
    int counter = 0;

    while(walker != null){
      counter++;
      walker = walker.getNext();
    }

  	return counter;
  }


  /**
  Returns the index (location) of the first node in the list
  that contains value.
  Example:
  Given the list:
  "a"->"b"->"c"->"d"->"e"
  indexOf("d") would return 3 since "d" is at location 3.
  */
  public int indexOf(String value){
    Node walker = head;
    int counter = 0;

    while(walker != null){
      if(walker.getData() == value){
        return counter;
      }else{
        counter++;
        walker = walker.getNext();
      }
    }
	
    return -1;
  }



  /**
  Return a string representation of the list
  */
  public String toString(){
    Node walker = head;
    String temp = "";

    while(walker != null){
      temp += walker.getData() + "->";
      walker = walker.getNext();
    }

    temp += "null";
    
	return temp;
  }




  /**
  Parameters:
  index - an int with the location to add
  value - the new value
  Adds a new node with the String value to the list.
  The new node should be added at the location specified by the index.
  For example, given the list:
  "a" -> "b" -> "c" -> "d"
  add(1,"z") results in:
  "a"-> "z" -> "b" -> "c" -> "d"
  */
  public void add(int index, String value){
    Node walker = head;
    Node n = new Node(value);

    if(index == 0){
      add(value);
    }else{
      for(int i = 0; i < index-1; i++){
        walker = walker.getNext();
      }
      n.setNext(walker.getNext());
      walker.setNext(n);
    }
  }



  /**
  This routine should create a new array that is the same
  size as the number of Nodes in the list.
  It should then copy all of the values to the array and return
  the array.
  */
  public String[] toArray(){
    Node walker = head;
    int counter = size();

    String[] data = new String[counter];

    for(int i = 0; i < counter; i++){
      data[i] = walker.getData();
      walker = walker.getNext();
    }
    
    return data;
  }



  /**
  Remove the Node at location index from the list.
  Ex:
  Given the list:
  "a"->"b"->"c"->"d"->"e"
  remove(2) results in:
  "a"->"b"->"d"->"e"
  */
  public void remove(int index){
    Node walker = head;

    if(index == 0){
      head = head.getNext();
    }else{
      for(int i = 0; i < index-1; i++){
        walker = walker.getNext();
      }

      walker.setNext(walker.getNext().getNext());
    }
  }
}
import java.io.*;
import java.util.*;

public class ExpressionTree{


  //You must write this method:
  //Calculate the value of the entire tree
  public double evaluate(){
    if(isValue()){
      return value;
    }
    
    return apply(left.evaluate(), right.evaluate(), operator);
  }

  //You must write this method:
  //Return a string representation of the tree
  //A value is just the string of the value
  //An operation has parenthesis around
  //such as
  //"12.5"  //just a value
  //"(5.0-8.0)" //a tree with 2 value children
  //"(12.5*(5.0-8.0)) //a tree that is the product of the previous two example trees
  //"(((2.0+1.0)/(8.0*0.43)) - 1.0)" //a tree with more
  public String toString(){
    if(isValue()){
      return "" + value;
    }
    
    return "(" + left + operator + right + ")";
  }




  private double value;
  private ExpressionTree left,right;
  private char operator;

  //Tree can be a value
  public ExpressionTree(double val){
   value = val;
   left = null;
   right = null;
  }

  //Tree can be an operator that connects two sub-trees
  public ExpressionTree(char op, ExpressionTree l, ExpressionTree r){
    operator = op;
    left = l;
    right = r;
  }

  //Operator for square root functionality
  public ExpressionTree(char op, ExpressionTree l){
    if(op == 's'){
      operator = '^';
    }else{
      operator = op;
    }

    left = l;
    right = new ExpressionTree(0.5);
  }

  //Return true when the node is a value, false when it is an operator
  //when the children are null, the current tree is a value
  private boolean isValue(){
    return left == null && right == null;
  }

  //Return false when the node is a value, true when it is an operator
  private boolean isOperator(){
    return !isValue();
  }

  //To simplify things, you get a method to use to convert the
  //operator and two values into a result.
  private double apply(double a, double b, char op){
   if(op == '+'){
    return a+b;
   }else if(op == '-'){
    return a-b;
   }else if(op == '*'){
    return a*b;
   }else if(op == '^'){
     return Math.pow(a,b);
   }else{ //  if(op == '/'){ //or any invalid operators
    return a/b;
   }

  }

 }
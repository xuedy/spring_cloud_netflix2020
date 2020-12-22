package com.xue.example.clients;

class Person{
private String name;
private int age;
private static String address;
private final static String hobby="Programming";
public void say(){
System.out.println("person say...");
}
public int calc(int op1,int op2){
return op1+op2;
}
}
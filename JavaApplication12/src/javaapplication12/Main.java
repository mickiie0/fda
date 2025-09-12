package javaapplication12;

class Data{
    String name;
    int age;

    public Data(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString(){
        return name+" age: "+age;
    }
    
    
}

class Node{
    Data data;
    Node next;
    Node prev;

    public Node(Data newData) {
        data = newData;
    }
    
}

class LinkedList{
    Node head;
    Node tail;
    int count;
    
    public void addFirst(Data newData){
        Node newNode = new Node(newData);
        if(head == null) head = tail = newNode;
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }
    
    public void addLast(Data newData){
        Node newNode = new Node(newData);
        if(tail == null) head = tail = newNode;
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }
 
    public void removeFirst(){
        head = head.next;
//        head = null;
        count--;
    }
    
    public void removeLast(){
//        tail = null;
        tail = tail.prev;
        tail.next = null;
        count--;
    }
    
    public void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.data.toString()+", ");
            current = current.next;
        }
        System.out.println("\nData : "+count);
    }
}

public class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        Data d1 = new Data("Mix", 22);
        Data d2 = new Data("Fong", 21);
        Data d3 = new Data("Guy", 22);
        
        list.addFirst(d1);  //Mix
        list.addFirst(d2);  //Fong, Mix
        list.addLast(d3);   //Fong, Mix, Guy
        
        System.out.println("Before : ");
        list.print();
        
        list.removeFirst();  //Mix, Guy
        list.removeLast();  //Fong, Mix
        
        System.out.println("\n\nAfter : ");
        list.print();
        
    }
}
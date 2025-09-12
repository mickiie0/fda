package javaapplication12;

import java.util.*;

class Data {

    String name;
    int age;

    public Data(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " age: " + age;
    }

}

class Node {

    Data data;
    Node next;
    Node prev;

    public Node(Data newData) {
        data = newData;
    }

}

class LinkedList {

    Node head;
    Node tail;
    int count;

    public void addFirst(Data newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }

    public void addLast(Data newData) {
        Node newNode = new Node(newData);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    public void addAt(int index, Data newData) {
        if (index < 1 || index > count) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node newNode = new Node(newData);

        if (index == 1) {
            addFirst(newData);
            return;
        }
        if (index == count+1) {
            addLast(newData);
            return;
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;

        count++;
    }

    public void removeFirst() {
        head = head.next;
        count--;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        count--;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data.toString() + ", ");
            current = current.next;
        }
        System.out.println("\nData : " + count);
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Data d1 = new Data("Mix", 22);
        Data d2 = new Data("Fong", 21);
        Data d3 = new Data("Guy", 22);
        Data d4 = new Data("Pao", 20);

        list.addFirst(d1);  //Mix
        list.addFirst(d2);  //Fong, Mix
        list.addLast(d3);   //Fong, Mix, Guy
//        list.addLast(d4);   //Fong, Mix, Guy

        System.out.println("Before : ");
        list.print();

        list.removeFirst();  //Mix, Guy
//        list.removeLast();  //Fong, Mix

        System.out.println("\n\nAfter : ");
        list.print();
        
        list.addAt(2, d4);  //fong,pao,mix
        
        System.out.println("\n\nafter addAt : ");
        list.print();
    }
}

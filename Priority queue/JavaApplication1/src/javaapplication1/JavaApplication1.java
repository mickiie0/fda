package javaapplication1;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Student{
    String code;
    String name;
    double gpa;

    public Student(String code, String name, double gpa) {
        this.code = code;
        this.name = name;
        this.gpa = gpa;
    }
    
    public String toString(){
        return code+"-"+name+"-"+gpa;
    }
}

class StudentComparator implements Comparator<Student>{
    
    @Override
    public int compare(Student s1,Student s2){
        if(s1.code.hashCode() > s2.code.hashCode()) return 1;
        else if (s1.code.hashCode() < s2.code.hashCode()) return -1;
        return 0;
    }
}

public class JavaApplication1 {
    public static void main(String[] args) {
        
                //Natural ordering
//        Queue<String> pq = new PriorityQueue<>();
//        pq.add("ABC");
//        pq.add("ACB");
//        pq.add("AAB");
//        
//        System.out.println(pq); //[aab,acb,aab]
//        
//        String x = pq.element();
//        System.out.println(x);  //aab
//        
//        pq.remove();
//        System.out.println(pq); //abc,acb
//        
//        pq.remove();
//        System.out.println(pq); //acb


                //reverse ordering
//        Queue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
//        pq.add("ABC");
//        pq.add("ACB");
//        pq.add("AAB");
//        
//        System.out.println(pq); //[]
//        
//        String x = pq.element();
//        System.out.println(x);  //
//        
//        pq.remove();
//        System.out.println(pq); //
//        
//        pq.remove();
//        System.out.println(pq); //
        

                //queue with object
            Queue<Student> pq = new PriorityQueue<>(new StudentComparator());  //need comparator to compare values
            pq.add(new Student("001","A",2.50));
            pq.add(new Student("003","C",2.75));
            pq.add(new Student("002","B",3.50));
            
            System.out.println(pq);
            
            Student x = pq.poll();
            System.out.println(x);
            
            Student y = pq.poll();
            System.out.println(y);
    }
    
}

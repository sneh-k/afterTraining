package com.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Assign8 implements Runnable
{
       static List<Integer> li = new ArrayList<Integer>();
       Assign8()
       {
              Thread t= new Thread(this);
              t.start();
              
       }
       @Override
       public void run() {
              Consumer<Integer> c = (list) ->System.out.print("\t"+list);
              print(li,c);
       } 
       void print(List<Integer> li,Consumer<Integer> c)
       {
              for(Integer i:li)    
                     c.accept(i);
       }
public static void main(String args[])
       {  
              
              new Assign8();
              li.add(21);
              li.add(10);
              li.add(36);
              li.add(101);
                     
       }

}

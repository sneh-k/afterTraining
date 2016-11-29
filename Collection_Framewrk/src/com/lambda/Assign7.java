package com.lambda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Assign7 {
       public static void main(String args[])
       {
              HashMap<Integer, String> newmap = new HashMap<Integer, String>();
             StringBuilder str=new StringBuilder();
              
                 newmap.put(1, "A");
                 newmap.put(2, "B");
                 newmap.put(3, "C");
                 newmap.put(4, "D");
                 newmap.put(5, "3");
                    
                Object s;
                 Set<?> set=newmap.entrySet();
                 Iterator<?> itr=set.iterator();
                     while ( itr.hasNext( ) ) 
                     {      s=itr.next();
                           System.out.println( s );
                           str.append(s);
                     }
                 System.out.println("Set values: " + str);
       }
}

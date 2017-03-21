package com.java.test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by Seven on 2017/3/16.
 */

public class Demo {
    public static ReferenceQueue<Store> queue = new ReferenceQueue<Store>();

    public static void checkQueue()
    {
        if(queue!=null)
        {
            @SuppressWarnings("unchecked")
            Reference<Store> ref =(Reference<Store>)queue.poll();
            if(ref!=null)
                System.out.println(ref+"......"+ref.get());
        }
    }

    public static void main(String[] args) {

        String string1 = "a";
        String  string2 = "b";
        String string3 = "ab";
        String string5 = "a"+"b";
        final String string7 = "a";
        final String string9 = "b";
        String string4 = string1 + string2;
        String string6 = string7+"b";
        String string8 = string1+"b";
        String string11 = "abc".substring(0,2);
        String string10 = string7 +string9;
        System.out.println(string4 == string3);
        System.out.println(string5 == string3);
        System.out.println(string6 == string3);
        System.out.println(string8 == string3);
        System.out.println(string7 == string1);
        System.out.println(string10 == string3);
        System.out.println(string11 == string3);
    }
}

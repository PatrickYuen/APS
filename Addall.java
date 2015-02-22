 import java.text.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Addall {
    public static void main (String[] args)
    { 
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int sum = 0;
        int realsum = 0;
        PriorityQueue<Integer> arr = new PriorityQueue<Integer>();

        while(input != 0) {
            for(int i = 0; i < input; i++) {
                arr.add(in.nextInt());   
            }
            
            while(arr.size() != 1) {
                sum = arr.poll() + arr.poll();
                realsum += sum;
                arr.add(sum);
            }
            System.out.println(realsum);
            sum = 0;
            realsum = 0;
            arr.clear();
            input = in.nextInt();
        }
    }
}
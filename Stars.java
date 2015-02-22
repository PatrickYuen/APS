import java.text.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Stars {
    public static int[] table;

    public static int sumQuery(int a, int b) {
        return sumQuery(b) - sumQuery(a - 1);
    }

    public static int sumQuery(int k) {
        int ret = 0;
        while (k > 0) {
            ret += table[k];
            k &= k - 1;
        }
        return ret;
    }

    public static void adjust(int i) {
        while (i < table.length) {
            table[i] ++;
            i += (i & (-i));
        }
    }
    
    public static void main (String[] args)
    { 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            table = new int[32010];
            int[] level = new int[32010];
            int num = Integer.parseInt(in.readLine());
            String[] some = null;
            int x;
            for(int i = 0; i < num; i++) {
                some = in.readLine().split("\\s");
                x = Integer.parseInt(some[0]) + 1;
                level[sumQuery(x)]++;
                adjust(x);
            }
            for(int i = 0; i < num; i++) {
                System.out.println(level[i]);
            }
        } catch (IOException e)
        {  e.printStackTrace(); }     
    }
}
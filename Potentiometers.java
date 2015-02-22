import java.text.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Potentiometers {
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

    public static void adjust(int i, int adj) {
        while (i < table.length) {
            table[i] += adj;
            i += (i & (-i));
        }
    }
    
    public static void main (String[] args)
    { 
        StringBuilder answer = new StringBuilder("");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            int num = Integer.parseInt(in.readLine());
            table = new int[200010];
            String temp;
            String[] some = null;
            int sum;
            int change;
            int casenum = 1;
            while (num != 0) {
                answer.append("Case " + casenum + ":\n");
                for(int i = 1; i <= num; i++) {
                    change = Integer.parseInt(in.readLine());
                    adjust(i, change);
                }
                temp = in.readLine();
                while(!temp.equals("END")) { 
                   some = temp.split("\\s");
                   if (some[0].equals("M")) {
                       sum = sumQuery(Integer.parseInt(some[1]), Integer.parseInt(some[2]));
                       answer.append(sum).append("\n");
                   } else if (some[0].equals("S")) {
                       change = Integer.parseInt(some[1]);
                       adjust(change, Integer.parseInt(some[2]) - sumQuery(change, change));
                   }        
                   temp = in.readLine();
                }
                casenum++;
                Arrays.fill(table, 0);
                num = Integer.parseInt(in.readLine());
                if(num!=0) answer.append("\n");
            }
            System.out.print(answer);
        } catch (IOException e)
        {  e.printStackTrace(); }     
    }
}
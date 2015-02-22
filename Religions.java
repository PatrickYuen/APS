 import java.text.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Religions {
    public static void main (String[] args)
    { 
       BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String s = bufferRead.readLine();
            int round = 1;
            
            String[] line;
            int m;
            int n;
            int[] parent;
            int pa;
            int pb;
            int a;
            int b;
            
            while(!s.equals("0 0")) {
                line = s.split(" ");
                m = Integer.parseInt(line[0]);
                n = Integer.parseInt(line[1]);
                
                parent = new int[m + 1];
                for (int i = 0; i <= m; i++)
                    parent[i] = i;
                
                for(int i = 0; i < n; i++) {
                    s = bufferRead.readLine();
                    line = s.split(" ");
                    a = Integer.parseInt(line[0]);
                    b = Integer.parseInt(line[1]);
                    pa = a;
                    pb = b;
                    while(parent[pa] != pa)
                        pa = parent[pa];
                    while(parent[pb] != pb)
                        pb = parent[pb];
                    if(pb != pa) {
                        m--;
                        parent[pa] = pb;
                    }
                }

                System.out.println("Case " + round + ": "+  m);
               
                round++;

                s = bufferRead.readLine();
            }
        } catch (IOException e) { e.printStackTrace();}
    }
}
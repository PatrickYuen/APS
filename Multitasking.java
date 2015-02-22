 import java.text.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Multitasking {
    public static void main (String[] args)
    { 
        Scanner in = new Scanner(System.in);
        
        int[] range = new int[1000010];
        int taskstart[] = new int[110];
        int taskend[] = new int[110];
        int reptaskstart[] = new int[110];
        int reptaskend[] = new int[110];
        int reptaskint[] = new int[110];
       
        int numtask = in.nextInt();
        int reptask = in.nextInt();
        int result = 0;
        int start;
        int end;
        int rep;
        
        while(numtask != 0 || reptask != 0) {
            for(int i = 0; i < numtask; i++) {
                start = in.nextInt();
                end = in.nextInt();
                for(int c = start; c < end; c++)  
                    range[c]++;
            }
            
            for(int i = 0; i < reptask; i++) {
                start = in.nextInt();
                end = in.nextInt();
                rep = in.nextInt();
                
                while(end<=1000010)  {  
                    for(int c = start; c < end; c++) {  
                        range[c]++;  
                    }  
                    start += rep;  
                    end += rep;  
                    if(end>1000010 && start < 1000010)
                        end = 1000010;
                }  
            }  
                
            for(int i=0; i < 1000010;i++)  
                if(range[i]>1)  {  
                    result=1;  
                    break;  
                }  
            
                if(result == 1)
                    System.out.println("CONFLICT");
                else
                    System.out.println("NO CONFLICT");
                      
            result = 0;
            numtask = in.nextInt();
            reptask = in.nextInt();
            Arrays.fill(range, 0);
        }
    }
}
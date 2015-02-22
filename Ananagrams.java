import java.text.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Ananagrams {
    public static void main (String[] args)
	{ 
       Scanner in = new Scanner(System.in);
       int[] word = new int[26];
       HashMap<String,Integer> dict = new HashMap<String,Integer>();
       String input = "";
       String temp = in.nextLine();
       String orig;
       
        while(!temp.equals("#")) {
               input += " " + temp; 
               temp = in.nextLine();
        }   
        
       StringTokenizer token = new StringTokenizer(input);
       while(token.hasMoreTokens()) {
           Arrays.fill(word, 0);
           orig = token.nextToken();
           temp = orig.toLowerCase();
           for(char i: temp.toCharArray()) { 
                word[i - 'a'] += 1;
           }
           temp = Arrays.toString(word);
           if(!dict.containsKey(temp))
               dict.put(temp,1);
           else
               dict.put(temp,dict.get(temp) + 1);
       }   
       
       ArrayList<String> answer = new ArrayList<String>();
       
       token = new StringTokenizer(input);
       while(token.hasMoreTokens()) {
           Arrays.fill(word, 0);
           orig = token.nextToken();
           temp = orig.toLowerCase();
           for(char i: temp.toCharArray()) { 
               word[i - 'a'] += 1;
           }
           temp = Arrays.toString(word);
          
           if(dict.get(temp) == 1)
               answer.add(orig);
       } 
       Collections.sort(answer);
       for(String i: answer)
           System.out.println(i);
     
	}
}
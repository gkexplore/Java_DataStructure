package com.java.datastructure;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//FFS Phoenix Interview
//Find missing word in a array
public class Solution {
    /*
 * Complete the function below.
 */
 
 //I am using hackerrank to improve programming
 //  am       hackerrank to improve

    static String[] missingWords(String s, String t) {
            List<String> missinglist = new ArrayList<String>();
            String[] wordsT = t.split(" ");
            String[] wordsS = s.split(" ");
            int j=0;
            for(int i=0;i<wordsS.length;i++){
                
                if(j < wordsT.length && wordsS[i].equalsIgnoreCase(wordsT[j])){
                    j++;
                }
                else{
                    missinglist.add(wordsS[i]);
                }
            }
            String [] result = new String[missinglist.size()];
        return missinglist.toArray(result);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
        
        String _t;
        try {
            _t = in.nextLine();
        } catch (Exception e) {
            _t = null;
        }
        
        res = missingWords(_s, _t);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}
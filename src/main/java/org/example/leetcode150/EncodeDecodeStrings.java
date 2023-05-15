package org.example.leetcode150;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        EncodeDecodeStrings sol = new EncodeDecodeStrings();
        String encoded = sol.encode(List.of("i:n*9a#", "min67a@", "di&##ka"));
        System.out.println("Encode:" + encoded);
        List<String> words = sol.decode(encoded);
        System.out.println(words);

    }


    public String encode(List<String> strs) {
        // write your code here
        StringBuilder builder = new StringBuilder();
        for(String str: strs) {
            int length = str.length();
            builder.append(length+"#" + str);
        }
        return builder.toString();
    }


    public List<String> decode(String str) {
        char[] arr = str.toCharArray();
        List<String> words = new LinkedList<>();
        int i = 0;
        while(i< arr.length) {
            //find first #
            StringBuilder digits = new StringBuilder();
            while(arr[i] != '#'){
                digits.append(arr[i]);
                i++;
            }
            int N = Integer.valueOf(digits.toString());
            i++; //Skip#

            StringBuilder word = new StringBuilder();
            for(int j=0; j<N; j++) {
                word.append(arr[i++]);
            }
            words.add(word.toString());
        }
        return words;
    }
}

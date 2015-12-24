package com.zhangyin.leetcode;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 *  For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *  For "bbbbb" the longest substring is "b", with the length of 1.
 * @author yin
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("au"));
	}
	public static int lengthOfLongestSubstring(String s) {
	        int result=0;
	        int start=0;
	        for (int i = 0; i < s.length(); i++) {
	           char c = s.charAt(i);
	           if(result==0){
	        	   result=1;
	        	   continue;
	           }
	           String substring = s.substring(start, i);
	           int indexOf = substring.indexOf(c);
	           if(indexOf>-1){  //不包含
	        	   start+=indexOf+1; 
	        	   if(substring.length()>result){
		        		  result=substring.length()+1;
		           }
	           }else{
	        	   if(substring.length()+1>result){
		        		  result=substring.length()+1;
		           } 
	           }
	           
	        }
	        return result;
	}

}

package com.zhangyin.leetcode;
/***
 * 
 * 
 * Given a string S, find the longest palindromic substring in S.
 *  You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author yin
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring l=new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("abbacvcvc"));
	}
	
	 public String longestPalindrome(String s) {
		 if(s.length()<=1){
			 return s;
		 }
		 StringBuffer sb=new StringBuffer();
		 sb.append("#");
		 for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			sb.append("#");
		}
		 s=sb.toString();
		 String result="";
		 for (int i = 1; i < s.length(); i++) {
			 String getstring = getstring(s, i);
			 if(getstring.length()>result.length()){
				 result=getstring;
			 }	 
		} 
		 sb=new StringBuffer();
		 for (int i = 0; i < result.length(); i++) {
			if(result.charAt(i)!='#'){
				sb.append(result.charAt(i));
			}
		}
		 return sb.toString();
	  }
	 
	 public String getstring(String s,int i){
		 int index=1;
		 while(i-index>=0&&i+index<=s.length()-1&&s.charAt(i-index)==s.charAt(i+index)){
			 if(i-index==0||i+index==s.length()-1){
				 break;
			 }
			 index++;
		 }
		 if(i-index==0||i+index==s.length()-1){
			 return s.substring(i-index, i+index);	
		 }else{
			 index--;
			 return s.substring(i-index, i+index);	 
		 }
	 }

}

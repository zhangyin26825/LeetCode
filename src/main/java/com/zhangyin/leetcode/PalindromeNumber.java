package com.zhangyin.leetcode;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		boolean palindrome = PalindromeNumber.isPalindrome(435654);
		System.out.println(palindrome);
	}
	
	public static  boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		if(x<10){
			return true;
		}
        String s=Integer.toString(x);
        if(s.length()%2==0){
        	int i=s.length()/2-1;
        	for (int j = 0; j <= i; j++) {
				if(s.charAt(j)!=s.charAt(s.length()-1-j)){
					return false;
				}
			}
        	return true;
        }else{
        	int i=(s.length()-1)/2;
        	for (int j = 0; j < i; j++) {
        		if(s.charAt(j)!=s.charAt(s.length()-1-j)){
					return false;
				}
			}
        	return true;
        }
		
    }

}

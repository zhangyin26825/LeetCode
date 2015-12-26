package com.zhangyin.leetcode;
/**
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 * @author yin
 *
 */
public class ReverseInteger {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int reverse = ReverseInteger.reverse(1534236469);
		System.out.println(reverse);
	}
	
	public static int reverse(int x) {
        String s = String.valueOf(x);
        boolean ispositive=true;
        StringBuffer sb=new StringBuffer();
        for (int i =s.length()-1; i >=0; i--) {
        	if(s.charAt(i)!='-'){
        		sb.append(s.charAt(i));
        	}else{
        		ispositive=false;
        	}
		}
        try {
			if(ispositive){
				return Integer.parseInt(sb.toString());
			}else{
				return -Integer.parseInt(sb.toString());
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return 0;
		}
    }

}

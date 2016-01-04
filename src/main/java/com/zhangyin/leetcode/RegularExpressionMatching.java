package com.zhangyin.leetcode;

import java.util.Arrays;

/**
 * mplement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
Subscribe to see which companies asked this question
 * @author yin
 *"aaa"
"ab*a*c*a"  
"bbbba"
".*a*a"
 */
public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("c", "a*c"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("a", "ab*"));
		System.out.println(isMatch("bbbba", ".*a*a"));
		System.out.println(isMatch("a", ".*"));
		System.out.println(isMatch("", "c*"));
		System.out.println(isMatch("aabccbcbacabaab", ".*c*a*b.*a*ba*bb*"));
	}
	
	public static boolean isMatch(String s, String p) {
		if(s.equals(p)){
			return true;
		}
		if(s.length()==0){
			for (int i = 0; i < p.length(); i++){
					if(p.charAt(i)=='*'){
						continue;
					}
					if(p.charAt(i)!='*'&&i+1<p.length()&&p.charAt(i+1)=='*'){
						continue;
					}else{
						return false;
					}	
			}
			return true;
		}
		
		boolean [] [] r=new boolean[p.length()+1][s.length()+1];
		r[0][0]=true;
		for (int i = 0; i <= p.length(); i++) {	
			//i 为 p上的char的索引 -1
			for (int j = 0; j <= s.length(); j++) {
				//j 为 s上的char的索引 -1
				if(i==0&&j==0){
					r[0][0]=true;
					continue;
				}	
				if(i==0){
					continue;
				}
				if(j==0&&p.charAt(i-1)!='*'){
					continue;
				}
				char pi = p.charAt(i-1);
				if(pi!='*'){//这里判断 * 是因为  * 是唯一会产生多长度判断的元素  .只需要判断一个
					// pi 当前值不为  　*
					char sj = s.charAt(j-1);
					r[i][j]=r[i-1][j-1]&&(pi==sj||pi=='.');
					
				}else{
					// pi 当前值为  　*
					if(r[i-2][j]){
						r[i][j]=r[i-2][j];
						char c = p.charAt(i-2);
						int k=j+1;
						while(k-1<s.length()&&(s.charAt(k-1)==c||c=='.')){
							r[i][k]=true;
							k++;
						}
						
					}
				}
				
				
			}
		}
		return r[p.length()][s.length()]; 
    }
	
	
	
}

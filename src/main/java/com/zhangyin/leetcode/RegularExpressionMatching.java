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
//		System.out.println(isMatch("c", "a*c"));
//		System.out.println(isMatch("ab", ".*"));
//		System.out.println(isMatch("aa", ".*"));
//		System.out.println(isMatch("aaa","aa"));
//		System.out.println(isMatch("a", "ab*"));
		System.out.println(isMatch("bbbba", ".*a*a"));
	}
	
	public static boolean isMatch(String s, String p) {
		if(s.equals(p)){
			return true;
		}
		boolean [] [] r=new boolean[p.length()+1][s.length()+1];
		r[0][0]=true;
		for (int i = 0; i <= p.length(); i++) {	
			for (int j = 0; j <= s.length(); j++) {
				if(i==0||j==0){
					continue;
				}
				char pi = p.charAt(i-1);
				char sj = s.charAt(j-1);
				if(j==s.length()&&r[i-1][j]){
					if(pi!='*'&&pi!=sj&&i<p.length()&&p.charAt(i)=='*'){
						r[i][j]=true;
					}
					if(pi=='*'){
						 r[i][j]=true;	
					}
				}
				if(r[i-1][j-1]){
					if(pi!='*'&&(pi==sj||pi=='.')){
						r[i][j]=true;
						continue;
					}
					if(pi!='*'&&pi!=sj&&i<p.length()&&p.charAt(i)=='*'){
						r[i][j-1]=true;
						continue;
					}
					if(pi=='*'){
							char c=p.charAt(i-2);
							for (int k = j-1; k < s.length(); k++) {
								if(c==s.charAt(k)||c=='.'){
									r[i][k+1]=true;
								}else{
									break;
								}
							 }
							 r[i][j-1]=true;	 
					}
				}
				
				
			}
		}
		return r[p.length()][s.length()]; 
    }
	
	
	
}

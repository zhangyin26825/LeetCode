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
 *
 */
public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
	}
	
	public static boolean isMatch(String s, String p) {
		if(s.equals(p)){
			return true;
		}
		boolean [] [] r=new boolean[p.length()+1][s.length()+1];
		r[0][0]=true;
		for (int i = 0; i < p.length(); i++) {	
			for (int j = 0; j < s.length(); j++) {
				if(i==0||j==0){
					continue;
				}
				char pi = p.charAt(i-1);
				char sj = s.charAt(j-1);
				if(r[i-1][j-1]){
					if(pi!='*'&&pi==sj||pi=='.'){
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
							if(c==s.charAt(k)){
								r[i][k+1]=true;
							}else{
								break;
							}
						}
					}
				}
				
			}
		}
		return r[p.length()][s.length()]; 
    }
	
	
	
}

package com.zhangyin.dp;
/**
 * 最长公共子序列
 * @author yin
 *
 */
public class LongestCommonSubSequenceProblem {
	
	public static void main(String[] args) {
		System.out.println(LongestCommonSubSequenceProblem("fsfgasdfasdf", "asdfgasdfasdf"));
	}
	public  static int LongestCommonSubSequenceProblem(String a,String b){
		int al=a.length();
		int bl=b.length();
		int [][] result=new int[al][bl];
		for (int i = 0; i < al; i++) {
			for (int j = 0; j < bl; j++) {
				if(i==0||j==0){
					result[i][j]=0;
					continue;
				}
				if(a.charAt(i)==b.charAt(j)){
					result[i][j]=result[i-1][j-1]+1;
				}else{
					result[i][j]=Math.max(result[i-1][j], result[i][j-1]);
				}	
			}
		}	
		return result[al-1][bl-1];
	}

}

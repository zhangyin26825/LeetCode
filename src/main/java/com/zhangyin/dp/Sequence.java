package com.zhangyin.dp;
/***
 *  最长递增子序列
 * @author yin
 *
 */
public class Sequence {
	
	
	public static void main(String[] args) {
		
		int [] l=new int[]{1,5,8,2,3,4};
		System.out.println(Sequence.LongestIncreasingSubsequence(l));
	}
	
	public  static int LongestIncreasingSubsequence(int [] l){
		int n=l.length;
		int [] f=new int[n];
		for (int i = 0; i < n; i++) {
			f[i]=1;
			for (int j = 0; j < i; j++) {
				if(l[j]<l[i]){
					f[i]=f[j]+1;
				}
				
			}
		}
		return f[n-1];
	}

}

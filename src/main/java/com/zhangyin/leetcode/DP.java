package com.zhangyin.leetcode;

public class DP {
	
	
	//						   重量                               价值               总重量
	public static int sovle(int [] weight,int [] value, int maxMas){
		int length=weight.length;
		int [][] v=new int[length][maxMas+1];
		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j <= maxMas; j++) {
				if(i==0){
					if(j>=weight[i]){
						v[i][j]=value[i];
					}else{
						v[i][j]=0;
					}
					continue;
				}
				if(weight[i]>j){
					v[i][j]=v[i-1][j];
					continue;
				}
				if(i>0){
					v[i][j]=Math.max(v[i-1][j-weight[i]]+value[i], v[i-1][j]);
					continue;
				}
				System.out.println("正常应该不会到这里");
			}	
		}
		int a=v[length-1][maxMas];
		return a;
		
	}
	
	
	public static void main(String[] args) {
		int [] goods=new int[]{509,838,924,650,604,793,564,651,697,649,747,787,701,605,644};
		int maxmass=5000;
//			int val[] = {10, 40, 30, 50};
//	        int goods[] = {5, 4, 6, 3};
//	        int maxmass = 16;
		
		System.out.println(DP.sovle(goods,goods,maxmass));
	}

}

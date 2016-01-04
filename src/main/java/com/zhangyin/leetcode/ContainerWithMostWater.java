package com.zhangyin.leetcode;
/**
 Given n non-negative integers a1, a2, ..., an,
 where each represents a point at coordinate (i, ai). 
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, 
 such that the container contains the most water.

Note: You may not slant the container.
 * @author zhangyin
 *
 */
public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		int maxVolume=0;
		int left=0;
		int right=height.length-1;
		while(left<right){
			
			int volume=Math.min(height[left], height[right])*(right-left);
			if(volume>maxVolume){
				maxVolume=volume;
			}
			if(height[left]<height[right]){
				left++;
			}else{
				right--;
			}
			
		}
        return maxVolume;
    }

}

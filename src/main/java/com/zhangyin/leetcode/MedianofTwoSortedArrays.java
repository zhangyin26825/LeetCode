package com.zhangyin.leetcode;
/** There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 *  Find the median of the two sorted arrays. 
 *  The overall run time complexity should be O(log (m+n)).
 * @author yin
 *
 */
public class MedianofTwoSortedArrays {
	public static void main(String[] args) {
		int [] nums1=new int[]{1,3,5,7,9,11};
		int [] nums2=new int[]{2,4,6,8};
		MedianofTwoSortedArrays s=new MedianofTwoSortedArrays();
		double findMedianSortedArrays = s.findMedianSortedArrays(nums1, nums2);
		System.out.println(findMedianSortedArrays);
	}
	
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1=nums1.length;
		int l2=nums2.length;
		if(l1==0&&l2==0){
			return 0.0;
		}
		int count=l1+l2;
		if(count%2==0){
			return (findKth(nums1, 0, l1, nums2, 0, l2, count/2)+findKth(nums1, 0, l1, nums2, 0, l2, count/2+1))/2;
		}else{
			return findKth(nums1, 0, l1, nums2, 0, l2, (count+1)/2);
		}
    }
	
	
	/**
	 * nums1 的长度默认比nums2小
	 * @param nums1
	 * @param nums1start
	 * @param nums1end
	 * @param nums2
	 * @param nums2start
	 * @param nums2end
	 * @param k
	 * @return
	 */
	public double  findKth(int[] nums1,int nums1start,int nums1end,int[] nums2,int nums2start,int nums2end,int k){
		 int l1=nums1end-nums1start;
		 int l2=nums2end-nums2start;
		 if(l1>l2){
			return findKth(nums2, nums2start, nums2end, nums1, nums1start, nums1end, k);
		 }
		 if(l1==0){
			 return nums2[nums2start+k-1];
		 }
		 if(l2==0){
			 return nums1[nums1start+k-1];
		 }
		 if(k==1){
			 return Math.min(nums2[nums2start], nums1[nums1start]);
		 }
		 int minPosition=Math.min(k/2, l1);
		 int maxPosition=k-minPosition;
		 int a=nums1[nums1start+minPosition-1];
		 int b=nums2[nums2start+maxPosition-1];
		 if(a<b){
			 return findKth(nums1, nums1start+minPosition, nums1end, nums2, nums2start, nums2end, k-minPosition);
		 }else if(a>b){
			 return findKth(nums1, nums1start, nums1end, nums2, nums2start+maxPosition, nums2end, k-maxPosition);
		 }else{
			 return a;
		 }
	}
}

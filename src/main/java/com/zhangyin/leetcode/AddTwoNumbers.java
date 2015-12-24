package com.zhangyin.leetcode;
/** 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
	Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * @author yin
 *
 */
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(0);
		ListNode l2=new ListNode(1);
		ListNode addTwoNumbers = addTwoNumbers(l1, l2);
		System.out.println(addTwoNumbers.val);
		System.out.println(addTwoNumbers.next);
	}
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode start=null;
		 int carry=0;
		 ListNode temp=null;
		 while((l1!=null||l2!=null)||carry>0){
			 int templ1Value=0,templ2Value=0;
			 if(l1!=null){
				 templ1Value=l1.val; 
				 l1=l1.next;
			 }
			 if(l2!=null){
				 templ2Value=l2.val;
				 l2=l2.next;
			 }
			 int value=templ1Value+templ2Value+carry;
			 carry=0;
			 if(value>=10){
				 carry=1;
				 value-=10;
			 }
			 
			 if(start==null){
				 start=new ListNode(value);
				 temp=start;
			 }else{
				 temp.next=new ListNode(value); 
				 temp=temp.next; 
			 }
			
		 }
		 return start; 
	 }

}

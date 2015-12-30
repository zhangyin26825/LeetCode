package com.zhangyin.leetcode;
/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Subscribe to see which companies asked this question
 * @author yin
 *
 */
public class ZigZagConversion {
	
	public static void main(String[] args) {
		ZigZagConversion zz=new ZigZagConversion();
		String convert = zz.convert("PAYPALISHIRING", 3);
		System.out.println(convert);
	}

	
	public String convert(String s, int numRows) {
		int length=s.length();
		if(numRows==1){
			return s;
		}
		StringBuffer [] sbs=new StringBuffer[numRows];
		for (int i = 0; i < sbs.length; i++) {
			sbs[i]=new StringBuffer("");
		}
		boolean add=true;
		int row=0;
		for (int i = 0; i < s.length(); i++) {
			sbs[row].append(s.charAt(i));
			if(row==numRows-1){
				add=false;
			}
			if(row==0){
				add=true;
			}
			if(add){
				row++;
			}else{
				row--;
			}
		}
		StringBuilder result=new StringBuilder();
		for (int i = 0; i < sbs.length; i++) {
			result.append(sbs[i].toString());
		}
		return result.toString();   
    }
}

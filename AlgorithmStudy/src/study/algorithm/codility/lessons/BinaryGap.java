package study.algorithm.codility.lessons;

import java.util.ArrayList;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(getBinaryGap(1041));
	}
	
	/**
	 * 양의정수(N)을 받아 2진 표현으로 바꾸게 될 때에
	 * 1과 1사이에 가장 큰 0의 개수를 return
	 * (단, 1이 하나만 있거나 모두가 1인 경우는 return 0)
	 * @param N
	 * @return
	 */
	public static int getBinaryGap(int N) {
		ArrayList<Integer> idxArr = new ArrayList<Integer>();
		int maxGap = 0;
		
		// 1. binary로 표현 될 수 있는 index 저장
		int end = 10000;
		int binary = 0;
		for(int i=0; i<end; i++) {
			binary = (int) Math.pow(2, i);
			if(N < binary) {
				N = N - (int) Math.pow(2, i-1);
				idxArr.add(i-1);
				i = -1;
			} else if(N == binary) {
				idxArr.add(i);
				i = end;
			}
		}
		
		// 2. 가장큰 gap을 구함
		if(idxArr.size() == 0)
			maxGap = 0;
		else if(idxArr.size() == idxArr.get(0)+1)
			maxGap = 0;
		else {
			for(int i=0; i < idxArr.size()-1; i++) {
				if(maxGap < (idxArr.get(i) - idxArr.get(i+1))-1)
					maxGap = (idxArr.get(i) - idxArr.get(i+1))-1; 
			}
		}
		
		return maxGap;
	}

}

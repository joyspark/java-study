package study.algorithm.codility.lessons;

import java.util.ArrayList;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(getBinaryGap(1041));
	}
	
	/**
	 * ��������(N)�� �޾� 2�� ǥ������ �ٲٰ� �� ����
	 * 1�� 1���̿� ���� ū 0�� ������ return
	 * (��, 1�� �ϳ��� �ְų� ��ΰ� 1�� ���� return 0)
	 * @param N
	 * @return
	 */
	public static int getBinaryGap(int N) {
		ArrayList<Integer> idxArr = new ArrayList<Integer>();
		int maxGap = 0;
		
		// 1. binary�� ǥ�� �� �� �ִ� index ����
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
		
		// 2. ����ū gap�� ����
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

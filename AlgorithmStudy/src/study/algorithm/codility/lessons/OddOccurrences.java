package study.algorithm.codility.lessons;

import java.util.HashMap;

/**
 * �ڵ���Ƽ lessons 2-2
 * 
 * Ȧ���� ������ �迭����
 * ���� ���� 2���� ¦�� �̷�� ����.
 * �׷��� ¦�� ���� ���� �ϳ��ְ�
 * �� ���� ã�Ƽ� return 
 * 
 * @since 2020-01-21
 * @author joy.seo
 */
public class OddOccurrences {
	public static void main(String[] args) {
		int[] A = {9,3,9,3,9,7,9};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		int unpaired = 0;
		
		HashMap<Integer, Integer> numCntMap = new HashMap<Integer, Integer>();
		int cnt = 0;
		
		// ���ں��� ���� ����
		for(int key : A) {
			if(numCntMap.containsKey(key)) {
				cnt = numCntMap.get(key) + 1;
			} else {
				cnt = 1;
			}
			numCntMap.put(key, cnt);
		}
		
		// Ȧ�� ���� ���� �ָ� retrun 
		for(int key : numCntMap.keySet()) {
			if((numCntMap.get(key) % 2) != 0)
				unpaired = key;
		}
		
		return unpaired;
	}
}

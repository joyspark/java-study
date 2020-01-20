package study.algorithm.codility.lessons;

import java.util.HashMap;

/**
 * 코딜리티 lessons 2-2
 * 
 * 홀수가 나열된 배열에서
 * 같은 수가 2개씩 짝을 이루고 있음.
 * 그러나 짝이 없는 수가 하나있고
 * 그 수를 찾아서 return 
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
		
		// 숫자별로 개수 적재
		for(int key : A) {
			if(numCntMap.containsKey(key)) {
				cnt = numCntMap.get(key) + 1;
			} else {
				cnt = 1;
			}
			numCntMap.put(key, cnt);
		}
		
		// 홀수 개수 가진 애를 retrun 
		for(int key : numCntMap.keySet()) {
			if((numCntMap.get(key) % 2) != 0)
				unpaired = key;
		}
		
		return unpaired;
	}
}

package study.algorithm.codility.lessons;

import java.util.ArrayList;
import java.util.Collections;

/**
 * lesson 3
 * 
 * @since 2020-02-12
 * @author joy.seo
 *
 */
public class TimeComplexity {
	
	public static void main(String[] args) {
		// 1) Perm Missing Elem
		int[] A = {};
		System.out.println(solution1(A));
		// 2) Tape Equilibrium
		
		// 3) Frog Jmp
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	public static int solution1(int[] A) {
		int missingElem = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// �� ���� ��� 
		if(A.length == 0)
			return 1;
		
		// list �� ���� �ִ´�.
		for(int a : A) {
			list.add(a);
		}
		
		list.sort(null);
		// ������ �� ��
		if(list.get(list.size()-1) == A.length) {
			return A.length+1;
		// ó�� �� ��
		} else if(list.get(0) != 1){
			return 1;
		} else {
			for(int i=list.size()-1; i>0; i--) {
				// ���� ���̶� ���ؼ� ���̰� 2�� �� 
				if((list.get(i) - list.get(i-1)) == 2) {
					missingElem = list.get(i)-1;
				}
			}
			return missingElem;
		}
	}
}

package study.algorithm.codility.practice;

import java.util.ArrayList;

/**
 * S : �ؽ�Ʈ (non-empty, ~500��)
 * K : ���� ���� �� (1~500)
 * 
 * �ϳ��� SMS�� K�� ���� ���� ���� �Ǿ��־
 * S�� K�� ���� ���ڼ��� ������ �� ��� SMS �� �����°�?
 * 
 * �ּ��� SMS�� �������ϸ�,
 * ���� �� ���� ��� return -1
 * 
 * (�ּҷ� ������ ���ؼ��� ����� ���� ����ؾ��ϴ� ����� �ʿ��� �� ������,
 * �׽�Ʈ ���̽��� ���ٺ��� ������ �� ������ Ǯ�� ����)
 * 
 * @since 2020-02-11
 * @author joy.seo
 *
 */
public class TextSplitIntoK {
	public static void main(String[] args) {
		String S = "SMS messages are really short";
		int K = 12;

		System.out.println(solution(S, K));
		//System.out.println(solution2(S, K));
	}

	/**
	 * ���� Ǭ��
	 * @param S
	 * @param K
	 * @return
	 */
	public static int solution(String S, int K) {
		String[] strArr = S.split(" ");

		int len = 0; // ���� ����
		String str = ""; // ���� �ؽ�Ʈ 

		// ��� ����Ʈ 
		ArrayList<String> resultList = new ArrayList<String>();
		for (String s : strArr) {
			// �ܾ� ��ü�� K ���� �̻��� �� �и� �Ұ�
			if (s.length() > K) {
				return -1;
			// ���� �ܾ� �ٿ��� ��, 
			// 1) K���� ���̰� ��� ���̱� ���� �ؽ�Ʈ�� ��� ����Ʈ�� �ִ´�.
			} else if (len + s.length() > K) {
				resultList.add(str);
				// str�� len ����
				str = s;
				len = s.length();
			// 1) K���� ���̰� ª���� ���� ���̿� �ؽ�Ʈ�� ���� ���δ�.
			} else {
				if(len == 0) {
					str += s;
					len += s.length();
				} else { // ó���� �ƴ� ��� ���� �߰�
					str += " "+s;
					len += s.length()+1;
				}
			}
		}
		resultList.add(str); // ������ �ؽ�Ʈ���� ��� ����Ʈ�� �ְ� 
		return resultList.size(); // ����Ʈ�� ���̸� �����Ѵ�.
	}

	/**
	 * ��ó : https://ideone.com/HVriNX
	 * @param S
	 * @param K
	 * @return
	 */
	static int solution2(String S, int K) {
		int result = 1;
		String[] wordArr = S.split(" ");

		int limit = K;
		for (int i = 0; i < wordArr.length; i++) {
			// ó���� ������ ���� ����
			if (limit != K) {
				limit--;
			}
			if (limit - wordArr[i].length() < 0) {
				limit = K - wordArr[i].length();
				result++;
			} else {
				limit = limit - wordArr[i].length();
			}
		}

		return result;
	}


}

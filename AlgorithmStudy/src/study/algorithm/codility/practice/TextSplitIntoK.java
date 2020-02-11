package study.algorithm.codility.practice;

import java.util.ArrayList;

/**
 * S : 텍스트 (non-empty, ~500자)
 * K : 제한 문자 수 (1~500)
 * 
 * 하나의 SMS는 K개 문자 수로 제한 되어있어서
 * S를 K개 이하 문자수로 나누면 총 몇개의 SMS 가 나오는가?
 * 
 * 최소의 SMS로 나눠야하며,
 * 나눌 수 없는 경우 return -1
 * 
 * (최소로 나누기 위해서는 경우의 수를 계산해야하는 방법이 필요할 것 같은데,
 * 테스트 케이스가 없다보니 아직은 그 문제를 풀지 못함)
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
	 * 내가 푼것
	 * @param S
	 * @param K
	 * @return
	 */
	public static int solution(String S, int K) {
		String[] strArr = S.split(" ");

		int len = 0; // 현재 길이
		String str = ""; // 현재 텍스트 

		// 결과 리스트 
		ArrayList<String> resultList = new ArrayList<String>();
		for (String s : strArr) {
			// 단어 자체가 K 길이 이상일 때 분리 불가
			if (s.length() > K) {
				return -1;
			// 다음 단어 붙였을 때, 
			// 1) K보다 길이가 길면 붙이기 현재 텍스트를 결과 리스트에 넣는다.
			} else if (len + s.length() > K) {
				resultList.add(str);
				// str과 len 리셋
				str = s;
				len = s.length();
			// 1) K보다 길이가 짧으면 현재 길이와 텍스트에 값을 붙인다.
			} else {
				if(len == 0) {
					str += s;
					len += s.length();
				} else { // 처음이 아닌 경우 공백 추가
					str += " "+s;
					len += s.length()+1;
				}
			}
		}
		resultList.add(str); // 마지막 텍스트까지 결과 리스트에 넣고 
		return resultList.size(); // 리스트의 길이를 리턴한다.
	}

	/**
	 * 출처 : https://ideone.com/HVriNX
	 * @param S
	 * @param K
	 * @return
	 */
	static int solution2(String S, int K) {
		int result = 1;
		String[] wordArr = S.split(" ");

		int limit = K;
		for (int i = 0; i < wordArr.length; i++) {
			// 처음을 제외한 공백 빼기
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

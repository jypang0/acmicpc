package math;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @사용알고리즘 
 * @사용자료구조 Map, HashMap, Map.Entity, PriorityQueue
 *  
 * @배운점 자료구조 관련 연습했다고 생각하면..ㅎㅎ
 * 
 * @try1
 *
 * @Date 31 Dec 2024
 */
public class S3_2108_통계학_meanModeMedianRange_v1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		//1. mean를 위한 전체 sum
		double sum = 0.0;

		//2. median을 위한 array
		int[] medianArr = new int[N];
		
		//3. mode를 위한 Map
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		//4. range를 위한 값들
		int min = 4001;
		int max = -4001;

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			sum += input;
			medianArr[i] = input;
			frequencyMap.put(input, frequencyMap.containsKey(input) ? frequencyMap.get(input) + 1 : 1);
			min = Math.min(min, input);
			max = Math.max(max, input);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> modePQ = new PriorityQueue<>((a, b) -> {
			// 값 내림차순
			int valueComparison = b.getValue().compareTo(a.getValue());
			if (valueComparison != 0) {
				return valueComparison;
			}
			// 값이 동일하면 키 오름차순
			return a.getKey().compareTo(b.getKey());
		});
		modePQ.addAll(frequencyMap.entrySet());
		
		System.out.println(Math.round(sum / N));

		Arrays.sort(medianArr);
		System.out.println(medianArr[N/2]);

		int tempKey = modePQ.peek().getKey();
		int tempVal = modePQ.poll().getValue();
		if (modePQ.isEmpty())
			System.out.println(tempKey);
		else
			System.out.println(modePQ.peek().getValue() == tempVal ? modePQ.peek().getKey() : tempKey);
		System.out.println(max - min);
	}
}
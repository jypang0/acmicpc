package impl;
import java.util.Scanner;

public class S4_1158_요세푸스문제_Node {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		if (N == 1) {
			System.out.println("<1>");
			return;
		}

		StringBuilder sb = new StringBuilder("<");

		Node[] nodes = new Node[N + 1];
		nodes[0] = new Node(0, 1);
		nodes[1] = new Node(N, 2);
		for (int i = 2; i < nodes.length - 1; i++) {
			nodes[i] = new Node(i - 1, i + 1);
		}
		nodes[N] = new Node(N - 1, 1);

		int curNode = 0;
		for (int i = 0; i <= K; i++) {

			if (i == K) {
				sb.append(curNode).append(", ");

				nodes[nodes[curNode].front].back = nodes[curNode].back;
				nodes[nodes[curNode].back].front = nodes[curNode].front;

				if (nodes[nodes[curNode].front].front != nodes[curNode].front) {
					i = -1;
					continue;
				}
			}
			curNode = nodes[curNode].back;
		}

		sb.append(nodes[curNode].front).append(">");

		System.out.println(sb);
	}
}

class Node {
	int front;
	int back;

	public Node(int front, int back) {
		this.front = front;
		this.back = back;
	}

	@Override
	public String toString() {
		return "(" + front + "," + back + ")\n";
	}

}
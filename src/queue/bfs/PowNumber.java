package queue.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PowNumber {
    private static class Node {
        int number;
        int left;

        public Node(int number, int left) {
            this.number = number;
            this.left = left;
        }
    }
    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        int square = (int) Math.sqrt(n);
        for (int k = square; k >= 1; k--) {
            queue.offer(new Node(k, n - k * k));
        }

        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left == 0) {
                    return depth;
                }

                square = (int) Math.sqrt(node.left);
                square = Math.min(square, node.number);
                for (int k = square; k >= 1; k--) {
                    queue.offer(new Node(k, node.left - k * k));
                }
            }
            depth += 1;
        }

        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new PowNumber().numSquares(13));
    }


}

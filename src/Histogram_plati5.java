import java.util.Scanner;
import java.util.Stack;

public class Histogram_plati5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] height = new long[N];
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextLong();
        }

        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= N; i++) {
            while (!stack.isEmpty() && (i == N || height[stack.peek()] >= height[i])) {
                long h = height[stack.pop()];
                long w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        System.out.println(maxArea);
    }
}

import java.util.Scanner;
import java.util.Stack;

public class OasisReunion_plati5 {
    static class Person {
        int height;
        int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Person> pLine = new Stack<>();
        long answer = 0;

        for(int i=0; i<N; i++) {
            int hgt = sc.nextInt();
            Person p1 = new Person(hgt, 1);

            while(!pLine.isEmpty() && pLine.peek().height <= hgt) {
                if(pLine.peek().height == hgt) {
                    p1.count += pLine.peek().count;
                }

                answer += pLine.pop().count;
            }

            if(!pLine.isEmpty()) {
                answer++;
            }

            pLine.push(p1);
        }

        System.out.println(answer);
    }
}

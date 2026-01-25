package Stack;

import java.util.*;

class stockspan {

    public ArrayList<Integer> calculateSpan(int[] arr) {

        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> span = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - s.peek());
            }

            s.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        stockspan obj = new stockspan();

        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        ArrayList<Integer> result = obj.calculateSpan(arr);

        System.out.println("Stock Span Values:");
        System.out.println(result);
    }
}

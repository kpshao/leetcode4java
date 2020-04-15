package stack;

import java.util.Stack;

public class StringDecoder {
    public String decodeString(String s) {
        Stack<Integer> stackMulti = new Stack<>();
        Stack<String> stackRes = new Stack<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stackMulti.push(multi);
                stackRes.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.pop();
                for (int i = 0; i < curMulti; i++) tmp.append(res);
                res = new StringBuilder(stackRes.pop() + tmp.toString());
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                res.append(c);
            }

        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringDecoder().decodeString("100[leetcode]"));
    }
}

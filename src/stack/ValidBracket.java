package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {
    public boolean isValid(String s) {
        Stack<Character> queue = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (queue.isEmpty()) {
                    return false;
                }
                char c = queue.pop();
                if (map.get(s.charAt(i)) != c) {
                    return false;
                }
            } else {
                queue.push(s.charAt(i));
            }
        }

        return queue.isEmpty();
    }
}

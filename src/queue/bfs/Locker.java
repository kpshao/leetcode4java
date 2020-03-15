package queue.bfs;


import java.util.*;
import java.util.stream.Collectors;

/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
public class Locker {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int cnt = 0;
        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String code = queue.poll();

                if (deads.contains(code)) {
                    continue;
                }

                if (target.equals(code)) {
                    return cnt;
                }

                for (int j = 0; j < 4; j++) {
                    char[] newCode1 = code.toCharArray();
                    newCode1[j] = (char) ((newCode1[j] - '0' + 1) % 10 + '0');
                    if (!seen.contains(new String(newCode1))) {
                        seen.add(new String(newCode1));
                        queue.offer(new String(newCode1));
                    }


                    char[] newCode2 = code.toCharArray();
                    newCode2[j] = (char) ((newCode2[j] - '0' + 9) % 10 + '0');
                    if (!seen.contains(new String(newCode2))) {
                        seen.add(new String(newCode2));
                        queue.offer(new String(newCode2));
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
//        String[] deadends = new String[] {"8888"};
//        String target = "0009";

        Locker locker = new Locker();
        System.out.println(locker.openLock(deadends, target));
    }
}

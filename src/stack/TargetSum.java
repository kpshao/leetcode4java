package stack;

public class TargetSum {
    private int count = 0;
    private int sum = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, nums, S);
        return count;
    }

    private void dfs(int i, int[] nums, int S) {
        if (i >= nums.length) {
            if (sum == S) {
                count ++;
            }
            return;
        }

        sum += nums[i];
        dfs(i + 1, nums, S);
        sum -= nums[i];

        sum -= nums[i];
        dfs(i + 1, nums, S);
        sum += nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    }
}

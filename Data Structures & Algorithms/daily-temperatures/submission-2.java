class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] solArr = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int prevTemp = stack.pop();
                solArr[prevTemp] = i - prevTemp;
            }

            stack.push(i);
        }

        return solArr;
    }
}

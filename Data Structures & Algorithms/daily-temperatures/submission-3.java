class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] retArr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int nextEntry = stack.pop();
                retArr[nextEntry] = i - nextEntry;
            }

            stack.push(i);
        }

        return retArr;
    }
}

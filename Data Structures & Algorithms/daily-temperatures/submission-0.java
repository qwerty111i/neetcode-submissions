class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] outputList = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                int topOfStack = stack.peek();
                if (temperatures[topOfStack] < temperatures[i]) {
                    stack.pop();
                    outputList[topOfStack] = i - topOfStack;
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            outputList[stack.pop()] = 0;
        }

        return outputList;
    }
}

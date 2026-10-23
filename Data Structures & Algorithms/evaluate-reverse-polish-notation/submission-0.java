class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> operands = Set.of("+", "-", "*", "/");

        for (int i = 0; i < tokens.length; i++) {
            if (operands.contains(tokens[i])) {
                int rightNum = Integer.parseInt(stack.pop());
                int leftNum = Integer.parseInt(stack.pop());

                if (tokens[i].equals("+")) stack.push(String.valueOf(leftNum + rightNum));
                if (tokens[i].equals("-")) stack.push(String.valueOf(leftNum - rightNum));
                if (tokens[i].equals("*")) stack.push(String.valueOf(leftNum * rightNum));
                if (tokens[i].equals("/")) stack.push(String.valueOf(leftNum / rightNum));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}

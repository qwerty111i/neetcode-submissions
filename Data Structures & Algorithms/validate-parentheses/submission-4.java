class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            } else {
                if (stack.isEmpty()) return false;
                char newChar = stack.pop();
                if (map.get(currChar) != newChar) return false;
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}

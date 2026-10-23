class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
                leftPointer++;
            }
            char leftChar = Character.toLowerCase(s.charAt(leftPointer));

            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))) {
                rightPointer--;
            }
            char rightChar = Character.toLowerCase(s.charAt(rightPointer));

            if (leftPointer < rightPointer) {
                if (leftChar == rightChar) {
                    leftPointer++;
                    rightPointer--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

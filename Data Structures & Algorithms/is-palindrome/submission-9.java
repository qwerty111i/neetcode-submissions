class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) left++;
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) right--;
            
            char c = s.toLowerCase().charAt(left);
            char d = s.toLowerCase().charAt(right);
            if (left < right) {
                if (c != d) return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
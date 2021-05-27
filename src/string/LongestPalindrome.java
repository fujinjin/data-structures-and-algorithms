package string;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.getLongestPalindrome("abc1234321ab",12));
    }

    public int getLongestPalindrome(String s, int n) {
        if (n < 2) {
            return n;
        }
        int maxLen = 0;
        for (int i = 0; i < n; ) {

            if(n-i <= maxLen/2){
                break;
            }
            int left = i;
            int right = i;
            while (right < n - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right + 1;
            while (right < n - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                right++;
                left--;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
            }
        }
        return maxLen;
    }
}

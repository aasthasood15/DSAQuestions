package org.two.pointer;

public class ValidPalindrome {

    //simple without spaces
    boolean validPalindrome(String s) {
        // Get the left and right pointers
        int left = 0;
        int right = s.length() - 1;

        // Start a loop and compare characters
        while (left < right)
            // If same, move both pointers
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            // If not, simply return false
            else
                return false;

        // If we come out of the loop, then all
        // characters have matched, return true
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) { i++; }
            else if (!Character.isLetterOrDigit(s.charAt(j))) { j--; }
            else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else { i++; j--; }
        }
        return true;
    }

}
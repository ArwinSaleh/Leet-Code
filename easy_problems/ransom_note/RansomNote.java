import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution testSolution = new Solution();
        boolean result = testSolution.canConstruct("abc", "ab");
        System.out.println(result);
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Edge case: empty ransom note can always be constructed
        if (ransomNote.isEmpty()) {
            return true;
        }

        // Initialize character counts
        int[] charCounts = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            charCounts[c - 'a']++;
        }

        // Decrement character counts for each character in the magazine
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int count = charCounts[c - 'a'];
            if (count > 0) {
                charCounts[c - 'a'] = count - 1;
            }
        }

        // If all counts have been decremented to zero, the ransom note can be constructed
        for (int count : charCounts) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}


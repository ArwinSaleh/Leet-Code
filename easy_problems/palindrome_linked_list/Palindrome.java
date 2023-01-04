class Main {
    public static void main(String[] args) {

        Solution testSolution = new Solution();
        ListNode testNode = new ListNode(1, new ListNode(2));
        boolean result = testSolution.isPalindrome(testNode);
        System.out.println(result);
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode singleStep = head, doubleStep = head;
        ListNode reversedNodes = null, tail = null;
        
        while (doubleStep != null && doubleStep.next != null) {
            tail = reversedNodes;
            reversedNodes = singleStep;
            singleStep = singleStep.next;
            doubleStep = doubleStep.next.next;
            reversedNodes.next = tail;
        }

        if (doubleStep != null) {
            singleStep = singleStep.next;
        }

        while (reversedNodes != null) {
            if (reversedNodes.val != singleStep.val) {
                return false;
            }
            reversedNodes = reversedNodes.next;
            singleStep = singleStep.next;
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
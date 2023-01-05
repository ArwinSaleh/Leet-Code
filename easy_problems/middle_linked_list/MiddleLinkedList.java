class Main {
    public static void main(String[] args) {

        Solution testSolution = new Solution();
        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        testNode.next.next = new ListNode(3);
        testNode.next.next.next = new ListNode(4);
        ListNode result = testSolution.middleNode(testNode);
        System.out.println(result.val);
    }
}

class Solution {
    /* NOTE: Comments bade by ChatGPT.
     * My solution to the problem of finding the middle node of a linked list is to
     * use a divide and conquer approach. This involves dividing the linked list
     * into two halves at each recursive call, and then returning the middle node
     * once the problem size has been reduced to a single node.
     * 
     * The implementation uses two pointers: a slow pointer and a fast pointer. The
     * slow pointer advances one node at a time, while the fast pointer advances two
     * nodes at a time. This way, when the fast pointer reaches the end of the
     * linked list, the slow pointer will be at the middle of the list.
     * 
     * The solution has a time complexity of O(log n) because it reduces the problem
     * size by half on each iteration of the loop. It has a space complexity of
     * O(log n) because the call stack will grow by one frame for each recursive
     * call.
     * 
     * Overall, this is a simple and efficient solution to the problem of finding
     * the middle node of a linked list.
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
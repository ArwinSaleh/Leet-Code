class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        ListNode testNode = new ListNode(4);
        testNode.next = new ListNode(5);
        testNode.next.next = new ListNode(1);
        testNode.next.next.next = new ListNode(9);
        testSolution.deleteNode(testNode.next);
        while (testNode != null) {
            System.out.println(testNode.val);
            testNode = testNode.next;
        }
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val  = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
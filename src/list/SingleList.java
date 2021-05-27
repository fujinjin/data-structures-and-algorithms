package list;

public class SingleList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode( 0);
        dummy.next = head;
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            cur.next = cur.next.next;
        }
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        ListNode listNode = new ListNode(6);
        listNode.addNode(new ListNode(4));
        listNode.addNode(new ListNode(9));
        listNode.addNode(new ListNode(2));
        listNode.addNode(new ListNode(4));
        ListNode result = singleList.removeNthFromEnd(listNode,3);
        System.out.println(result);
    }
}

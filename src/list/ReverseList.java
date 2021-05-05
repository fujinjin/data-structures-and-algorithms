package list;

/**
 * 反转链表
 */
public class ReverseList {
    public static ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr !=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode inListNode = new ListNode(3);
        inListNode.addNode(new ListNode(5));
        inListNode.addNode(new ListNode(8));
        inListNode.addNode(new ListNode(6));
        inListNode.addNode(new ListNode(2));
        inListNode.addNode(new ListNode(1));
        ListNode outListNode = ReverseList.ReverseList(inListNode);

      while (outListNode.next !=null){
          System.out.println(outListNode.val);
          outListNode = outListNode.next;
      }
        System.out.println(outListNode.val);

    }
}

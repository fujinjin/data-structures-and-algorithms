package list;

public class CycleList {
    public static boolean hasCircle(ListNode L) {
        if (L == null) return false;//单链表为空时，单链表没有环
        if (L.next == null) return false;//单链表中只有头结点，而且头结点的next为空，单链表没有环
        ListNode p = L.next;//p表示从头结点开始每次往后走一步的指针
        ListNode q = L.next.next;//q表示从头结点开始每次往后走两步的指针
        while (q != null) //q不为空执行while循环
        {
            if (p == q) return true;//p与q相等，单链表有环
            if (q.next == null) {
                return false;
            }
            p = p.next;
            q = q.next.next;

        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.addNode(new ListNode(3));
        node.addNode(new ListNode(7));
        node.addNode(new ListNode(5));
        node.addNode(new ListNode(4));
        node.next.next.next.next = node.next.next;
        boolean result = CycleList.hasCircle(node);
        System.out.println(result);

    }

}

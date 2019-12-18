package list;

/**
 * Definition for list node
 */
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public void addNode(ListNode node){
        if (this.next == null){
            this.next = node;
        }else {
            this.next.addNode(node);
        }
    }
}

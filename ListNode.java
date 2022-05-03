import java.util.PriorityQueue;
import java.util.Queue;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String args[]) {
        Solution sol = new Solution();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        lists[2] = new ListNode(2, new ListNode(6, null));
        sol.mergeKLists(lists);
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode sol = null;
        ListNode temp = null;
        Queue<ListNode> heap = new PriorityQueue<>((head1,head2)->head1.val-head2.val);
        for (ListNode l : lists) {
            if (l != null) {
                heap.offer(l);
            }
        }
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            if (curr.next != null) {
                heap.offer(curr.next);
            }
            if (sol == null) {
                sol = new ListNode(temp.val);
                temp = sol;
            } else{
                temp.next = new ListNode(temp.val);
            }
        }
        System.out.println();
        return sol;
    }
    //moves the list one node to the right @ n
    public ListNode makeSpace (ListNode sol, int n) {
        int num = 0;
        ListNode temp = sol;
        while (temp.next != null) {
            if (num == n) {
                while (temp.next != null) {
                    int val = temp.val;

                }
            } else {
                num++;
            }

        }
        return sol;
    }
}
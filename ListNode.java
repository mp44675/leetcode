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
        ListNode sol = new ListNode();
        int inc = 0;
        sol = lists[0];             // sol is now the first list
        for (int i = 1; i < lists.length; i++) {
            ListNode temp = sol;
            ListNode lists_temp = lists[i];
            while (temp.next != null) {
                if (lists_temp.val == temp.val) {
                    //same value so put it next to each other
                    ListNode new_node = new ListNode(lists_temp.val);
                    new_node.next = temp.next;
                    temp.next = new_node;
                    temp = sol;
                } else if (lists_temp.val > temp.val) {
                    if (lists_temp.val < temp.val) {
                        //insert here
                    }
                    temp = temp.next;
                } 
                lists_temp = lists_temp.next;
            }
        }
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
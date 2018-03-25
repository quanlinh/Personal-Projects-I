
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }

    public static void insert(ListNode head){
        ListNode listNode1 = new ListNode(1);
        listNode1.next = null;
    }
}

class LinkedListClient {

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        // empty
        if(head == null) {
            return head;
        } // one element
        else if(head.next == null) {
            if(head.val == val) {
                head = null;
                return head;
            }
            // two element and above
        } else {
            while(curr.next != null) {
                // last element
                if(curr.next.next == null && curr.next.val == val){

                    curr.next = null;
                    if(curr.val == val) {
                        if(head == curr)
                            head = null;
                        else
                            curr = null;
                    }
                    break;
                }

                if(curr.val == val) {
                    curr.val = curr.next.val;
                    curr.next = curr.next.next;
                    continue;
                }
                curr = curr.next;
            }



        }
        return head;
    }

    public void insertBeginning(ListNode head, int val) {
        ListNode oldHead = head;
        head = new ListNode(val);
        head.next = oldHead;
    }

    public void removeBeginning(ListNode head) {
        head = head.next;
    }
    public void insertAtTheEnd(ListNode head, int val) {
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode lastNode = new ListNode(val);
        curr.next = lastNode;
    }
    public static void main(String [] a) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);

        listNode.next = listNode1;
        LinkedListClient linkedListClient = new LinkedListClient();
        linkedListClient.insertAtTheEnd(listNode,3);

//        ListNode listNode2 =   linkedListClient.removeElements(listNode,1);

    }

}
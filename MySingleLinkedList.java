public class MySingleLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * This strategy use three pointers prev, curr, and post to three nodes.
     * I try to improve it with only two pointers but still struggle to figure out
     * @param head
     * @return
     */
    public ListNode reverseLinkedList (ListNode head) {
        // only one elment

        if(head == null || head.next == null) {
            return head;
            // only two element
        } else if(head.next.next == null) {
            ListNode curr = head.next;
            // set the poiner of
            curr.next = head;
            head.next = null;
            return curr;
            // only three elements

        }
        else {
            ListNode prev = head;
            ListNode curr = prev.next;
            ListNode post = curr.next;
            head.next = null;
            while (post != null) {
                curr.next = prev;
                prev = curr;
                curr = post;
                if(post.next == null){
                    post.next = prev;
                    return post;
                } else {
                    post = post.next;
                }
            }
            return post;
        }
    }

    /**
     * In the not improved version, the linked list basically
     * forget that a linked Node can be null, using the null node
     * like this (adapt form LeetCode.com) make the solution shorter
     * @param head
     * @return the head to the likedList
     */
    public ListNode reverseListImproved(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode post = curr.next;
            curr.next = prev;
            prev = curr;
            curr = post;
        }
        return prev;
    }

    /**
     * The way of this linked list recursive works is that
     * it continued go to next node until it reach the end
     * of the list which is the base case; it also grab the end
     * node become a new head, it then start to
     * resetting the pointer on the way back.
     * One things is do extra works which is set the head.next
     * on the previous recursive call to null, then reset it to
     * the previous node on every step since there is no way to tell
     * when it need to stop.
     * @param head
     * @return
     */
    public ListNode reverseLinkedListRecursive(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode reverse = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        } else {
            ListNode prev = head;
            ListNode post = head.next;
            while(post.next != null) {
                if(prev.val == post.val) {
                    prev.next = post.next;
                    post = post.next;
                } else {
                    prev = post;
                    post  = post.next;
                }

            }
            if(prev.val == post.val) {
                prev.next = null;
            }
            return head;

        }
    }

    public void addToEnd(ListNode head, int val) {
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        ListNode newNode = new ListNode(val);
        curr.next = newNode;
    }

    /**
     *  This function take in to two list that already
     *  sorted and merge them and still keep the sorting
     *  orders.
     *  The first step is create an head that always to the smallest
     *  of the first element of either one linked list.
     *  The second steps:
     *  The strategy here to use two pointer for each, and make
     *  the prev of smaller pointers point to the largest pointer of
     *  the others.
     *  :) What I learn:
     *  the pointer values should only be access when it is not null
     *  in and condition, check for first condition satisfied first
     *  then check for second condition satisfied, since the first
     *  condition not satisfied, the seconds condition no need to check
     *  In this problems, the null point exception can be avoid to check
     *  the pointer is != null, if it is null, no more check is need.
     *  And the pointer.val will never reach a null point exception.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else {
            ListNode prev_1 = l1;
            ListNode post_1 = l1.next;
            ListNode prev_2 = l2;
            ListNode post_2 = l2.next;
            ListNode head;
            if(l1.val <= l2.val) head = l1;
            else head = l2;

            while(true) {
                while(post_1 != null &&  prev_2 != null && post_1.val <= prev_2.val) {
                    prev_1 = post_1;
                    post_1 = post_1.next;
                }
                if(prev_1 != null && prev_2 != null && prev_1.val <= prev_2.val ) {
                    prev_1.next = prev_2;
                    prev_1  = post_1;
                    if(post_1 != null) post_1 = post_1.next;
                }

                while(post_2 != null &&  prev_1 != null && post_2.val <= prev_1.val) {
                    prev_2 = post_2;
                    post_2 = post_2.next;
                }
                if(prev_1 != null && prev_2 != null && prev_2.val <= prev_1.val){
                    prev_2.next = prev_1;
                    prev_2 = post_2;
                    if(post_2 != null)  post_2 = post_2.next;
                }

                if(prev_1 == null || prev_2 == null) break;
            }
            return head;
        }
    }
    public static void main(String args[]) {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode fourth = new ListNode(4);
        third.next = fourth;
    }
}

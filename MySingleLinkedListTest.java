import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySingleLinkedListTest {
    @Test
    void reverseLinkedList() {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        MySingleLinkedList.ListNode head = new MySingleLinkedList.ListNode(1);
        MySingleLinkedList.ListNode second = new MySingleLinkedList.ListNode(2);
        head.next = second;
        MySingleLinkedList.ListNode third = new MySingleLinkedList.ListNode(3);
        second.next = third;
        MySingleLinkedList.ListNode fourth = new MySingleLinkedList.ListNode(4);
        third.next = fourth;
        MySingleLinkedList.ListNode fifth = new MySingleLinkedList.ListNode(5);
        fourth.next = fifth;
        fifth.next = null;
        int[] a  = {5,4,3,2,1};
        int[] b =  {1,2,3,4};

                MySingleLinkedList.ListNode curr =  mySingleLinkedList.reverseLinkedList(head);;

        int i = 0;
        while(curr.next != null) {
            assertTrue(curr.val == a[i++]);
//            assertTrue(curr.val == b[i++]);
            curr = curr.next;

        }
    }

    @Test
    void deleteDuplicates() {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();

        MySingleLinkedList.ListNode first = new MySingleLinkedList.ListNode(1);
        MySingleLinkedList.ListNode second = new MySingleLinkedList.ListNode(1);
        first.next = second;
        MySingleLinkedList.ListNode third = new MySingleLinkedList.ListNode(2);
        second.next = third;
        third.next = null;
        mySingleLinkedList.deleteDuplicates(first);
        int[] a = {1,2};
        MySingleLinkedList.ListNode curr = first;
        int i = 0;
        while (curr != null) {
            assertTrue(a[i++] == curr.val);
            System.err.println(curr.val);
            curr = curr.next;
        }

        System.err.println();
        // Test 1->1->2->3->3
        MySingleLinkedList mySingleLinkedList2 = new MySingleLinkedList();
        MySingleLinkedList.ListNode head = new MySingleLinkedList.ListNode(1);
        mySingleLinkedList2.addToEnd(head,1);
        mySingleLinkedList2.addToEnd(head,2);
        mySingleLinkedList2.addToEnd(head,3);
        mySingleLinkedList2.addToEnd(head,3);
        mySingleLinkedList2.deleteDuplicates(head);
        int[] a2 = {1,2,3};
        int j = 0;
        MySingleLinkedList.ListNode curr2 = head;

        while (curr2 != null) {
            assertTrue(a2[j++] == curr2.val);
            System.err.println(curr2.val);
            curr2 = curr2.next;
        }

        // Test 1->1->1
        MySingleLinkedList mySingleLinkedList3 = new MySingleLinkedList();
        MySingleLinkedList.ListNode head3 = new MySingleLinkedList.ListNode(1);
        mySingleLinkedList3.addToEnd(head3,1);
        mySingleLinkedList3.addToEnd(head3,1);
        MySingleLinkedList.ListNode curr3 = head3;
        mySingleLinkedList3.deleteDuplicates(head3);
        int[] a3 = {1};
        int k = 0;
        System.err.println();
        while (curr3 != null) {
            assertTrue(a3[k++] == curr3.val);
            System.err.println(curr3.val);
            curr3  = curr3.next;
        }
        // Test 1->1->1->2
        MySingleLinkedList mySingleLinkedList4 = new MySingleLinkedList();
        MySingleLinkedList.ListNode head4 = new MySingleLinkedList.ListNode(1);
        mySingleLinkedList4.addToEnd(head4,1);
        mySingleLinkedList4.addToEnd(head4,1);
        mySingleLinkedList4.addToEnd(head4,2);
        MySingleLinkedList.ListNode curr4 = head4;
        mySingleLinkedList4.deleteDuplicates(head4);
        int[] a4 = {1,2};
        int g = 0;
        System.err.println();
        while (curr4 != null) {
            assertTrue(a4[g++] == curr4.val);
            System.err.println(curr4.val);
            curr4  = curr4.next;
        }

    }

    @Test
    public void mergeTwoLists() {
        MySingleLinkedList mySingleLinkedList1 = new MySingleLinkedList();
        MySingleLinkedList mySingleLinkedList2 = new MySingleLinkedList();
        MySingleLinkedList.ListNode head1 =  new MySingleLinkedList.ListNode(5);
        MySingleLinkedList.ListNode head2 =  new MySingleLinkedList.ListNode(1);
        mySingleLinkedList2.addToEnd(head2,2);
        mySingleLinkedList2.addToEnd(head2,4);
        // Test the case [5] and [1,2,4]
        MySingleLinkedList.ListNode mySingleLinkedListMerge = mySingleLinkedList1.mergeTwoLists(head1,head2);
        MySingleLinkedList.ListNode curr = mySingleLinkedListMerge;
        while(curr.next != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
        System.out.println(curr.val);

    }

}
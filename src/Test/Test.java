package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Reverse a Linked List in groups of given size
 *
 * Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL, k = 2
 * Output: head: 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> NULL
 */
public class Test {
    public static void main(String[] args) {

        ListNode six = new ListNode(6,null);
        ListNode five = new ListNode(5,six);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode two = new ListNode(2,three);
        ListNode head = new ListNode(1,two);

        ListNode temp = head;
        ListNode prevList = null;

        while(temp != null)
        {
            ListNode kthNode = getKthNode(temp, 2);

            if(kthNode == null)
            {
                if (prevList != null) {
                    prevList.next = temp;
                }
                break;
            }

            ListNode nxtNd = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            if(temp == head)
            {
                head = kthNode;
            }
            else
            {
                prevList.next = temp;
            }
            prevList = temp;
            temp = nxtNd;
        }

        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static ListNode reverseLinkedList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode front = head;

        while(curr != null)
        {
            front = front.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    private static ListNode getKthNode(ListNode nd, int k)
    {
        while(nd != null && k >=0)
        {
            nd = nd.next;
            k--;
        }
        return nd;
    }
}
class ListNode
{
    int data;
    ListNode next;

    public ListNode(int data, ListNode next)
    {
        this.data = data;
        this.next = next;

    }
}
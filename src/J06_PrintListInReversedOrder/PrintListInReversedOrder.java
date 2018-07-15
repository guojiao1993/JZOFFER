package J06_PrintListInReversedOrder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题6：从尾到头打印链表
 * <p>题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class PrintListInReversedOrder {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(printListFromTailToHead(listNode));
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

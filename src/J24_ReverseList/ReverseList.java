package J24_ReverseList;

import java.util.Stack;

/**
 * 面试题24：反转链表
 * <p>题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
 * <p>利用栈先进后出的特点，反转链表中的节点值
 * <p>OJ：https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        Stack<Integer> val = new Stack<>();
        ListNode p = head;
        while (p != null) {
            val.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            p.val = val.pop();
            p = p.next;
        }
        return head;
    }
}

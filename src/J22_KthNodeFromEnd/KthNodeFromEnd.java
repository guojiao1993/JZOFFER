package J22_KthNodeFromEnd;

/**
 * 面试题22：链表中倒数第k个结点
 * <p>题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 * <p>OJ：https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * <p>RE：https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#22-%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC-k-%E4%B8%AA%E7%BB%93%E7%82%B9
 */
public class KthNodeFromEnd {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) {
            return null;
        }
        ListNode pre = head;
        ListNode p = pre;
        for (int i = 1; i < k; i++) {
            p = p.next;
            if(p == null) {
                return null;
            }
        }
        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
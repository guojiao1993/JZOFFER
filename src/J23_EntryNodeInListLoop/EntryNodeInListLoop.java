package J23_EntryNodeInListLoop;

/**
 * 面试题23：链表中环的入口结点
 * <p>题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * 环的入口结点是结点3。
 * <p>OJ：https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * <p>RE：https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#23-%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%8E%AF%E7%9A%84%E5%85%A5%E5%8F%A3%E7%BB%93%E7%82%B9
 */
public class EntryNodeInListLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode p = pHead;
        ListNode p2 = pHead.next;
        while (p2 != p) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            if(p2 == null) {
                return null;
            }
            p2 = p2.next;
            p = p.next;
        }
        p = p.next;
        p2 = pHead;
        while (p != p2) {
            p = p.next;
            p2 = p2.next;
        }
        return p;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
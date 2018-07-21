package J18_DeleteNodeInList;

/**
 * 面试题18（二）：删除链表中重复的结点
 * <p>题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * 结点被删除之后，链表如图3.4（b）所示。
 * <p>OJ：https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class DeleteDuplicatedNode {
    // 测试用例有{1,1,1,1,1,2}、{1,1,2,3,3,4,5,5}
    public ListNode deleteDuplication(ListNode pHead) {
        // 先特殊处理头节点
        while (true) {
            if (pHead == null) {
                return null;
            }
            ListNode preNode = pHead;
            while (preNode.next != null && preNode.val == preNode.next.val) {
                preNode = preNode.next;
            }
            if (preNode == pHead) {
                break;
            } else {
                pHead = preNode.next;
            }
        }
        // 处理除头节点外的其他节点的情况
        ListNode preNode = pHead;
        ListNode tempNode = preNode.next;
        while (tempNode != null && tempNode.next != null) {
            // 这里仍然需要判断tempNode != null && tempNode.next != null
            while (tempNode != null && tempNode.next != null && tempNode.val == tempNode.next.val) {
                tempNode = tempNode.next;
            }
            // pre后无相邻重复节点
            if (preNode.next == tempNode) {
                preNode = tempNode;
            } else {
                // 跳过中间重复的节点
                preNode.next = tempNode.next;
            }
            tempNode = tempNode.next;
        }
        return pHead;
    }
}

package J62_LastNumberInCircle;

/**
 * 面试题62：圆圈中最后剩下的数字
 * <p>题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class LastNumberInCircle {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }

    /**
     * 使用环形链表法
     * @param n 数字个数
     * @param m 删除计数
     * @return 最后剩下的数字
     */
    public static int LastRemaining_Solution(int n, int m) {
        // 处理特殊输入
        if(n == 0) {
            return -1;
        }
        Node head = null;
        Node temp = null;
        // 构造链表
        for (int i = 0; i < n; i++) {
            if(head == null) {
                head = new Node(i, null);
                temp = head;
            } else {
                temp.next = new Node(i, null);
                temp = temp.next;
            }
        }
        // 使链表成环
        temp.next = head;
        // 遍历删除，直至最后只剩一个数字
        while(head != head.next) {
            // 当前是第1个，所以迭代m-1次
            for (int i = 1; i < m; i++) {
                temp = head;
                head = head.next;
            }
            temp.next = temp.next.next;
            // 以删除后的数字为新的开始
            head = temp.next;
        }
        return head.value;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
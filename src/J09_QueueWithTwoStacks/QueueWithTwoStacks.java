package J09_QueueWithTwoStacks;

import java.util.Stack;

/**
 * 面试题9：用两个栈实现队列
 * <p>题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

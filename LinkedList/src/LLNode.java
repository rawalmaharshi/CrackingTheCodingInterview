import java.util.Scanner;

public class LLNode<T> {
    T data;
    LLNode next;

    public LLNode (T data) {
        this.data = data;
        this.next = null;
    }

    public LLNode insertNode (LLNode head, T data) {
        //edge case
        if (head == null) {
            return null;
        }

        LLNode insNode = new LLNode(data);
        LLNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        //Reached the end
        temp.next = insNode;
        insNode.next = null;

        return head;
    }

    public static LLNode deleteNode (LLNode head, LLNode delNode) {
        //edge case
        if (head == null) {
            return null;
        }

        LLNode temp = head, prev = null;
        while (temp != null) {
            if (delNode == temp) {
                if (prev == null) {     //case 1: Delete head
                    head = head.next;
                    return head;
                } else if (temp.next == null) {     //case 2: Delete tail
                    prev.next = null;
                    return head;
                } else {        //case 3: Delete middle node
                    prev.next = temp.next;
                    return head;
                }
            }

            prev = temp;
            temp = temp.next;
        }

        return head;    //Node not found
    }

    public static void printList (LLNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.data);
            } else {
                System.out.print(head.data + " -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.print("Enter the length of Linked List: ");
//        int length = s.nextInt();

        LLNode<Integer> node1 = new LLNode<Integer> (10);
        System.out.println(node1.data);
        System.out.println(node1.next);

        LLNode<Integer> node2 = new LLNode<Integer> (20);
        LLNode<Integer> node3 = new LLNode<Integer> (30);
        LLNode<Integer> node4 = new LLNode<Integer> (40);
        LLNode<Integer> node5 = new LLNode<Integer> (50);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LLNode<Integer> head = node1;
        printList(head);

        head = deleteNode(head, node1);
        head = deleteNode(head, node5);
        head = deleteNode(head, node3);
        printList(head);
    }
}
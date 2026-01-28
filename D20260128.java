import java.util.Scanner;

class PriorityNode {
    int priority, value;
    PriorityNode next, previous;

    PriorityNode(int value, int priority) {
        this.priority = priority;
        this.value = value;
        next = previous = null;
    }

}

class PriorityQ {
    PriorityNode front = null, rear = null;

    void insert(int val, int priority) {
        PriorityNode newNode = new PriorityNode(val, priority);
        if (front == null) {
            front = rear = newNode;
        } else if (priority < front.priority) {
            newNode.next = front;
            front.previous = newNode;
            front = newNode;
        } else {
            PriorityNode temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }

            if (temp.next == null) {
                rear.next = newNode;
                newNode.previous = rear;
                rear = newNode;
            } else {
                newNode.next = temp.next;
                temp.next.previous = newNode;
                temp.next = newNode;
                newNode.previous = temp;
            }
        }
    }

    void display() {
        PriorityNode temp = front;
        
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}

public class D20260128 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQ head = new PriorityQ();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int pr = sc.nextInt();
            head.insert(val, pr);
        }

        head.display();

        sc.close();
    }
}
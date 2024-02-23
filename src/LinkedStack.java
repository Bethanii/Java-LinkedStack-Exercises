public class LinkedStack<E> {
    private Node<E> last;
    private int count;

    public LinkedStack() {
        last = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(E element) {
        last = new Node<E>(last, element);
        count++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> curr = last;
        last = last.pre;
        curr.pre = null;
        count--;
        return curr.element;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return last.element;
    }

    public void showStack() {
        Node<E> current = last;
        while (current != null) {
            System.out.print(current.element);
            current = current.pre;
            System.out.println();
        }
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        LinkedStack<Character> buffer = new LinkedStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1)
                buffer.push(c);
            else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty())
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }
        }
        return buffer.isEmpty();
    }

    private static class Node<E> {
        Node<E> pre;
        E element;

        Node(Node<E> pre, E element) {
            this.pre = pre;
            this.element = element;
        }
    }
}

class Main {
    public static void main(String[] args) {
        LinkedStack<String> buffer = new LinkedStack<>();

        buffer.push("UMC");
        buffer.push("UND");
        System.out.println(buffer.pop());
        System.out.println(buffer.size());
        System.out.println(buffer.pop());

        buffer.showStack();

        boolean match = buffer.isMatched("{[()]}");
        System.out.println("Match: " + match);

        match = buffer.isMatched("{[(}");
        System.out.println("Match: " + match);
    }
}
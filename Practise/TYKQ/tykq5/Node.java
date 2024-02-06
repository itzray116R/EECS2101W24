public class Node {
    char content;
    Node next;

    public Node(char c, Node tail) {
        content = c;
        next = tail;
    }

    public void Add(char c) {
        next = new Node(c, next);
    }

    public static void main(String[] args) {
        String s1 = new String("42");
        Node aList = new Node((char) 0, null);

        for (int i = 0; i < s1.length(); i++) {
            int c = Integer.parseInt(s1.substring(i, i + 1));
            for (int n = c; n > 0; n--) {
                aList.Add(s1.charAt(i));
            }
        }

        for (Node nd = aList.next; nd != null; nd = nd.next) {
            System.out.print(nd.content + "$");
        }
    }
}

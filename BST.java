class Node {
    int book_id;
    String title;
    Node left, right;

    Node(int book_id, String title) {
        this.book_id = book_id;
        this.title = title;
        left = right = null;
    }
}

public class BST {

    // Insert operation
    Node insert(Node root, int book_id, String title) {

        if (root == null) {
            return new Node(book_id, title);
        }

        if (book_id < root.book_id) {
            root.left = insert(root.left, book_id, title);
        } else {
            root.right = insert(root.right, book_id, title);
        }

        return root;
    }

    // Search operation
    Node search(Node root, int key) {

        if (root == null || root.book_id == key) {
            return root;
        }

        if (key < root.book_id) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Main method
    public static void main(String[] args) {

        BST tree = new BST();
        Node root = null;

        root = tree.insert(root, 101, "Java");
        root = tree.insert(root, 105, "Python");
        root = tree.insert(root, 102, "C Programming");

        int key = 105;

        Node result = tree.search(root, key);

        if (result != null) {
            System.out.println("Book Found:");
            System.out.println("Book ID: " + result.book_id);
            System.out.println("Title: " + result.title);
        } else {
            System.out.println("Book not found");
        }
    }
}
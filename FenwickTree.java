class FenwickTree {

    int size;
    int[] tree;

    // Constructor
    FenwickTree(int size) {
        this.size = size;
        tree = new int[size + 1];
    }

    // Update function
    void update(int index, int value) {

        while (index <= size) {
            tree[index] += value;
            index += index & (-index);
        }
    }

    // Query function
    int query(int index) {

        int total = 0;

        while (index > 0) {
            total += tree[index];
            index -= index & (-index);
        }

        return total;
    }

    // Main method
    public static void main(String[] args) {

        FenwickTree ft = new FenwickTree(5);

        ft.update(1, 5);
        ft.update(2, 3);

        System.out.println(ft.query(2));
    }
}
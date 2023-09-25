import java.util.List;

public class Tree<T> {

    private T root;
    private final List<Tree<T>> subtrees;

    public Tree(T root, List<T> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int length() {
        if (root == null)
            return 0;
        int size = 1;
        for (Tree<T> subtree : subtrees) {
            size += subtree.length();
        }
        return size;
    }

    public int count(T item) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.equals(item)) {
            count += 1;
        }
        for (Tree<T> subtree : subtrees) {
            count += subtree.count(item);
        }
        return count;
    }

    @Override
    public String toString() {
        toString0(0);
    }

    private String toString0(int depth) {
        if (root == null)
            return "";

        StringBuilder b = new StringBuilder(" ".repeat(depth));
        b.append(root);
        b.append('\n');
        for (Tree<T> subtree : subtrees) {
            b.append(subtree.toString0(depth + 1));
        }
        return b.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (!(other instanceof Tree<?>)) {
            return false;
        }
        Tree<T> ot = (Tree<T>) other;
        if (root != ot.root)
            return false;
        return subtrees.equals(ot.subtrees);
    }
}

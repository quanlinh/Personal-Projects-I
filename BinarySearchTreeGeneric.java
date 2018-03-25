import java.util.Comparator;

public class BinarySearchTreeGeneric<Key extends Comparable<Key>, Value>
{
    private class TreeNode {
        private Key key;
        private Value val;
        private TreeNode left, right;
        public TreeNode(Key key, Value val) {
            this.key = key;
            this.val = val;
        }

        public void put(Key key, Value value) {

        }

        public Value get(Key key) {
            return  null;
        }

        public void delete(Key key) {

        }

        public Iterable<Key> iterator() {
            return null;
        }

    }
}

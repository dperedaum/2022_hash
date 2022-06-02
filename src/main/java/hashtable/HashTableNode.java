package hashtable;

public class HashTableNode<Key, Value> {

    private Key key;

    private Value value;

    private boolean deleted;

    public HashTableNode(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

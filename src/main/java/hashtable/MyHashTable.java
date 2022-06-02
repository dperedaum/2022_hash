package hashtable;

public interface MyHashTable <Key, Value> {

    void put(Key k, Value v);

    Value get(Key k);

    void remove(Key k);

    int size();

}

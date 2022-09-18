package dataStructure.core.binarytree;

public interface Tree<T extends  Comparable<T>>{

    Tree<T> insert(T value);
    void delete(T value);
    void traverse();
    T getMax();
    T getMin();
    boolean isEmpty();
}

public interface MultiSet<T> {
    boolean add(T item);

    void remove(T item);

    boolean contains(T item);

    int count(T item);

    int size();
}

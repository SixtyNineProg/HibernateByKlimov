package dao;

public interface Dao<E, K> {
    void add(E entity);
    E findById(K key);
    void update(E entity);
    void delete(E entity);
}

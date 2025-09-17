package app.dao;

public interface IDAO<T, I> {

    public void create(T t);

    public void recover(I id);

    public void update(T t, I id);

    public void delete(I id);
}

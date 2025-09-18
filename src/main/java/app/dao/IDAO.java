package app.dao;

public interface IDAO<T, I> {

    public T create(T t);

    public T read(I id);

    public T update(T t);

    public T delete(I id);
}

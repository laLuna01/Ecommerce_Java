package main.java.org.example.repositories;

import main.java.org.example.entities._BaseEntity;

import java.util.List;

public interface _BaseRepository<T extends _BaseEntity> {
    public void Create(T entity);
    public List<T> Read();
    public void Update(T entity);
    public void Delete(T entity);
}

package org.example.repositories;

import org.example.entities._BaseEntity;

import java.util.List;

public interface _BaseRepository<T extends _BaseEntity> {
    public void Create(T entity);
    public List<T> Read();
    public void Update(T entity);
    public void Delete(int idItem);
}

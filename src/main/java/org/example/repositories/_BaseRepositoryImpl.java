package org.example.repositories;

import org.example.entities._BaseEntity;

import java.util.List;

import java.util.ArrayList;

public class _BaseRepositoryImpl<T extends _BaseEntity> implements _BaseRepository {

    protected List<T> entities = new ArrayList<>();

    public _BaseRepositoryImpl() {
    }

    @Override
    public void Create(_BaseEntity entity) {
        entities.add((T) entity);
    }

    @Override
    public List Read() {
        return entities;
    }

    @Override
    public void Update(_BaseEntity entity) {
        entities.removeIf(item -> item.getId() == entity.getId());
        entities.add((T) entity);
    }

    @Override
    public void Delete(_BaseEntity entity) {
        entities.removeIf(item -> item.getId() == entity.getId());
    }
}

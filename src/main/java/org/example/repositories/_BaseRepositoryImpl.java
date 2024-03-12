package org.example.repositories;

import org.example.entities._BaseEntity;
import java.util.List;

import java.util.ArrayList;

public class _BaseRepositoryImpl<T extends _BaseEntity> implements _BaseRepository {

    private List<T> entities = new ArrayList<>();
    private final Class<T> type;

    public _BaseRepositoryImpl(Class<T> type) {
        this.type = type;

    }

    public Class<T> getType() {
        return type;
    }

    @Override
    public void Create(_BaseEntity entity) {
        if (entity.getClass() == this.getType()) {
            entities.add((T) entity);
            System.out.println("Object added");
        } else {
            System.out.println("This object is not a " + this.getType().getSimpleName());
        }
    }

    @Override
    public List Read() {
        return entities;
    }

    @Override
    public void Update(_BaseEntity entity) {
        entities.removeIf(item -> item.getId() == entity.getId());
        if (entity.getClass() == this.getType()) {
            entities.add((T) entity);
            System.out.println("Object updated");
        } else {
            System.out.println("This object is not a " + this.getType().getSimpleName());
        }
    }

    @Override
    public void Delete(_BaseEntity entity) {
        entities.removeIf(item -> item.getId() == entity.getId());
    }

}

package org.example.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import org.example.entities.Product;
import org.example.entities._BaseEntity;

import javax.xml.namespace.QName;
import java.io.*;
import java.lang.reflect.Type;
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

    public String createFile() {
        String path = this.getType().getSimpleName() + "s.json";
        File file = new File(path);
        return path;
    }
    public void toJson() {
        String path = createFile();
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new Gson();
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(gson.toJson(entities));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String fromJson() {
        String path = createFile();
        var gson = new Gson();
        try (var jsonReader = new JsonReader(new FileReader(path))) {
            List products =  gson.fromJson(jsonReader, List.class);
            var productString = products.get(0).toString();
            return productString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

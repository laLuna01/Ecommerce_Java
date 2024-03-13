package org.example.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.entities.Client;
import org.example.entities.Product;
import org.example.entities.Sale;
import org.example.entities._BaseEntity;

import javax.xml.namespace.QName;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.CharBuffer;
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
            System.out.println("\nObject created\n");
        } else {
            System.out.println("\nThis is not a " + this.getType().getSimpleName() + "\n");
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
            System.out.println("\nObject updated\n");
        } else {
            System.out.println("\nThis is not a " + this.getType().getSimpleName() + "\n");
        }
    }

    @Override
    public void Delete(int delId) {
        entities.removeIf(item -> item.getId() == delId);
        System.out.println("\nObject deleted\n");
    }

    public Client addClientToSale(int clientId) {
        Client client = new Client();
        for (_BaseEntity item : entities) {
            if (item.getId() == clientId) {
                client = (Client) item;
            }
        }
        return client;
    }

    public Product addProductToSaleItem(int productId) {
        Product product = new Product();
        for (_BaseEntity item : entities) {
            if (item.getId() == productId) {
                product = (Product) item;
            }
        }
        return product;
    }

    public String createFile() {
        String path = this.getType().getSimpleName() + "s.json";
        File file = new File(path);
        return path;
    }
    public void toJson() {
        String path = createFile();
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(gson.toJson(this.entities));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String fromJson() {
        String result;
        String path = createFile();
        File file = new File(path);
        if (file.exists()) {
            var gson = new Gson();
            try (var jsonReader = new JsonReader(new FileReader(path))) {
                Type listType = jsonTypes();
                ArrayList newEntities = gson.fromJson(jsonReader, listType);
                for (Object item: newEntities) {
                    if (this.type.equals(Product.class)) {
                        Product product = (Product) item;
                        entities.add((T) product);
                    } else if (this.type.equals(Client.class)) {
                        Client client = (Client) item;
                        entities.add((T) client);
                    } else if (this.type.equals(Sale.class)) {
                        Sale sale = (Sale) item;
                        entities.add((T) sale);
                    }
                }
                result = "Success";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No file");
            result = "Fail";
        }
        return result;
    }

    public Type jsonTypes() {
        Type jsonListType = null;
        if (this.type.equals(Product.class)) {
            Type productListType = new TypeToken<ArrayList<Product>>(){}.getType();
            jsonListType = productListType;
        } else if (this.type.equals(Client.class)) {
            Type clientListType = new TypeToken<ArrayList<Client>>(){}.getType();
            jsonListType = clientListType;
        } else if (this.type.equals(Sale.class)) {
            Type saleListType = new TypeToken<ArrayList<Sale>>(){}.getType();
            jsonListType = saleListType;
        }
        return jsonListType;
    }
}

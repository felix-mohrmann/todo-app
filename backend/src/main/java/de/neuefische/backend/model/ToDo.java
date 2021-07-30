package de.neuefische.backend.model;

import java.util.Objects;
import java.util.UUID;

public class ToDo {


    private  String id;
    private final String description;
    private final String status;


    public ToDo(String description,String status) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return Objects.equals(description, toDo.description) && Objects.equals(id, toDo.id) && Objects.equals(status, toDo.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id, status);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

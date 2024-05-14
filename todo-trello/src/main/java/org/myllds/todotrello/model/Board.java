package org.myllds.todotrello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Board {
    private String id;
    private String name;
    private Map<String, ToDoList> toDoListMap;
    private String ownerId;
    private List<User> users;
    private BoardType type;

    public Board(String name, User user) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ownerId = user.getId();
        this.users = new ArrayList<>();
        this.users.add(user);
        this.toDoListMap = new ConcurrentHashMap<>();
        this.type = BoardType.PUBLIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoardType getType() {
        return type;
    }

    public void setType(BoardType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, ToDoList> getToDoListMap() {
        return toDoListMap;
    }

    public void setToDoListMap(Map<String, ToDoList> toDoListMap) {
        this.toDoListMap = toDoListMap;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[\n");
        for (Map.Entry<String, ToDoList> taskEntry : toDoListMap.entrySet()) {
            sb.append(taskEntry.getValue().toString());
            sb.append("\n");
        }
        sb.append("]\n");

        return "Board: {\n" +
                "id:" + id + "\n" +
                "name:" + name + "\n" +
                sb.toString() + "\n" +
                "}";
    }
}

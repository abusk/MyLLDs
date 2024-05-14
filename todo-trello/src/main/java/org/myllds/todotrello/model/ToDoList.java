package org.myllds.todotrello.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class ToDoList {
    private String name;
    private String id;
    private Map<String, ToDoTask> tasks;

    public ToDoList(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        tasks = new ConcurrentHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, ToDoTask> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, ToDoTask> tasks) {
        this.tasks = tasks;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[\n");
        for (Map.Entry<String, ToDoTask> taskEntry : tasks.entrySet()) {
            sb.append(taskEntry.getValue().toString());
            sb.append("\n");
        }
        sb.append("]\n");

        return "List: {" + "\n" +
                "id:" + id + "\n" +
                "name:" + name + "\n" +
                 sb.toString() + "\n" +
                "}\n";
    }
}

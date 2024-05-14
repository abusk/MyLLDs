package org.myllds.todotrello.model;

import java.util.Date;
import java.util.UUID;

public class ToDoTask {
    private String id;
    private String name;
    private String desc;
    private String label;
    private Date createDate;
    private Date endDate;
    private String ownerId;
    private String assignTo;

    public ToDoTask(String name, String desc) {
        this.name =name;
        this.desc = desc;
        this.id = UUID.randomUUID().toString();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String toString() {
        return "Task: {\n" +
                "id:" + id + "\n" +
                "name:" + name + "\n" +
                "}\n";
    }
}

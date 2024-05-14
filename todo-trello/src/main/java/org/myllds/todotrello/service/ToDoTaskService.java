package org.myllds.todotrello.service;

import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.ToDoTask;
import org.myllds.todotrello.model.User;

public interface ToDoTaskService {
    ToDoTask createTask(User user, String name, String desc) throws PermissionDeniedException;
    void deleteTask(User user, String taskId) throws PermissionDeniedException;
    void assignTask(User adminUser, String taskId, User user) throws PermissionDeniedException;
}

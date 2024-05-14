package org.myllds.todotrello.service;

import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.ToDoList;
import org.myllds.todotrello.model.User;

public interface ToDoListService {
    ToDoList createTodoList(User user, String name) throws PermissionDeniedException;

    void deleteList(User adminUser, String listId) throws PermissionDeniedException;
}

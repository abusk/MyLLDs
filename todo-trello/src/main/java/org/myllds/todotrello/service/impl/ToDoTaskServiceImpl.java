package org.myllds.todotrello.service.impl;

import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.Board;
import org.myllds.todotrello.model.BoardType;
import org.myllds.todotrello.model.ToDoList;
import org.myllds.todotrello.model.ToDoTask;
import org.myllds.todotrello.model.User;
import org.myllds.todotrello.repository.BoardRepo;
import org.myllds.todotrello.service.ToDoTaskService;

import java.util.List;
import java.util.Map;

public class ToDoTaskServiceImpl implements ToDoTaskService {
    private final BoardRepo boardRepo;
    private final Board board;
    private final ToDoList list;

    public ToDoTaskServiceImpl(BoardRepo boardRepo, Board board, ToDoList list) {
        this.boardRepo = boardRepo;
        this.board = board;
        this.list = list;
    }

    @Override
    public ToDoTask createTask(User user, String name, String desc) throws PermissionDeniedException {
        List<User> users = board.getUsers();
        if(board.getType() == BoardType.PUBLIC || users.contains(user)) {
            ToDoTask toDoTask = new ToDoTask(name, desc);
            Map<String, ToDoTask> tasks = list.getTasks();
            tasks.put(toDoTask.getId(), toDoTask);
            list.setTasks(tasks);
            Map<String, ToDoList> toDoListMap = board.getToDoListMap();
            toDoListMap.put(list.getId(), list);
            board.setToDoListMap(toDoListMap);
            boardRepo.addBoard(board);
            return toDoTask;
        } else {
            throw new PermissionDeniedException("User:[" + user.getId() + "] don't have permission");
        }
    }

    @Override
    public void deleteTask(User user, String taskId) throws PermissionDeniedException {
        List<User> users = board.getUsers();
        if(board.getType() == BoardType.PUBLIC || users.contains(user)) {
            Map<String, ToDoTask> tasks = list.getTasks();
            tasks.remove(taskId);
            list.setTasks(tasks);
            Map<String, ToDoList> toDoListMap = board.getToDoListMap();
            toDoListMap.put(list.getId(), list);
            board.setToDoListMap(toDoListMap);
            boardRepo.addBoard(board);
        } else {
            throw new PermissionDeniedException("User:[" + user.getId() + "] don't have permission");
        }
    }

    @Override
    public void assignTask(User adminUser, String taskId, User user) throws PermissionDeniedException {
        List<User> users = board.getUsers();
        if(board.getType() == BoardType.PUBLIC || users.contains(adminUser)) {
            Map<String, ToDoTask> tasks = list.getTasks();
            ToDoTask toDoTask = tasks.get(taskId);
            toDoTask.setAssignTo(user.getId());
            list.setTasks(tasks);
            Map<String, ToDoList> toDoListMap = board.getToDoListMap();
            toDoListMap.put(list.getId(), list);
            board.setToDoListMap(toDoListMap);
            boardRepo.addBoard(board);
        } else {
            throw new PermissionDeniedException("User:[" + adminUser.getId() + "] don't have permission");
        }
    }
}

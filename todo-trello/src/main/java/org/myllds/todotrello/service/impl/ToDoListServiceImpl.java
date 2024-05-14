package org.myllds.todotrello.service.impl;

import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.Board;
import org.myllds.todotrello.model.BoardType;
import org.myllds.todotrello.model.ToDoList;
import org.myllds.todotrello.model.User;
import org.myllds.todotrello.repository.BoardRepo;
import org.myllds.todotrello.service.ToDoListService;

import java.util.List;
import java.util.Map;

public class ToDoListServiceImpl implements ToDoListService {
    private final BoardRepo boardRepo;
    private final Board board;


    public ToDoListServiceImpl(BoardRepo boardRepo, Board board) {
        this.boardRepo = boardRepo;
        this.board = board;
    }

    @Override
    public ToDoList createTodoList(User user, String name) throws PermissionDeniedException {
        List<User> users = board.getUsers();
        if(board.getType() == BoardType.PUBLIC || users.contains(user)) {
            ToDoList toDoList = new ToDoList(name);
            Map<String, ToDoList> toDoListMap = board.getToDoListMap();
            toDoListMap.put(toDoList.getId(), toDoList);
            board.setToDoListMap(toDoListMap);
            boardRepo.addBoard(board);
            return toDoList;
        } else {
            throw new PermissionDeniedException("User:[" + user.getId() + "] don't have permission");
        }
    }

    @Override
    public void deleteList(User adminUser, String listId) throws PermissionDeniedException {
        List<User> users = board.getUsers();
        if(board.getType() == BoardType.PUBLIC || users.contains(adminUser)) {
            Map<String, ToDoList> toDoListMap = board.getToDoListMap();
            toDoListMap.remove(listId);
            board.setToDoListMap(toDoListMap);
            boardRepo.addBoard(board);
        } else {
            throw new PermissionDeniedException("User:[" + adminUser.getId() + "] don't have permission");
        }
    }
}

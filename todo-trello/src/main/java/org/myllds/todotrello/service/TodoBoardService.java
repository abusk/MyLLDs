package org.myllds.todotrello.service;

import org.myllds.todotrello.exceptions.BoardNotFoundException;
import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.Board;
import org.myllds.todotrello.model.User;

public interface TodoBoardService {
    Board createBoard(User user, String name, String description);
    void updateBoard(Board board) throws BoardNotFoundException;
    void deleteBoard(User adminUser, String boardId) throws BoardNotFoundException, PermissionDeniedException;
    void addUserToBoard(User adminUser, User user, String boardId) throws BoardNotFoundException, PermissionDeniedException;
    void removeUserFromBoard(User adminUser, User user, String boardId) throws BoardNotFoundException, PermissionDeniedException;
    String viewBoard(User user, String boardId) throws BoardNotFoundException, PermissionDeniedException;
}

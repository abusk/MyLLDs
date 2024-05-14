package org.myllds.todotrello.service.impl;

import org.myllds.todotrello.exceptions.BoardNotFoundException;
import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.Board;
import org.myllds.todotrello.model.BoardType;
import org.myllds.todotrello.model.User;
import org.myllds.todotrello.repository.BoardRepo;
import org.myllds.todotrello.service.TodoBoardService;

import java.util.List;

public class ToDoBoardServiceImpl implements TodoBoardService {

    private final BoardRepo boardRepo;
    public ToDoBoardServiceImpl(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    @Override
    public Board createBoard(User user, String name, String description) {
        Board board = new Board(name, user);
        boardRepo.addBoard(board);
        return board;
    }

    @Override
    public void updateBoard(Board board) throws BoardNotFoundException {
        boardRepo.getBoard(board.getId());
        boardRepo.addBoard(board);
    }

    @Override
    public void deleteBoard(User adminUser, String boardId) throws BoardNotFoundException, PermissionDeniedException {
        Board board = boardRepo.getBoard(boardId);
        if(board.getUsers().contains(adminUser)) {
            boardRepo.deleteBoard(boardId);
        } else {
            throw new PermissionDeniedException("User:[" + adminUser.getId() + "] don't have permission");
        }
    }

    @Override
    public void addUserToBoard(User adminUser, User user, String boardId) throws BoardNotFoundException, PermissionDeniedException {
        Board board = boardRepo.getBoard(boardId);
        if(board.getType() == BoardType.PUBLIC) {
            return;
        }
        if(board.getUsers().contains(adminUser)) {
            List<User> users = board.getUsers();
            users.add(user);
            board.setUsers(users);
            boardRepo.addBoard(board);
        } else {
            throw new PermissionDeniedException("User:[" + adminUser.getId() + "] don't have permission");
        }
    }

    @Override
    public void removeUserFromBoard(User adminUser, User user, String boardId) throws BoardNotFoundException, PermissionDeniedException {
        Board board = boardRepo.getBoard(boardId);
        if(board.getType() == BoardType.PUBLIC) {
            return;
        }
        if(board.getUsers().contains(adminUser)) {
            List<User> users = board.getUsers();
            users.remove(user);
            board.setUsers(users);
            boardRepo.addBoard(board);
        } else {
            throw new PermissionDeniedException("User:[" + adminUser.getId() + "] don't have permission");
        }
    }

    @Override
    public String viewBoard(User user, String boardId) throws BoardNotFoundException, PermissionDeniedException {
        Board board = boardRepo.getBoard(boardId);
        if(board.getUsers().contains(user)) {
            return board.toString();
        } else {
            throw new PermissionDeniedException("User:[" + user.getId() + "] don't have permission");
        }
    }
}

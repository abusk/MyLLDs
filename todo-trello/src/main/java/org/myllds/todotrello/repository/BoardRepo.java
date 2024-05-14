package org.myllds.todotrello.repository;

import org.myllds.todotrello.exceptions.BoardNotFoundException;
import org.myllds.todotrello.model.Board;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BoardRepo {
    private Map<String, Board> boards;

    public BoardRepo() {
        boards = new ConcurrentHashMap<>();
    }

    public void addBoard(Board board) {
        boards.put(board.getId(), board);
    }

    public Board getBoard(String boardId) throws BoardNotFoundException {
        if (boards.containsKey(boardId)) {
            return boards.get(boardId);
        } else {
            throw new BoardNotFoundException("Board not found to remove");
        }
    }
    public void deleteBoard(String boardId) throws BoardNotFoundException {
        if (boards.containsKey(boardId)) {
            boards.remove(boardId);
        } else {
            throw new BoardNotFoundException("Board not found to remove");
        }
    }
}

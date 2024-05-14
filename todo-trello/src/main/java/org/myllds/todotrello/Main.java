package org.myllds.todotrello;

import org.myllds.todotrello.exceptions.BoardNotFoundException;
import org.myllds.todotrello.exceptions.PermissionDeniedException;
import org.myllds.todotrello.model.Board;
import org.myllds.todotrello.model.ToDoList;
import org.myllds.todotrello.model.User;
import org.myllds.todotrello.repository.BoardRepo;
import org.myllds.todotrello.service.ToDoListService;
import org.myllds.todotrello.service.ToDoTaskService;
import org.myllds.todotrello.service.TodoBoardService;
import org.myllds.todotrello.service.impl.ToDoBoardServiceImpl;
import org.myllds.todotrello.service.impl.ToDoListServiceImpl;
import org.myllds.todotrello.service.impl.ToDoTaskServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("u1");
        User user2 = new User("u2");
        User user3 = new User("u3");
        User user4 = new User("u4");
        User user5 = new User("u4");
        BoardRepo boardRepo = new BoardRepo();
        TodoBoardService boardService = new ToDoBoardServiceImpl(boardRepo);
        Board board = boardService.createBoard(user1, "Retro", "Retrospective on last sprint");

        ToDoListService toDoListService = new ToDoListServiceImpl(boardRepo, board);
        try {
            ToDoList kudos = toDoListService.createTodoList(user2, "Kudos");
            ToDoList whatWentWell = toDoListService.createTodoList(user3, "What Went Well");
            ToDoList actionItems = toDoListService.createTodoList(user1, "Action Items");

            ToDoTaskService kudosTaskService = new ToDoTaskServiceImpl(boardRepo, board, kudos);
            kudosTaskService.createTask(user1, "prod Deployment", "Deployment done");
            kudosTaskService.createTask(user4, "Pentest", "Pentest done");

            ToDoTaskService wellTaskService = new ToDoTaskServiceImpl(boardRepo, board, whatWentWell);
            wellTaskService.createTask(user2, "BugFixed", "Bug fixed and deployed");

            ToDoTaskService actionTodotaskService = new ToDoTaskServiceImpl(boardRepo, board, actionItems);
            actionTodotaskService.createTask(user5, "ShortMeeting", "Make meeting short");
            String viewBoard = boardService.viewBoard(user1, board.getId());
            System.out.println(viewBoard);
        } catch (PermissionDeniedException | BoardNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
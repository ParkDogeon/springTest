package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.Boards.Board;
import org.koreait.Boards.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardDao boardDao;


    @Test
    @DisplayName("게시글을 추가합니다...")
    public void writeTest(){
        Board board = new Board();
        board.setSub("제목!");
        board.setContent("내용!");

        boolean result = boardDao.insert(board);

        assertTrue(result);
    }

    @Test
    @DisplayName("게시글을 조회합니다...")
    public void getTest(){

        Board board = boardDao.get(3L);
        System.out.println(board);
    }

}


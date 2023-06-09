package org.koreait.Boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardWriteService {


    private BoardDao boardDao;


    @Autowired
    public void setBoardDao(BoardDao boardDao){
        this.boardDao = boardDao;
    }


    public void write(BoardRequiredCheck boardRequiredCheck){

        Board board = new Board();
        board.setSub(boardRequiredCheck.getSub());
        board.setContent(boardRequiredCheck.getContent());

        boardDao.insert(board);

    }
}


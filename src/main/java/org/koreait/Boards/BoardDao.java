package org.koreait.Boards;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


@Component
@RequiredArgsConstructor
public class BoardDao {
    private final JdbcTemplate jdbcTemplate;


    // 게시글 추가
    public boolean insert(Board board){

        String sql = "INSERT INTO BOARD (ID, SUBJECT, CONTENT) " +
                " VALUES (SEQ_BOARD.nextval, ?, ?)";
        int cnt = jdbcTemplate.update(sql, board.getSub(), board.getContent());

        return cnt > 0; // 임시
    }


    // 게시글 조회
    public Board get(Long id){

        try{

            String sql = "SELECT * FROM BOARD WHERE ID = ?";
            Board board = jdbcTemplate.queryForObject(sql, this::boardMapper, id);
            return board;

        }catch (Exception e){

            e.printStackTrace();
            return null;
        }
    }

    private Board boardMapper(ResultSet rs, int i) throws SQLException{
        Board board = new Board();
        board.setIdNm(rs.getLong("ID"));
        board.setSub(rs.getString("SUBJECT"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDt(rs.getTimestamp("REGDT").toLocalDateTime());

        Timestamp modDt = rs.getTimestamp("MODDT");
        if(modDt != null){
            board.setRegDt(modDt.toLocalDateTime());
        }
        return board;
    }
}



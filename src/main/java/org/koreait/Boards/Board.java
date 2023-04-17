package org.koreait.Boards;


import lombok.Data;


import java.time.LocalDateTime;


@Data
public class Board {
    // 번호
    private Long idNm;
    // 제목
    private String sub;
    // 내용
    private String content;
    // 등록일
    private LocalDateTime regDt;
    // 수정일
    private LocalDateTime modDt;

}

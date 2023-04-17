package org.koreait.Boards;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardRequiredCheck {

    @NotBlank(message = "제목을 입력해주세요...")
    private String sub;

    @NotBlank(message = "내용을 입력해주세요...")
    private String content;
}


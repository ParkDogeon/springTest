package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;



@SpringBootTest
@AutoConfigureMockMvc
public class WriteTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("게시글 작성 성공시 /list로 이동합니다!!")
    public void writeSuccess() throws Exception {
        mockMvc.perform(post("/board/write")
                        .param("sub","제목2")
                        .param("content","내용2"))
                .andDo(print())
                .andExpect(redirectedUrl("/board/list"));
    }


    @Test
    @DisplayName("제목, 내용 필수 체크합니다!")
    public void validation() throws Exception {
        String body = mockMvc.perform(post("/board/write"))

                .andReturn().getResponse().getContentAsString();

        assertFalse(body.contains("제목을 입력하세요."));
        assertFalse(body.contains("내용을 입력하세요."));
    }
}





package com.srivatsan177.sioverflow.app.mappers;

import com.srivatsan177.sioverflow.app.dtos.questions.CreateQuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionDTO;
import com.srivatsan177.sioverflow.app.entities.Question;

public class QuestionMapper {
    public static QuestionDTO toQuestionDTO(Question question) {
        return QuestionDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .tags(question.getTags())
                .body(question.getBody())
                .author(AppUserMapper.toAppUserDTO(question.getAuthor()))
                .build();
    }

    public static Question toQuestion(QuestionDTO questionDTO) {
        return Question.builder()
                .id(questionDTO.getId())
                .title(questionDTO.getTitle())
                .tags(questionDTO.getTags())
                .body(questionDTO.getBody())
                .author(AppUserMapper.toAppUser(questionDTO.getAuthor()))
                .build();
    }

    public static Question toQuestion(CreateQuestionDTO createQuestionDTO) {
        return Question.builder()
                .title(createQuestionDTO.getTitle())
                .tags(createQuestionDTO.getTags())
                .body(createQuestionDTO.getBody())
                .build();
    }
}

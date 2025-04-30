package com.srivatsan177.sioverflow.app.services;

import com.srivatsan177.sioverflow.app.dtos.questions.CreateQuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionParam;
import com.srivatsan177.sioverflow.app.dtos.rest.PageParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface QuestionsService {
    QuestionDTO createQuestion(CreateQuestionDTO createQuestionDTO);

    QuestionDTO getQuestion(UUID questionId);

    List<QuestionDTO> getQuestions(PageParams pageParams, QuestionParam questionParam);
}

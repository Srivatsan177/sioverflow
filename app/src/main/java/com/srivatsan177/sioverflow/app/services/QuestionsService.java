package com.srivatsan177.sioverflow.app.services;

import com.srivatsan177.sioverflow.app.dtos.questions.CreateQuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface QuestionsService {
    QuestionDTO createQuestion(CreateQuestionDTO createQuestionDTO);

    QuestionDTO getQuestion(UUID questionId);

    Iterable<QuestionDTO> getQuestions(int page, int size);
}

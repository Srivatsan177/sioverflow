package com.srivatsan177.sioverflow.app.controllers;

import com.srivatsan177.sioverflow.app.dtos.BaseResponseDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.CreateQuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionParam;
import com.srivatsan177.sioverflow.app.dtos.rest.PageParams;
import com.srivatsan177.sioverflow.app.services.QuestionsService;
import com.srivatsan177.sioverflow.app.util.ObjectMapperUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/questions")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Question Management", description = "APIs for managing questions")
public class QuestionsController {
    private final QuestionsService questionsService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponseDTO<QuestionDTO> createQuestion(@RequestBody CreateQuestionDTO createQuestionDTO) {
        QuestionDTO questionDTO = questionsService.createQuestion(createQuestionDTO);
        log.info("Question created: {} by {}", questionDTO.getId(), questionDTO.getAuthor().getUsername());
        return BaseResponseDTO.<QuestionDTO>builder().data(List.of(questionDTO)).build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponseDTO<QuestionDTO> getQuestion(@PathVariable UUID id) {
        QuestionDTO questionDTO = questionsService.getQuestion(id);
        log.info("Question fetched: {}", questionDTO.getId());
        return BaseResponseDTO.<QuestionDTO>builder().data(List.of(questionDTO)).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponseDTO<QuestionDTO> getQuestions(PageParams pageParams, QuestionParam questionParam) {
        log.debug("Question param passed {}", ObjectMapperUtil.toJsonString(questionParam));
        List<QuestionDTO> questions = questionsService.getQuestions(pageParams, questionParam);
        log.info("Questions fetched: {}", questions.size());
        return BaseResponseDTO.<QuestionDTO>builder()
                .data(questions)
                .nextUri("/v1/questions?page=" + (pageParams.getPage() + 1) + "&size=" + pageParams.getSize())
                .build();
    }
}

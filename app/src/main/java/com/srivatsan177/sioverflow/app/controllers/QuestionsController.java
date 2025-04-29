package com.srivatsan177.sioverflow.app.controllers;

import com.srivatsan177.sioverflow.app.dtos.questions.CreateQuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionDTO;
import com.srivatsan177.sioverflow.app.services.QuestionsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/questions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Question Management", description = "APIs for managing questions")
public class QuestionsController {
    private final QuestionsService questionsService;
    @PostMapping
    public QuestionDTO createQuestion(@RequestBody CreateQuestionDTO createQuestionDTO) {
        QuestionDTO questionDTO = questionsService.createQuestion(createQuestionDTO);
        log.info("Question created: {} by {}", questionDTO.getId(),questionDTO.getAuthor().getUsername());
        return questionDTO;
    }

    @GetMapping("/{id}")
    public QuestionDTO getQuestion(@PathVariable UUID id) {
        return questionsService.getQuestion(id);
    }

    @GetMapping
    public Iterable<QuestionDTO> getQuestions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return questionsService.getQuestions(page, size);
    }
}

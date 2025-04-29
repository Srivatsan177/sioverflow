package com.srivatsan177.sioverflow.app.services.impl;

import com.srivatsan177.sioverflow.app.dtos.questions.CreateQuestionDTO;
import com.srivatsan177.sioverflow.app.dtos.questions.QuestionDTO;
import com.srivatsan177.sioverflow.app.entities.AppUser;
import com.srivatsan177.sioverflow.app.entities.Question;
import com.srivatsan177.sioverflow.app.mappers.AppUserMapper;
import com.srivatsan177.sioverflow.app.mappers.QuestionMapper;
import com.srivatsan177.sioverflow.app.repositories.QuestionRepository;
import com.srivatsan177.sioverflow.app.services.AppUserService;
import com.srivatsan177.sioverflow.app.services.QuestionsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionRepository questionRepository;
    private final AppUserService appUserService;
    @Override
    @Transactional
    public QuestionDTO createQuestion(CreateQuestionDTO createQuestionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Question question = QuestionMapper.toQuestion(createQuestionDTO);
        AppUser appUser = AppUserMapper.toAppUser(appUserService.findUser(authentication.getName()));
        question.setAuthor(appUser);
        question = questionRepository.save(question);
        log.info("Question {} created by {}", question.getId(), question.getAuthor().getUsername());
        return QuestionMapper.toQuestionDTO(question);
    }

    @Override
    public QuestionDTO getQuestion(UUID questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow();
        log.info("Question {} fetched", question.getId());
        return QuestionMapper.toQuestionDTO(question);
    }

    @Override
    public Iterable<QuestionDTO> getQuestions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return questionRepository.findAll(pageable).stream()
                .map(QuestionMapper::toQuestionDTO)
                .toList();
    }
}

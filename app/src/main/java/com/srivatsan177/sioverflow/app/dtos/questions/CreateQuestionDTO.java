package com.srivatsan177.sioverflow.app.dtos.questions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuestionDTO {
    private String title;

    private String[] tags;

    private String body;
}

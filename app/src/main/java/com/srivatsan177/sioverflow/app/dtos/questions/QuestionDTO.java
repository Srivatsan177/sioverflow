package com.srivatsan177.sioverflow.app.dtos.questions;

import com.srivatsan177.sioverflow.app.dtos.AppUserDTO;
import com.srivatsan177.sioverflow.app.entities.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDTO {
    private UUID id;

    private String title;

    private String[] tags;

    private String body;

    private AppUserDTO author;
}

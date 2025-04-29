package com.srivatsan177.sioverflow.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String title;

    private String[] tags;

    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private AppUser author;
}

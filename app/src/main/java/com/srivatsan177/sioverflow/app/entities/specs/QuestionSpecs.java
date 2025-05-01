package com.srivatsan177.sioverflow.app.entities.specs;

import com.srivatsan177.sioverflow.app.dtos.questions.QuestionParam;
import com.srivatsan177.sioverflow.app.entities.Question;
import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

public class QuestionSpecs {
    public static Specification<Question> buildQuestionSpec(QuestionParam questionParam) {
        Specification<Question> spec = Specification.where(null);

        if (questionParam.getSearch() != null) {
            spec = spec.and(searchSpec(questionParam.getSearch()));
        }

        if(questionParam.getTags() != null) {
            spec = spec.and(tagsSpec(questionParam.getTags()));
        }

        return spec;
    }

    public static Specification<Question> searchSpec(String search) {
        return (root, query, criteriaBuilder) -> {
            Expression<Object> tsQuery = criteriaBuilder.function(
                    "plainto_tsquery",
                    Object.class,
                    criteriaBuilder.literal("english"),
                    criteriaBuilder.literal(search)
            );

            return criteriaBuilder.isTrue(
                    criteriaBuilder.function(
                            "ts_match_vq",
                            Boolean.class,
                            root.get("searchVector"),
                            tsQuery
                    )
            );
        };
    }

    public static Specification<Question> tagsSpec(String[] tags) {
        return (root, query, criteriaBuilder) -> {
            Expression<String[]> tagsLiteral = criteriaBuilder.literal(tags);
            Expression<String[]> tagsColumn = root.get("tags");

            return criteriaBuilder.isTrue(
                    criteriaBuilder.function(
                            ("array_some_overlap"),
                            Boolean.class,
                            tagsColumn,
                            tagsLiteral
                    )
            );
        };
    }
}

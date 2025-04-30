package com.srivatsan177.sioverflow.app.entities.specs;

import com.srivatsan177.sioverflow.app.dtos.questions.QuestionParam;
import com.srivatsan177.sioverflow.app.entities.Question;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class QuestionSpecs {
    public static Specification<Question> buildQuestionSpec(QuestionParam questionParam) {
        Specification<Question> spec = Specification.where(null);

        if (questionParam.getSearch() != null) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                Expression<Object> tsQuery = criteriaBuilder.function(
                        "plainto_tsquery",
                        Object.class,
                        criteriaBuilder.literal("english"),
                        criteriaBuilder.literal(questionParam.getSearch())
                );

                return criteriaBuilder.isTrue(
                        criteriaBuilder.function(
                                "ts_match_vq",
                                Boolean.class,
                                root.get("searchVector"),
                                tsQuery
                        )
                );
            });
        }
        return spec;
    }
}

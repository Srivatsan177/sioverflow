package com.srivatsan177.sioverflow.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.srivatsan177.sioverflow.app.common.RestConstants.RESPONSE_MESSAGE_SUCCESS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponseDTO<T> {
    @Builder.Default
    String message = RESPONSE_MESSAGE_SUCCESS;
    List<T> data;

    @Builder.Default
    String nextUri = null;
}

package com.srivatsan177.sioverflow.app.dtos.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParams {
    private int page = 0;
    private int size = 5;
}

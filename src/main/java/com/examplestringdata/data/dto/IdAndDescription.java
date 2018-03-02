package com.examplestringdata.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IdAndDescription {
    private Long id;
    private String description;

    public IdAndDescription(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}

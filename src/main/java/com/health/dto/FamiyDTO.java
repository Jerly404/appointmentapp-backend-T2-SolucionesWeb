package com.health.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamiyDTO {

    private Integer idFamily;

    @NotNull
    private String name;

    @NotNull
    private String description;
}

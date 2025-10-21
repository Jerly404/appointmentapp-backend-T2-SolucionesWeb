package com.health.dto;

import com.health.model.Category;
import com.health.model.Family;
import com.health.model.Laboratory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer idProduct;

    @NotNull
    private String nameProduct;

    @NotNull
    private String descriptionProduct;

    private String presentationProduct;

    @NotNull
    private Double unitPriceProduct;

    @NotNull
    private Integer stockProduct;

    private LocalDate expiredProduct;

    @NotNull
    private Category category;

    @NotNull
    private Family family;

    @NotNull
    private Laboratory laboratory;
}

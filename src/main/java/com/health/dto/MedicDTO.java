package com.health.dto;

import com.health.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicDTO {
    private int idMedic;
    private Specialty specialty;
    private String firstName;
    private String lastName;
    private String cmp;
    private String photoUrl;
}

package com.teachmeskills.visaction.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    private long id;
    @Size(min = 3, max = 8, message = "The number of characters should be in the range from 3 to 8")
    @NotEmpty(message = "The field must be filled in")
    private String username;
    @Size(min = 3, max = 8, message = "The number of characters should be in the range from 3 to 8")
    @NotEmpty(message = "The field must be filled in")
    private String password;
}

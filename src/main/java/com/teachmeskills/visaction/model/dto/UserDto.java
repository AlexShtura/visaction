package com.teachmeskills.visaction.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @Length(min = 2, message = "The first name must consist of more than 1 character")
    @Length(max = 21, message = "The first name must consist of no more than 20 characters")
    private String firstName;
    @Length(min = 2, message = "The last name must consist of more than 1 character")
    @Length(max = 21, message = "The last name must consist of no more than 20 characters")
    private String lastName;
    @Min(value = 2, message = "The age must be more than 1 year")
    @Max(value=99, message = "The age must be less than 100 years")
    private int age;
    @Length(min = 7, message = "The mobile number must consist of more than 7 character")
    @Length(max = 9, message = "The mobile number must consist of no more than 9 characters")
    private String mobileNumber;
}

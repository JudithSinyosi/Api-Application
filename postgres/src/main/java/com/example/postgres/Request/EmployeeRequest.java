package com.example.postgres.Request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class EmployeeRequest {
@NotNull(message = "firstname shouldn't be null")
    private String firstName;
    @NotNull(message = "lastname shouldn't be null")
    private String lastName;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile entered")
    private String mobile;
    @NotBlank
    private String gender;
    @Email(message = "invalid email")
    private String email;
}

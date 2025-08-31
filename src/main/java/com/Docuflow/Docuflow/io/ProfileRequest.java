package com.Docuflow.Docuflow.io;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {
   @NotBlank(message = "Name is mandatory")

   private String name;
   @Email(message = "Email should be valid")
   @NotNull(message = "EMail should not be empty")
   private String email;
   @Size(min = 6, message = "Password must be at least 6 characters long")
   private String password;

}

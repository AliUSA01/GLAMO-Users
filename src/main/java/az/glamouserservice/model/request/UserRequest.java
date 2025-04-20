package az.glamouserservice.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

import static az.glamouserservice.model.constants.ApplicationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = FULL_NAME_IS_REQUIRED)
    private String fullName;

    @NotBlank(message = EMAIL_IS_REQUIRED)
    private String email;

    @NotBlank(message = PHONE_NUMBER_IS_REQUIRED)
    private String phone;

    @NotBlank(message = ROLE_IS_REQUIRED)
    private String role;


}

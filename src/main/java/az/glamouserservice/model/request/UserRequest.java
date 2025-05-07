package az.glamouserservice.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import static az.glamouserservice.model.constants.ApplicationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = FULL_NAME_IS_REQUIRED)
    private String fullName;

    @NotBlank(message = EMAIL_IS_REQUIRED)
    @Email(message =EMAIL_VALIDATION)
    private String email;

    @NotBlank(message = PASSWORD_IS_REQUIRED)
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,16}$",
            message = "Password must contain at least one uppercase letter, " +
                    "one lowercase letter, and one number")
    private String password;

    @NotBlank(message = PHONE_NUMBER_IS_REQUIRED)
    private String phone;



}

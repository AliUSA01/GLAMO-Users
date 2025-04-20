package az.glamouserservice.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessage {
    USER_NOT_FOUND("User not found with id: %s");

    private final String message;
}

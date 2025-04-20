package az.glamouserservice.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}

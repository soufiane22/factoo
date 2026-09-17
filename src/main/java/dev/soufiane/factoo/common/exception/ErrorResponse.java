package dev.soufiane.factoo.common.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp,
        List<String> details
) {
    public ErrorResponse(int status, String message) {
        this(status, message, LocalDateTime.now(), List.of());
    }

    public ErrorResponse(int status, String message, List<String> details) {
        this(status, message, LocalDateTime.now(), details);
    }
}

package bridge.validation.support;

import bridge.dto.InputValidationDto.Request;

public abstract class ValidationSupport {

    public boolean isExceptedLetter(final Request request, final String... expectedLetters) {
        for (String expectedLetter : expectedLetters) {
            if (request.getTarget().equals(expectedLetter)) {
                return true;
            }
        }
        return false;
    }
}

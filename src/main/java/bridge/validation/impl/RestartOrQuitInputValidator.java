package bridge.validation.impl;

import bridge.config.BridgeInformation;
import bridge.dto.InputValidationDto.Request;
import bridge.dto.InputValidationDto.Response;
import bridge.exception.ErrorCode;
import bridge.type.InputType;
import bridge.validation.InputValidationChain;

public class RestartOrQuitInputValidator implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNextChain(InputValidationChain nextChain) {
        next = nextChain;
    }

    @Override
    public Response validate(Request request) {
        if (!request.getType().equals(InputType.RESTART_OR_QUIT)) {
            return next.validate(request);
        }
        if (bothIncorrectLetter(request)) {
            return new Response(false, ErrorCode.INVALID_INPUT.getMessage());
        }
        return new Response(true);
    }

    private boolean bothIncorrectLetter(Request request) {
        return !request.getTarget().equals(BridgeInformation.RESTART) &&
            !request.getTarget().equals(BridgeInformation.QUIT);
    }
}

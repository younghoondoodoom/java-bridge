package bridge.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.exception.ErrorCode;
import org.junit.jupiter.api.Test;

class BridgeSpaceStatusTest {

    @Test
    public void findByNumberInvalidSignatureNumberFailure() {
        //given
        int number = Integer.MIN_VALUE;

        //when
        //then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> BridgeSpaceStatus.findByNumber(number)
        );
        assertThat(exception.getMessage()).isEqualTo(
            ErrorCode.INVALID_SIGNATURE_NUMBER.getMessage());
    }

    @Test
    public void findByNumberSuccess() {
        //given
        int upNumber = BridgeSpaceStatus.UP.getNumber();
        int downNumber = BridgeSpaceStatus.DOWN.getNumber();

        //when
        BridgeSpaceStatus up = BridgeSpaceStatus.findByNumber(upNumber);
        BridgeSpaceStatus down = BridgeSpaceStatus.findByNumber(downNumber);

        //then
        assertThat(up).isEqualTo(BridgeSpaceStatus.UP);
        assertThat(down).isEqualTo(BridgeSpaceStatus.DOWN);
    }
}
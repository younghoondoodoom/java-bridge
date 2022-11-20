package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.Bridge;
import bridge.dto.BridgeMove.Request;
import bridge.dto.BridgeMove.Response;
import bridge.exception.ErrorCode;
import bridge.type.BridgeSpaceStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private final BridgeGameInf bridgeGame = new BridgeGame();


    private Bridge bridge;

    @BeforeEach
    public void setUp() {
        final List<String> sequence = List.of("D", "D", "D", "D", "D", "D", "U", "U", "U", "U");
        bridge = new Bridge(sequence);
    }

    @Test
    public void moveIndexErrorFailure() {
        //given
        int index1 = -1;
        int index2 = 10;

        Request request1 = new Request(index1, 0, BridgeSpaceStatus.DOWN);
        Request request2 = new Request(index2, 0, BridgeSpaceStatus.DOWN);

        //when
        //then
        IllegalArgumentException exception1 = assertThrows(
            IllegalArgumentException.class,
            () -> bridgeGame.move(request1, bridge)
        );
        IllegalArgumentException exception2 = assertThrows(
            IllegalArgumentException.class,
            () -> bridgeGame.move(request2, bridge)
        );

        assertThat(exception1.getMessage()).isEqualTo(ErrorCode.INDEX_OUT_OF_BOUND.getMessage());
        assertThat(exception2.getMessage()).isEqualTo(ErrorCode.INDEX_OUT_OF_BOUND.getMessage());
    }

    @Test
    public void moveSuccess() {
        //given
        int index1 = 0;
        int index2 = 9;

        Request request1 = new Request(index1, 0, BridgeSpaceStatus.UP);
        Request request2 = new Request(index2, 0, BridgeSpaceStatus.UP);

        //when
        Response response1 = bridgeGame.move(request1, bridge);
        Response response2 = bridgeGame.move(request2, bridge);

        //then
        assertThat(response1.isSuccess()).isFalse();
        assertThat(response1.isPossible()).isFalse();
        assertThat(response2.isSuccess()).isTrue();
        assertThat(response2.isPossible()).isTrue();
    }

    @Test
    public void retrySuccess() {
        //given
        int attemptCount = 1;
        Request request = new Request(0, attemptCount, BridgeSpaceStatus.UP);

        //when
        Response response = bridgeGame.retry(request);

        //then
        assertThat(response.getAttemptCount()).isEqualTo(attemptCount + 1);
    }
}
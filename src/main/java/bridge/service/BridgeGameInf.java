package bridge.service;

import bridge.domain.Bridge;
import bridge.dto.BridgeMove;

public interface BridgeGameInf {

    BridgeMove.Response move(BridgeMove.Request request, Bridge bridge);

    void retry();
}
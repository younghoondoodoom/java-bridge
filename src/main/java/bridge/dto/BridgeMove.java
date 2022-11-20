package bridge.dto;

import bridge.type.BridgeSpaceStatus;

public class BridgeMove {

    public static class Request {

        private final int index;
        private final int attemptCount;
        private final BridgeSpaceStatus spaceStatus;

        public Request(int index, int attemptCount, BridgeSpaceStatus spaceStatus) {
            this.index = index;
            this.attemptCount = attemptCount;
            this.spaceStatus = spaceStatus;
        }

        public int getIndex() {
            return index;
        }

        public int getAttemptCount() {
            return attemptCount;
        }

        public BridgeSpaceStatus getSpaceStatus() {
            return spaceStatus;
        }
    }

    public static class Response {
        private final boolean isSuccess;
        private final boolean isPossible;
        private final int attemptCount;

        public Response(boolean isSuccess, boolean isPossible, int attemptCount) {
            this.isSuccess = isSuccess;
            this.isPossible = isPossible;
            this.attemptCount = attemptCount;
        }

        public boolean isSuccess() {
            return isSuccess;
        }

        public boolean isPossible() {
            return isPossible;
        }

        public int getAttemptCount() {
            return attemptCount;
        }
    }
}

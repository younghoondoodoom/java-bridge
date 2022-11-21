package bridge.dto;

import java.util.List;

public class PrintResultDto {
    private List<String> sequence;
    private boolean isSuccess;
    private int attemptCount;
    private int index;

    public PrintResultDto(List<String> sequence, boolean isSuccess, int attemptCount, int index) {
        this.sequence = sequence;
        this.isSuccess = isSuccess;
        this.attemptCount = attemptCount;
        this.index = index;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getIndex() {
        return index;
    }
}

package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private final List<Integer> rolls = new ArrayList<>();

    public boolean isFull() {
        return rolls.size() == 2;
    }

    public void addRoll(int pinsKnockedDown) {
        rolls.add(pinsKnockedDown);
    }

    public int totalPinsKnockedDown() {
        int total = 0;
        for (int aThrow : rolls) {
            total += aThrow;
        }
        return total;
    }

    public boolean isSpare() {
        return totalPinsKnockedDown() == 10;
    }

    public int firstRoll() {
        return rolls.get(0);
    }
}

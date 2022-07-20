package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private final List<Integer> rolls = new ArrayList<>();

    public boolean isFull() {
        return rolls.size() == 2 || isStrike();
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

    public boolean isStrike() {
        return totalPinsKnockedDown() == 10 && rolls.size() == 1;
    }

    public boolean isSpare() {
        return totalPinsKnockedDown() == 10 && rolls.size() == 2;
    }

    public int firstRoll() {
        return rolls.get(0);
    }

    public int secondRoll() {
        if (rolls.size() == 1) {
            throw new RuntimeException();
        }
        return rolls.get(1);
    }
}

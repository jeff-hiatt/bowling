package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private final List<Frame> frames;

    public BowlingGame() {
        frames = new ArrayList<>();
        generateNewFrame();
    }

    public void addRoll(int pinsKnockedDown) {
        if(currentFrame().isFull()) {
            generateNewFrame();
        }

        currentFrame().addRoll(pinsKnockedDown);
    }

    public int getTotalScore() {
        int score = 0;

        for (int i = 0; i < frames.size(); i++) {
            Frame currentFrame = frames.get(i);
            score += currentFrame.totalPinsKnockedDown();

            if(currentFrame.isSpare()) {
                score += frames.get(i + 1).firstRoll();
            }
         }
        return score;
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }

    private void generateNewFrame() {
        frames.add(new Frame());
    }
}

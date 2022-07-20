package bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BowlingGameTest {

    /****** Bowling game requirements
     *  Playing the game:
     *     The game consists of 10 frames.  For any given frame, the player has up to two rolls to knock down 10 pins.
     *     After the player successfully knocks down all 10 pins or used their 2 attempts the frame is considered complete
     *     and the game proceeds to the next frame.
     *
     *  Frame type definitions:
     *     * Open frame:  Less than 10 pins were knocked down
     *     * Spare: All 10 pins were knocked down, but it required two rolls to accomplish
     *     * Strike: All 10 pins were knocked down on the first throw.
     *
     * Scoring the game:
     *     The game is scored by totalling up the scores of the individual frames.
     *     Frame scores are determined by the type of the frame.
     *
     *     Open frame: The total of the pins knocked down in the frame
     *     Spare: The total of the pins knocked down in the frame plus 1 bonus(1)
     *     Strike: The total of the pins knocked down in the frame plus 2 bonuses(1)
     *
     *     (1) Bonuses are scored by adding the number of pins from the next 1 or 2 subsequent rolls.
     *
     */

    @Test
    void allGutterBalls() {
        BowlingGame game = new BowlingGame();

        for (int i = 0; i < 10; i++) {
            game.addRoll(0);
            game.addRoll(0);
        }

        assertEquals(0, game.getTotalScore());
    }

    @Test
    void openFrames() {
        BowlingGame game = new BowlingGame();

        //frame 1
        game.addRoll(2);
        game.addRoll(3);

        //frame 2
        game.addRoll(4);
        game.addRoll(5);

        //remaining frames
        for (int i = 0; i < 8; i++) {
            game.addRoll(0);
            game.addRoll(0);
        }

        assertEquals(5 + 9, game.getTotalScore());
    }
}

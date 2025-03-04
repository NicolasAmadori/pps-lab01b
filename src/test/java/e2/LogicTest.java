package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  public static final int SIZE = 5;
  public static final int KNIGHT_NUMBER = 1;
  public static final int PAWN_NUMBER = 1;
  Logics logic;

  @BeforeEach
  public void beforeEach() {
    logic = new LogicsImpl(SIZE);
  }

  @Test
  public void testKnightInitialPosition() {
    int knightCounter = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        knightCounter += this.logic.hasKnight(i, j) ? 1 : 0;
      }
    }
    assertEquals(KNIGHT_NUMBER, knightCounter);
  }

  @Test
  public void testPawnInitialPosition() {
    int pawnCounter = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        pawnCounter += this.logic.hasPawn(i, j) ? 1 : 0;
      }
    }
    assertEquals(PAWN_NUMBER, pawnCounter);
  }

  @Test
  public void testPawnAndKnightInitialPosition() {
    for(int c = 0; c < 10_000; c++ ){
      this.logic = new LogicsImpl(SIZE);
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          assert !this.logic.hasPawn(i, j) || !this.logic.hasKnight(i, j);
        }
      }
    }
  }
}

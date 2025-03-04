package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTest {

  @Test
  public void testKnightInitialPosition() {
    Logics logic = new LogicsImpl(5);
    int knightCounter = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if(logic.hasKnight(i, j)) {
          knightCounter++;
        }
      }
    }
    assertEquals(1, knightCounter);
  }

  @Test
  public void testPawnInitialPosition() {
    Logics logic = new LogicsImpl(5);
    int pawnCounter = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if(logic.hasPawn(i, j)) {
          pawnCounter++;
        }
      }
    }
    assertEquals(1, pawnCounter);
  }
}

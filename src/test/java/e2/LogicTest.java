package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  public static final int SIZE = 5;
  public static final int KNIGHT_NUMBER = 1;
  public static final int PAWN_NUMBER = 1;
  public static final int RANDOM_TEST_NUMBER = 10_000;
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
    for(int c = 0; c < RANDOM_TEST_NUMBER; c++ ){
      this.logic = new LogicsImpl(SIZE);
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          assert !this.logic.hasPawn(i, j) || !this.logic.hasKnight(i, j);
        }
      }
    }
  }

  @Test
  public void testInvalidHitPositions() {
    assertAll(
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, 0)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(0, -1)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, -1)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE, -1)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(0, SIZE)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE, SIZE))
    );
  }

  @Test
  public void testInvalidMove() {
    Pair<Integer,Integer> knightPos = null;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if(this.logic.hasKnight(i, j)) {
          knightPos = new Pair<>(i, j);
        }
      }
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        int x = i - knightPos.getX();
        int y = j - knightPos.getY();
        if (x==0 || y==0 || Math.abs(x)+Math.abs(y)!=3) {
          assertFalse(this.logic.hit(i, j));
          Pair<Integer,Integer> newknightPos = null;

          for (int i2 = 0; i2 < 5; i2++) {
            for (int j2 = 0; j2 < 5; j2++) {
              if(this.logic.hasKnight(i2, j2)) {
                newknightPos = new Pair<>(i2, j2);
              }
            }
          }
          assertEquals(knightPos, newknightPos);
        }
      }
    }
  }

}

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
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE, 0)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(0, SIZE)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE, SIZE))
    );
  }

  @Test
  public void testInvalidMoves() {
    Pair<Integer,Integer> knightPos = findKnightPosition();

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (!isPositionValid(knightPos.getX(), knightPos.getY(), i, j)) {
          assertFalse(this.logic.hit(i, j));
          assertEquals(knightPos, findKnightPosition());
        }
      }
    }
  }

  @Test
  public void testValidMoves() {
    Pair<Integer,Integer> knightPos = findKnightPosition();

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (isPositionValid(knightPos.getX(), knightPos.getY(), i, j)) {
          this.logic.hit(i, j);
          assertEquals(new Pair<>(i, j), findKnightPosition());
          this.logic.hit(knightPos.getX(), knightPos.getY());
        }
      }
    }
  }

  @Test
  public void TestFixedPositionConstructor() {
    Pair<Integer,Integer> validPawnPosition = new Pair<>(0,0);
    Pair<Integer,Integer> validKnightPosition = new Pair<>(1, 1);
    this.logic = new LogicsImpl(SIZE, validPawnPosition, validKnightPosition);
    Integer x = null;
    Integer y = null;
    for (int i = 0; i < 5 && x == null; i++) {
      for (int j = 0; j < 5 && x == null; j++) {
        if(this.logic.hasPawn(i, j)) {
          x = i;
          y = j;
        }
      }
    }
    Pair<Integer,Integer> foundPawnPosition = new Pair<>(x, y);

    assertAll(
            () -> assertEquals(validPawnPosition, foundPawnPosition),
            () -> assertEquals(validKnightPosition, findKnightPosition())
    );
  }

  private Pair<Integer,Integer> findKnightPosition() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if(this.logic.hasKnight(i, j)) {
          return new Pair<>(i, j);
        }
      }
    }
    return null;
  }

  private boolean isPositionValid(int startingX, int startingY, int newX, int newY) {
    int x = newX - startingX;
    int y = newY - startingY;
    return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
  }
}

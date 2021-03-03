import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int EMPTY = 0;
    private static final int ONE_ELEMENT = 1;
    private static final int ANOTHER_ELEMENT = 2;
    private static final int START_ITERATIONS = 1;
    private static final int ITERATIONS = 100;
    private static final int ODD_ELEMENT = 9;
    private static final int EVEN_ELEMENT = 4;
    private static final int ANSWER_TO_LIFE_UNIVERSE_AND_EVERYTHING = 42;
    private static final int SQUARE_OF_42 = 1764;

    CircularList circularList;
    SelectStrategyFactory factory;

    @BeforeEach
    void setCircularList() {
        this.circularList = new CircularListImpl();
    }

    @BeforeEach
    void setFactory() { factory = new SelectStrategyFactory(); }

    @Test
    void testAdd() {
        assertEquals(EMPTY, circularList.size());
        circularList.add(ONE_ELEMENT);
        assertEquals(ONE_ELEMENT, circularList.size());
    }
    
    @Test
    void testSize() {
        for(int i=START_ITERATIONS; i <=ITERATIONS; i++) {
            circularList.add(ONE_ELEMENT);
        }
        assertEquals(ITERATIONS, circularList.size());
    }

    @Test
    void testIsEmpty() {
        assertEquals(EMPTY, circularList.size());
        circularList.add(ONE_ELEMENT);
        assertNotEquals(EMPTY, circularList.size());
    }

    @Test
    void testNext() {
        assertEquals(Optional.empty(), this.circularList.next());
        this.circularList.add(ONE_ELEMENT);
        this.circularList.add(ANOTHER_ELEMENT);
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.next());
        assertEquals(Optional.of(ANOTHER_ELEMENT), this.circularList.next());
    }

    @Test
    void testNextCircularity() {
        testNext();
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.next());
    }

    @Test
    void testPrevious() {
        assertEquals(Optional.empty(), this.circularList.previous());
        testNext();
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.previous());
    }

    @Test
    void testPreviousCircularity() {
        testPrevious();
        assertEquals(Optional.of(ANOTHER_ELEMENT), this.circularList.previous());
    }

    @Test
    void testReset() {
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            this.circularList.add(i);
            this.circularList.next();
        }
        this.circularList.reset();
        assertEquals(Optional.of(START_ITERATIONS), this.circularList.next());
        this.circularList.reset();
        assertEquals(Optional.of(ITERATIONS), this.circularList.previous());
    }

    @Test
    void testEvenStrategy() {
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            circularList.add(ODD_ELEMENT);
        }
        circularList.add(EVEN_ELEMENT);
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            circularList.add(ODD_ELEMENT);
        }

        SelectStrategy strategy = factory.getSelectStrategy(StrategyType.EVEN, Optional.empty());
        assertEquals(Optional.of(EVEN_ELEMENT), circularList.next(strategy));
    }

    @Test
    void testEqualsStrategy() {
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            circularList.add(ONE_ELEMENT);
        }
        circularList.add(ANSWER_TO_LIFE_UNIVERSE_AND_EVERYTHING);
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            circularList.add(ODD_ELEMENT);
        }
        SelectStrategy strategy = factory.getSelectStrategy(StrategyType.EQUALS, Optional.of(ANSWER_TO_LIFE_UNIVERSE_AND_EVERYTHING));
        assertEquals(Optional.of(ANSWER_TO_LIFE_UNIVERSE_AND_EVERYTHING), circularList.next(strategy));
    }

    @Test
    void testSquareStrategy() {
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            circularList.add(ONE_ELEMENT);
        }
        circularList.add(SQUARE_OF_42);
        for(int i = START_ITERATIONS; i <= ITERATIONS; i++) {
            circularList.add(ODD_ELEMENT);
        }
        SelectStrategy strategy = factory.getSelectStrategy(StrategyType.SQUARE, Optional.of(ANSWER_TO_LIFE_UNIVERSE_AND_EVERYTHING));
        assertEquals(Optional.of(SQUARE_OF_42), circularList.next(strategy));
    }
}

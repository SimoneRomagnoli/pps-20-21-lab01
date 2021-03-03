import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    CircularList circularList;

    @BeforeEach
    void setCircularList() {
        this.circularList = new CircularListImpl();
    }

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
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.next());
        this.circularList.add(ANOTHER_ELEMENT);
        assertEquals(Optional.of(ANOTHER_ELEMENT), this.circularList.next());
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.next());
    }

    @Test
    void testPrevious() {
        assertEquals(Optional.empty(), this.circularList.previous());
        this.circularList.add(ONE_ELEMENT);
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.previous());
        this.circularList.add(ANOTHER_ELEMENT);
        assertEquals(Optional.of(ANOTHER_ELEMENT), this.circularList.previous());
        assertEquals(Optional.of(ONE_ELEMENT), this.circularList.previous());
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
}

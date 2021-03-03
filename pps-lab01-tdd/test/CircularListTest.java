import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int EMPTY = 0;
    private static final int ONE_ELEMENT = 1;
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
    void isEmpty() {
        assertEquals(EMPTY, circularList.size());
        circularList.add(ONE_ELEMENT);
        assertNotEquals(EMPTY, circularList.size());
    }
    
}

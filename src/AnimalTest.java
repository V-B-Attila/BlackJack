import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void speak() {
    }

    @Test
    void main() {
    }

    @Test
    void testReturnFive() {
        int expected = 5;
        int result = Animal.returnFive();
        assertEquals(expected, result);
    }
}
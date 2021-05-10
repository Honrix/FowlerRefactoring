import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    private Result result;
    private String testLine = "TestLine";
    private String testInput = "TestInput";

    @BeforeEach
    void setUp() {
        result = new Result("test");
    }

    @Test
    void addLine() {
        result.addLine(testLine);
        assertEquals("test" + "\n" + "TestLine", result.getResult());
    }

    @Test
    void add() {
        result.add(testInput);
        assertEquals("test" + "TestInput", result.getResult());
    }

    @Test
    void getResult() {
        assertEquals("test", result.getResult());
    }
}
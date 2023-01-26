import org.example.ChineseNumberStringifier;
import org.example.RomanNumberStringifier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumberStringifierTest {
    final int convertedInt = 1024;
    final RomanNumberStringifier target = new RomanNumberStringifier();
    final String expected = "MXXIV";


    @Nested
    class stringify {

        @Test
        void returnsStringifyNumber() {
            var result = target.stringify(convertedInt);

            assertEquals(expected, result);
        }
    }
}
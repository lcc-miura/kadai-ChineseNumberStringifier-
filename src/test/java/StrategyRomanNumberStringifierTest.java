import org.example.NumberStringifierOperator;
import org.example.StrategyRomanNumberStringifier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyRomanNumberStringifierTest {
    final int convertedInt = 1024;
    final NumberStringifierOperator target = new NumberStringifierOperator(new StrategyRomanNumberStringifier());
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
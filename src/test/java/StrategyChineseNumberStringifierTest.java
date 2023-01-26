import org.example.NumberStringifierOperator;
import org.example.StrategyChineseNumberStringifier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyChineseNumberStringifierTest {
    final int convertedInt = 45013;
    final NumberStringifierOperator target = new NumberStringifierOperator(new StrategyChineseNumberStringifier());
    final String expected = "肆萬伍阡壱拾参";


    @Nested
    class stringify {

        @Test
        void returnsStringifyNumber() {
            var result = target.stringify(convertedInt);

            assertEquals(expected, result);
        }
    }
}
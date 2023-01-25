import org.example.ChineseNumberStringifier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChineseNumberStringifierTest {
    final int convertedInt = 45013;
    final ChineseNumberStringifier target = new ChineseNumberStringifier(convertedInt);
    final String expected = "肆萬伍阡壱拾参";


    @Nested
    class stringify {

        @Test
        void returnsStringifyNumber() {
            var result = target.getString();

            assertEquals(expected, result);
        }
    }
}
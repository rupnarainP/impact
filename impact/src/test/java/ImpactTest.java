import numberrangesummarizer.Impact;
import numberrangesummarizer.NumberRangeSummarizerExpection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The ImpactTest class contains all the unit tests
 *
 * @author Priyal Rupnarain
 */

class ImpactTest {
    Impact impact;

    @BeforeEach
    void init() {
        impact = new Impact();
    }

    @Test
    void givenValidInput_whenProducingAListOfNumbers_thenReturnSuccessfulResult() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> result = impact.collect(input);

        Object[] expected = {1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31};

        Assertions.assertArrayEquals(expected, result.toArray());
    }

    @Test
    void givenInvalidInput_whenProducingAListOfNumbers_thenThrowAnException() {
        String input = "1,3,6,7,8,12,13,14,15,21,test,23,24,31";

        Exception exception = Assertions.assertThrows(NumberRangeSummarizerExpection.class, () -> {
            impact.collect(input);
        });

        String expectedMessage = "Input is not a number";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void givenNullInput_whenProducingAListOfNumbers_thenThrowAnException() {
        String input = null;

        Exception exception = Assertions.assertThrows(NumberRangeSummarizerExpection.class, () -> {
            impact.collect(input);
        });

        String expectedMessage = "Input is empty";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void givenValidCollection_whenSummarizingListOfNumbers_thenReturnSuccessfulResult() {
        Integer[] a = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        List<Integer> list = Arrays.asList(a);
        Collection<Integer> input = new ArrayList<>(list);

        String result = impact.summarizeCollection(input);

        Assertions.assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    void givenNullInputCollection_whenSummarizingListOfNumbers_thenThrowAnException() {
        Collection<Integer> input = null;

        Exception exception = Assertions.assertThrows(NumberRangeSummarizerExpection.class, () -> {
            impact.summarizeCollection(input);
        });

        String expectedMessage = "Input is empty";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
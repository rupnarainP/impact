package numberrangesummarizer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * The Impact class is the main class
 *
 * @author Priyal Rupnarain
 */

@Slf4j
public class Impact implements NumberRangeSummarizer {

    public static void main(String[] args) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Impact impact = new Impact();
        Collection<Integer> result = impact.collect(input);
        log.info("Result: {}", impact.summarizeCollection(result));
    }

    private static StringBuilder appendRange(StringBuilder sb, int startEntry, int previousEntry) {
        sb.append(startEntry);

        if (startEntry != previousEntry) {
            sb.append(previousEntry - startEntry > 1 ? "-" : ", ").append(previousEntry);
        }

        return sb;
    }

    @Override
    public Collection<Integer> collect(String input) {
        log.info("Validating input");

        if (input != null) {
            ArrayList<Integer> list = new ArrayList<>();

            String[] inputAsArray = input.split(",");

            for (String number : inputAsArray) {
                try {
                    int num = Integer.parseInt(number);
                    list.add(num);

                } catch (NumberFormatException nfe) {
                    log.error("Input is not a number");
                    throw new NumberRangeSummarizerExpection("Input is not a number");
                }
            }

            Collections.sort(list);
            log.info("List of numbers that is collected: {}", list);

            return list;
        } else {
            log.error("Input validation failed");
            throw new NumberRangeSummarizerExpection("Input is empty");
        }
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        if (input != null && !input.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>(input);

            log.info("Calculating ranges");
            StringBuilder sb = new StringBuilder();
            int previousEntry = list.get(0);
            int startEntry = previousEntry;

            for (int nextEntry : list.subList(1, list.size())) {
                if (previousEntry + 1 != nextEntry) {
                    appendRange(sb, startEntry, previousEntry).append(", ");
                    startEntry = nextEntry;
                }
                previousEntry = nextEntry;
            }

            String result = appendRange(sb, startEntry, previousEntry).toString();
            log.info("Summarized Collection: {}", result);

            return result;
        } else {
            throw new NumberRangeSummarizerExpection("Input is empty");
        }

    }
}
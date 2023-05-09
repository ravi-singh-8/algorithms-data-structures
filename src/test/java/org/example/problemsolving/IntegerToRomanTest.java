package org.example.problemsolving;

import org.example.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntegerToRomanTest {

    @TestFactory
    @DisplayName("Integer To Roman Literal Conversion Tests")
    List<DynamicTest> dynamicTests() throws IOException {

        List<String> inputLines = TestHelper.getFileData("ProblemSolving/IntegerToRoman/input.txt");
        List<String> outLines = TestHelper.getFileData("ProblemSolving/IntegerToRoman/output.txt");
        List<DynamicTest> tests = new ArrayList<>();

        for (int i = 0; i < inputLines.size(); i++) {
            final String input = inputLines.get(i);
            final String output = outLines.get(i);

            tests.add(DynamicTest.dynamicTest(
                    "Test Integer To Roman for Input:" + input+ " Expected Output: " + output,
                    () -> execute(input, output)));
        }
        return tests;
    }

    private void execute(String input, String output) {
        int number = Integer.parseInt(input.strip());
        String result = IntegerToRoman.integerToRoman(number);
        Assertions.assertEquals(output, result);
    }
}

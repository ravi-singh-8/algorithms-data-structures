package org.example.problemsolving;

import org.example.TestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RomanToIntegerTest {

    @TestFactory
    @DisplayName("Roman Literal to Integer Conversion Tests")
    public List<DynamicTest> testRomanToInteger() throws IOException {
        List<String> inputs = TestHelper.getFileData("ProblemSolving/RomanToInteger/input.txt");
        List<String> outputs = TestHelper.getFileData("ProblemSolving/RomanToInteger/output.txt");
        List<DynamicTest> tests = new ArrayList<>();
        for(int i=0; i<inputs.size(); i++) {

            final String input = inputs.get(i).trim();
            final int output = Integer.valueOf(outputs.get(i));
            tests.add(DynamicTest.dynamicTest(
                    "Test Roman to Integer for Input:"+ input +" Expected: "+ output,
                    ()-> {
                        int val = RomanToInteger.romanToInteger(input);
                        Assertions.assertEquals(output, val);
                    }));
        }

        return tests;
    }
}

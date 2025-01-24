package com.appsdeveloperblog;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @DisplayName("Division by zero")
    @RepeatedTest(value=3, name="{displayName}. Repetition {currentRepetition} of {totalRepetition}")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowAritmeticException(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("Division by zero");
        System.out.println(MessageFormat.format("Running {0}", testInfo.getTestMethod().get().getName()));
        System.out.println(MessageFormat.format("Repetition #{0} of {1}", repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions()));
        // Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act && assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            // Act
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception.");


        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");

        //fail("Not implemented yet");
    }

}

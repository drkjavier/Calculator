package com.appsdeveloperblog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.text.MessageFormat;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method.");
    }

    // test <System Under Test>_<Condition or state change>_<Expected result>
    @DisplayName("Test 4/2 =2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Executing Test 4/2 =2");
        // Arrange
        Calculator calculator = new Calculator();
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;


        // Act
        int actualResult = calculator.integerDivision(dividend, divisor);

        assertEquals(expectedResult, actualResult, "4/2 did not produce 2");

    }

    //@Disabled("TODO: Still need to work it")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowAritmeticException() {
        System.out.println("Division by zero");

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

    @ParameterizedTest
    @ValueSource(strings = {"Jhon", "Kate", "Alice"})
    void valueSourceDemonstration(String firstName) {
        System.out.println(firstName);
        assertNull(firstName);
    }

    @DisplayName("Test integer substraction [minuend, substraend, expectedResult]")
    @ParameterizedTest
    //@MethodSource("integerSubstractionInputParameters")
    //@CsvSource({ "33, 1, 32", "24, 1, 23", "54, 1, 53", })
    @CsvFileSource(resources = "/integerDivision.csv")
    void integerSubstraction(int minuend, int substrahend, int expectedResult) {
        System.out.println(MessageFormat.format("Runing Test {0} - {1} = {2}", minuend, substrahend, expectedResult));
        Calculator calculator = new Calculator();

        int result = calculator.integerSubstraction(33, 1);

        assertEquals(32, result);

    }

//    private static Stream<Arguments> integerSubstractionInputParameters() {
//        return Stream.of(Arguments.of(33, 1, 32), Arguments.of(54, 1, 53), Arguments.of(24, 1, 23));
//    }
}
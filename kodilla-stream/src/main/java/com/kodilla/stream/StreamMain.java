package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalBeautifier;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nPoem beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String quote = "To be, or not to be, that is the question";
        System.out.println("Original quote: " + quote + "\n");

        poemBeautifier.beautify(quote,poem -> poem.toUpperCase());
        poemBeautifier.beautify(quote,poem -> "ABC " + quote + " ABC");
        poemBeautifier.beautify(quote,FunctionalBeautifier::everySecondCharacterToUpperCase);
        poemBeautifier.beautify(quote,FunctionalBeautifier::spacesToStars);
    }
}
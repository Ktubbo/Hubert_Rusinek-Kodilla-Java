package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String poem, PoetDecorator poetDecorator){
        String result = poetDecorator.decorate(poem);
        System.out.println(result);
    }
}

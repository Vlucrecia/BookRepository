package com.sky.library;

import com.sky.library.util.WordProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordProcessorTest {

    @Test
    public void Given_Sentence_When_getFirstNWordsFromString_Then_Return_FirstNWords() {
        String sentence = "Hello, Good Morning";
        assertEquals("", WordProcessor.getFirstNWordsFromString(sentence, 0));
        assertEquals("Hello", WordProcessor.getFirstNWordsFromString(sentence, 1));
        assertEquals("Hello, Good", WordProcessor.getFirstNWordsFromString(sentence, 2));
        assertEquals("Hello, Good Morning", WordProcessor.getFirstNWordsFromString(sentence, 3));
    }
}

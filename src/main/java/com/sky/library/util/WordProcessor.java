package com.sky.library.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor {
    public static final String OPEN_BRACKETS = "[";
    public static final String CLOSE_BRACKETS = "]";
    public static final String HYPHEN = "-";
    public static final String SPACE = " ";
    public static String PATTERN_WORD = "\\W*(?:\\w+|\\.|,\\b\\W*)";

    /**
     * Get the Matcher for the word processor
     * @param sentence
     * @return
     *          Matcher for the word
     */
    public static Matcher getWordMatcher(String sentence) {
        Pattern p = Pattern.compile(PATTERN_WORD);

        return p.matcher(sentence);
    }

    /**
     * Get the First N words from the string
     * @param sentence
     *          Given a sentence
     * @param limit
     *          Given the number of words to be retrieved
     * @return
     *          the First N words from the string
     */
    public static String getFirstNWordsFromString(String sentence, int limit) {

        Matcher m1 = getWordMatcher(sentence);

        StringBuilder sb = new StringBuilder();

        int count = 0;

        while ((m1.find()) && (count < limit)) {
            ++count;
            sb.append(m1.group());
        }

        return sb.toString();
    }
}

package com.example.learnmaori;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataProvider {
    public static Map<Integer, String> generateMaoriDigits() {
        Map<Integer, String> words =
                new LinkedHashMap<Integer, String>();
        words.put(1, "Tahi");
        words.put(2, "Rua");
        words.put(3, "Toru");
        words.put(4, "Wha");
        words.put(5, "Rima");
        words.put(6, "Ono");
        words.put(7, "Whitu");
        words.put(8, "Waru");
        words.put(9, "Iwa");
        return words;
    }

}

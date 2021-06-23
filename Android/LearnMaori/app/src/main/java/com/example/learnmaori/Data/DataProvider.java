package com.example.learnmaori.Data;

import com.example.learnmaori.Models.Number;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

    public static List<Number> getNumbers() {
        List<Number> numbersList = new ArrayList<Number>();
        Map<Integer, String> words = generateMaoriDigits();
        for (Integer key : words.keySet()) {
            int digit = key;
            String maoriTranslation = words.get(key);
            String icon = "icon" + String.valueOf(key);
            String audio = "audio_" + String.valueOf(key);

            Number n = new Number(digit, maoriTranslation, icon,  audio);
            numbersList.add(n);
        }

        return numbersList;
    }

}

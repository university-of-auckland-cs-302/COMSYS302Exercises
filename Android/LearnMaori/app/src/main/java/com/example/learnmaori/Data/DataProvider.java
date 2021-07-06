package com.example.learnmaori.Data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.learnmaori.Models.Colors;
import com.example.learnmaori.Models.IItems;
import com.example.learnmaori.Models.Number;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.installations.local.IidStore;

import org.jetbrains.annotations.NotNull;

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

    // Add number documents to Firestore
    public static void addNumberstoFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        List<IItems> numbersList = getNumbers();
        for (IItems aNumber : numbersList) {
            db.collection("numbers").document("number " + aNumber.getDigit()).set(aNumber).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d("Numbers Collection Add", "number " + aNumber.getDigit() + " added.");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Log.w("Numbers Collection Add", "number " + aNumber.getDigit() + " NOT added.");
                }
            });
        }
    }

    public static List<IItems> getNumbers() {
        List<IItems> numbersList = new ArrayList<IItems>();
        Map<Integer, String> words = generateMaoriDigits();
        for (Integer key : words.keySet()) {
            int digit = key;
            String maoriTranslation = words.get(key);
            String icon = "icon" + String.valueOf(key);
            String audio = "audio_" + String.valueOf(key);

            Number n = new Number(digit, maoriTranslation, icon, audio);
            numbersList.add(n);
        }

        return numbersList;
    }


}

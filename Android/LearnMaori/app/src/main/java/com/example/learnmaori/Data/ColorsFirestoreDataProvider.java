package com.example.learnmaori.Data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.learnmaori.Models.Colors;
import com.example.learnmaori.Models.IItems;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ColorsFirestoreDataProvider {

    private static Map<String, String> GetMaoriColors() {
        Map<String, String> words = new LinkedHashMap<String, String>();
        words.put("Yellow", "Kowhai");
        words.put("Orange", "Karaka");
        words.put("Red", "Whero");
        words.put("Pink", "Mawhero");
        words.put("Purple", "Tawa");
        words.put("Blue", "Kikorangi");
        words.put("Green", "Kakariki");
        words.put("Brown", "Parauri");
        words.put("Grey", "Kiwikiwi");
        words.put("White", "Ma");
        words.put("Black", "Mangu");
        return words;
    }

    // Add number documents to Firestore
    public static void addColorsToFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        List<IItems> colorList = getColors();
        for (IItems aColor : colorList) {
            db.collection("colors").document("color " + aColor.getEnglishColor()).set(aColor).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Log.d("Numbers Collection Add", "number " + aColor.getEnglishColor() + " added.");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Log.w("Numbers Collection Add", "number " + aColor.getEnglishColor() + " NOT added.");
                }
            });
        }
    }

    private static List<IItems> getColors() {
        List<IItems> colorsArrayList = new ArrayList<IItems>();
        Map<String, String> words = GetMaoriColors();

        for (String key : words.keySet()) {
            String defaultText = key;
            String maoriTranslation = words.get(key);
            String audio = "audio_" + defaultText.toLowerCase();
            String color = key.toLowerCase();
            Colors n = new Colors(defaultText, maoriTranslation, color, audio);
            colorsArrayList.add(n);
        }

        return colorsArrayList;
    }
}

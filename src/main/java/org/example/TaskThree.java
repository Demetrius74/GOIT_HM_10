package org.example;

import org.example.dto.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskThree {
    private final InputStream inputStream;

    public TaskThree(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        this.inputStream = classLoader.getResourceAsStream(fileName);
    }

    public void readFile() {
        Map<String, Integer> wordCount = new HashMap<>();

        // Читаю файл
        InputStreamReader streamReader = new InputStreamReader(this.inputStream);
        try (BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        List<Map.Entry<String, Integer>> list = sorted(wordCount);

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private List<Map.Entry<String, Integer>> sorted(Map<String, Integer> wordCount) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        return list;
    }
}

package org.example;

import java.io.*;
import java.util.regex.*;

public class TaskOne {
    private final InputStream inputStream;

    public TaskOne(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        this.inputStream = classLoader.getResourceAsStream(fileName);
    }

    public void printValidPhoneNumber(){
        InputStreamReader streamReader = new InputStreamReader(this.inputStream);
        try (BufferedReader br = new BufferedReader(streamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // ТУт валідуємо через регулярний вираз
        String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}

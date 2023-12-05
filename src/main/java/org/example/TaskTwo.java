package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
    private final Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();
    private final InputStream inputStream;

    public TaskTwo(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        this.inputStream = classLoader.getResourceAsStream(fileName);
    }
    private List<User> readFile() {
        List<User> users = new ArrayList<>();

        // Читаю файл
        InputStreamReader streamReader = new InputStreamReader(this.inputStream);
        try (BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                // Записуємо данні в класс
                User user = new User();
                user.setName(parts[0]);
                user.setAge(Integer.parseInt(parts[1]));
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return users;
    }

    public void writeDTO() {
        List<User> users = this.readFile();
        String json = gson.toJson(users);

        try (PrintWriter out = new PrintWriter("src/main/resources/user.json")) {
            out.println(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("Done.");
    }
}

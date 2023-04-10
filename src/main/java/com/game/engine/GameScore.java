package com.game.engine;

import com.game.di.DependencyManager;
import com.game.ui.game.HiscoreModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class GameScore {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
            .disableHtmlEscaping().create();

    private int score;

    private final Map<String, Integer> scores;

    private String directory;

    public GameScore() {
        this.scores = new HashMap<>();
        directory = "./";
        load();
    }

    public void updateScore(int by) {
        this.score += by;
        HiscoreModel model = DependencyManager.get("hiscores");
        model.score.set(this.score);
    }

    public void onGameEnd(String name) {
        scores.put(name, this.score);
        save();
        this.score = 0;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
        load();
    }

    public void save() {
        try {
            Path path = Path.of(directory,"scores.json");
            if(Files.notExists(path)) {
                Files.createFile(path);
            }
            Files.write(path, GSON.toJson(scores).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            Path path = Path.of(directory, "scores.json");
            if(!Files.exists(path)) {
                return;
            }
            byte[] data = Files.readAllBytes(path);
            Map<String, Integer> scores = GSON.fromJson(new String(data), new TypeToken<Map<String, Integer>>(){}.getType());
            this.scores.putAll(scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

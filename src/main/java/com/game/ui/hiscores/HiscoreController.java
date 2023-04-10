package com.game.ui.hiscores;

import com.game.di.DependencyManager;
import com.game.engine.GameScore;
import com.game.engine.GameSettings;
import com.game.engine.world.GameWorld;
import com.game.ui.controller.ControllerManager;
import com.game.ui.controller.GameUIController;
import com.game.ui.game.HiscoreModel;
import com.game.ui.game.ScoreModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class HiscoreController extends GameUIController {

    @FXML
    private TableView<ScoreModel> scoreTable;
    @FXML
    private TableColumn<ScoreModel, String> nameColumn;
    @FXML
    private TableColumn<ScoreModel, GameSettings.Difficulty> gameDifficulty;
    @FXML
    private TableColumn<ScoreModel, Integer> scoreColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HiscoreModel model = DependencyManager.get("hiscores");

        scoreTable.itemsProperty().bind(model.scores);

        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        gameDifficulty.setCellValueFactory(param -> param.getValue().difficultyProperty());
        scoreColumn.setCellValueFactory(param -> param.getValue().scoreProperty().asObject());

        GameWorld world = DependencyManager.get("world");
        world.getState().load();
        Map<String, Pair<GameSettings.Difficulty, Integer>> scores = world.getState().getScores();

        List<ScoreModel> scoreModels = scores.entrySet()
                .stream()
                .map(entry -> new ScoreModel(entry.getKey(), entry.getValue().getKey(), entry.getValue().getValue()))
                .toList();
        model.scores.clear();
        model.scores.addAll(scoreModels);
    }

    @FXML
    public void onMainMenu() throws IOException {
        ControllerManager.switchToMainMenu(this);
    }
}

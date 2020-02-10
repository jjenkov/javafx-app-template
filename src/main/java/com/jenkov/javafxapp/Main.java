package com.jenkov.javafxapp;

import com.jenkov.javafxapp.bus.ComBus;
import com.jenkov.javafxapp.plugins.PluginManager;
import com.jenkov.javafxapp.plugins.plugin1.Plugin1;
import com.jenkov.javafxapp.plugins.plugin2.Plugin2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        ComBus comBus = new ComBus();

        PluginManager pluginManager = new PluginManager();

        pluginManager.addPlugin(new Plugin1());
        pluginManager.addPlugin(new Plugin2());

        pluginManager.initPlugins(comBus);
        pluginManager.configurePlugins();

        VBox root = new VBox(new Label("Hello World, JavaFX"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

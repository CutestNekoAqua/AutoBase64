package me.waterdev.autobase64;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import me.waterdev.autobase64.Objects.Result;
import me.waterdev.autobase64.Utils.Base64Manager;
import me.waterdev.autobase64.Utils.LogManager;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Result> list = new ArrayList<Result>();

    @Override
    public void start(Stage stage) throws Exception{
        initUI(stage);
    }

    private void initUI(Stage stage) {

        GridPane root = new GridPane ();
        AnchorPane ap = new AnchorPane();

        Scene scene = new Scene(ap, 400, 300);

        //Font config
        Font fbig = Font.font("Serif", FontWeight.NORMAL, 20);
        Font fsmol = Font.font("Serif", FontWeight.NORMAL, 13);

        //Adding objects
        Label lb1 = new Label("Encoding");
        lb1.setFont(fbig);

        Label lb2 = new Label("Decoding");
        lb2.setFont(fbig);

        TextField f1 = new TextField("Original text");
        f1.setFont(fsmol);
        f1.setMaxWidth(300);

        TextField f2 = new TextField("Encoded text");
        f2.setFont(fsmol);
        f2.setMaxWidth(300);

        TextField f3 = new TextField("Encode count");
        f3.setFont(fsmol);
        f3.setAlignment(Pos.CENTER_RIGHT);
        f3.setPrefWidth(100);

        Button b1 = new Button("Encode");
        b1.setPrefWidth(100);
        b1.setFont(fsmol);
        b1.setAlignment(Pos.CENTER_RIGHT);
        b1.setOnAction((ActionEvent arg0) -> {
            Platform.runLater(() -> {
                try {
                    new Base64Manager(f1.getText()).encode(new Integer(f3.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        Button b2 = new Button("Decode");
        b2.setPrefWidth(100);
        b2.setFont(fsmol);
        b2.setAlignment(Pos.CENTER_RIGHT);
        b2.setOnAction((ActionEvent arg0) -> {
            Platform.runLater(() -> {
                new Base64Manager(f2.getText()).decode();
            });
        });

        TextArea log = new TextArea();
        log.setFont(fsmol);
        log.setWrapText(true);
        log.setPrefHeight(1000);
        log.setPrefWidth(1400);

        Button logb = new Button("Refresh Log");
        logb.setFont(fsmol);
        logb.setOnAction((ActionEvent arg0) -> {
            Platform.runLater(() -> {
                log.setText(new LogManager().getlog());
            });
        });


        //Adding all Rows
        root.addRow(0, lb1);
        root.addRow(1, f1, f3, b1);
        root.addRow(2, lb2);
        root.addRow(3, f2, b2);
        root.addRow(4, logb);

        ap.setTopAnchor(log, 125.0);
        ap.setLeftAnchor(log, 0.0);
        ap.setBottomAnchor(log, 0.0);
        ap.setRightAnchor(log, 0.0);

        ap.getChildren().addAll(log, root);

        stage.setTitle("Multilayer Base64 En/Decoder");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

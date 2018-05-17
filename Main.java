package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Main extends Application {

    int COUNTER = 0;

    @Override
    public void start(Stage primaryStage) {

        Controller con = new Controller();
        int randomNumber;
        randomNumber = con.PickRandomNumber();
        System.out.println("RANDOM NUMBER " + randomNumber);

        TextField textField = new TextField();
        TextField score = new TextField();

        score.getOnAction();

        TextField textField2 = new TextField();
        textField2.setEditable(false);

        Label label = new Label("Number of guesses: ");

        Label makeAGuessLabel = new Label("Insert your guess here -> ");

        FlowPane flow = new FlowPane();

        Button button = new Button("Make a guess!");



        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fun = "";
                Controller con = new Controller();
                System.out.println("ACTUAL NUMBER: " + randomNumber + "\n");
                fun = con.MakeAGuess(textField.getText(), randomNumber);
                System.out.println("FUN: " + fun);
                if(fun == "lower!"){
                    COUNTER++;
                }
                else if (fun == "higher!"){
                    COUNTER++;
                }
                else{
                    COUNTER = 0;
                }
                textField2.setText(fun);
                score.setText(String.valueOf(COUNTER));
                System.out.println("COUNTER: " + COUNTER);
            }
        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setMargin(button, new Insets(10, 5, 5, 10));
        hbox.setMargin(textField, new Insets(10, 5, 5, 0));
        hbox.setMargin(makeAGuessLabel, new Insets(13, 5, 5, 5));

        textField.setPrefWidth(60);
        textField.setEditable(true);

        score.setPrefWidth(50);
        score.setEditable(false);

        textField2.setPrefWidth(60);

        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(5, 5, 5, 5));
        hbox2.setMargin(textField2, new Insets(5, 5, 5, 145));

        HBox hbox3 = new HBox();
        hbox3.setPadding(new Insets(5, 50, 5, 100));
        hbox3.setMargin(score, new Insets(3, 5, 2, 10));
        hbox3.setMargin(label, new Insets(5, 5, 5, 5));

        ObservableList list = hbox.getChildren();
        list.addAll(makeAGuessLabel, textField, button);

        ObservableList list2 = hbox2.getChildren();
        list2.addAll(textField2);

        ObservableList list4 = hbox3.getChildren();
        list4.addAll(label, score);

        ObservableList list3 = flow.getChildren();
        list3.addAll(hbox, hbox2, hbox3);

        primaryStage.setTitle("Higher/Lower");
        primaryStage.setScene(new Scene(flow, 320, 200));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

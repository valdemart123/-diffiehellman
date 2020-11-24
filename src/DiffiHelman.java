import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.event.EventHandler;

import java.math.BigInteger;

public class DiffiHelman extends Application {
    public static void main(String[] args) {

        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        //Text labels
        Label qLabel = new Label("Число Q");
        Label xLabel = new Label("Число X");
        Label yLabel = new Label("Число Y");
        Label keyLabel = new Label("Ключ");

        //Result labels
        Label lbl = new Label();
        Label xlbl = new Label();
        Label ylbl = new Label();



        AlgorithmDiffiHelman  dhAlgorithm = new AlgorithmDiffiHelman();
        TextArea qArea = new TextArea();
        qArea.setPrefColumnCount(1);
        qArea.setPrefRowCount(1);
        Button btnEncode = new Button("Зашифровать");


        btnEncode.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int q = Integer.parseInt(qArea.getText());
                Generator generator = new Generator();
                BigInteger a = generator.getA(q);
                Integer privateNumber = generator.getPrivateNumber(q);
                AlgorithmDiffiHelman algorithm = new AlgorithmDiffiHelman(BigInteger.valueOf(q), a, privateNumber);
                BigInteger result = algorithm.calculatePrivateKey(algorithm.calculatePublicKey());
                lbl.setText(result.toString());
                xlbl.setText(privateNumber.toString());
                ylbl.setText(a.toString());
            }
        });

        ScrollPane scrollPane = new ScrollPane(lbl);
        scrollPane.setPrefViewportHeight(1);
        scrollPane.setPrefViewportWidth(1);

        ScrollPane xPane = new ScrollPane(xlbl);
        xPane.setPrefViewportHeight(1);
        xPane.setPrefViewportWidth(1);

        ScrollPane yPane = new ScrollPane(ylbl);
        yPane.setPrefViewportHeight(1);
        yPane.setPrefViewportWidth(1);

        FlowPane root = new FlowPane(Orientation.VERTICAL, 1, 6, qLabel,qArea, btnEncode,
                xLabel, xPane, yLabel, yPane,  keyLabel, scrollPane);

        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 250, 320);

        stage.setScene(scene);
        stage.setTitle("Деффи Хелман Шифровальщик");
        stage.show();
    }
}

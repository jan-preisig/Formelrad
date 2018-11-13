package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Formelrad Application
 *
 * @author Ufuk Arikan, Jan Preisig
 * @version 13.09.2018
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    try {
      Pane root = new Pane();

      // Creating an image
      Image image = new Image(new FileInputStream("src\\application\\formelradelektronik.gif"));
      ImageView imageView = new ImageView(image);
      imageView.setX(10);
      imageView.setY(10);
      imageView.setFitHeight(300);
      imageView.setFitWidth(300);
      imageView.setPreserveRatio(true);
      root.getChildren().add(imageView);

      Label lbleistung = new Label("Leistung:");
      lbleistung.relocate(10, 285);
      lbleistung.setFont(Font.font(15));
      root.getChildren().add(lbleistung);

      TextField txLeistung = new TextField();
      txLeistung.relocate(100, 285);
        txLeistung.setStyle("-fx-text-inner-color: red;");
      txLeistung.setFont(Font.font("Verdana", 15));
      root.getChildren().add(txLeistung);

      Label lblSpannung = new Label("Spannung:");
      lblSpannung.relocate(10, 325);
      lblSpannung.setFont(Font.font(15));
      root.getChildren().add(lblSpannung);

      TextField txSpannung = new TextField();
      txSpannung.relocate(100, 325);
        txSpannung.setStyle("-fx-text-inner-color: red;");
      txSpannung.setFont(Font.font("Verdana", 15));
      root.getChildren().add(txSpannung);

      Label lblStrom = new Label("Strom:");
      lblStrom.relocate(10, 365);
      lblStrom.setFont(Font.font(15));
      root.getChildren().add(lblStrom);

      TextField txStrom = new TextField();
      txStrom.relocate(100, 365);
        txStrom.setStyle("-fx-text-inner-color: red;");
      txStrom.setFont(Font.font("Verdana", 15));
      root.getChildren().add(txStrom);

      Label lblWiderstand = new Label("Widerstand:");
      lblWiderstand.relocate(10, 405);
      lblWiderstand.setFont(Font.font(15));
      root.getChildren().add(lblWiderstand);

      TextField txWiderstand = new TextField();
      txWiderstand.relocate(100, 405);
        txWiderstand.setStyle("-fx-text-inner-color: red;");
      txWiderstand.setFont(Font.font("Verdana", 15));
      root.getChildren().add(txWiderstand);

      Button btnBerechnen = new Button();
      btnBerechnen.relocate(100, 445);
      btnBerechnen.setText("Berechnen");
      root.getChildren().add(btnBerechnen);

      Label lblWarnung = new Label();
      lblWarnung.relocate(200, 445);
      lblWarnung.autosize();
      root.getChildren().add(lblWarnung);

      btnBerechnen.setOnAction(e -> {
          Calculator myCalculator = new Calculator(getValues(txLeistung),
                  getValues(txSpannung), getValues(txStrom), getValues(txWiderstand));
        System.out.print("Vorher:  ");
        System.out.println(myCalculator.toString());
        myCalculator.calculate();
        System.out.print("Nachher: ");
        System.out.println(myCalculator.toString());

        txLeistung.setText(Double.toString(myCalculator.getLeistung()));
        txSpannung.setText(Double.toString(myCalculator.getSpannung()));
        txStrom.setText(Double.toString(myCalculator.getStrom()));
        txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
        lblWarnung.setText(myCalculator.getWarnung());
      });

      Scene scene = new Scene(root, 330, 490);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setTitle("Formelrad");
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

    private Double getValues(TextField field) {
        if (!field.getText().trim().equals("")) {
            return Double.parseDouble(field.getText());
        }
        return 0.0;
    }
}

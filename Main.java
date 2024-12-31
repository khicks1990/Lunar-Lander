import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;

/**
 *  Lunar Lander
 */

public class Main extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {

      // Load the images.
      Image landerImage = new Image("lunar lander.png");
      Image surfaceImage = new Image("lunar surface.png");

      // Create the ImageView controls.
      ImageView landerIV = new ImageView(landerImage);
      ImageView surfaceIV = new ImageView(surfaceImage);

      // Create a Transition object to move the lander into position
      TranslateTransition itrans =
            new TranslateTransition(new Duration(1000), landerIV);
      itrans.setFromX(0);
      itrans.setFromY(350);
      itrans.setToX(320);
      itrans.setToY(350);

      // Create the Transition object.
      TranslateTransition ttrans =
            new TranslateTransition(new Duration(1000), landerIV);
      ttrans.setFromX(320);
      ttrans.setFromY(350);
      ttrans.setToX(320);
      ttrans.setToY(-100);

      // Put everything into a Pane
      Pane mainpane = new Pane(surfaceIV, landerIV);

      // Add the main VBox to a scene.
      Scene scene = new Scene(mainpane);

      // Register the event handler.
      scene.setOnKeyPressed(e ->
      {
         ttrans.play();
      });

      // Set the scene to the stage aand display it.
      primaryStage.setScene(scene);
      primaryStage.show();
      itrans.play();
   }
}
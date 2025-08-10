import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

/**
 * Primeira aplicação JavaFX
 *
 * @author POO 2024/2025
 * @version junho/2025
 */
public class App extends Application
{
    private static final double WINDOW_WIDTH = 700.0;
    private static final double WINDOW_HEIGHT = 500.0;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: blue");

       Circle planet = new Circle();

       planet.setCenterX(350.0);
       planet.setCenterY(1000.0);
       planet.setRadius(700.0f);
       planet.setFill(Color.rgb(101, 67, 33));


        Cloud cloud1 = new Cloud(150.0, 100.0);
        Cloud cloud2 = new Cloud(500.0, 150.0);
        Cloud cloud3 = new Cloud(60.0, 200.0);

        Rocket rocket = new Rocket(300, 100);



        root.getChildren().add(planet);
        root.getChildren().add(rocket);
        root.getChildren().addAll(cloud1, cloud2, cloud3);


        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

class Cloud extends Pane {
    private static final double RADIUS_X = 35.0;
    private static final double RADIUS_Y = 15.0;
    private static final Color FILL_COLOR = Color.LIGHTGRAY;

    public Cloud(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
        createCloud();
    }

    private void createCloud() {
        Ellipse ellipse1 = createEllipse(1.5, 1.0);
        Ellipse ellipse2 = createEllipse(3.0, 1.0);
        Ellipse ellipse3 = createEllipse(1.0, 2.0);
        Ellipse ellipse4 = createEllipse(2.5, 2.0);
        Ellipse ellipse5 = createEllipse(3.5, 2.0);

        getChildren().addAll(ellipse1, ellipse2, ellipse3, ellipse4, ellipse5);
    }

    private Ellipse createEllipse(double dx, double dy) {
        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(RADIUS_X);
        ellipse.setRadiusY(RADIUS_Y);
        ellipse.setCenterX(RADIUS_X * dx);
        ellipse.setCenterY(RADIUS_Y * dy);
        ellipse.setFill(FILL_COLOR);
        return ellipse;
    }
}
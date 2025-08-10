import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

class Rocket extends Pane {
    // Constantes para dimensões
    private static final double BODY_WIDTH = 80.0;
    private static final double BODY_HEIGHT = 150.0;
    private static final double TIP_HEIGHT = 50.0;
    private static final double FOOT_HEIGHT = 50.0;
    private static final double FOOT_WIDTH = 50.0;
    private static final double FOOT_DX = 15.0;
    private static final double FOOT_DY = 20.0;
    private static final double STROKE_WIDTH = 2.0;

    // Constantes para cores
    private static final Color BODY_COLOR = Color.GREY;
    private static final Color OTHER_COLOR = Color.rgb(128, 0, 32); // BURGUNDY
    private static final Color STROKE_COLOR = Color.BLACK;

    // Atributo para guardar a posição Y inicial
    private double initialY;

    public Rocket(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
        createRocket();
        setupMouseHandlers();
    }

    private void createRocket() {
        // Criar o topo (triângulo)
        Polygon tip = createTriangle(FOOT_DX, 0.0, BODY_WIDTH, TIP_HEIGHT);

        // Criar o corpo (retângulo)
        Rectangle body = createRectangle(FOOT_DX, TIP_HEIGHT, BODY_WIDTH, BODY_HEIGHT);

        // Criar o pé esquerdo (triângulo)
        Polygon leftFoot = createTriangle(0.0,
                TIP_HEIGHT + BODY_HEIGHT - FOOT_DY,
                FOOT_WIDTH, FOOT_HEIGHT);

        // Criar o pé direito (triângulo)
        Polygon rightFoot = createTriangle(FOOT_DX * 2 + BODY_WIDTH - FOOT_WIDTH,
                TIP_HEIGHT + BODY_HEIGHT - FOOT_DY,
                FOOT_WIDTH, FOOT_HEIGHT);

        getChildren().addAll(tip, body, leftFoot, rightFoot);
    }

    private void setupMouseHandlers() {
        setOnMousePressed(e -> {
            initialY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            double deltaY = initialY - e.getSceneY();
            setTranslateY(Math.min(0.0, -deltaY)); // Só permite movimento para cima
        });

        setOnMouseReleased(e -> {
            setTranslateY(0); // Volta à posição original
        });
    }

    private Rectangle createRectangle(double x, double y, double width, double height) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(BODY_COLOR);
        rectangle.setStroke(STROKE_COLOR);
        rectangle.setStrokeWidth(STROKE_WIDTH);
        return rectangle;
    }

    private Polygon createTriangle(double x, double y, double width, double height) {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                x, y + height,            // Ponto inferior esquerdo
                x + width / 2.0, y,       // Ponto superior central
                x + width, y + height     // Ponto inferior direito
        );
        triangle.setFill(OTHER_COLOR);
        triangle.setStroke(STROKE_COLOR);
        triangle.setStrokeWidth(STROKE_WIDTH);
        return triangle;
    }
}
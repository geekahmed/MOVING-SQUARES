import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class  Main extends  Application{
    ArrayList<Rectangle> rectangleArrayList = new ArrayList<>();
    Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.YELLOW, Color.GREEN, Color.VIOLET};
    Random rand = new Random();
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        add_rect();
        for(Rectangle r: rectangleArrayList){
            root.getChildren().add(r);
            Timeline animation = new Timeline (new KeyFrame(Duration.millis(1000) , e -> {
                double dx = rand.nextInt(16 + 15) - 15;
                double dy = rand.nextInt(16 + 15) - 15;
                if (r.getX() >= 800 - r.getWidth() || r.getX() < 0){
                    dx *= -1 ;
                }
                if (r.getY() >= 600 - r.getHeight() || r.getY() < 0){
                    dy *= -1 ;
                }
                r.setX(r.getX() + dx);
                r.setY(r.getY() + dy);
            }));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        Scene scene = new Scene(root, 800,600);
        primaryStage.setTitle("Moving Squares");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void add_rect(){
        int x = 100, y = 50;
        for (int i = 1 ; i <= 11 ; i++){
            int c = rand.nextInt(colors.length);
            Rectangle rectangle = new Rectangle(x,y,100,100);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(colors[c]);
            rectangle.setStrokeWidth(10);
            rectangleArrayList.add(rectangle);
            x += 50;
            y += 20;
        }
    }
}
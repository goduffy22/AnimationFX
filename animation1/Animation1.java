/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation1;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Gareth
 */
public class Animation1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(50, 50, 300, 100);
        rectangle.setFill(Color.FORESTGREEN);
        
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000));
        //fadeTransition.setNode(circle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.25);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(false);
        
        //fadeTransition.play();
        
        FillTransition fillTransition = new FillTransition(Duration.millis(1000));
        //fillTransition.setShape(rectangle);
        fillTransition.setFromValue(Color.CORAL);
        fillTransition.setToValue(Color.BROWN);
        fillTransition.setCycleCount(5);
        fillTransition.setAutoReverse(true);
        
        //fillTransition.play();
        
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setCycleCount(4);
        //rotateTransition.setToAngle(90);
        rotateTransition.setByAngle(360);
        rotateTransition.setNode(rectangle);
        
        //rotateTransition.play();
        
        //ScaleTransition, StrokeTransition(color, how do you do thickness?)
        //TranslateTransition, SequentialTransition, ParallelTransition, PauseTransition 
        
        PathTransition pathTransition = new PathTransition();
        Path path = new Path();
        MoveTo moveTo = new MoveTo(20, 20);
        HLineTo line1 = new HLineTo(120);
        LineTo line2 = new LineTo(60, 100);
        QuadCurveTo quadCurveTo = new QuadCurveTo(500, 100, 180, 300);
        path.getElements().addAll(moveTo, line1, line2, quadCurveTo);
        pathTransition.setPath(path);
        pathTransition.setNode(rectangle);
        pathTransition.setCycleCount(2);
        pathTransition.setAutoReverse(false);
        pathTransition.setDuration(Duration.millis(2000));
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);//Default = none
        
        //pathTransition.play();
        
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(3));
        
        SequentialTransition sequentialTransition = new SequentialTransition(rectangle,
        pathTransition, pauseTransition, rotateTransition);
        //sequentialTransition.play(); //Performed in sequence, one after the other
        
        ParallelTransition parallelTransition = new ParallelTransition(rectangle, pathTransition, pauseTransition, rotateTransition);
        parallelTransition.play(); //All at the "same" time
        
        Group root = new Group();
        ObservableList list = root.getChildren();
        list.add(rectangle);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Animate");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

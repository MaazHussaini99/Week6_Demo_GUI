package week6_demo_gui;

import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;

import javafx.scene.shape.*;

import javafx.stage.Stage;

public class Week6_Demo_GUI extends Application {

    int count = 0;

    double strtX = 0, strtY = 0, endX = 0, endY = 0;

    public static void main(String[] args) {

        launch(args);

    }

    @Override

    public void start(Stage stage) throws Exception {

        Rectangle canvas1 = new Rectangle(600, 250, Color.LIGHTBLUE); //painting sky lightblue
        Rectangle canvas2 = new Rectangle(600, 450, Color.LIME);//painting lawn/surrounding
        canvas2.setX(0); canvas2.setY(250);
        
        Polyline roof = new Polyline();
        roof.getPoints().addAll(new Double[]{
            300.0, 0.0,
            550.0, 150.0,
            50.0, 150.0, // triangle roof on the top
            300.0, 0.0});
        roof.setStroke(Color.BLACK);
        roof.setFill(Color.WHITE);
        
        Rectangle rect = new Rectangle(70, 150, 460, 30);
        rect.setFill(Color.WHITE); // rectangle below the triangle
        rect.setStroke(Color.BLACK);
        
        Rectangle wall = new Rectangle(70, 180, 460, 330);
        wall.setFill(Color.CHOCOLATE); //Brown wall
        wall.setStroke(Color.BLACK);
        
        Rectangle window = new Rectangle(260, 210, 80, 40);
        window.setFill(Color.LIGHTGRAY); //Center window
        window.setStroke(Color.BLACK);
        
        Rectangle door1 = new Rectangle(125, 295, 80, 165);
        door1.setFill(Color.WHITE); // door no 1
        door1.setStroke(Color.BLACK);
        
        Rectangle door2 = new Rectangle(260, 275, 80, 190);
        door2.setFill(Color.WHITE); // door no 2
        door2.setStroke(Color.BLACK);
        
        Rectangle door3 = new Rectangle(395, 295, 80, 165);
        door3.setFill(Color.WHITE); // door no 3
        door3.setStroke(Color.BLACK);
       
        Rectangle belowDoor = new Rectangle(70, 460, 460, 5);
        belowDoor.setFill(Color.LIGHTGRAY); //gray block under doors and pillars
        belowDoor.setStroke(Color.BLACK);
        
        Group gp = new Group(canvas1, canvas2, roof, rect, wall, window, door1, door2, door3, belowDoor); // drawing the components
        
        Circle circle1;
        Circle circle2;
        int num = 80;
        int radius = 11;
        
        for (int i = 0; i < 4; i++) {
            
            Rectangle pillar1 = new Rectangle(num, 180, 35, 270);
            pillar1.setFill(Color.WHITE); // white fill pillar
            pillar1.setStroke(Color.BLACK); //black outline pillar
            gp.getChildren().add(pillar1); //draw pillar
            
            circle1 = new Circle();
            circle1.setFill(Color.WHITE);
            circle1.setStroke(Color.BLACK);
            circle1.setRadius(radius);
            circle1.setCenterX(num); // circle on the top left side of the pillars
            circle1.setCenterY(180 + radius);
            gp.getChildren().add(circle1);
           
            circle2 = new Circle();
            circle2.setFill(Color.WHITE);
            circle2.setStroke(Color.BLACK);
            circle2.setRadius(radius);
            circle2.setCenterX(num + 35); // circle on the top right side of the pillars
            circle2.setCenterY(180 + radius);
            gp.getChildren().add(circle2);
            
            rect = new Rectangle(num - 5, 450, 45, 10); 
            rect.setFill(Color.WHITE);
            rect.setStroke(Color.BLACK);//block/base under the pillars
            gp.getChildren().add(rect);
            
            num += 135;
        }
        int x = 120; int y = 460; int width = 360;
        
        for (int i = 1; i <= 11; i++) {
            rect = new Rectangle(x, y, width, 10);
            rect.setFill(Color.LIGHTGRAY);
            rect.setStroke(Color.BLACK);
            gp.getChildren().add(rect); // drawing stairs after changing size in evry iteration
            x = x - 10; 
            y = y + 10; 
            width = width + 20; 
        }
        int a= 142; int b= 310;
        
        for (int z = 0; z < 3; z++) {
            for (int i = 0, j = 0; i < 5; i++, j += 30) {
                rect = new Rectangle(a, b + j, 15, 25); 
                rect.setFill(Color.BLACK);
                rect.setStroke(Color.BLACK); // left side black boxexxon the doors
                gp.getChildren().add(rect);

                rect = new Rectangle(a + 30, b + j, 15, 25); 
                rect.setFill(Color.BLACK);
                rect.setStroke(Color.BLACK); // right side black boxes on the door
                gp.getChildren().add(rect);
            }
            a+=135;
        }
       
        Scene sn = new Scene(gp, 600, 600);

        stage.setScene(sn);

        stage.show();

    }

}

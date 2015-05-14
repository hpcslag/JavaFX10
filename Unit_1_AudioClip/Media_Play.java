/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author m4a1
 */
public class Main extends Application {
    
    public void start(Stage primaryStage) {
        Text t = new Text("JavaFX Hello world!");
        t.setX(50);
        t.setY(50);
       
        Button status = new Button();
        
        
       CheckBox checkbox;
       final Slider slider1, slider2, slider3, slider4, slider5;
       
       slider1 = new Slider(0,1,1);
       slider1.setMin(0);
       slider1.setMax(100);
       slider1.setValue(40);
       slider1.setShowTickLabels(true);
       slider1.setShowTickMarks(true);
       slider1.setMajorTickUnit(50);
       slider1.setMinorTickCount(5);
       slider1.setBlockIncrement(10);
       
       final Media a = new Media(getClass().getResource("audio/Stromae-Papaoutai.wav").toString());
       System.out.println(getClass().getResource("audio/Stromae-Papaoutai.mp3").toString());
       //a.setVolume(0);
       final MediaPlayer md = new MediaPlayer(a);
       
       md.setAutoPlay(true);
       
       slider1.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old, Number newD) {
                md.setVolume((double)newD * 0.01);
                System.out.println(md.getVolume());
                //md.setVolume(d);
                slider1.setValue((double)newD);
            }
        });
       
       status.setLayoutX(20);
       status.setLayoutY(20);
       status.setText("Play/Pause");
       status.setOnMouseClicked(new EventHandler(){
            @Override
            public void handle(Event e) {
                if(md.getStatus() == MediaPlayer.Status.PLAYING){
                    md.pause();
                }else{
                    md.play();
                }
            }
       });
       
       
       
       Group group = new Group();
       group.getChildren().add(t);
       group.getChildren().add(slider1);
       group.getChildren().add(status);
       
       Scene s = new Scene(group);
       primaryStage.setTitle("Hello world");
       primaryStage.setWidth(250);
       primaryStage.setHeight(200);
       primaryStage.setScene(s);
       
       
       
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

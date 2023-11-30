package com.example.stick_hero;

import javafx.animation.KeyValue;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

import static com.example.stick_hero.HelloApplication.accessMainStageHeight;
import static com.example.stick_hero.HelloApplication.accessMainStageWidth;

public class GamePlay  {

    private Stage Game_Stage;
    private Scene Game_Scene;
    private int stick_has = 1;
    private int stick_rotate = 0;
    private Parent root;
    // private Character character;
    // private Rectangle pillar_current;
    // private Rectangle pillar_next;
    // private Rectangle pillar_next_to_next;
    // private Imgview cherry;
    // private Rectangle stick;
    // private int score;
    //
    @FXML
    private Rectangle stick;
    @FXML
    private Rectangle starting_platform;
    @FXML
    private Rectangle next_platform;
    @FXML
    AnchorPane main_stuff;
    public int character_fate;
    public int Stick_checker(){
        double p = starting_platform.getLayoutX()+starting_platform.getWidth();
        double separation=(next_platform.getLayoutX()-p);
        System.out.println(separation);
        double difference=stick.getHeight()-separation;
        if(difference<0){
            //stick too short case
            System.out.println("OYE PAPAJI! OYE PAPAJI!");
            return -1;
        }

            else if(difference>next_platform.getWidth()){
                //stick too long case
                System.out.println("PAIN MAKES ME NUMB");
                return 0;
            }else{
                //stick just right
                System.out.println("JAI GANESH!");
                return 1;
            }


    }

    public void initialize() {

        //stick generator
        Timeline stick_generate = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            stick.setHeight(stick.getHeight() + 10);
            stick.setY(stick.getY() - 10);
        }));
        stick_generate.setCycleCount(Timeline.INDEFINITE);


        //stick rotation timeline
        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(stick.xProperty());
        rotation.pivotYProperty().bind(stick.yProperty().add(stick.heightProperty()));
        stick.getTransforms().add(rotation);

        Timeline stick_rotation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(rotation.angleProperty(), 90))
        );

        System.out.println(accessMainStageWidth());
        System.out.println(accessMainStageHeight());

        //random numbers for variable pillar position and width
        Random rand = new Random();
        double rand_dub1 = rand.nextDouble(115,435);
        double max_allowed_width=accessMainStageWidth()-rand_dub1;
        double rand_dub2 = rand.nextDouble(45,max_allowed_width);
        System.out.println("Random Doubles: "+rand_dub1);
        System.out.println("Random Doubles: "+rand_dub2);
        next_platform.setLayoutX(rand_dub1);
        next_platform.setWidth(rand_dub2);




        //Don't make multiple setOnKeyPressed as the code will call the last event handler
        //this is our keyboard input to code execution block
        main_stuff.setOnKeyPressed( event1 -> {
            switch(event1.getCode()) {
                case CONTROL:
                    System.out.println("hari om "+ event1.getCode());
                    switch(stick_has) {
                        case 0:
                            System.out.println("Stick already made");
                            break;
                        case 1:
                            stick_generate.play();
                            stick_has=0;
                            break;
                    }
                    break;
                case SHIFT:
                    //I have added this as a case of example : agar tujhe aur koi key press add karna ho toh just add a case here
                    //Aur yeh optimised hai: he he :)
                    System.out.println("Hing " + event1.getCode());
                    break;
            }
        });
        main_stuff.setOnKeyReleased(event -> {
            switch(event.getCode()) {
                case CONTROL:
                    System.out.println("hari om");
                    stick_generate.stop();
                    switch(stick_rotate) {
                        case 0:
                            stick_rotation.play();
                            stick_rotate=1;
                            break;
                        case 1:
                            System.out.println("Stick has rotated");
                            break;
                    }
                    character_fate=this.Stick_checker();
                    break;
                case SHIFT:
                    //I have added this as a case of example : agar tujhe aur koi key press add karna ho toh just add a case here
                    //Aur yeh optimised hai: he he :)
                    System.out.println("Hing");
                    break;
            }
        });
    }



    public void pause_game(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pause_menu.fxml")));
        Game_Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Game_Scene = new Scene(root);
        Game_Stage.setScene(Game_Scene);
        Game_Stage.show();
    }
    public void game_over(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game_over.fxml")));
        Game_Stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Game_Scene = new Scene(root);
        Game_Stage.setScene(Game_Scene);
        Game_Stage.show();
    }
    // public void create_pillar(){}
    // public void move_character(){}
    // public void invert_character(){}
    // public void shift_to_Game_Stage(){}
    // public void collect_cherry(){}
    // public void get_score(){}
    // public void set_score(){}
    // public void get_cherry_count(){}
    // public void set_cherry_count(){}
}

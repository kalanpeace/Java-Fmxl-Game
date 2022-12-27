package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class HelloController {
    @FXML
    private VBox NPCVBox;
    @FXML
    private Label NPCStats;
    @FXML
    private VBox playerVBox;
    @FXML
    private Label playerStats;
    @FXML
    private Button moveNorthButton;
    @FXML
    private Button movesSouthButton;
    @FXML
    private Button moveWestButton;
    @FXML
    private Button moveEastButton;
    @FXML
    private Button fightButton;
    @FXML
    private Button runButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button sleepButton;
    @FXML
    private TextArea textArea;

    private ArrayList<ArrayList<Room>> maze;

    int row;

    int column;
    private Room room;

    private NPCMonster NPC;

    private playerCharacter character;
    @FXML
    private TextField NpcHitPoints;
    @FXML
    private TextField NpcStrength;
    @FXML
    private TextField NpcDexterity;
    @FXML
    private TextField NpcIntelligence;
    @FXML
    private TextField playerHitPoints;
    @FXML
    private TextField playerStrength;
    @FXML
    private TextField playerDexterity;
    @FXML
    private TextField playerIntelligence;
    @FXML
    private TextField playerTotalGold;

    @FXML
    public void buttonClicked(ActionEvent actionEvent) {
        if (actionEvent.getSource() == moveNorthButton) {
           textArea.appendText("Moved North!\n")  ;

                column++;
        } else if (actionEvent.getSource() == movesSouthButton) {
            textArea.appendText("Moved South!\n");
                column++;

        } else if (actionEvent.getSource() == moveWestButton) {
            textArea.appendText("Moved West!\n");

                row++;

        } else if (actionEvent.getSource() == moveEastButton) {
                row--;

        }
    }

    public void initialize() {
        textArea.setEditable(false);
        character = new playerCharacter(20, 1, 1, 1, 0);
        playerDexterity.setText("Dexterity: " + String.valueOf(character.getDexterity()));
        playerHitPoints.setText("Hit Points : " + String.valueOf(character.getHitPoints()));
        playerIntelligence.setText("Intelligence: " + String.valueOf(character.getIntelligence()));
        playerStrength.setText("Strength: " + String.valueOf(character.getStrength()));
        playerTotalGold.setText("total Gold: " + String.valueOf(character.getTotalGold()));
        maze = new ArrayList<>();
        for (int row = 0; row < 10; row++) {
            ArrayList<Room> mazeColumn = new ArrayList<>();
            for (int column = 0; column < 10; column++) {
                mazeColumn.add(new Room(true,false,100));
            }
            maze.add(mazeColumn);
                }
        row = 0;
        column = 0;
        room = maze.get(row).get(column);
        if(room.isNPC()){
            NPC = new  NPCMonster(1, 1, 1, 1);
            NpcHitPoints.setText("Hit Points : " + String.valueOf(NPC.getHitPoints()));
            NpcStrength.setText("Strength : " + String.valueOf(NPC.getStrength()));
            NpcDexterity.setText("Dexterity : " + String.valueOf(NPC.getDexterity()));
            NpcIntelligence.setText("Intelligence : " + String.valueOf(NPC.getIntelligence()));

        }else{
            NPC = null;
        }
        if(room.isBlocked());
            //moveNorthButton.setDisable(true);
            }

    @FXML
    public void fightButtonClicked(ActionEvent actionEvent) {
        int roll = (int)(Math.random() * 20) + 1;
        if (roll >= NPC.getDexterity()){
            textArea.appendText("You hit the monster!");
            NpcHitPoints.setText("Hit Points: "+String.valueOf((character.getStrength()/3)-NPC.getHitPoints()));
        } else if (NPC.getHitPoints() != 0) {
            playerHitPoints.setText("Hit Points : " + String.valueOf(character.getHitPoints()-NPC.getStrength()));
        }
        else {
            textArea.appendText("You cannot fight this monster!");
        }

    }

    @FXML
    public void runButtonClicked(ActionEvent actionEvent) {
        int roll = (int)(Math.random() * 20) + 1;
        if(roll < NPC.getIntelligence()){
            textArea.appendText("The Monster has seen you!");
            playerHitPoints.setText("Hit Points : " + String.valueOf(character.getHitPoints()-NPC.getStrength()));
        }else {
            textArea.appendText("You have ran away!");
        }
}

    @FXML
    public void sleepButtonClicked(ActionEvent actionEvent) {
        int npcSpawn = (int) (Math.random()*6 +1);
        if(npcSpawn == 3){
            textArea.appendText("A NPC has spawned \n");
            NPC = new NPCMonster(1, 1, 1, 1);
            NpcHitPoints.setText("Hit Points : " + String.valueOf(NPC.getHitPoints()));
            NpcStrength.setText("Strength : " + String.valueOf(NPC.getStrength()));
            NpcDexterity.setText("Dexterity : " + String.valueOf(NPC.getDexterity()));
            NpcIntelligence.setText("Intelligence : " + String.valueOf(NPC.getIntelligence()));
        }
        else{
            textArea.appendText("You are now sleeping you will regain your hit points but there is a chance a monster will come\n ");
            playerHitPoints.setText("Hit Points :"+ String.valueOf(character.getHitPoints()+ 20));
        }
    }

    @FXML
    public void searchButtonClicked(ActionEvent actionEvent) {
        int roll = (int)(Math.random() * 20) + 1;
        int addGold = room.getGold() + character.getTotalGold();
        character.setTotalGold(character.getTotalGold() + addGold);
        if (roll <= character.getIntelligence()){
            textArea.appendText("You have earned gold\n");
            playerTotalGold.setText("total Gold: " + String.valueOf(character.getTotalGold()));
        }else{
            textArea.appendText("You did not find anything!\n");
        }
    }
}







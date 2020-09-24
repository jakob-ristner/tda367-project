package model;

import java.util.ArrayList;
import java.util.List;

public class Game {


    private List<Player> playerList;
    private List<Kharacter> characterList;


    //private Board board;
    private int playerAmount;

    public Game() {

    }
    //Must it be private?
    public void createPlayers(int amountPlayers) {
        playerList = new ArrayList<>();
        for (int i = 0; i < amountPlayers; i++)
            playerList.add(new Player());
    }

    public void run() {

    }

    private void runCharacterSelectScreen() {
        //Temporary character select
        for (int i = 0; i < playerAmount; i++) {
            playerList.get(i).setCharacter(characterList.get(i));
        }
    }

    private void runStartScreen() {
        playerAmount = 4;
        createPlayers(playerAmount);
    }

    private void runGame() {
        for (Player player: playerList)
            turn(player);
    }

    private void turn(Player player) {

    }

    private void runGameOverScreen() {

    }
    //Must it be private?
    public void createCharaters() {
        characterList = new ArrayList<>();
        characterList.add(new Kharacter(3, 2, 6, 2, "Rufus Von Gross"));
        characterList.add(new Kharacter(3, 6, 2, 2, "Medera Caldovas"));
        characterList.add(new Kharacter(3, 3, 4, 3, "Sven Nordstadt"));
        characterList.add(new Kharacter(6, 2, 3, 2, "Sarah"));
    }
    public List<Kharacter> getCharacterList() {
        return characterList;
    }
    public List<Player> getPlayerList() {
        return playerList;
    }


}

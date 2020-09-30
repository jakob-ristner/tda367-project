package model;

import controller.GameObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class Game implements ControllerObservable{

    private List<GameObserver> observers;
    private List<Player> playerList;
    private List<Kharacter> characterList;



    private Board board;


   

    private int playerAmount;
    private GameState gameState;
    private int activePlayer;

    private int currentPlayerIndex;


    public Game() {

        board = new Board();

        observers = new ArrayList<>();
        createCharaters();
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
        createPlayers(playerAmount);
    }


    public int getPlayerAmount() {
        return playerAmount;
    }
    //Must it be private?
    public void createPlayers(int amountPlayers) {
        playerList = new ArrayList<>();
        for (int i = 0; i < amountPlayers; i++)
            playerList.add(new Player());
    }

    private void runCharacterSelectScreen() {
        //Temporary character select
        for (int i = 0; i < playerAmount; i++) {
            playerList.get(i).setCharacter(characterList.get(i));
        }
    }

    private void runGame() {
        for (Player player: playerList)
            turn(player);
    }

    private void turn(Player activePlayer) {
        int steps = activePlayer.rollStepsDice();

        while (steps > 0 ){
            //doorPickMethod
            //activePlayer.playerMove(doorPickMethod);
            if(getPlayerTile(activePlayer).hasEvent() && !activePlayer.isHaunted){
                getPlayerTile(activePlayer).activate();
            }
            if (gameState != null){
                gameState.turn(activePlayer,this);
            }
            steps--;
        }
        setNextPlayer();

    }
    private void setNextPlayer(){
        activePlayer++;
        if (activePlayer > playerAmount-1) activePlayer = 0;
        
    }
    private Player activePlayer(){
        return playerList.get(activePlayer);
    }

    private Tile getPlayerTile(Player player){
       return board.getFloor(player.getFloor()).getTile(player.getX(),player.getY());
    }

    public boolean roomContainsInsanePlayer(){
        return roomContainsInsanePlayer();
    }

    private void runGameOverScreen() {

    }
    //Must it be private?
    public void createCharaters() {

        HashMap<Stat, Integer> rufus = new HashMap<>();
        HashMap<Stat, Integer> medera = new HashMap<>();
        HashMap<Stat, Integer> sven = new HashMap<>();
        HashMap<Stat, Integer> sarah = new HashMap<>();

        rufus.put(Stat.STRENGTH, 2);
        rufus.put(Stat.STAMINA, 2);
        rufus.put(Stat.SPEED, 3);
        rufus.put(Stat.SANITY, 6);

        medera.put(Stat.STRENGTH, 6);
        medera.put(Stat.STAMINA, 2);
        medera.put(Stat.SPEED, 3);
        medera.put(Stat.SANITY, 2);

        sven.put(Stat.STRENGTH, 3);
        sven.put(Stat.STAMINA, 3);
        sven.put(Stat.SPEED, 3);
        sven.put(Stat.SANITY, 4);

        sarah.put(Stat.STRENGTH, 2);
        sarah.put(Stat.STAMINA, 2);
        sarah.put(Stat.SPEED, 6);
        sarah.put(Stat.SANITY, 6);

        characterList = new ArrayList<>();
        characterList.add(new Kharacter(rufus, "Rufus von gross"));
        characterList.add(new Kharacter(sven, "Sven Nordstadt"));
        characterList.add(new Kharacter(medera, "Medera Calvados"));
        characterList.add(new Kharacter(sarah, "Sarah"));





    }
    public List<String> getCharacterNames(){
        List<String> characterNames = new ArrayList<>();
        for(Kharacter a : characterList){
            characterNames.add(a.getName());
        }
        return characterNames;
    }
    public List<Kharacter> getCharacterList() {
        return characterList;
    }
    public List<Player> getPlayerList() {
        return playerList;
    }
    void turn(Player activePlayer, Event event){

    }

    public Player getCurrentPlayer(){
        return playerList.get(currentPlayerIndex);
    }

    public void updateCurrentPlayer(){
        currentPlayerIndex++;
        currentPlayerIndex = currentPlayerIndex % playerAmount;
        for (GameObserver observer : observers)
            observer.updateCurrentPlayer();
        if (currentPlayerIndex == 0)
            notifyNewTurn();
    }


    @Override
    public void registerObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyNewTurn() {
        for (GameObserver observer: observers) {
            observer.update();
        }
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public boolean checkAllPlayersHaveChars() {
        for (Player player : playerList)  {
            if (!player.hasCharacter)
                return false;
        }
        return true;
    }
}

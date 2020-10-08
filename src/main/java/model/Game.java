package model;

import controller.GameObserver;
import utilities.Coord;

import java.util.*;

public class Game implements ControllerObservable{

    private GameObserver observer;
    private List<Player> playerList;
    private List<Kharacter> characterList;
    private List<GameState> listOfHaunts = new ArrayList<>();
    GameState insanityHaunt;

    private Board board;
    private static Game gameInstance;

    private static boolean isInstanciated = false;

    private int playerAmount;
    private GameState gameState;

    private int currentPlayerIndex;
    private int eventCounter;
    private Random random = new Random();


    private Game() {
        board = new Board();
        listOfHaunts.add(new InsanityHauntState());
        createCharaters();
    }

    //SingeltonPattern
    public static Game getInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    public void initHaunt(){
        listOfHaunts.get(0).init();
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
        createPlayers(playerAmount);
    }
    private void eventTriggered(){
        eventCounter++;
        if(eventCounter == 8){
            gameState = getRandomHaunt();
        }
    }
    private GameState getRandomHaunt(){
        return listOfHaunts.get(random.nextInt(listOfHaunts.size()));
    }

    public int getPlayerAmount() {
        return playerAmount;
    }
    //Must it be private?
    public void createPlayers(int amountPlayers) {
        Player currPlayer;
        playerList = new ArrayList<>();
        for (int i = 0; i < amountPlayers; i++) {
            currPlayer = new Player();
            currPlayer.setPos(new Coord(i, 0, i));
            playerList.add(currPlayer);
        }
    }

    private void runCharacterSelectScreen() {
        //Temporary character select
        for (int i = 0; i < playerAmount; i++) {
            playerList.get(i).setCharacter(characterList.get(i));
        }
    }

    public void runGame() {
        for (Player player: playerList)
            turn(player);
    }

    private void turn(Player activePlayer) {
        /*
        activePlayer.setStepAmount();
        int steps = activePlayer.getStepAmount();

        while (steps > 0 ){
            //doorPickMethod
            //activePlayer.playerMove(doorPickMethod);
            //getPlayerTile(activePlayer).setHasPlayer(true);
            if(getPlayerTile(activePlayer).hasEvent() && activePlayer.isHaunted()){
                getPlayerTile(activePlayer).activate();
                eventTriggered();
            }
            if (gameState != null){
                gameState.turn(activePlayer);
            }
            removeDeadPlayersFromGame();
            steps--;
            if (!playerList.contains(activePlayer)) break;
        }


        updateCurrentPlayer();

         */

    }

    public void moveCurrentPlayer(int dx, int dy) {
        Player currentPlayer = getCurrentPlayer();
        if (currentPlayer.stepsLeft > 1) {
            currentPlayer.playerMove(dx, dy);
        } else {
            currentPlayer.resetSteps();
            updateCurrentPlayer();
        }
        notifyGameEvent();
    }

    public void removeDeadPlayersFromGame(){
        for (Player p: playerList){
            p.isPlayerDead();
            if(p.isDead()){
                playerList.remove(p);
                playerAmount--;
            }
        }
    }
   public Tile getPlayerTile(Player player){
       return board.getFloor(player.getFloor()).getTile(player.getX(),player.getY());
    }

    public boolean roomContainsInsanePlayer(){
        return roomContainsInsanePlayer();  //Why does it return itself??
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
    public List< HashMap<Stat, Integer>> getCharacterStats(){
        List< HashMap<Stat, Integer>> characterStats = new ArrayList<>();
        for(Kharacter a : characterList){
            characterStats.add(a.getStats());
        }
        return characterStats;
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
        if(currentPlayerIndex == playerAmount +1){ //TODO se om vi kan göra detta lite vackrare xD
            currentPlayerIndex--;
        }
        currentPlayerIndex = currentPlayerIndex % playerAmount;
        observer.updateCurrentPlayer();
        if (currentPlayerIndex == 0)
            notifyNewTurn();
    }


    @Override
    public void setObserver(GameObserver observer) {
        this.observer = observer;
    }

    @Override
    public void notifyNewTurn() { //TODO change to only one observer not list
        observer.updateTurn();
    }

    @Override
    public void notifyGameEvent() {
        observer.updateMapData();
    }

    @Override
    public void notifyGameStart() {
        observer.initMapData();
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

    public List<Coord> getPlayerPositions() {
        List<Coord> playerPositions = new ArrayList<>();
        for (Player player: playerList)
            playerPositions.add(player.getPos());
        return playerPositions;
    }

    public String getCurrentPlayersCharacterName() {
        return getCurrentPlayer().getCharacterName();
    }

    public List<String> getCurrentPlayerStatsAsStrings() {
        return getCurrentPlayer().getCharacterStatsAsStrings();
    }

    public Board getBoard(){
        return board;
    }

    public int getCurrentFloorNumber() {
        return getCurrentPlayer().getFloor();
    }

    public List<Integer> getPlayerIndicesOnCurrentFloor() {
        List<Integer> playerIndicesOnCurrentFloor = new ArrayList<>();
        for (int i = 0; i < playerAmount; i++) {
            if (playerList.get(i).getFloor() == getCurrentFloorNumber()) {
               playerIndicesOnCurrentFloor.add(i);
            }
        }
        return playerIndicesOnCurrentFloor;
    }

    public HashMap<Integer, Boolean> getCurrentTileDoors() {
        return board.getCurrentPlayerTileDoors(getPlayerPositions().get(getCurrentPlayerIndex()));
    }
}

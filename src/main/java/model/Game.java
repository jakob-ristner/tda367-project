package model;

import controller.EventObserver;
import controller.GameObserver;
import utilities.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game implements ControllerObservable {

    private static Game gameInstance;
    private static final boolean isInstanciated = false;
    private GameObserver observer;
    private List<Player> playerList;

    private List<Kharacter> characterList = KharacterFactory.getCharacters();
    private List<GameState> listOfHaunts = new ArrayList<>();
    private HashMap<String, Integer> staminaNameMap = new HashMap<>();

    private Board board;


    private int playerAmount;
    private GameState gameState;

    private int currentPlayerIndex;
    private int eventCounter;
    private Random random = new Random();

    //SingeltonPattern

    public void moveCurrentPlayer(int dx, int dy) {
        Player currentPlayer = getCurrentPlayer();
        if (currentPlayer.getStepsLeft() > 0) {
            currentPlayer.playerMove(dx, dy, 0);
            if(getPlayerTile(currentPlayer).hasStairDown()){
                currentPlayer.addCoord(new Coord(0,0,-1));
            }else if(getPlayerTile(currentPlayer).hasStairUp()) {
                currentPlayer.addCoord(new Coord(0,0,1));
            }
            board.tryActivateEventOnPlayerPos(currentPlayer); //As of now haunted players can not activate events.
        }
        removeDeadPlayersFromGame();
        hauntCheck();
        notifyGameData();

    }

    private void hauntCheck(){
        checkForHauntInit();
        if (gameState != null){
            gameState.turn(getCurrentPlayer());
        }

    }




   /*
    public boolean roomContainsInsanePlayer(){
        return roomContainsInsanePlayer();  //Why does it return itself??
    }

    */

    private void runGameOverScreen() {

    }
    //Must it be private?

    public List<String> getCharacterNames() {
        List<String> characterNames = new ArrayList<>();
        for (Kharacter a : characterList) {
            characterNames.add(a.getName());
        }
        return characterNames;
    }

    public String getHauntText(){
        return gameState.getHauntText();
    }

    public List<HashMap<Stat, Integer>> getCharacterStats() {
        List<HashMap<Stat, Integer>> characterStats = new ArrayList<>();
        for (Kharacter a : characterList) {
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

    public Player getCurrentPlayer() {
        return playerList.get(currentPlayerIndex);
    }

    public void updateCurrentPlayer() {
        getCurrentPlayer().resetSteps();
        currentPlayerIndex++;
        if (currentPlayerIndex == playerAmount + 1) { //TODO se om vi kan göra detta lite vackrare xD
            currentPlayerIndex--;
        }
        observer.updateCurrentPlayer();
        currentPlayerIndex = currentPlayerIndex % playerAmount;

        if (currentPlayerIndex == 0)
            notifyNewTurn();
    }

    public List<String> getHauntedNamesInSameRoom(){
        List<String> hauntedNameList = new ArrayList<>();
        for(Player p: createListOfPlayersInSameRoom()){ //Om du nånsin debuggar och hamnar här. Kontrollera så inte listan är tom
            if(p.isHaunted()){
                hauntedNameList.add(p.getCharacterName());
            }
        }
        return hauntedNameList;
    }

    public List<String> getNonHauntedNamesList(){
        List<String> nonHauntedNames = new ArrayList<>();
        for(Player p: createListOfPlayersInSameRoom()){  //Om du nånsin debuggar och hamnar här. Kontrollera så inte listan är tom
            if(!p.isHaunted()){
                nonHauntedNames.add(p.getCharacterName());
            }
        }
        return nonHauntedNames;
    }

    public HashMap<String, Integer> getDamageMap(){
        HashMap<String, Integer> damageMap = new HashMap<>();
        int damage;
        if (!staminaNameMap.isEmpty()) {
            for (Player p : createListOfPlayersInSameRoom()) {
                damage = Math.abs(staminaNameMap.get(p.getCharacterName()) - p.getCharacter().getStat(Stat.STAMINA));
                damageMap.put(p.getCharacterName(), damage);
            }
        }
        return damageMap;
    }
    public HashMap<String, Integer> getStaminaNameMap(){
        HashMap<String, Integer> staminaNameMap = new HashMap<>();
        for(Player p: createListOfPlayersInSameRoom()){
            staminaNameMap.put(p.getCharacterName(), p.getCharacter().getStat(Stat.STAMINA));
        }
        return staminaNameMap;
    }

   void saveOldStaminaMap(){
        staminaNameMap = getStaminaNameMap();
    }

    List<Player> createListOfPlayersInSameRoom() {
        List <Player> listOfPlayersInTheSameRoom = new ArrayList<>();
        for (Player p : getPlayerList()) {
            if (getCurrentPlayer().getX() == p.getX() && getCurrentPlayer().getY() == p.getY()) {
                listOfPlayersInTheSameRoom.add(p);
            }
        }
        return listOfPlayersInTheSameRoom;
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
    public void notifyGameData() {
        observer.updateMapData();
    }

    @Override
    public void notifyGameStart() {
        observer.initMapData();

    }

    @Override
    public void notifyHaunt() {
        observer.initHauntView();
    }

    @Override
    public void notifyCombat() {
        observer.initCombatScreen();
    }

    @Override
    public void notifyGameOver() {
        observer.initGameOverView();

    }

    public String getEventEffectText(){
        return board.getEventEffectText(getCurrentPlayer());
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public boolean checkAllPlayersHaveChars() {
        for (Player player : playerList) {
            if (!player.getHasCharacter())
                return false;
        }
        return true;
    }

    public List<Coord> getPlayerPositions() {
        List<Coord> playerPositions = new ArrayList<>();
        for (Player player : playerList)
            playerPositions.add(player.getPos());
        return playerPositions;
    }

    public String getCurrentPlayersCharacterName() {
        return getCurrentPlayer().getCharacterName();
    }

    public List<String> getCurrentPlayerStatsAsStrings() {
        return getCurrentPlayer().getCharacterStatsAsStrings();
    }

    public Board getBoard() {
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

    public int getCurrentPlayerStepsLeft() {
        return getCurrentPlayer().getStepsLeft();
    }

    public void endTurn() {
        removeDeadPlayersFromGame();
        checkForHauntInit();
        updateCurrentPlayer();
        notifyGameData();
    }

    public List<String> getCurrentPlayerItemsAsText() {
        return getCurrentPlayer().getItemNames();
    }

    public boolean currentPlayerHasCharacter() {
        return getCurrentPlayer().getHasCharacter();
    }

    public void setCurrentPlayersCharacter(int index) {
        getCurrentPlayer().setCharacter(characterList.get(index));
    }

    /**
     * singleton pattern
     * @return instance of game
     */
    public static Game getInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    /**
     * registers event observer
     * @param eventObserver
     */
    public void registerEventObserver(EventObserver eventObserver) {
        for (Event e : board.getEvents()) {
            e.setObserver(eventObserver);
        }
    }





    public void handleEvent() {
        Player currentPlayer = getCurrentPlayer();
        board.handleEvent(currentPlayer);
        eventTriggered();
        observer.updateMapData();
    }

    /**
     * Getter for the buttonText on the eventButton
     * @return String
     */
    public String getEventButtonText(){
        return board.getEventButtonText(getCurrentPlayer());
    }

    public void removeDeadPlayersFromGame() {
        List<Player> deadPlayers = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i ++) {
            if (playerList.get(i).isPlayerDead()) {
                deadPlayers.add(playerList.get(i));
            }
        }
        for (int i = 0; i < deadPlayers.size(); i++) {
            playerList.remove(deadPlayers.get(i));
            playerAmount--;
            if (currentPlayerIndex >= playerAmount)currentPlayerIndex--;
            /*
            if (playerAmount == 0) {
                playerAmount = 1;
            }

             */
        }
    }



    public Tile getPlayerTile(Player player) {
        return board.getFloor(player.getFloor()).getTile(player.getX(), player.getY());
    }

    public boolean roomContainsInsanePlayer() {
        return false;
    }


    private void initHaunt() {
        gameState.init();
    }

    /**
     * starts haunt if event counter reaches threshold
     */
    void eventTriggered() {
        eventCounter++;
    }

    private void checkForHauntInit(){
        if(eventCounter == 10217239 && gameState == null){
            gameState = getRandomHaunt();
            initHaunt();
            notifyHaunt();
        }
    }


     GameState getRandomHaunt() {
        return listOfHaunts.get(random.nextInt(listOfHaunts.size()));
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
        createPlayers(playerAmount);
    }

    int nonHauntedPlayersLeft(){
        int count = 0;
        for (Player player: playerList){
            if (!player.isHaunted())
                count++;
        }
        return count;
    }

    //Must it be private?
    void createPlayers(int amountPlayers) {
        Player currPlayer;
        playerList = new ArrayList<>();
        for (int i = 0; i < amountPlayers; i++) {
            currPlayer = new Player();
            currPlayer.setPos(new Coord(i, 0, 1));
            playerList.add(currPlayer);
        }
    }

    private Game() {
        board = new Board();
        listOfHaunts.add(new InsanityHauntState());
    }
    


    public void resetGame() { //TODO: discuss if this is the way we want to do it. If it is implement a method in controller which resets view.
        board = new Board();
        listOfHaunts.clear();
        listOfHaunts.add(new InsanityHauntState());

        playerList.clear();
        characterList.clear();
        characterList = KharacterFactory.getCharacters();
        eventCounter = 0;
    }

    public List<Coord> getStairsDownOnCurrentFloor() {
        return board.getStairsDownOnCurrentFloor(getCurrentFloorNumber());
    }

    public List<Coord> getStairsUpOnCurrentFloor() {
        return board.getStairsUpOnCurrentFloor(getCurrentFloorNumber());
    }
}

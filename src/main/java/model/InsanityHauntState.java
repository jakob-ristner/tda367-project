package model;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * InsanityHauntState is a GameState
 * Occurs after a player has triggered X amount of events
 * InsanityHauntState makes a player haunted, giving the haunted player the ability to attack other players.
 * The winCondition for the haunted player if all players is killed
 * The winCondition for the other players is finding a escapeHatch.
 */

public class InsanityHauntState implements GameState {
    Game game;
    int numEscapeHatch = 4;
    Random rand = new Random();
    HashMap<Stat, Integer> statBoost;
    private final String hauntText = "After wandering the house for too long your mind begins to break down." +
            "You hear whispers from the old gods telling you that only way to carry on is to betray your friends.\n " +
            "\n The rules for this haunt are written below: \n" +
            "\n The haunted players objective is to kill all the other players\n" +
            "\n The adventurers objective is to find a hidden escape hatch to escape the horrors of the house";


    public InsanityHauntState() {
        statBoost = new HashMap<>();
        statBoost.put(Stat.STRENGTH, 10);
        statBoost.put(Stat.SPEED, 5);
    }


    @Override
    public void init() {
        game = Game.getInstance();
        createEscapeHatches();
        setHauntedPlayer();

    }

    private void setHauntedPlayer() {
        game.getCurrentPlayer().setIsHaunted();
        game.getCurrentPlayer().getCharacter().updateStat(statBoost);
    }

    /**
     * The new turn when the state is activated
     *
     * @param activePlayer the current player.
     */
    @Override
    public void turn(Player activePlayer) {
        combat();
        winConditionChecker();
    }

    /**
     * Creates escapeHatches for the players that are not hunted.
     */
    private void createEscapeHatches() {
        Tile tile;
        int i = 0;
        while (i < numEscapeHatch) {
            tile = game.getBoard().getFloor(1).getTile(rand.nextInt(6), rand.nextInt(6));
            if (!tile.hasEvent()) {
                tile.setEvent(EventFactory.createEscapeEvent());
                i++;
            }
        }
    }

    /**
     * Logic for the combat between players during haunt
     */
    private void combat() {
        Player hauntedPlayer = null;
        List<Player> playersInRoom = game.createListOfPlayersInSameRoom();
        for (Player p : playersInRoom) {
            if (p.isHaunted()) {
                hauntedPlayer = p;
            }
        }
        playersInRoom.remove(hauntedPlayer);

        if (hauntedPlayer != null && !playersInRoom.isEmpty()) {
            game.saveOldStaminaMap();
            game.notifyCombat();
            for (Player p : playersInRoom) {
                int insanePlayerStrenght = hauntedPlayer.rollStat(Stat.STRENGTH);
                int playerInRoomStrenght = p.rollStat(Stat.STRENGTH);
                int damage = Math.max(0, insanePlayerStrenght - playerInRoomStrenght);
                p.getCharacter().updateStatFromCombat(Stat.STAMINA, damage);

            }
        }
    }

    /**
     * @return if the monster kills all players the game is won, return true.
     */
    @Override
    public boolean winConditionChecker() {
        if (game.getPlayerList().isEmpty() || (game.getPlayerList().size() == 1 && game.getPlayerList().get(0).isHaunted())) {
            game.notifyGameOver();
            return true;
        }
        return false;
    }

    @Override
    public String getHauntText() {
        return hauntText;
    }

}

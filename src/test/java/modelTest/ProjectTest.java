package modelTest;

import model.*;
import org.junit.Assert;
import org.junit.Test;



public class ProjectTest {

	/*
	@Test
	public void testRollDice(){
		Player player = new Player();

		player.setCharacter(new Kharacter(8,8,8,8,"Moana"));

		Assert.assertTrue(player.rollDice(Stat.STRENGTH,1));
			}
	 */


	@Test
	public void testCreateCharacters(){
		Game game = new Game();
		int size = 4;
		game.createPlayers(size);
		Assert.assertTrue(game.getCharacterList().size()==size);

	}
}

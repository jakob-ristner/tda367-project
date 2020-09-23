package modelTest;

import model.*;
import org.junit.Assert;
import org.junit.Test;



public class ProjectTest {


	@Test
	public void testRollDice(){
		Player player = new Player();

		player.setCharacter(new Kharacter(8,8,8,8,"Moana"));

		Assert.assertTrue(player.rollDice(Stat.STRENGTH,-1));
			}



	@Test
	public void testCreatePlayers(){
		Game game = new Game();
		int size = 4;
		game.createPlayers(size);
		Assert.assertTrue(game.getPlayerList().size()==size); //Four characters right now

	}
	@Test
	public void testCreateCharacters(){
		Game game  = new Game();
		int size = 4;
		game.createCharaters();
		Assert.assertTrue(game.getCharacterList().size()==4);
	}
	@Test
	public void testEquippingItem(){
		Player player = new Player();
		Kharacter character = new Kharacter(1,1,1,1,"Bengt");
		int startStrength = character.getStrength();
		Item sword = new Item("Sword", Stat.STRENGTH,5);
		player.setCharacter(character);
		player.addToInventory(sword);
		Assert.assertTrue(character.getStrength() == sword.getStatIncrease() + startStrength);

	}
}

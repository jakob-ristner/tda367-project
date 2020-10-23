package model;


import org.junit.Assert;
import org.junit.Test;

/**
 * True means that there is a door
 * False means that there is no door
 * When placed at (0,0) there is no door up or left which is tested.
 */
public class TestTile {
    @Test
    public void testAddTile() {
        int size = 6;
        Tile tile = new Tile(0, 0, size, size);
        Assert.assertFalse(tile.getDoors().get(0));
        Assert.assertFalse(tile.getDoors().get(3));
        Assert.assertTrue(tile.getDoors().get(1));
        Assert.assertTrue(tile.getDoors().get(2));
    }
}



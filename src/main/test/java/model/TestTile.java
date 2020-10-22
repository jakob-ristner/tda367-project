package model;


import org.junit.Assert;
import org.junit.Test;
public class TestTile {

    @Test
    public void testAddTile(){
        int size = 6;
        Tile tile = new Tile(0,0,size,size);
        Assert.assertFalse(tile.getDoors().get(0));
        Assert.assertFalse(tile.getDoors().get(3));
        Assert.assertTrue(tile.getDoors().get(1));
        Assert.assertTrue(tile.getDoors().get(2));
    }
}



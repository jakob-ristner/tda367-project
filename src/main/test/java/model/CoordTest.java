package model;

import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;


public class CoordTest {
    /**
     * Testing if getters works
     * Testing coords outside of the map (setFloor(5) is outside map 0-1-2-0-1-2->output 2
     * Testing lower limit aswell (floor -1) when adding.
     */
    @Test
    public void testSanityCheck() {
        Coord coord = new Coord(0, 0, 0);
        Assert.assertEquals(0, coord.getFloor());
        Assert.assertEquals(0, coord.getX());
        Assert.assertEquals(0, coord.getY());

        coord.setFloor(5);
        Assert.assertEquals(2, coord.getFloor());

        Coord deltaCoord = new Coord(0, 0, -1);
        coord.setFloor(0);
        coord.add(deltaCoord);
        Assert.assertEquals(0, coord.getFloor());
    }
}

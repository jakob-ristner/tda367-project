package modelTest;

import org.junit.Assert;
import org.junit.Test;
import utilities.Coord;

public class CoordTest {

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

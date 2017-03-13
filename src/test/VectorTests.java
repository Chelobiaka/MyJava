package test;
import core.Vector;
import org.junit.Test;
import static org.junit.Assert.*;


public class VectorTests {
    @Test
    public void length() {
        assertEquals(7.0, new Vector(2.0, 3.0, -6.0).length(), 1e-6);
    }

    @Test
    public void plus() {
        assertEquals(new Vector(3, -3.4, 21),
                new Vector(3, 7, 24).plus(new Vector(0, -10.4, -3)));
    }

    @Test
    public void minus() {
        assertEquals(new Vector(3, -10.8, 27),
                new Vector(3, -4.8, 24).minus(new Vector(0, 6, -3)));
    }

    @Test
    public void mult() {
        assertEquals(new Vector(0, 30, -15), new Vector(0, 6, -3).mult(5));
    }

    @Test
    public void scalarMult() {
        assertEquals(-100.8,
                new Vector(3, -4.8, 24).scalarMult(new Vector(0, 6, -3)), 1e-6);
    }
}

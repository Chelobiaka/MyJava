package test;
import core.Vector;
import org.junit.Test;
import static org.junit.Assert.*;


public class VectorTests {
    @Test
    public void length() {
        assertEquals(7, new Vector(2, 3, -6).length(), 1e-6);
        assertEquals(128, new Vector(127, 10, -9, -8, 3, -1).length(), 1e-6);
        assertEquals(7.5, new Vector(-6, 4, -2, 0.5).length(), 1e-6);
    }

    @Test
    public void plus() {
        assertEquals(new Vector(3, -3.4, 21),
                new Vector(3, 7, 24).plus(new Vector(0, -10.4, -3)));
        assertEquals(new Vector(-63, 10.394, -309, -9.5, 1.823),
                new Vector(12, 4.27, -301, 5.9, 5).plus
                        (new Vector(-75, 6.124, -8, -15.4, -3.177)));
        assertEquals(new Vector(13.6, -20, 158.8, 28.4),
                new Vector(-41.4, 65, 94.6, 44.2).plus(new Vector(55.0, -85, 64.2, -15.8)));
    }

    @Test
    public void minus() {
        assertEquals(new Vector(3, -10.8, 27),
                new Vector(3, -4.8, 24).minus(new Vector(0, 6, -3)));
        assertEquals(new Vector(87, -1.854, -293, 21.3, 8.177),
                new Vector(12, 4.27, -301, 5.9, 5).minus
                        (new Vector(-75, 6.124, -8, -15.4, -3.177)));
        assertEquals(new Vector(-96.4, 150, 30.4, 60),
                new Vector(-41.4, 65, 94.6, 44.2).minus(new Vector(55.0, -85, 64.2, -15.8)));
    }

    @Test
    public void mult() {
        assertEquals(new Vector(0, 30, -15), new Vector(0, 6, -3).mult(5));
        assertEquals(new Vector(364, -1.05), new Vector(52, -0.15).mult(7));
        assertEquals(new Vector(-2.896, -25.84, 125.2, -2.04),
                new Vector(7.24, 64.6, -313, 5.1).mult(-0.4));
    }

    @Test
    public void scalarMult() {
        assertEquals(-100.8,
                new Vector(3, -4.8, 24).scalarMult(new Vector(0, 6, -3)), 1e-6);
        assertEquals(1427.40448, new Vector(12, 4.27, -301, 5.9, 5)
                .scalarMult(new Vector(-75, 6.124, -8, -15.4, -3.177)), 1e-6);
        assertEquals(18927.8425,
                new Vector(52, 0.15).scalarMult(new Vector(364, -1.05)), 1e-6);
    }
}

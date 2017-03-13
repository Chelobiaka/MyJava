package core;

public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Vector) {
            Vector other = (Vector) o;
            return (Math.abs(x - other.x) < 1e-10) && (Math.abs(y - other.y) < 1e-10)
                    && (Math.abs(z - other.z) < 1e-10);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(z);
        return result;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector plus(Vector other) {
        return new Vector(x + other.x, y + other.y, z + other.z);
    }

    public Vector minus(Vector other) {
        return new Vector(x - other.x, y - other.y, z - other.z);
    }

    public Vector mult(double k) {
        return new Vector(k * x, k * y, k * z);
    }

    public double scalarMult(Vector other) {
        return (x * other.x + y * other.y + z * other.z);
    }
}

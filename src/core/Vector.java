package core;

import java.util.ArrayList;
import java.util.Arrays;

public class Vector {
    private double[] coords;

    public Vector(double ... coords) {
        this.coords = coords;
    }

    public double getCoord(int index) {
        return coords[index];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (double coord : coords) {
            s.append(coord);
            s.append(";");
        }
        s.deleteCharAt(s.length() - 1);
        return s.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Vector) {
            Vector other = (Vector) o;
            if (coords.length != other.coords.length) return false;
            for (int i = 0; i < coords.length; i++) {
                for (int j = 0; j < other.coords.length; j++) {
                    if ((i == j) && (Math.abs(coords[i] - other.coords[j]) > 1e-10)) return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coords);
    }

    public double length() {
        double l = 0;
        if (coords.length < 2) throw new IllegalArgumentException("Недостаточная размерность вектора");
        for (double coord : coords) {
            l += coord * coord;
        }
        return Math.sqrt(l);
    }

    public Vector plus(Vector other) {
        if ((coords.length < 2) || (other.coords.length < 2))
            throw new IllegalArgumentException("Недостаточная размерность векторов");
        if (coords.length != other.coords.length) throw new IllegalArgumentException
                ("Сложение векторов разной размерности невозможно");
        ArrayList<Double> vList = new ArrayList<>();
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < other.coords.length; j++) {
                if (i == j) vList.add(coords[i] + other.coords[j]);
            }
        }
        return new Vector(vList.stream().mapToDouble(d -> d).toArray());
    }

    public Vector minus(Vector other) {
        if ((coords.length < 2) || (other.coords.length < 2))
            throw new IllegalArgumentException("Недостаточная размерность векторов");
        if (coords.length != other.coords.length) throw new IllegalArgumentException
                ("Вычитание векторов разной размерности невозможно");
        ArrayList<Double> vList = new ArrayList<>();
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < other.coords.length; j++) {
                if (i == j) vList.add(coords[i] - other.coords[j]);
            }
        }
        return new Vector(vList.stream().mapToDouble(d -> d).toArray());
    }

    public Vector mult(double k) {
        int i;
        if (coords.length < 2) throw new IllegalArgumentException("Недостаточная размерность вектора");
        for (i = 0; i < coords.length; i++) {
            coords[i] *= k;
        }
        return new Vector(coords);
    }

    public double scalarMult(Vector other) {
        if ((coords.length < 2) || (other.coords.length < 2))
            throw new IllegalArgumentException("Недостаточная размерность векторов");
        if (coords.length != other.coords.length) throw new IllegalArgumentException
                ("Невозможно найти скалярное произведение векторов разной размерности");
        double m = 0;
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < other.coords.length; j++) {
                if (i == j) m += coords[i] * other.coords[j];
            }
        }
        return m;
    }

}

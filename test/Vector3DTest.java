import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class Vector3DTest {
    private Vector3D vector;

    @BeforeEach
    void setup(){
        vector = new Vector3D(1.00, 2.00, 3.00);
    }

    @org.junit.jupiter.api.Test
    void getX() {
        assertEquals(1.00, vector.getX());
    }

    @org.junit.jupiter.api.Test
    void getY() {
        assertEquals(2.00, vector.getY());
    }

    @org.junit.jupiter.api.Test
    void getZ() {
        assertEquals(3.00, vector.getZ());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = "(1.00, 2.00, 3.00)";
        assertEquals(expected, vector.toString(), "String representation must match.");
    }

    @org.junit.jupiter.api.Test
    void getMagnitude() {
        double expected = Math.sqrt((1.00 * 1.00) + (2.00 * 2.00) + (3.00 * 3.00));
        assertEquals(expected, vector.getMagnitude(vector.getX(), vector.getY(), vector.getZ()));
    }

    @org.junit.jupiter.api.Test
    void normalize() {
        Vector3D normalizedVector = vector.normalize();
        double magnitude = normalizedVector.getMagnitude(normalizedVector.getX(), normalizedVector.getY(), normalizedVector.getZ());
        assertEquals(1.0, magnitude, 0.01, "Normalized vector must have a magnitude of 1.");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Vector3D other = new Vector3D(1.00, 2.00, 3.00);
        Vector3D resultVector = vector.add(other);
        assertEquals(new Vector3D(2.0, 4.0, 6.0), resultVector, "Addition must be exact and on point.");
    }

    @org.junit.jupiter.api.Test
    void multiply() {

    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
    }

    @org.junit.jupiter.api.Test
    void angleBetween() {
    }

    @org.junit.jupiter.api.Test
    void crossProduct() {
    }
}
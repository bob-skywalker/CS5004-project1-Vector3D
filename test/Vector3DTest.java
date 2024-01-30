import org.junit.jupiter.api.BeforeEach;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Vector3DTest {
    private Vector3D vector, vectorB, vectorC;

    @BeforeEach
    void setup(){
        vector = new Vector3D(1.00, 2.00, 3.00);
        vectorB = new Vector3D(-1.374, 2.394, 0);
        vectorC = new Vector3D(1.876, -2.582, -3.384);
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
        double demoConstant = 2.00;
        Vector3D resultVector = vector.multiply(demoConstant);
        Vector3D other = new Vector3D(2.00, 4.00, 6.00);
        assertEquals(resultVector, other, "Vectors must have the same x, y, z values");
    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
        Vector3D other = new Vector3D(2.00, 3.00, 4.00);
        double expectedResult = 2.00 + 6.00 + 12.00;
        assertEquals(expectedResult, vector.dotProduct(other), "Dot product must equals exactly as the expected result.");
    }

    @org.junit.jupiter.api.Test
    void angleBetween() {
        Vector3D otherVector = new Vector3D(4.0, 5.0, 6.0);
        double angle = vector.angleBetween(otherVector);
        double expectedAngle = 12.933154491899135;
        assertEquals(expectedAngle, angle, 0.001, "Angle between vectors must be calculated correctly.");
    }

    @org.junit.jupiter.api.Test
    void crossProduct() {
        Vector3D other = new Vector3D(2.0, 3.0, 4.0);
        Vector3D otherBC = new Vector3D(-8.101, -4.65, -0.943);
        double actualX = vector.getY() * other.getZ() - vector.getZ() * other.getY();
        double actualY = vector.getZ() * other.getX() - vector.getX() * other.getZ();
        double actualZ = vector.getX() * other.getY() - vector.getY() * other.getX();
        assertTrue(otherBC.equals(vectorB.crossProduct(vectorC)));
        Vector3D acutalVector3D = new Vector3D(actualX, actualY, actualZ);
        assertEquals(acutalVector3D, new Vector3D(-1.00, 2.00, -1.00));
    }
}
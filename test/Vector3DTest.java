import org.junit.jupiter.api.BeforeEach;
import project01.Vector3D;

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
        assertEquals(-1.374, vectorB.getX());
        assertEquals(1.876, vectorC.getX());
    }

    @org.junit.jupiter.api.Test
    void getY() {
        assertEquals(2.00, vector.getY());
        assertEquals(2.394, vectorB.getY());
        assertEquals(-2.582, vectorC.getY());
    }

    @org.junit.jupiter.api.Test
    void getZ() {
        assertEquals(3.00, vector.getZ());
        assertEquals(0, vectorB.getZ());
        assertEquals(-3.384, vectorC.getZ());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = "(1.00, 2.00, 3.00)";
        String expectedB = "(-1.37, 2.39, 0.00)";
        String expectedC = "(1.88, -2.58, -3.38)";
        assertEquals(expected, vector.toString(), "String representation must match.");
        assertEquals(expectedB, vectorB.toString(), "String representation must match.");
        assertEquals(expectedC, vectorC.toString(), "String representation must match.");
    }

    @org.junit.jupiter.api.Test
    void getMagnitude() {
        double expected = Math.sqrt((1.00 * 1.00) + (2.00 * 2.00) + (3.00 * 3.00));
        double expectedB = Math.sqrt(Math.pow(-1.374, 2) + Math.pow(2.394, 2) + Math.pow(0.00, 2));
        double expectedC = Math.sqrt(Math.pow(1.876,2) + Math.pow(-2.582, 2) + Math.pow(-3.384, 2));
        assertEquals(expected, vector.getMagnitude(vector.getX(), vector.getY(), vector.getZ()));
        assertEquals(expectedB, vectorB.getMagnitude(vectorB.getX(), vectorB.getY(), vectorB.getZ()));
        assertEquals(expectedC, vectorC.getMagnitude(vectorC.getX(), vectorC.getY(), vectorC.getZ()));
    }

    @org.junit.jupiter.api.Test
    void normalize() {
        Vector3D normalizedVector = vector.normalize();
        Vector3D normalizedVectorB = vectorB.normalize();
        Vector3D normalizedVectorC = vectorC.normalize();
        double magnitude = normalizedVector.getMagnitude(normalizedVector.getX(), normalizedVector.getY(), normalizedVector.getZ());
        double magnitudeB = normalizedVectorB.getMagnitude(normalizedVectorB.getX(), normalizedVectorB.getY(), normalizedVectorB.getZ());
        double magnitudeC = normalizedVectorC.getMagnitude(normalizedVectorC.getX(), normalizedVectorC.getY(), normalizedVectorC.getZ());
        assertEquals(1.0, magnitude, 0.001, "Normalized vector must have a magnitude of 1.");
        assertEquals(1.0, magnitudeB, 0.001, "Normalized vector must have a magnitude of 1.");
        assertEquals(1.0, magnitudeC,0.001, "Normalized vector must have a magnitude of 1.");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Vector3D other = new Vector3D(1.00, 2.00, 3.00);
//        vectorB = new Vector3D(-1.374, 2.394, 0);
//        vectorC = new Vector3D(1.876, -2.582, -3.384);
        Vector3D resultVector = vector.add(other);
        Vector3D resultVectorB = vectorB.add(other);
        Vector3D resultVectorC = vectorC.add(other);

        assertEquals(new Vector3D(2.0, 4.0, 6.0), resultVector, "Addition must be exact and on point.");
        assertEquals(new Vector3D(-0.374, 4.394, 3.00), resultVectorB, "Addition must be exact and on point.");
        assertEquals(new Vector3D(2.876, -0.582, -0.384), resultVectorC, "Addition must be exact and on point.");
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        double demoConstant = 2.00;
        // vectorB = new Vector3D(-1.374, 2.394, 0);
        // vectorC = new Vector3D(1.876, -2.582, -3.384);
        Vector3D resultVector = vector.multiply(demoConstant);
        Vector3D resultVectorB = vectorB.multiply(demoConstant);
        Vector3D resultVectorC = vectorC.multiply(demoConstant);


        Vector3D other = new Vector3D(2.00, 4.00, 6.00);
        Vector3D otherB = new Vector3D(-2.748, 4.788, 0.00);
        Vector3D otherC = new Vector3D(3.752, -5.164, -6.768);
        assertEquals(resultVector, other, "Vectors must have the same x, y, z values");
        assertEquals(resultVectorB, otherB, "Vectors must have the same x, y, z values");
        assertEquals(resultVectorC, otherC, "Vectors must have the same x, y, z values");
    }

    @org.junit.jupiter.api.Test
    void dotProduct() {
        // vectorB = new Vector3D(-1.374, 2.394, 0);
        // vectorC = new Vector3D(1.876, -2.582, -3.384);
        Vector3D other = new Vector3D(2.00, 3.00, 4.00);
        double expectedResult = 2.00 + 6.00 + 12.00;
        double expectedResultB = -2.748 + 7.182 + 0.00;
        double expectedResultC = 3.752 - 7.746 - 13.536;
        assertEquals(expectedResult, vector.dotProduct(other), "Dot product must equals exactly as the expected result.");
        assertEquals(expectedResultB, vectorB.dotProduct(other), "Dot product must equals exactly as the expected results.");
        assertEquals(expectedResultC, vectorC.dotProduct(other), "Dot product must equals exactly as the expected results.");
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
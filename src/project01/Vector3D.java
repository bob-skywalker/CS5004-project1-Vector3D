import java.util.Objects;
import java.util.Vector;


/**
 * Represents a 3-dimensional vector.
 */
public class Vector3D {
    private double x, y, z;

    /**
     * Constructs a new Vector3D instance.
     * @param x The x-component of the vector.
     * @param y The y-component of the vector.
     * @param z The z-component of the vector.
     */
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Return the x-component of the vector.
     * @return the x-component.
     */
    public double getX(){
        return this.x;
    }

    /**
     * Return the y-component of the vector.
     * @return the y-component.
     */
    public double getY(){
        return this.y;
    }

    /**
     * Return the z-component of the vector.
     * @return the z-component.
     */
    public double getZ(){
        return this.z;
    }

    /**
     * Returns a string representation of the vector in the format "(x, y, z)" format,
     * with each component rounede to 2 decimal places.
     * @return The string representation of the vector.
     */
    @Override
    public String toString(){
        String formattedX = String.format("%.2f", this.x);
        String formattedY = String.format("%.2f", this.y);
        String formattedZ = String.format("%.2f", this.z);

        return String.format("(%s, %s, %s)", formattedX, formattedY, formattedZ);
    }

    /**
     * Returns the magnitude of the vector.
     * @param x input the x-component of the vector.
     * @param y input the y-component of the vector.
     * @param z input the z-component of the vector.
     * @return The magnitutde of the vector.
     */
    public double getMagnitude(double x, double y, double z){
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }


    /**
     * Normalizes the vector to a unit vector and returns the result as a new Vector3D instance.
     * @return  a new Vector3D instance representing the normalized vector.
     * @throws IllegalStateException If the vector is a zero vector and cannot be normalized.
     */
    public Vector3D normalize() throws IllegalStateException{
        double magnitutde = getMagnitude(this.x, this.y, this.z);

        if (magnitutde == 0){
            throw  new IllegalStateException("Cannot normalize a zero vector.");
        }

        return new Vector3D(x / magnitutde, y / magnitutde, z /magnitutde);
    }


    /**
     * Adds this vector to another vector and returns the result as a new Vector3D instance.
     * @param other The vector to add to this vector.
     * @return A new Vector3D instance representing the sum of the two vectors.
     */
    public Vector3D  add(Vector3D other){
        double newX = this.x + other.x;
        double newY = this.y + other.y;
        double newZ = this.z + other.z;

        return new Vector3D(newX, newY, newZ);
    }

    /**
     * Multiplies this vector by a scalar and returns the result as a new Vector3D instance.
     * @param constant the Scalar to multiply the vector by.
     * @return a New Vector3D
     */
    public Vector3D multiply(double constant){
        double newX = this.x * constant;
        double newY = this.y * constant;
        double newZ = this.z * constant;

        return new Vector3D(newX, newY, newZ);

    }

    /**
     * Calculate the dot product of this vector with another vector.
     * @param other the vector to perform the dot product with.
     * @return The dot product of the two vectors.
     */
    public double dotProduct(Vector3D other){
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    /**
     * Calculates the angle between this vector and another vector in degrees.
     * @param other The vevtor to calculate the angle with.
     * @return The angle between the two vectors in degrees.
     * @throws IllegalStateException If either vector is zero vector or if a numerical error occurs.
     */
    public double angleBetween(Vector3D other) throws IllegalStateException{
        double dotProductRes = dotProduct(other);
        double thisMagnitude = getMagnitude(this.x, this.y, this.z);
        double otherMagnitude = getMagnitude(other.x, other.y, other.z);



        if (thisMagnitude == 0 || otherMagnitude == 0) {
            throw new IllegalStateException("Magnitude Value cannot be zero.");
        }

        double cosTheata = dotProductRes / (thisMagnitude * otherMagnitude);

        if (cosTheata > 1 || cosTheata < -1) {
            throw new IllegalStateException("Numerical error: cosTheata out of [-1, 1] range due to floating-point inaccuracy.");
        }

        double angleRadians = Math.acos(cosTheata);
        return Math.toDegrees(angleRadians);
    }

    /**
     * Calculates the cross product of this vector with another vector
     * @param other tbe vector to perform crossProduct method with
     * @return a new Vector3D instance with the newly calculated x, y, z arguments.
     */
    public Vector3D crossProduct(Vector3D other) {
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;

        return new Vector3D(crossX, crossY, crossZ);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)  return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vector3D vector = (Vector3D) obj;
        return Double.compare(vector.x, x) == 0 &&
                Double.compare(vector.y, y) == 0 &&
                Double.compare(vector.z, z) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y, z);
    }
}

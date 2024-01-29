public class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getX(){
        return String.format("X value is: %.2f", this.x);
    }

    public String getY(){
        return String.format("X value is: %.2f", this.y);
    }

    public String getZ(){
        return String.format("X value is: %.2f", this.z);
    }

    @Override
    public String toString(){
        String formattedX = String.format("%.2f", this.x);
        String formattedY = String.format("%.2f", this.y);
        String formattedZ = String.format("%.2f", this.z);

        return String.format("(%s, %s, %s)", formattedX, formattedY, formattedZ);
    }

    public double getMagnitude(double x, double y, double z){
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector3D normalize() throws IllegalStateException{
        double magnitutde = getMagnitude(this.x, this.y, this.z);

        if (magnitutde == 0){
            throw  new IllegalStateException("Cannot normalize a zero vector.");
        }

        return new Vector3D(x / magnitutde, y / magnitutde, z /magnitutde);
    }

    public String add(Vector3D other){
        double newX = this.x + other.x;
        double newY = this.y + other.y;
        double newZ = this.z + other.z;

        String formattedX = String.format("%.2f", newX);
        String formattedY = String.format("%.2f", newY);
        String formattedZ = String.format("%.2f", newZ);

        return String.format("(%s, %s, %s)", formattedX, formattedY, formattedZ);
    }

    public String multiply(double constant){
        double newX = this.x * constant;
        double newY = this.y * constant;
        double newZ = this.z * constant;

        String formattedX = String.format("%.2f", newX);
        String formattedY = String.format("%.2f", newY);
        String formattedZ = String.format("%.2f", newZ);

        return String.format("(%s, %s, %s)", formattedX, formattedY, formattedZ);

    }

    public double dotProduct(Vector3D other){
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

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

    public Vector3D crossProduct(Vector3D other) {
        double crossX = this.y * other.z - this.z * other.y;
        double crossY = this.z * other.x - this.x * other.z;
        double crossZ = this.x * other.y - this.y * other.x;

        return new Vector3D(crossX, crossY, crossZ);
    }
}

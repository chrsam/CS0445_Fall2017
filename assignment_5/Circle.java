import java.awt.geom.Point2D;

// does compile

public class Circle {

  private double x;
  private double y;
  private double radius;

  public Circle(double x, double y, double radius) {
    this.radius = radius;
    this.x = x;
    this.y = y;
  }

  public Point2D.Double getLocation() {
    return new Point2D.Double(x, y);
  }

  public double getRadius() {
    return radius;
  }

  public int hashCode() {
    Double total = x + y + radius;
    String hashString = total.toString();
    return hashString.hashCode();
  }
}

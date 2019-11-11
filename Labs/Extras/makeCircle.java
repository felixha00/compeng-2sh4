
public class makeCircle {

    public static void main (String[] args){
        Circle c = new Circle(3.5,65,7);

        int a = c.getX();
        int b = c.getY();
        double r = c.getRadius();

        Point p = new Point(65, 7);
        System.out.println(c.toString());
        System.out.println(p.toString());

    }
}
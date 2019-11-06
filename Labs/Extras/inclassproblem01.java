import org.graalvm.compiler.replacements.nodes.PureFunctionMacroNode;

public class myCircle {
    private double radius;
    private Point centre;

    public myCircle (double r, int x, int y){
        this.radius = r;
        this.centre = new Point(x,y);
    }

    public myCircle (double r){
        this.radius = r;
        this.centre = new Point(0,0);
        
    }

    public double getRadius (){
        return this.radius;
    }
    
    public int getX(){
        return this.centre.x;
    }

    public int getY(){
        return this.centre.y;
    }

    public Point getCenter(){
        return new Point(this.centre.getX(), this.centre.getY());
    }

    public boolean isTangTo(myCircle c){
        
    }

    public static void main(String[] args) {

    }
}
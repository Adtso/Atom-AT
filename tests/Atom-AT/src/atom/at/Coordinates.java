package atom.at;

public class Coordinates {
    public double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
        
    public boolean iguals(Coordinates c2) {
        return x == c2.x && y == c2.y;         
    }
        
    public double distancia(Coordinates c2) {
        return Math.sqrt(Math.pow((c2.x - x), 2) - Math.pow((c2.y - y), 2));
    }
}

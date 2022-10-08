package atom.at;

import robocode.*;

public class AtomAT extends AdvancedRobot{
        
    public void run() {
        ahead(100);
    }
    
    class DistCoordOcupat {
        boolean ocupat;
        double dist;
        Coordinates coord;
    };
    
    public DistCoordOcupat[] corners_mes_propers(Coordinates c)
    {
        //new Coord (2, 0);
        Coordinates[] corners = {
            new Coordinates (0, 0),
            new Coordinates (0, getBattleFieldHeight()),
            new Coordinates (getBattleFieldWidth(), 0),
            new Coordinates (getBattleFieldWidth(), getBattleFieldHeight())
        };
            
        DistCoordOcupat[] opcions = null;
        
        for (int i = 0; i < 4; i++) {
            opcions[i].dist = c.distancia(corners[i]);
            opcions[i].coord = corners[i];
            opcions[i].ocupat = false;
        }
        
        return opcions;
    }
    
}

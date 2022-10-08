package atom.at;

import robocode.*;
import java.util.Arrays;

public class AtomAT extends AdvancedRobot{ // Actua com a lider (crea array de opciones y envia su estado a compañeros).
    
    DistCoordOcupat[] array_opcions = null;
    Coordinates pos_actual = new Coordinates(getX(), getY());
           
    public void run() {
        cornersMesPropers(pos_actual, array_opcions);    
        
        // Girar correctamente Robot.
        ahead(array_opcions[0].dist); // Avanza a las coordenadas indicadas.
        array_opcions[0].ocupat = true;
        
        // Envia indicacion de que las coordenadas del array_opcions estan ocupadas.
    }
    
    class DistCoordOcupat {
        boolean ocupat;
        double dist;
        Coordinates coord;
    };
    
    public void cornersMesPropers(Coordinates c, DistCoordOcupat[] opcions)
    {
        Coordinates[] corners = {
            new Coordinates (0, 0),
            new Coordinates (0, getBattleFieldHeight()),
            new Coordinates (getBattleFieldWidth(), 0),
            new Coordinates (getBattleFieldWidth(), getBattleFieldHeight())
        };
                   
        for (int i = 0; i < 4; i++) {
            opcions[i].dist = c.distancia(corners[i]);
            opcions[i].coord = corners[i];
            opcions[i].ocupat = false;
        }
        
        Arrays.sort(opcions); // Ordenamos el array de opciones (distancia mas cercana a distancia mas lejana).
    }
    
}

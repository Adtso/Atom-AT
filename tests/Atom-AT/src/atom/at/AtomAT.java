package atom.at;

import robocode.*;

import java.util.Arrays;
import java.awt.*;
import java.io.IOException;

public class AtomAT extends TeamRobot{ // Actua com a lider (crea array de opciones y envia su estado a compañeros).
    
    DistCoordOcupat[] array_opcions = null;
    Coordinates pos_actual = new Coordinates(getX(), getY());

    public void onScannedRobot(ScannedRobotEvent e) {
		// No disparar a companys d'equip
		if (isTeammate(e.getName())) {
			return;
		}
		// Calcular direccio enemic
		double enemyBearing = this.getHeading() + e.getBearing();
		// Caalcular posicio enemic
		double enemyX = getX() + e.getDistance() * Math.sin(Math.toRadians(enemyBearing));
		double enemyY = getY() + e.getDistance() * Math.cos(Math.toRadians(enemyBearing));

		try {
			// Enviar posicio d'enemic a equip
            Point enemy = new Point (enemyX, enemyY);
			broadcastMessage(enemy);
		} catch (IOException ex) {
			out.println("Unable to send order: ");
			ex.printStackTrace(out);
		}
	}
           
    public void run() {
        cornersMesPropers(pos_actual, array_opcions);    
        
        // Girar correctamente Robot.
        //while (true){
            ahead(array_opcions[0].dist); // Avanza a las coordenadas indicadas segun la distancia calculada.
            // array_opcions[0].ocupat = true;
        //}
        
        // Envia indicacion al resto de robots de que las coordenadas del array_opcions estan ocupadas.
        
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

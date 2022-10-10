package atom.at;

import robocode.*;

import java.util.Arrays;
import java.awt.*;
import java.io.IOException;
import java.awt.geom.Point2D;

public class Soldier extends TeamRobot{
    
    public void run(){
        //preparem el color dels soldats
            setBodyColor(Color.green);
            setGunColor(Color.green);
            setRadarColor(Color.yellow);
            setScanColor(Color.red);
            setBulletColor(Color.red);
        //envia coordenades
            enviaCoords();
    }
    
    public void enviaCoords() {
        
        String team[] = getTeammates();
        try {
            sendMessage("atom.at.Leader02",new Coordinates(getX(),getY()));
            out.println("missatge enviat");
        } catch (IOException error) {
            out.println("no s'ha enviat el missatge: ");
            error.printStackTrace(out);
        }
    }
}

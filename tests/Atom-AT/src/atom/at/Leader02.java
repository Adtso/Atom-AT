package atom.at;

import robocode.*;

import java.util.Arrays;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;


public class Leader02 extends TeamRobot{
    
    //array per guardar les coordenades de cada soldier
    Coordinates[] array_coordenadas = new Coordinates[4];
    String[] array_senders = new String[4];
    int i_coorS = 0;
    
    public void run() {
        //preparem el color del lider
            setBodyColor(Color.white);
            setGunColor(Color.green);
            setRadarColor(Color.yellow);
            setScanColor(Color.red);
            setBulletColor(Color.red);
            
    }
    
    //al rebre un missatge de coordenades les guardem
    public void onMessageReceived (MessageEvent e) {
        out.println("missatge rebut de " + e.getSender());
        array_coordenadas[i_coorS] = (Coordinates) e.getMessage();
        array_senders[i_coorS] = e.getSender();
        i_coorS++;
        out.println(i_coorS);
        coordenador();
    }
    
    public void coordenador() {
        if (i_coorS == 4) {
                for (int i = 0; i < 4; i++) {
                    out.println(array_senders[i] + 
                                " en X:" + array_coordenadas[i].coordX() + 
                                " Y:" + array_coordenadas[i].coordY());
                }
            }
    }
}

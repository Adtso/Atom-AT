package atom.at;

import robocode.*;
import java.awt.*;
import java.io.IOException;

/**
 * Robot that emulates a hive mind, no real leader, all think together
 * @author Aitor
 */
public class wasp extends TeamRobot{
    
    public void run() {
        /**
         * Prepare robot colors
         */
            setBodyColor(Color.yellow);
            setGunColor(Color.black);
            setRadarColor(Color.yellow);
            setScanColor(Color.red);
            setBulletColor(Color.red);
    }
}

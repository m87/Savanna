/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

/**
 *
 * @author Bartosz Radliński
 */
/**
 * Klasa obiektu pustego - "ducha"
 */
class Ghost extends Terrain {

    static private String spName = ISettings.BLANK;

    Ghost(Board scene) {
        super(scene, spName);
        this.setType(3);


    }
}

/**
 * Klasa Markera
 */
class Marker extends Terrain {

    static private String spName = ISettings.MARKER;

    Marker(Board scene) {
        super(scene, spName);
        this.setType(3);


    }

    /**
     * Uauwanie markera z mapy 
     */
    public static void removeMarker(Board scene) {

        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                Ghost m = new Ghost(scene);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                Board.setTemp_fields(i, j, m);
            }
        }
    }
}

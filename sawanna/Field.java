/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

/**
 *
 * @author Bartosz Radliński
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Field extends Point {

    /**
     * Ustawienie szerokości pola
     */
    static private int width = ISettings.FIELD_SIZE;
    /**
     * Ustawienie wydokosci pola
     */
    static private int height = ISettings.FIELD_SIZE;

    /**
     * @return the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public static int getHeight() {
        return height;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param aType the type to set
     */
    public void setType(int aType) {
        type = aType;
    }
    /**
     * Nazwa pliku z obrazem
     */
    private String spriteName;
    /**
     * Miejsce gdzie rysować
     */
    private Board scene;
    private SpriteData spriteData;
    /**
     * Blokowanie pola
     */
    private boolean blocked = false;
    /**
     * Typ pola
     */
    private static int type;

    public Field(Board scene) {
        this.scene = scene;
        spriteData = scene.getSpriteData();
    }

    /**
     * Malowanie grafiki pola
     */
    public void paint(Graphics g) {

        g.drawImage(getSpriteData().getSprite(spriteName), getX(), getY(), ISettings.FIELD_SIZE, ISettings.FIELD_SIZE, getScene());
    }

    /**
     * Pobieranie nazwy pliku - pozwala na łatwe określenie typu obiektu
     */
    public synchronized String getSpriteName() {
        return spriteName;
    }

    public void setSpriteName(String string) {
        spriteName = string;
        BufferedImage image = getSpriteData().getSprite(spriteName);
    }

    /**
     * @return the blocked
     */
    public boolean isBlocked() {

        return blocked;
    }

    /**
     * @param blocked the blocked to set
     */
    public void setBlocked(boolean blocked) {

        this.blocked = blocked;
    }

    /**
     * @return the scene
     */
    public Board getScene() {
        return scene;
    }

    /**
     * @return the spriteData
     */
    public SpriteData getSpriteData() {
        return spriteData;
    }

    /**
     * Synchronizowane ustalanie blokowania pola
     * @see Animal
     */
    public synchronized void removePresence() {
        this.setBlocked(false);

    }

   /**
     * Synchronizowane usuwanie blokowania pola
     * @see Animal
     */
    public synchronized void setPresence() {
        this.setBlocked(true);

    }
}

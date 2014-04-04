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
 * Klasa punktu - najstarsza
 */
class Point {
    /** Położenie w poziomie*/
    private int x;
    /** Położnie w pionie*/
    private int y;

 
    Point() {
    }

    Point(int X, int Y) {
        this.x = X;
        this.y = Y;

    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /** Pobieranie współrzędnej poziomej [index tablicy]*/
    public int getPointX() {

        return this.getX() / ISettings.FIELD_SIZE;
    }
    /** Pobieranie współrzędnej pionowej [index tablicy]*/
    public int getPointY() {

        return this.getY() / ISettings.FIELD_SIZE;
    }
    /** Obliczanie położenia bezwzględnego z punktu**/
    public int calcLoc(int l) {
        return l * ISettings.FIELD_SIZE;

    }
    /** Oblicznie punktu z położenia bezwzględnego**/
    public int calcPoint(int p) {
        return p / ISettings.FIELD_SIZE;

    }
}
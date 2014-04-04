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
 *
 * Interface głównych ustawień świata
 */
public interface ISettings {
    /////////////Ustawienia świata//////////////

    /**
     * Rozmiar pola
     */
    public static final int FIELD_SIZE = 30;
    /**
     * Szerokość mapy
     */
    public static final int WORKSPACE_WIDTH = 600;
    /**
     * Wysokość mapy
     */
    public static final int WORKSPACE_HEIGHT = 600;
    /**
     * Liczba pól poziomo
     */
    public static final int WORKSPACE_POINTS_X = WORKSPACE_WIDTH / FIELD_SIZE;
    /**
     * Liczba pól pionowo
     */
    public static final int WORKSPACE_POINTS_Y = WORKSPACE_HEIGHT / FIELD_SIZE;
    /**
     * Szerokość okna
     */
    public static final int SZEROKOSC = 611;
    /**
     * Wysokość okna
     */
    public static final int WYSOKOSC = 630;
    /**
     * Okres odświeżania mapy
     */
    public static final int SZYBKOSC = 10;
    /**
     * Długość cyklu życia
     */
    public static final int PERIOD = 100;
    /**
     * Granica wieku
     */
    public static final int ANIMAL_DEADLINE = 100;
    /**
     * Granica głodu - śmierć
     */
    public static final int CRITICAL_FOOD = 0;
    /**
     * Granica pragnienia - śmierć
     */
    public static final int CRITICAL_WATER = 0;
    /**
     * Poziom głodu od którego zaczyna poszukiwanie pokarmu
     */
    public static final int HUNGER = 500;
    /**
     * Poziom pragnienia od którego idzie do wodopoju
     */
    public static final int THIRST = 500;
    /**
     * Pojemność żołądka
     */
    public static final int STOMACH = 1000;
    /**
     * Pojemność pęcherza
     */
    public static final int BLADDER = 1000;
    /**
     * Grafika równiny
     */
    public static final String SAND = "sand.jpg";
    /**
     * Grafika lwiej skały
     */
    public static final String ROCK = "rock.jpg";
    /**
     * Grafika cmentarzyska słoni
     */
    public static final String ELEROCK = "elerock.jpg";
    /**
     * Grafika wody
     */
    public static final String WATER = "water.jpg";
    /**
     * Grafika padliny
     */
    public static final String CARRION = "carrion.png";
    /**
     * Grafika hieny
     */
    public static final String HYENA = "hyena.png";
    /**
     * Grafika drzewa
     */
    public static final String TREE = "tree.jpg";
    /**
     * Grafika antylopy
     */
    public static final String ANTELOPE = "antelope.png";
    /**
     * Grafika lwa
     */
    public static final String LION = "lion.png";
    /**
     * Grafika węża
     */
    public static final String SNAKE = "snake.png";
    /**
     * Grafika ptaka
     */
    public static final String BIRD = "bird.png";
    /**
     * Grafika pusta
     */
    public static final String BLANK = "blank.png";
    /**
     * Grafika markera
     */
    public static final String MARKER = "marker.png";
    ///////////////////////////////////////////////////
}

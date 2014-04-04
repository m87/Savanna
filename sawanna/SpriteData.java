/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

/**
 *
 * @author Bartosz Radliński
 */
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

class SpriteData {

    /**
     * Kolekcja obrazków pól
     */
    public HashMap sprites;

    /**
     * Inicjalizacja kolekcji
     */
    public SpriteData() {
        sprites = new HashMap();

    }

    /**
     * Ładowanie obrazka
     */
    public BufferedImage loadImage(String sciezka) {
        URL url = null;
        try {
            url = getClass().getClassLoader().getResource(sciezka);
            return ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("Przy otwieraniu " + sciezka + " jako " + url);

            System.exit(0);
            return null;
        }
    }

    /**
     * Pobranie obrazka - jeżlei nie ma w kolekcji do dodać
     */
    public BufferedImage getSprite(String sciezka) {
        BufferedImage img = (BufferedImage) sprites.get(sciezka);
        if (img == null) {
            img = loadImage("img/" + sciezka);
            sprites.put(sciezka, img);
        }
        return img;
    }
}

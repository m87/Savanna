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
 * Klasa terenu - ustalany typ (Type) tylko w celu kompatybilności ze starym
 * fragmentem kodu, przy którym nie chciało mi się już kombinować, bo dobrze
 * działa.(Rozpoznawanie obiektu jako zwierzęcia - typ 0)
 *
 * @see Animal.canStand
 */
class Terrain extends Field {

    public Terrain(Board scene, String spName) {
        super(scene);
        setSpriteName(spName);
        this.setType(1);
    }

    /**
     * Sprawdzanie czy obiekt terenu jest domem dla zwierzęcia
     *
     * @param String s - dom zwierzęcia
     */
    public boolean isHome(String s) {
        if (this.getSpriteName().equals(s)) {
            return true;
        } else {
            return false;
        }

    }
}

/**
 * Klasa równiny - domyślnie nieblokowane
 */
class Sand extends Terrain {

    static private String spName = ISettings.SAND;

    public Sand(Board scene) {
        super(scene, spName);
        this.setType(4);
        this.setBlocked(false);

    }
}

/**
 * Klasa równiny - domyślnie blokowane
 */
class Water extends Terrain {

    static private String spName = ISettings.WATER;

    public Water(Board scene) {
        super(scene, spName);
        this.setBlocked(true);
    }
}

/**
 * Klasa równiny - domyślnie nieblokowane
 */
class Tree extends Terrain {

    static private String spName = ISettings.TREE;

    public Tree(Board scene) {
        super(scene, spName);
        this.setBlocked(false);
    }
}

/**
 * Klasa równiny - domyślnie nieblokowane
 */
class Rock extends Terrain {

    static private String spName = ISettings.ROCK;

    public Rock(Board scene) {
        super(scene, spName);
        this.setBlocked(false);
    }
}

/**
 * Klasa równiny - domyślnie nieblokowane
 */
class EleRock extends Terrain {

    static private String spName = ISettings.ELEROCK;

    public EleRock(Board scene) {
        super(scene, spName);
        this.setBlocked(false);
    }
}

/**
 * Klasa padliny dziedzicy po Mammel w celu prostrzego wyświetlnia rozmiaru
 */
class Carrion extends Mammal {

    static private String spName = ISettings.CARRION;

    /**
     * Padlia stworzona przez gracza. Nie ma potrzeby regulować rozmiaru - można
     * stworzyć kilka obiektów. Nie blokuje pola.
     */
    public Carrion(Board scene) {
        super(scene, spName);
        this.setSize(100);
        setSpriteName(spName);
        this.setBlocked(false);
    }

    /**
     * Padlina tworzona przez zwierzę. Nie blokuje pola
     *
     * @see Lion
     * @see Hyena
     */
    public Carrion(Board scene, int size) {
        super(scene, spName);
        this.setSize(size);
        setSpriteName(spName);
        this.setBlocked(false);

    }

    /**
     * Usuwanie padliny
     *
     * @Override
     */
    public void remove() {
        Board.setCarrion_fields(this.getPointX(), this.getPointY(), new Ghost(this.scene));

        Board.setDynamic_fields(this.getPointX(), this.getPointY(), new Ghost(this.scene));
    }
}
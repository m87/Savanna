/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

import javax.swing.JOptionPane;

/**
 *
 * @author Bartosz Radliński
 */
/**
 * Klasa ssaka
 */
public class Mammal extends Animal {

    /**
     * Inicjalizacja
     */
    Mammal(Board scene, String spName) {
        super(scene, spName);
        this.water = ISettings.BLADDER;
        this.food = ISettings.STOMACH;
        this.appetite = 0;
        this.scene = scene;
        this.setPatrolRoadis(false);

    }
    /**
     * Poziom wody
     */
    private int water;
    /**
     * Poziom pokarmu
     */
    private int food;
    /**
     * Apetyt
     */
    private int appetite;
    /**
     * Scena - gdzie rysować
     */
    public Board scene;

    /**
     * @return the water
     */
    public int getWater() {
        return water;
    }

    /**
     * @return the food
     */
    public int getFood() {
        return food;
    }

    /**
     * Sprawdzenie czy zwierzę jest głodne i przejście do odpowiedniego stanu
     * cyklu życia zwierzęcia
     */
    public void checkFood() {

        if (this.getFood() < ISettings.HUNGER) {
            this.setAnimalState(4);
        }
    }

    /**
     * @return the appetite
     */
    public int getAppetite() {
        return appetite;
    }

    /**
     * Znajdowanie terytorium zwierzęcia , jeżeli nie wykryto - błąd. Terytorium
     * to prostokat o max polu obejmujący wszystkie pola określone jako dom dla
     * danego zwierzęcia
     */
    public int[] findRestPlace() {
        int maxX = ISettings.WORKSPACE_POINTS_X;
        int maxX1 = -1;
        int maxY = -1;
        int maxY1 = ISettings.WORKSPACE_POINTS_Y;

        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                if (Board.getStatic_fields(i, j).getSpriteName().equals(this.getHome())) {
                    if (Board.getStatic_fields(i, j).getPointX() < maxX) {
                        maxX = Board.getStatic_fields(i, j).getPointX();
                    }
                    if (Board.getStatic_fields(i, j).getPointX() > maxX1) {
                        maxX1 = Board.getStatic_fields(i, j).getPointX();
                    }
                    if (Board.getStatic_fields(i, j).getPointY() > maxY) {
                        maxY = Board.getStatic_fields(i, j).getPointY();
                    }
                    if (Board.getStatic_fields(i, j).getPointY() < maxY1) {
                        maxY1 = Board.getStatic_fields(i, j).getPointY();
                    }
                }

            }
        }

        if (maxX == ISettings.WORKSPACE_POINTS_X || maxX1 == -1 || maxY == -1 || maxY1 == ISettings.WORKSPACE_POINTS_Y) {
            JOptionPane.showMessageDialog(scene,
                    "Brak lub błąd terytorium zwierzęcia",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);

            return null;
        } else {
            int[] tab = {maxX, maxX1, maxY1, maxY,};
            return tab;
        }
    }

    /**
     * Sprawdzenie czy zwierze powinno, żyć pod względem fizjologicznym:)
     */
    public boolean checkLife() {
        if (this.getAge() >= ISettings.ANIMAL_DEADLINE || this.getFood() < ISettings.CRITICAL_FOOD || this.getWater() < ISettings.CRITICAL_WATER) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * @param food the food to set
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * @param appetite the appetite to set
     */
    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    /**
     * @param water the water to set
     */
    public void setWater(int water) {
        this.water = water;
    }
}

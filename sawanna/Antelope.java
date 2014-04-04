/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bartosz Radliński
 */
/**
 * Klasa antylopy
 */
public class Antelope extends Mammal implements Runnable {

    /**
     * Grafika
     */
    static private String spName = ISettings.ANTELOPE;
    /**
     * Tempo wzrostu
     */
    static private int size_age = 1;
    /**
     * Tempo starzenia
     */
    static private int agingRate = 1;
    /**
     * Tempo reprodukcji
     */
    static private int reproductionRate = 100;
    public static int[] Terrytory = new int[4];
    /**
     * Tempo jedzenia
     */
    private static int eatingRate = 5;
    /**
     * Tempo picia
     */
    private static int drinkingRate = 5;
    /**
     * Tempo spalania energii
     */
    private static int energyRate = 1;
    /**
     * Prędkość
     */
    private static int velocity = 100;
    /**
     * Licznik urodzenia
     */
    private int born;
    /**
     * Kolekcjia puntków drogi do wodopoju
     */
    public static HashMap WaterPlaceRoad = new HashMap();
    /**
     * Iterator
     */
    private int WaterPlaceRoadInc;
    /**
     * Licznik stanu okresu
     */
    private int period = 0;

    /**
     * Inicjalizacja i ustalenie terytorium
     */
    Antelope(Board scene) {
        super(scene, spName);
        this.setHome(ISettings.SAND);
        born = 0;
        setType(0);
        this.setSize(150);
        WaterPlaceRoadInc = 0;

        this.setFoodObject(ISettings.SAND);
        Antelope.Terrytory = this.findRestPlace();
        this.PatrolRoad.put(0, new Point(this.getX(), this.getY()));
        this.setPatrolRoadInc(0);
        this.setPatrolRoadis(true);

    }

    /**
     * @return the eatingRate
     */
    public static int getEatingRate() {
        return eatingRate;
    }

    /**
     * @param aEatingRate the eatingRate to set
     */
    public static void setEatingRate(int aEatingRate) {
        eatingRate = aEatingRate;
    }

    /**
     * @return the drinkingRate
     */
    public static int getDrinkingRate() {
        return drinkingRate;
    }

    /**
     * @param aDrinkingRate the drinkingRate to set
     */
    public static void setDrinkingRate(int aDrinkingRate) {
        drinkingRate = aDrinkingRate;
    }

    /**
     * @return the energyRate
     */
    public static int getEnergyRate() {
        return energyRate;
    }

    /**
     * @param aEnergyRate the energyRate to set
     */
    public static void setEnergyRate(int aEnergyRate) {
        energyRate = aEnergyRate;
    }

    /**
     * @return the velocity
     */
    public static int getVelocity() {
        return velocity;
    }

    /**
     * @param aVelocity the velocity to set
     */
    public static void setVelocity(int aVelocity) {
        velocity = aVelocity;
    }

    /**
     * @return the size_age
     */
    public static int getSize_age() {
        return size_age;
    }

    /**
     * @param aSize_age the size_age to set
     */
    public static void setSize_age(int aSize_age) {
        size_age = aSize_age;
    }

    /**
     * @return the agingRate
     */
    public static int getAgingRate() {
        return agingRate;
    }

    /**
     * @param aAgingRate the agingRate to set
     */
    public static void setAgingRate(int aAgingRate) {
        agingRate = aAgingRate;
    }

    /**
     * @return the reproductionRate
     */
    public static int getReproductionRate() {
        return reproductionRate;
    }

    /**
     * @param aReproductionRate the reproductionRate to set
     */
    public static void setReproductionRate(int aReproductionRate) {
        reproductionRate = aReproductionRate;
    }

    /**
     * Reset okresu
     */
    public void resetPeriod() {
        this.period = 0;
    }

    /**
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod() {
        this.period++;
    }

    /**
     * @return the WaterPlaceRoadInc
     */
    public int getWaterPlaceRoadInc() {
        return WaterPlaceRoadInc;
    }

    /**
     * @param WaterPlaceRoadInc the WaterPlaceRoadInc to set
     */
    public void setWaterPlaceRoadInc(int WaterPlaceRoadInc) {
        this.WaterPlaceRoadInc = WaterPlaceRoadInc;
    }

    /**
     * Konsumpcja pokarmu
     */
    public void foodrUse() {
        this.setFood(this.getFood() - Antelope.getEnergyRate());
        this.setAppetite(this.getAppetite() + Antelope.getEnergyRate());
    }

    /**
     * Picie
     */
    public void drink() {
        this.setWater(this.getWater() + Antelope.getDrinkingRate());
    }

    /**
     * Zużywanie wody
     */
    public void waterUse() {
        this.setWater(this.getWater() - Antelope.getEnergyRate());
    }

    /**
     * Jedzenie
     */
    public void eat() {
        if (this.getFood() < ISettings.STOMACH) {
            this.setFood(this.getFood() + Antelope.getEatingRate());
            this.setAppetite(this.getAppetite() - Antelope.getEatingRate());
        } else {

            this.setFood(ISettings.STOMACH);
            this.setAppetite(0);
        }

    }

    /**
     * Wykonywanie akcji okresowych - zwiększenie rozmiaru, wieku . Zwiększenie
     * licznika urodzenia(born). Jeżeli born równa się tempo rozrodu -
     * powastanie nowej antylopy i reset licznika.
     */
    public void exPeriod() {

        if (this.getPeriod() == ISettings.PERIOD) {
            this.resetPeriod();
            this.setAge(this.getAge() + Antelope.getAgingRate());
            this.setSize(this.getSize() + Antelope.size_age);
            setBorn(getBorn() + 1);

        } else {

            this.setPeriod();
        }
        if (getBorn() == Antelope.getReproductionRate()) {
            this.reproduct();
            this.setBorn(0);

        }

    }

    /**
     * Reprodkcja - losowanie pozycji nowej antylopy na terytorium(Równnina) i
     * tworzenie nowego potomka;
     */
    public void reproduct() {

        Antelope ant = new Antelope(scene);
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(ISettings.WORKSPACE_POINTS_X) * ISettings.FIELD_SIZE;
            y = rand.nextInt(ISettings.WORKSPACE_POINTS_Y) * ISettings.FIELD_SIZE;
        } while ((Board.getStatic_fields(this.calcPoint(x), this.calcPoint(y)).isBlocked())
                && !Board.getStatic_fields(this.calcPoint(x), this.calcPoint(y)).getSpriteName().equals(ISettings.SAND));
        this.createAnimal(x, y, ant);
        ant.PatrolRoad.put(0, new Point(this.getPointX(), this.getPointY()));
        new Thread(ant).start();

    }

    /**
     * Cykl życia. Dopóki żyje(stop). Jeżeli ustalona droga żerowania, to
     * patroluje drogę. Jeżeli poziom jedzenie < ISettings.HUNGER to konumuje,
     * jeżeli poziom wody < ISEttings.THISRST to idzie do wodpoju (pokoleji
     * przechodzi elementy kolekcji WaterPlaceRoad) i pije. Następnie wykonanie
     * okresowych czynności, zużywanie jedzenia i wody oraz sprawdzenie funkcji
     * życiowych. Jedzenie ma większy priotytet niż picie;
     * Cykl powtarza się co czas w milisekundach równy prędkości.
     *
     *
     *
     *
     *
     *
     *
     *
     *

     *
     * @Override
     */
    public void run() {
        while (!isStop()) {

            if (this.isPatrolRoadis()) {
                this.checkFood();
                switch (getAnimalState()) {

                    case 0: {

                        setWaterPlaceRoadInc(0);
                        patrol();

                        break;
                    }
                    case 1: {
                        this.move((Point) Antelope.WaterPlaceRoad.get(0));
                        if (!Antelope.WaterPlaceRoad.isEmpty()) {
                            if (this.isArrive((Point) Antelope.WaterPlaceRoad.get(0))) {

                                this.setWaterPlaceRoadInc(this.getWaterPlaceRoadInc() + 1);

                                this.setAnimalState(2);

                            }
                        }

                        break;
                    }

                    case 2: {

                        if (getWaterPlaceRoadInc() < Antelope.WaterPlaceRoad.size()) {

                            this.move((Point) Antelope.WaterPlaceRoad.get(getWaterPlaceRoadInc()));
                            if (this.getX() == ((Point) Antelope.WaterPlaceRoad.get(getWaterPlaceRoadInc())).getX()
                                    && this.getY() == ((Point) Antelope.WaterPlaceRoad.get(getWaterPlaceRoadInc())).getY()) {
                                setWaterPlaceRoadInc(getWaterPlaceRoadInc() + 1);
                            }
                        } else {
                            this.setAnimalState(3);

                        }

                        break;
                    }

                    case 3: {


                        if (this.getWater() < ISettings.BLADDER) {
                            this.drink();
                        } else {

                            this.setAnimalState(0);
                        }

                        break;
                    }
                    case 4: {
                        patrol();
                        if (this.getFood() < ISettings.STOMACH) {
                            this.eat();
                        } else {
                            this.setAnimalState(0);
                        }
                        break;
                    }
                }

                if (this.getWater() < ISettings.THIRST && this.getFood() > ISettings.HUNGER && this.getAnimalState() == 0) {
                    this.setAnimalState(1);
                }


                this.exPeriod();
                this.waterUse();
                this.foodrUse();
                if (!checkLife()) {
                    this.remove();
                }


            }

            try {
                Thread.sleep(Antelope.getVelocity());
            } catch (InterruptedException ex) {
                Logger.getLogger(Antelope.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the born
     */
    public int getBorn() {
        return born;
    }

    /**
     * @param born the born to set
     */
    public void setBorn(int born) {
        this.born = born;
    }
}

/*o
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
 * Klasa lwa
 */
public class Lion extends Mammal implements Runnable {

    /**
     * Grafika
     */
    static private String spName = ISettings.LION;
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
    /**
     * Czas odpoczynku
     */
    private static int restTime = 20;
    /**
     * Gdzie malować
     */
    static private Board scene;
    /**
     * Prędkość
     */
    private static int velocity = 100;
    /**
     * Licznik czasu odpoczynku
     */
    private int restTimer = 0;
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
     * Licznik urodzenia
     */
    private int born = 0;
    /**
     * Kolekcja punktów drogi do wodpoju
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
     * Szansa upolowania
     */
    private static int huntingRate = 2;

    /**
     * Inicjalizacja i ustalenie terytorium
     */
    Lion(Board scene) {
        super(scene, spName);
        this.setHome(ISettings.ROCK);
        this.scene = scene;
        born = 0;
        setType(0);
        this.setFoodObject(ISettings.ANTELOPE);
        this.setSize(200);
        WaterPlaceRoadInc = 0;

        Lion.Terrytory = this.findRestPlace();
        this.PatrolRoad.put(0, new Point(this.getX(), this.getY()));
        this.setPatrolRoadInc(0);
        this.setPatrolRoadis(true);

    }

    /**
     * @return the huntingRate
     */
    public static int getHuntingRate() {
        return huntingRate;
    }

    /**
     * @param aHuntingRate the huntingRate to set
     */
    public static void setHuntingRate(int aHuntingRate) {
        huntingRate = aHuntingRate;
    }

    /**
     * @return the restTime
     */
    public static int getRestTime() {
        return restTime;
    }

    /**
     * @param aRestTime the restTime to set
     */
    public static void setRestTime(int aRestTime) {
        restTime = aRestTime;
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
     * Konsumpcja pokarmu
     */
    public void foodrUse() {
        this.setFood(this.getFood() - Lion.getEnergyRate());
        this.setAppetite(this.getAppetite() + Lion.getEnergyRate());
    }

    /**
     * Picie
     */
    public void drink() {
        this.setWater(this.getWater() + Lion.getDrinkingRate());
    }

    /**
     * Zużywanie wody
     */
    public void waterUse() {
        this.setWater(this.getWater() - Lion.getEnergyRate());
    }

    /**
     * Jedzenie jeżeli upolowana zwierzyna była mniejsza niż tempo jedzenia to
     * zjada, jeżeli większa to je dopóki się nie naje, jeżeli coś zostanie to
     * tworzy padlinę o masie równej resztkom.
     */
    public void eatHunt() {
        if (this.getFood() < ISettings.STOMACH) {

            if (this.getFoodHunt() <= Lion.getEatingRate()) {
                this.setFood(this.getFood() + this.getFoodHunt());
                this.setFoodHunt(0);
                if (this.getFood() > ISettings.HUNGER) {
                    this.setAnimalState(0);

                } else {
                    this.setAnimalState(4);
                }

            } else {
                this.setFood(this.getFood() + Lion.getEatingRate());
                this.setAppetite(this.getAppetite() - Lion.getEatingRate());
                this.setFoodHunt(this.getFoodHunt() - Lion.getEatingRate());
                if (this.getFood() > ISettings.HUNGER) {

                    Carrion m = new Carrion(this.scene, this.getFoodHunt());
                    m.setX(this.getX());
                    m.setY(this.getY());
                    Board.setCarrion_fields(this.getPointX(), this.getPointY(), m);


                    this.setAnimalState(0);
                    this.setFoodHunt(0);
                } else {
                    Carrion m = new Carrion(this.scene, this.getFoodHunt());
                    m.setX(this.getX());
                    m.setY(this.getY());

                    Board.setCarrion_fields(this.getPointX(), this.getPointY(), m);
                    this.setFoodHunt(0);
                    this.setAnimalState(4);
                }
            }
        } else {

            this.setFood(ISettings.STOMACH);
            this.setAppetite(0);
        }
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
     * Sprawdza czy w punkcie znajduje się obiekt który może zjeść
     */
    public boolean canHunt(Point f) {

        if (Board.getDynamic_fields(f.getPointX(), f.getPointY()).getSpriteName().equals(ISettings.ANTELOPE)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Odpoczynek przez określony czas
     */
    public void rest() {
        if (getRestTimer() >= Lion.getRestTime()) {
            setRestTimer(0);
            this.setRestPlace(null);
            this.setAnimalState(0);
        } else {

            setRestTimer(getRestTimer() + 1);
        }
    }

    /**
     * Reset licznika okresu
     */
    public void resetPeriod() {
        this.period = 0;
    }

    /**
     * Wykonywanie akcji okresowych - zwiększenie rozmiaru, wieku . Zwiększenie
     * licznika urodzenia(born). Jeżeli born równa się tempo rozrodu -
     * powastanie nowego lwa i reset licznika.
     */
    public void exPeriod() {

        if (this.getPeriod() == ISettings.PERIOD) {
            this.resetPeriod();
            this.setAge(this.getAge() + Lion.getAgingRate());
            this.setSize(this.getSize() + Lion.size_age);
            setBorn(getBorn() + 1);
        } else {

            this.setPeriod();
        }
        if (getBorn() == Lion.getReproductionRate()) {
            this.reproduct();
            this.setBorn(0);

        }

    }

    /**
     * Reprodkcja - losowanie pozycji nowego lwa na terytorium(Lwia skała) i
     * tworzenie nowego potomka;
     */
    public void reproduct() {

        Lion ant = new Lion(scene);
        Random rand = new Random();

        int x, y;

        do {
            x = (rand.nextInt((Lion.Terrytory[1] - Lion.Terrytory[0] + 1)) + Lion.Terrytory[0]) * ISettings.FIELD_SIZE;
            y = (rand.nextInt((Lion.Terrytory[3] - Lion.Terrytory[2] + 1)) + Lion.Terrytory[2]) * ISettings.FIELD_SIZE;
        } while ((Board.getStatic_fields(this.calcPoint(x), this.calcPoint(y)).isBlocked()));


        this.createAnimal(x, y, ant);
        ant.PatrolRoad.put(0, new Point(this.getPointX(), this.getPointY()));
        new Thread(ant).start();

    }

    /**
     * Cykl życia. Dopóki żyje(stop). Jeżeli lew jest najedzony i napojony to
     * odpoczywa na swoim terytorium co jakiś czas zmieniając pozycję. Jeżeli
     * poziom jedzenie < ISettings.HUNGER to żeruje dopóki się nie naje, jeżeli
     * poziom wody < ISEttings.THISRST to idzie do wodpoju (pokoleji przechodzi
     * elementy kolekcji WaterPlaceRoad) i pije. Następnie wykonanie okresowych
     * czynności, zużywanie jedzenia i wody oraz sprawdzenie funkcji życiowych.
     * Jedzenie ma większy priotytet niż picie;
     *
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
     *
     *
     *
     *

     *
     * @Override
     */
    public void run() {
        while (!isStop()) {
            if (Lion.Terrytory == null) {
                this.remove();
            }
            if (this.isPatrolRoadis()) {
                this.checkFood();
                switch (getAnimalState()) {

                    case 0: {
                        this.setWaterPlaceRoadInc(0);
                        if (this.getRestPlace() == null) {
                            Random rand = new Random();
                            setRestPlace(new Point((rand.nextInt(Lion.Terrytory[1] - Lion.Terrytory[0] + 1) + Lion.Terrytory[0]) * ISettings.FIELD_SIZE,
                                    (rand.nextInt(Lion.Terrytory[3] - Lion.Terrytory[2] + 1) + Lion.Terrytory[2]) * ISettings.FIELD_SIZE));

                            move(getRestPlace());

                        } else {
                            if (!this.isArrive(this.getRestPlace())) {
                                move(getRestPlace());
                            } else {
                                this.setAnimalState(1);
                            }
                        }

                        break;
                    }

                    case 1: {
                        rest();

                        break;
                    }

                    case 2: {
                        if (!Lion.WaterPlaceRoad.isEmpty()) {
                            if (this.isArrive(((Point) Lion.WaterPlaceRoad.get(0)))) {
                                this.setAnimalState(3);
                            } else {
                                this.move((Point) Lion.WaterPlaceRoad.get(0));

                            }
                        }
                        this.checkFood();
                        break;
                    }



                    case 3: {



                        if (getWaterPlaceRoadInc() < Lion.WaterPlaceRoad.size()) {

                            this.move((Point) Lion.WaterPlaceRoad.get(getWaterPlaceRoadInc()));
                            if (this.isArrive(((Point) Lion.WaterPlaceRoad.get(getWaterPlaceRoadInc())))) {
                                setWaterPlaceRoadInc(getWaterPlaceRoadInc() + 1);
                            }
                        } else {
                            if (this.getWater() < ISettings.BLADDER) {
                                this.drink();
                            } else {

                                this.setAnimalState(0);
                            }
                        }
                        this.checkFood();
                        break;
                    }

                    case 4: {
                        this.setWaterPlaceRoadInc(0);
                        if (this.getFoodHunt() != 0) {
                            this.eatHunt();

                        } else {
                            patrol();
                        }
                        break;
                    }


                }

                if (this.getWater() < ISettings.THIRST && this.getFood() > ISettings.HUNGER && this.getAnimalState() == 1) {

                    this.setAnimalState(2);
                }


                this.waterUse();
                this.foodrUse();
                this.exPeriod();

                if (!checkLife()) {
                    this.remove();
                }



            }

            try {
                Thread.sleep(Lion.getVelocity());
            } catch (InterruptedException ex) {
                Logger.getLogger(Lion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
     * @return the restTimer
     */
    public int getRestTimer() {
        return restTimer;
    }

    /**
     * @param restTimer the restTimer to set
     */
    public void setRestTimer(int restTimer) {
        this.restTimer = restTimer;
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

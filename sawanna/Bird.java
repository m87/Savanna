/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bartosz Radliński
 */
/**
 * Klasa pataka
 */
class Bird extends Animal implements Runnable {

    /**
     * Grafika
     */
    static private String spName = ISettings.BIRD;
    /**
     * Tempo starzenia
     */
    static private int agingRate = 1;
    /**
     * Reprodukcji
     */
    static private int reproductionRate = 100;
    public static int[] Terrytory = new int[4];

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
     * Licznik stanu okresu
     */
    private int period = 0;
    /**
     * Licznik urodzenia
     */
    private int born = 0;
    /**
     * Jedzenie
     */
    private int food = ISettings.STOMACH;
    /**
     * Apetyt
     */
    private int appetite = 0;
    /**
     * Tempo jedzenia
     */
    private static int eatingRate = 5;
    /**
     * Tempo spalania energii
     */
    private static int energyRate = 1;
    /**
     * Położnei gniazda
     */
    private Point nest = null;
    /**
     * Czy gniazdo ustalone
     */
    private boolean NestEst = false;
    /**
     * Aktualna wyokość
     */
    private int h = 0;
    Random rand = new Random();
    /**
     * Szansa upolowania
     */
    private static int huntingRate = 1;
    /**
     * Prędkość
     */
    private static int velocity = 100;
    /**
     * Gdzie rysowaćs
     */
    Board scene;

    /**
     * Inicjalizacja i ustalenie terytorium
     */
    Bird(Board scene) {
        super(scene, spName);
        this.setHome(ISettings.TREE);
        this.scene = scene;
        born = 0;
        setType(0);
        this.setAnimalState(0);
        this.setFoodHunt(0);
        this.setFoodObject(ISettings.SNAKE);

        int WaterPlaceRoadInc = 0;
        int WaterPlaceState = 0;
        Bird.Terrytory[0] = 0;
        Bird.Terrytory[1] = ISettings.WORKSPACE_POINTS_X;
        Bird.Terrytory[2] = 0;
        Bird.Terrytory[3] = ISettings.WORKSPACE_POINTS_Y;
        this.h = rand.nextInt(100);

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
     * Usunięcie ptaka
     */
    public void remove() {
        Board.setDynamic_fields(this.getPointX(), this.getPointY(), new Ghost(this.scene));
        Board.setSky_fields(this.getPointX(), this.getPointY(), new Ghost(this.scene));
        Board.animals.remove(this.getID());
        this.PatrolRoad.clear();
        this.setStop(true);
    }

    /**
     * Reprodkcja - losowanie pozycji nowego ptaka na terytorium(Cała mapa) i
     * tworzenie nowego potomka;
     */
    public void reproduct() {

        Bird ant = new Bird(scene);

        int x, y;
        do {
            x = (rand.nextInt(ISettings.WORKSPACE_POINTS_X)) * ISettings.FIELD_SIZE;
            y = (rand.nextInt(ISettings.WORKSPACE_POINTS_Y)) * ISettings.FIELD_SIZE;
        } while ((Board.getStatic_fields(this.calcPoint(x), this.calcPoint(y)).isBlocked()));


        this.createAnimal(x, y, ant);
        ant.PatrolRoad.put(0, new Point(this.getPointX(), this.getPointY()));
        new Thread(ant).start();

    }

    /**
     * Reset licznika okresu
     */
    public void resetPeriod() {
        this.period = 0;
    }

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
     * Wykonywanie akcji okresowych - zwiększenie wieku (rozmiar nieistotny -
     * nikt na ptaka nie poluje). Zwiększenie licznika urodzenia(born). Jeżeli
     * born równa się tempo rozrodu - powastanie nowego ptaka i reset licznika.
     */
    public void exPeriod() {

        if (this.getPeriod() == ISettings.PERIOD) {
            this.resetPeriod();
            this.setAge(this.getAge() + Bird.getAgingRate());

            setBorn(getBorn() + 1);
            this.setH(rand.nextInt(100));
        } else {

            this.setPeriod();
        }
        if (getBorn() == Bird.getReproductionRate()) {
            this.reproduct();
            this.setBorn(0);

        }

    }

    /**
     * Przeciążony patrol do poruszania zamiast move używa fly
     */
    public void patrol() {

        if (getPatrolRoadState() == 0) {
            if (getPatrolRoadInc() < this.PatrolRoad.size() - 1) {


                this.fly((Point) this.PatrolRoad.get(getPatrolRoadInc()));
                if (this.isArrive(((Point) this.PatrolRoad.get(getPatrolRoadInc())))) {
                    setPatrolRoadInc(getPatrolRoadInc() + 1);
                }


            } else {
                setPatrolRoadState(1);
            }

        } else {
            if (getPatrolRoadInc() > 0) {

                this.fly((Point) this.PatrolRoad.get(getPatrolRoadInc()));

                if (this.isArrive(((Point) this.PatrolRoad.get(getPatrolRoadInc())))) {
                    setPatrolRoadInc(getPatrolRoadInc() - 1);
                }
            } else {
                setPatrolRoadState(0);
            }


        }
    }

    /**
     * Jedzenie jeżeli upolowana zwierzyna była mniejsza niż tempo jedzenia to
     * zjada, jeżeli większa to je dopóki się nie naje, jeżeli coś zostanie to
     * tworzy padlinę o masie równej resztkom.
     */
    public void eatHunt() {
        if (this.getFood() < ISettings.STOMACH) {
            if (this.getFoodHunt() < Bird.getEatingRate()) {
                this.food += this.getFoodHunt();
                this.setFoodHunt(0);
                if (this.food > ISettings.STOMACH) {
                    this.setAnimalState(0);

                } else {
                    this.setAnimalState(1);
                }

            } else {
                this.food += Bird.getEatingRate();
                this.setFoodHunt(this.getFoodHunt() - Bird.getEatingRate());
                if (this.food > ISettings.STOMACH) {
                    this.setAnimalState(0);
                    Carrion m = new Carrion(this.scene, this.getFoodHunt());
                    m.setX(this.getX());
                    m.setY(this.getY());
                    Board.setCarrion_fields(this.getPointX(), this.getPointY(), m);

                    this.setFoodHunt(0);
                } else {
                    this.setAnimalState(1);
                }
            }
        } else {

            this.setFood(ISettings.STOMACH);
            this.setAppetite(0);
        }
    }

    /**
     * Sprawdzenie czy zwierzę jest głodne i przejście do odpowiedniego stanu
     * cyklu życia zwierzęcia
     */
    public void checkFood() {

        if (this.getFood() < ISettings.HUNGER) {
            this.setAnimalState(1);
        }
    }

    /**
     * Konsumpcja pokarmu
     */
    public void foodrUse() {
        this.food -= Bird.getEnergyRate();
        this.setAppetite(this.getAppetite() + Bird.getEnergyRate());
    }

    /**
     * Cykl życia. Dopóki żyje(stop). Jeżeli ustalona droga żerowania, to
     * patroluje drogę. Jeżeli poziom jedzenie < ISettings.HUNGER to konumuje,
     * jeżeli poziom wody < ISEttings.THISRST to idzie do wodpoju (pokoleji
     * przechodzi elementy kolekcji WaterPlaceRoad) i pije. Następnie wykonanie
     * okresowych czynności, zużywanie jedzenia i wody oraz sprawdzenie funkcji
     * życiowych. Cykl powtarza się co czas w milisekundach równy prędkości.
     */
    public void run() {
        setAnimalState(0);
        while (!isStop()) {

            this.checkFood();
            switch (getAnimalState()) {
                case 0: {
                    if (getNest() != null) {
                        fly(getNest());
                    }

                    break;
                }
                case 1: {
                    if (this.isPatrolRoadis()) {


                        patrol();


                    }
                    break;
                }

                case 2: {

                    if (this.getFoodHunt() != 0) {
                        this.eatHunt();
                    }

                    break;
                }
            }

            this.foodrUse();
            this.exPeriod();

            if (!checkLife()) {
                this.remove();
            }

            try {
                Thread.sleep(Bird.getVelocity());
            } catch (InterruptedException ex) {
                Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Sprawdzenie funkcji życiowych
     */
    public boolean checkLife() {
        if (this.getAge() >= ISettings.ANIMAL_DEADLINE || this.getFood() < ISettings.CRITICAL_FOOD) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Ruch analogiczny do ruchu lwa tylko operuje dodatkowo na tablicy
     * sky_fields *
     */
    public void fly(Point goPoint) {

        if (this.getY() != goPoint.getY()) {

            if (this.getY() < goPoint.getY() && this.getPointY() < ISettings.WORKSPACE_POINTS_Y - 1) {

                synchronized (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)) {
                    if (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(getFoodObject())) {
                        if ((rand.nextInt(Bird.getHuntingRate())) - 1 <= 0) {
                            this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).getSize());
                            ((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).remove();
                            setAnimalState(2);
                        }
                    }
                }
                if (!Board.getSky_fields(this.getPointX(), this.getPointY() + 1).isBlocked()) {
                    Board.setSky_fields(this.getPointX(), this.getPointY() + 1, this);
                    this.setY(this.getY() + ISettings.FIELD_SIZE);

                    Board.setSky_fields(this.getPointX(), this.getPointY() - 1, new Ghost(scene));

                }

            } else {
                if (this.getPointY() > 0) {

                    synchronized (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)) {
                        if (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(getFoodObject())) {
                            if ((rand.nextInt(Bird.getHuntingRate())) - 1 <= 0) {
                                this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).getSize());
                                ((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).remove();
                                setAnimalState(2);
                            }
                        }
                    }
                    if (!Board.getSky_fields(this.getPointX(), this.getPointY() - 1).isBlocked()) {
                        Board.setSky_fields(this.getPointX(), this.getPointY() - 1, this);
                        this.setY(this.getY() - ISettings.FIELD_SIZE);
                        Board.setSky_fields(this.getPointX(), this.getPointY() + 1, new Ghost(scene));

                    }

                }



            }
        } else {
            if (this.getX() != goPoint.getX()) {

                if (this.getX() < goPoint.getX() && this.getPointX() < ISettings.WORKSPACE_POINTS_X - 1) {


                    synchronized (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())) {
                        if (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(getFoodObject())) {
                            if ((rand.nextInt(Bird.getHuntingRate())) - 1 <= 0) {
                                this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).getSize());
                                ((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).remove();
                                setAnimalState(2);
                            }
                        }
                    }

                    if (!Board.getSky_fields(this.getPointX() + 1, this.getPointY()).isBlocked()) {
                        Board.setSky_fields(this.getPointX() + 1, this.getPointY(), this);
                        this.setX(this.getX() + ISettings.FIELD_SIZE);
                        Board.setSky_fields(this.getPointX() - 1, this.getPointY(), new Ghost(scene));
                    }

                } else {
                    if (this.getPointX() > 0) {

                        synchronized (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())) {
                            if (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(getFoodObject())) {
                                if ((rand.nextInt(Bird.getHuntingRate())) - 1 <= 0) {
                                    this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).getSize());
                                    ((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).remove();
                                    setAnimalState(2);
                                }
                            }
                        }

                        if (!Board.getSky_fields(this.getPointX() - 1, this.getPointY()).isBlocked()) {

                            Board.setSky_fields(this.getPointX() - 1, this.getPointY(), this);
                            this.setX(this.getX() - ISettings.FIELD_SIZE);
                            Board.setSky_fields(this.getPointX() + 1, this.getPointY(), new Ghost(scene));


                        }
                    }
                }
            }
        }




    }

    /**
     * @return the eatingRate
     */
    public static int getEatingRate() {
        return eatingRate;
    }

    /**
     * @param eatingRate the eatingRate to set
     */
    public static void setEatingRate(int eatingRate) {
        Bird.eatingRate = eatingRate;
    }

    /**
     * @return the food
     */
    public int getFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * @return the energyRate
     */
    public static int getEnergyRate() {
        return energyRate;
    }

    /**
     * @param energyRate the energyRate to set
     */
    public static void setEnergyRate(int energyRate) {
        Bird.energyRate = energyRate;
    }

    /**
     * @return the appetite
     */
    public int getAppetite() {
        return appetite;
    }

    /**
     * @param appetite the appetite to set
     */
    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    /**
     * @return the nest
     */
    public Point getNest() {
        return nest;
    }

    /**
     * @param nest the nest to set
     */
    public void setNest(Point nest) {
        this.nest = nest;
    }

    /**
     * @return the NestEst
     */
    public boolean isNestEst() {
        return NestEst;
    }

    /**
     * @param NestEst the NestEst to set
     */
    public void setNestEst(boolean NestEst) {
        this.NestEst = NestEst;
    }

    /**
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(int h) {
        this.h = h;
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

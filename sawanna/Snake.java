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
 * Klasa węża
 */
class Snake extends Animal implements Runnable {

    /**
     * Grafika
     */
    static private String spName = ISettings.SNAKE;
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
     * Posiada ilość trucizny
     */
    private int poison = 200;
    /**
     * Maksymalna ilość trucizny
     */
    private static int poisonMax = 200;
    /**
     * Tempo regeneracji trucizny
     */
    private static int poisonReg = 10;
    /**
     * Licznik stanu okresu
     */
    private int period = 0;
    /**
     * Licznik urodzenia
     */
    private int born = 0;
    /**
     * Predkość
     */
    private static int velocity = 100;
    /**
     * Gdzie malować
     */
    Board scene;

    /**
     * Inicjalizacja i ustalenie terytorium
     */
    Snake(Board scene) {
        super(scene, spName);
        this.setHome(ISettings.SAND);
        this.scene = scene;
        born = 0;
        setType(0);
        this.setSize(50);
        this.setFoodHunt(0);

        Snake.Terrytory[0] = 0;
        Snake.Terrytory[1] = ISettings.WORKSPACE_POINTS_X;
        Snake.Terrytory[2] = 0;
        Snake.Terrytory[3] = ISettings.WORKSPACE_POINTS_Y;
        this.PatrolRoad.put(0, new Point(this.getX(), this.getY()));
        this.setPatrolRoadInc(0);
        this.setPatrolRoadis(true);

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
     * @return the poisonMax
     */
    public static int getPoisonMax() {
        return poisonMax;
    }

    /**
     * @param aPoisonMax the poisonMax to set
     */
    public static void setPoisonMax(int aPoisonMax) {
        poisonMax = aPoisonMax;
    }

    /**
     * @return the poisonReg
     */
    public static int getPoisonReg() {
        return poisonReg;
    }

    /**
     * @param aPoisonReg the poisonReg to set
     */
    public static void setPoisonReg(int aPoisonReg) {
        poisonReg = aPoisonReg;
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
     * Reprodkcja - losowanie pozycji nowego weża na terytorium(cała mapa) i
     * tworzenie potomka.
     */
    public void reproduct() {

        Snake ant = new Snake(scene);
        Random rand = new Random();

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
     * Reset okresu zmian
     */
    public void resetPeriod() {
        this.period = 0;
    }

    /**
     * @param aktualny stan licznika okresu
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
     * Wykonywanie akcjia okresowych - zwiększenie rozmiaru, wieku i ewewntualna
     * regeneracja trucizny. Zwiększenie licznika urodzenia(born). Jeżeli born
     * równa się tempo rozrodu - powastanie nowego węża i reset licznika.
     */
    public void exPeriod() {

        if (this.getPeriod() == ISettings.PERIOD) {
            this.resetPeriod();
            this.setAge(this.getAge() + Snake.getAgingRate());
            this.setSize(this.getSize() + Snake.getSize_age());
            if (this.getPoison() < Snake.getPoisonMax()) {
                this.setPoison(this.getPoison() + Snake.getPoisonReg());
            } else {
                this.setPoison(Snake.getPoisonMax());
            }

            born++;
        } else {

            this.setPeriod();
        }
        if (born == Snake.getReproductionRate()) {
            this.reproduct();
            this.born = 0;

        }

    }

    /**
     * Cykl życia. Dopóki żyje(stop). Jeżeli ustalona droga żerowania, to
     * patroluje drogę, lub tworzy padlinę. Następnie wykonanie okresowych
     * czynności oraz sprawdzenie funkcji życiowych. Cykl powtarza się co czas w
     * milisekundach równy prędkości.
     *
     * @see Snake.move()
     * @Override
     */
    public void run() {
        while (!isStop()) {
            if (this.isPatrolRoadis()) {


                if (this.getFoodHunt() != 0) {
                    this.CarrionMake();
                } else {
                    patrol();
                }



                this.exPeriod();

                if (!checkLife()) {
                    this.remove();
                }


            }

            try {
                Thread.sleep(Snake.getVelocity());
            } catch (InterruptedException ex) {
                Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Sprawdzenie funkcji życiowych węża
     */
    public boolean checkLife() {
        if (this.getAge() >= ISettings.ANIMAL_DEADLINE) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Tworznie padliny
     */
    public void CarrionMake() {
        Carrion m = new Carrion(this.scene, this.getFoodHunt());
        m.setX(this.getX());
        m.setY(this.getY());
        Board.setCarrion_fields(this.getPointX(), this.getPointY(), m);
        this.setFoodHunt(0);
    }

    /**
     * Ruch węża. Wąż idzie do zadanego punktu, jeżeli na jego drodze nie stoi
     * woda, drzewo albo inny wąż. Następnie sprawdza w synchronizowanym bloku
     * dynamicznego pola do którego ma przejść, czy to co pole zaiwera może
     * zostać zaatakowane. Jeżeli tak i starczy jadu to uśmierca. Zmienna
     * fooHunt zawiera masę ukąszonego zwierzęcia - potrzebne to stworznie
     * padliny. Wąż trać tyle jadu ile wynosi masa ofiary. Jeżeli pole do cleowe
     * nie jest blokowane przechodzi, w przeciwnym razie czeka; Operacje
     * odbywają sią w 2 osiach - poziomo i pionowo.
     */
    public void move(Point goPoint) {
        Random rand = new Random();
        if (this.getY() != goPoint.getY()) {
            if (this.getY() < goPoint.getY() && this.getPointY() < ISettings.WORKSPACE_POINTS_Y - 1) {
                if (!(Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(ISettings.WATER))
                        && !(Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(ISettings.TREE))) {
                    synchronized (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)) {
                        if ((Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(ISettings.ANTELOPE))
                                || (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(ISettings.LION))
                                || (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(ISettings.HYENA))) {
                            if (((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).getSize() < this.getPoison()) {
                                this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).getSize());
                                this.setPoison(this.getPoison() - this.getFoodHunt());
                                ((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).remove();
                            }
                        }
                    }
                    if (!Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).isBlocked()) {
                        Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).setPresence();
                        Board.setDynamic_fields(this.getPointX(), this.getPointY() + 1, this);
                        this.setY(this.getY() + ISettings.FIELD_SIZE);
                        Board.setDynamic_fields(this.getPointX(), this.getPointY() - 1, new Ghost(scene));
                        Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).removePresence();
                    }
                }
            } else {
                if (this.getPointY() > 0) {
                    if (!Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(ISettings.WATER)
                            && !Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(ISettings.TREE)) {
                        synchronized (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)) {
                            if ((Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(ISettings.ANTELOPE))
                                    || (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(ISettings.LION))
                                    || (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(ISettings.HYENA))) {
                                if (((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).getSize() < this.getPoison()) {
                                    this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).getSize());
                                    this.setPoison(this.getPoison() - this.getFoodHunt());
                                    ((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).remove();
                                }
                            }
                        }
                        if (!Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).isBlocked()) {
                            Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).setPresence();
                            Board.setDynamic_fields(this.getPointX(), this.getPointY() - 1, this);
                            this.setY(this.getY() - ISettings.FIELD_SIZE);
                            Board.setDynamic_fields(this.getPointX(), this.getPointY() + 1, new Ghost(scene));
                            Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).removePresence();
                        }
                    }
                }
            }
        } else {
            if (this.getX() != goPoint.getX()) {
                if (this.getX() < goPoint.getX() && this.getPointX() < ISettings.WORKSPACE_POINTS_X - 1) {
                    if (!Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(ISettings.WATER)
                            && !Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(ISettings.TREE)) {
                        synchronized (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())) {
                            if ((Board.getDynamic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(ISettings.ANTELOPE))
                                    || (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(ISettings.LION))
                                    || (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(ISettings.HYENA))) {
                                if (((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).getSize() < this.getPoison()) {
                                    this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).getSize());
                                    this.setPoison(this.getPoison() - this.getFoodHunt());
                                    ((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).remove();
                                }
                            }
                        }
                        if (!Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).isBlocked()) {
                            Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).setPresence();
                            Board.setDynamic_fields(this.getPointX() + 1, this.getPointY(), this);
                            this.setX(this.getX() + ISettings.FIELD_SIZE);
                            Board.setDynamic_fields(this.getPointX() - 1, this.getPointY(), new Ghost(scene));
                            Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).removePresence();
                        }
                    }

                } else {
                    if (this.getPointX() > 0) {
                        if (!Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(ISettings.WATER)
                                && !Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(ISettings.TREE)) {

                            synchronized (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())) {
                                if ((Board.getDynamic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(ISettings.ANTELOPE))
                                        || (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(ISettings.LION))
                                        || (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(ISettings.HYENA))) {
                                    if (((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).getSize() < this.getPoison()) {
                                        this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).getSize());
                                        this.setPoison(this.getPoison() - this.getFoodHunt());
                                        ((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).remove();
                                    }
                                }
                            }
                            if (!Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).isBlocked()) {
                                Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).setPresence();
                                Board.setDynamic_fields(this.getPointX() - 1, this.getPointY(), this);
                                this.setX(this.getX() - ISettings.FIELD_SIZE);
                                Board.setDynamic_fields(this.getPointX() + 1, this.getPointY(), new Ghost(scene));
                                Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).removePresence();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @return the poison
     */
    public int getPoison() {
        return poison;
    }

    /**
     * @param poison the poison to set
     */
    public void setPoison(int poison) {
        this.poison = poison;
    }
}

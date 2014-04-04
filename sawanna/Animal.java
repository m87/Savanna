/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Bartosz Radliński
 */
/**
 * Klasa zwierzęcia
 */
public class Animal extends Field {

    /**
     * Licnik ID
     */
    private static int inc = 0;
    /**
     * ID
     */
    private int ID;
    /**
     * Wiek
     */
    private int age;
    /**
     * Masa
     */
    private int size;
    /**
     * Gdzie malować
     */
    private Board scene;
    /**
     * Kolekcja drogi żerowania
     */
    public HashMap PatrolRoad = new HashMap();
    /**
     * Iterator drogi żerowania do określania indexów w kolekcji
     */
    private int patrolRoadInc;
    /**
     * Zmiana kierunku ruchu podczas żerowania
     */
    private int patrolRoadState;
    /**
     * Czy droga żerownia jest ustalona
     */
    private boolean PatrolRoadis = false;
    /**
     * Stan zwierzęcia - zachowanie w danej chwili - sterowanie zachowaniem
     * zwierzęcia(odpoczynek, patrol, jedzenie itp.)
     */
    private int AnimalState = 0;
    /**
     * Sterowanie pętli życia zwierzęcia
     */
    private boolean stop = false;
    /**
     * Dom zwierzęcia
     */
    private String home;
    /**
     * Miejsce odpoczynku
     */
    private Point RestPlace = null;
    /**
     * Co jest pokarmem zwierzęcia
     */
    private String foodObject;
    /**
     * Zmienna przechowuje masę upolowanej zwierzyny
     */
    private int foodHunt = 0;

    /**
     * Inicjalizacja
     */
    public Animal(Board scene, String spName) {
        super(scene);
        setSpriteName(spName);
        ID = getInc();
        this.scene = scene;
        this.setType(0);
        patrolRoadInc = 0;
        patrolRoadState = 0;
        AnimalState = 0;
        stop = false;
        this.setFoodHunt(0);
        this.PatrolRoad.put(0, new Point(this.getX(), this.getY()));
        this.patrolRoadInc = 0;
        this.PatrolRoadis = true;
    }

    /**
     * Zwiększenie licznika ID
     */
    public static int getInc() {
        return inc++;
    }

    /**
     * Pobranie stanu licznika ID
     */
    public static int sgetInc() {
        return inc;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Sprawdzenie czy zwierze może stać na danym polu
     */
    public boolean canStand(int x, int y) {
        if (!Board.getStatic_fields(x, y).isBlocked()) {
            return true;
        } else {
            if (((Terrain) Board.getStatic_fields(x, y)).isHome(this.getHome()) && Board.getDynamic_fields(x, y).getType() != 0) {
                return true;
            } else {
                return false;
            }

        }

    }

    /**
     * Sprawdzeni czy zwierzę dotarło to punkut docelowego
     */
    public boolean isArrive(Point p) {
        if (this.getX() == p.getX() && this.getY() == p.getY()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Ruch zwierząt do danego punktu docelowego. Jeżeli teren, na który zwierzę
     * chce wejść jest równiną lub domem. W synchronizowanym polu dynamicznym
     * zwierzę sprawdza czy to co się znajduję się na sprawdzanym polu jest
     * pokarmem, jeżeli tak to w przypdaku antylopy nie dzieje się nic
     * (konsumcja przebieg w innym miejscu), w przypadku lwa losowana jest
     * liczba z zakresu szansy upolowania i jeżeli jest <= 0 to lew upolował, w
     * przypadku hieny polowanie kończy się zawsze kończy się sukcesem.
     * Następnie jeżeli pole nie jset blokowane to następuje przemieszczenie.
     * Ruch przebiega w dwuch osiach - poziomo i pionowo.
     */
    public void move(Point goPoint) {
        try {
            Random rand = new Random();
            if (this.getY() != goPoint.getY()) {

                if (this.getY() < goPoint.getY() && this.getPointY() < ISettings.WORKSPACE_POINTS_Y - 1) {

                    if ((Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(ISettings.SAND)
                            || Board.getStatic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(this.getHome()))) {
                        synchronized (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)) {
                            if (Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1).getSpriteName().equals(getFoodObject())) {

                                if (this.getSpriteName().equals(ISettings.LION)) {
                                    if ((rand.nextInt(Lion.getHuntingRate())) - 1 <= 0) {

                                        this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).getSize());
                                        ((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).remove();

                                    }
                                }
                                if (this.getSpriteName().equals(ISettings.HYENA)) {

                                    this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() + 1)).getSize());

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

                        if (Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(ISettings.SAND)
                                || Board.getStatic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(this.getHome())) {
                            synchronized (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)) {
                                if (Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1).getSpriteName().equals(getFoodObject())) {
                                    if (this.getSpriteName().equals(ISettings.LION)) {
                                        if ((rand.nextInt(Lion.getHuntingRate())) - 1 <= 0) {

                                            this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).getSize());

                                            ((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).remove();

                                        }
                                    }
                                    if (this.getSpriteName().equals(ISettings.HYENA)) {

                                        this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX(), this.getPointY() - 1)).getSize());

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


                        if (Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(ISettings.SAND)
                                || Board.getStatic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(this.getHome())) {
                            synchronized (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())) {

                                if (Board.getDynamic_fields(this.getPointX() + 1, this.getPointY()).getSpriteName().equals(getFoodObject())) {
                                    if (this.getSpriteName().equals(ISettings.LION)) {

                                        if ((rand.nextInt(Lion.getHuntingRate())) - 1 <= 0) {

                                            this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).getSize());
                                            ((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).remove();

                                        }
                                    }
                                    if (this.getSpriteName().equals(ISettings.HYENA)) {

                                        this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() + 1, this.getPointY())).getSize());

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

                            if (Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(ISettings.SAND)
                                    || Board.getStatic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(this.getHome())) {

                                synchronized (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())) {
                                    if (Board.getDynamic_fields(this.getPointX() - 1, this.getPointY()).getSpriteName().equals(getFoodObject())) {
                                        if (this.getSpriteName().equals(ISettings.LION)) {

                                            if ((rand.nextInt(Lion.getHuntingRate())) - 1 <= 0) {
                                                this.setFoodHunt(((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).getSize());
                                                ((Animal) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).remove();

                                            }
                                        }
                                        if (this.getSpriteName().equals(ISettings.HYENA)) {

                                            this.setFoodHunt(((Carrion) Board.getDynamic_fields(this.getPointX() - 1, this.getPointY())).getSize());

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

        } catch (java.lang.NullPointerException e) {

            JOptionPane.showMessageDialog(scene,
                    "Brak miejsca docelowego. Prawdopodobnie nie ustalono drogi do wodopoju " + this.getSpriteName() + " ID:" + this.getID(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            Board.setLastWaterPoint(null);
            this.remove();
        }


    }

    /**
     * Patrol - ruch po wyznaczonej trasie żerowania tam i z powrotem
     */
    public void patrol() {

        if (getPatrolRoadState() == 0) {
            if (getPatrolRoadInc() < this.PatrolRoad.size() - 1) {




                this.move((Point) this.PatrolRoad.get(getPatrolRoadInc()));
                if (this.isArrive(((Point) this.PatrolRoad.get(getPatrolRoadInc())))) {
                    setPatrolRoadInc(getPatrolRoadInc() + 1);
                }


            } else {
                setPatrolRoadState(1);
            }

        } else {
            if (getPatrolRoadInc() > 0) {

                this.move((Point) this.PatrolRoad.get(getPatrolRoadInc()));

                if (this.isArrive(((Point) this.PatrolRoad.get(getPatrolRoadInc())))) {
                    setPatrolRoadInc(getPatrolRoadInc() - 1);
                }
            } else {
                setPatrolRoadState(0);
            }



        }



    }

    /**
     * Tworzenie zwierzęcia
     *
     * @see Cykle życia zwierząt
     */
    public void createAnimal(int x, int y, Animal ant) {
        ant.setX(x);
        ant.setY(y);
        Board.setDynamic_fields(this.calcPoint(x), this.calcPoint(y), ant);
        Board.getStatic_fields(this.calcPoint(x), this.calcPoint(y)).setBlocked(true);

        Board.animals.put(ant.getID(), ant);

        ant.PatrolRoad.put(0, new Point(this.getX(), this.getY()));

    }

    /**
     * Usunięcie ziwerzęcia
     */
    public void remove() {

        Board.setDynamic_fields(this.getPointX(), this.getPointY(), new Ghost(this.scene));

        Board.getStatic_fields(this.getPointX(), this.getPointY()).removePresence();

        Board.animals.remove(this.getID());


        this.PatrolRoad.clear();
        this.setStop(true);

    }

    /**
     * @return the home
     */
    public String getHome() {
        return home;
    }

    /**
     * @param home the home to set
     */
    public void setHome(String home) {
        this.home = home;
    }

    /**
     * @return the patrolRoadInc
     */
    public int getPatrolRoadInc() {
        return patrolRoadInc;
    }

    /**
     * @param patrolRoadInc the patrolRoadInc to set
     */
    public void setPatrolRoadInc(int patrolRoadInc) {
        this.patrolRoadInc = patrolRoadInc;
    }

    /**
     * @return the patrolRoadState
     */
    public int getPatrolRoadState() {
        return patrolRoadState;
    }

    /**
     * @param patrolRoadState the patrolRoadState to set
     */
    public void setPatrolRoadState(int patrolRoadState) {
        this.patrolRoadState = patrolRoadState;
    }

    /**
     * @return the PatrolRoadis
     */
    public boolean isPatrolRoadis() {
        return PatrolRoadis;
    }

    /**
     * @param PatrolRoadis the PatrolRoadis to set
     */
    public void setPatrolRoadis(boolean PatrolRoadis) {
        this.PatrolRoadis = PatrolRoadis;
    }

    /**
     * @return the AnimalState
     */
    public int getAnimalState() {
        return AnimalState;
    }

    /**
     * @param AnimalState the AnimalState to set
     */
    public void setAnimalState(int AnimalState) {
        this.AnimalState = AnimalState;
    }

    /**
     * @return the stop
     */
    public boolean isStop() {
        return stop;
    }

    /**
     * @param stop the stop to set
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    /**
     * @return the RestPlace
     */
    public Point getRestPlace() {
        return RestPlace;
    }

    /**
     * @param RestPlace the RestPlace to set
     */
    public void setRestPlace(Point RestPlace) {
        this.RestPlace = RestPlace;
    }

    /**
     * @return the foodObject
     */
    public String getFoodObject() {
        return foodObject;
    }

    /**
     * @param foodObject the foodObject to set
     */
    public void setFoodObject(String foodObject) {
        this.foodObject = foodObject;
    }

    /**
     * @return the foodHunt
     */
    public int getFoodHunt() {
        return foodHunt;
    }

    /**
     * @param foodHunt the foodHunt to set
     */
    public void setFoodHunt(int foodHunt) {
        this.foodHunt = foodHunt;
    }
}

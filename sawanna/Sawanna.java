/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bartosz Radliński
 */
/**
 * Klasa planszy.
 *
 */
class Board extends JPanel implements MouseListener, MouseMotionListener, Runnable {

    /**
     *
     *
     * @return the static_field
     */
    public static Field getStatic_fields(int x, int y) {
        return static_fields[x][y];
    }

    /**
     * @param aStatic_fields the static_fields to set
     */
    public static void setStatic_fields(int x, int y, Field f) {
        static_fields[x][y] = f;
    }

    /**
     *
     *
     * @return the dynamic_field
     */
    public static Field getDynamic_fields(int x, int y) {
        return dynamic_fields[x][y];
    }

    /**
     * @param aDynamic_fields the dynamic_fields to set
     */
    public static void setDynamic_fields(int x, int y, Field f) {
        dynamic_fields[x][y] = f;
    }

    /**
     * @return the temp_fields
     */
    public static Field getTemp_fields(int x, int y) {
        return temp_fields[x][y];
    }

    /**
     *
     * @param aTemp_fields the temp_fields to set
     */
    public static void setTemp_fields(int x, int y, Field f) {
        temp_fields[x][y] = f;
    }

    /**
     *
     *
     * @return the carrion_fields
     */
    public static Field getCarrion_fields(int x, int y) {
        return carrion_fields[x][y];
    }

    /**
     * @param aCarrion_fields the carrion_fields to set
     */
    public static void setCarrion_fields(int x, int y, Field f) {
        carrion_fields[x][y] = f;
    }

    /**
     * @return the boardState
     */
    public static int getBoardState() {
        return boardState;
    }

    /**
     * @param aBoardState the boardState to set
     */
    public static void setBoardState(int aBoardState) {
        boardState = aBoardState;
    }

    /**
     * @return the WorldBuildState
     */
    public static int getWorldBuildState() {
        return WorldBuildState;
    }

    /**
     * @param aWorldBuildState the WorldBuildState to set
     */
    public static void setWorldBuildState(int aWorldBuildState) {
        WorldBuildState = aWorldBuildState;
    }

    /**
     * @return the AnimalCreatorState
     */
    public static int getAnimalCreatorState() {
        return AnimalCreatorState;
    }

    /**
     * @param aAnimalCreatorState the AnimalCreatorState to set
     */
    public static void setAnimalCreatorState(int aAnimalCreatorState) {
        AnimalCreatorState = aAnimalCreatorState;
    }

    /**
     * @return the PatrolMarkerState
     */
    public static int getPatrolMarkerState() {
        return PatrolMarkerState;
    }

    /**
     * @param aPatrolMarkerState the PatrolMarkerState to set
     */
    public static void setPatrolMarkerState(int aPatrolMarkerState) {
        PatrolMarkerState = aPatrolMarkerState;
    }

    /**
     * @return the WaterRoadMarkerState
     */
    public static int getWaterRoadMarkerState() {
        return WaterRoadMarkerState;
    }

    /**
     * @param aWaterRoadMarkerState the WaterRoadMarkerState to set
     */
    public static void setWaterRoadMarkerState(int aWaterRoadMarkerState) {
        WaterRoadMarkerState = aWaterRoadMarkerState;
    }

    /**
     * @return the PatrolAniType
     */
    public static Animal getPatrolAniType() {
        return PatrolAniType;
    }

    /**
     * @param aPatrolAniType the PatrolAniType to set
     */
    public static void setPatrolAniType(Animal aPatrolAniType) {
        PatrolAniType = aPatrolAniType;
    }

    /**
     * @return the markerInc
     */
    public static int getMarkerInc() {
        return markerInc;
    }

    /**
     * @param aMarkerInc the markerInc to set
     */
    public static void setMarkerInc(int aMarkerInc) {
        markerInc = aMarkerInc;
    }

    /**
     * @return the lastWaterPoint
     */
    public static Point getLastWaterPoint() {
        return lastWaterPoint;
    }

    /**
     * @param aLastWaterPoint the lastWaterPoint to set
     */
    public static void setLastWaterPoint(Point aLastWaterPoint) {
        lastWaterPoint = aLastWaterPoint;
    }

    /**
     *
     * @return the sky_fields
     */
    public static Field getSky_fields(int x, int y) {
        return sky_fields[x][y];
    }

    /**
     * @param aSky_fields the sky_fields to set
     */
    public static void setSky_fields(int x, int y, Field f) {
        sky_fields[x][y] = f;
    }
    /**
     * Przechowywanie obrazków obiektów
     */
    private SpriteData spriteData;
    /**
     * Pola statyczne zwierają obiety podłoża oraz informację od blokowaniu
     * danego pola przez zwierzę
     */
    private static Field[][] static_fields;
    /**
     * Pola dynamiczne zawierają obiekty zwierząt naziemnych
     */
    private static Field[][] dynamic_fields;
    /**
     * Pola tymczasowe zawierają obiekty markera - służą do malowania
     * zaznaczenia dróg
     */
    private static Field[][] temp_fields;
    /**
     * Pola z padliną
     */
    private static Field[][] carrion_fields;
    /**
     * Pola powietrzne zawierają obiekty ptaków
     */
    private static Field[][] sky_fields;
    /**
     * Kolekcja żywych zwierząt
     */
    protected static HashMap animals = new HashMap();
    /**
     * Określa akcje po kliknięciu w pole
     */
    private static int boardState = 0;
    /**
     * Określa jaki obiekt terenu tworzyć po kliknięciu podczas budowania świata
     */
    private static int WorldBuildState = 0;
    /**
     * Określe jaki obiekt zwierzęcia tworzyć po kliknięciu
     */
    private static int AnimalCreatorState = 0;
    /**
     * Określa, któremu zwierzęciu przypisać aktualnie zaznaczaną ścieżkę
     * żerowania
     */
    private static int PatrolMarkerState = 0;
    /**
     * Określa, któremu zwierzęciu przypisać aktualnie zaznaczana drogę do
     * wodopoju
     */
    private static int WaterRoadMarkerState = 0;
    /**
     * Pozwala określić, do kórego obiektu zwierzęcia przypisać aktualnie
     * zaznaczoną ścieżkę żerowania
     */
    private static Animal PatrolAniType;
    /**
     * Iterator markera - określa kolejne indexy elementów kolekcji zaznaczanej
     * drogi
     */
    private static int markerInc = 0;
    /**
     * Ostatni zaznaczony punkt drogi do wodopoju - służy do określenia czy
     * droga faktycznie ma połaczenie z wodopojem
     */
    private static Point lastWaterPoint = null;

    /**
     * Inicjalizacja najważniejszych elementów planszy, wypełnianie tablicy pól
     * statycznych obiektami Sand - pozostałe tablice wypełniane są "duchami"
     *
     * @see Ghost
     * @sww ISettings
     */
    Board() {

        spriteData = new SpriteData();
        addMouseListener(this);
        addMouseMotionListener(this);

        boardState = 0;
        WorldBuildState = 0;
        AnimalCreatorState = 0;
        PatrolMarkerState = 0;
        markerInc = 0;
        static_fields = new Field[ISettings.WORKSPACE_POINTS_X][ISettings.WORKSPACE_POINTS_Y];
        dynamic_fields = new Field[ISettings.WORKSPACE_POINTS_X][ISettings.WORKSPACE_POINTS_Y];
        temp_fields = new Field[ISettings.WORKSPACE_POINTS_X][ISettings.WORKSPACE_POINTS_Y];
        carrion_fields = new Field[ISettings.WORKSPACE_POINTS_X][ISettings.WORKSPACE_POINTS_Y];
        sky_fields = new Field[ISettings.WORKSPACE_POINTS_X][ISettings.WORKSPACE_POINTS_Y];

        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                Ghost m = new Ghost(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);

                sky_fields[i][j] = m;
            }
        }


        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                Ghost m = new Ghost(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                dynamic_fields[i][j] = m;
                temp_fields[i][j] = m;
            }
        }

        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                Ghost m = new Ghost(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);

                carrion_fields[i][j] = m;
            }
        }

        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                Sand m = new Sand(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                static_fields[i][j] = m;
            }
        }




    }

    public SpriteData getSpriteData() {
        return spriteData;
    }

    /**
     * Malowanie mapy - najpierw pola podłoża, następnie jeżeli pole nie zawiera
     * zwierzęcia malowania jest padlina, dalej malowane są zwierzęta i na końcu
     * Markery
     *
     * @see Marker
     * @Override
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                getStatic_fields(i, j).paint(g);

                if (getDynamic_fields(i, j).getSpriteName().equals(ISettings.BLANK) && getCarrion_fields(i, j).getSpriteName().equals(ISettings.CARRION)) {
                    dynamic_fields[i][j] = getCarrion_fields(i, j);
                }

                getDynamic_fields(i, j).paint(g);
                getSky_fields(i, j).paint(g);

                getTemp_fields(i, j).paint(g);

            }
        }


    }

    /**
     * Budowanie świata - jeżeli pole nie jest blokowane lub jest wodą(domyślnie
     * blokowane) Stany: 0 - Nie rób nic; 1 - Towrzenie obiektu wody; 2 -
     * Tworzenie obiektu Lwiej Skały; 3 - Tworzenie obiektu Cmentarzyska Słoni;
     * 4 - Tworzenie obiektu drzewa; 5 - Tworzenie obiektu równiny(Sand)
     * Domyślnie tworznie obiektu równiny; Usuwanie przez zastąpienie danego
     * obieku obiektem równiny;
     *
     * @see Sand
     * @see Rock
     * @see EleRock
     * @see Tree
     * @see Water
     */
    public void WorldBuild(int state, int i, int j) {
        if (!getStatic_fields(i, j).isBlocked() || getStatic_fields(i, j).getSpriteName().equals(ISettings.WATER)) {
            switch (state) {
                case 1: {

                    Water m = new Water(this);
                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    static_fields[i][j] = m;

                    break;
                }
                case 2: {

                    Rock m = new Rock(this);
                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    static_fields[i][j] = m;

                    break;
                }
                case 3: {

                    EleRock m = new EleRock(this);
                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    static_fields[i][j] = m;

                    break;
                }
                case 4: {

                    Tree m = new Tree(this);
                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    static_fields[i][j] = m;

                    break;
                }
                case 5: {

                    Sand m = new Sand(this);
                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    static_fields[i][j] = m;

                    break;
                }
                default: {

                    Sand m = new Sand(this);
                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    static_fields[i][j] = m;

                    break;
                }
            }
        }
    }

    /**
     * Towrzenie obiektów zwierząt - jeżeli na polu dynamicznym znajduje się
     * "duch" Ustawia pole statyczne o tych samych współrzędnych jak blokowane
     * Dodaje zwierzę do kolekcji z kluczem ID Start wątku Stany: 0 - Nic nie
     * rób; 1 - Tworznie obiektu antylopy - tylko na równinie; 2 - Tworznie
     * obiektu lwa - tylko na równinie albo Lwiej Skale; 3 - Tworzenie obiektu
     * Hieny - tylko na równinie albo Cmentarzysku Słoni; 4 - Tworzenie obiektu
     * ptaka - bez ograniczeń; 5 - Tworznie obiektu węża - tylko nie na wodzie;
     * 6 - Tworzenie obiektu padliny - tylko nie na wodzie;
     *
     * @see ISettings
     */
    public void AnimalCreator(int state, int i, int j) {
        if (getDynamic_fields(i, j).getSpriteName().equals(ISettings.BLANK)) {
            switch (state) {
                case 1: {
                    if (getStatic_fields(i, j).getSpriteName().equals(ISettings.SAND)) {
                        Antelope m = new Antelope(this);
                        if (m.canStand(i, j)) {
                            m.setX(i * ISettings.FIELD_SIZE);
                            m.setY(j * ISettings.FIELD_SIZE);
                            dynamic_fields[i][j] = m;
                            static_fields[i][j].setBlocked(true);
                            Board.animals.put(m.getID(), m);
                            new Thread(m).start();
                        }
                    }
                    break;
                }
                case 2: {

                    if ((getStatic_fields(i, j).getSpriteName().equals(ISettings.SAND)
                            || getStatic_fields(i, j).getSpriteName().equals(ISettings.ROCK))) {

                        Lion m = new Lion(this);
                        m.setX(i * ISettings.FIELD_SIZE);
                        m.setY(j * ISettings.FIELD_SIZE);
                        dynamic_fields[i][j] = m;
                        static_fields[i][j].setBlocked(true);
                        Board.animals.put(m.getID(), m);
                        new Thread(m).start();

                    }
                    break;
                }
                case 3: {

                    if ((getStatic_fields(i, j).getSpriteName().equals(ISettings.SAND)
                            || getStatic_fields(i, j).getSpriteName().equals(ISettings.ELEROCK))) {

                        Hyena m = new Hyena(this);

                        m.setX(i * ISettings.FIELD_SIZE);
                        m.setY(j * ISettings.FIELD_SIZE);
                        dynamic_fields[i][j] = m;
                        static_fields[i][j].setBlocked(true);
                        Board.animals.put(m.getID(), m);
                        new Thread(m).start();

                    }
                    break;
                }

                case 4: {


                    Bird m = new Bird(this);

                    m.setX(i * ISettings.FIELD_SIZE);
                    m.setY(j * ISettings.FIELD_SIZE);
                    setSky_fields(i, j, m);
                    getSky_fields(i, j).setBlocked(true);
                    Board.animals.put(m.getID(), m);
                    new Thread(m).start();

                    break;
                }


                case 5: {
                    if (!getStatic_fields(i, j).getSpriteName().equals(ISettings.WATER)) {
                        Snake m = new Snake(this);

                        m.setX(i * ISettings.FIELD_SIZE);
                        m.setY(j * ISettings.FIELD_SIZE);
                        dynamic_fields[i][j] = m;
                        static_fields[i][j].setBlocked(true);
                        Board.animals.put(m.getID(), m);
                        new Thread(m).start();
                    }

                    break;
                }


                case 6: {
                    if (!getStatic_fields(i, j).getSpriteName().equals(ISettings.WATER)) {
                        Carrion m = new Carrion(this);
                        m.setX(i * ISettings.FIELD_SIZE);
                        m.setY(j * ISettings.FIELD_SIZE);
                        Board.setCarrion_fields(m.getPointX(), m.getPointY(), m);

                    }
                    break;
                }
            }
        }
    }

    /**
     * Wywołanie okna ustawień obiektu w zależności od typu obiektu
     *
     * @see AnimalSet
     */
    public void AnimalSet(int i, int j) {

        if (Board.getSky_fields(i, j).getSpriteName().equals(ISettings.BIRD)) {
            AnimalSet aniset = new AnimalSet((Bird) getSky_fields(i, j));
            aniset.setVisible(true);

        }

        if (Board.getDynamic_fields(i, j).getSpriteName().equals(ISettings.SNAKE)) {
            AnimalSet aniset = new AnimalSet((Snake) getDynamic_fields(i, j));
            aniset.setVisible(true);

        }

        if (Board.getDynamic_fields(i, j).getSpriteName().equals(ISettings.ANTELOPE)
                || Board.getDynamic_fields(i, j).getSpriteName().equals(ISettings.LION)
                || Board.getDynamic_fields(i, j).getSpriteName().equals(ISettings.HYENA)
                || Board.getDynamic_fields(i, j).getSpriteName().equals(ISettings.CARRION)) {
            AnimalSet aniset = new AnimalSet((Mammal) getDynamic_fields(i, j));
            aniset.setVisible(true);

        }
    }

    /**
     * Zapisywanie drogi do wodopoju do odpowiedniego typu
     */
    public void WaterMarker(int i, int j, int state) {
        Marker m = new Marker(this);
        m.setX(i * ISettings.FIELD_SIZE);
        m.setY(j * ISettings.FIELD_SIZE);
        setTemp_fields(i, j, m);
        Board.setLastWaterPoint(m);
        switch (state) {
            case 0: {
                Antelope.WaterPlaceRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                break;
            }
            case 1: {
                Lion.WaterPlaceRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                break;
            }

            case 2: {
                Hyena.WaterPlaceRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                break;
            }



        }
        setMarkerInc(getMarkerInc() + 1);
    }

    /**
     * Zapisywanie drogi żerowania (lub gnizada) w zależności od stanu
     * PatrolMarkerState. Stany : 0 - Antylopa; 1 - Lew; 2 - Hiena; 3 - Ptak; 4
     * - Wąż; 5 - Zapisanie pozycji gniazda Ptaka;
     */
    public void PatrolMarker(Animal ani, int i, int j, int state) {

        switch (state) {
            case 0: {

                Marker m = new Marker(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                if (ani.canStand(i, j)) {
                    setTemp_fields(i, j, m);
                    ((Antelope) ani).PatrolRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                    setMarkerInc(getMarkerInc() + 1);
                }
                break;
            }



            case 1: {

                Marker m = new Marker(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                if (ani.canStand(i, j)) {
                    setTemp_fields(i, j, m);
                    ((Lion) ani).PatrolRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                    setMarkerInc(getMarkerInc() + 1);
                }
                break;

            }

            case 2: {

                Marker m = new Marker(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                if (ani.canStand(i, j)) {
                    setTemp_fields(i, j, m);
                    ((Hyena) ani).PatrolRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                    setMarkerInc(getMarkerInc() + 1);
                }
                break;
            }

            case 3: {

                Marker m = new Marker(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                if (ani.canStand(i, j)) {
                    setTemp_fields(i, j, m);
                    ((Bird) ani).PatrolRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                    setMarkerInc(getMarkerInc() + 1);
                }
                break;
            }
            case 4: {

                Marker m = new Marker(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                if (ani.canStand(i, j)) {
                    setTemp_fields(i, j, m);
                    ((Snake) ani).PatrolRoad.put(getMarkerInc(), new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));
                    setMarkerInc(getMarkerInc() + 1);
                }
                break;
            }
            case 5: {

                Marker m = new Marker(this);
                m.setX(i * ISettings.FIELD_SIZE);
                m.setY(j * ISettings.FIELD_SIZE);
                if (getStatic_fields(i, j).getSpriteName().equals(ISettings.TREE)) {
                    setTemp_fields(i, j, m);
                    ((Bird) ani).setNest(new Point(i * ISettings.FIELD_SIZE, j * ISettings.FIELD_SIZE));

                }
                break;
            }

        }

    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
    }

    /**
     * Wywołanie odpowiedniej akcji po kliknięciu w zależności od stanu
     * BoardState. Stany: 0 - Budowanie świata; 1 - Tworzenie zwierząt; 2 -
     * Zaznaczanie drogi do wodopoju; 3 - Zaznaczenie drogi żerownia lub
     * gniazda; Oprócz tego wywołanie okan ustawieni zwierzęcia
     *
     * @Override
     */
    public void mouseClicked(MouseEvent e) {



        for (int i = 0; i < ISettings.WORKSPACE_POINTS_X; i++) {
            for (int j = 0; j < ISettings.WORKSPACE_POINTS_Y; j++) {
                if (e.getX() >= i * ISettings.FIELD_SIZE && e.getX() <= (i + 1) * ISettings.FIELD_SIZE && e.getY() >= j * ISettings.FIELD_SIZE
                        && e.getY() <= (j + 1) * ISettings.FIELD_SIZE) {

                    if (!getDynamic_fields(i, j).getSpriteName().equals(ISettings.BLANK)
                            || !sky_fields[i][j].getSpriteName().equals(ISettings.BLANK)) {
                        this.AnimalSet(i, j);
                    }

                    switch (getBoardState()) {
                        case 0: {
                            this.WorldBuild(getWorldBuildState(), i, j);
                            break;
                        }
                        case 1: {
                            this.AnimalCreator(getAnimalCreatorState(), i, j);
                            break;
                        }
                        case 2: {
                            this.WaterMarker(i, j, getWaterRoadMarkerState());
                            break;
                        }

                        case 3: {

                            this.PatrolMarker(getPatrolAniType(), i, j, getPatrolMarkerState());
                            break;
                        }
                    }

                }

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Odmalowanie mapy co kwant czasu
     *
     * @see ISettings
     */
    @Override
    public void run() {

        while (true) {

            this.repaint();
            try {
                Thread.sleep(ISettings.SZYBKOSC);
            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

/**
 * Głóna klasa gry
 */
public class Sawanna {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                init();
            }
        });
    }

    /**
     * Inicjalizacja obiektu planszy i okan gry
     */
    private static void init() {
        JFrame f = new JFrame("Sawanna");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(ISettings.SZEROKOSC, ISettings.WYSOKOSC);

        Board p = new Board();
        SetUp set = new SetUp();

        set.setVisible(true);
        f.add(p);


        f.setVisible(true);

        new Thread(p).start();
    }
}
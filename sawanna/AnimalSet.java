/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawanna;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bartosz Radliński
 */
public class AnimalSet extends javax.swing.JFrame {

    /**
     * Ssak
     */
    private Mammal f = null;
    /**
     * Wąż
     */
    private Snake s = null;
    /**
     * Ptak
     */
    private Bird b = null;
    /**
     * Stan - okeśla typ zwierzęcia 0 - antylopa; 1 - lew; 2 - hiena; 3 - ptak;
     * 4 - wąż; 6 - padlina;
     */
    public int state;

    /**
     * Creates new form AnimalSet
     */
    public AnimalSet() {
        initComponents();
    }

    public AnimalSet(Mammal f) {
        initComponents();
        this.f = f;
        this.s = null;
        this.b = null;
    }

    public AnimalSet(Snake s) {
        initComponents();
        this.s = s;
        this.f = null;
        this.b = null;
    }

    public AnimalSet(Bird b) {
        initComponents();
        this.b = b;
        this.f = null;
        this.s = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SetPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        XLabel = new javax.swing.JLabel();
        YLabel = new javax.swing.JLabel();
        FoodLabel = new javax.swing.JLabel();
        WaterLabel = new javax.swing.JLabel();
        AppLabel = new javax.swing.JLabel();
        SizeLabel = new javax.swing.JLabel();
        AgeLabel = new javax.swing.JLabel();
        WRMarkerButton = new javax.swing.JButton();
        WPOKButton = new javax.swing.JButton();
        RoadButton = new javax.swing.JButton();
        OKRoadButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Size_ageSlider = new javax.swing.JSlider();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        AgingSlider = new javax.swing.JSlider();
        ReproSlider = new javax.swing.JSlider();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        EatRateSlider = new javax.swing.JSlider();
        DrinkRateSlider = new javax.swing.JSlider();
        EnergyRateSlider = new javax.swing.JSlider();
        LionSetPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        HuntingRateSlider = new javax.swing.JSlider();
        RestTimeSlider = new javax.swing.JSlider();
        HyenaSetPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        H_RTSlider = new javax.swing.JSlider();
        VelSlider = new javax.swing.JSlider();
        BirdSetPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        BirdIDLabel = new javax.swing.JLabel();
        BirdXLabel = new javax.swing.JLabel();
        BirdYLabel = new javax.swing.JLabel();
        BirdHLabel = new javax.swing.JLabel();
        BirdEatLabel = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        BirdAppLabel = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        BirdAgeLabel = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        BirdVelSlider = new javax.swing.JSlider();
        BirdReproSlider = new javax.swing.JSlider();
        BirdAgingSlider = new javax.swing.JSlider();
        BirdEatSlider = new javax.swing.JSlider();
        BirdEnergySlider = new javax.swing.JSlider();
        BirdHuntSlider = new javax.swing.JSlider();
        NestButton = new javax.swing.JButton();
        SnakePanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        PoisonSlider = new javax.swing.JSlider();
        PoisonRegSlider = new javax.swing.JSlider();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        SnakeIDLabel = new javax.swing.JLabel();
        XSnakeLabel = new javax.swing.JLabel();
        YSnakeLabel = new javax.swing.JLabel();
        SizeSnakeLabel = new javax.swing.JLabel();
        AgeSnakeLabel = new javax.swing.JLabel();
        SnakeRoadButton = new javax.swing.JButton();
        SnakeOKRoadButton = new javax.swing.JButton();
        SnakeRemoveButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        SnakeAgingSlider = new javax.swing.JSlider();
        SnakeVelSlider = new javax.swing.JSlider();
        SnakeSizeSlider = new javax.swing.JSlider();
        SnakeReproSlider = new javax.swing.JSlider();
        jLabel30 = new javax.swing.JLabel();
        PoisonLabel = new javax.swing.JLabel();
        CarrionPanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        CarrionLabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(300, 580));
        setPreferredSize(new java.awt.Dimension(300, 580));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("X:");

        jLabel3.setText("Y:");

        jLabel4.setText("Jedzenie:");

        jLabel5.setText("Woda:");

        jLabel6.setText("Apetyt:");

        jLabel7.setText("Masa:");

        jLabel8.setText("Wiek:");

        IDLabel.setText(null);

        XLabel.setText(null);

        YLabel.setText(null);

        FoodLabel.setText(null);

        WaterLabel.setText(null);

        AppLabel.setText(null);

        SizeLabel.setText(null);

        AgeLabel.setText(null);

        WRMarkerButton.setText("Droga do wody");
        WRMarkerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WRMarkerButtonActionPerformed(evt);
            }
        });

        WPOKButton.setText("OK");
        WPOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WPOKButtonActionPerformed(evt);
            }
        });

        RoadButton.setText("Trasa");
        RoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoadButtonActionPerformed(evt);
            }
        });

        OKRoadButton.setText("OK");
        OKRoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKRoadButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Usuń");
        RemoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveButtonMouseClicked(evt);
            }
        });
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Prędkość");

        jLabel11.setText("Wzrost");

        Size_ageSlider.setMinimum(1);
        Size_ageSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Size_ageSliderMouseDragged(evt);
            }
        });

        jLabel12.setText("Starzenie");

        jLabel13.setText("Rozród");

        AgingSlider.setMaximum(20);
        AgingSlider.setMinimum(1);
        AgingSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                AgingSliderMouseDragged(evt);
            }
        });

        ReproSlider.setMaximum(300);
        ReproSlider.setMinimum(1);
        ReproSlider.setInverted(true);
        ReproSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ReproSliderMouseDragged(evt);
            }
        });

        jLabel14.setText("Jedzenie");

        jLabel15.setText("Picie");

        jLabel16.setText("Spalanie");

        EatRateSlider.setMinimum(5);
        EatRateSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                EatRateSliderMouseDragged(evt);
            }
        });

        DrinkRateSlider.setMinimum(5);
        DrinkRateSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                DrinkRateSliderMouseDragged(evt);
            }
        });

        EnergyRateSlider.setMaximum(10);
        EnergyRateSlider.setMinimum(1);
        EnergyRateSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                EnergyRateSliderMouseDragged(evt);
            }
        });

        LionSetPanel.setAlignmentX(0.0F);
        LionSetPanel.setAlignmentY(0.0F);
        LionSetPanel.setAutoscrolls(true);

        jLabel17.setText("Polowanie");

        jLabel18.setText("Odpoczynek");

        HuntingRateSlider.setMaximum(20);
        HuntingRateSlider.setMinimum(1);
        HuntingRateSlider.setInverted(true);
        HuntingRateSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HuntingRateSliderMouseDragged(evt);
            }
        });

        RestTimeSlider.setMaximum(300);
        RestTimeSlider.setMinimum(1);
        RestTimeSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                RestTimeSliderMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout LionSetPanelLayout = new javax.swing.GroupLayout(LionSetPanel);
        LionSetPanel.setLayout(LionSetPanelLayout);
        LionSetPanelLayout.setHorizontalGroup(
            LionSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LionSetPanelLayout.createSequentialGroup()
                .addGroup(LionSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(36, 36, 36)
                .addGroup(LionSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HuntingRateSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(RestTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        LionSetPanelLayout.setVerticalGroup(
            LionSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LionSetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LionSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(HuntingRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LionSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(RestTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel19.setText("Odpocznek");

        H_RTSlider.setMaximum(300);
        H_RTSlider.setMinimum(1);
        H_RTSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                H_RTSliderMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout HyenaSetPanelLayout = new javax.swing.GroupLayout(HyenaSetPanel);
        HyenaSetPanel.setLayout(HyenaSetPanelLayout);
        HyenaSetPanelLayout.setHorizontalGroup(
            HyenaSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HyenaSetPanelLayout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(H_RTSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        HyenaSetPanelLayout.setVerticalGroup(
            HyenaSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HyenaSetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HyenaSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(H_RTSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        VelSlider.setMaximum(500);
        VelSlider.setMinimum(50);
        VelSlider.setInverted(true);
        VelSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                VelSliderMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout SetPanelLayout = new javax.swing.GroupLayout(SetPanel);
        SetPanel.setLayout(SetPanelLayout);
        SetPanelLayout.setHorizontalGroup(
            SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetPanelLayout.createSequentialGroup()
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(WRMarkerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WPOKButton))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(RoadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OKRoadButton))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(XLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(YLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FoodLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WaterLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AppLabel))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SizeLabel))
                    .addComponent(RemoveButton)
                    .addComponent(HyenaSetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LionSetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel11))
                            .addGroup(SetPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel12))
                            .addGroup(SetPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15))
                            .addGroup(SetPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14))))
                        .addGap(23, 23, 23)
                        .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ReproSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DrinkRateSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VelSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Size_ageSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EatRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AgingSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EnergyRateSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SetPanelLayout.setVerticalGroup(
            SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetPanelLayout.createSequentialGroup()
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(XLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(YLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FoodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(WaterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(AppLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(SizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(AgeLabel))
                .addGap(33, 33, 33)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WRMarkerButton)
                    .addComponent(WPOKButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoadButton)
                    .addComponent(OKRoadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RemoveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(VelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SetPanelLayout.createSequentialGroup()
                        .addComponent(Size_ageSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReproSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addGap(8, 8, 8)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(AgingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EatRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DrinkRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(EnergyRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LionSetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HyenaSetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel31.setText("ID:");

        jLabel32.setText("X:");

        jLabel33.setText("Y:");

        jLabel34.setText("H:");

        jLabel35.setText("Jedzenie");

        jButton1.setText("Trasa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Usuń");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel36.setText("Prędkość");

        jLabel37.setText("Rozród");

        jLabel38.setText("Starzenie");

        jLabel39.setText("Jedzenie");

        BirdIDLabel.setText(null);

        BirdXLabel.setText(null);

        BirdYLabel.setText(null);

        BirdHLabel.setText(null);

        BirdEatLabel.setText(null);

        jLabel45.setText("Apetyt");

        BirdAppLabel.setText(null);

        jLabel48.setText("Wiek:");

        BirdAgeLabel.setText(null);

        jLabel51.setText("Spalanie");

        jLabel52.setText("Polowanie");

        BirdVelSlider.setMaximum(500);
        BirdVelSlider.setMinimum(50);
        BirdVelSlider.setInverted(true);
        BirdVelSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BirdVelSliderMouseDragged(evt);
            }
        });

        BirdReproSlider.setMaximum(500);
        BirdReproSlider.setMinimum(1);
        BirdReproSlider.setInverted(true);
        BirdReproSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BirdReproSliderMouseDragged(evt);
            }
        });

        BirdAgingSlider.setMaximum(20);
        BirdAgingSlider.setMinimum(1);
        BirdAgingSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BirdAgingSliderMouseDragged(evt);
            }
        });

        BirdEatSlider.setMinimum(5);
        BirdEatSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BirdEatSliderMouseDragged(evt);
            }
        });

        BirdEnergySlider.setMaximum(10);
        BirdEnergySlider.setMinimum(1);
        BirdEnergySlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BirdEnergySliderMouseDragged(evt);
            }
        });

        BirdHuntSlider.setMaximum(20);
        BirdHuntSlider.setMinimum(1);
        BirdHuntSlider.setInverted(true);
        BirdHuntSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BirdHuntSliderMouseDragged(evt);
            }
        });

        NestButton.setText("Gniazdo");
        NestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BirdSetPanelLayout = new javax.swing.GroupLayout(BirdSetPanel);
        BirdSetPanel.setLayout(BirdSetPanelLayout);
        BirdSetPanelLayout.setHorizontalGroup(
            BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BirdSetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BirdSetPanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jButton3)
                    .addGroup(BirdSetPanelLayout.createSequentialGroup()
                        .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addGap(19, 19, 19)
                        .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BirdVelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirdReproSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirdAgingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirdEatSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirdEnergySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirdHuntSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BirdSetPanelLayout.createSequentialGroup()
                        .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel45)
                            .addComponent(jLabel48))
                        .addGap(33, 33, 33)
                        .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BirdAgeLabel)
                            .addComponent(BirdEatLabel)
                            .addComponent(BirdHLabel)
                            .addComponent(BirdYLabel)
                            .addComponent(BirdXLabel)
                            .addComponent(BirdIDLabel)
                            .addComponent(BirdAppLabel)))
                    .addComponent(NestButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        BirdSetPanelLayout.setVerticalGroup(
            BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BirdSetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(BirdIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(BirdXLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(BirdYLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(BirdHLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(BirdEatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BirdAppLabel)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(BirdAgeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BirdSetPanelLayout.createSequentialGroup()
                        .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BirdSetPanelLayout.createSequentialGroup()
                        .addComponent(NestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(10, 10, 10)))
                .addGroup(BirdSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BirdSetPanelLayout.createSequentialGroup()
                        .addComponent(BirdVelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BirdReproSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BirdAgingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BirdEatSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BirdEnergySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BirdHuntSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BirdSetPanelLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel52)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setText("Trucizna");

        jLabel21.setText("Regeneracja");

        PoisonSlider.setMaximum(500);
        PoisonSlider.setMinimum(1);
        PoisonSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PoisonSliderMouseDragged(evt);
            }
        });

        PoisonRegSlider.setMaximum(50);
        PoisonRegSlider.setMinimum(1);
        PoisonRegSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PoisonRegSliderMouseDragged(evt);
            }
        });

        jLabel22.setText("ID:");

        jLabel23.setText("X:");

        jLabel24.setText("Y:");

        jLabel25.setText("Masa:");

        jLabel26.setText("Wiek:");

        SnakeIDLabel.setText(null);

        XSnakeLabel.setText(null);

        YSnakeLabel.setText(null);

        SizeSnakeLabel.setText(null);

        AgeSnakeLabel.setText(null);

        SnakeRoadButton.setText("Trasa");
        SnakeRoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SnakeRoadButtonActionPerformed(evt);
            }
        });

        SnakeOKRoadButton.setText("OK");
        SnakeOKRoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SnakeOKRoadButtonActionPerformed(evt);
            }
        });

        SnakeRemoveButton.setText("Usuń");
        SnakeRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SnakeRemoveButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Prędkość");

        jLabel27.setText("Wzrost");

        jLabel28.setText("Rozród");

        jLabel29.setText("Starzenie");

        SnakeAgingSlider.setMaximum(20);
        SnakeAgingSlider.setMinimum(1);
        SnakeAgingSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SnakeAgingSliderMouseDragged(evt);
            }
        });

        SnakeVelSlider.setMaximum(500);
        SnakeVelSlider.setMinimum(50);
        SnakeVelSlider.setInverted(true);
        SnakeVelSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SnakeVelSliderMouseDragged(evt);
            }
        });

        SnakeSizeSlider.setMinimum(1);
        SnakeSizeSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SnakeSizeSliderMouseDragged(evt);
            }
        });

        SnakeReproSlider.setMaximum(500);
        SnakeReproSlider.setMinimum(1);
        SnakeReproSlider.setInverted(true);
        SnakeReproSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                SnakeReproSliderMouseDragged(evt);
            }
        });

        jLabel30.setText("Trucizna:");

        PoisonLabel.setText(null);

        javax.swing.GroupLayout SnakePanelLayout = new javax.swing.GroupLayout(SnakePanel);
        SnakePanel.setLayout(SnakePanelLayout);
        SnakePanelLayout.setHorizontalGroup(
            SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnakePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PoisonSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(PoisonRegSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(XSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SizeSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SnakeIDLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(SnakeRoadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SnakeOKRoadButton))
                    .addComponent(SnakeRemoveButton)
                    .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SnakePanelLayout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SnakeReproSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SnakePanelLayout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SnakeSizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SnakePanelLayout.createSequentialGroup()
                            .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel9))
                            .addGap(29, 29, 29)
                            .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SnakeAgingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SnakeVelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PoisonLabel)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        SnakePanelLayout.setVerticalGroup(
            SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnakePanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26))
                    .addComponent(SnakeIDLabel)
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(XSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(YSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(SizeSnakeLabel))
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(AgeSnakeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(PoisonLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SnakePanelLayout.createSequentialGroup()
                        .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SnakeRoadButton)
                            .addComponent(SnakeOKRoadButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SnakeRemoveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(SnakeVelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27))
                    .addComponent(SnakeSizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(SnakeReproSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(SnakeAgingSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(PoisonSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SnakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(PoisonRegSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel40.setText("Masa:");

        CarrionLabel.setText(null);

        jButton4.setText("Usuń");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CarrionPanelLayout = new javax.swing.GroupLayout(CarrionPanel);
        CarrionPanel.setLayout(CarrionPanelLayout);
        CarrionPanelLayout.setHorizontalGroup(
            CarrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarrionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CarrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CarrionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(CarrionLabel))
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CarrionPanelLayout.setVerticalGroup(
            CarrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CarrionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CarrionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(CarrionLabel))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SnakePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarrionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BirdSetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(SnakePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarrionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(BirdSetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Rozpoznawanie zwierzęcia - określenie odpowiedniego stanu; -1 -
     * nierozpoznany
     *
     */
    public int recognizeAnimal() {
        if (f != null) {
            if (((Animal) f).getSpriteName().equals(ISettings.ANTELOPE)) {
                return 0;
            }
            if (((Animal) f).getSpriteName().equals(ISettings.LION)) {
                return 1;
            }
            if (((Animal) f).getSpriteName().equals(ISettings.HYENA)) {
                return 2;
            }

            if (((Animal) f).getSpriteName().equals(ISettings.CARRION)) {
                return 6;
            }
            Board.setPatrolAniType(f);

        }

        if (b != null) {
            Board.setPatrolAniType(b);
            return 3;

        }

        if (s != null) {
            Board.setPatrolAniType(s);
            return 4;
        }
        return -1;
    }

    /**
     * Otwarcie okna budowanie menu w zależności od typu zwierzęcia
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        state = this.recognizeAnimal();
        Board.setWaterRoadMarkerState(state);
        Board.setPatrolMarkerState(state);
        LionSetPanel.setVisible(false);
        HyenaSetPanel.setVisible(false);
        SnakePanel.setVisible(false);
        SetPanel.setVisible(false);
        BirdSetPanel.setVisible(false);
        CarrionPanel.setVisible(false);


        switch (state) {

            case 0: {
                SetPanel.setAlignmentX(0);
                SetPanel.setAlignmentY(0);
                SetPanel.setVisible(true);
                IDLabel.setText(new Integer(f.getID()).toString());
                VelSlider.setValue(Antelope.getVelocity());
                EatRateSlider.setValue(Antelope.getEatingRate());
                DrinkRateSlider.setValue(Antelope.getDrinkingRate());
                EnergyRateSlider.setValue(Antelope.getEnergyRate());
                Size_ageSlider.setValue(Antelope.getSize_age());
                AgingSlider.setValue(Antelope.getAgingRate());
                ReproSlider.setValue(Antelope.getReproductionRate());
                this.uptodate(state);
                for (int z = 0; z < f.PatrolRoad.size(); z++) {
                    Marker m = new Marker(f.scene);
                    m.setX(((Point) f.PatrolRoad.get(z)).getX());
                    m.setY(((Point) f.PatrolRoad.get(z)).getY());
                    Board.setTemp_fields(m.getPointX(), m.getPointY(), m);

                }

                break;
            }


            case 1: {
                IDLabel.setText(new Integer(f.getID()).toString());
                SetPanel.setAlignmentX(0);
                SetPanel.setAlignmentY(0);
                SetPanel.setVisible(true);
                LionSetPanel.setVisible(true);
                HuntingRateSlider.setValue(Lion.getHuntingRate());
                RestTimeSlider.setValue(Lion.getRestTime());
                VelSlider.setValue(Lion.getVelocity());
                EatRateSlider.setValue(Lion.getEatingRate());
                DrinkRateSlider.setValue(Lion.getDrinkingRate());
                EnergyRateSlider.setValue(Lion.getEnergyRate());
                Size_ageSlider.setValue(Lion.getSize_age());
                AgingSlider.setValue(Lion.getAgingRate());
                ReproSlider.setValue(Lion.getReproductionRate());
                this.uptodate(1);
                for (int z = 0; z < f.PatrolRoad.size(); z++) {
                    Marker m = new Marker(f.scene);
                    m.setX(((Point) f.PatrolRoad.get(z)).getX());
                    m.setY(((Point) f.PatrolRoad.get(z)).getY());
                    Board.setTemp_fields(m.getPointX(), m.getPointY(), m);
                }

                break;
            }


            case 2: {
                SetPanel.setAlignmentX(0);
                SetPanel.setAlignmentY(0);
                SetPanel.setVisible(true);
                HyenaSetPanel.setVisible(true);
                IDLabel.setText(new Integer(f.getID()).toString());
                H_RTSlider.setValue(Hyena.getRestTime());
                VelSlider.setValue(Hyena.getVelocity());
                EatRateSlider.setValue(Hyena.getEatingRate());
                DrinkRateSlider.setValue(Hyena.getDrinkingRate());
                EnergyRateSlider.setValue(Hyena.getEnergyRate());
                Size_ageSlider.setValue(Hyena.getSize_age());
                AgingSlider.setValue(Hyena.getAgingRate());
                ReproSlider.setValue(Hyena.getReproductionRate());
                this.uptodate(2);
                for (int z = 0; z < f.PatrolRoad.size(); z++) {
                    Marker m = new Marker(f.scene);
                    m.setX(((Point) f.PatrolRoad.get(z)).getX());
                    m.setY(((Point) f.PatrolRoad.get(z)).getY());
                    Board.setTemp_fields(m.getPointX(), m.getPointY(), m);

                }

                break;
            }

            case 3: {

                SetPanel.setVisible(false);
                BirdSetPanel.setAlignmentX(0);
                BirdSetPanel.setAlignmentY(0);
                BirdSetPanel.setVisible(true);
                BirdIDLabel.setText(new Integer(b.getID()).toString());
                BirdVelSlider.setValue(Bird.getVelocity());
                BirdAgingSlider.setValue(Bird.getAgingRate());
                BirdReproSlider.setValue(Bird.getReproductionRate());
                BirdHuntSlider.setValue(Bird.getHuntingRate());



                this.uptodate(3);

                for (int z = 0; z < b.PatrolRoad.size(); z++) {

                    Marker m = new Marker(b.scene);
                    m.setX(((Point) b.PatrolRoad.get(z)).getX());
                    m.setY(((Point) b.PatrolRoad.get(z)).getY());
                    Board.setTemp_fields(m.getPointX(), m.getPointY(), m);

                }

                break;
            }

            case 4: {

                SetPanel.setVisible(false);
                SnakePanel.setAlignmentX(0);
                SnakePanel.setAlignmentY(0);
                SnakePanel.setVisible(true);
                SnakeIDLabel.setText(new Integer(s.getID()).toString());
                SnakeVelSlider.setValue(Snake.getVelocity());
                SnakeSizeSlider.setValue(Snake.getSize_age());
                SnakeAgingSlider.setValue(Snake.getAgingRate());
                SnakeReproSlider.setValue(Snake.getReproductionRate());
                PoisonSlider.setValue(Snake.getPoisonMax());
                PoisonRegSlider.setValue(Snake.getPoisonReg());
                this.uptodate(4);

                for (int z = 0; z < s.PatrolRoad.size(); z++) {

                    Marker m = new Marker(s.scene);
                    m.setX(((Point) s.PatrolRoad.get(z)).getX());
                    m.setY(((Point) s.PatrolRoad.get(z)).getY());

                    Board.setTemp_fields(m.getPointX(), m.getPointY(), m);

                }

                break;
            }

            case 6: {
                SetPanel.setVisible(false);
                CarrionPanel.setAlignmentX(0);
                CarrionPanel.setAlignmentY(0);
                CarrionPanel.setVisible(true);
                this.uptodate(6);

                break;
            }
        }
    }//GEN-LAST:event_formWindowOpened
    /**
     * Ustalenie stanu zaznaczania drogi do wodopoju i wyświetlnie aktualnej
     * drogi do wodopoju
     */
    private void WRMarkerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WRMarkerButtonActionPerformed

        Board.setBoardState(2);
        Board.setMarkerInc(0);

        Marker.removeMarker(f.scene);
        if (f.getSpriteName().equals(ISettings.ANTELOPE)) {
            for (int z = 0; z < Antelope.WaterPlaceRoad.size(); z++) {

                Marker m = new Marker(f.scene);
                m.setX(((Point) Antelope.WaterPlaceRoad.get(z)).getX());
                m.setY(((Point) Antelope.WaterPlaceRoad.get(z)).getY());



                Board.setTemp_fields(m.getPointX(), m.getPointY(), m);
            }
            Antelope.WaterPlaceRoad.clear();



        }
        if (f.getSpriteName().equals(ISettings.LION)) {
            for (int z = 0; z < Lion.WaterPlaceRoad.size(); z++) {

                Marker m = new Marker(f.scene);
                m.setX(((Point) Lion.WaterPlaceRoad.get(z)).getX());
                m.setY(((Point) Lion.WaterPlaceRoad.get(z)).getY());



                Board.setTemp_fields(m.getPointX(), m.getPointY(), m);
            }
            Lion.WaterPlaceRoad.clear();


        }
        if (f.getSpriteName().equals(ISettings.HYENA)) {
            for (int z = 0; z < Hyena.WaterPlaceRoad.size(); z++) {

                Marker m = new Marker(f.scene);
                m.setX(((Point) Hyena.WaterPlaceRoad.get(z)).getX());
                m.setY(((Point) Hyena.WaterPlaceRoad.get(z)).getY());



                Board.setTemp_fields(m.getPointX(), m.getPointY(), m);
            }
            Hyena.WaterPlaceRoad.clear();


        }
    }//GEN-LAST:event_WRMarkerButtonActionPerformed
    /**
     * Zapisywanie drogi do wodopoju, sprawdzenie czy jest połaczenie z wodą i
     * wyświetlenie ewentualnego komunikatu o błędzie
     */
    private void WPOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WPOKButtonActionPerformed

        if (checkWaterPlace()) {
            Board.setBoardState(0);

            Board.setMarkerInc(0);
            Board.setWaterRoadMarkerState(-1);


            Marker.removeMarker(f.scene);
        } else {


            JOptionPane.showMessageDialog(this,
                    "Drog nie ma połączenia z wodą!!!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            Board.setLastWaterPoint(null);

        }
    }//GEN-LAST:event_WPOKButtonActionPerformed
    /**
     * Sprawdzenie połaczenia ścieżki z wodopojem. Ostatni element drogi mus
     * istykać się scianą lub rogiem z polem wody Ignorowanie wyjątków
     * przekroczenia indexu tablicy, wystąpienie wyjatku nie ma znaczenia dla
     * działania gry.
     */
    public boolean checkWaterPlace() {
        int x, y;
        if (Board.getLastWaterPoint() != null) {
            x = Board.getLastWaterPoint().getPointX();
            y = Board.getLastWaterPoint().getPointY();
            try {
                if (Board.getStatic_fields(x + 1, y).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x, y + 1).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x - 1, y).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x, y - 1).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x + 1, y + 1).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x + 1, y - 1).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x - 1, y + 1).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (Board.getStatic_fields(x - 1, y - 1).getSpriteName().equals(ISettings.WATER)) {
                    return true;
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            }
            return false;
        } else {
            return false;
        }

    }

    /**
     * Ustalanie nowej ścieżki żerowania i wyświetlanie aktualnej (ssaki)
     */
    private void RoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoadButtonActionPerformed
        Board.setBoardState(3);

        Board.setMarkerInc(0);


        Board.setPatrolAniType(f);
        f.setPatrolRoadis(false);
        for (int z = 0; z < f.PatrolRoad.size(); z++) {

            Marker m = new Marker(f.scene);
            m.setX(((Point) f.PatrolRoad.get(z)).getX());
            m.setY(((Point) f.PatrolRoad.get(z)).getY());



            Board.setTemp_fields(m.getPointX(), m.getPointY(), m);
        }


        Board.setPatrolMarkerState(state);

        f.PatrolRoad.clear();


    }//GEN-LAST:event_RoadButtonActionPerformed
    /**
     * Zapisanie drogi żerowania
     */
    private void OKRoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKRoadButtonActionPerformed

        Board.setBoardState(0);

        Board.setMarkerInc(0);
        Board.setPatrolAniType(null);


        f.setPatrolRoadis(true);
        Marker.removeMarker(f.scene);

        if (!((Animal) f).PatrolRoad.isEmpty()) {
            ((Animal) f).setPatrolRoadis(true);
        }






    }//GEN-LAST:event_OKRoadButtonActionPerformed
    /**
     * Oczyszczanie okan z markerów
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (f != null) {
            Marker.removeMarker(f.scene);
        }
        if (s != null) {
            Marker.removeMarker(s.scene);
        }
        if (b != null) {
            Marker.removeMarker(b.scene);
        }

        Board.setBoardState(1);
    }//GEN-LAST:event_formWindowClosed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
    }//GEN-LAST:event_formMouseMoved

    private void RemoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveButtonMouseClicked
    }//GEN-LAST:event_RemoveButtonMouseClicked
    /**
     * Usuwanie ssaka
     */
    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        f.remove();
        this.dispose();
    }//GEN-LAST:event_RemoveButtonActionPerformed
    /**
     * (Ssaki)Ustawienie w zależności od typu zwierzęcia tempa wzrostu
     */
    private void Size_ageSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Size_ageSliderMouseDragged
        switch (state) {
            case 0: {
                Antelope.setSize_age(Size_ageSlider.getValue());
                break;
            }
            case 1: {
                Lion.setSize_age(Size_ageSlider.getValue());
                break;
            }
            case 2: {
                Hyena.setSize_age(Size_ageSlider.getValue());
                break;
            }


        }
    }//GEN-LAST:event_Size_ageSliderMouseDragged
    /**
     * (Ssaki)Ustawienie w zależności od typu zwierzęcia tempa starzenia
     */
    private void AgingSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgingSliderMouseDragged
        switch (state) {
            case 0: {
                Antelope.setAgingRate(AgingSlider.getValue());
                break;
            }
            case 1: {
                Lion.setAgingRate(AgingSlider.getValue());
                break;
            }
            case 2: {
                Hyena.setAgingRate(AgingSlider.getValue());
                break;
            }
        }
    }//GEN-LAST:event_AgingSliderMouseDragged
    /**
     * (Ssaki)Ustawienie w zależności od typu zwierzęcia tempa reprodukcji
     */
    private void ReproSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReproSliderMouseDragged
        switch (state) {
            case 0: {
                Antelope.setReproductionRate(ReproSlider.getValue());
                break;
            }
            case 1: {
                Lion.setReproductionRate(ReproSlider.getValue());
                break;
            }
            case 2: {
                Hyena.setReproductionRate(ReproSlider.getValue());
                break;
            }
        }
    }//GEN-LAST:event_ReproSliderMouseDragged
    /**
     * Update informacji o zwierzęciu w zależności od typu zwierzęcia (update
     * danych i slider'ów)
     */
    public void uptodate(int state) {


        switch (state) {
            case 0: {
                new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                sleep(VelSlider.getValue());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AnimalSet.class.getName()).log(Level.SEVERE, null, ex);
                            }



                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {

                                    XLabel.setText(new Integer(f.getX()).toString());
                                    YLabel.setText(new Integer(f.getY()).toString());
                                    FoodLabel.setText(new Integer(f.getFood()).toString());
                                    WaterLabel.setText(new Integer(f.getWater()).toString());
                                    AppLabel.setText(new Integer(f.getAppetite()).toString());

                                    AgeLabel.setText(new Integer(f.getAge()).toString());
                                    SizeLabel.setText(new Integer(f.getSize()).toString());
                                    VelSlider.setValue(Antelope.getVelocity());
                                    EatRateSlider.setValue(Antelope.getEatingRate());
                                    DrinkRateSlider.setValue(Antelope.getDrinkingRate());
                                    EnergyRateSlider.setValue(Antelope.getEnergyRate());
                                    Size_ageSlider.setValue(Antelope.getSize_age());
                                    AgingSlider.setValue(Antelope.getAgingRate());
                                    ReproSlider.setValue(Antelope.getReproductionRate());


                                }
                            });
                        }
                    }
                }.start();

                break;
            }

            case 1: {
                new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                sleep(VelSlider.getValue());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AnimalSet.class.getName()).log(Level.SEVERE, null, ex);
                            }



                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {

                                    XLabel.setText(new Integer(f.getX()).toString());
                                    YLabel.setText(new Integer(f.getY()).toString());
                                    FoodLabel.setText(new Integer(f.getFood()).toString());
                                    WaterLabel.setText(new Integer(f.getWater()).toString());
                                    AppLabel.setText(new Integer(f.getAppetite()).toString());

                                    AgeLabel.setText(new Integer(f.getAge()).toString());
                                    SizeLabel.setText(new Integer(f.getSize()).toString());
                                    HuntingRateSlider.setValue(Lion.getHuntingRate());
                                    RestTimeSlider.setValue(Lion.getRestTime());


                                    VelSlider.setValue(Lion.getVelocity());
                                    EatRateSlider.setValue(Lion.getEatingRate());
                                    DrinkRateSlider.setValue(Lion.getDrinkingRate());
                                    EnergyRateSlider.setValue(Lion.getEnergyRate());
                                    Size_ageSlider.setValue(Lion.getSize_age());
                                    AgingSlider.setValue(Lion.getAgingRate());
                                    ReproSlider.setValue(Lion.getReproductionRate());


                                }
                            });
                        }
                    }
                }.start();

                break;
            }

            case 2: {
                new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                sleep(VelSlider.getValue());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AnimalSet.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {

                                    XLabel.setText(new Integer(f.getX()).toString());
                                    YLabel.setText(new Integer(f.getY()).toString());
                                    FoodLabel.setText(new Integer(f.getFood()).toString());
                                    WaterLabel.setText(new Integer(f.getWater()).toString());
                                    AppLabel.setText(new Integer(f.getAppetite()).toString());

                                    AgeLabel.setText(new Integer(f.getAge()).toString());
                                    SizeLabel.setText(new Integer(f.getSize()).toString());
                                    H_RTSlider.setValue(Hyena.getRestTime());


                                    VelSlider.setValue(Hyena.getVelocity());
                                    EatRateSlider.setValue(Hyena.getEatingRate());
                                    DrinkRateSlider.setValue(Hyena.getDrinkingRate());
                                    EnergyRateSlider.setValue(Hyena.getEnergyRate());
                                    Size_ageSlider.setValue(Hyena.getSize_age());
                                    AgingSlider.setValue(Hyena.getAgingRate());
                                    ReproSlider.setValue(Hyena.getReproductionRate());


                                }
                            });
                        }
                    }
                }.start();

                break;
            }

            case 4: {


                new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                sleep(VelSlider.getValue());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AnimalSet.class.getName()).log(Level.SEVERE, null, ex);
                            }


                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {

                                    XSnakeLabel.setText(new Integer(s.getX()).toString());
                                    YSnakeLabel.setText(new Integer(s.getY()).toString());


                                    AgeSnakeLabel.setText(new Integer(s.getAge()).toString());
                                    SizeSnakeLabel.setText(new Integer(s.getSize()).toString());
                                    PoisonLabel.setText(new Integer(s.getPoison()).toString());
                                    SnakeVelSlider.setValue(Snake.getVelocity());
                                    SnakeSizeSlider.setValue(Snake.getSize_age());
                                    SnakeAgingSlider.setValue(Snake.getAgingRate());
                                    SnakeReproSlider.setValue(Snake.getReproductionRate());
                                    PoisonSlider.setValue(Snake.getPoisonMax());
                                    PoisonRegSlider.setValue(Snake.getPoisonReg());

                                }
                            });
                        }
                    }
                }.start();


                break;
            }
            case 3: {

                new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                sleep(VelSlider.getValue());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AnimalSet.class.getName()).log(Level.SEVERE, null, ex);
                            }



                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {

                                    BirdXLabel.setText(new Integer(b.getX()).toString());
                                    BirdYLabel.setText(new Integer(b.getY()).toString());
                                    BirdHLabel.setText(new Integer(b.getH()).toString());

                                    BirdAgeLabel.setText(new Integer(b.getAge()).toString());
                                    BirdEatLabel.setText(new Integer(b.getFood()).toString());
                                    BirdVelSlider.setValue(Bird.getVelocity());


                                    BirdAgingSlider.setValue(Bird.getAgingRate());
                                    BirdReproSlider.setValue(Bird.getReproductionRate());
                                    BirdHuntSlider.setValue(Bird.getHuntingRate());
                                    BirdEatSlider.setValue(Bird.getEatingRate());
                                    BirdEnergySlider.setValue(Bird.getEnergyRate());




                                }
                            });
                        }
                    }
                }.start();

                break;
            }
            case 6: {

                new Thread() {
                    public void run() {
                        while (true) {
                            try {
                                sleep(VelSlider.getValue());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AnimalSet.class.getName()).log(Level.SEVERE, null, ex);
                            }



                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {

                                    CarrionLabel.setText(new Integer(f.getSize()).toString());




                                }
                            });
                        }
                    }
                }.start();

                break;
            }

        }


    }

    /**
     * (Ssaki)Ustawienie w zależności od typu zwierzęcia tempa jedzenia
     */
    private void EatRateSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EatRateSliderMouseDragged
        switch (state) {
            case 0:
                Antelope.setEatingRate(EatRateSlider.getValue());
                break;
            case 1:
                Lion.setEatingRate(EatRateSlider.getValue());
                break;
            case 2:
                Hyena.setEatingRate(EatRateSlider.getValue());
                break;

        }

    }//GEN-LAST:event_EatRateSliderMouseDragged
    /**
     * (Ssaki)Ustawienie w zależności od typu zwierzęcia tempa picia
     */
    private void DrinkRateSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrinkRateSliderMouseDragged

        switch (state) {
            case 0:
                Antelope.setDrinkingRate(DrinkRateSlider.getValue());
                break;
            case 1:
                Lion.setDrinkingRate(DrinkRateSlider.getValue());
                break;
            case 2:
                Hyena.setDrinkingRate(DrinkRateSlider.getValue());
                break;

        }

    }//GEN-LAST:event_DrinkRateSliderMouseDragged
    /**
     * (Ssaki)Ustawienie w zależności od typu zwierzęcia tempa spalania
     */
    private void EnergyRateSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnergyRateSliderMouseDragged


        switch (state) {
            case 0:
                Antelope.setEnergyRate(EnergyRateSlider.getValue());
                break;
            case 1:
                Lion.setEnergyRate(EnergyRateSlider.getValue());
                break;
            case 2:
                Hyena.setEnergyRate(EnergyRateSlider.getValue());
                break;

        }

    }//GEN-LAST:event_EnergyRateSliderMouseDragged
    /**
     * Ustawienie prawdopodobieństwa upolowania przez lwa
     */
    private void HuntingRateSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HuntingRateSliderMouseDragged
        Lion.setHuntingRate(HuntingRateSlider.getValue());

    }//GEN-LAST:event_HuntingRateSliderMouseDragged
    /**
     * Ustalenie długości odpoczynku lwa
     */
    private void RestTimeSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RestTimeSliderMouseDragged
        Lion.setRestTime(RestTimeSlider.getValue());
    }//GEN-LAST:event_RestTimeSliderMouseDragged
    /**
     * Ustalanie drogi żerwania dla węża (analogicznie do ssaków)
     */
    private void SnakeRoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SnakeRoadButtonActionPerformed
        Board.setBoardState(3);


        Board.setMarkerInc(0);
        Board.setPatrolAniType(s);

        s.setPatrolRoadis(false);


        for (int z = 0; z < s.PatrolRoad.size(); z++) {

            Marker m = new Marker(s.scene);
            m.setX(((Point) s.PatrolRoad.get(z)).getX());
            m.setY(((Point) s.PatrolRoad.get(z)).getY());

            Board.setTemp_fields(m.getPointX(), m.getPointY(), m);


        }



        s.PatrolRoad.clear();
    }//GEN-LAST:event_SnakeRoadButtonActionPerformed
    /**
     * Zatwierdzenie drogi żerwania dla węża (analogicznie do ssaków)
     */
    private void SnakeOKRoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SnakeOKRoadButtonActionPerformed

        Board.setBoardState(0);

        Board.setMarkerInc(0);
        Board.setPatrolAniType(null);


        s.setPatrolRoadis(true);
        Marker.removeMarker(s.scene);

        if (!((Animal) s).PatrolRoad.isEmpty()) {
            ((Animal) s).setPatrolRoadis(true);
        }
    }//GEN-LAST:event_SnakeOKRoadButtonActionPerformed
    /**
     * Usuniecie węża
     */
    private void SnakeRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SnakeRemoveButtonActionPerformed
        s.remove();
        this.dispose();
    }//GEN-LAST:event_SnakeRemoveButtonActionPerformed
    /**
     * Ustalanie predkość węża
     */
    private void SnakeVelSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnakeVelSliderMouseDragged
        Snake.setVelocity(SnakeVelSlider.getValue());

    }//GEN-LAST:event_SnakeVelSliderMouseDragged
    /**
     * Ustalanie tempa wrostu węża
     */
    private void SnakeSizeSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnakeSizeSliderMouseDragged
        Snake.setSize_age(SnakeSizeSlider.getValue());


    }//GEN-LAST:event_SnakeSizeSliderMouseDragged
    /**
     * Ustalanie tempa reprodukcji węża
     */
    private void SnakeReproSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnakeReproSliderMouseDragged
        Snake.setReproductionRate(SnakeReproSlider.getValue());

    }//GEN-LAST:event_SnakeReproSliderMouseDragged
    /**
     * Ustalanie tempa starzenia węża
     */
    private void SnakeAgingSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnakeAgingSliderMouseDragged
        Snake.setAgingRate(SnakeAgingSlider.getValue());

    }//GEN-LAST:event_SnakeAgingSliderMouseDragged
    /**
     * Ustalanie maksymalnej ilości trucizny węża
     */
    private void PoisonSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PoisonSliderMouseDragged
        Snake.setPoisonMax(PoisonSlider.getValue());

    }//GEN-LAST:event_PoisonSliderMouseDragged
    /**
     * Ustalanie tempa regeneracji trucizny węża
     */
    private void PoisonRegSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PoisonRegSliderMouseDragged
        Snake.setPoisonReg(PoisonRegSlider.getValue());
    }//GEN-LAST:event_PoisonRegSliderMouseDragged
    /**
     * Ustalanie drogi żerwania dla ptaka (analogicznie do ssaków)
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        Board.setBoardState(3);
        Board.setMarkerInc(0);
        Board.setPatrolAniType(b);

        b.setPatrolRoadis(false);
        Board.setPatrolMarkerState(3);

        for (int z = 0; z < b.PatrolRoad.size(); z++) {

            Marker m = new Marker(b.scene);
            m.setX(((Point) b.PatrolRoad.get(z)).getX());
            m.setY(((Point) b.PatrolRoad.get(z)).getY());

            Board.setTemp_fields(m.getPointX(), m.getPointY(), m);


        }



        b.PatrolRoad.clear();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Zatwierdzenie drogi żerwania dla węża (analogicznie do ssaków)
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Board.setBoardState(0);

        Board.setMarkerInc(0);
        Board.setPatrolAniType(null);


        b.setPatrolRoadis(true);
        Marker.removeMarker(b.scene);

        if (!((Animal) b).PatrolRoad.isEmpty()) {
            ((Animal) b).setPatrolRoadis(true);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Usunięcie ptaka
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        b.remove();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * Ustalenie gniazda ptaka
     */
    private void NestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NestButtonActionPerformed

        Board.setBoardState(3);

        Board.setMarkerInc(0);
        Board.setPatrolAniType(b);

        b.setNestEst(false);
        Board.setPatrolMarkerState(5);


        if (b.getNest() != null) {
            Marker m = new Marker(b.scene);
            m.setX(((Point) b.getNest()).getX());
            m.setY(((Point) b.getNest()).getY());

            Board.setTemp_fields(m.getPointX(), m.getPointY(), m);

        }





    }//GEN-LAST:event_NestButtonActionPerformed
    /**
     * Ustalanie predkości dla ssaków
     */
    private void VelSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VelSliderMouseDragged

        switch (state) {
            case 0:
                Antelope.setVelocity(VelSlider.getValue());
                break;
            case 1:
                Lion.setVelocity(VelSlider.getValue());
                break;
            case 2:
                Hyena.setVelocity(VelSlider.getValue());
                break;

        }

    }//GEN-LAST:event_VelSliderMouseDragged
    /**
     * Usuwanie padliny
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ((Carrion) f).remove();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    /**
     * Ustalanie predkości ptaków
     */
    private void BirdVelSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BirdVelSliderMouseDragged
        Bird.setVelocity(BirdVelSlider.getValue());


    }//GEN-LAST:event_BirdVelSliderMouseDragged
    /**
     * Ustalanie tempa reprodukcji ptaków
     */
    private void BirdReproSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BirdReproSliderMouseDragged
        Bird.setReproductionRate(BirdReproSlider.getValue());
    }//GEN-LAST:event_BirdReproSliderMouseDragged
    /**
     * Ustalanie tempa starzenia ptaków
     */
    private void BirdAgingSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BirdAgingSliderMouseDragged
        Bird.setAgingRate(BirdAgingSlider.getValue());
    }//GEN-LAST:event_BirdAgingSliderMouseDragged
    /**
     * Ustalanie tempa jedzenia ptaków
     */
    private void BirdEatSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BirdEatSliderMouseDragged
        Bird.setEatingRate(BirdEatSlider.getValue());
    }//GEN-LAST:event_BirdEatSliderMouseDragged
    /**
     * Ustalanie tempa spalania ptaków
     */
    private void BirdEnergySliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BirdEnergySliderMouseDragged
        Bird.setEnergyRate(BirdEnergySlider.getValue());
    }//GEN-LAST:event_BirdEnergySliderMouseDragged
    /**
     * Ustalanie szansy upolowania przez ptaków
     */
    private void BirdHuntSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BirdHuntSliderMouseDragged
        Bird.setHuntingRate(BirdHuntSlider.getValue());
    }//GEN-LAST:event_BirdHuntSliderMouseDragged
    /**
     * Ustalanie czasu odpoczynku hien
     */
    private void H_RTSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_H_RTSliderMouseDragged
        Hyena.setRestTime(RestTimeSlider.getValue());
    }//GEN-LAST:event_H_RTSliderMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnimalSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgeLabel;
    private javax.swing.JLabel AgeSnakeLabel;
    private javax.swing.JSlider AgingSlider;
    private javax.swing.JLabel AppLabel;
    private javax.swing.JLabel BirdAgeLabel;
    private javax.swing.JSlider BirdAgingSlider;
    private javax.swing.JLabel BirdAppLabel;
    private javax.swing.JLabel BirdEatLabel;
    private javax.swing.JSlider BirdEatSlider;
    private javax.swing.JSlider BirdEnergySlider;
    private javax.swing.JLabel BirdHLabel;
    private javax.swing.JSlider BirdHuntSlider;
    private javax.swing.JLabel BirdIDLabel;
    private javax.swing.JSlider BirdReproSlider;
    private javax.swing.JPanel BirdSetPanel;
    private javax.swing.JSlider BirdVelSlider;
    private javax.swing.JLabel BirdXLabel;
    private javax.swing.JLabel BirdYLabel;
    private javax.swing.JLabel CarrionLabel;
    private javax.swing.JPanel CarrionPanel;
    private javax.swing.JSlider DrinkRateSlider;
    private javax.swing.JSlider EatRateSlider;
    private javax.swing.JSlider EnergyRateSlider;
    private javax.swing.JLabel FoodLabel;
    private javax.swing.JSlider H_RTSlider;
    private javax.swing.JSlider HuntingRateSlider;
    private javax.swing.JPanel HyenaSetPanel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JPanel LionSetPanel;
    private javax.swing.JButton NestButton;
    private javax.swing.JButton OKRoadButton;
    private javax.swing.JLabel PoisonLabel;
    private javax.swing.JSlider PoisonRegSlider;
    private javax.swing.JSlider PoisonSlider;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JSlider ReproSlider;
    private javax.swing.JSlider RestTimeSlider;
    private javax.swing.JButton RoadButton;
    private javax.swing.JPanel SetPanel;
    private javax.swing.JLabel SizeLabel;
    private javax.swing.JLabel SizeSnakeLabel;
    private javax.swing.JSlider Size_ageSlider;
    private javax.swing.JSlider SnakeAgingSlider;
    private javax.swing.JLabel SnakeIDLabel;
    private javax.swing.JButton SnakeOKRoadButton;
    private javax.swing.JPanel SnakePanel;
    private javax.swing.JButton SnakeRemoveButton;
    private javax.swing.JSlider SnakeReproSlider;
    private javax.swing.JButton SnakeRoadButton;
    private javax.swing.JSlider SnakeSizeSlider;
    private javax.swing.JSlider SnakeVelSlider;
    private javax.swing.JSlider VelSlider;
    private javax.swing.JButton WPOKButton;
    private javax.swing.JButton WRMarkerButton;
    private javax.swing.JLabel WaterLabel;
    private javax.swing.JLabel XLabel;
    private javax.swing.JLabel XSnakeLabel;
    private javax.swing.JLabel YLabel;
    private javax.swing.JLabel YSnakeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}

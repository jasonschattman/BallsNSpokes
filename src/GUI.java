
import java.awt.Color;


public class GUI extends javax.swing.JFrame {

    Animator ballsNSpokesAnimator;
    Color defaultBallColour;
    
    public GUI() {
        initComponents(); 
        this.defaultBallColour = Color.black;
        restartAnimation(0);
    }
    
    public void reset() {
        ballsNSpokesAnimator.runner = null;
        int frameWhereWeLeftOff = ballsNSpokesAnimator.frameNumber;
        restartAnimation( frameWhereWeLeftOff );
    }

    public void restartAnimation( int frameStart ) {
        int numBalls = this.numBallsSlider.getValue();
        int numCrests = this.numCrestsSlider.getValue();
        int minRadius = this.minRadiusSlider.getValue();
        int maxRadius = this.maxRadiusSlider.getValue();
        int speed = this.speedSlider.getValue();
        boolean showSpokes = this.showSpokesCheckbox.isSelected();
        boolean showInnerRing = this.showInnerRingCheckbox.isSelected();
        boolean showOuterRing = this.showOuterRingCheckbox.isSelected();
        boolean showTracerBalls = this.showTracerCheckbox.isSelected();
        ballsNSpokesAnimator = new Animator( drawingPanel, numBalls, numCrests, minRadius, maxRadius, speed, showSpokes, showInnerRing, showOuterRing, showTracerBalls, frameStart, defaultBallColour);
        
        ballsNSpokesAnimator.runner = new Thread( ballsNSpokesAnimator );
        ballsNSpokesAnimator.runner.start();
        //ballsNSpokesAnimator.run();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maxRadiusSlider = new javax.swing.JSlider();
        numCrestsSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        minRadiusSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        numBallsSlider = new javax.swing.JSlider();
        showSpokesCheckbox = new javax.swing.JCheckBox();
        showInnerRingCheckbox = new javax.swing.JCheckBox();
        showOuterRingCheckbox = new javax.swing.JCheckBox();
        showTracerCheckbox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        speedSlider = new javax.swing.JSlider();
        showAllButton = new javax.swing.JButton();
        clearAllButton = new javax.swing.JButton();
        invertColoursButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jLabel1.setText("Number of crests");

        jLabel2.setText("Maximum radius");

        maxRadiusSlider.setMajorTickSpacing(50);
        maxRadiusSlider.setMaximum(275);
        maxRadiusSlider.setMinimum(100);
        maxRadiusSlider.setMinorTickSpacing(10);
        maxRadiusSlider.setPaintLabels(true);
        maxRadiusSlider.setPaintTicks(true);
        maxRadiusSlider.setValue(275);
        maxRadiusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxRadiusSliderChanged(evt);
            }
        });

        numCrestsSlider.setMajorTickSpacing(1);
        numCrestsSlider.setMaximum(10);
        numCrestsSlider.setMinimum(1);
        numCrestsSlider.setMinorTickSpacing(1);
        numCrestsSlider.setPaintLabels(true);
        numCrestsSlider.setPaintTicks(true);
        numCrestsSlider.setSnapToTicks(true);
        numCrestsSlider.setValue(3);
        numCrestsSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numCrestsSliderChanged(evt);
            }
        });

        jLabel3.setText("Minimum radius");

        minRadiusSlider.setMajorTickSpacing(50);
        minRadiusSlider.setMaximum(275);
        minRadiusSlider.setMinorTickSpacing(10);
        minRadiusSlider.setPaintLabels(true);
        minRadiusSlider.setPaintTicks(true);
        minRadiusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minRadiusSliderChanged(evt);
            }
        });

        jLabel4.setText("Number of balls");

        numBallsSlider.setMajorTickSpacing(20);
        numBallsSlider.setMaximum(180);
        numBallsSlider.setMinimum(20);
        numBallsSlider.setMinorTickSpacing(10);
        numBallsSlider.setPaintLabels(true);
        numBallsSlider.setPaintTicks(true);
        numBallsSlider.setValue(60);
        numBallsSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numBallsSliderChanged(evt);
            }
        });

        showSpokesCheckbox.setSelected(true);
        showSpokesCheckbox.setText("Show spokes");
        showSpokesCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSpokesCheckboxActionPerformed(evt);
            }
        });

        showInnerRingCheckbox.setSelected(true);
        showInnerRingCheckbox.setText("Show inner ring");
        showInnerRingCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInnerRingCheckboxActionPerformed(evt);
            }
        });

        showOuterRingCheckbox.setSelected(true);
        showOuterRingCheckbox.setText("Show outer ring");
        showOuterRingCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOuterRingCheckboxActionPerformed(evt);
            }
        });

        showTracerCheckbox.setSelected(true);
        showTracerCheckbox.setText("Show tracer balls");
        showTracerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTracerCheckboxActionPerformed(evt);
            }
        });

        jLabel5.setText("Speed");

        speedSlider.setMajorTickSpacing(1);
        speedSlider.setMaximum(10);
        speedSlider.setMinimum(1);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTicks(true);
        speedSlider.setSnapToTicks(true);
        speedSlider.setValue(3);
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderChanged(evt);
            }
        });

        showAllButton.setText("Select all");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        clearAllButton.setText("Unselect all");
        clearAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllButtonActionPerformed(evt);
            }
        });

        invertColoursButton.setText("Invert colours");
        invertColoursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertColoursButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxRadiusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numBallsSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numCrestsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(149, 149, 149))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(minRadiusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(showSpokesCheckbox)
                                        .addComponent(showTracerCheckbox))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(showInnerRingCheckbox)
                                            .addGap(18, 18, 18)
                                            .addComponent(showAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(showOuterRingCheckbox)
                                            .addGap(18, 18, 18)
                                            .addComponent(clearAllButton)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(invertColoursButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(numBallsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numCrestsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxRadiusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(minRadiusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showSpokesCheckbox)
                            .addComponent(showInnerRingCheckbox)
                            .addComponent(showAllButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showOuterRingCheckbox)
                            .addComponent(showTracerCheckbox)
                            .addComponent(clearAllButton))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(invertColoursButton))
                    .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showInnerRingCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInnerRingCheckboxActionPerformed
        reset();
    }//GEN-LAST:event_showInnerRingCheckboxActionPerformed

    private void numCrestsSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numCrestsSliderChanged
        reset();
    }//GEN-LAST:event_numCrestsSliderChanged

    private void showSpokesCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSpokesCheckboxActionPerformed
        reset();
    }//GEN-LAST:event_showSpokesCheckboxActionPerformed

    private void numBallsSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numBallsSliderChanged
        reset();
    }//GEN-LAST:event_numBallsSliderChanged

    private void maxRadiusSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxRadiusSliderChanged
        reset();
    }//GEN-LAST:event_maxRadiusSliderChanged

    private void minRadiusSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minRadiusSliderChanged
        reset();
    }//GEN-LAST:event_minRadiusSliderChanged

    private void showOuterRingCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOuterRingCheckboxActionPerformed
        reset();
    }//GEN-LAST:event_showOuterRingCheckboxActionPerformed

    private void showTracerCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTracerCheckboxActionPerformed
        reset();
    }//GEN-LAST:event_showTracerCheckboxActionPerformed

    private void speedSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderChanged
        reset();
    }//GEN-LAST:event_speedSliderChanged

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        this.showSpokesCheckbox.setSelected(true);
        this.showInnerRingCheckbox.setSelected(true);
        this.showOuterRingCheckbox.setSelected(true);
        this.showTracerCheckbox.setSelected(true);
        reset();
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void clearAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllButtonActionPerformed
        this.showSpokesCheckbox.setSelected(false);
        this.showInnerRingCheckbox.setSelected(false);
        this.showOuterRingCheckbox.setSelected(false);
        this.showTracerCheckbox.setSelected(false);
        reset();
    }//GEN-LAST:event_clearAllButtonActionPerformed

    private void invertColoursButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertColoursButtonActionPerformed
        if (this.defaultBallColour == Color.black)
            this.defaultBallColour = Color.white;
        else
            this.defaultBallColour = Color.black;
        
        reset();
    }//GEN-LAST:event_invertColoursButtonActionPerformed

    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearAllButton;
    private javax.swing.JPanel drawingPanel;
    private javax.swing.JButton invertColoursButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSlider maxRadiusSlider;
    private javax.swing.JSlider minRadiusSlider;
    private javax.swing.JSlider numBallsSlider;
    private javax.swing.JSlider numCrestsSlider;
    private javax.swing.JButton showAllButton;
    private javax.swing.JCheckBox showInnerRingCheckbox;
    private javax.swing.JCheckBox showOuterRingCheckbox;
    private javax.swing.JCheckBox showSpokesCheckbox;
    private javax.swing.JCheckBox showTracerCheckbox;
    private javax.swing.JSlider speedSlider;
    // End of variables declaration//GEN-END:variables
}

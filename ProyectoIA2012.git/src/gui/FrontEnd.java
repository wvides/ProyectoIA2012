/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import MAPITA.automovil;
import MAPITA.mapa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import solucion.resolucion;
import structures.Coordinate;
import structures.Item;

/**
 *
 * @author Omar
 */
public class FrontEnd extends javax.swing.JFrame {

    /**
     * Creates new form FrontEnd
     */
    double x = 15, y = 50, w = 70, h = 70;
    ArrayList<Item> items = new ArrayList<Item>();

    public FrontEnd() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Debug");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(444, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Abrir archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        x++;
        y++;
        repaint(0, 0, 800, 800);
    }//GEN-LAST:event_jButton1ActionPerformed
    public static File archivo;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            Item tempo = new Item();
            boolean tempoHasItems = false;

            FileInputStream fstream = null;
//            try {
                File fichero = fileChooser.getSelectedFile();
                archivo = fichero;
                automovil ferrari=new automovil(new Coordinate(1,2));
                mapa m1=new mapa(17,14,ferrari);
                Coordinate inicial =new Coordinate(1,2);
                Coordinate pfinal =new Coordinate(8,8);
                resolucion res=new resolucion();
                try {
                    res.calcularrutaoptima(m1, pfinal);
                } catch (Exception ex) {
                    Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
                }
//            try {
//                fstream = new FileInputStream(fichero.getAbsoluteFile());
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                DataInputStream in = new DataInputStream(fstream);
//                BufferedReader br = new BufferedReader(new InputStreamReader(in));
//                String strLine;
//
//                while ((strLine = br.readLine()) != null) {
//                    if (strLine.contains(":")) {
//                        if (tempoHasItems) {
//                            items.add(tempo);
//                            tempo = new Item();
//                            tempo.setName(strLine.replace(":", ""));
//                            System.out.println(tempo.getName());
//                            tempoHasItems = false;
//                        } else {
//                            tempo = new Item();
//                            tempo.setName(strLine.replace(":", ""));
//                            System.out.println(tempo.getName());
//                        }
//
//                    } else {
//                        strLine = strLine.replace("(", "").replace(")", "");
//                        StringTokenizer tokenized = new StringTokenizer(strLine, "/");
//                        while (tokenized.hasMoreTokens()) {
//                            //System.out.println("Token: " + tokenized.nextToken());
//                            int count = 0;
//                            Coordinate tempoCord = new Coordinate();
//                            StringTokenizer subTokenized = new StringTokenizer(tokenized.nextToken(), ",");
//                            while (subTokenized.hasMoreTokens()) {
//                                String token = subTokenized.nextToken();
//                                System.out.println("Token: " + token);
//                                switch (count) {
//                                    case 0:
//                                        tempoCord.setX(Integer.parseInt(token));
//                                        break;
//                                    case 1:
//                                        tempoCord.setY(Integer.parseInt(token));
//                                        break;
//                                    case 2:
//                                        tempoCord.setLetter(token);
//                                        break;
//                                }
//                                count++;
//                            }
//                            tempo.addCoordinate(tempoCord);
//                            System.out.println("----------");
//                        }
//                        tempoHasItems = true;
//                        //stringtokenizer para parserar objeto
//                    }
//                }
//                in.close();
//            } catch (IOException ex) {
//                Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
//            } finally {
//                try {
//                    fstream.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Iterator i = items.iterator();
        while (i.hasNext()) {
            Item m = (Item) i.next();
            Iterator u = m.getCoordinates().iterator();
            System.out.println(m.getName());
            while (u.hasNext()) {
                Coordinate coord = (Coordinate) u.next();
                System.out.println(coord.getX() + " , " + coord.getY() + " , " + coord.getLetter());
            }
            System.out.println("-----------");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
    }//GEN-LAST:event_jButton3ActionPerformed
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (x = 1; x < 20; x++) {
            for (y = 1; y < 20; y++) {
                Rectangle2D.Double square = new Rectangle2D.Double(60 + 25 * x, 30 + 25 * y, 20, 20);
                g2.setPaint(Color.white);
                g2.fill(square);
                g2.draw(square);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrontEnd().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

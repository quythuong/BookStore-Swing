/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

/**
 *
 * @author quythuong
 */
public class panel_employees extends javax.swing.JPanel {

	/**
	 * Creates new form panel_employees
	 */
	public panel_employees() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panelCustom1 = new com.nhom08.bookstore.GUI.PanelCustom();
                panel_TableArea = new com.nhom08.bookstore.GUI.PanelCustom();

                setBackground(new java.awt.Color(255, 255, 255));
                setPreferredSize(new java.awt.Dimension(1056, 740));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                panelCustom1.setBackground(new java.awt.Color(137, 207, 245));
                panelCustom1.setRoundBottomLeft(20);
                panelCustom1.setRoundBottomRight(20);
                panelCustom1.setRoundTopLeft(20);
                panelCustom1.setRoundTopRight(20);

                javax.swing.GroupLayout panelCustom1Layout = new javax.swing.GroupLayout(panelCustom1);
                panelCustom1.setLayout(panelCustom1Layout);
                panelCustom1Layout.setHorizontalGroup(
                        panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 305, Short.MAX_VALUE)
                );
                panelCustom1Layout.setVerticalGroup(
                        panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 665, Short.MAX_VALUE)
                );

                add(panelCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 25, 305, 665));

                panel_TableArea.setRoundBottomLeft(20);
                panel_TableArea.setRoundBottomRight(20);
                panel_TableArea.setRoundTopLeft(20);
                panel_TableArea.setRoundTopRight(20);

                javax.swing.GroupLayout panel_TableAreaLayout = new javax.swing.GroupLayout(panel_TableArea);
                panel_TableArea.setLayout(panel_TableAreaLayout);
                panel_TableAreaLayout.setHorizontalGroup(
                        panel_TableAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 664, Short.MAX_VALUE)
                );
                panel_TableAreaLayout.setVerticalGroup(
                        panel_TableAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 578, Short.MAX_VALUE)
                );

                add(panel_TableArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 109, 664, 578));
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private com.nhom08.bookstore.GUI.PanelCustom panelCustom1;
        private com.nhom08.bookstore.GUI.PanelCustom panel_TableArea;
        // End of variables declaration//GEN-END:variables
}

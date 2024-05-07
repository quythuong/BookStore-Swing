/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import Custom.ScrollBar;
import com.nhom08.bookstore.Models.BookModel;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author Quoc Thinh
 */
public class FormHome extends javax.swing.JPanel {

    /**
     * @param event the event to set
     */
    public void setEvent(Event.EventItem event) {
        this.event = event;
    }

    private Event.EventItem event;
    public FormHome() {
        initComponents();
        scroll.setVerticalScrollBar(new ScrollBar());
    }

     public void addItem(BookModel data) {
        Panel_BookItem item = new Panel_BookItem();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    event.itemClick(item, data);
                }
            }

        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }
     
     public void setSelected(Component item){
         for (Component com : panelItem.getComponents()){
             Panel_BookItem i = (Panel_BookItem)com;
             if (i.isSelected()){
                 i.setSelected(false);
             }
         }
         ((Panel_BookItem)item).setSelected(true);
     }
     
//    public void setItemClickListener(ItemClickListener listener){
//        for (Component component : this.getComponents()) {
//            if (component instanceof Panel_BookItem) {
//                Panel_BookItem item = (Panel_BookItem) component;
//                item.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        if (SwingUtilities.isLeftMouseButton(e)) {
//                            //listener.onItemClick(item.getData());
//                            
//                        }
//                    }
//                });
//            }
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panelItem = new com.nhom08.bookstore.GUI.FunctionalPanels.PanelItem();

        setOpaque(false);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom08.bookstore.GUI.FunctionalPanels.PanelItem panelItem;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quythuong
 */
public class panel_IReceiptAndIReceiptDetail extends javax.swing.JPanel {

	/**
	 * Creates new form panel_IReceiptAndIReceiptDetail
	 */
	private final panel_iReceipt panelIReceipt;
	private final panel_iReceiptDetail panelReceiptDetail;
	private final JPanel panel_goToDetailsBtn;
	private final JLabel lbl_backBtn;
	private final DefaultTableModel tableModel;
	private final JTable iReceiptTable;
	public panel_IReceiptAndIReceiptDetail() {
		initComponents();
		panelIReceipt = new panel_iReceipt();
		panelReceiptDetail = new panel_iReceiptDetail();
		
		this.setSize(new Dimension(1056, 740));
		TabbedPane.addTab("IReceipt", panelIReceipt);
		TabbedPane.addTab("IReceipt Details", panelReceiptDetail);
		
		panel_goToDetailsBtn = panelIReceipt.getPanel_goToIReceiptDetails();
		lbl_backBtn = panelReceiptDetail.getLbl_backBtn();
		iReceiptTable = panelIReceipt.getTable_iReceiptList();
		tableModel = (DefaultTableModel)iReceiptTable.getModel();
		
		panel_goToDetailsBtn.addMouseListener(new MouseAdapter() {
			@Override
                        public void mouseClicked(MouseEvent evt) {
                                panel_goToDetailsBtnMouseClicked(evt);
                        }
                });
		
		lbl_backBtn.addMouseListener(new MouseAdapter() {
			@Override
                        public void mouseClicked(MouseEvent evt) {
                                lbl_backBtnMouseClicked(evt);
                        }
                });
		
		iReceiptTable.addMouseListener(new MouseAdapter() {
			@Override
                        public void mouseClicked(MouseEvent evt) {
                                TableMouseClicked(evt);
                        }
                });
	}
	public void TableMouseClicked(MouseEvent evt) {
		panelIReceipt.getTf_iReceiptId().setText(tableModel.getValueAt(iReceiptTable.getSelectedRow(), 0).toString());
		panelIReceipt.getTf_publisherId().setText(tableModel.getValueAt(iReceiptTable.getSelectedRow(), 1).toString());
		panelIReceipt.getTf_date().setText(tableModel.getValueAt(iReceiptTable.getSelectedRow(), 2).toString());
		panelIReceipt.setIReceiptId(tableModel.getValueAt(iReceiptTable.getSelectedRow(), 0).toString());
		panelReceiptDetail.setIReceiptId(tableModel.getValueAt(iReceiptTable.getSelectedRow(), 0).toString());
	}
	public void panel_goToDetailsBtnMouseClicked(MouseEvent evt) {
		if(panelIReceipt.getIReceiptId() == null) {
			JOptionPane.showMessageDialog(this, "Chưa chọn đơn nhập nào!");
		} else {
			panelIReceipt.setIReceiptId("");
			TabbedPane.setSelectedIndex(1);
			panelReceiptDetail.loadTable();
		}
	}
	public void lbl_backBtnMouseClicked(MouseEvent evt) {
		iReceiptTable.clearSelection();
		panelIReceipt.setIReceiptId(null);
		panelIReceipt.clearText();
		TabbedPane.setSelectedIndex(0);
	}
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                TabbedPane = new javax.swing.JTabbedPane();

                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1056, 770));
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTabbedPane TabbedPane;
        // End of variables declaration//GEN-END:variables
}

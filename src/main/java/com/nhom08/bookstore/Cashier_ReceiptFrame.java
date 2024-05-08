/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom08.bookstore;

//import com.nhom08.bookstore.DAO.BookDAO;
import Custom.EventCellInputChange;
import Custom.QtyCellEditor;
import Event.EventItem;
import com.nhom08.bookstore.GUI.FunctionalPanels.FormHome;
import com.nhom08.bookstore.DAO.BookDAO;

import com.nhom08.bookstore.Models.BookModel;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.nhom08.bookstore.DAO.ReceiptDAO;
import com.nhom08.bookstore.DAO.ReceiptDetailsDAO;
import com.nhom08.bookstore.Models.ModelItemSell;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.components.table.util.TableUtil;
import com.nhom08.bookstore.Models.Item;
import java.awt.Font;
import java.awt.FontMetrics;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Cashier_ReceiptFrame extends javax.swing.JFrame implements Printable {

    private FormHome home;
    private String maHoaDon;
    private ReceiptDAO receiptDAO;
    private ReceiptDetailsDAO receiptDetailsDAO;

    public Cashier_ReceiptFrame(String maHoaDon) {
        initComponents();
        //setBackground(new Color(0,0,0,0));
        init();
        this.maHoaDon = maHoaDon;
        lb_mahoadon.setText(maHoaDon);
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, nên cộng thêm 1
        int nam = calendar.get(Calendar.YEAR);
        lb_date.setText("Date of receipt: " + ngay + "/" + thang + "/" + nam);

        receiptDAO = new ReceiptDAO();
        receiptDetailsDAO = new ReceiptDetailsDAO();
        //formatTable();
    }

    private void showData() {
        home.setEvent(new EventItem() {

            @Override
            public void itemClick(Component com, BookModel item) {
                //System.err.println(item.getId());
                String id = item.getId();
                home.setSelected(com);
                addItemToTable(item);
            }

            private void addItemToTable(BookModel item) {
                DefaultTableModel model = (DefaultTableModel) tb_list.getModel();
                DecimalFormat df = new DecimalFormat("#,###");
                boolean exists = false;

                if (item.getQuantity() <= 0) {
                    JOptionPane.showMessageDialog(null, "Mặt hàng này đã hết hàng", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return; // Không thêm vào bảng nếu số lượng là 0 hoặc âm
                }
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 1).equals(item.getName())) {
                        int quantity = (int) model.getValueAt(i, 2);
                        quantity++;
                        model.setValueAt(quantity, i, 2);
                        double price = item.getPrice() * quantity;
                        model.setValueAt(df.format(price), i, 4);
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    String formattedPrice = df.format(item.getPrice());
                    model.addRow(new Object[]{
                        model.getRowCount() + 1,
                        item.getName(),
                        1,
                        formattedPrice,
                        formattedPrice,
                        item.getId()
                    });
                }
                DecimalFormat df1 = new DecimalFormat("#,###");
                double subtotal = calculateTotal();
                lb_sub.setText(df1.format(subtotal) + " VND");
                double total = subtotal - (subtotal * 0.1);
                lb_total.setText(df1.format(total) + " VND");
            }

        });
        BookDAO bookDao = new BookDAO();
        if (bookDao != null) {
            List<BookModel> books = bookDao.getInfoBook();

            for (BookModel book : books) {
                home.addItem(book);
            }
        } else {
            System.err.println("Không thể kết nối đến CSDL");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Header = new javax.swing.JPanel();
        lbl_userIcon = new javax.swing.JLabel();
        lbl_accountName = new javax.swing.JLabel();
        textFieldCustom1 = new com.nhom08.bookstore.GUI.TextFieldCustom();
        mainPanel = new com.nhom08.bookstore.GUI.FunctionalPanels.main_CashierPanel();
        panelToPrint = new javax.swing.JPanel();
        panelCustom2 = new Custom.PanelCustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_date = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_mahoadon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_list = new javax.swing.JTable();
        panelCustom4 = new Custom.PanelCustom();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lb_iconTrash5 = new javax.swing.JLabel();
        lb_changed = new javax.swing.JLabel();
        lb_sub = new javax.swing.JLabel();
        lb_sale = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        btn_export = new Custom.ButtonCustom();
        tf_received = new javax.swing.JTextField();
        panelCustom1 = new Custom.PanelCustom();
        lb_cancle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 254, 251));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Header.setBackground(new java.awt.Color(219, 235, 247));
        panel_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_userIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_userIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_filled.png"))); // NOI18N
        panel_Header.add(lbl_userIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 12, 40, 40));

        lbl_accountName.setFont(new java.awt.Font("Lexend SemiBold", 0, 20)); // NOI18N
        lbl_accountName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_accountName.setText("Account name");
        panel_Header.add(lbl_accountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1098, 18, -1, -1));
        panel_Header.add(textFieldCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 11, 338, 41));

        getContentPane().add(panel_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 60));
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 700));

        panelCustom2.setPreferredSize(new java.awt.Dimension(532, 87));
        panelCustom2.setRoundBottomLeft(30);
        panelCustom2.setRoundBottomRigt(30);
        panelCustom2.setRoundTopLeft(30);
        panelCustom2.setRoundTopRigt(30);

        jLabel1.setFont(new java.awt.Font("Lexend SemiBold", 0, 15)); // NOI18N
        jLabel1.setText("NEW ORDER");

        jLabel2.setFont(new java.awt.Font("Lexend Light", 0, 14)); // NOI18N
        jLabel2.setText("Thank you for order our books");

        lb_date.setFont(new java.awt.Font("Lexend Light", 1, 15)); // NOI18N
        lb_date.setText("Date of receipt");

        jLabel4.setFont(new java.awt.Font("Lexend Light", 1, 15)); // NOI18N
        jLabel4.setText("Receipt ID:");

        lb_mahoadon.setText("jLabel5");

        javax.swing.GroupLayout panelCustom2Layout = new javax.swing.GroupLayout(panelCustom2);
        panelCustom2.setLayout(panelCustom2Layout);
        panelCustom2Layout.setHorizontalGroup(
            panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(217, 217, 217))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(161, 161, 161))))
                    .addGroup(panelCustom2Layout.createSequentialGroup()
                        .addComponent(lb_date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelCustom2Layout.setVerticalGroup(
            panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_date)
                    .addComponent(jLabel4)
                    .addComponent(lb_mahoadon))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sách", "Số lượng", "Giá ", "Thành tiền", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_list.setRowHeight(23);
        tb_list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_listKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tb_list);
        if (tb_list.getColumnModel().getColumnCount() > 0) {
            tb_list.getColumnModel().getColumn(0).setPreferredWidth(0);
            tb_list.getColumnModel().getColumn(1).setPreferredWidth(60);
            tb_list.getColumnModel().getColumn(2).setPreferredWidth(0);
            tb_list.getColumnModel().getColumn(3).setPreferredWidth(10);
            tb_list.getColumnModel().getColumn(4).setPreferredWidth(10);
            tb_list.getColumnModel().getColumn(5).setMinWidth(0);
            tb_list.getColumnModel().getColumn(5).setPreferredWidth(0);
            tb_list.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        panelCustom4.setPreferredSize(new java.awt.Dimension(532, 183));
        panelCustom4.setRoundBottomLeft(30);
        panelCustom4.setRoundBottomRigt(30);
        panelCustom4.setRoundTopLeft(30);
        panelCustom4.setRoundTopRigt(30);

        jLabel19.setFont(new java.awt.Font("Lexend Medium", 0, 14)); // NOI18N
        jLabel19.setText("Received :");

        jLabel20.setFont(new java.awt.Font("Lexend Medium", 0, 14)); // NOI18N
        jLabel20.setText("Subtotal :");

        jLabel21.setFont(new java.awt.Font("Lexend Medium", 0, 14)); // NOI18N
        jLabel21.setText("Changed :");

        jLabel22.setFont(new java.awt.Font("Lexend SemiBold", 0, 20)); // NOI18N
        jLabel22.setText("Total :");

        jLabel23.setFont(new java.awt.Font("Lexend Medium", 0, 14)); // NOI18N
        jLabel23.setText("Sale :");

        lb_changed.setFont(new java.awt.Font("Lexend Light", 0, 14)); // NOI18N

        lb_sub.setFont(new java.awt.Font("Lexend Light", 0, 14)); // NOI18N

        lb_sale.setFont(new java.awt.Font("Lexend Light", 0, 14)); // NOI18N
        lb_sale.setText("10%");

        jLabel27.setText("__________________________________________________");

        lb_total.setFont(new java.awt.Font("Lexend Light", 0, 14)); // NOI18N
        lb_total.setText("xxx.xxx.xxx.xxx.xxx VND");

        btn_export.setBackground(new java.awt.Color(255, 216, 156));
        btn_export.setText("Export Receipt");
        btn_export.setFont(new java.awt.Font("Lexend Light", 0, 16)); // NOI18N
        btn_export.setRadius(25);
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        panelCustom1.setRoundBottomLeft(50);
        panelCustom1.setRoundBottomRigt(50);
        panelCustom1.setRoundTopLeft(50);

        lb_cancle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancle.png"))); // NOI18N

        javax.swing.GroupLayout panelCustom1Layout = new javax.swing.GroupLayout(panelCustom1);
        panelCustom1.setLayout(panelCustom1Layout);
        panelCustom1Layout.setHorizontalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_cancle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCustom1Layout.setVerticalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_cancle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCustom4Layout = new javax.swing.GroupLayout(panelCustom4);
        panelCustom4.setLayout(panelCustom4Layout);
        panelCustom4Layout.setHorizontalGroup(
            panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(panelCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(lb_iconTrash5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_export, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(panelCustom4Layout.createSequentialGroup()
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_changed, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_received))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom4Layout.createSequentialGroup()
                                .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel20))
                                .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCustom4Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(lb_sale))
                                    .addGroup(panelCustom4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_sub))
                                    .addGroup(panelCustom4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_total)))
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom4Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(1, 1, 1))))))
        );
        panelCustom4Layout.setVerticalGroup(
            panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom4Layout.createSequentialGroup()
                .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCustom4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCustom4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(tf_received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(lb_sub)))
                        .addGap(20, 20, 20)
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(lb_changed)
                            .addComponent(jLabel23)
                            .addComponent(lb_sale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lb_total))
                        .addGroup(panelCustom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustom4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lb_iconTrash5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustom4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panelToPrintLayout = new javax.swing.GroupLayout(panelToPrint);
        panelToPrint.setLayout(panelToPrintLayout);
        panelToPrintLayout.setHorizontalGroup(
            panelToPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToPrintLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelToPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelToPrintLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelToPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelToPrintLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(panelCustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelToPrintLayout.setVerticalGroup(
            panelToPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToPrintLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCustom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelToPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 560, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed

        int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hóa đơn không?", "Xác nhận xuất hóa đơn", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            String maHoaDon = null;
            double total = 0;
            String maSach = null;
            int soLuongBan = 0;
            double gia = 0;
            addChiTietHoaDon(maHoaDon, maSach, soLuongBan, gia);
            updateTotalInHoaDon(maHoaDon, total);

            createItemList();
//        Float change = Float.parseFloat(jTextFieldCash.getText()) - Float.parseFloat(jTextFieldTotal.getText());
//        jTextFieldChange.setText(df.format(change));

            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setPrintable((Printable) this, getPageFormat(pj));

//      there's dialog
            pj.setPrintable((Printable) this);
            boolean ok = pj.printDialog();
            if (ok) {
                try {
                    pj.print();
                } catch (PrinterException ex) {
                }
            }

//            Cashier_ReceiptFrame receiptFrame = new Cashier_ReceiptFrame(maHoaDon);
//            receiptFrame.setVisible(false);
            CashierFrame cs = new CashierFrame();
            cs.setVisible(true);

            dispose();
        }
    }//GEN-LAST:event_btn_exportActionPerformed

    private void tb_listKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_listKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
//        if (c == '-') {
//            evt.consume();
//        }
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tb_listKeyTyped

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
            java.util.logging.Logger.getLogger(Cashier_ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cashier_ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cashier_ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cashier_ReceiptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cashier_ReceiptFrame("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonCustom btn_export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_cancle;
    private javax.swing.JLabel lb_changed;
    private javax.swing.JLabel lb_date;
    private javax.swing.JLabel lb_iconTrash5;
    private javax.swing.JLabel lb_mahoadon;
    private javax.swing.JLabel lb_sale;
    private javax.swing.JLabel lb_sub;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lbl_accountName;
    private javax.swing.JLabel lbl_userIcon;
    private com.nhom08.bookstore.GUI.FunctionalPanels.main_CashierPanel mainPanel;
    private Custom.PanelCustom panelCustom1;
    private Custom.PanelCustom panelCustom2;
    private Custom.PanelCustom panelCustom4;
    private javax.swing.JPanel panelToPrint;
    private javax.swing.JPanel panel_Header;
    private javax.swing.JTable tb_list;
    private com.nhom08.bookstore.GUI.TextFieldCustom textFieldCustom1;
    private javax.swing.JTextField tf_received;
    // End of variables declaration//GEN-END:variables

    private void init() {
        home = new FormHome();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        showData();

        tf_received.addActionListener((ActionEvent e) -> {
            // Lấy giá trị từ tf_received
            String receivedText = tf_received.getText().trim();
            try {
                // Loại bỏ dấu phân cách và dấu chấm
                String processedText = receivedText.replace(",", "").replace(".", "");

                // Chuyển đổi giá trị nhận được thành số
                double receivedValue = Double.parseDouble(processedText);

                // Lấy giá trị hiện tại của lb_total
                String totalText = lb_total.getText().trim();
                double totalValue = Double.parseDouble(totalText.replace(",", "").replace("VND", ""));

                // Kiểm tra nếu giá trị nhận được lớn hơn tổng
                if (receivedValue >= totalValue) {
                    // Tính toán và cập nhật giá trị của lb_changed
                    double changeValue = receivedValue - totalValue;
                    DecimalFormat df = new DecimalFormat("#,###");
                    lb_changed.setText(df.format(changeValue) + " VND");
                } else {
                    // Nếu giá trị nhận được nhỏ hơn tổng, hiển thị thông báo
                    JOptionPane.showMessageDialog(null, "Số tiền nhập vào phải lớn hơn số tiền cần thanh toán!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Giá trị nhập vào phải là số", "Error", JOptionPane.ERROR_MESSAGE);
                //ex.printStackTrace();
            }
        });

        lb_cancle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Gọi stored procedure Proc_XoaHoaDon
                deleteReceipt(maHoaDon);
                JOptionPane.showMessageDialog(null, "Hủy hóa đơn thành công", "Success", JOptionPane.INFORMATION_MESSAGE);

                CashierFrame cashierFrame = new CashierFrame();
                cashierFrame.setVisible(true);
                // Đóng Cashier_ReceiptFrame
                dispose();
//                Cashier_ReceiptFrame receiptFrame = new Cashier_ReceiptFrame(maHoaDon);
//                receiptFrame.setVisible(false);
            }

            private void deleteReceipt(String maHoaDon) {
                BookDAO bookDao = new BookDAO();
                bookDao.deleteReceipt(maHoaDon);
            }
        });

        DefaultTableModel model = (DefaultTableModel) tb_list.getModel();
        tb_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Check for double click
                    int selectedRow = tb_list.getSelectedRow();
                    if (selectedRow != -1) { // Check if any row is selected
                        // Get the ID of the selected row
                        String id = tb_list.getValueAt(selectedRow, 0).toString();
                        // Remove the row from the table model
                        model.removeRow(selectedRow);
                        System.out.println("Deleted row with ID: " + id);
                        updateIDs(selectedRow);
                    }
                }
            }

            private void updateIDs(int selectedRow) {
                for (int i = selectedRow; i < model.getRowCount(); i++) {
                    model.setValueAt(String.valueOf(i + 1), i, 0);
                }
            }
        });

        tb_list.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateTotalPrice();
                }
            }

            private void updateTotalPrice() {
                DefaultTableModel model = (DefaultTableModel) tb_list.getModel();
                int selectedRow = tb_list.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        int quantity = (int) model.getValueAt(selectedRow, 2);
                        int currentQuantity = getCurrentQuantity(selectedRow); // Lấy số lượng hiện có của mặt hàng

                        if (quantity <= 0) {
                            // Hiển thị thông báo và đặt lại giá trị số lượng về 1
                            JOptionPane.showMessageDialog(null, "Số lượng không thể là số nhỏ hơn hoặc bằng 0", "Error", JOptionPane.ERROR_MESSAGE);
                            model.setValueAt(1, selectedRow, 2);
                            return;
                        }

                        if (quantity > currentQuantity) {
                            // Hiển thị thông báo lỗi nếu số lượng nhập vào lớn hơn số lượng hiện có
                            JOptionPane.showMessageDialog(null, "Số lượng nhập vào lớn hơn số lượng hiện có của mặt hàng", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String priceStr = (String) model.getValueAt(selectedRow, 3);
                        // Loại bỏ dấu "," từ chuỗi số giá
                        priceStr = priceStr.replaceAll(",", "");
                        double price = Double.parseDouble(priceStr);
                        double totalPrice = quantity * price;
                        // Định dạng lại totalPrice thành chuỗi có dấu ","
                        DecimalFormat df = new DecimalFormat("#,###");
                        String formattedTotalPrice = df.format(totalPrice);
                        // Cập nhật giá trị mới vào cột
                        model.setValueAt(formattedTotalPrice, selectedRow, 4);

                        double subtotal = calculateTotal();
                        lb_sub.setText(df.format(subtotal) + " VND");
                        double total = subtotal - (subtotal * 0.1);
                        lb_total.setText(df.format(total) + " VND");
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        //JOptionPane.showMessageDialog(null, "Số lượng phải là một số nguyên", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            private int getCurrentQuantity(int selectedRow) {
                DefaultTableModel model = (DefaultTableModel) tb_list.getModel();
                String itemId = (String) model.getValueAt(selectedRow, 5); // Lấy ID từ cột số 5
                int currentQuantity = 0;

                // Sử dụng BookDAO để lấy số lượng hiện có của mặt hàng với ID là itemId
                BookDAO bookDao = new BookDAO();
                currentQuantity = bookDao.getQuantityById(itemId);

                return currentQuantity;
            }
        });
    }

    private double calculateTotal() {
        DefaultTableModel model = (DefaultTableModel) tb_list.getModel();
        double total = 0;
        for (int row = 0; row < model.getRowCount(); row++) {
            String value = (String) model.getValueAt(row, 4);
            try {
                double price = Double.parseDouble(value.replace(",", ""));
                total += price;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return total;
    }

    private void formatTable() {
        DefaultTableModel model = (DefaultTableModel) tb_list.getModel();
        model.addRow(new ModelItemSell("1", "sss", 2, 2, 4).toTableRow(tb_list.getRowCount() + 1));
        tb_list.getColumnModel().getColumn(2).setCellEditor(new QtyCellEditor(new EventCellInputChange() {
            @Override
            public void inputChanged() {
                System.err.println("Input changed");
            }
        }));
        tb_list.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }

        });
    }

//    private void printRecord(JPanel panelToPrint) {
//
//        btn_export.setVisible(false);
//        lb_cancle.setVisible(false);
//
//        PrinterJob printerJob = PrinterJob.getPrinterJob();
//        printerJob.setJobName("Print record");
//        printerJob.setPrintable(new Printable() {
//            @Override
//            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//                pageFormat.setOrientation(PageFormat.LANDSCAPE);
//                if (pageIndex > 0) {
//                    return Printable.NO_SUCH_PAGE;
//                }
//                Graphics2D graphics2D = (Graphics2D) graphics;
////                graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
////                graphics2D.scale(0.5,0.5);
//                graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//                graphics2D.scale(0.47, 0.47);
//                panelToPrint.paint(graphics2D);
//                return Printable.PAGE_EXISTS;
//            }
//        });
//        boolean returningResult = printerJob.printDialog();
//        if (returningResult) {
//            try {
//                printerJob.print();
//            } catch (PrinterException printerException) {
//                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
//            }
//        }
//    }
//    private void printRecord(JPanel panelToPrint) {
//
//        createItemList();
////        Float change = Float.parseFloat(jTextFieldCash.getText()) - Float.parseFloat(jTextFieldTotal.getText());
////        jTextFieldChange.setText(df.format(change));
//
//        PrinterJob pj = PrinterJob.getPrinterJob();
//        pj.setPrintable((Printable) this, getPageFormat(pj));
//
////      there's dialog
//        pj.setPrintable((Printable) this);
//        boolean ok = pj.printDialog();
//        if (ok) {
//            try {
//                pj.print();
//            } catch (PrinterException ex) {
//            }
//        }
//    }
    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double width = pf.getImageableWidth();
        double height = pf.getImageableHeight();
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        return pf;
    }

    protected static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 58d;
    }

// Phương thức để lấy kích thước giấy A4
    private Paper getA4Paper() {
        double width = 8.3 * 72; // inch to points
        double height = 11.7 * 72; // inch to points
        Paper paper = new Paper();
        paper.setSize(width, height);
        paper.setImageableArea(0, 0, width, height);
        return paper;
    }

    private void updateTotalInHoaDon(String maHoaDon, double total) {

        String totalString1 = lb_total.getText().replace(",", "").replace("VND", "");
        total = Double.parseDouble(totalString1);

        receiptDAO.updateTotalInHoaDon(lb_mahoadon.getText(), total);
    }

    private void addChiTietHoaDon(String maHoaDon, String maSach, int soLuongBan, double gia) {

        for (int i = 0; i < tb_list.getRowCount(); i++) {
            maSach = tb_list.getValueAt(i, 5).toString(); // Lấy mã sách từ cột đầu tiên
            soLuongBan = Integer.parseInt(tb_list.getValueAt(i, 2).toString()); // Lấy số lượng bán từ cột thứ hai
            gia = Double.parseDouble(tb_list.getValueAt(i, 4).toString().replaceAll(",", "")); // Lấy giá từ cột thứ ba

            // Thêm bản ghi mới vào bảng ChiTietHoaDon
            receiptDetailsDAO.addChiTietHoaDon(lb_mahoadon.getText(), maSach, soLuongBan, gia);
        }

    }

    private java.util.ArrayList<Item> createItemList() {
        java.util.ArrayList<Item> iL = new java.util.ArrayList<Item>();
        Item itm = null;
        for (int i = 0; i < tb_list.getRowCount(); i++) {
            String item = tb_list.getValueAt(i, 1).toString();
            String qty = tb_list.getValueAt(i, 2).toString();
            String price = tb_list.getValueAt(i, 3).toString().replace(",", ".");
            itm = new Item(item, qty, price);
            iL.add(itm);
        }
        return iL;
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        double totalAmount = 0.0;
        double change = 0.0;
        //String readFile = System.getProperty("user.dir") + "/src/main/resources/images/my pic.png";
        //ImageIcon icon = new ImageIcon(readFile);
        int result = NO_SUCH_PAGE;
        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;
            double width = pageFormat.getImageableWidth();
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 7));
            try {
                int y = 15;
                int yShift = 10;
                int headerRectHeight = 15;
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
                double wh = pageFormat.getImageableWidth();
                double ht = pageFormat.getImageableHeight();
                g2d.drawImage(null, 0, 0, (int) wh, (int) ht, null);

                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                //g2d.drawImage(icon.getImage(), 75, 20, 30, 30, rootPane);
                y += yShift + 30;
                g2d.drawString("--------------------------------------------------------", 10, y);
                y += yShift;
                g2d.drawString("  Quan Ly Nha Sach ", 100, y);
                y += yShift;
                g2d.drawString("  So 1 VVN, Thu Duc ", 100, y);
                y += yShift;
                g2d.drawString("  Ho Chi Minh City ", 100, y);
                y += yShift;
                y += yShift;
                g2d.drawString(lb_date.getText(), 10, y);
                y += yShift;
                g2d.drawString("ID: " + lb_mahoadon.getText(), 10, y);
                y += yShift;
                g2d.drawString("--------------------------------------------------------", 10, y);
                y += headerRectHeight;

                g2d.drawString(" Item                                       Price  ", 10, y);
                y += yShift;
                g2d.drawString("--------------------------------------------------------", 10, y);
                y += headerRectHeight;

                for (Item item : createItemList()) {
                    g2d.drawString(" " + item.getItem() + "                              ", 10, y);
                    y += yShift;
                    g2d.drawString("     " + item.getQty() + " x " + item.getPrice(), 5, y);
                    g2d.drawString(String.valueOf((Double.parseDouble(item.getQty()) * (Double.parseDouble(item.getPrice())))), 250, y);
                    y += yShift;
                    totalAmount = totalAmount + (Double.parseDouble(item.getQty())) * (Double.parseDouble(item.getPrice()));

                }
                double cash = Double.parseDouble(tf_received.getText().replace(",", "."));
                double total1 = Double.parseDouble(lb_total.getText().replace("VND", "").replace(",", "."));
                double change1 = Double.parseDouble(lb_changed.getText().replace("VND", "").replace(",", "."));

                g2d.drawString("--------------------------------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Total   :                                  " + String.valueOf(total1) + " VND" + "   ", 10, y);
                y += yShift;
                g2d.drawString("--------------------------------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Cash    :                                  " + String.valueOf(df.format(cash)) + " VND" + "   ", 10, y);
                y += yShift;
                g2d.drawString("--------------------------------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Change  :                                  " + String.valueOf(change1) + " VND" + "   ", 10, y);
                y += yShift;
                y += yShift;
                y += yShift;

                g2d.drawString("*********************************************************", 10, y);
                y += yShift;
                g2d.drawString("    THANK YOU, COME AGAIN!!    ", 90, y);
                y += yShift;
                g2d.drawString("*********************************************************", 10, y);
                y += yShift;

            } catch (Exception e) {
                e.printStackTrace();
            }
            result = PAGE_EXISTS;
        }
        return result;
    }

    private DecimalFormat df = new DecimalFormat("#,###");
}

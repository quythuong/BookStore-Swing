/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom08.bookstore.GUI.FunctionalPanels;

import com.nhom08.bookstore.DAO.DBConnection;
import com.nhom08.bookstore.DAO.StatisticsDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Admin
 */
public class Panel_Statistics extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Statistics
     */
    public Panel_Statistics() {
        initComponents();
        hienThiDoanhThu();
        showLineChart();
        showWeeklyChart();
        showPieChart();
    }

    public void showPieChart() {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.GetDBConnection();
        StatisticsDAO statisticsDAO = new StatisticsDAO(con);
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Lấy ngày được chọn từ JCalendar
        Date selectedDate = cld_lich.getDate();

        // Tạo một Calendar và thiết lập ngày được chọn
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        // Duyệt qua 7 ngày gần nhất
        for (int i = 0; i < 7; i++) {
            // Lấy ngày, tháng, năm của ngày hiện tại trong vòng lặp
            int ngay = calendar.get(Calendar.DAY_OF_MONTH);
            int thang = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
            int nam = calendar.get(Calendar.YEAR);

            // Tính toán doanh thu của ngày hiện tại
            float doanhThuNgay = statisticsDAO.tinhDoanhThuNgay(ngay, thang, nam);

            // Thêm giá trị vào dataset
            if (doanhThuNgay != 0) {
                dataset.setValue(ngay + "/" + thang + "/" + nam, doanhThuNgay);
            }
            // Giảm ngày hiện tại đi 1 ngày để lấy ngày trước đó
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        // Tạo biểu đồ Pie phẳng (không 3D)
        JFreeChart piechart = ChartFactory.createPieChart("", dataset, false, true, false);

        // Cài đặt một số thuộc tính cho biểu đồ Pie
        PiePlot piePlot = (PiePlot) piechart.getPlot();
        piePlot.setBackgroundPaint(Color.white); // Đặt màu nền thành màu trắng
        piePlot.setShadowPaint(new Color(0, 0, 0, 0)); // Đặt màu đổ bóng thành màu trong suốt
        // Thiết lập màu sắc cho các phần tử của biểu đồ Pie
        Color[] colors = {new Color(255, 207, 179), new Color(179, 255, 207), new Color(255, 230, 179),
            new Color(179, 207, 255), new Color(255, 179, 207), new Color(207, 255, 179),
            new Color(230, 179, 255)};
        for (int i = 0; i < dataset.getItemCount(); i++) {
            piePlot.setSectionPaint(dataset.getKey(i), colors[i % colors.length]); // Thiết lập màu cho phần tử dataset.getKey(i)
        }

        // Tạo ChartPanel để hiển thị biểu đồ
        ChartPanel pieChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(pieChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    public void showWeeklyChart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Lấy ngày hiện tại từ calendar
        Date selectedDate = cld_lich.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        // Lấy thông tin về tháng và năm
        int thang = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
        int nam = calendar.get(Calendar.YEAR);

        // Duyệt qua 4 tuần trong tháng
        for (int tuan = 1; tuan <= 4; tuan++) {
            // Tính toán ngày bắt đầu và kết thúc của tuần
            int ngayBatDau = (tuan - 1) * 7 + 1;
            int ngayKetThuc = tuan * 7;
            if (ngayKetThuc > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                ngayKetThuc = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            }

            // Tính toán doanh thu của tuần từ ngàyBatDau đến ngayKetThuc
            float doanhThuTuan = tinhDoanhThuTuan(ngayBatDau, ngayKetThuc, thang, nam);

            // Thêm giá trị vào dataset
            dataset.setValue(doanhThuTuan, "VND", "Week " + tuan);
        }

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart("", "Week", "VND",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        Font font = new Font("Lexend", Font.PLAIN, 12);
        chart.getTitle().setFont(font);
        chart.getCategoryPlot().getDomainAxis().setLabelFont(font);
        chart.getCategoryPlot().getRangeAxis().setLabelFont(font);

        // Cài đặt một số thuộc tính cho biểu đồ cột
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);
        renderer.setBarPainter(new StandardBarPainter()); // Sử dụng trình vẽ màu phẳng

        Color lightBlue = new Color(102, 178, 255); // Màu xanh dương nhạt
        renderer.setSeriesPaint(0, lightBlue);

        // Thêm biểu đồ vào jPanel1
        ChartPanel barChartPanel = new ChartPanel(chart);
        jPanel1.removeAll();
        jPanel1.add(barChartPanel, BorderLayout.CENTER);
        jPanel1.validate();
    }

    public float tinhDoanhThuTuan(int ngayBatDau, int ngayKetThuc, int thang, int nam) {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.GetDBConnection();
        StatisticsDAO statisticsDAO = new StatisticsDAO(con);
        float doanhThuTuan = 0;
        // Tính toán doanh thu từ ngàyBatDau đến ngayKetThuc trong tháng và năm tương ứng
        for (int ngay = ngayBatDau; ngay <= ngayKetThuc; ngay++) {
            float doanhThuNgay = statisticsDAO.tinhDoanhThuNgay(ngay, thang, nam);
            doanhThuTuan += doanhThuNgay;
        }
        return doanhThuTuan;
    }

  public void showLineChart() {
    DBConnection dbConnection = new DBConnection();
    Connection con = dbConnection.GetDBConnection();
    StatisticsDAO statisticsDAO = new StatisticsDAO(con);

    // Lấy năm từ cld_lich
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(cld_lich.getDate());
    int year = calendar.get(Calendar.YEAR);

    // Tạo dataset cho biểu đồ
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    // Duyệt qua từ tháng 1 đến tháng 12
    for (int thang = 1; thang <= 12; thang++) {
        // Lấy doanh thu của tháng từ đối tượng DAO
        float doanhThuThang = statisticsDAO.tinhDoanhThuThang(thang, year);
        // Đặt giá trị vào dataset
        dataset.setValue(doanhThuThang, "Amount", getMonthName(thang));
    }

    Font font = new Font("Lexend", Font.PLAIN, 12);

    // Tạo biểu đồ
    JFreeChart linechart = ChartFactory.createLineChart("", "Tháng", "Doanh thu (VND)",
            dataset, PlotOrientation.VERTICAL, false, true, false);
    linechart.getTitle().setFont(font); // Thiết lập font cho tiêu đề
    linechart.getCategoryPlot().getDomainAxis().setLabelFont(font); // Thiết lập font cho nhãn trên trục x
    linechart.getCategoryPlot().getRangeAxis().setLabelFont(font);

    // Tạo plot
    CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
    lineCategoryPlot.setBackgroundPaint(Color.white);

    // Tạo đối tượng Renderer để thay đổi các thuộc tính của đường như màu sắc
    LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
    Color lineChartColor = new Color(204, 0, 51);
    lineRenderer.setSeriesPaint(0, lineChartColor);

    // Tạo ChartPanel để hiển thị biểu đồ
    ChartPanel lineChartPanel = new ChartPanel(linechart);
    panelLineChart.removeAll();
    panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
    panelLineChart.validate();
}

    private String getMonthName(int month) {
        String[] monthNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        return monthNames[month - 1];
    }

    private void hienThiDoanhThu() {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.GetDBConnection();
        StatisticsDAO statisticsDAO = new StatisticsDAO(con);

        Date selectedDate = cld_lich.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        int ngay = calendar.get(Calendar.DAY_OF_MONTH);
        int thang = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
        int nam = calendar.get(Calendar.YEAR);
        float doanhThuNgay = statisticsDAO.tinhDoanhThuNgay(ngay, thang, nam);
        float doanhThuThang = statisticsDAO.tinhDoanhThuThang(thang, nam);
        float doanhThuNam = statisticsDAO.tinhDoanhThuNam(nam);

        String dtngay = String.format("%.0f", doanhThuNgay);
        String dtthang = String.format("%.0f", doanhThuThang);
        String dtnam = String.format("%.0f", doanhThuNam);
        // Hiển thị kết quả lên các JTextPane
        txt_doanhthungay.setText(String.valueOf(dtngay) + " VND");
        txt_doanhthuthang.setText(String.valueOf(dtthang) + " VND");
        txt_doanhthunam.setText(String.valueOf(dtnam) + " VND");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        panelCustom1 = new Custom.PanelCustom();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cld_lich = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_doanhthunam = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_doanhthungay = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_doanhthuthang = new javax.swing.JTextPane();
        panelLineChart = new Custom.PanelCustom();
        jPanel1 = new Custom.PanelCustom();
        panelBarChart = new Custom.PanelCustom();

        jTextPane3.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jTextPane3.setForeground(java.awt.SystemColor.controlHighlight);
        jScrollPane3.setViewportView(jTextPane3);

        setBackground(new java.awt.Color(255, 254, 251));
        setPreferredSize(new java.awt.Dimension(1056, 740));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lexend", 0, 30)); // NOI18N
        jLabel1.setText("Statistics Management");
        jLabel1.setPreferredSize(new java.awt.Dimension(342, 38));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 25, -1, -1));

        panelCustom1.setBackground(new java.awt.Color(243, 243, 243));
        panelCustom1.setPreferredSize(new java.awt.Dimension(230, 230));
        panelCustom1.setRoundBottomLeft(30);
        panelCustom1.setRoundBottomRigt(30);
        panelCustom1.setRoundTopLeft(30);
        panelCustom1.setRoundTopRigt(30);

        jLabel2.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel2.setText("Sum of day : ");

        jLabel3.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel3.setText("Sum of month :");

        jLabel4.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        jLabel4.setText("Sum of year :");

        cld_lich.setBackground(new java.awt.Color(255, 255, 255));
        cld_lich.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cld_lich.setDecorationBackgroundColor(new java.awt.Color(243, 243, 243));
        cld_lich.setDecorationBordersVisible(true);
        cld_lich.setFocusable(false);
        cld_lich.setFont(new java.awt.Font("Lexend", 1, 12)); // NOI18N
        cld_lich.setMinSelectableDate(new java.util.Date(-62135791116000L));
        cld_lich.setOpaque(false);
        cld_lich.setWeekOfYearVisible(false);
        cld_lich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cld_lichMouseClicked(evt);
            }
        });
        cld_lich.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cld_lichPropertyChange(evt);
            }
        });

        txt_doanhthunam.setBorder(null);
        txt_doanhthunam.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        txt_doanhthunam.setOpaque(false);
        jScrollPane1.setViewportView(txt_doanhthunam);

        txt_doanhthungay.setBorder(null);
        txt_doanhthungay.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        txt_doanhthungay.setOpaque(false);
        jScrollPane2.setViewportView(txt_doanhthungay);

        txt_doanhthuthang.setBorder(null);
        txt_doanhthuthang.setFont(new java.awt.Font("Lexend", 0, 15)); // NOI18N
        txt_doanhthuthang.setOpaque(false);
        jScrollPane4.setViewportView(txt_doanhthuthang);

        javax.swing.GroupLayout panelCustom1Layout = new javax.swing.GroupLayout(panelCustom1);
        panelCustom1.setLayout(panelCustom1Layout);
        panelCustom1Layout.setHorizontalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cld_lich, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addGroup(panelCustom1Layout.createSequentialGroup()
                        .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );
        panelCustom1Layout.setVerticalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cld_lich, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(273, 273, 273)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        add(panelCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 103, 261, 612));

        panelLineChart.setBackground(new java.awt.Color(243, 243, 243));
        panelLineChart.setPreferredSize(new java.awt.Dimension(685, 353));
        panelLineChart.setRoundBottomLeft(30);
        panelLineChart.setRoundBottomRigt(30);
        panelLineChart.setRoundTopLeft(30);
        panelLineChart.setRoundTopRigt(30);
        panelLineChart.setLayout(new java.awt.BorderLayout());
        add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 375, 680, 340));

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(426, 230));
        jPanel1.setRoundBottomLeft(30);
        jPanel1.setRoundBottomRigt(30);
        jPanel1.setRoundTopLeft(30);
        jPanel1.setRoundTopRigt(30);
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 103, -1, 250));

        panelBarChart.setBackground(new java.awt.Color(243, 243, 243));
        panelBarChart.setPreferredSize(new java.awt.Dimension(230, 230));
        panelBarChart.setRoundBottomLeft(30);
        panelBarChart.setRoundBottomRigt(30);
        panelBarChart.setRoundTopLeft(30);
        panelBarChart.setRoundTopRigt(30);
        panelBarChart.setLayout(new java.awt.BorderLayout());
        add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 103, 250, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void cld_lichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cld_lichMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cld_lichMouseClicked

    private void cld_lichPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cld_lichPropertyChange
        if ("calendar".equals(evt.getPropertyName())) {
            hienThiDoanhThu();
            showWeeklyChart();
            showPieChart();
            showLineChart();
        }
    }//GEN-LAST:event_cld_lichPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar cld_lich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private Custom.PanelCustom jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane3;
    private Custom.PanelCustom panelBarChart;
    private Custom.PanelCustom panelCustom1;
    private Custom.PanelCustom panelLineChart;
    private javax.swing.JTextPane txt_doanhthunam;
    private javax.swing.JTextPane txt_doanhthungay;
    private javax.swing.JTextPane txt_doanhthuthang;
    // End of variables declaration//GEN-END:variables
}

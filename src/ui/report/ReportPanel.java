package ui.report;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {

    public ReportPanel() {

        setLayout(null);
        setBackground(Color.WHITE);

        JLabel title = new JLabel("System Analytics Dashboard");
        title.setBounds(30, 20, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        add(title);

        //  KPI Widgets
        KPIWidgetPanel revenue = new KPIWidgetPanel("Revenue", "12,500$", new Color(220, 240, 255));
        revenue.setBounds(30, 80, 200, 120);

        KPIWidgetPanel cars = new KPIWidgetPanel("Cars", "45", new Color(220, 255, 220));
        cars.setBounds(250, 80, 200, 120);

        KPIWidgetPanel customers = new KPIWidgetPanel("Customers", "120", new Color(255, 240, 220));
        customers.setBounds(470, 80, 200, 120);

        KPIWidgetPanel profit = new KPIWidgetPanel("Profit", "8,300$", new Color(245, 245, 245));
        profit.setBounds(690, 80, 200, 120);

        add(revenue);
        add(cars);
        add(customers);
        add(profit);

        //  Chart Section
        ChartPanel chartPanel = new ChartPanel();
        chartPanel.setBounds(30, 230, 860, 300);

        add(chartPanel);
    }
}
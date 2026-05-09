package controller;

import service.ReportService;

import java.util.Date;

public class ReportController {

    private ReportService reportService = new ReportService();

    public double totalRevenue() {
        return reportService.getTotalRevenue();
    }

    public double branchRevenue(int branchId) {
        return reportService.getRevenueByBranch(branchId);
    }

    public double profit(int branchId) {
        return reportService.getProfit(branchId);
    }

    public int activeRentals() {
        return reportService.getActiveRentalsCount();
    }

    public int availableCars() {
        return reportService.getAvailableCarsCount();
    }

    public Object dailyReport(Date date) {
        return reportService.getDailyRevenueReport(date);
    }
}
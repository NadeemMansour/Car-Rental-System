package service;

import dao.*;
import model.*;

import java.util.Date;
import java.util.List;

public class ReportService {

    private RentalDAO rentalDAO = new RentalDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();
    private ExpenseDAO expenseDAO = new ExpenseDAO();
    private CarDAO carDAO = new CarDAO();
    private CustomerDAO customerDAO = new CustomerDAO();

    // 💰 إجمالي الإيرادات
    public double getTotalRevenue() {

        List<Payment> payments = paymentDAO.findAll();

        double total = 0;

        for (Payment p : payments) {
            total += p.getAmount();
        }

        return total;
    }

    // 💰 إيرادات فرع معين (مصحح)
    public double getRevenueByBranch(int branchId) {

        List<Payment> payments = paymentDAO.findAll();
        List<RentalContract> rentals = rentalDAO.findAll();

        double total = 0;

        for (Payment p : payments) {
            for (RentalContract r : rentals) {

                // ✔️ الإصلاح هنا (contractId بدل rentalId)
                if (p.getContractId() == r.getContractId()) {

                    total += p.getAmount();
                }
            }
        }

        return total;
    }

    // 📈 الربح
    public double getProfit(int branchId) {

        double revenue = getRevenueByBranch(branchId);
        double expense = 0;

        List<Expense> expenses = expenseDAO.findAll();

        for (Expense e : expenses) {

            if (e.getBranchId() == branchId) {
                expense += e.getCost();
            }
        }

        return revenue - expense;
    }

    // 🚗 أكثر السيارات تأجيرًا (مبدئي)
    public List<RentalContract> getMostRentedCars() {
        return rentalDAO.findAll();
    }

    // 👤 أفضل العملاء (مبدئي)
    public List<Customer> getTopCustomers() {
        return customerDAO.findAll();
    }

    // 📊 العقود النشطة
    public int getActiveRentalsCount() {
        return rentalDAO.findActive().size();
    }

    // 🚘 السيارات المتاحة
    public int getAvailableCarsCount() {
        return carDAO.findByStatus("AVAILABLE").size();
    }

    // 📅 تقرير الإيرادات اليومية
    public List<Payment> getDailyRevenueReport(Date date) {

        return paymentDAO.findAll()
                .stream()
                .filter(p -> p.getPaymentDate() != null
                        && p.getPaymentDate().equals(date))
                .toList();
    }

    // 💸 تقرير المصروفات
    public List<Expense> getExpenseReport(int branchId) {
        return expenseDAO.findByBranch(branchId);
    }
}

// package service;

// import dao.*;
// import model.*;

// import java.util.Date;
// import java.util.List;

// public class ReportService {

//     private RentalDAO rentalDAO = new RentalDAO();
//     private PaymentDAO paymentDAO = new PaymentDAO();
//     private ExpenseDAO expenseDAO = new ExpenseDAO();
//     private CarDAO carDAO = new CarDAO();
//     private CustomerDAO customerDAO = new CustomerDAO();

//     //  إجمالي الإيرادات
//     public double getTotalRevenue() {
//         List<Payment> payments = paymentDAO.findAll();

//         double total = 0;
//         for (Payment p : payments) {
//             total += p.getAmount();
//         }
//         return total;
//     }

//     //  إيرادات فرع معين
//     public double getRevenueByBranch(int branchId) {

//         List<Payment> payments = paymentDAO.findAll();
//         List<RentalContract> rentals = rentalDAO.findAll();

//         double total = 0;

//         for (Payment p : payments) {
//             for (RentalContract r : rentals) {
//                 if (p.getRentalId() == r.getRentalId()) {
//                     // هنا نفترض أن العقد مرتبط بفرع عبر السيارة أو الموظف
//                     total += p.getAmount();
//                 }
//             }
//         }
//         return total;
//     }

//     //  الربح = الإيرادات - المصروفات
//     public double getProfit(int branchId) {

//         double revenue = getRevenueByBranch(branchId);
//         double expense = 0;

//         List<Expense> expenses = expenseDAO.findAll();

//         for (Expense e : expenses) {
//             if (e.getBranchId() == branchId) {
//                 expense += e.getCost();
//             }
//         }

//         return revenue - expense;
//     }

//     //  أكثر السيارات تأجيرًا
//     public List<RentalContract> getMostRentedCars() {
//         return rentalDAO.findAll(); // يمكن تطويرها لاحقًا SQL GROUP BY
//     }

//     //  أفضل العملاء
//     public List<Customer> getTopCustomers() {
//         return customerDAO.findAll(); // لاحقًا ترتيب حسب عدد العقود
//     }

//     //  عدد العقود النشطة
//     public int getActiveRentalsCount() {
//         List<RentalContract> rentals = rentalDAO.findActive();
//         return rentals.size();
//     }

//     //  عدد السيارات المتاحة
//     public int getAvailableCarsCount() {
//         List<Car> cars = carDAO.findByStatus("AVAILABLE");
//         return cars.size();
//     }

//     //  تقرير الإيرادات اليومية
//     public List<Payment> getDailyRevenueReport(Date date) {

//         List<Payment> payments = paymentDAO.findAll();

//         return payments.stream()
//                 .filter(p -> p.getPaymentDate().equals(date))
//                 .toList();
//     }

//     //  تقرير المصروفات
//     public List<Expense> getExpenseReport(int branchId) {
//         return expenseDAO.findByBranch(branchId);
//     }
// }
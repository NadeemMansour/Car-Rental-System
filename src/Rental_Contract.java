import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

class Rental_Contract implements Serializable {

    private int contractID;
    private Date startDate;
    private Date endDate;
    private double totalAmount;
    private double deposit;
    private String status;

    public Rental_Contract(Date startDate, Date endDate, double totalAmount, double deposit, String status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
        this.deposit = deposit;
        this.status = status;
    }

    public int getContractID() {
        return contractID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ArrayList<Rental_Contract> view(Connection conn) {
        ArrayList<Rental_Contract> list = new ArrayList<>();
        final String SQL = "SELECT * FROM Rental_Contract";
        try (PreparedStatement ps = conn.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Rental_Contract rc = new Rental_Contract(
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getDouble("totalAmount"),
                        rs.getDouble("deposit"),
                        rs.getString("status"));
                rc.contractID = rs.getInt("contractID");
                list.add(rc);
            }
        } catch (Exception e) {
            System.out.println("View Error: " + e.getMessage());
        }
        return list;
    }

    public void add(Connection conn) {
        final String SQL = "INSERT INTO Rental_Contract "
                + "(startDate, endDate, totalAmount, deposit, status) "
                + "VALUES (?, ?, ?, ?, ?)";
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        if (deposit < 0) {
            throw new IllegalArgumentException("Deposit cannot be negative");
        }
        calculateTotalAmount();
        try (
                PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            boolean autoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);
            ps.setDate(1, this.startDate);
            ps.setDate(2, this.endDate);
            ps.setDouble(3, this.totalAmount);
            ps.setDouble(4, this.deposit);
            ps.setString(5, this.status != null ? this.status : "Active");
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    this.contractID = rs.getInt(1);
                } else {
                    throw new SQLException("Insert succeeded but no ID obtained.");
                }
            }
            conn.commit();
            conn.setAutoCommit(autoCommit);
        } catch (Exception e) {
            try {
                conn.rollback(); // rollback في حالة الخطأ
            } catch (Exception ex) {
                System.out.println("Rollback failed: " + ex);
            }
            System.out.println("Add Contract Error: " + e.getMessage());
        }
    }

    public void delete(Connection conn) {
        final String SQL = "DELETE FROM Rental_Contract WHERE contractID = ?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, this.contractID);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Delete failed, contract not found.");
            }
            System.out.println("Contract deleted successfully.");
        } catch (Exception e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }

    public void updateStatus(Connection conn, String newStatus) {
        final String SQL = "UPDATE Rental_Contract SET status = ? WHERE contractID = ?";
        try (PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, newStatus);
            ps.setInt(2, this.contractID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cancelContract(Connection conn) {
        String query = "UPDATE Rental_Contract SET status = ? WHERE contractID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "Cancelled");
            ps.setInt(2, this.contractID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double calculateTotalAmount() {
        long diff = endDate.getTime() - startDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        double pricePerDay = 50;
        this.totalAmount = days * pricePerDay;
        return totalAmount;
    }

    public void extendContract(Connection conn, Date newEndDate) {
        this.endDate = newEndDate;
        calculateTotalAmount();
        String query = "UPDATE Rental_Contract SET endDate = ?, totalAmount = ? WHERE contractID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, this.endDate);
            ps.setDouble(2, this.totalAmount);
            ps.setInt(3, this.contractID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void generateInvoice(Connection conn) {
        String query = "SELECT * FROM Rental_Contract WHERE contractID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, this.contractID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("========== INVOICE ==========");
                System.out.println("Contract ID: " + rs.getInt("contractID"));
                System.out.println("Start Date : " + rs.getDate("startDate"));
                System.out.println("End Date   : " + rs.getDate("endDate"));
                System.out.println("Deposit    : " + rs.getDouble("deposit"));
                System.out.println("Total      : " + rs.getDouble("totalAmount"));
                System.out.println("Status     : " + rs.getString("status"));
                System.out.println("=============================");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void saveAll(ArrayList<Rental_Contract> list) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Rental_Contract.ser"));
            for (Rental_Contract rc : list) {
                output.writeObject(rc);
            }
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Rental_Contract> search(
            Connection conn,
            String status,
            Double minAmount,
            Double maxAmount,
            Date startDate,
            Date endDate) {
        ArrayList<Rental_Contract> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Rental_Contract WHERE 1=1");
        if (status != null) {
            sql.append(" AND status = ?");
        }
        if (minAmount != null) {
            sql.append(" AND totalAmount >= ?");
        }
        if (maxAmount != null) {
            sql.append(" AND totalAmount <= ?");
        }
        if (startDate != null) {
            sql.append(" AND startDate >= ?");
        }
        if (endDate != null) {
            sql.append(" AND endDate <= ?");
        }
        try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            int index = 1;
            if (status != null) {
                ps.setString(index++, status);
            }
            if (minAmount != null) {
                ps.setDouble(index++, minAmount);
            }
            if (maxAmount != null) {
                ps.setDouble(index++, maxAmount);
            }
            if (startDate != null) {
                ps.setDate(index++, startDate);
            }
            if (endDate != null) {
                ps.setDate(index++, endDate);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rental_Contract rc = new Rental_Contract(
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getDouble("totalAmount"),
                        rs.getDouble("deposit"),
                        rs.getString("status"));
                rc.contractID = rs.getInt("contractID");
                list.add(rc);
            }
        } catch (Exception e) {
            System.out.println("Search Error: " + e.getMessage());
        }
        return list;
    }

}
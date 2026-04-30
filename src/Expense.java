class Expense {
    private String description;
    private String category;

    public Expense(String description, String category) {
        this.description = description;
        this.category = category;
    }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public void addExpense() {}
    public void updateExpense() {}
    public void deleteExpense() {}
    public void calculateTotalExpenses() {}
}
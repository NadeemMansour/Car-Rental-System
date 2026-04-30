import java.sql.Date;

class CarReturn {
    private Date returnDate;
    private String condition;

    
    

    public CarReturn(Date returnDate, String condition) {
        this.returnDate = returnDate;
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "CarReturn [returnDate=" + returnDate + ", condition=" + condition + ", getCondition()=" + getCondition()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
    
}
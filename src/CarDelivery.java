import java.sql.Date;

class CarDelivery {
    private Date deliveryDate;
    private String condition;
    
    public CarDelivery(Date deliveryDate, String condition) {
        this.deliveryDate = deliveryDate;
        this.condition = condition;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

}
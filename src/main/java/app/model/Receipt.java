package app.model;

import java.text.DecimalFormat;
import java.util.UUID;

public class Receipt {
    private String id = UUID.randomUUID().toString().substring(0, 8);
    private String companyName;
    private double payment;
    private String date;
    private String time;
    private boolean paid;
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Receipt # " + id + "\n" +
                companyName + " \n" +
                new DecimalFormat("#0.00").format(payment) + "\n" +
                date + " | " + time + "\n" +
                "paid: " + paid + "\n" +
                comment;
    }
}

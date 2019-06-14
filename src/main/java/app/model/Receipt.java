package app.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @Column(name = "rec_id")
    private String id = UUID.randomUUID().toString().substring(0, 8);

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "payment")
    private double payment;

    @Column(name = "paid")
    private boolean paid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    @Column(name = "comment")
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

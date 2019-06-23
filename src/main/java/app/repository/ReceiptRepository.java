package app.repository;

import app.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, String> {

    List<Receipt> findByPaid(Boolean bool);

    //List<Receipt> findByOrOrderByCompanyNameAsc();

    @Modifying
    @Query(value = "update Receipt rec set " +
            "rec.companyName= ?1," +
            " rec.payment = ?2," +
            " rec.paid= ?3," +
            " rec.date = ?4," +
            " rec.time = ?5," +
            " rec.comment= ?6" +
            "where rec.id= ?7")
    void customEditReceipt(String companyName,
                           Double payment,
                           Boolean paid,
                           LocalDate date,
                           LocalTime time,
                           String comment,
                           String id);
}

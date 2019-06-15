package app.dao;

import app.model.Receipt;

import java.util.List;

public interface DaoReceipt {
    void addReceipt(Receipt receipt);

    void editReceipt(Receipt receipt);

    Receipt getReceipt(String id);

    void deleteReceipt(Receipt receipt);

    List<Receipt> getAllReceipts();

}

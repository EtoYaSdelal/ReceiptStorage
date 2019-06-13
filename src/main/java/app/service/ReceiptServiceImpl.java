package app.service;

import app.dao.DaoReceiptImpl;
import app.model.Receipt;

import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private DaoReceiptImpl daoReceipt = new DaoReceiptImpl();

    @Override
    public void addReceipt(Receipt receipt) {
        daoReceipt.addReceipt(receipt);

    }

    @Override
    public void editReceipt(Receipt receipt) {
        daoReceipt.editReceipt(receipt);
    }

    @Override
    public Receipt getReceipt(String id) {
        return daoReceipt.getReceipt(id);
    }

    @Override
    public void deleteReceipt(String id) {
        daoReceipt.deleteReceipt(id);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return daoReceipt.getAllReceipts();
    }
}

package app.service;

import app.dao.DaoReceiptImpl;
import app.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final DaoReceiptImpl daoReceipt;

    @Autowired
    public ReceiptServiceImpl(DaoReceiptImpl daoReceipt) {
        this.daoReceipt = daoReceipt;
    }

    @Override
    @Transactional
    public void addReceipt(Receipt receipt) {
        daoReceipt.addReceipt(receipt);

    }

    @Override
    @Transactional
    public void editReceipt(Receipt receipt) {
        daoReceipt.editReceipt(receipt);
    }

    @Override
    @Transactional
    public Receipt getReceipt(String id) {
        return daoReceipt.getReceipt(id);
    }

    @Override
    @Transactional
    public void deleteReceipt(Receipt receipt) {
        daoReceipt.deleteReceipt(receipt);
    }

    @Override
    @Transactional
    public List<Receipt> getAllReceipts() {
        return daoReceipt.getAllReceipts();
    }

    @Override
    @Transactional
    public List<Receipt> showDebtors() {
        return daoReceipt.showDebtors();
    }

}


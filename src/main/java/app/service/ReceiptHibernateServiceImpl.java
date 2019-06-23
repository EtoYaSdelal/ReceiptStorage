/*
package app.service;

import app.dao.DaoReceiptImpl;
import app.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptHibernateServiceImpl implements ReceiptService {

    private final DaoReceiptImpl daoReceipt;

    @Autowired
    public ReceiptHibernateServiceImpl(DaoReceiptImpl daoReceipt) {
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
        return getAllReceipts().stream().filter(x -> !x.getPaid()).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Receipt> sortByName() {
        return getAllReceipts().stream().sorted(Comparator.comparing(r-> r.getCompanyName().toUpperCase())).collect(Collectors.toList());
    }

}

*/

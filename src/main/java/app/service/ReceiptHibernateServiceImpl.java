package app.service;

import app.dao.DaoReceipt;
import app.model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(value = "hibernateTransactionManager")
public class ReceiptHibernateServiceImpl implements ReceiptService {


    @Autowired
    private DaoReceipt daoReceipt;


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
    public void deleteReceipt(Receipt receipt) {
        daoReceipt.deleteReceipt(receipt);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return daoReceipt.getAllReceipts();
    }

    @Override
    public List<Receipt> showDebtors() {
        return getAllReceipts().stream().filter(x -> !x.getPaid()).collect(Collectors.toList());
    }

    @Override
    public List<Receipt> sortByName() {
        return getAllReceipts().stream().sorted(Comparator.comparing(r -> r.getCompanyName().toUpperCase())).collect(Collectors.toList());
    }

}


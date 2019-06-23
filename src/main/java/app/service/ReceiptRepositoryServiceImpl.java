package app.service;

import app.model.Receipt;
import app.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReceiptRepositoryServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    @Transactional
    public void addReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    @Transactional
    public void editReceipt(Receipt receipt) {
        receiptRepository.customEditReceipt(
                receipt.getCompanyName()
                , receipt.getPayment()
                , receipt.getPaid()
                , receipt.getDate()
                , receipt.getTime()
                , receipt.getComment()
                , receipt.getId());
    }


    @Override
    public Receipt getReceipt(String id) {
        return receiptRepository.getOne(id);
    }

    @Override
    @Transactional
    public void deleteReceipt(Receipt receipt) {
        receiptRepository.delete(receipt);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public List<Receipt> showDebtors() {
        return receiptRepository.findByPaid(false);
    }

    @Override
    public List<Receipt> sortByName() {
        return receiptRepository.findAll(Sort.by(Sort.Direction.ASC, "companyName"));
    }
}

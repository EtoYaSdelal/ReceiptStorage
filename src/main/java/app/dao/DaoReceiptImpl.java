package app.dao;

import app.model.Receipt;
import app.util.RandomReceiptGetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoReceiptImpl implements DaoReceipt {
    private static Map<String, Receipt> receiptMap = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++ ){
            Receipt receipt = RandomReceiptGetter.getReceipt();
            receiptMap.put(receipt.getId(),receipt);
        }
    }

    @Override
    public void addReceipt(Receipt receipt) {
        receiptMap.put(receipt.getId(), receipt);
    }

    @Override
    public void editReceipt(Receipt receipt) {
        receiptMap.put(receipt.getId(), receipt);

    }

    @Override
    public Receipt getReceipt(String id) {
        return receiptMap.get(id);
    }

    @Override
    public void deleteReceipt(Receipt receipt) {
        receiptMap.remove(receipt.getId());
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return new ArrayList<>(receiptMap.values());
    }

//    public static void main(String[] args) {
//        DaoReceiptImpl daoReceipt = new DaoReceiptImpl();
//
//        daoReceipt.getAllReceipts().forEach(x-> System.out.println(x + "\n"));
//    }
}

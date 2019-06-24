package app.dao;

import app.model.Receipt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoReceiptImpl implements DaoReceipt {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addReceipt(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(receipt);
    }

    @Override
    public void editReceipt(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        session.update(receipt);
    }


    @Override
    public Receipt getReceipt(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Receipt.class, id);
    }

    @Override
    public void deleteReceipt(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(receipt);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Receipt> getAllReceipts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Receipt ").list();
    }

}

package app.dao;

import app.model.Receipt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoReceiptImpl implements DaoReceipt {

    private SessionFactory sessionFactory;

    @Autowired
    public DaoReceiptImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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

    @Override
    @SuppressWarnings("unchecked")
    public List<Receipt> showDebtors() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Receipt where paid=false").list();
    }

}

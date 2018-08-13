package db;

import models.Pointe;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBPointe {

    private static Session session;
    private static Transaction transaction;

    public static void save(Pointe pointe) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(pointe);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Pointe> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Pointe> results = null;
        try {
            Criteria cr = session.createCriteria(Pointe.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Pointe findById(int id) {
        Pointe result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Pointe.class);
            cr.add(Restrictions.eq("id", id));
            result = (Pointe)cr.uniqueResult();
        }catch (HibernateException ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }
}


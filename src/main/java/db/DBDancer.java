package db;

import models.Dancer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDancer {

    private static Session session;
    private static Transaction transaction;

//    CREATE
    public static void save(Dancer dancer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(dancer);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//   READ
    public static List<Dancer> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Dancer> results = null;
        try {
            Criteria cr = session.createCriteria(Dancer.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

//   FIND BY ID
    public static Dancer findById(int id) {
        Dancer result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Dancer.class);
            cr.add(Restrictions.eq("id", id));
            result = (Dancer)cr.uniqueResult();
        }catch (HibernateException ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

//    UPDATE
    public static Dancer update(int id, ) {
        Dancer result = null;
        session = HibernateUtil.getSessionFactory().openSession();

    }

}

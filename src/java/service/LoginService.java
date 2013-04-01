/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Iterator;
import java.util.List;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class LoginService {

    Session session;
    Transaction transaction;

    public int checkLoginDetails(String username, String password) {
        int check_user = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Users");
            List list = query.list();
            Iterator it_u = list.iterator();
            for (int i = 0; it_u.hasNext(); i++) {
                Users st_u = (Users) it_u.next();
                if (username.equals(st_u.getUsername()) && password.equals(st_u.getPassword())) {
                    check_user = 1;
                }
            }

            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }
        return check_user;
    }
    
    public Integer getUserId(String username, String password){
        int users_id = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Users");
            List list = query.list();
            Iterator it_u = list.iterator();
            for (int i = 0; it_u.hasNext(); i++) {
                Users st_u = (Users) it_u.next();
                if (username.equals(st_u.getUsername()) && password.equals(st_u.getPassword())) {
                    users_id = st_u.getIdusers();
                }
            }

            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }
        return users_id;
    }
}

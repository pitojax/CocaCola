/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.UserType;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class RegisteruserstypeService {

    Session session;
    Transaction transaction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    UserType usertype = new UserType();

    public String storeUsersType(String name, String details, int session_id) {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            usertype.setName(name);
            usertype.setDetails(details);
            usertype.setDate(date);

            Query query = session.createQuery("from Users");
            List dco = query.list();
            Integer users_id = null;
            Iterator it = dco.iterator();
            for (int i = 0; it.hasNext(); i++) {
                Users st = (Users) it.next();
                if (session_id == st.getIdusers()) {
                    users_id = (st.getIdusers());
                }
            }
            Users user_o = (Users) session.get(Users.class, users_id);
            usertype.setUsers(user_o);

            session.save(usertype);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }


        return "User permission successfully submitted.";
    }

    public Object[][] getAllUserTypes() {
        Object[][] referencedata = null ;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from UserType");
            List userstype_ = query.list();
            referencedata = new Object[userstype_.size()][4];
            Iterator it = userstype_.iterator();
            for (int i = 0; it.hasNext(); i++) {
                UserType st = (UserType) it.next();
                referencedata[i][0] = st.getName();
                referencedata[i][1] =  st.getDetails();
                referencedata[i][2] =  st.getDate();
                referencedata[i][3] =  st.getUsers().getFname() + " " + st.getUsers().getLname();
            }

            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return referencedata;
    }

    
}

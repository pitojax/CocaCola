/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.DcOwner;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class RegisterdcownerService {

    Session session;
    Transaction transaction;
    Date date = new Date();
    DcOwner dcowner = new DcOwner();

    public String storeDcOwner(String name, int telephone, String email, int session_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            dcowner.setName(name);
            dcowner.setTelephone(telephone);
            dcowner.setEmail(email);
            dcowner.setDate(date);

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
            dcowner.setUsers(user_o);

            session.save(dcowner);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }


        return "Dc owner data successfully submitted.";
    }

    public Object[][] getAllDcOwners() {
        Object[][] referencedata = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from DcOwner");
            List userstype_ = query.list();
            referencedata = new Object[userstype_.size()][5];
            Iterator it = userstype_.iterator();
            for (int i = 0; it.hasNext(); i++) {
                DcOwner st = (DcOwner) it.next();
                referencedata[i][0] = st.getName();
                referencedata[i][1] = st.getTelephone();
                referencedata[i][2] = st.getEmail();
                referencedata[i][3] = st.getUsers().getFname() + " " + st.getUsers().getLname();
                referencedata[i][4] = st.getDate();
            }

            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return referencedata;
    }
    
}

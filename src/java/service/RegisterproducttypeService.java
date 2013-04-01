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
import model.ProductType;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class RegisterproducttypeService {
    Session session;
    Transaction transaction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    ProductType producttype = new ProductType();
    
    public String storeProductType(String name, String details, int session_id){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            producttype.setName(name);
            producttype.setDetails(details);
            producttype.setDatetime(date);

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
            producttype.setUsers(user_o);

            session.save(producttype);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }
        return "Product successfully stored in the database";
    }
}

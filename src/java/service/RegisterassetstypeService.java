package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.AssetType;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class RegisterassetstypeService {

    Session session;
    Transaction transaction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    AssetType assettype = new AssetType();

    public String storeAssetsType(String name, String details, int session_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            assettype.setName(name);
            assettype.setDetails(details);
            assettype.setDate(date);

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
            assettype.setUsers(user_o);

            session.save(assettype);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }
        return "Asset type successfully stored.";
    }
    
    public Object[][] getAllAssetTypes() {
        Object[][] referencedata = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from AssetType");
            List assettype_ = query.list();
            referencedata = new Object[assettype_.size()][4];
            Iterator it = assettype_.iterator();
            for (int i = 0; it.hasNext(); i++) {
                AssetType st = (AssetType) it.next();
                referencedata[i][0] = st.getName();
                referencedata[i][1] = st.getDetails();
                referencedata[i][2] = st.getUsers().getFname() + " " + st.getUsers().getLname();
                referencedata[i][3] = st.getDate();
            }

            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return referencedata;
    }

   
}

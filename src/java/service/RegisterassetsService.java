/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.AssetType;
import model.Assets;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class RegisterassetsService {
    Session session;
    Transaction transaction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    AssetType assettype = new AssetType();
    Assets assets = new Assets();
    
     public List<AssetType> getAssetTypes() {
        List<AssetType> assettypes = new ArrayList<AssetType>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from AssetType");
            assettypes = query.list();
            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return assettypes;
    }
     
     public String storeAssets( int assettype_id, String serialno, String details, int session_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query_at = session.createQuery("from AssetType");
            List at = query_at.list();
            Integer assettype_id_ = null;
            Iterator it = at.iterator();
            for (int i = 0; it.hasNext(); i++) {
                AssetType st = (AssetType) it.next();
                if (assettype_id == st.getIdassetType()) {
                    assettype_id_ = (st.getIdassetType());
                }
            }
            AssetType assettype_ = (AssetType) session.get(AssetType.class, assettype_id_);
            assets.setAssetType(assettype_);
            
            assets.setDetails(details);
            assets.setDate(date);
            assets.setSerialNo(serialno);

            Query query = session.createQuery("from Users");
            List dco = query.list();
            Integer users_id = null;
            Iterator itu = dco.iterator();
            for (int i = 0; itu.hasNext(); i++) {
                Users st = (Users) itu.next();
                if (session_id == st.getIdusers()) {
                    users_id = (st.getIdusers());
                }
            }
            Users user_o = (Users) session.get(Users.class, users_id);
            assets.setUsers(user_o);

            session.save(assets);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }
        return "Asset details successfully stored.";
    }
     
      public Object[][] getAllAssets() {
        Object[][] referencedata = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Assets");
            List assets_ = query.list();
            referencedata = new Object[assets_.size()][5];
            Iterator it = assets_.iterator();
            for (int i = 0; it.hasNext(); i++) {
                Assets st = (Assets) it.next();
                referencedata[i][0] = st.getAssetType().getName();
                referencedata[i][1] = st.getSerialNo();
                referencedata[i][2] = st.getDetails();
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

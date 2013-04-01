package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import model.DcInfo;
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
public class RegisterdcinformationService {

    Session session;
    Transaction transaction;
    Date date = new Date();
    DcOwner dcowner = new DcOwner();
    DcInfo dcinfo = new DcInfo();

    public List<DcOwner> getDcOwners() {
        List<DcOwner> dcowners = new ArrayList<DcOwner>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from DcOwner");
            dcowners = query.list();
            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return dcowners;

    }
    
    public String storeDcInformation(String name, int dcowner, int telephone, String location, String email, String start_date_of_contract, String expiry_date_of_contract, int session_id){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            dcinfo.setName(name);
            dcinfo.setTelephone(telephone);
            dcinfo.setEmail(email);
            dcinfo.setDate(date);
            
            Query query_do = session.createQuery("from DcOwner");
            List dco = query_do.list();
            Integer dcowner_id = null;
            Iterator it = dco.iterator();
            for (int i = 0; it.hasNext(); i++) {
                DcOwner st = (DcOwner) it.next();
                if (dcowner == st.getIddcOwner()) {
                    dcowner_id = (st.getIddcOwner());
                }
            }
            DcOwner dcowner_ = (DcOwner) session.get(DcOwner.class, dcowner_id);
            dcinfo.setDcOwner(dcowner_);
            
            dcinfo.setLocation(location);
            
            Date start_date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(start_date_of_contract);
            dcinfo.setStartDateOfContract(start_date);
            
            Date expiry_date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(expiry_date_of_contract);
            dcinfo.setExpireyDateOfContract(expiry_date);

            Query query = session.createQuery("from Users");
            List users = query.list();
            Integer users_id = null;
            Iterator itu = users.iterator();
            for (int i = 0; itu.hasNext(); i++) {
                Users st = (Users) itu.next();
                if (session_id == st.getIdusers()) {
                    users_id = (st.getIdusers());
                }
            }
            Users user_ = (Users) session.get(Users.class, users_id);
            dcinfo.setUsers(user_);

            session.save(dcowner);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }


        return "Dc owner data successfully submitted.";
    }
}

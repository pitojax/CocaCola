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
public class UsersService {

    Session session;
    Transaction transaction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    UserType usertype = new UserType();
    Users users = new Users();
    Crypto crypto = new Crypto();

    public String storeUsers(String username, String password, String fname, String lname, int permissions, int session_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            users.setUsername(username);
            users.setPassword(password);
            users.setFname(fname);
            users.setLname(lname);

            Query queryu = session.createQuery("from UserType");
            List list = queryu.list();
            Integer user_permission = null;
            Iterator it_ut = list.iterator();
            for (int i = 0; it_ut.hasNext(); i++) {
                UserType st_u = (UserType) it_ut.next();
                if (permissions == st_u.getIduserType()) {
                    user_permission = st_u.getIduserType();
                }
            }
            UserType users_o = (UserType) session.get(UserType.class, user_permission);
            users.setUserType(users_o);

            Query query = session.createQuery("from Users where is_deleted = 0");
            List usersList = query.list();
            Integer users_id = null;
            Iterator it = usersList.iterator();
            for (int i = 0; it.hasNext(); i++) {
                Users st = (Users) it.next();
                if (session_id == st.getIdusers()) {
                    users_id = st.getIdusers();
                }
            }
            Users user_o = (Users) session.get(Users.class, users_id);
            users.setUsersByUsersId(user_o);
            users.setUsersByUpdatedBy(user_o);
            users.setDate(date);
            users.setLastUpdated(date);

            session.save(users);
            transaction.commit();

        } catch (Exception e) {
            
        }
        return "User data successfully submitted";
    }

    public List<UserType> getUsersType() {
        List<UserType> userstype = new ArrayList<UserType>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from UserType");
            userstype = query.list();
            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return userstype;

    }

    public Object[][] getAllUsers() {
        Object[][] referencedata = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Users where is_deleted = 0");
            List users_ = query.list();
            referencedata = new Object[users_.size()][6];
            Iterator it = users_.iterator();
            for (int i = 0; it.hasNext(); i++) {
                Users st = (Users) it.next();
                referencedata[i][0] = st.getFname() + " " + st.getLname();
                referencedata[i][1] = st.getUsername();
                referencedata[i][2] = st.getUserType().getName();
                referencedata[i][3] = st.getUsersByUsersId().getFname() + " " + st.getUsersByUsersId().getLname();
                referencedata[i][4] = st.getDate();
                referencedata[i][5] = st.getIdusers();
            }

            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return referencedata;
    }

    public List<Users> getUserById(String users_id) {
        List<Users> _user = new ArrayList<Users>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Users where is_deleted = 0 and idusers = " + Integer.parseInt(crypto.decode(users_id)));
            _user = query.list();
            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return _user;
    }

    public String updateUsers(String usersid, String username, String password, String fname, String lname, int permissions, int session_id) {

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Users user = (Users) session.get(Users.class, Integer.parseInt(crypto.decode(usersid)));
            System.out.println(user.getIdusers());
            user.setUsername(username);
            user.setPassword(password);
            user.setFname(fname);
            user.setLname(lname);

            Query queryu = session.createQuery("from UserType");
            List list = queryu.list();
            Integer user_permission = null;
            Iterator it_ut = list.iterator();
            for (int i = 0; it_ut.hasNext(); i++) {
                UserType st_u = (UserType) it_ut.next();
                if (permissions == st_u.getIduserType()) {
                    user_permission = st_u.getIduserType();
                    break;
                }
            }
            UserType users_o = (UserType) session.get(UserType.class, user_permission);
            user.setUserType(users_o);

            Query query = session.createQuery("from Users");
            List usersList = query.list();
            Integer users_id = null;
            Iterator it = usersList.iterator();
            for (int i = 0; it.hasNext(); i++) {
                Users st = (Users) it.next();
                if (session_id == st.getIdusers()) {
                    users_id = st.getIdusers();
                    break;
                }
            }
            Users user_o = (Users) session.get(Users.class, users_id);
            user.setUsersByUsersId(user_o);

            session.update(user);
            transaction.commit();

        } catch (Exception e) {
        }
        return "User data successfully updated";
    }

    public String deleteUser(int usersid, int session_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Users user = (Users) session.get(Users.class, usersid);
            user.setIsDeleted(1);
            session.update(user);
            transaction.commit();

        } catch (Exception e) {
        }
        return "User deleted successfully";
    }
}

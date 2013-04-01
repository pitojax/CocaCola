/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.UserType;
import model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KSC
 */
public class Sample {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        Session sess = null;
        try {
            SessionFactory fact = new Configuration()
                    .configure().buildSessionFactory();
            sess = fact.openSession();
            Transaction tr = sess.beginTransaction();
            Users user = (Users) sess.get(Users.class, 6);
            System.out.println(user.getIdusers());
            user.setUsername("pit");
            user.setPassword("1230000");
            user.setFname("pete");
            user.setLname("ojam");
            UserType users_o = (UserType) sess.get(UserType.class, 9);
            user.setUserType(users_o);

            Users user_o = (Users) sess.get(Users.class, 5);
            user.setUsersByUpdatedBy(user_o);
            
            sess.update(user);
            tr.commit();
            sess.close();
            System.out.println("Update successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

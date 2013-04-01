/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author KSC
 */
public class RegistrationService {
    public String storeDcInfo(String name, String namef, String location, int dcowner){
        //        try {
//            session = HibernateUtil.currentSession();
//            transaction = session.beginTransaction();
//            dcinfo.setName(name);
//            
//            Query query = session.createQuery("from DcOwner");
//            List dco = query.list();
//            Integer dc_owner = null;
//            Iterator it = dco.iterator();
//            for (int i = 0; it.hasNext(); i++) {
//                DcOwner st = (DcOwner) it.next();
//                if (dcowner == st.getIddcOwner()) {
//                    dc_owner = (st.getIddcOwner());
//                }
//            }
//            DcOwner dc_o = (DcOwner) session.get(DcOwner.class, dc_owner);
//            dcinfo.setDcOwner(dc_o);
//            
//            Query queryu = session.createQuery("from Users");
//            List users = queryu.list();
//            Integer users_ = null;
//            Iterator it_u = users.iterator();
//            for (int i = 0; it_u.hasNext(); i++) {
//                Users st_u = (Users) it_u.next();
//                if (dcowner == st_u.getIdusers()) {
//                    users_ = (st_u.getIdusers());
//                }
//            }
//            Users users_o = (Users) session.get(Users.class, users_);
//            dcinfo.setUsers(users_o);
//            
//            
//            dcinfo.setTelephone(telephone);
//            dcinfo.setEmail(email);
//            dcinfo.setLocation(location);
//            dcinfo.setStartDateOfContract(start_contract);
//            dcinfo.setExpireyDateOfContract(expire_contract);
//            
//            
//            session.save(dcinfo);
//            transaction.commit();
//                
//        } catch (Exception e) {
//            return e.getMessage();
//        }finally{
//            session.close();
//        }
//        
        return "Hello " + name + " !" + namef+" "+ location + " !" + dcowner;
    }  
    
   
}

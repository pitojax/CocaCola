package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import model.ProductType;
import model.StockControl;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibernateUtil;

/**
 *
 * @author KSC
 */
public class StockcontrolService {

    Session session;
    Transaction transaction;
    Date date = new Date();
    StockControl sc = new StockControl();

    public List<ProductType> getProductType() {
        List<ProductType> producttype = new ArrayList<ProductType>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from ProductType");
            producttype = query.list();
            transaction.commit();

        } catch (Exception e) {
        } finally {
            session.close();
        }

        return producttype;

    }

    public String storeStockControl(int product_type, int opening_stock, int cdc_delivered_stock, int total_flow_stock, int expired_stock, int prior_day_sales, int target_sales, int empties_available, int order, int session_id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Query query_pt = session.createQuery("from ProductType");
            List list = query_pt.list();
            Integer product_type_id = null;
            Iterator it_ut = list.iterator();
            for (int i = 0; it_ut.hasNext(); i++) {
                ProductType st_u = (ProductType) it_ut.next();
                if (product_type == st_u.getIdproductType()) {
                    product_type_id = st_u.getIdproductType();
                }
            }
            ProductType pt_o = (ProductType) session.get(ProductType.class, product_type_id);
            sc.setProductType(pt_o);
            sc.setOpenningStock(opening_stock);
            sc.setCdcDeliveredStock(cdc_delivered_stock);
            sc.setTotalFlowStock(total_flow_stock);
            sc.setExpiredStock(expired_stock);
            sc.setPriorDaySales(prior_day_sales);
            sc.setTargetSales(target_sales);
            sc.setEmptiesAvailable(empties_available);
            sc.setOrder(order);          

            Query query = session.createQuery("from Users");
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
            sc.setUsers(user_o);
            System.out.print(date);
            sc.setDate(date);

            session.save(sc);
            transaction.commit();

        } catch (Exception e) {
            return e.getMessage();
        }
        return "Stock control data successfully submitted";
    }
}

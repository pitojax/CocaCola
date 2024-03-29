package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * StockControl generated by hbm2java
 */
public class StockControl  implements java.io.Serializable {


     private Integer idstockControl;
     private ProductType productType;
     private Users users;
     private int openningStock;
     private int cdcDeliveredStock;
     private int totalFlowStock;
     private int expiredStock;
     private int priorDaySales;
     private int targetSales;
     private int emptiesAvailable;
     private int order;
     private Date date;

    public StockControl() {
    }

    public StockControl(ProductType productType, Users users, int openningStock, int cdcDeliveredStock, int totalFlowStock, int expiredStock, int priorDaySales, int targetSales, int emptiesAvailable, int order, Date date) {
       this.productType = productType;
       this.users = users;
       this.openningStock = openningStock;
       this.cdcDeliveredStock = cdcDeliveredStock;
       this.totalFlowStock = totalFlowStock;
       this.expiredStock = expiredStock;
       this.priorDaySales = priorDaySales;
       this.targetSales = targetSales;
       this.emptiesAvailable = emptiesAvailable;
       this.order = order;
       this.date = date;
    }
   
    public Integer getIdstockControl() {
        return this.idstockControl;
    }
    
    public void setIdstockControl(Integer idstockControl) {
        this.idstockControl = idstockControl;
    }
    public ProductType getProductType() {
        return this.productType;
    }
    
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public int getOpenningStock() {
        return this.openningStock;
    }
    
    public void setOpenningStock(int openningStock) {
        this.openningStock = openningStock;
    }
    public int getCdcDeliveredStock() {
        return this.cdcDeliveredStock;
    }
    
    public void setCdcDeliveredStock(int cdcDeliveredStock) {
        this.cdcDeliveredStock = cdcDeliveredStock;
    }
    public int getTotalFlowStock() {
        return this.totalFlowStock;
    }
    
    public void setTotalFlowStock(int totalFlowStock) {
        this.totalFlowStock = totalFlowStock;
    }
    public int getExpiredStock() {
        return this.expiredStock;
    }
    
    public void setExpiredStock(int expiredStock) {
        this.expiredStock = expiredStock;
    }
    public int getPriorDaySales() {
        return this.priorDaySales;
    }
    
    public void setPriorDaySales(int priorDaySales) {
        this.priorDaySales = priorDaySales;
    }
    public int getTargetSales() {
        return this.targetSales;
    }
    
    public void setTargetSales(int targetSales) {
        this.targetSales = targetSales;
    }
    public int getEmptiesAvailable() {
        return this.emptiesAvailable;
    }
    
    public void setEmptiesAvailable(int emptiesAvailable) {
        this.emptiesAvailable = emptiesAvailable;
    }
    public int getOrder() {
        return this.order;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}



package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Assets generated by hbm2java
 */
public class Assets  implements java.io.Serializable {


     private Integer idassets;
     private AssetType assetType;
     private Users users;
     private String serialNo;
     private String details;
     private Date date;
     private Set<MdcOutlet> mdcOutlets = new HashSet<MdcOutlet>(0);
     private Set<DeliveredItem> deliveredItems = new HashSet<DeliveredItem>(0);

    public Assets() {
    }

	
    public Assets(AssetType assetType, Users users, String serialNo, String details, Date date) {
        this.assetType = assetType;
        this.users = users;
        this.serialNo = serialNo;
        this.details = details;
        this.date = date;
    }
    public Assets(AssetType assetType, Users users, String serialNo, String details, Date date, Set<MdcOutlet> mdcOutlets, Set<DeliveredItem> deliveredItems) {
       this.assetType = assetType;
       this.users = users;
       this.serialNo = serialNo;
       this.details = details;
       this.date = date;
       this.mdcOutlets = mdcOutlets;
       this.deliveredItems = deliveredItems;
    }
   
    public Integer getIdassets() {
        return this.idassets;
    }
    
    public void setIdassets(Integer idassets) {
        this.idassets = idassets;
    }
    public AssetType getAssetType() {
        return this.assetType;
    }
    
    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getSerialNo() {
        return this.serialNo;
    }
    
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Set<MdcOutlet> getMdcOutlets() {
        return this.mdcOutlets;
    }
    
    public void setMdcOutlets(Set<MdcOutlet> mdcOutlets) {
        this.mdcOutlets = mdcOutlets;
    }
    public Set<DeliveredItem> getDeliveredItems() {
        return this.deliveredItems;
    }
    
    public void setDeliveredItems(Set<DeliveredItem> deliveredItems) {
        this.deliveredItems = deliveredItems;
    }




}



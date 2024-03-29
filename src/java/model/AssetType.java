package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AssetType generated by hbm2java
 */
public class AssetType  implements java.io.Serializable {


     private Integer idassetType;
     private Users users;
     private String name;
     private String details;
     private Date date;
     private Set<Assets> assetses = new HashSet<Assets>(0);

    public AssetType() {
    }

	
    public AssetType(Users users, String name, String details, Date date) {
        this.users = users;
        this.name = name;
        this.details = details;
        this.date = date;
    }
    public AssetType(Users users, String name, String details, Date date, Set<Assets> assetses) {
       this.users = users;
       this.name = name;
       this.details = details;
       this.date = date;
       this.assetses = assetses;
    }
   
    public Integer getIdassetType() {
        return this.idassetType;
    }
    
    public void setIdassetType(Integer idassetType) {
        this.idassetType = idassetType;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public Set<Assets> getAssetses() {
        return this.assetses;
    }
    
    public void setAssetses(Set<Assets> assetses) {
        this.assetses = assetses;
    }




}



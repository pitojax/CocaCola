package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * GlassHolding generated by hbm2java
 */
public class GlassHolding  implements java.io.Serializable {


     private Integer idglassHolding;
     private Users users;
     private String type;
     private String details;
     private Date date;
     private Set<MdcOutlet> mdcOutlets = new HashSet<MdcOutlet>(0);

    public GlassHolding() {
    }

	
    public GlassHolding(Users users, String type, String details, Date date) {
        this.users = users;
        this.type = type;
        this.details = details;
        this.date = date;
    }
    public GlassHolding(Users users, String type, String details, Date date, Set<MdcOutlet> mdcOutlets) {
       this.users = users;
       this.type = type;
       this.details = details;
       this.date = date;
       this.mdcOutlets = mdcOutlets;
    }
   
    public Integer getIdglassHolding() {
        return this.idglassHolding;
    }
    
    public void setIdglassHolding(Integer idglassHolding) {
        this.idglassHolding = idglassHolding;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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




}


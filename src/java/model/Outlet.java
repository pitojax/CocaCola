package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Outlet generated by hbm2java
 */
public class Outlet  implements java.io.Serializable {


     private Integer idoutlet;
     private Routes routes;
     private DcInfo dcInfo;
     private Users users;
     private String name;
     private String location;
     private String details;
     private Date date;
     private Set<Delivery> deliveries = new HashSet<Delivery>(0);
     private Set<MdcOutlet> mdcOutlets = new HashSet<MdcOutlet>(0);

    public Outlet() {
    }

	
    public Outlet(Routes routes, DcInfo dcInfo, Users users, String name, String location, String details, Date date) {
        this.routes = routes;
        this.dcInfo = dcInfo;
        this.users = users;
        this.name = name;
        this.location = location;
        this.details = details;
        this.date = date;
    }
    public Outlet(Routes routes, DcInfo dcInfo, Users users, String name, String location, String details, Date date, Set<Delivery> deliveries, Set<MdcOutlet> mdcOutlets) {
       this.routes = routes;
       this.dcInfo = dcInfo;
       this.users = users;
       this.name = name;
       this.location = location;
       this.details = details;
       this.date = date;
       this.deliveries = deliveries;
       this.mdcOutlets = mdcOutlets;
    }
   
    public Integer getIdoutlet() {
        return this.idoutlet;
    }
    
    public void setIdoutlet(Integer idoutlet) {
        this.idoutlet = idoutlet;
    }
    public Routes getRoutes() {
        return this.routes;
    }
    
    public void setRoutes(Routes routes) {
        this.routes = routes;
    }
    public DcInfo getDcInfo() {
        return this.dcInfo;
    }
    
    public void setDcInfo(DcInfo dcInfo) {
        this.dcInfo = dcInfo;
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
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
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
    public Set<Delivery> getDeliveries() {
        return this.deliveries;
    }
    
    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
    public Set<MdcOutlet> getMdcOutlets() {
        return this.mdcOutlets;
    }
    
    public void setMdcOutlets(Set<MdcOutlet> mdcOutlets) {
        this.mdcOutlets = mdcOutlets;
    }




}


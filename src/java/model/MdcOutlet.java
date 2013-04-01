package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * MdcOutlet generated by hbm2java
 */
public class MdcOutlet  implements java.io.Serializable {


     private Integer idmdcOutlet;
     private Outlet outlet;
     private Routes routes;
     private Channel channel;
     private GlassHolding glassHolding;
     private RedClass redClass;
     private Assets assets;
     private Users users;
     private String serialNo;
     private String remarks;
     private Date date;

    public MdcOutlet() {
    }

	
    public MdcOutlet(Outlet outlet, Routes routes, Channel channel, GlassHolding glassHolding, RedClass redClass, Assets assets, Users users, String serialNo, Date date) {
        this.outlet = outlet;
        this.routes = routes;
        this.channel = channel;
        this.glassHolding = glassHolding;
        this.redClass = redClass;
        this.assets = assets;
        this.users = users;
        this.serialNo = serialNo;
        this.date = date;
    }
    public MdcOutlet(Outlet outlet, Routes routes, Channel channel, GlassHolding glassHolding, RedClass redClass, Assets assets, Users users, String serialNo, String remarks, Date date) {
       this.outlet = outlet;
       this.routes = routes;
       this.channel = channel;
       this.glassHolding = glassHolding;
       this.redClass = redClass;
       this.assets = assets;
       this.users = users;
       this.serialNo = serialNo;
       this.remarks = remarks;
       this.date = date;
    }
   
    public Integer getIdmdcOutlet() {
        return this.idmdcOutlet;
    }
    
    public void setIdmdcOutlet(Integer idmdcOutlet) {
        this.idmdcOutlet = idmdcOutlet;
    }
    public Outlet getOutlet() {
        return this.outlet;
    }
    
    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }
    public Routes getRoutes() {
        return this.routes;
    }
    
    public void setRoutes(Routes routes) {
        this.routes = routes;
    }
    public Channel getChannel() {
        return this.channel;
    }
    
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    public GlassHolding getGlassHolding() {
        return this.glassHolding;
    }
    
    public void setGlassHolding(GlassHolding glassHolding) {
        this.glassHolding = glassHolding;
    }
    public RedClass getRedClass() {
        return this.redClass;
    }
    
    public void setRedClass(RedClass redClass) {
        this.redClass = redClass;
    }
    public Assets getAssets() {
        return this.assets;
    }
    
    public void setAssets(Assets assets) {
        this.assets = assets;
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
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}


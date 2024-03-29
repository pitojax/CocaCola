package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DcInfo generated by hbm2java
 */
public class DcInfo  implements java.io.Serializable {


     private Integer iddcInfo;
     private DcOwner dcOwner;
     private Users users;
     private String name;
     private int telephone;
     private String location;
     private byte[] photo;
     private String email;
     private Date startDateOfContract;
     private Date expireyDateOfContract;
     private Date date;
     private Set<Outlet> outlets = new HashSet<Outlet>(0);

    public DcInfo() {
    }

	
    public DcInfo(DcOwner dcOwner, Users users, String name, int telephone, String location, String email, Date startDateOfContract, Date expireyDateOfContract, Date date) {
        this.dcOwner = dcOwner;
        this.users = users;
        this.name = name;
        this.telephone = telephone;
        this.location = location;
        this.email = email;
        this.startDateOfContract = startDateOfContract;
        this.expireyDateOfContract = expireyDateOfContract;
        this.date = date;
    }
    public DcInfo(DcOwner dcOwner, Users users, String name, int telephone, String location, byte[] photo, String email, Date startDateOfContract, Date expireyDateOfContract, Date date, Set<Outlet> outlets) {
       this.dcOwner = dcOwner;
       this.users = users;
       this.name = name;
       this.telephone = telephone;
       this.location = location;
       this.photo = photo;
       this.email = email;
       this.startDateOfContract = startDateOfContract;
       this.expireyDateOfContract = expireyDateOfContract;
       this.date = date;
       this.outlets = outlets;
    }
   
    public Integer getIddcInfo() {
        return this.iddcInfo;
    }
    
    public void setIddcInfo(Integer iddcInfo) {
        this.iddcInfo = iddcInfo;
    }
    public DcOwner getDcOwner() {
        return this.dcOwner;
    }
    
    public void setDcOwner(DcOwner dcOwner) {
        this.dcOwner = dcOwner;
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
    public int getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public byte[] getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getStartDateOfContract() {
        return this.startDateOfContract;
    }
    
    public void setStartDateOfContract(Date startDateOfContract) {
        this.startDateOfContract = startDateOfContract;
    }
    public Date getExpireyDateOfContract() {
        return this.expireyDateOfContract;
    }
    
    public void setExpireyDateOfContract(Date expireyDateOfContract) {
        this.expireyDateOfContract = expireyDateOfContract;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Set<Outlet> getOutlets() {
        return this.outlets;
    }
    
    public void setOutlets(Set<Outlet> outlets) {
        this.outlets = outlets;
    }




}



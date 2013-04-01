package model;
// Generated Mar 29, 2013 3:29:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer idusers;
     private UserType userType;
     private Users usersByUsersId;
     private Users usersByUpdatedBy;
     private String username;
     private String password;
     private String fname;
     private String lname;
     private Date date;
     private int isDeleted;
     private Date lastUpdated;
     private Set<Users> usersesForUpdatedBy = new HashSet<Users>(0);
     private Set<Users> usersesForUsersId = new HashSet<Users>(0);
     private Set<StockControl> stockControls = new HashSet<StockControl>(0);
     private Set<Channel> channels = new HashSet<Channel>(0);
     private Set<DeliveredItem> deliveredItems = new HashSet<DeliveredItem>(0);
     private Set<RedCardScore> redCardScores = new HashSet<RedCardScore>(0);
     private Set<Assets> assetses = new HashSet<Assets>(0);
     private Set<UserType> userTypes = new HashSet<UserType>(0);
     private Set<AssetType> assetTypes = new HashSet<AssetType>(0);
     private Set<MdcOutlet> mdcOutlets = new HashSet<MdcOutlet>(0);
     private Set<Outlet> outlets = new HashSet<Outlet>(0);
     private Set<DcInfo> dcInfos = new HashSet<DcInfo>(0);
     private Set<Tracks> trackses = new HashSet<Tracks>(0);
     private Set<Delivery> deliveries = new HashSet<Delivery>(0);
     private Set<ProductPackage> productPackages = new HashSet<ProductPackage>(0);
     private Set<Routes> routeses = new HashSet<Routes>(0);
     private Set<QuantityTypes> quantityTypeses = new HashSet<QuantityTypes>(0);
     private Set<ProductType> productTypes = new HashSet<ProductType>(0);
     private Set<RedClass> redClasses = new HashSet<RedClass>(0);
     private Set<ProductSize> productSizes = new HashSet<ProductSize>(0);
     private Set<GlassHolding> glassHoldings = new HashSet<GlassHolding>(0);
     private Set<DcOwner> dcOwners = new HashSet<DcOwner>(0);

    public Users() {
    }

	
    public Users(UserType userType, Users usersByUsersId, String username, String password, String fname, String lname, Date date, int isDeleted, Date lastUpdated) {
        this.userType = userType;
        this.usersByUsersId = usersByUsersId;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.date = date;
        this.isDeleted = isDeleted;
        this.lastUpdated = lastUpdated;
    }
    public Users(UserType userType, Users usersByUsersId, Users usersByUpdatedBy, String username, String password, String fname, String lname, Date date, int isDeleted, Date lastUpdated, Set<Users> usersesForUpdatedBy, Set<Users> usersesForUsersId, Set<StockControl> stockControls, Set<Channel> channels, Set<DeliveredItem> deliveredItems, Set<RedCardScore> redCardScores, Set<Assets> assetses, Set<UserType> userTypes, Set<AssetType> assetTypes, Set<MdcOutlet> mdcOutlets, Set<Outlet> outlets, Set<DcInfo> dcInfos, Set<Tracks> trackses, Set<Delivery> deliveries, Set<ProductPackage> productPackages, Set<Routes> routeses, Set<QuantityTypes> quantityTypeses, Set<ProductType> productTypes, Set<RedClass> redClasses, Set<ProductSize> productSizes, Set<GlassHolding> glassHoldings, Set<DcOwner> dcOwners) {
       this.userType = userType;
       this.usersByUsersId = usersByUsersId;
       this.usersByUpdatedBy = usersByUpdatedBy;
       this.username = username;
       this.password = password;
       this.fname = fname;
       this.lname = lname;
       this.date = date;
       this.isDeleted = isDeleted;
       this.lastUpdated = lastUpdated;
       this.usersesForUpdatedBy = usersesForUpdatedBy;
       this.usersesForUsersId = usersesForUsersId;
       this.stockControls = stockControls;
       this.channels = channels;
       this.deliveredItems = deliveredItems;
       this.redCardScores = redCardScores;
       this.assetses = assetses;
       this.userTypes = userTypes;
       this.assetTypes = assetTypes;
       this.mdcOutlets = mdcOutlets;
       this.outlets = outlets;
       this.dcInfos = dcInfos;
       this.trackses = trackses;
       this.deliveries = deliveries;
       this.productPackages = productPackages;
       this.routeses = routeses;
       this.quantityTypeses = quantityTypeses;
       this.productTypes = productTypes;
       this.redClasses = redClasses;
       this.productSizes = productSizes;
       this.glassHoldings = glassHoldings;
       this.dcOwners = dcOwners;
    }
   
    public Integer getIdusers() {
        return this.idusers;
    }
    
    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }
    public UserType getUserType() {
        return this.userType;
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    public Users getUsersByUsersId() {
        return this.usersByUsersId;
    }
    
    public void setUsersByUsersId(Users usersByUsersId) {
        this.usersByUsersId = usersByUsersId;
    }
    public Users getUsersByUpdatedBy() {
        return this.usersByUpdatedBy;
    }
    
    public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
        this.usersByUpdatedBy = usersByUpdatedBy;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public int getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public Set<Users> getUsersesForUpdatedBy() {
        return this.usersesForUpdatedBy;
    }
    
    public void setUsersesForUpdatedBy(Set<Users> usersesForUpdatedBy) {
        this.usersesForUpdatedBy = usersesForUpdatedBy;
    }
    public Set<Users> getUsersesForUsersId() {
        return this.usersesForUsersId;
    }
    
    public void setUsersesForUsersId(Set<Users> usersesForUsersId) {
        this.usersesForUsersId = usersesForUsersId;
    }
    public Set<StockControl> getStockControls() {
        return this.stockControls;
    }
    
    public void setStockControls(Set<StockControl> stockControls) {
        this.stockControls = stockControls;
    }
    public Set<Channel> getChannels() {
        return this.channels;
    }
    
    public void setChannels(Set<Channel> channels) {
        this.channels = channels;
    }
    public Set<DeliveredItem> getDeliveredItems() {
        return this.deliveredItems;
    }
    
    public void setDeliveredItems(Set<DeliveredItem> deliveredItems) {
        this.deliveredItems = deliveredItems;
    }
    public Set<RedCardScore> getRedCardScores() {
        return this.redCardScores;
    }
    
    public void setRedCardScores(Set<RedCardScore> redCardScores) {
        this.redCardScores = redCardScores;
    }
    public Set<Assets> getAssetses() {
        return this.assetses;
    }
    
    public void setAssetses(Set<Assets> assetses) {
        this.assetses = assetses;
    }
    public Set<UserType> getUserTypes() {
        return this.userTypes;
    }
    
    public void setUserTypes(Set<UserType> userTypes) {
        this.userTypes = userTypes;
    }
    public Set<AssetType> getAssetTypes() {
        return this.assetTypes;
    }
    
    public void setAssetTypes(Set<AssetType> assetTypes) {
        this.assetTypes = assetTypes;
    }
    public Set<MdcOutlet> getMdcOutlets() {
        return this.mdcOutlets;
    }
    
    public void setMdcOutlets(Set<MdcOutlet> mdcOutlets) {
        this.mdcOutlets = mdcOutlets;
    }
    public Set<Outlet> getOutlets() {
        return this.outlets;
    }
    
    public void setOutlets(Set<Outlet> outlets) {
        this.outlets = outlets;
    }
    public Set<DcInfo> getDcInfos() {
        return this.dcInfos;
    }
    
    public void setDcInfos(Set<DcInfo> dcInfos) {
        this.dcInfos = dcInfos;
    }
    public Set<Tracks> getTrackses() {
        return this.trackses;
    }
    
    public void setTrackses(Set<Tracks> trackses) {
        this.trackses = trackses;
    }
    public Set<Delivery> getDeliveries() {
        return this.deliveries;
    }
    
    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
    public Set<ProductPackage> getProductPackages() {
        return this.productPackages;
    }
    
    public void setProductPackages(Set<ProductPackage> productPackages) {
        this.productPackages = productPackages;
    }
    public Set<Routes> getRouteses() {
        return this.routeses;
    }
    
    public void setRouteses(Set<Routes> routeses) {
        this.routeses = routeses;
    }
    public Set<QuantityTypes> getQuantityTypeses() {
        return this.quantityTypeses;
    }
    
    public void setQuantityTypeses(Set<QuantityTypes> quantityTypeses) {
        this.quantityTypeses = quantityTypeses;
    }
    public Set<ProductType> getProductTypes() {
        return this.productTypes;
    }
    
    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }
    public Set<RedClass> getRedClasses() {
        return this.redClasses;
    }
    
    public void setRedClasses(Set<RedClass> redClasses) {
        this.redClasses = redClasses;
    }
    public Set<ProductSize> getProductSizes() {
        return this.productSizes;
    }
    
    public void setProductSizes(Set<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }
    public Set<GlassHolding> getGlassHoldings() {
        return this.glassHoldings;
    }
    
    public void setGlassHoldings(Set<GlassHolding> glassHoldings) {
        this.glassHoldings = glassHoldings;
    }
    public Set<DcOwner> getDcOwners() {
        return this.dcOwners;
    }
    
    public void setDcOwners(Set<DcOwner> dcOwners) {
        this.dcOwners = dcOwners;
    }




}



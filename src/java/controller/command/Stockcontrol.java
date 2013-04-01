/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

/**
 *
 * @author KSC
 */
public class Stockcontrol {

    int product_type;
    int opening_stock;
    int cdc_delivered_stock;
    int total_flow_stock;
    int expired_stock;
    int prior_day_sales;
    int target_sales;
    int empties_available;
    int order;

    public int getCdc_delivered_stock() {
        return cdc_delivered_stock;
    }

    public void setCdc_delivered_stock(int cdc_delivered_stock) {
        this.cdc_delivered_stock = cdc_delivered_stock;
    }

    public int getEmpties_available() {
        return empties_available;
    }

    public void setEmpties_available(int empties_available) {
        this.empties_available = empties_available;
    }

    public int getExpired_stock() {
        return expired_stock;
    }

    public void setExpired_stock(int expired_stock) {
        this.expired_stock = expired_stock;
    }

    public int getOpening_stock() {
        return opening_stock;
    }

    public void setOpening_stock(int openning_stock) {
        this.opening_stock = openning_stock;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPrior_day_sales() {
        return prior_day_sales;
    }

    public void setPrior_day_sales(int prior_day_sales) {
        this.prior_day_sales = prior_day_sales;
    }

    public int getProduct_type() {
        return product_type;
    }

    public void setProduct_type(int product_type) {
        this.product_type = product_type;
    }

    public int getTarget_sales() {
        return target_sales;
    }

    public void setTarget_sales(int target_sales) {
        this.target_sales = target_sales;
    }

    public int getTotal_flow_stock() {
        return total_flow_stock;
    }

    public void setTotal_flow_stock(int total_flow_stock) {
        this.total_flow_stock = total_flow_stock;
    }

    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

/**
 *
 * @author KSC
 */
public class Redclassscore {

    int quantity_type;
    int score;
    String details;
    int product_type;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getProduct_type() {
        return product_type;
    }

    public void setProduct_type(int product_type) {
        this.product_type = product_type;
    }

    public int getQuantity_type() {
        return quantity_type;
    }

    public void setQuantity_type(int quantity_type) {
        this.quantity_type = quantity_type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

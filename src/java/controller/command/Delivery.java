/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

/**
 *
 * @author KSC
 */
public class Delivery {

    int track_id;
    int outlet_id;
    String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(int outlet_id) {
        this.outlet_id = outlet_id;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }
}

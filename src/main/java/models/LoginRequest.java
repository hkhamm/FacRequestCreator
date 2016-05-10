package models;

import java.util.ArrayList;

public class LoginRequest {

    private ArrayList<FacilitatorId> facilitatorIds;
    private String picture;

    public LoginRequest() {}

    public LoginRequest(ArrayList<FacilitatorId> facilitatorIds, String picture) {
        this.facilitatorIds = facilitatorIds;
        this.picture = picture;
    }

    public ArrayList<FacilitatorId> getFacilitatorIds() {
        return facilitatorIds;
    }

    public void setFacilitatorIds(ArrayList<FacilitatorId> facilitatorIds) {
        this.facilitatorIds = facilitatorIds;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

package models;

import java.util.ArrayList;

public class RegisterResponse {

    private ArrayList<FacilitatorId> facilitatorIds;
    private ArrayList<PictureError> errors;
    private Boolean success;

    public RegisterResponse() {}

    public RegisterResponse(Boolean success) {
        this.success = success;
    }

    public ArrayList<FacilitatorId> getFacilitatorIds() {
        return facilitatorIds;
    }

    public void setFacilitatorIds(ArrayList<FacilitatorId> facilitatorIds) {
        this.facilitatorIds = facilitatorIds;
    }

    public ArrayList<PictureError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<PictureError> errors) {
        this.errors = errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

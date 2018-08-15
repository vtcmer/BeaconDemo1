package com.vtcmer.beacon.appbeacondemoi.model;

/**
 * Created by vtcmer on 11/03/18.
 */

public class AppIBeaconDetail extends AppIBeacon{

    private String name;
    private String description;
    private String detail;
    private String imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}

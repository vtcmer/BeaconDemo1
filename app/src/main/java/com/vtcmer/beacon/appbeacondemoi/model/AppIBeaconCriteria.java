package com.vtcmer.beacon.appbeacondemoi.model;

/**
 * Created by vtcmer on 25/03/18.
 */

public class AppIBeaconCriteria {

    /**
     * Identificador de beacon
     */
    private String uuid;
    /**
     * Major del beacon
     */
    private Integer major;
    /**
     * Minor Beacon
     */
    private Integer minor;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }
}

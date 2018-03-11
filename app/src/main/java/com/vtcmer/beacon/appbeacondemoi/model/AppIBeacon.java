package com.vtcmer.beacon.appbeacondemoi.model;

/**
 * Created by vtcmer on 8/03/18.
 */

public class AppIBeacon {

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
    /**
     * Distancia Beacon
     */
    private double distance;

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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ApplicationIBeacon{" +
                "uuid='" + uuid + '\'' +
                ", major=" + major +
                ", minor=" + minor +
                '}';
    }
}

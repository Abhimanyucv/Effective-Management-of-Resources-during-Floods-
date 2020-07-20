package com.aumento.floodrescuresystem.ModelClass;

public class VehicleCampListModelClass {

    String camp_id;
    String camp_name;
    String latitude;
    String longitude;

    public VehicleCampListModelClass(String camp_id, String camp_name, String latitude, String longitude) {
        this.camp_id = camp_id;
        this.camp_name = camp_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCamp_id() {
        return camp_id;
    }

    public String getCamp_name() {
        return camp_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}

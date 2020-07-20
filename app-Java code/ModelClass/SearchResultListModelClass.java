package com.aumento.floodrescuresystem.ModelClass;

public class SearchResultListModelClass {

    String id;
    String name;
    String camp;
    String location;
    String date;

    public SearchResultListModelClass(String id, String name, String camp, String location, String date) {
        this.id = id;
        this.name = name;
        this.camp = camp;
        this.location = location;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCamp() {
        return camp;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}

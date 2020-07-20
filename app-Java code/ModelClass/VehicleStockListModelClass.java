package com.aumento.floodrescuresystem.ModelClass;

public class VehicleStockListModelClass {

    String item_name;
    String item_qty;

    public VehicleStockListModelClass(String item_name, String item_qty) {
        this.item_name = item_name;
        this.item_qty = item_qty;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_qty() {
        return item_qty;
    }
}

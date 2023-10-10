package com.royalenfield.evcansim;

public class Parameters {
    String key;
    String value;
    Double val;
    String canid;

    public Parameters(String key, String value, String canid) {
        this.key = key;
        this.value = value;
        this.canid = canid;
    }
    public Parameters(String key, Double val, String canid) {
        this.key = key;
        this.value = String.valueOf(val);
        this.canid = canid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCanid() {
        return canid;
    }

    public void setCanid(String canid) {
        this.canid = canid;
    }
}

package com.fl.saas.base.cache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdCacheBean {
    private long id;
    private String key;
    private double price;
    private long time;
    private String value;

    public AdCacheBean() {
    }

    public AdCacheBean(String str, long j, double d, String str2) {
        this.key = str;
        this.time = j;
        this.price = d;
        this.value = str2;
    }

    public long getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public double getPrice() {
        return this.price;
    }

    public long getTime() {
        return this.time;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "User{id=" + this.id + ", key='" + this.key + "', time=" + this.time + ", value='" + this.value + "'}";
    }
}

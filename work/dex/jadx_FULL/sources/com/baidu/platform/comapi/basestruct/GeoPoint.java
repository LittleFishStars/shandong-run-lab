package com.baidu.platform.comapi.basestruct;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f26782a;
    private double b;

    public GeoPoint(int i, int i2) {
        this.f26782a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        return Math.abs(this.f26782a - geoPoint.f26782a) <= 1.0E-6d && Math.abs(this.b - geoPoint.b) <= 1.0E-6d;
    }

    public double getLatitude() {
        return this.f26782a;
    }

    public double getLatitudeE6() {
        return this.f26782a;
    }

    public double getLongitude() {
        return this.b;
    }

    public double getLongitudeE6() {
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitude(double d) {
        this.f26782a = d;
    }

    public void setLatitudeE6(double d) {
        this.f26782a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f26782a + ", Longitude: " + this.b;
    }

    public void setLatitude(int i) {
        this.f26782a = i;
    }

    public void setLongitude(int i) {
        this.b = i;
    }

    public GeoPoint(double d, double d2) {
        this.f26782a = d;
        this.b = d2;
    }
}

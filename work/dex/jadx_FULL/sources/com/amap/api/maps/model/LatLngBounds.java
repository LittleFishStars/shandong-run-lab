package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        private boolean a(double d) {
            double d2 = this.mWest;
            double d3 = this.mEast;
            if (d2 <= d3) {
                return d2 <= d && d <= d3;
            }
            return d2 <= d || d <= d3;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d = this.mWest;
            double d2 = this.mEast;
            if (d > d2) {
                this.mWest = d2;
                this.mEast = d;
            }
            double d3 = this.mSouth;
            double d4 = this.mNorth;
            if (d3 > d4) {
                this.mSouth = d4;
                this.mNorth = d3;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d = latLng.longitude;
            if (!Double.isNaN(this.mWest)) {
                if (!a(d)) {
                    if (LatLngBounds.c(this.mWest, d) < LatLngBounds.d(this.mEast, d)) {
                        this.mWest = d;
                    }
                }
                return this;
            }
            this.mWest = d;
            this.mEast = d;
            return this;
        }
    }

    public LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        boolean z;
        try {
            if (latLng == null) {
                throw new RuntimeRemoteException("null southwest");
            }
            if (latLng2 == null) {
                throw new RuntimeRemoteException("null northeast");
            }
            if (latLng2.latitude >= latLng.latitude) {
                z = true;
                this.mVersionCode = z ? i : 0;
                this.southwest = z ? latLng : null;
                this.northeast = z ? latLng2 : null;
                return;
            }
            throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
        } catch (Throwable th) {
            Log.e(CLASSNAME, "the structure parameters are illegal!");
            th.printStackTrace();
            z = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLng.latitude) && b(latLng.longitude);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final int hashCode() {
        return zwa.k(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d;
        if (latLng == null) {
            return this;
        }
        if (this.northeast == null || (latLng2 = this.southwest) == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
        double dMin = Math.min(latLng2.latitude, latLng.latitude);
        double dMax = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (b(d4)) {
            d = d2;
        } else if (c(d3, d4) < d(d2, d4)) {
            d3 = d4;
            d = d2;
        } else {
            d = d4;
        }
        try {
            return new LatLngBounds(new LatLng(dMin, d3, false), new LatLng(dMax, d, false));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast != null && this.southwest != null) {
            return a(latLngBounds) || latLngBounds.a(this);
        }
        Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
        return false;
    }

    public final String toString() {
        return zwa.A(zwa.z("southwest", this.southwest), zwa.z("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.a(this, parcel, i);
    }

    private boolean b(double d) {
        double d2 = this.southwest.longitude;
        double d3 = this.northeast.longitude;
        if (d2 <= d3) {
            return d2 <= d && d <= d3;
        }
        return d2 <= d || d <= d3;
    }

    public final int a() {
        return this.mVersionCode;
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d = latLng.longitude;
        double d2 = latLng2.longitude;
        LatLng latLng3 = this.northeast;
        double d3 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d4 = latLng4.longitude;
        double d5 = ((d + d2) - d3) - d4;
        double d6 = ((d3 - d4) + d) - d2;
        double d7 = latLng.latitude;
        double d8 = latLng2.latitude;
        double d9 = latLng3.latitude;
        double d10 = latLng4.latitude;
        return Math.abs(d5) < d6 && Math.abs(((d7 + d8) - d9) - d10) < ((d9 - d10) + d7) - d8;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    private boolean a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}

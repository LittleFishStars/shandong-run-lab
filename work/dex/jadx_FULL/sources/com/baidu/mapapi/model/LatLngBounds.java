package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f26500a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static class a implements Parcelable.Creator<LatLngBounds> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLngBounds createFromParcel(Parcel parcel) {
            return new LatLngBounds(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLngBounds[] newArray(int i) {
            return new LatLngBounds[i];
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        LatLng latLng2 = this.southwest;
        double d = latLng2.latitude;
        LatLng latLng3 = this.northeast;
        double d2 = latLng3.latitude;
        double d3 = latLng2.longitude;
        double d4 = latLng3.longitude;
        double d5 = latLng.latitude;
        double d6 = latLng.longitude;
        return d5 >= d && d5 <= d2 && d6 >= d3 && d6 <= d4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        LatLng latLng = this.f26500a;
        if (latLng != null) {
            return latLng;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.northeast);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.southwest);
        LatLng latLngMc2ll = CoordUtil.mc2ll(new GeoPoint(((geoPointLl2mc.getLatitudeE6() - geoPointLl2mc2.getLatitudeE6()) / 2.0d) + geoPointLl2mc2.getLatitudeE6(), ((geoPointLl2mc.getLongitudeE6() - geoPointLl2mc2.getLongitudeE6()) / 2.0d) + geoPointLl2mc2.getLongitudeE6()));
        this.f26500a = latLngMc2ll;
        return latLngMc2ll;
    }

    public void setCenter(LatLng latLng) {
        this.f26500a = latLng;
    }

    public String toString() {
        return "southwest: " + this.southwest.latitude + ", " + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + ", " + this.northeast.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.northeast, i);
        parcel.writeParcelable(this.southwest, i);
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f26501a;
        private double b;
        private double c;
        private double d;
        private double e;
        private double f;
        private boolean g = true;

        private void a() {
            if (Math.abs(this.d) + Math.abs(this.f) > 180.0d) {
                c();
            } else {
                c();
                b();
            }
        }

        private void b() {
            double d = this.d;
            if (d > 180.0d) {
                double d2 = d - 360.0d;
                this.d = d2;
                double d3 = this.c;
                if (d2 < d3) {
                    this.d = d3;
                    this.c = d2;
                }
            }
        }

        private void c() {
            double d = this.f + 360.0d;
            this.c = d;
            double d2 = this.d;
            if (d > d2) {
                this.d = d;
                this.c = d2;
            }
        }

        public LatLngBounds build() {
            double d = this.e;
            if (d != AudioStats.AUDIO_AMPLITUDE_NONE || this.f != AudioStats.AUDIO_AMPLITUDE_NONE) {
                double d2 = this.d;
                if (d2 == AudioStats.AUDIO_AMPLITUDE_NONE && this.c == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    this.d = d;
                    this.c = this.f;
                } else if (Math.abs(d2) > 90.0d && Math.abs(this.f) > 90.0d) {
                    c();
                } else if (Math.abs(this.d) >= 90.0d || Math.abs(this.f) >= 90.0d) {
                    a();
                } else {
                    c();
                    b();
                }
            }
            return new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.f26501a, this.c));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            if (this.g) {
                this.g = false;
                double d = latLng.longitude;
                if (d >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                    this.c = d;
                    this.d = d;
                } else {
                    this.f = d;
                    this.e = d;
                }
                double d2 = latLng.latitude;
                this.f26501a = d2;
                this.b = d2;
            }
            a(latLng);
            return this;
        }

        private void a(LatLng latLng) {
            if (latLng == null) {
                return;
            }
            double d = latLng.latitude;
            double d2 = latLng.longitude;
            if (d < this.f26501a) {
                this.f26501a = d;
            }
            if (d > this.b) {
                this.b = d;
            }
            if (d2 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (d2 < this.f) {
                    this.f = d2;
                }
                if (d2 > this.e) {
                    this.e = d2;
                    return;
                }
                return;
            }
            if (d2 < this.c) {
                this.c = d2;
            }
            if (d2 > this.d) {
                this.d = d2;
                if (this.c == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    this.c = d2;
                }
            }
            if (d2 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.e = d2;
            }
        }

        public Builder include(List<LatLng> list) {
            if (list != null && list.size() != 0) {
                if (list.get(0) != null && this.g) {
                    this.g = false;
                    if (list.get(0).longitude >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        double d = list.get(0).longitude;
                        this.c = d;
                        this.d = d;
                    } else {
                        double d2 = list.get(0).longitude;
                        this.f = d2;
                        this.e = d2;
                    }
                    double d3 = list.get(0).latitude;
                    this.f26501a = d3;
                    this.b = d3;
                }
                Iterator<LatLng> it = list.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            return this;
        }
    }

    public LatLngBounds(Parcel parcel) {
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }
}

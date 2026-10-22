package huachenjie.sdk.map.lib_base;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class HCJLatLng implements Parcelable {
    public static final Parcelable.Creator<HCJLatLng> CREATOR = new Parcelable.Creator<HCJLatLng>() { // from class: huachenjie.sdk.map.lib_base.HCJLatLng.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HCJLatLng createFromParcel(Parcel parcel) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HCJLatLng[] newArray(int i) {
            return new HCJLatLng[i];
        }
    };
    public double lat;
    public double lng;

    public HCJLatLng() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public HCJLatLng(double d, double d2) {
    }

    public HCJLatLng(Parcel parcel) {
    }
}

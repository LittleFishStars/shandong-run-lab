package com.baidu.mapapi.search.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DistrictResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DistrictResult> CREATOR = new a();
    public LatLng centerPt;
    public int cityCode;
    public String cityName;
    public List<List<LatLng>> polylines;

    public static class a implements Parcelable.Creator<DistrictResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DistrictResult[] newArray(int i) {
            return new DistrictResult[i];
        }
    }

    public DistrictResult() {
        this.centerPt = null;
        this.polylines = null;
        this.cityName = null;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenterPt() {
        return this.centerPt;
    }

    public int getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public List<List<LatLng>> getPolylines() {
        return this.polylines;
    }

    public void setCenterPt(LatLng latLng) {
        this.centerPt = latLng;
    }

    public void setCityCode(int i) {
        this.cityCode = i;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setPolylines(List<List<LatLng>> list) {
        this.polylines = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.centerPt, i);
        List<List<LatLng>> list = this.polylines;
        parcel.writeInt(list == null ? 0 : list.size());
        Iterator<List<LatLng>> it = this.polylines.iterator();
        while (it.hasNext()) {
            parcel.writeTypedList(it.next());
        }
        parcel.writeInt(this.cityCode);
        parcel.writeString(this.cityName);
    }

    public DistrictResult(Parcel parcel) {
        super(parcel);
        this.centerPt = null;
        this.polylines = null;
        this.cityName = null;
        this.centerPt = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        int i = parcel.readInt();
        if (i > 0) {
            this.polylines = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                this.polylines.add(parcel.createTypedArrayList(LatLng.CREATOR));
            }
        }
        this.cityCode = parcel.readInt();
        this.cityName = parcel.readString();
    }
}

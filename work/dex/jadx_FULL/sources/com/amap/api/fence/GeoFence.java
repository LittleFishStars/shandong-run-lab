package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 0;
    public static final String BUNDLE_KEY_CUSTOMID = "customId";
    public static final String BUNDLE_KEY_FENCE = "fence";
    public static final String BUNDLE_KEY_FENCEID = "fenceid";
    public static final String BUNDLE_KEY_FENCESTATUS = "event";
    public static final String BUNDLE_KEY_LOCERRORCODE = "location_errorcode";
    public static final Parcelable.Creator<GeoFence> CREATOR = new Parcelable.Creator<GeoFence>() { // from class: com.amap.api.fence.GeoFence.1
        private static GeoFence a(Parcel parcel) {
            return new GeoFence(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeoFence[] newArray(int i) {
            return a(i);
        }

        private static GeoFence[] a(int i) {
            return new GeoFence[i];
        }
    };
    public static final int ERROR_CODE_EXISTS = 17;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int ERROR_NO_VALIDFENCE = 16;
    public static final int STATUS_IN = 1;
    public static final int STATUS_LOCFAIL = 4;
    public static final int STATUS_OUT = 2;
    public static final int STATUS_STAYED = 3;
    public static final int STATUS_UNKNOWN = 0;
    public static final int TYPE_AMAPPOI = 2;
    public static final int TYPE_DISTRICT = 3;
    public static final int TYPE_POLYGON = 1;
    public static final int TYPE_ROUND = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26075a;
    private String b;
    private String c;
    private PendingIntent d;
    private int e;
    private PoiItem f;
    private List<DistrictItem> g;
    private List<List<DPoint>> h;
    private float i;
    private long j;
    private int k;
    private float l;
    private float m;
    private DPoint n;
    private int o;
    private long p;
    private boolean q;
    private AMapLocation r;

    public GeoFence() {
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1L;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1L;
        this.q = true;
        this.r = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoFence)) {
            return false;
        }
        GeoFence geoFence = (GeoFence) obj;
        if (TextUtils.isEmpty(this.b)) {
            if (!TextUtils.isEmpty(geoFence.b)) {
                return false;
            }
        } else if (!this.b.equals(geoFence.b)) {
            return false;
        }
        DPoint dPoint = this.n;
        if (dPoint == null) {
            if (geoFence.n != null) {
                return false;
            }
        } else if (!dPoint.equals(geoFence.n)) {
            return false;
        }
        if (this.i != geoFence.i) {
            return false;
        }
        List<List<DPoint>> list = this.h;
        if (list == null) {
            return geoFence.h == null;
        }
        return list.equals(geoFence.h);
    }

    public int getActivatesAction() {
        return this.k;
    }

    public DPoint getCenter() {
        return this.n;
    }

    public AMapLocation getCurrentLocation() {
        return this.r;
    }

    public String getCustomId() {
        return this.b;
    }

    public List<DistrictItem> getDistrictItemList() {
        return this.g;
    }

    public long getEnterTime() {
        return this.p;
    }

    public long getExpiration() {
        return this.j;
    }

    public String getFenceId() {
        return this.f26075a;
    }

    public float getMaxDis2Center() {
        return this.m;
    }

    public float getMinDis2Center() {
        return this.l;
    }

    public PendingIntent getPendingIntent() {
        return this.d;
    }

    public String getPendingIntentAction() {
        return this.c;
    }

    public PoiItem getPoiItem() {
        return this.f;
    }

    public List<List<DPoint>> getPointList() {
        return this.h;
    }

    public float getRadius() {
        return this.i;
    }

    public int getStatus() {
        return this.o;
    }

    public int getType() {
        return this.e;
    }

    public int hashCode() {
        return this.b.hashCode() + this.h.hashCode() + this.n.hashCode() + ((int) (this.i * 100.0f));
    }

    public boolean isAble() {
        return this.q;
    }

    public void setAble(boolean z) {
        this.q = z;
    }

    public void setActivatesAction(int i) {
        this.k = i;
    }

    public void setCenter(DPoint dPoint) {
        this.n = dPoint;
    }

    public void setCurrentLocation(AMapLocation aMapLocation) {
        this.r = aMapLocation.m149clone();
    }

    public void setCustomId(String str) {
        this.b = str;
    }

    public void setDistrictItemList(List<DistrictItem> list) {
        this.g = list;
    }

    public void setEnterTime(long j) {
        this.p = j;
    }

    public void setExpiration(long j) {
        if (j < 0) {
            this.j = -1L;
        } else {
            this.j = j + i.b();
        }
    }

    public void setFenceId(String str) {
        this.f26075a = str;
    }

    public void setMaxDis2Center(float f) {
        this.m = f;
    }

    public void setMinDis2Center(float f) {
        this.l = f;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.d = pendingIntent;
    }

    public void setPendingIntentAction(String str) {
        this.c = str;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f = poiItem;
    }

    public void setPointList(List<List<DPoint>> list) {
        this.h = list;
    }

    public void setRadius(float f) {
        this.i = f;
    }

    public void setStatus(int i) {
        this.o = i;
    }

    public void setType(int i) {
        this.e = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26075a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeTypedList(this.g);
        parcel.writeFloat(this.i);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeFloat(this.l);
        parcel.writeFloat(this.m);
        parcel.writeParcelable(this.n, i);
        parcel.writeInt(this.o);
        parcel.writeLong(this.p);
        List<List<DPoint>> list = this.h;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.h.size());
            Iterator<List<DPoint>> it = this.h.iterator();
            while (it.hasNext()) {
                parcel.writeTypedList(it.next());
            }
        }
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.r, i);
    }

    public GeoFence(Parcel parcel) {
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.i = 0.0f;
        this.j = -1L;
        this.k = 1;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = null;
        this.o = 0;
        this.p = -1L;
        this.q = true;
        this.r = null;
        this.f26075a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (PendingIntent) parcel.readParcelable(PendingIntent.class.getClassLoader());
        this.e = parcel.readInt();
        this.f = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        this.g = parcel.createTypedArrayList(DistrictItem.CREATOR);
        this.i = parcel.readFloat();
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readFloat();
        this.m = parcel.readFloat();
        this.n = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        this.o = parcel.readInt();
        this.p = parcel.readLong();
        int i = parcel.readInt();
        if (i != 0) {
            this.h = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                this.h.add(parcel.createTypedArrayList(DPoint.CREATOR));
            }
        }
        this.q = parcel.readByte() != 0;
        this.r = (AMapLocation) parcel.readParcelable(AMapLocation.class.getClassLoader());
    }
}

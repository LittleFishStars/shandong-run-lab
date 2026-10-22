package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.y.l;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BikingRouteLine extends RouteLine<BikingStep> implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new a();

    public static class BikingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<BikingStep> CREATOR = new a();
        private int e;
        private RouteNode f;
        private RouteNode g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private int n;

        public static class a implements Parcelable.Creator<BikingStep> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BikingStep createFromParcel(Parcel parcel) {
                return new BikingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BikingStep[] newArray(int i) {
                return new BikingStep[i];
            }
        }

        public BikingStep() {
        }

        private List<LatLng> a(String str) {
            if (str != null && str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                String[] strArrSplit = str.split(l.b);
                if (strArrSplit != null && strArrSplit.length != 0) {
                    for (String str2 : strArrSplit) {
                        String[] strArrSplit2 = str2.split(",");
                        if (strArrSplit2 != null && strArrSplit2.length >= 2) {
                            LatLng latLng = new LatLng(Double.valueOf(strArrSplit2[1]).doubleValue(), Double.valueOf(strArrSplit2[0]).doubleValue());
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.baiduToGcj(latLng);
                            }
                            arrayList.add(latLng);
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.e;
        }

        public RouteNode getEntrance() {
            return this.f;
        }

        public String getEntranceInstructions() {
            return this.i;
        }

        public RouteNode getExit() {
            return this.g;
        }

        public String getExitInstructions() {
            return this.j;
        }

        public String getInstructions() {
            return this.k;
        }

        public String getRestrictionsInfo() {
            return this.m;
        }

        public int getRestrictionsStatus() {
            return this.n;
        }

        public String getTurnType() {
            return this.l;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.h);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i) {
            this.e = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.i = str;
        }

        public void setExit(RouteNode routeNode) {
            this.g = routeNode;
        }

        public void setExitInstructions(String str) {
            this.j = str;
        }

        public void setInstructions(String str) {
            this.k = str;
        }

        public void setPathString(String str) {
            this.h = str;
        }

        public void setRestrictionsInfo(String str) {
            this.m = str;
        }

        public void setRestrictionsStatus(int i) {
            this.n = i;
        }

        public void setTurnType(String str) {
            this.l = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.e);
            parcel.writeParcelable(this.f, 1);
            parcel.writeParcelable(this.g, 1);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
        }

        public BikingStep(Parcel parcel) {
            super(parcel);
            this.e = parcel.readInt();
            this.f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<BikingRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteLine createFromParcel(Parcel parcel) {
            return new BikingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteLine[] newArray(int i) {
            return new BikingRouteLine[i];
        }
    }

    public BikingRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<BikingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.BIKINGSTEP);
        super.writeToParcel(parcel, 1);
    }

    public BikingRouteLine(Parcel parcel) {
        super(parcel);
    }
}

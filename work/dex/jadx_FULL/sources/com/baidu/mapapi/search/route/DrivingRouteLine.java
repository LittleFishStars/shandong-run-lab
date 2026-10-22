package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DrivingRouteLine extends RouteLine<DrivingStep> implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new a();
    private boolean i;
    private List<RouteNode> j;
    private int k;
    private int l;
    private int m;

    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new a();
        private int e;
        private RouteNode f;
        private RouteNode g;
        private String h;
        private String i;
        private String j;
        private String k;
        private int l;
        List<LatLng> m;
        int[] n;
        private int o;
        private String p;

        public static class a implements Parcelable.Creator<DrivingStep> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DrivingStep createFromParcel(Parcel parcel) {
                return new DrivingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DrivingStep[] newArray(int i) {
                return new DrivingStep[i];
            }
        }

        public DrivingStep() {
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

        public int getNumTurns() {
            return this.l;
        }

        public int getRoadLevel() {
            return this.o;
        }

        public String getRoadName() {
            return this.p;
        }

        public int[] getTrafficList() {
            return this.n;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.h);
            }
            return this.m;
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

        public void setNumTurns(int i) {
            this.l = i;
        }

        public void setPathList(List<LatLng> list) {
            this.m = list;
        }

        public void setPathString(String str) {
            this.h = str;
        }

        public void setRoadLevel(int i) {
            this.o = i;
        }

        public void setRoadName(String str) {
            this.p = str;
        }

        public void setTrafficList(int[] iArr) {
            this.n = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.e);
            parcel.writeParcelable(this.f, 1);
            parcel.writeParcelable(this.g, 1);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeInt(this.l);
            parcel.writeTypedList(this.m);
            parcel.writeIntArray(this.n);
            parcel.writeInt(this.o);
            parcel.writeString(this.p);
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.e = parcel.readInt();
            this.f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readInt();
            this.m = parcel.createTypedArrayList(LatLng.CREATOR);
            this.n = parcel.createIntArray();
            this.o = parcel.readInt();
            this.p = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<DrivingRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrivingRouteLine createFromParcel(Parcel parcel) {
            return new DrivingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrivingRouteLine[] newArray(int i) {
            return new DrivingRouteLine[i];
        }
    }

    public DrivingRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.k;
    }

    public int getLightNum() {
        return this.l;
    }

    public int getToll() {
        return this.m;
    }

    public List<RouteNode> getWayPoints() {
        return this.j;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.i;
    }

    public void setCongestionDistance(int i) {
        this.k = i;
    }

    public void setLightNum(int i) {
        this.l = i;
    }

    public void setSupportTraffic(boolean z) {
        this.i = z;
    }

    public void setToll(int i) {
        this.m = i;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.j = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeList(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.i = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }
}

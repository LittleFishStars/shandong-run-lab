package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WalkingRouteLine extends RouteLine<WalkingStep> implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new a();

    public static class WalkingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<WalkingStep> CREATOR = new a();
        private int e;
        private RouteNode f;
        private RouteNode g;
        private String h;
        private String i;
        private String j;
        private String k;

        public static class a implements Parcelable.Creator<WalkingStep> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WalkingStep createFromParcel(Parcel parcel) {
                return new WalkingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WalkingStep[] newArray(int i) {
                return new WalkingStep[i];
            }
        }

        public WalkingStep() {
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

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.h);
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
        }

        public WalkingStep(Parcel parcel) {
            super(parcel);
            this.e = parcel.readInt();
            this.f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<WalkingRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WalkingRouteLine createFromParcel(Parcel parcel) {
            return new WalkingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WalkingRouteLine[] newArray(int i) {
            return new WalkingRouteLine[i];
        }
    }

    public WalkingRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<WalkingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.WALKSTEP);
        super.writeToParcel(parcel, 1);
    }

    public WalkingRouteLine(Parcel parcel) {
        super(parcel);
    }
}

package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<TransitRouteLine> CREATOR = new a();
    private TaxiInfo i;

    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new a();
        private VehicleInfo e;
        private RouteNode f;
        private RouteNode g;
        private TransitRouteStepType h;
        private String i;
        private String j;

        public enum TransitRouteStepType {
            BUSLINE,
            SUBWAY,
            WAKLING
        }

        public static class a implements Parcelable.Creator<TransitStep> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep createFromParcel(Parcel parcel) {
                return new TransitStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep[] newArray(int i) {
                return new TransitStep[i];
            }
        }

        public TransitStep() {
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public RouteNode getEntrance() {
            return this.f;
        }

        public RouteNode getExit() {
            return this.g;
        }

        public String getInstructions() {
            return this.i;
        }

        public TransitRouteStepType getStepType() {
            return this.h;
        }

        public VehicleInfo getVehicleInfo() {
            return this.e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.j);
            }
            return this.mWayPoints;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.g = routeNode;
        }

        public void setInstructions(String str) {
            this.i = str;
        }

        public void setPathString(String str) {
            this.j = str;
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            this.h = transitRouteStepType;
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            this.e = vehicleInfo;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.e, 1);
            parcel.writeParcelable(this.f, 1);
            parcel.writeParcelable(this.g, 1);
            TransitRouteStepType transitRouteStepType = this.h;
            parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
            parcel.writeString(this.i);
            parcel.writeString(this.j);
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            this.e = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int i = parcel.readInt();
            this.h = i == -1 ? null : TransitRouteStepType.values()[i];
            this.i = parcel.readString();
            this.j = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<TransitRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitRouteLine createFromParcel(Parcel parcel) {
            return new TransitRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitRouteLine[] newArray(int i) {
            return new TransitRouteLine[i];
        }
    }

    public TransitRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public TaxiInfo getTaxitInfo() {
        return this.i;
    }

    public void setTaxitInfo(TaxiInfo taxiInfo) {
        this.i = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.TRANSITSTEP);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.i, 1);
    }

    public TransitRouteLine(Parcel parcel) {
        super(parcel);
        this.i = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }
}

package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RouteLine<T extends RouteStep> implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RouteNode f26518a;
    private RouteNode b;
    private String c;
    private List<T> d;
    private int e;
    private int f;
    private a g;
    TYPE h;

    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);

        private int b;

        TYPE(int i) {
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.b;
        }
    }

    public RouteLine() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.d;
    }

    public int getDistance() {
        return this.e;
    }

    public int getDuration() {
        return this.f;
    }

    public a getLegLinked() {
        return this.g;
    }

    public RouteNode getStarting() {
        return this.f26518a;
    }

    public RouteNode getTerminal() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public TYPE getType() {
        return this.h;
    }

    public void setDistance(int i) {
        this.e = i;
    }

    public void setDuration(int i) {
        this.f = i;
    }

    public void setLegLinked(a aVar) {
        this.g = aVar;
    }

    public void setStarting(RouteNode routeNode) {
        this.f26518a = routeNode;
    }

    public void setSteps(List<T> list) {
        this.d = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.b = routeNode;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setType(TYPE type) {
        this.h = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TYPE type = this.h;
        if (type != null) {
            parcel.writeInt(type.a());
        } else {
            parcel.writeInt(10);
        }
        parcel.writeValue(this.f26518a);
        parcel.writeValue(this.b);
        parcel.writeString(this.c);
        if (this.h != null) {
            parcel.writeTypedList(this.d);
        }
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }

    public RouteLine(Parcel parcel) {
        int i = parcel.readInt();
        this.f26518a = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.c = parcel.readString();
        if (i == 0) {
            this.d = parcel.createTypedArrayList(DrivingRouteLine.DrivingStep.CREATOR);
        } else if (i == 1) {
            this.d = parcel.createTypedArrayList(TransitRouteLine.TransitStep.CREATOR);
        } else if (i == 2) {
            this.d = parcel.createTypedArrayList(WalkingRouteLine.WalkingStep.CREATOR);
        } else if (i == 3) {
            this.d = parcel.createTypedArrayList(BikingRouteLine.BikingStep.CREATOR);
        }
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }
}

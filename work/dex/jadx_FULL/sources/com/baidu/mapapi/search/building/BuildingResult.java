package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BuildingResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BuildingResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<BuildingInfo> f26505a;
    private int b;
    private double c;

    public static class a implements Parcelable.Creator<BuildingResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BuildingResult createFromParcel(Parcel parcel) {
            return new BuildingResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BuildingResult[] newArray(int i) {
            return new BuildingResult[i];
        }
    }

    public BuildingResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BuildingInfo> getBuildingList() {
        return this.f26505a;
    }

    public double getDistance() {
        return this.c;
    }

    public int getRelation() {
        return this.b;
    }

    public void setBuildingList(List<BuildingInfo> list) {
        this.f26505a = list;
    }

    public void setDistance(double d) {
        this.c = d;
    }

    public void setRelation(int i) {
        this.b = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BuidingResult: ");
        List<BuildingInfo> list = this.f26505a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append("null");
        } else {
            for (int i = 0; i < this.f26505a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                BuildingInfo buildingInfo = this.f26505a.get(i);
                if (buildingInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(buildingInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f26505a);
    }

    public BuildingResult(Parcel parcel) {
        this.f26505a = parcel.createTypedArrayList(BuildingInfo.CREATOR);
    }
}

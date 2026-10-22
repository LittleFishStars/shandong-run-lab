package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<IndoorRouteLine> f26558a;

    public static class a implements Parcelable.Creator<IndoorRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndoorRouteResult createFromParcel(Parcel parcel) {
            return new IndoorRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndoorRouteResult[] newArray(int i) {
            return new IndoorRouteResult[i];
        }
    }

    public IndoorRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f26558a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f26558a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f26558a);
    }

    public IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f26558a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }
}

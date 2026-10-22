package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<BikingRouteLine> f26552a;
    private SuggestAddrInfo b;
    private String c = "";

    public static class a implements Parcelable.Creator<BikingRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteResult createFromParcel(Parcel parcel) {
            return new BikingRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BikingRouteResult[] newArray(int i) {
            return new BikingRouteResult[i];
        }
    }

    public BikingRouteResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.c;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f26552a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.b;
    }

    public void setMessage(String str) {
        this.c = str;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f26552a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f26552a);
        parcel.writeParcelable(this.b, 1);
    }

    public BikingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f26552a = arrayList;
        parcel.readList(arrayList, BikingRouteLine.class.getClassLoader());
        this.b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }
}

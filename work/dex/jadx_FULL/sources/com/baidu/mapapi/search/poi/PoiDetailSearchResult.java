package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PoiDetailSearchResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiDetailSearchResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<PoiDetailInfo> f26535a;

    public static class a implements Parcelable.Creator<PoiDetailSearchResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailSearchResult createFromParcel(Parcel parcel) {
            return new PoiDetailSearchResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiDetailSearchResult[] newArray(int i) {
            return new PoiDetailSearchResult[i];
        }
    }

    public PoiDetailSearchResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiDetailInfo> getPoiDetailInfoList() {
        return this.f26535a;
    }

    public void setPoiDetailInfoList(List<PoiDetailInfo> list) {
        this.f26535a = list;
    }

    public String toString() {
        List<PoiDetailInfo> list = this.f26535a;
        if (list == null || list.isEmpty()) {
            return "PoiDetailSearchResult is null";
        }
        StringBuffer stringBuffer = new StringBuffer("PoiDetailSearchResult:");
        for (int i = 0; i < this.f26535a.size(); i++) {
            stringBuffer.append(" ");
            stringBuffer.append(i);
            stringBuffer.append(" ");
            PoiDetailInfo poiDetailInfo = this.f26535a.get(i);
            if (poiDetailInfo != null) {
                stringBuffer.append(poiDetailInfo.toString());
            } else {
                stringBuffer.append("null");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f26535a);
    }

    public PoiDetailSearchResult(SearchResult.ERRORNO errorno) {
        super(errorno);
    }

    public PoiDetailSearchResult(Parcel parcel) {
        super(parcel);
        this.f26535a = parcel.createTypedArrayList(PoiDetailInfo.CREATOR);
    }
}

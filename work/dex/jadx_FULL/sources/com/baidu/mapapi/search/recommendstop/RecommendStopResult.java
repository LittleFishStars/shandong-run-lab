package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RecommendStationStopInfo;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RecommendStopResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<RecommendStopResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RecommendStopInfo> f26548a;
    private List<RecommendStationStopInfo> b;

    public static class a implements Parcelable.Creator<RecommendStopResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopResult createFromParcel(Parcel parcel) {
            return new RecommendStopResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopResult[] newArray(int i) {
            return new RecommendStopResult[i];
        }
    }

    public RecommendStopResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.f26548a;
    }

    public List<RecommendStationStopInfo> getStationInfoList() {
        return this.b;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.f26548a = list;
    }

    public void setStationInfoList(List<RecommendStationStopInfo> list) {
        this.b = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RecommendStopResult: ");
        List<RecommendStopInfo> list = this.f26548a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append("null");
        } else {
            for (int i = 0; i < this.f26548a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                RecommendStopInfo recommendStopInfo = this.f26548a.get(i);
                if (recommendStopInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(recommendStopInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f26548a);
    }

    public RecommendStopResult(Parcel parcel) {
        super(parcel);
        this.f26548a = parcel.createTypedArrayList(RecommendStopInfo.CREATOR);
    }
}

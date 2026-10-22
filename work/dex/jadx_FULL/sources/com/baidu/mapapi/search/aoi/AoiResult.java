package com.baidu.mapapi.search.aoi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.AoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AoiResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<AoiResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<AoiInfo> f26503a;

    public static class a implements Parcelable.Creator<AoiResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiResult createFromParcel(Parcel parcel) {
            return new AoiResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiResult[] newArray(int i) {
            return new AoiResult[i];
        }
    }

    public AoiResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AoiInfo> getAoiList() {
        return this.f26503a;
    }

    public void setAoiList(List<AoiInfo> list) {
        this.f26503a = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiResult: ");
        List<AoiInfo> list = this.f26503a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append("null");
        } else {
            for (int i = 0; i < this.f26503a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                AoiInfo aoiInfo = this.f26503a.get(i);
                if (aoiInfo == null) {
                    stringBuffer.append("null");
                } else {
                    stringBuffer.append(aoiInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f26503a);
    }

    public AoiResult(Parcel parcel) {
        this.f26503a = parcel.createTypedArrayList(AoiInfo.CREATOR);
    }
}

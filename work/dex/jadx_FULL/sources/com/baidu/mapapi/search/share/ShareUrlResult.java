package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26573a;
    private int b;

    public static class a implements Parcelable.Creator<ShareUrlResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareUrlResult createFromParcel(Parcel parcel) {
            return new ShareUrlResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareUrlResult[] newArray(int i) {
            return new ShareUrlResult[i];
        }
    }

    public ShareUrlResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f26573a;
    }

    public void setType(int i) {
        this.b = i;
    }

    public void setUrl(String str) {
        this.f26573a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26573a);
        parcel.writeInt(this.b);
    }

    public ShareUrlResult(Parcel parcel) {
        this.f26573a = parcel.readString();
        this.b = parcel.readInt();
    }
}

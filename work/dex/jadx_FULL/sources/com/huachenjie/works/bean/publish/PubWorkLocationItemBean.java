package com.huachenjie.works.bean.publish;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "Landroid/os/Parcelable;", "cityName", "", "subName", "lng", "lat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "getLat", "setLat", "getLng", "setLng", "getSubName", "setSubName", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PubWorkLocationItemBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PubWorkLocationItemBean> CREATOR = new Creator();

    @NotNull
    private String cityName;

    @NotNull
    private String lat;

    @NotNull
    private String lng;

    @NotNull
    private String subName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PubWorkLocationItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PubWorkLocationItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PubWorkLocationItemBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PubWorkLocationItemBean[] newArray(int i) {
            return new PubWorkLocationItemBean[i];
        }
    }

    public PubWorkLocationItemBean() {
        this(null, null, null, null, 15, null);
    }

    public PubWorkLocationItemBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "cityName");
        Intrinsics.checkNotNullParameter(str2, "subName");
        Intrinsics.checkNotNullParameter(str3, "lng");
        Intrinsics.checkNotNullParameter(str4, "lat");
        this.cityName = str;
        this.subName = str2;
        this.lng = str3;
        this.lat = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCityName() {
        return this.cityName;
    }

    @NotNull
    public final String getLat() {
        return this.lat;
    }

    @NotNull
    public final String getLng() {
        return this.lng;
    }

    @NotNull
    public final String getSubName() {
        return this.subName;
    }

    public final void setCityName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cityName = str;
    }

    public final void setLat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }

    public final void setLng(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lng = str;
    }

    public final void setSubName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.cityName);
        parcel.writeString(this.subName);
        parcel.writeString(this.lng);
        parcel.writeString(this.lat);
    }

    public /* synthetic */ PubWorkLocationItemBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}

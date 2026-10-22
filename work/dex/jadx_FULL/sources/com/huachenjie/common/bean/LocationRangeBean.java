package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/huachenjie/common/bean/LocationRangeBean;", "Landroid/os/Parcelable;", "lng", "", "lat", "scope", "", "name", "", "(DDILjava/lang/String;)V", "getLat", "()D", "getLng", "getName", "()Ljava/lang/String;", "getScope", "()I", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LocationRangeBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<LocationRangeBean> CREATOR = new Creator();
    private final double lat;
    private final double lng;

    @NotNull
    private final String name;
    private final int scope;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LocationRangeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationRangeBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LocationRangeBean(parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationRangeBean[] newArray(int i) {
            return new LocationRangeBean[i];
        }
    }

    public LocationRangeBean() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, null, 15, null);
    }

    public LocationRangeBean(double d, double d2, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.lng = d;
        this.lat = d2;
        this.scope = i;
        this.name = str;
    }

    public static /* synthetic */ LocationRangeBean copy$default(LocationRangeBean locationRangeBean, double d, double d2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = locationRangeBean.lng;
        }
        double d3 = d;
        if ((i2 & 2) != 0) {
            d2 = locationRangeBean.lat;
        }
        double d4 = d2;
        if ((i2 & 4) != 0) {
            i = locationRangeBean.scope;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = locationRangeBean.name;
        }
        return locationRangeBean.copy(d3, d4, i3, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getLng() {
        return this.lng;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getScope() {
        return this.scope;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final LocationRangeBean copy(double lng, double lat, int scope, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new LocationRangeBean(lng, lat, scope, name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocationRangeBean)) {
            return false;
        }
        LocationRangeBean locationRangeBean = (LocationRangeBean) other;
        return Double.compare(this.lng, locationRangeBean.lng) == 0 && Double.compare(this.lat, locationRangeBean.lat) == 0 && this.scope == locationRangeBean.scope && Intrinsics.areEqual(this.name, locationRangeBean.name);
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getScope() {
        return this.scope;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.lng) * 31) + Double.hashCode(this.lat)) * 31) + Integer.hashCode(this.scope)) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "LocationRangeBean(lng=" + this.lng + ", lat=" + this.lat + ", scope=" + this.scope + ", name=" + this.name + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeDouble(this.lng);
        parcel.writeDouble(this.lat);
        parcel.writeInt(this.scope);
        parcel.writeString(this.name);
    }

    public /* synthetic */ LocationRangeBean(double d, double d2, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0d : d, (i2 & 2) == 0 ? d2 : AudioStats.AUDIO_AMPLITUDE_NONE, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str);
    }
}

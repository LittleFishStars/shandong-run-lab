package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003JO\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\bHÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006-"}, d2 = {"Lcom/huachenjie/common/bean/ClockTimeData;", "Landroid/os/Parcelable;", "clockTimeList", "", "Lcom/huachenjie/common/bean/ClockTime;", "imgFlag", "", "outsideConfigCode", "", "currentDate", "lng", "lat", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClockTimeList", "()Ljava/util/List;", "getCurrentDate", "()Ljava/lang/String;", "setCurrentDate", "(Ljava/lang/String;)V", "getImgFlag", "()Z", "getLat", "setLat", "getLng", "setLng", "getOutsideConfigCode", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ClockTimeData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ClockTimeData> CREATOR = new Creator();

    @Nullable
    private final List<ClockTime> clockTimeList;

    @Nullable
    private String currentDate;
    private final boolean imgFlag;

    @NotNull
    private String lat;

    @NotNull
    private String lng;

    @NotNull
    private final String outsideConfigCode;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClockTimeData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockTimeData createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(ClockTime.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new ClockTimeData(arrayList, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ClockTimeData[] newArray(int i) {
            return new ClockTimeData[i];
        }
    }

    public ClockTimeData(@Nullable List<ClockTime> list, boolean z, @NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "outsideConfigCode");
        Intrinsics.checkNotNullParameter(str3, "lng");
        Intrinsics.checkNotNullParameter(str4, "lat");
        this.clockTimeList = list;
        this.imgFlag = z;
        this.outsideConfigCode = str;
        this.currentDate = str2;
        this.lng = str3;
        this.lat = str4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClockTimeData copy$default(ClockTimeData clockTimeData, List list, boolean z, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = clockTimeData.clockTimeList;
        }
        if ((i & 2) != 0) {
            z = clockTimeData.imgFlag;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str = clockTimeData.outsideConfigCode;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = clockTimeData.currentDate;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = clockTimeData.lng;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = clockTimeData.lat;
        }
        return clockTimeData.copy(list, z2, str5, str6, str7, str4);
    }

    @Nullable
    public final List<ClockTime> component1() {
        return this.clockTimeList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getImgFlag() {
        return this.imgFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOutsideConfigCode() {
        return this.outsideConfigCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCurrentDate() {
        return this.currentDate;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLng() {
        return this.lng;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLat() {
        return this.lat;
    }

    @NotNull
    public final ClockTimeData copy(@Nullable List<ClockTime> clockTimeList, boolean imgFlag, @NotNull String outsideConfigCode, @Nullable String currentDate, @NotNull String lng, @NotNull String lat) {
        Intrinsics.checkNotNullParameter(outsideConfigCode, "outsideConfigCode");
        Intrinsics.checkNotNullParameter(lng, "lng");
        Intrinsics.checkNotNullParameter(lat, "lat");
        return new ClockTimeData(clockTimeList, imgFlag, outsideConfigCode, currentDate, lng, lat);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClockTimeData)) {
            return false;
        }
        ClockTimeData clockTimeData = (ClockTimeData) other;
        return Intrinsics.areEqual(this.clockTimeList, clockTimeData.clockTimeList) && this.imgFlag == clockTimeData.imgFlag && Intrinsics.areEqual(this.outsideConfigCode, clockTimeData.outsideConfigCode) && Intrinsics.areEqual(this.currentDate, clockTimeData.currentDate) && Intrinsics.areEqual(this.lng, clockTimeData.lng) && Intrinsics.areEqual(this.lat, clockTimeData.lat);
    }

    @Nullable
    public final List<ClockTime> getClockTimeList() {
        return this.clockTimeList;
    }

    @Nullable
    public final String getCurrentDate() {
        return this.currentDate;
    }

    public final boolean getImgFlag() {
        return this.imgFlag;
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
    public final String getOutsideConfigCode() {
        return this.outsideConfigCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        List<ClockTime> list = this.clockTimeList;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z = this.imgFlag;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iHashCode2 = (((iHashCode + r2) * 31) + this.outsideConfigCode.hashCode()) * 31;
        String str = this.currentDate;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.lng.hashCode()) * 31) + this.lat.hashCode();
    }

    public final void setCurrentDate(@Nullable String str) {
        this.currentDate = str;
    }

    public final void setLat(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lat = str;
    }

    public final void setLng(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lng = str;
    }

    @NotNull
    public String toString() {
        return "ClockTimeData(clockTimeList=" + this.clockTimeList + ", imgFlag=" + this.imgFlag + ", outsideConfigCode=" + this.outsideConfigCode + ", currentDate=" + this.currentDate + ", lng=" + this.lng + ", lat=" + this.lat + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<ClockTime> list = this.clockTimeList;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<ClockTime> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeInt(this.imgFlag ? 1 : 0);
        parcel.writeString(this.outsideConfigCode);
        parcel.writeString(this.currentDate);
        parcel.writeString(this.lng);
        parcel.writeString(this.lat);
    }

    public /* synthetic */ ClockTimeData(List list, boolean z, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, str, (i & 8) != 0 ? "" : str2, str3, str4);
    }
}

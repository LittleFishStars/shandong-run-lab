package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u008b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015J\u0011\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u0000H\u0096\u0002J\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0004HÆ\u0003J\t\u0010E\u001a\u00020\u000eHÆ\u0003J\u008f\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0003\u0010\u0010\u001a\u00020\u000e2\b\b\u0003\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001J\t\u0010G\u001a\u00020\fHÖ\u0001J\u0013\u0010H\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\fHÖ\u0001J\t\u0010K\u001a\u00020\tHÖ\u0001J\u0019\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\fHÖ\u0001R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b\u001f\u0010\u001eR\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104¨\u0006Q"}, d2 = {"Lcom/huachenjie/common/bean/TargetPoints;", "Landroid/os/Parcelable;", "", "code", "", "lat", "", "lng", "pointName", "", "simpleName", "type", "", "passStatus", "", "clockTime", "isClosingStatus", "isInFence", "sort", "isSensitiveFenceAdded", "nfcEnable", "(JDDLjava/lang/String;Ljava/lang/String;IZJZZIZZ)V", "getClockTime", "()J", "setClockTime", "(J)V", "getCode", "setCode", "()Z", "setClosingStatus", "(Z)V", "setInFence", "setSensitiveFenceAdded", "getLat", "()D", "setLat", "(D)V", "getLng", "setLng", "getNfcEnable", "setNfcEnable", "getPassStatus", "setPassStatus", "getPointName", "()Ljava/lang/String;", "setPointName", "(Ljava/lang/String;)V", "getSimpleName", "setSimpleName", "getSort", "()I", "setSort", "(I)V", "getType", "setType", "compareTo", "other", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JSONType(includes = {"lat", "lng", "clockTime", "code", "passStatus"})
public final /* data */ class TargetPoints implements Parcelable, Comparable<TargetPoints> {

    @NotNull
    public static final Parcelable.Creator<TargetPoints> CREATOR = new Creator();
    private long clockTime;
    private long code;
    private boolean isClosingStatus;
    private boolean isInFence;
    private boolean isSensitiveFenceAdded;
    private double lat;
    private double lng;
    private boolean nfcEnable;
    private boolean passStatus;

    @Nullable
    private String pointName;

    @Nullable
    private String simpleName;
    private int sort;
    private int type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TargetPoints> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TargetPoints createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TargetPoints(parcel.readLong(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TargetPoints[] newArray(int i) {
            return new TargetPoints[i];
        }
    }

    public TargetPoints() {
        this(0L, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, 0, false, 0L, false, false, 0, false, false, 8191, null);
    }

    public TargetPoints(long j, double d, double d2, @JSONField(serialize = false) @Nullable String str, @JSONField(serialize = false) @Nullable String str2, @JSONField(serialize = false) int i, boolean z, long j2, @JSONField(serialize = false) boolean z2, @JSONField(serialize = false) boolean z3, int i2, @JSONField(serialize = false) boolean z4, boolean z5) {
        this.code = j;
        this.lat = d;
        this.lng = d2;
        this.pointName = str;
        this.simpleName = str2;
        this.type = i;
        this.passStatus = z;
        this.clockTime = j2;
        this.isClosingStatus = z2;
        this.isInFence = z3;
        this.sort = i2;
        this.isSensitiveFenceAdded = z4;
        this.nfcEnable = z5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsInFence() {
        return this.isInFence;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsSensitiveFenceAdded() {
        return this.isSensitiveFenceAdded;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getNfcEnable() {
        return this.nfcEnable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getLng() {
        return this.lng;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPointName() {
        return this.pointName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSimpleName() {
        return this.simpleName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getPassStatus() {
        return this.passStatus;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getClockTime() {
        return this.clockTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsClosingStatus() {
        return this.isClosingStatus;
    }

    @NotNull
    public final TargetPoints copy(long code, double lat, double lng, @JSONField(serialize = false) @Nullable String pointName, @JSONField(serialize = false) @Nullable String simpleName, @JSONField(serialize = false) int type, boolean passStatus, long clockTime, @JSONField(serialize = false) boolean isClosingStatus, @JSONField(serialize = false) boolean isInFence, int sort, @JSONField(serialize = false) boolean isSensitiveFenceAdded, boolean nfcEnable) {
        return new TargetPoints(code, lat, lng, pointName, simpleName, type, passStatus, clockTime, isClosingStatus, isInFence, sort, isSensitiveFenceAdded, nfcEnable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TargetPoints)) {
            return false;
        }
        TargetPoints targetPoints = (TargetPoints) other;
        return this.code == targetPoints.code && Double.compare(this.lat, targetPoints.lat) == 0 && Double.compare(this.lng, targetPoints.lng) == 0 && Intrinsics.areEqual(this.pointName, targetPoints.pointName) && Intrinsics.areEqual(this.simpleName, targetPoints.simpleName) && this.type == targetPoints.type && this.passStatus == targetPoints.passStatus && this.clockTime == targetPoints.clockTime && this.isClosingStatus == targetPoints.isClosingStatus && this.isInFence == targetPoints.isInFence && this.sort == targetPoints.sort && this.isSensitiveFenceAdded == targetPoints.isSensitiveFenceAdded && this.nfcEnable == targetPoints.nfcEnable;
    }

    public final long getClockTime() {
        return this.clockTime;
    }

    public final long getCode() {
        return this.code;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    public final boolean getNfcEnable() {
        return this.nfcEnable;
    }

    public final boolean getPassStatus() {
        return this.passStatus;
    }

    @Nullable
    public final String getPointName() {
        return this.pointName;
    }

    @Nullable
    public final String getSimpleName() {
        return this.simpleName;
    }

    public final int getSort() {
        return this.sort;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.code) * 31) + Double.hashCode(this.lat)) * 31) + Double.hashCode(this.lng)) * 31;
        String str = this.pointName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.simpleName;
        int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.type)) * 31;
        boolean z = this.passStatus;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode4 = (((iHashCode3 + r1) * 31) + Long.hashCode(this.clockTime)) * 31;
        boolean z2 = this.isClosingStatus;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.isInFence;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int iHashCode5 = (((i + r3) * 31) + Integer.hashCode(this.sort)) * 31;
        boolean z4 = this.isSensitiveFenceAdded;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i2 = (iHashCode5 + r4) * 31;
        boolean z5 = this.nfcEnable;
        return i2 + (z5 ? 1 : z5);
    }

    public final boolean isClosingStatus() {
        return this.isClosingStatus;
    }

    public final boolean isInFence() {
        return this.isInFence;
    }

    public final boolean isSensitiveFenceAdded() {
        return this.isSensitiveFenceAdded;
    }

    public final void setClockTime(long j) {
        this.clockTime = j;
    }

    public final void setClosingStatus(boolean z) {
        this.isClosingStatus = z;
    }

    public final void setCode(long j) {
        this.code = j;
    }

    public final void setInFence(boolean z) {
        this.isInFence = z;
    }

    public final void setLat(double d) {
        this.lat = d;
    }

    public final void setLng(double d) {
        this.lng = d;
    }

    public final void setNfcEnable(boolean z) {
        this.nfcEnable = z;
    }

    public final void setPassStatus(boolean z) {
        this.passStatus = z;
    }

    public final void setPointName(@Nullable String str) {
        this.pointName = str;
    }

    public final void setSensitiveFenceAdded(boolean z) {
        this.isSensitiveFenceAdded = z;
    }

    public final void setSimpleName(@Nullable String str) {
        this.simpleName = str;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "TargetPoints(code=" + this.code + ", lat=" + this.lat + ", lng=" + this.lng + ", pointName=" + this.pointName + ", simpleName=" + this.simpleName + ", type=" + this.type + ", passStatus=" + this.passStatus + ", clockTime=" + this.clockTime + ", isClosingStatus=" + this.isClosingStatus + ", isInFence=" + this.isInFence + ", sort=" + this.sort + ", isSensitiveFenceAdded=" + this.isSensitiveFenceAdded + ", nfcEnable=" + this.nfcEnable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.code);
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeString(this.pointName);
        parcel.writeString(this.simpleName);
        parcel.writeInt(this.type);
        parcel.writeInt(this.passStatus ? 1 : 0);
        parcel.writeLong(this.clockTime);
        parcel.writeInt(this.isClosingStatus ? 1 : 0);
        parcel.writeInt(this.isInFence ? 1 : 0);
        parcel.writeInt(this.sort);
        parcel.writeInt(this.isSensitiveFenceAdded ? 1 : 0);
        parcel.writeInt(this.nfcEnable ? 1 : 0);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull TargetPoints other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i = this.sort;
        int i2 = other.sort;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public /* synthetic */ TargetPoints(long j, double d, double d2, String str, String str2, int i, boolean z, long j2, boolean z2, boolean z3, int i2, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0.0d : d, (i3 & 4) == 0 ? d2 : AudioStats.AUDIO_AMPLITUDE_NONE, (i3 & 8) != 0 ? null : str, (i3 & 16) == 0 ? str2 : null, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? false : z, (i3 & 128) == 0 ? j2 : 0L, (i3 & 256) != 0 ? false : z2, (i3 & 512) != 0 ? false : z3, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? false : z4, (i3 & 4096) != 0 ? false : z5);
    }
}

package com.huachenjie.run.bean;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0002\u0010\u0014J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\t\u00106\u001a\u00020\u0011HÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\u0089\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011HÆ\u0001J\t\u0010A\u001a\u00020\u0007HÖ\u0001J\u0013\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u0007HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR\u001a\u0010\u0013\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001c¨\u0006L"}, d2 = {"Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;", "Landroid/os/Parcelable;", "faceAuth", "", "faceImg", "", "similarityValue", "", "faceTime", "bodyEnable", "bodyRate", "faceModelType", "faceCheckRecordList", "", "Lcom/huachenjie/run/bean/SunshineRunFaceRecord;", "currentFaceCheckIndex", "faceLeftTime", "", "faceUseTime", "faceUseSaveTime", "(ZLjava/lang/String;IIZIILjava/util/List;IJJJ)V", "getBodyEnable", "()Z", "setBodyEnable", "(Z)V", "getBodyRate", "()I", "setBodyRate", "(I)V", "getCurrentFaceCheckIndex", "setCurrentFaceCheckIndex", "getFaceAuth", "getFaceCheckRecordList", "()Ljava/util/List;", "getFaceImg", "()Ljava/lang/String;", "setFaceImg", "(Ljava/lang/String;)V", "getFaceLeftTime", "()J", "setFaceLeftTime", "(J)V", "getFaceModelType", "setFaceModelType", "getFaceTime", "setFaceTime", "getFaceUseSaveTime", "setFaceUseSaveTime", "getFaceUseTime", "setFaceUseTime", "getSimilarityValue", "setSimilarityValue", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SunshineRunFaceCheckData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SunshineRunFaceCheckData> CREATOR = new Creator();
    private boolean bodyEnable;
    private int bodyRate;
    private int currentFaceCheckIndex;
    private final boolean faceAuth;

    @NotNull
    private final List<SunshineRunFaceRecord> faceCheckRecordList;

    @Nullable
    private String faceImg;
    private long faceLeftTime;
    private int faceModelType;
    private int faceTime;
    private long faceUseSaveTime;
    private long faceUseTime;
    private int similarityValue;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SunshineRunFaceCheckData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunFaceCheckData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            String string = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            boolean z2 = parcel.readInt() != 0;
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            int i5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList.add(SunshineRunFaceRecord.CREATOR.createFromParcel(parcel));
            }
            return new SunshineRunFaceCheckData(z, string, i, i2, z2, i3, i4, arrayList, parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunFaceCheckData[] newArray(int i) {
            return new SunshineRunFaceCheckData[i];
        }
    }

    public SunshineRunFaceCheckData() {
        this(false, null, 0, 0, false, 0, 0, null, 0, 0L, 0L, 0L, 4095, null);
    }

    public SunshineRunFaceCheckData(boolean z, @Nullable String str, int i, int i2, boolean z2, int i3, int i4, @NotNull List<SunshineRunFaceRecord> list, int i5, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(list, "faceCheckRecordList");
        this.faceAuth = z;
        this.faceImg = str;
        this.similarityValue = i;
        this.faceTime = i2;
        this.bodyEnable = z2;
        this.bodyRate = i3;
        this.faceModelType = i4;
        this.faceCheckRecordList = list;
        this.currentFaceCheckIndex = i5;
        this.faceLeftTime = j;
        this.faceUseTime = j2;
        this.faceUseSaveTime = j3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getFaceAuth() {
        return this.faceAuth;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getFaceLeftTime() {
        return this.faceLeftTime;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getFaceUseTime() {
        return this.faceUseTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getFaceUseSaveTime() {
        return this.faceUseSaveTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFaceImg() {
        return this.faceImg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSimilarityValue() {
        return this.similarityValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFaceTime() {
        return this.faceTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getBodyEnable() {
        return this.bodyEnable;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getBodyRate() {
        return this.bodyRate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getFaceModelType() {
        return this.faceModelType;
    }

    @NotNull
    public final List<SunshineRunFaceRecord> component8() {
        return this.faceCheckRecordList;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getCurrentFaceCheckIndex() {
        return this.currentFaceCheckIndex;
    }

    @NotNull
    public final SunshineRunFaceCheckData copy(boolean faceAuth, @Nullable String faceImg, int similarityValue, int faceTime, boolean bodyEnable, int bodyRate, int faceModelType, @NotNull List<SunshineRunFaceRecord> faceCheckRecordList, int currentFaceCheckIndex, long faceLeftTime, long faceUseTime, long faceUseSaveTime) {
        Intrinsics.checkNotNullParameter(faceCheckRecordList, "faceCheckRecordList");
        return new SunshineRunFaceCheckData(faceAuth, faceImg, similarityValue, faceTime, bodyEnable, bodyRate, faceModelType, faceCheckRecordList, currentFaceCheckIndex, faceLeftTime, faceUseTime, faceUseSaveTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SunshineRunFaceCheckData)) {
            return false;
        }
        SunshineRunFaceCheckData sunshineRunFaceCheckData = (SunshineRunFaceCheckData) other;
        return this.faceAuth == sunshineRunFaceCheckData.faceAuth && Intrinsics.areEqual(this.faceImg, sunshineRunFaceCheckData.faceImg) && this.similarityValue == sunshineRunFaceCheckData.similarityValue && this.faceTime == sunshineRunFaceCheckData.faceTime && this.bodyEnable == sunshineRunFaceCheckData.bodyEnable && this.bodyRate == sunshineRunFaceCheckData.bodyRate && this.faceModelType == sunshineRunFaceCheckData.faceModelType && Intrinsics.areEqual(this.faceCheckRecordList, sunshineRunFaceCheckData.faceCheckRecordList) && this.currentFaceCheckIndex == sunshineRunFaceCheckData.currentFaceCheckIndex && this.faceLeftTime == sunshineRunFaceCheckData.faceLeftTime && this.faceUseTime == sunshineRunFaceCheckData.faceUseTime && this.faceUseSaveTime == sunshineRunFaceCheckData.faceUseSaveTime;
    }

    public final boolean getBodyEnable() {
        return this.bodyEnable;
    }

    public final int getBodyRate() {
        return this.bodyRate;
    }

    public final int getCurrentFaceCheckIndex() {
        return this.currentFaceCheckIndex;
    }

    public final boolean getFaceAuth() {
        return this.faceAuth;
    }

    @NotNull
    public final List<SunshineRunFaceRecord> getFaceCheckRecordList() {
        return this.faceCheckRecordList;
    }

    @Nullable
    public final String getFaceImg() {
        return this.faceImg;
    }

    public final long getFaceLeftTime() {
        return this.faceLeftTime;
    }

    public final int getFaceModelType() {
        return this.faceModelType;
    }

    public final int getFaceTime() {
        return this.faceTime;
    }

    public final long getFaceUseSaveTime() {
        return this.faceUseSaveTime;
    }

    public final long getFaceUseTime() {
        return this.faceUseTime;
    }

    public final int getSimilarityValue() {
        return this.similarityValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    public int hashCode() {
        boolean z = this.faceAuth;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.faceImg;
        int iHashCode = (((((i + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.similarityValue)) * 31) + Integer.hashCode(this.faceTime)) * 31;
        boolean z2 = this.bodyEnable;
        return ((((((((((((((iHashCode + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.bodyRate)) * 31) + Integer.hashCode(this.faceModelType)) * 31) + this.faceCheckRecordList.hashCode()) * 31) + Integer.hashCode(this.currentFaceCheckIndex)) * 31) + Long.hashCode(this.faceLeftTime)) * 31) + Long.hashCode(this.faceUseTime)) * 31) + Long.hashCode(this.faceUseSaveTime);
    }

    public final void setBodyEnable(boolean z) {
        this.bodyEnable = z;
    }

    public final void setBodyRate(int i) {
        this.bodyRate = i;
    }

    public final void setCurrentFaceCheckIndex(int i) {
        this.currentFaceCheckIndex = i;
    }

    public final void setFaceImg(@Nullable String str) {
        this.faceImg = str;
    }

    public final void setFaceLeftTime(long j) {
        this.faceLeftTime = j;
    }

    public final void setFaceModelType(int i) {
        this.faceModelType = i;
    }

    public final void setFaceTime(int i) {
        this.faceTime = i;
    }

    public final void setFaceUseSaveTime(long j) {
        this.faceUseSaveTime = j;
    }

    public final void setFaceUseTime(long j) {
        this.faceUseTime = j;
    }

    public final void setSimilarityValue(int i) {
        this.similarityValue = i;
    }

    @NotNull
    public String toString() {
        return "SunshineRunFaceCheckData(faceAuth=" + this.faceAuth + ", faceImg=" + this.faceImg + ", similarityValue=" + this.similarityValue + ", faceTime=" + this.faceTime + ", bodyEnable=" + this.bodyEnable + ", bodyRate=" + this.bodyRate + ", faceModelType=" + this.faceModelType + ", faceCheckRecordList=" + this.faceCheckRecordList + ", currentFaceCheckIndex=" + this.currentFaceCheckIndex + ", faceLeftTime=" + this.faceLeftTime + ", faceUseTime=" + this.faceUseTime + ", faceUseSaveTime=" + this.faceUseSaveTime + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.faceAuth ? 1 : 0);
        parcel.writeString(this.faceImg);
        parcel.writeInt(this.similarityValue);
        parcel.writeInt(this.faceTime);
        parcel.writeInt(this.bodyEnable ? 1 : 0);
        parcel.writeInt(this.bodyRate);
        parcel.writeInt(this.faceModelType);
        List<SunshineRunFaceRecord> list = this.faceCheckRecordList;
        parcel.writeInt(list.size());
        Iterator<SunshineRunFaceRecord> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.currentFaceCheckIndex);
        parcel.writeLong(this.faceLeftTime);
        parcel.writeLong(this.faceUseTime);
        parcel.writeLong(this.faceUseSaveTime);
    }

    public /* synthetic */ SunshineRunFaceCheckData(boolean z, String str, int i, int i2, boolean z2, int i3, int i4, List list, int i5, long j, long j2, long j3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? false : z, (i6 & 2) != 0 ? null : str, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? 0 : i2, (i6 & 16) != 0 ? false : z2, (i6 & 32) == 0 ? i3 : 0, (i6 & 64) != 0 ? 1 : i4, (i6 & 128) != 0 ? new ArrayList() : list, (i6 & 256) != 0 ? -1 : i5, (i6 & 512) != 0 ? 0L : j, (i6 & 1024) != 0 ? 0L : j2, (i6 & 2048) == 0 ? j3 : 0L);
    }
}

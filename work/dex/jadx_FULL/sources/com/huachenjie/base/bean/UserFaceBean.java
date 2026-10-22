package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.il2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u00069"}, d2 = {"Lcom/huachenjie/base/bean/UserFaceBean;", "Landroid/os/Parcelable;", "faceEnabled", "", "faceImg", "", "similarityValue", "faceAuth", "", "runRecordCode", "faceTime", "leftTime", "bodyEnable", "bodyRate", "faceModelType", il2.g, "(ILjava/lang/String;IZLjava/lang/String;IIZIII)V", "getBodyEnable", "()Z", "getBodyRate", "()I", "getFaceAuth", "getFaceCheckIndex", "getFaceEnabled", "getFaceImg", "()Ljava/lang/String;", "setFaceImg", "(Ljava/lang/String;)V", "getFaceModelType", "getFaceTime", "getLeftTime", "getRunRecordCode", "getSimilarityValue", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserFaceBean implements Parcelable {
    public static final int FACE_MODEL_ALIYUN = 1;
    public static final int FACE_MODEL_LOCAL = 2;
    private final boolean bodyEnable;
    private final int bodyRate;
    private final boolean faceAuth;
    private final int faceCheckIndex;
    private final int faceEnabled;

    @NotNull
    private String faceImg;
    private final int faceModelType;
    private final int faceTime;
    private final int leftTime;

    @NotNull
    private final String runRecordCode;
    private final int similarityValue;

    @NotNull
    public static final Parcelable.Creator<UserFaceBean> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserFaceBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserFaceBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserFaceBean(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserFaceBean[] newArray(int i) {
            return new UserFaceBean[i];
        }
    }

    public UserFaceBean() {
        this(0, null, 0, false, null, 0, 0, false, 0, 0, 0, 2047, null);
    }

    public UserFaceBean(int i, @NotNull String str, int i2, boolean z, @NotNull String str2, int i3, int i4, boolean z2, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, "faceImg");
        Intrinsics.checkNotNullParameter(str2, "runRecordCode");
        this.faceEnabled = i;
        this.faceImg = str;
        this.similarityValue = i2;
        this.faceAuth = z;
        this.runRecordCode = str2;
        this.faceTime = i3;
        this.leftTime = i4;
        this.bodyEnable = z2;
        this.bodyRate = i5;
        this.faceModelType = i6;
        this.faceCheckIndex = i7;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFaceEnabled() {
        return this.faceEnabled;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getFaceModelType() {
        return this.faceModelType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getFaceCheckIndex() {
        return this.faceCheckIndex;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFaceImg() {
        return this.faceImg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSimilarityValue() {
        return this.similarityValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFaceAuth() {
        return this.faceAuth;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRunRecordCode() {
        return this.runRecordCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFaceTime() {
        return this.faceTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getLeftTime() {
        return this.leftTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getBodyEnable() {
        return this.bodyEnable;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getBodyRate() {
        return this.bodyRate;
    }

    @NotNull
    public final UserFaceBean copy(int faceEnabled, @NotNull String faceImg, int similarityValue, boolean faceAuth, @NotNull String runRecordCode, int faceTime, int leftTime, boolean bodyEnable, int bodyRate, int faceModelType, int faceCheckIndex) {
        Intrinsics.checkNotNullParameter(faceImg, "faceImg");
        Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
        return new UserFaceBean(faceEnabled, faceImg, similarityValue, faceAuth, runRecordCode, faceTime, leftTime, bodyEnable, bodyRate, faceModelType, faceCheckIndex);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserFaceBean)) {
            return false;
        }
        UserFaceBean userFaceBean = (UserFaceBean) other;
        return this.faceEnabled == userFaceBean.faceEnabled && Intrinsics.areEqual(this.faceImg, userFaceBean.faceImg) && this.similarityValue == userFaceBean.similarityValue && this.faceAuth == userFaceBean.faceAuth && Intrinsics.areEqual(this.runRecordCode, userFaceBean.runRecordCode) && this.faceTime == userFaceBean.faceTime && this.leftTime == userFaceBean.leftTime && this.bodyEnable == userFaceBean.bodyEnable && this.bodyRate == userFaceBean.bodyRate && this.faceModelType == userFaceBean.faceModelType && this.faceCheckIndex == userFaceBean.faceCheckIndex;
    }

    public final boolean getBodyEnable() {
        return this.bodyEnable;
    }

    public final int getBodyRate() {
        return this.bodyRate;
    }

    public final boolean getFaceAuth() {
        return this.faceAuth;
    }

    public final int getFaceCheckIndex() {
        return this.faceCheckIndex;
    }

    public final int getFaceEnabled() {
        return this.faceEnabled;
    }

    @NotNull
    public final String getFaceImg() {
        return this.faceImg;
    }

    public final int getFaceModelType() {
        return this.faceModelType;
    }

    public final int getFaceTime() {
        return this.faceTime;
    }

    public final int getLeftTime() {
        return this.leftTime;
    }

    @NotNull
    public final String getRunRecordCode() {
        return this.runRecordCode;
    }

    public final int getSimilarityValue() {
        return this.similarityValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.faceEnabled) * 31) + this.faceImg.hashCode()) * 31) + Integer.hashCode(this.similarityValue)) * 31;
        boolean z = this.faceAuth;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((iHashCode + r1) * 31) + this.runRecordCode.hashCode()) * 31) + Integer.hashCode(this.faceTime)) * 31) + Integer.hashCode(this.leftTime)) * 31;
        boolean z2 = this.bodyEnable;
        return ((((((iHashCode2 + (z2 ? 1 : z2)) * 31) + Integer.hashCode(this.bodyRate)) * 31) + Integer.hashCode(this.faceModelType)) * 31) + Integer.hashCode(this.faceCheckIndex);
    }

    public final void setFaceImg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.faceImg = str;
    }

    @NotNull
    public String toString() {
        return "UserFaceBean(faceEnabled=" + this.faceEnabled + ", faceImg=" + this.faceImg + ", similarityValue=" + this.similarityValue + ", faceAuth=" + this.faceAuth + ", runRecordCode=" + this.runRecordCode + ", faceTime=" + this.faceTime + ", leftTime=" + this.leftTime + ", bodyEnable=" + this.bodyEnable + ", bodyRate=" + this.bodyRate + ", faceModelType=" + this.faceModelType + ", faceCheckIndex=" + this.faceCheckIndex + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.faceEnabled);
        parcel.writeString(this.faceImg);
        parcel.writeInt(this.similarityValue);
        parcel.writeInt(this.faceAuth ? 1 : 0);
        parcel.writeString(this.runRecordCode);
        parcel.writeInt(this.faceTime);
        parcel.writeInt(this.leftTime);
        parcel.writeInt(this.bodyEnable ? 1 : 0);
        parcel.writeInt(this.bodyRate);
        parcel.writeInt(this.faceModelType);
        parcel.writeInt(this.faceCheckIndex);
    }

    public /* synthetic */ UserFaceBean(int i, String str, int i2, boolean z, String str2, int i3, int i4, boolean z2, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? "" : str, (i8 & 4) != 0 ? 50 : i2, (i8 & 8) != 0 ? false : z, (i8 & 16) == 0 ? str2 : "", (i8 & 32) != 0 ? 0 : i3, (i8 & 64) != 0 ? 0 : i4, (i8 & 128) != 0 ? false : z2, (i8 & 256) == 0 ? i5 : 0, (i8 & 512) != 0 ? 1 : i6, (i8 & 1024) != 0 ? -1 : i7);
    }
}

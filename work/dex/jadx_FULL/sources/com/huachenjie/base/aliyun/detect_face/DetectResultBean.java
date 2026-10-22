package com.huachenjie.base.aliyun.detect_face;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0010HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008e\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u00020\u0010HÖ\u0001J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0010HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006:"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "Landroid/os/Parcelable;", "success", "", "runRecordCode", "", "compareFaceUrl", "confidence", "", "label", "rate", "faceRequestId", "bodyRequestId", "faceCheckErrorCode", "bodyCheckErrorCode", il2.g, "", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBodyCheckErrorCode", "()Ljava/lang/String;", "getBodyRequestId", "getCompareFaceUrl", "getConfidence", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFaceCheckErrorCode", "getFaceCheckIndex", "()I", "getFaceRequestId", "getLabel", "getRate", "getRunRecordCode", "getSuccess", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/huachenjie/base/aliyun/detect_face/DetectResultBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DetectResultBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DetectResultBean> CREATOR = new a();

    @Nullable
    private final String bodyCheckErrorCode;

    @Nullable
    private final String bodyRequestId;

    @Nullable
    private final String compareFaceUrl;

    @Nullable
    private final Float confidence;

    @Nullable
    private final String faceCheckErrorCode;
    private final int faceCheckIndex;

    @Nullable
    private final String faceRequestId;

    @Nullable
    private final String label;

    @Nullable
    private final Float rate;

    @Nullable
    private final String runRecordCode;
    private final boolean success;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<DetectResultBean> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DetectResultBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DetectResultBean(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DetectResultBean[] newArray(int i) {
            return new DetectResultBean[i];
        }
    }

    public DetectResultBean(boolean z, @Nullable String str, @Nullable String str2, @Nullable Float f, @Nullable String str3, @Nullable Float f2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i) {
        this.success = z;
        this.runRecordCode = str;
        this.compareFaceUrl = str2;
        this.confidence = f;
        this.label = str3;
        this.rate = f2;
        this.faceRequestId = str4;
        this.bodyRequestId = str5;
        this.faceCheckErrorCode = str6;
        this.bodyCheckErrorCode = str7;
        this.faceCheckIndex = i;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getBodyCheckErrorCode() {
        return this.bodyCheckErrorCode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getFaceCheckIndex() {
        return this.faceCheckIndex;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRunRecordCode() {
        return this.runRecordCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCompareFaceUrl() {
        return this.compareFaceUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getConfidence() {
        return this.confidence;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getRate() {
        return this.rate;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFaceRequestId() {
        return this.faceRequestId;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBodyRequestId() {
        return this.bodyRequestId;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFaceCheckErrorCode() {
        return this.faceCheckErrorCode;
    }

    @NotNull
    public final DetectResultBean copy(boolean success, @Nullable String runRecordCode, @Nullable String compareFaceUrl, @Nullable Float confidence, @Nullable String label, @Nullable Float rate, @Nullable String faceRequestId, @Nullable String bodyRequestId, @Nullable String faceCheckErrorCode, @Nullable String bodyCheckErrorCode, int faceCheckIndex) {
        return new DetectResultBean(success, runRecordCode, compareFaceUrl, confidence, label, rate, faceRequestId, bodyRequestId, faceCheckErrorCode, bodyCheckErrorCode, faceCheckIndex);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectResultBean)) {
            return false;
        }
        DetectResultBean detectResultBean = (DetectResultBean) other;
        return this.success == detectResultBean.success && Intrinsics.areEqual(this.runRecordCode, detectResultBean.runRecordCode) && Intrinsics.areEqual(this.compareFaceUrl, detectResultBean.compareFaceUrl) && Intrinsics.areEqual(this.confidence, detectResultBean.confidence) && Intrinsics.areEqual(this.label, detectResultBean.label) && Intrinsics.areEqual(this.rate, detectResultBean.rate) && Intrinsics.areEqual(this.faceRequestId, detectResultBean.faceRequestId) && Intrinsics.areEqual(this.bodyRequestId, detectResultBean.bodyRequestId) && Intrinsics.areEqual(this.faceCheckErrorCode, detectResultBean.faceCheckErrorCode) && Intrinsics.areEqual(this.bodyCheckErrorCode, detectResultBean.bodyCheckErrorCode) && this.faceCheckIndex == detectResultBean.faceCheckIndex;
    }

    @Nullable
    public final String getBodyCheckErrorCode() {
        return this.bodyCheckErrorCode;
    }

    @Nullable
    public final String getBodyRequestId() {
        return this.bodyRequestId;
    }

    @Nullable
    public final String getCompareFaceUrl() {
        return this.compareFaceUrl;
    }

    @Nullable
    public final Float getConfidence() {
        return this.confidence;
    }

    @Nullable
    public final String getFaceCheckErrorCode() {
        return this.faceCheckErrorCode;
    }

    public final int getFaceCheckIndex() {
        return this.faceCheckIndex;
    }

    @Nullable
    public final String getFaceRequestId() {
        return this.faceRequestId;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Float getRate() {
        return this.rate;
    }

    @Nullable
    public final String getRunRecordCode() {
        return this.runRecordCode;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.runRecordCode;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.compareFaceUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f = this.confidence;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        String str3 = this.label;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f2 = this.rate;
        int iHashCode5 = (iHashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str4 = this.faceRequestId;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.bodyRequestId;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.faceCheckErrorCode;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.bodyCheckErrorCode;
        return ((iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31) + Integer.hashCode(this.faceCheckIndex);
    }

    @NotNull
    public String toString() {
        return "DetectResultBean(success=" + this.success + ", runRecordCode=" + this.runRecordCode + ", compareFaceUrl=" + this.compareFaceUrl + ", confidence=" + this.confidence + ", label=" + this.label + ", rate=" + this.rate + ", faceRequestId=" + this.faceRequestId + ", bodyRequestId=" + this.bodyRequestId + ", faceCheckErrorCode=" + this.faceCheckErrorCode + ", bodyCheckErrorCode=" + this.bodyCheckErrorCode + ", faceCheckIndex=" + this.faceCheckIndex + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.success ? 1 : 0);
        parcel.writeString(this.runRecordCode);
        parcel.writeString(this.compareFaceUrl);
        Float f = this.confidence;
        if (f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        }
        parcel.writeString(this.label);
        Float f2 = this.rate;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeString(this.faceRequestId);
        parcel.writeString(this.bodyRequestId);
        parcel.writeString(this.faceCheckErrorCode);
        parcel.writeString(this.bodyCheckErrorCode);
        parcel.writeInt(this.faceCheckIndex);
    }

    public /* synthetic */ DetectResultBean(boolean z, String str, String str2, Float f, String str3, Float f2, String str4, String str5, String str6, String str7, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : f, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : f2, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) == 0 ? str7 : null, (i2 & 1024) != 0 ? -1 : i);
    }
}

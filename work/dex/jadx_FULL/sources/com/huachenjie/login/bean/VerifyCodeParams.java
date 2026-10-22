package com.huachenjie.login.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u00065"}, d2 = {"Lcom/huachenjie/login/bean/VerifyCodeParams;", "Landroid/os/Parcelable;", "smsLoginRemainTimes", "", "callLoginRemainTimes", "lastSendTime", "", "lastSendTicket", "", "lastSendType", "lastThirdType", AliyunLogCommon.TERMINAL_TYPE, "(IIJLjava/lang/String;IILjava/lang/String;)V", "getCallLoginRemainTimes", "()I", "setCallLoginRemainTimes", "(I)V", "getLastSendTicket", "()Ljava/lang/String;", "setLastSendTicket", "(Ljava/lang/String;)V", "getLastSendTime", "()J", "setLastSendTime", "(J)V", "getLastSendType", "setLastSendType", "getLastThirdType", "setLastThirdType", "getPhone", "setPhone", "getSmsLoginRemainTimes", "setSmsLoginRemainTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VerifyCodeParams implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VerifyCodeParams> CREATOR = new Creator();
    private int callLoginRemainTimes;

    @NotNull
    private String lastSendTicket;
    private long lastSendTime;
    private int lastSendType;
    private int lastThirdType;

    @NotNull
    private String phone;
    private int smsLoginRemainTimes;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VerifyCodeParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerifyCodeParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VerifyCodeParams(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerifyCodeParams[] newArray(int i) {
            return new VerifyCodeParams[i];
        }
    }

    public VerifyCodeParams() {
        this(0, 0, 0L, null, 0, 0, null, 127, null);
    }

    public VerifyCodeParams(int i, int i2, long j, @NotNull String str, int i3, int i4, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "lastSendTicket");
        Intrinsics.checkNotNullParameter(str2, AliyunLogCommon.TERMINAL_TYPE);
        this.smsLoginRemainTimes = i;
        this.callLoginRemainTimes = i2;
        this.lastSendTime = j;
        this.lastSendTicket = str;
        this.lastSendType = i3;
        this.lastThirdType = i4;
        this.phone = str2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSmsLoginRemainTimes() {
        return this.smsLoginRemainTimes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCallLoginRemainTimes() {
        return this.callLoginRemainTimes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastSendTime() {
        return this.lastSendTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLastSendTicket() {
        return this.lastSendTicket;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLastSendType() {
        return this.lastSendType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getLastThirdType() {
        return this.lastThirdType;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final VerifyCodeParams copy(int smsLoginRemainTimes, int callLoginRemainTimes, long lastSendTime, @NotNull String lastSendTicket, int lastSendType, int lastThirdType, @NotNull String phone) {
        Intrinsics.checkNotNullParameter(lastSendTicket, "lastSendTicket");
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        return new VerifyCodeParams(smsLoginRemainTimes, callLoginRemainTimes, lastSendTime, lastSendTicket, lastSendType, lastThirdType, phone);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerifyCodeParams)) {
            return false;
        }
        VerifyCodeParams verifyCodeParams = (VerifyCodeParams) other;
        return this.smsLoginRemainTimes == verifyCodeParams.smsLoginRemainTimes && this.callLoginRemainTimes == verifyCodeParams.callLoginRemainTimes && this.lastSendTime == verifyCodeParams.lastSendTime && Intrinsics.areEqual(this.lastSendTicket, verifyCodeParams.lastSendTicket) && this.lastSendType == verifyCodeParams.lastSendType && this.lastThirdType == verifyCodeParams.lastThirdType && Intrinsics.areEqual(this.phone, verifyCodeParams.phone);
    }

    public final int getCallLoginRemainTimes() {
        return this.callLoginRemainTimes;
    }

    @NotNull
    public final String getLastSendTicket() {
        return this.lastSendTicket;
    }

    public final long getLastSendTime() {
        return this.lastSendTime;
    }

    public final int getLastSendType() {
        return this.lastSendType;
    }

    public final int getLastThirdType() {
        return this.lastThirdType;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    public final int getSmsLoginRemainTimes() {
        return this.smsLoginRemainTimes;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.smsLoginRemainTimes) * 31) + Integer.hashCode(this.callLoginRemainTimes)) * 31) + Long.hashCode(this.lastSendTime)) * 31) + this.lastSendTicket.hashCode()) * 31) + Integer.hashCode(this.lastSendType)) * 31) + Integer.hashCode(this.lastThirdType)) * 31) + this.phone.hashCode();
    }

    public final void setCallLoginRemainTimes(int i) {
        this.callLoginRemainTimes = i;
    }

    public final void setLastSendTicket(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastSendTicket = str;
    }

    public final void setLastSendTime(long j) {
        this.lastSendTime = j;
    }

    public final void setLastSendType(int i) {
        this.lastSendType = i;
    }

    public final void setLastThirdType(int i) {
        this.lastThirdType = i;
    }

    public final void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phone = str;
    }

    public final void setSmsLoginRemainTimes(int i) {
        this.smsLoginRemainTimes = i;
    }

    @NotNull
    public String toString() {
        return "VerifyCodeParams(smsLoginRemainTimes=" + this.smsLoginRemainTimes + ", callLoginRemainTimes=" + this.callLoginRemainTimes + ", lastSendTime=" + this.lastSendTime + ", lastSendTicket=" + this.lastSendTicket + ", lastSendType=" + this.lastSendType + ", lastThirdType=" + this.lastThirdType + ", phone=" + this.phone + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.smsLoginRemainTimes);
        parcel.writeInt(this.callLoginRemainTimes);
        parcel.writeLong(this.lastSendTime);
        parcel.writeString(this.lastSendTicket);
        parcel.writeInt(this.lastSendType);
        parcel.writeInt(this.lastThirdType);
        parcel.writeString(this.phone);
    }

    public /* synthetic */ VerifyCodeParams(int i, int i2, long j, String str, int i3, int i4, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0L : j, (i5 & 8) != 0 ? "" : str, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) == 0 ? i4 : 0, (i5 & 64) == 0 ? str2 : "");
    }
}

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/login/bean/LoginCheckData;", "Landroid/os/Parcelable;", AliyunLogCommon.TERMINAL_TYPE, "", "passwordType", "", "loginType", "(Ljava/lang/String;II)V", "getLoginType", "()I", "setLoginType", "(I)V", "getPasswordType", "getPhone", "()Ljava/lang/String;", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LoginCheckData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<LoginCheckData> CREATOR = new Creator();
    private int loginType;
    private final int passwordType;

    @NotNull
    private final String phone;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LoginCheckData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LoginCheckData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LoginCheckData(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LoginCheckData[] newArray(int i) {
            return new LoginCheckData[i];
        }
    }

    public LoginCheckData() {
        this(null, 0, 0, 7, null);
    }

    public LoginCheckData(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, AliyunLogCommon.TERMINAL_TYPE);
        this.phone = str;
        this.passwordType = i;
        this.loginType = i2;
    }

    public static /* synthetic */ LoginCheckData copy$default(LoginCheckData loginCheckData, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = loginCheckData.phone;
        }
        if ((i3 & 2) != 0) {
            i = loginCheckData.passwordType;
        }
        if ((i3 & 4) != 0) {
            i2 = loginCheckData.loginType;
        }
        return loginCheckData.copy(str, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPasswordType() {
        return this.passwordType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLoginType() {
        return this.loginType;
    }

    @NotNull
    public final LoginCheckData copy(@NotNull String phone, int passwordType, int loginType) {
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        return new LoginCheckData(phone, passwordType, loginType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginCheckData)) {
            return false;
        }
        LoginCheckData loginCheckData = (LoginCheckData) other;
        return Intrinsics.areEqual(this.phone, loginCheckData.phone) && this.passwordType == loginCheckData.passwordType && this.loginType == loginCheckData.loginType;
    }

    public final int getLoginType() {
        return this.loginType;
    }

    public final int getPasswordType() {
        return this.passwordType;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        return (((this.phone.hashCode() * 31) + Integer.hashCode(this.passwordType)) * 31) + Integer.hashCode(this.loginType);
    }

    public final void setLoginType(int i) {
        this.loginType = i;
    }

    @NotNull
    public String toString() {
        return "LoginCheckData(phone=" + this.phone + ", passwordType=" + this.passwordType + ", loginType=" + this.loginType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.phone);
        parcel.writeInt(this.passwordType);
        parcel.writeInt(this.loginType);
    }

    public /* synthetic */ LoginCheckData(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}

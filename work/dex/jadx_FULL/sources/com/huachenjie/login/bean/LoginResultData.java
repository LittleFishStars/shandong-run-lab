package com.huachenjie.login.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.AlertTip;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/huachenjie/login/bean/LoginResultData;", "Landroid/os/Parcelable;", "userId", "", "token", "satoken", "userType", "", "currentTip", "", yj7.a.ALERT_TIP, "Lcom/huachenjie/common/bean/AlertTip;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Lcom/huachenjie/common/bean/AlertTip;)V", "getAlertTip", "()Lcom/huachenjie/common/bean/AlertTip;", "getCurrentTip", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSatoken", "()Ljava/lang/String;", "getToken", "getUserId", "getUserType", "()I", "setUserType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Lcom/huachenjie/common/bean/AlertTip;)Lcom/huachenjie/login/bean/LoginResultData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LoginResultData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<LoginResultData> CREATOR = new Creator();

    @Nullable
    private final AlertTip alertTip;

    @Nullable
    private final Boolean currentTip;

    @NotNull
    private final String satoken;

    @NotNull
    private final String token;

    @NotNull
    private final String userId;
    private int userType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LoginResultData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LoginResultData createFromParcel(@NotNull Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i = parcel.readInt();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new LoginResultData(string, string2, string3, i, boolValueOf, (AlertTip) parcel.readParcelable(LoginResultData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LoginResultData[] newArray(int i) {
            return new LoginResultData[i];
        }
    }

    public LoginResultData(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @Nullable Boolean bool, @Nullable AlertTip alertTip) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, "token");
        Intrinsics.checkNotNullParameter(str3, "satoken");
        this.userId = str;
        this.token = str2;
        this.satoken = str3;
        this.userType = i;
        this.currentTip = bool;
        this.alertTip = alertTip;
    }

    public static /* synthetic */ LoginResultData copy$default(LoginResultData loginResultData, String str, String str2, String str3, int i, Boolean bool, AlertTip alertTip, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loginResultData.userId;
        }
        if ((i2 & 2) != 0) {
            str2 = loginResultData.token;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = loginResultData.satoken;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            i = loginResultData.userType;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            bool = loginResultData.currentTip;
        }
        Boolean bool2 = bool;
        if ((i2 & 32) != 0) {
            alertTip = loginResultData.alertTip;
        }
        return loginResultData.copy(str, str4, str5, i3, bool2, alertTip);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSatoken() {
        return this.satoken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getCurrentTip() {
        return this.currentTip;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AlertTip getAlertTip() {
        return this.alertTip;
    }

    @NotNull
    public final LoginResultData copy(@NotNull String userId, @NotNull String token, @NotNull String satoken, int userType, @Nullable Boolean currentTip, @Nullable AlertTip alertTip) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(satoken, "satoken");
        return new LoginResultData(userId, token, satoken, userType, currentTip, alertTip);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginResultData)) {
            return false;
        }
        LoginResultData loginResultData = (LoginResultData) other;
        return Intrinsics.areEqual(this.userId, loginResultData.userId) && Intrinsics.areEqual(this.token, loginResultData.token) && Intrinsics.areEqual(this.satoken, loginResultData.satoken) && this.userType == loginResultData.userType && Intrinsics.areEqual(this.currentTip, loginResultData.currentTip) && Intrinsics.areEqual(this.alertTip, loginResultData.alertTip);
    }

    @Nullable
    public final AlertTip getAlertTip() {
        return this.alertTip;
    }

    @Nullable
    public final Boolean getCurrentTip() {
        return this.currentTip;
    }

    @NotNull
    public final String getSatoken() {
        return this.satoken;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public int hashCode() {
        int iHashCode = ((((((this.userId.hashCode() * 31) + this.token.hashCode()) * 31) + this.satoken.hashCode()) * 31) + Integer.hashCode(this.userType)) * 31;
        Boolean bool = this.currentTip;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        AlertTip alertTip = this.alertTip;
        return iHashCode2 + (alertTip != null ? alertTip.hashCode() : 0);
    }

    public final void setUserType(int i) {
        this.userType = i;
    }

    @NotNull
    public String toString() {
        return "LoginResultData(userId=" + this.userId + ", token=" + this.token + ", satoken=" + this.satoken + ", userType=" + this.userType + ", currentTip=" + this.currentTip + ", alertTip=" + this.alertTip + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.os.Parcel, java.lang.Object] */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        ?? BooleanValue;
        Intrinsics.checkNotNullParameter((Object) parcel, "out");
        parcel.writeString(this.userId);
        parcel.writeString(this.token);
        parcel.writeString(this.satoken);
        parcel.writeInt(this.userType);
        Boolean bool = this.currentTip;
        if (bool == null) {
            BooleanValue = 0;
        } else {
            parcel.writeInt(1);
            BooleanValue = bool.booleanValue();
        }
        parcel.writeInt(BooleanValue);
        parcel.writeParcelable(this.alertTip, flags);
    }
}

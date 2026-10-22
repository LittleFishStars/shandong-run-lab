package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/huachenjie/common/bean/VodTokenInfo;", "Landroid/os/Parcelable;", "accessKeyId", "", "accessKeySecret", "expiration", "securityToken", "templateGroupId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getAccessKeySecret", "getExpiration", "getSecurityToken", "getTemplateGroupId", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VodTokenInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VodTokenInfo> CREATOR = new Creator();

    @NotNull
    private final String accessKeyId;

    @NotNull
    private final String accessKeySecret;

    @NotNull
    private final String expiration;

    @NotNull
    private final String securityToken;

    @NotNull
    private final String templateGroupId;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VodTokenInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VodTokenInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VodTokenInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VodTokenInfo[] newArray(int i) {
            return new VodTokenInfo[i];
        }
    }

    public VodTokenInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "accessKeyId");
        Intrinsics.checkNotNullParameter(str2, "accessKeySecret");
        Intrinsics.checkNotNullParameter(str3, "expiration");
        Intrinsics.checkNotNullParameter(str4, "securityToken");
        Intrinsics.checkNotNullParameter(str5, "templateGroupId");
        this.accessKeyId = str;
        this.accessKeySecret = str2;
        this.expiration = str3;
        this.securityToken = str4;
        this.templateGroupId = str5;
    }

    public static /* synthetic */ VodTokenInfo copy$default(VodTokenInfo vodTokenInfo, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vodTokenInfo.accessKeyId;
        }
        if ((i & 2) != 0) {
            str2 = vodTokenInfo.accessKeySecret;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = vodTokenInfo.expiration;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = vodTokenInfo.securityToken;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = vodTokenInfo.templateGroupId;
        }
        return vodTokenInfo.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExpiration() {
        return this.expiration;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSecurityToken() {
        return this.securityToken;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTemplateGroupId() {
        return this.templateGroupId;
    }

    @NotNull
    public final VodTokenInfo copy(@NotNull String accessKeyId, @NotNull String accessKeySecret, @NotNull String expiration, @NotNull String securityToken, @NotNull String templateGroupId) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(accessKeySecret, "accessKeySecret");
        Intrinsics.checkNotNullParameter(expiration, "expiration");
        Intrinsics.checkNotNullParameter(securityToken, "securityToken");
        Intrinsics.checkNotNullParameter(templateGroupId, "templateGroupId");
        return new VodTokenInfo(accessKeyId, accessKeySecret, expiration, securityToken, templateGroupId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VodTokenInfo)) {
            return false;
        }
        VodTokenInfo vodTokenInfo = (VodTokenInfo) other;
        return Intrinsics.areEqual(this.accessKeyId, vodTokenInfo.accessKeyId) && Intrinsics.areEqual(this.accessKeySecret, vodTokenInfo.accessKeySecret) && Intrinsics.areEqual(this.expiration, vodTokenInfo.expiration) && Intrinsics.areEqual(this.securityToken, vodTokenInfo.securityToken) && Intrinsics.areEqual(this.templateGroupId, vodTokenInfo.templateGroupId);
    }

    @NotNull
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    @NotNull
    public final String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @NotNull
    public final String getExpiration() {
        return this.expiration;
    }

    @NotNull
    public final String getSecurityToken() {
        return this.securityToken;
    }

    @NotNull
    public final String getTemplateGroupId() {
        return this.templateGroupId;
    }

    public int hashCode() {
        return (((((((this.accessKeyId.hashCode() * 31) + this.accessKeySecret.hashCode()) * 31) + this.expiration.hashCode()) * 31) + this.securityToken.hashCode()) * 31) + this.templateGroupId.hashCode();
    }

    @NotNull
    public String toString() {
        return "VodTokenInfo(accessKeyId=" + this.accessKeyId + ", accessKeySecret=" + this.accessKeySecret + ", expiration=" + this.expiration + ", securityToken=" + this.securityToken + ", templateGroupId=" + this.templateGroupId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.accessKeyId);
        parcel.writeString(this.accessKeySecret);
        parcel.writeString(this.expiration);
        parcel.writeString(this.securityToken);
        parcel.writeString(this.templateGroupId);
    }
}

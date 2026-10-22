package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/common/bean/OssTokenInfo;", "Landroid/os/Parcelable;", "securityToken", "", "accessKeySecret", "accessKeyId", "expiration", "", "domain", "directory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getAccessKeySecret", "getDirectory", "setDirectory", "(Ljava/lang/String;)V", "getDomain", "getExpiration", "()J", "getSecurityToken", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OssTokenInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OssTokenInfo> CREATOR = new Creator();

    @NotNull
    private final String accessKeyId;

    @NotNull
    private final String accessKeySecret;

    @NotNull
    private String directory;

    @NotNull
    private final String domain;
    private final long expiration;

    @NotNull
    private final String securityToken;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OssTokenInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OssTokenInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OssTokenInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OssTokenInfo[] newArray(int i) {
            return new OssTokenInfo[i];
        }
    }

    public OssTokenInfo() {
        this(null, null, null, 0L, null, null, 63, null);
    }

    public OssTokenInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "securityToken");
        Intrinsics.checkNotNullParameter(str2, "accessKeySecret");
        Intrinsics.checkNotNullParameter(str3, "accessKeyId");
        Intrinsics.checkNotNullParameter(str4, "domain");
        Intrinsics.checkNotNullParameter(str5, "directory");
        this.securityToken = str;
        this.accessKeySecret = str2;
        this.accessKeyId = str3;
        this.expiration = j;
        this.domain = str4;
        this.directory = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
    public final String getDirectory() {
        return this.directory;
    }

    @NotNull
    public final String getDomain() {
        return this.domain;
    }

    public final long getExpiration() {
        return this.expiration;
    }

    @NotNull
    public final String getSecurityToken() {
        return this.securityToken;
    }

    public final void setDirectory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.directory = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.securityToken);
        parcel.writeString(this.accessKeySecret);
        parcel.writeString(this.accessKeyId);
        parcel.writeLong(this.expiration);
        parcel.writeString(this.domain);
        parcel.writeString(this.directory);
    }

    public /* synthetic */ OssTokenInfo(String str, String str2, String str3, long j, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5);
    }
}

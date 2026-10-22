package com.huachenjie.channel.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/huachenjie/channel/bean/OrganizeTeamUserBean;", "Landroid/os/Parcelable;", "avatar", "", UserConstants.USER_PARAMS.b, "appUserCode", "slogan", "avatarFrameImgUrl", "userType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getAvatarFrameImgUrl", "getNickName", "getSlogan", "getUserType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrganizeTeamUserBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrganizeTeamUserBean> CREATOR = new Creator();

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private final String nickName;

    @NotNull
    private final String slogan;
    private final int userType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrganizeTeamUserBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrganizeTeamUserBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrganizeTeamUserBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrganizeTeamUserBean[] newArray(int i) {
            return new OrganizeTeamUserBean[i];
        }
    }

    public OrganizeTeamUserBean() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public OrganizeTeamUserBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "appUserCode");
        Intrinsics.checkNotNullParameter(str4, "slogan");
        Intrinsics.checkNotNullParameter(str5, "avatarFrameImgUrl");
        this.avatar = str;
        this.nickName = str2;
        this.appUserCode = str3;
        this.slogan = str4;
        this.avatarFrameImgUrl = str5;
        this.userType = i;
    }

    public static /* synthetic */ OrganizeTeamUserBean copy$default(OrganizeTeamUserBean organizeTeamUserBean, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = organizeTeamUserBean.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = organizeTeamUserBean.nickName;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = organizeTeamUserBean.appUserCode;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = organizeTeamUserBean.slogan;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = organizeTeamUserBean.avatarFrameImgUrl;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = organizeTeamUserBean.userType;
        }
        return organizeTeamUserBean.copy(str, str6, str7, str8, str9, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSlogan() {
        return this.slogan;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    @NotNull
    public final OrganizeTeamUserBean copy(@NotNull String avatar, @NotNull String nickName, @NotNull String appUserCode, @NotNull String slogan, @NotNull String avatarFrameImgUrl, int userType) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(slogan, "slogan");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        return new OrganizeTeamUserBean(avatar, nickName, appUserCode, slogan, avatarFrameImgUrl, userType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrganizeTeamUserBean)) {
            return false;
        }
        OrganizeTeamUserBean organizeTeamUserBean = (OrganizeTeamUserBean) other;
        return Intrinsics.areEqual(this.avatar, organizeTeamUserBean.avatar) && Intrinsics.areEqual(this.nickName, organizeTeamUserBean.nickName) && Intrinsics.areEqual(this.appUserCode, organizeTeamUserBean.appUserCode) && Intrinsics.areEqual(this.slogan, organizeTeamUserBean.slogan) && Intrinsics.areEqual(this.avatarFrameImgUrl, organizeTeamUserBean.avatarFrameImgUrl) && this.userType == organizeTeamUserBean.userType;
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getSlogan() {
        return this.slogan;
    }

    public final int getUserType() {
        return this.userType;
    }

    public int hashCode() {
        return (((((((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.appUserCode.hashCode()) * 31) + this.slogan.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + Integer.hashCode(this.userType);
    }

    @NotNull
    public String toString() {
        return "OrganizeTeamUserBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", appUserCode=" + this.appUserCode + ", slogan=" + this.slogan + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", userType=" + this.userType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.avatar);
        parcel.writeString(this.nickName);
        parcel.writeString(this.appUserCode);
        parcel.writeString(this.slogan);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeInt(this.userType);
    }

    public /* synthetic */ OrganizeTeamUserBean(String str, String str2, String str3, String str4, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? 0 : i);
    }
}

package com.huachenjie.channel.bean.notify;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/channel/bean/notify/BuddyDetailUserBean;", "Landroid/os/Parcelable;", "appUserCode", "", UserConstants.USER_PARAMS.b, "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getNickName", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyDetailUserBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BuddyDetailUserBean> CREATOR = new Creator();

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @NotNull
    private final String nickName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BuddyDetailUserBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BuddyDetailUserBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BuddyDetailUserBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BuddyDetailUserBean[] newArray(int i) {
            return new BuddyDetailUserBean[i];
        }
    }

    public BuddyDetailUserBean() {
        this(null, null, null, 7, null);
    }

    public BuddyDetailUserBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "appUserCode");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "avatar");
        this.appUserCode = str;
        this.nickName = str2;
        this.avatar = str3;
    }

    public static /* synthetic */ BuddyDetailUserBean copy$default(BuddyDetailUserBean buddyDetailUserBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buddyDetailUserBean.appUserCode;
        }
        if ((i & 2) != 0) {
            str2 = buddyDetailUserBean.nickName;
        }
        if ((i & 4) != 0) {
            str3 = buddyDetailUserBean.avatar;
        }
        return buddyDetailUserBean.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final BuddyDetailUserBean copy(@NotNull String appUserCode, @NotNull String nickName, @NotNull String avatar) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        return new BuddyDetailUserBean(appUserCode, nickName, avatar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyDetailUserBean)) {
            return false;
        }
        BuddyDetailUserBean buddyDetailUserBean = (BuddyDetailUserBean) other;
        return Intrinsics.areEqual(this.appUserCode, buddyDetailUserBean.appUserCode) && Intrinsics.areEqual(this.nickName, buddyDetailUserBean.nickName) && Intrinsics.areEqual(this.avatar, buddyDetailUserBean.avatar);
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
    public final String getNickName() {
        return this.nickName;
    }

    public int hashCode() {
        return (((this.appUserCode.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyDetailUserBean(appUserCode=" + this.appUserCode + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.appUserCode);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatar);
    }

    public /* synthetic */ BuddyDetailUserBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}

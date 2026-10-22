package com.huachenjie.works.bean;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lcom/huachenjie/works/bean/PostUserBean;", "Landroid/os/Parcelable;", "avatar", "", UserConstants.USER_PARAMS.b, "avatarFrameImgUrl", "appUserCode", "anonymous", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAnonymous", "()Z", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getAvatarFrameImgUrl", "getNickName", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostUserBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PostUserBean> CREATOR = new Creator();
    private final boolean anonymous;

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private final String nickName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PostUserBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostUserBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PostUserBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostUserBean[] newArray(int i) {
            return new PostUserBean[i];
        }
    }

    public PostUserBean() {
        this(null, null, null, null, false, 31, null);
    }

    public PostUserBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str4, "appUserCode");
        this.avatar = str;
        this.nickName = str2;
        this.avatarFrameImgUrl = str3;
        this.appUserCode = str4;
        this.anonymous = z;
    }

    public static /* synthetic */ PostUserBean copy$default(PostUserBean postUserBean, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postUserBean.avatar;
        }
        if ((i & 2) != 0) {
            str2 = postUserBean.nickName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = postUserBean.avatarFrameImgUrl;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = postUserBean.appUserCode;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = postUserBean.anonymous;
        }
        return postUserBean.copy(str, str5, str6, str7, z);
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
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAnonymous() {
        return this.anonymous;
    }

    @NotNull
    public final PostUserBean copy(@NotNull String avatar, @NotNull String nickName, @NotNull String avatarFrameImgUrl, @NotNull String appUserCode, boolean anonymous) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        return new PostUserBean(avatar, nickName, avatarFrameImgUrl, appUserCode, anonymous);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostUserBean)) {
            return false;
        }
        PostUserBean postUserBean = (PostUserBean) other;
        return Intrinsics.areEqual(this.avatar, postUserBean.avatar) && Intrinsics.areEqual(this.nickName, postUserBean.nickName) && Intrinsics.areEqual(this.avatarFrameImgUrl, postUserBean.avatarFrameImgUrl) && Intrinsics.areEqual(this.appUserCode, postUserBean.appUserCode) && this.anonymous == postUserBean.anonymous;
    }

    public final boolean getAnonymous() {
        return this.anonymous;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + this.appUserCode.hashCode()) * 31;
        boolean z = this.anonymous;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "PostUserBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", appUserCode=" + this.appUserCode + ", anonymous=" + this.anonymous + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.avatar);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatarFrameImgUrl);
        parcel.writeString(this.appUserCode);
        parcel.writeInt(this.anonymous ? 1 : 0);
    }

    public /* synthetic */ PostUserBean(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? false : z);
    }
}

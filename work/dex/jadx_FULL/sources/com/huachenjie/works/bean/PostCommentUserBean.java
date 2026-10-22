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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/bean/PostCommentUserBean;", "Landroid/os/Parcelable;", "avatar", "", UserConstants.USER_PARAMS.b, "appUserCode", "avatarFrameImgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getAvatarFrameImgUrl", "getNickName", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostCommentUserBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PostCommentUserBean> CREATOR = new Creator();

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private final String nickName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PostCommentUserBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostCommentUserBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PostCommentUserBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostCommentUserBean[] newArray(int i) {
            return new PostCommentUserBean[i];
        }
    }

    public PostCommentUserBean() {
        this(null, null, null, null, 15, null);
    }

    public PostCommentUserBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "appUserCode");
        Intrinsics.checkNotNullParameter(str4, "avatarFrameImgUrl");
        this.avatar = str;
        this.nickName = str2;
        this.appUserCode = str3;
        this.avatarFrameImgUrl = str4;
    }

    public static /* synthetic */ PostCommentUserBean copy$default(PostCommentUserBean postCommentUserBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postCommentUserBean.avatar;
        }
        if ((i & 2) != 0) {
            str2 = postCommentUserBean.nickName;
        }
        if ((i & 4) != 0) {
            str3 = postCommentUserBean.appUserCode;
        }
        if ((i & 8) != 0) {
            str4 = postCommentUserBean.avatarFrameImgUrl;
        }
        return postCommentUserBean.copy(str, str2, str3, str4);
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
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final PostCommentUserBean copy(@NotNull String avatar, @NotNull String nickName, @NotNull String appUserCode, @NotNull String avatarFrameImgUrl) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        return new PostCommentUserBean(avatar, nickName, appUserCode, avatarFrameImgUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostCommentUserBean)) {
            return false;
        }
        PostCommentUserBean postCommentUserBean = (PostCommentUserBean) other;
        return Intrinsics.areEqual(this.avatar, postCommentUserBean.avatar) && Intrinsics.areEqual(this.nickName, postCommentUserBean.nickName) && Intrinsics.areEqual(this.appUserCode, postCommentUserBean.appUserCode) && Intrinsics.areEqual(this.avatarFrameImgUrl, postCommentUserBean.avatarFrameImgUrl);
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

    public int hashCode() {
        return (((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.appUserCode.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostCommentUserBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", appUserCode=" + this.appUserCode + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.avatar);
        parcel.writeString(this.nickName);
        parcel.writeString(this.appUserCode);
        parcel.writeString(this.avatarFrameImgUrl);
    }

    public /* synthetic */ PostCommentUserBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}

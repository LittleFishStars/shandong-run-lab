package com.huachenjie.works.bean.comment;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/works/bean/comment/CommentUserBean;", "", "avatar", "", UserConstants.USER_PARAMS.b, "appUserCode", "avatarFrameImgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getAvatarFrameImgUrl", "getNickName", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommentUserBean {

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @Nullable
    private final String avatarFrameImgUrl;

    @NotNull
    private final String nickName;

    public CommentUserBean() {
        this(null, null, null, null, 15, null);
    }

    public CommentUserBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "appUserCode");
        this.avatar = str;
        this.nickName = str2;
        this.appUserCode = str3;
        this.avatarFrameImgUrl = str4;
    }

    public static /* synthetic */ CommentUserBean copy$default(CommentUserBean commentUserBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentUserBean.avatar;
        }
        if ((i & 2) != 0) {
            str2 = commentUserBean.nickName;
        }
        if ((i & 4) != 0) {
            str3 = commentUserBean.appUserCode;
        }
        if ((i & 8) != 0) {
            str4 = commentUserBean.avatarFrameImgUrl;
        }
        return commentUserBean.copy(str, str2, str3, str4);
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

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final CommentUserBean copy(@NotNull String avatar, @NotNull String nickName, @NotNull String appUserCode, @Nullable String avatarFrameImgUrl) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        return new CommentUserBean(avatar, nickName, appUserCode, avatarFrameImgUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentUserBean)) {
            return false;
        }
        CommentUserBean commentUserBean = (CommentUserBean) other;
        return Intrinsics.areEqual(this.avatar, commentUserBean.avatar) && Intrinsics.areEqual(this.nickName, commentUserBean.nickName) && Intrinsics.areEqual(this.appUserCode, commentUserBean.appUserCode) && Intrinsics.areEqual(this.avatarFrameImgUrl, commentUserBean.avatarFrameImgUrl);
    }

    @NotNull
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public int hashCode() {
        int iHashCode = ((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.appUserCode.hashCode()) * 31;
        String str = this.avatarFrameImgUrl;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "CommentUserBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", appUserCode=" + this.appUserCode + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ')';
    }

    public /* synthetic */ CommentUserBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}

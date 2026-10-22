package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/college/bean/PostUserBean;", "", "anonymous", "", "appUserCode", "", "avatar", "avatarFrameImgUrl", UserConstants.USER_PARAMS.b, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnonymous", "()Z", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getAvatarFrameImgUrl", "getNickName", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostUserBean {
    private final boolean anonymous;

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private final String nickName;

    public PostUserBean() {
        this(false, null, null, null, null, 31, null);
    }

    public PostUserBean(boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "appUserCode");
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str4, UserConstants.USER_PARAMS.b);
        this.anonymous = z;
        this.appUserCode = str;
        this.avatar = str2;
        this.avatarFrameImgUrl = str3;
        this.nickName = str4;
    }

    public static /* synthetic */ PostUserBean copy$default(PostUserBean postUserBean, boolean z, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = postUserBean.anonymous;
        }
        if ((i & 2) != 0) {
            str = postUserBean.appUserCode;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = postUserBean.avatar;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = postUserBean.avatarFrameImgUrl;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = postUserBean.nickName;
        }
        return postUserBean.copy(z, str5, str6, str7, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getAnonymous() {
        return this.anonymous;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final PostUserBean copy(boolean anonymous, @NotNull String appUserCode, @NotNull String avatar, @NotNull String avatarFrameImgUrl, @NotNull String nickName) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        return new PostUserBean(anonymous, appUserCode, avatar, avatarFrameImgUrl, nickName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostUserBean)) {
            return false;
        }
        PostUserBean postUserBean = (PostUserBean) other;
        return this.anonymous == postUserBean.anonymous && Intrinsics.areEqual(this.appUserCode, postUserBean.appUserCode) && Intrinsics.areEqual(this.avatar, postUserBean.avatar) && Intrinsics.areEqual(this.avatarFrameImgUrl, postUserBean.avatarFrameImgUrl) && Intrinsics.areEqual(this.nickName, postUserBean.nickName);
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
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.anonymous;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((r0 * 31) + this.appUserCode.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + this.nickName.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostUserBean(anonymous=" + this.anonymous + ", appUserCode=" + this.appUserCode + ", avatar=" + this.avatar + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", nickName=" + this.nickName + ')';
    }

    public /* synthetic */ PostUserBean(boolean z, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) == 0 ? str4 : "");
    }
}

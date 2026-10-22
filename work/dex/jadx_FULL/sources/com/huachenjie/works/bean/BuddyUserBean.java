package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/bean/BuddyUserBean;", "", "appUserCode", "", "avatar", UserConstants.USER_PARAMS.b, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserCode", "()Ljava/lang/String;", "getAvatar", "getNickName", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyUserBean {

    @NotNull
    private final String appUserCode;

    @NotNull
    private final String avatar;

    @NotNull
    private final String nickName;

    public BuddyUserBean() {
        this(null, null, null, 7, null);
    }

    public BuddyUserBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "appUserCode");
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, UserConstants.USER_PARAMS.b);
        this.appUserCode = str;
        this.avatar = str2;
        this.nickName = str3;
    }

    public static /* synthetic */ BuddyUserBean copy$default(BuddyUserBean buddyUserBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buddyUserBean.appUserCode;
        }
        if ((i & 2) != 0) {
            str2 = buddyUserBean.avatar;
        }
        if ((i & 4) != 0) {
            str3 = buddyUserBean.nickName;
        }
        return buddyUserBean.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppUserCode() {
        return this.appUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final BuddyUserBean copy(@NotNull String appUserCode, @NotNull String avatar, @NotNull String nickName) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        return new BuddyUserBean(appUserCode, avatar, nickName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyUserBean)) {
            return false;
        }
        BuddyUserBean buddyUserBean = (BuddyUserBean) other;
        return Intrinsics.areEqual(this.appUserCode, buddyUserBean.appUserCode) && Intrinsics.areEqual(this.avatar, buddyUserBean.avatar) && Intrinsics.areEqual(this.nickName, buddyUserBean.nickName);
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
        return (((this.appUserCode.hashCode() * 31) + this.avatar.hashCode()) * 31) + this.nickName.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyUserBean(appUserCode=" + this.appUserCode + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ')';
    }

    public /* synthetic */ BuddyUserBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}

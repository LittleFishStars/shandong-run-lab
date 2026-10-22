package com.huachenjie.channel.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0013HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006%"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelAdminBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "avatar", "", UserConstants.USER_PARAMS.b, "memberUserCode", "slogan", "avatarFrameImgUrl", "canCancel", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAvatar", "()Ljava/lang/String;", "getAvatarFrameImgUrl", "getCanCancel", "()Z", "setCanCancel", "(Z)V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getMemberUserCode", "getNickName", "getSlogan", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelAdminBean implements MultiItemEntity {

    @NotNull
    private final String avatar;

    @Nullable
    private final String avatarFrameImgUrl;
    private boolean canCancel;

    @NotNull
    private final String memberUserCode;

    @NotNull
    private final String nickName;

    @NotNull
    private final String slogan;

    public ChannelAdminBean() {
        this(null, null, null, null, null, false, 63, null);
    }

    public ChannelAdminBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "memberUserCode");
        Intrinsics.checkNotNullParameter(str4, "slogan");
        this.avatar = str;
        this.nickName = str2;
        this.memberUserCode = str3;
        this.slogan = str4;
        this.avatarFrameImgUrl = str5;
        this.canCancel = z;
    }

    public static /* synthetic */ ChannelAdminBean copy$default(ChannelAdminBean channelAdminBean, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelAdminBean.avatar;
        }
        if ((i & 2) != 0) {
            str2 = channelAdminBean.nickName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = channelAdminBean.memberUserCode;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = channelAdminBean.slogan;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = channelAdminBean.avatarFrameImgUrl;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            z = channelAdminBean.canCancel;
        }
        return channelAdminBean.copy(str, str6, str7, str8, str9, z);
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
    public final String getMemberUserCode() {
        return this.memberUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSlogan() {
        return this.slogan;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanCancel() {
        return this.canCancel;
    }

    @NotNull
    public final ChannelAdminBean copy(@NotNull String avatar, @NotNull String nickName, @NotNull String memberUserCode, @NotNull String slogan, @Nullable String avatarFrameImgUrl, boolean canCancel) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(memberUserCode, "memberUserCode");
        Intrinsics.checkNotNullParameter(slogan, "slogan");
        return new ChannelAdminBean(avatar, nickName, memberUserCode, slogan, avatarFrameImgUrl, canCancel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelAdminBean)) {
            return false;
        }
        ChannelAdminBean channelAdminBean = (ChannelAdminBean) other;
        return Intrinsics.areEqual(this.avatar, channelAdminBean.avatar) && Intrinsics.areEqual(this.nickName, channelAdminBean.nickName) && Intrinsics.areEqual(this.memberUserCode, channelAdminBean.memberUserCode) && Intrinsics.areEqual(this.slogan, channelAdminBean.slogan) && Intrinsics.areEqual(this.avatarFrameImgUrl, channelAdminBean.avatarFrameImgUrl) && this.canCancel == channelAdminBean.canCancel;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final boolean getCanCancel() {
        return this.canCancel;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    @NotNull
    public final String getMemberUserCode() {
        return this.memberUserCode;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getSlogan() {
        return this.slogan;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.memberUserCode.hashCode()) * 31) + this.slogan.hashCode()) * 31;
        String str = this.avatarFrameImgUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.canCancel;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final void setCanCancel(boolean z) {
        this.canCancel = z;
    }

    @NotNull
    public String toString() {
        return "ChannelAdminBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", memberUserCode=" + this.memberUserCode + ", slogan=" + this.slogan + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", canCancel=" + this.canCancel + ')';
    }

    public /* synthetic */ ChannelAdminBean(String str, String str2, String str3, String str4, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? false : z);
    }
}

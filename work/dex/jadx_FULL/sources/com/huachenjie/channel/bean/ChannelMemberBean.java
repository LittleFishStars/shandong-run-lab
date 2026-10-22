package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.ys8;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001(BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JG\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\r¨\u0006)"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelMemberBean;", "", "avatar", "", UserConstants.USER_PARAMS.b, "memberUserCode", "slogan", "avatarFrameImgUrl", "channelMemberType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "adminStr", "getAdminStr", "()Ljava/lang/String;", "getAvatar", "getAvatarFrameImgUrl", "getChannelMemberType", "()I", "setChannelMemberType", "(I)V", "getMemberUserCode", "getNickName", "presidentStr", "getPresidentStr", "setAsPresident", "", "getSetAsPresident", "()Z", "getSlogan", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "AdminType", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ChannelMemberBean {

    @NotNull
    private final String avatar;

    @Nullable
    private final String avatarFrameImgUrl;
    private int channelMemberType;

    @NotNull
    private final String memberUserCode;

    @NotNull
    private final String nickName;

    @NotNull
    private final String slogan;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelMemberBean$AdminType;", "", "Companion", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface AdminType {
        public static final int ADMIN = 1;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int PRESIDENT = 4;
        public static final int SUB_ADMIN = 2;
        public static final int UN_SET = 3;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/bean/ChannelMemberBean$AdminType$Companion;", "", "()V", "ADMIN", "", "PRESIDENT", "SUB_ADMIN", "UN_SET", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ADMIN = 1;
            public static final int PRESIDENT = 4;
            public static final int SUB_ADMIN = 2;
            public static final int UN_SET = 3;

            private Companion() {
            }
        }
    }

    public ChannelMemberBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, int i) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "memberUserCode");
        Intrinsics.checkNotNullParameter(str4, "slogan");
        this.avatar = str;
        this.nickName = str2;
        this.memberUserCode = str3;
        this.slogan = str4;
        this.avatarFrameImgUrl = str5;
        this.channelMemberType = i;
    }

    public static /* synthetic */ ChannelMemberBean copy$default(ChannelMemberBean channelMemberBean, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelMemberBean.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = channelMemberBean.nickName;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = channelMemberBean.memberUserCode;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = channelMemberBean.slogan;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = channelMemberBean.avatarFrameImgUrl;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = channelMemberBean.channelMemberType;
        }
        return channelMemberBean.copy(str, str6, str7, str8, str9, i);
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
    public final int getChannelMemberType() {
        return this.channelMemberType;
    }

    @NotNull
    public final ChannelMemberBean copy(@NotNull String avatar, @NotNull String nickName, @NotNull String memberUserCode, @NotNull String slogan, @Nullable String avatarFrameImgUrl, int channelMemberType) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(memberUserCode, "memberUserCode");
        Intrinsics.checkNotNullParameter(slogan, "slogan");
        return new ChannelMemberBean(avatar, nickName, memberUserCode, slogan, avatarFrameImgUrl, channelMemberType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMemberBean)) {
            return false;
        }
        ChannelMemberBean channelMemberBean = (ChannelMemberBean) other;
        return Intrinsics.areEqual(this.avatar, channelMemberBean.avatar) && Intrinsics.areEqual(this.nickName, channelMemberBean.nickName) && Intrinsics.areEqual(this.memberUserCode, channelMemberBean.memberUserCode) && Intrinsics.areEqual(this.slogan, channelMemberBean.slogan) && Intrinsics.areEqual(this.avatarFrameImgUrl, channelMemberBean.avatarFrameImgUrl) && this.channelMemberType == channelMemberBean.channelMemberType;
    }

    @NotNull
    public final String getAdminStr() {
        int i = this.channelMemberType;
        if (i == 1) {
            String strE = ys8.e(R.string.channel_my_channel_host);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.channel_my_channel_host)");
            return strE;
        }
        if (i != 2) {
            String strE2 = ys8.e(R.string.channel_manage_set_sub_admin);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.channel_manage_set_sub_admin)");
            return strE2;
        }
        String strE3 = ys8.e(R.string.channel_manage_sub_admin);
        Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.channel_manage_sub_admin)");
        return strE3;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public final int getChannelMemberType() {
        return this.channelMemberType;
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
    public final String getPresidentStr() {
        int i = this.channelMemberType;
        if (i != 1) {
            return i != 4 ? "设为社长" : "社长";
        }
        String strE = ys8.e(R.string.channel_my_channel_host);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.channel_my_channel_host)");
        return strE;
    }

    public final boolean getSetAsPresident() {
        int i = this.channelMemberType;
        return (i == 1 || i == 4) ? false : true;
    }

    @NotNull
    public final String getSlogan() {
        return this.slogan;
    }

    public int hashCode() {
        int iHashCode = ((((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.memberUserCode.hashCode()) * 31) + this.slogan.hashCode()) * 31;
        String str = this.avatarFrameImgUrl;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.channelMemberType);
    }

    public final void setChannelMemberType(int i) {
        this.channelMemberType = i;
    }

    @NotNull
    public String toString() {
        return "ChannelMemberBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", memberUserCode=" + this.memberUserCode + ", slogan=" + this.slogan + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", channelMemberType=" + this.channelMemberType + ')';
    }

    public /* synthetic */ ChannelMemberBean(String str, String str2, String str3, String str4, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, i);
    }
}

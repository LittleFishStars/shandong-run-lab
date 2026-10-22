package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003J{\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\nHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00068"}, d2 = {"Lcom/huachenjie/channel/bean/FriendApplyBean;", "", UserConstants.USER_PARAMS.b, "", "avatar", "fromUserCode", "accid", "fromAccid", "avatarFrameImgUrl", "status", "", "applyMsg", "closeContent", "", "expandContent", "textExpand", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)V", "getAccid", "()Ljava/lang/String;", "getApplyMsg", "getAvatar", "getAvatarFrameImgUrl", "getCloseContent", "()Ljava/lang/CharSequence;", "setCloseContent", "(Ljava/lang/CharSequence;)V", "getExpandContent", "setExpandContent", "getFromAccid", "getFromUserCode", "getNickName", "getStatus", "()I", "setStatus", "(I)V", "getTextExpand", "()Z", "setTextExpand", "(Z)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FriendApplyBean {

    @NotNull
    private final String accid;

    @NotNull
    private final String applyMsg;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @Nullable
    private CharSequence closeContent;

    @Nullable
    private CharSequence expandContent;

    @NotNull
    private final String fromAccid;

    @NotNull
    private final String fromUserCode;

    @NotNull
    private final String nickName;
    private int status;
    private boolean textExpand;

    public FriendApplyBean() {
        this(null, null, null, null, null, null, 0, null, null, null, false, 2047, null);
    }

    public FriendApplyBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i, @NotNull String str7, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(str, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, "fromUserCode");
        Intrinsics.checkNotNullParameter(str4, "accid");
        Intrinsics.checkNotNullParameter(str5, "fromAccid");
        Intrinsics.checkNotNullParameter(str6, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str7, "applyMsg");
        this.nickName = str;
        this.avatar = str2;
        this.fromUserCode = str3;
        this.accid = str4;
        this.fromAccid = str5;
        this.avatarFrameImgUrl = str6;
        this.status = i;
        this.applyMsg = str7;
        this.closeContent = charSequence;
        this.expandContent = charSequence2;
        this.textExpand = z;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final CharSequence getExpandContent() {
        return this.expandContent;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getTextExpand() {
        return this.textExpand;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFromUserCode() {
        return this.fromUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAccid() {
        return this.accid;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFromAccid() {
        return this.fromAccid;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getApplyMsg() {
        return this.applyMsg;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CharSequence getCloseContent() {
        return this.closeContent;
    }

    @NotNull
    public final FriendApplyBean copy(@NotNull String nickName, @NotNull String avatar, @NotNull String fromUserCode, @NotNull String accid, @NotNull String fromAccid, @NotNull String avatarFrameImgUrl, int status, @NotNull String applyMsg, @Nullable CharSequence closeContent, @Nullable CharSequence expandContent, boolean textExpand) {
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(fromUserCode, "fromUserCode");
        Intrinsics.checkNotNullParameter(accid, "accid");
        Intrinsics.checkNotNullParameter(fromAccid, "fromAccid");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(applyMsg, "applyMsg");
        return new FriendApplyBean(nickName, avatar, fromUserCode, accid, fromAccid, avatarFrameImgUrl, status, applyMsg, closeContent, expandContent, textExpand);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendApplyBean)) {
            return false;
        }
        FriendApplyBean friendApplyBean = (FriendApplyBean) other;
        return Intrinsics.areEqual(this.nickName, friendApplyBean.nickName) && Intrinsics.areEqual(this.avatar, friendApplyBean.avatar) && Intrinsics.areEqual(this.fromUserCode, friendApplyBean.fromUserCode) && Intrinsics.areEqual(this.accid, friendApplyBean.accid) && Intrinsics.areEqual(this.fromAccid, friendApplyBean.fromAccid) && Intrinsics.areEqual(this.avatarFrameImgUrl, friendApplyBean.avatarFrameImgUrl) && this.status == friendApplyBean.status && Intrinsics.areEqual(this.applyMsg, friendApplyBean.applyMsg) && Intrinsics.areEqual(this.closeContent, friendApplyBean.closeContent) && Intrinsics.areEqual(this.expandContent, friendApplyBean.expandContent) && this.textExpand == friendApplyBean.textExpand;
    }

    @NotNull
    public final String getAccid() {
        return this.accid;
    }

    @NotNull
    public final String getApplyMsg() {
        return this.applyMsg;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    @Nullable
    public final CharSequence getCloseContent() {
        return this.closeContent;
    }

    @Nullable
    public final CharSequence getExpandContent() {
        return this.expandContent;
    }

    @NotNull
    public final String getFromAccid() {
        return this.fromAccid;
    }

    @NotNull
    public final String getFromUserCode() {
        return this.fromUserCode;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean getTextExpand() {
        return this.textExpand;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.nickName.hashCode() * 31) + this.avatar.hashCode()) * 31) + this.fromUserCode.hashCode()) * 31) + this.accid.hashCode()) * 31) + this.fromAccid.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + Integer.hashCode(this.status)) * 31) + this.applyMsg.hashCode()) * 31;
        CharSequence charSequence = this.closeContent;
        int iHashCode2 = (iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.expandContent;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        boolean z = this.textExpand;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final void setCloseContent(@Nullable CharSequence charSequence) {
        this.closeContent = charSequence;
    }

    public final void setExpandContent(@Nullable CharSequence charSequence) {
        this.expandContent = charSequence;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTextExpand(boolean z) {
        this.textExpand = z;
    }

    @NotNull
    public String toString() {
        return "FriendApplyBean(nickName=" + this.nickName + ", avatar=" + this.avatar + ", fromUserCode=" + this.fromUserCode + ", accid=" + this.accid + ", fromAccid=" + this.fromAccid + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", status=" + this.status + ", applyMsg=" + this.applyMsg + ", closeContent=" + ((Object) this.closeContent) + ", expandContent=" + ((Object) this.expandContent) + ", textExpand=" + this.textExpand + ')';
    }

    public /* synthetic */ FriendApplyBean(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? 0 : i, (i2 & 128) == 0 ? str7 : "", (i2 & 256) != 0 ? null : charSequence, (i2 & 512) == 0 ? charSequence2 : null, (i2 & 1024) == 0 ? z : false);
    }
}

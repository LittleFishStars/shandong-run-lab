package com.huachenjie.channel.bean.notify;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import com.huachenjie.common.constants.UserConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.yj7;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010:\u001a\u00020\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\u0006\u0010<\u001a\u00020\rJ\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016¨\u0006?"}, d2 = {"Lcom/huachenjie/channel/bean/notify/NotifyFavoritesBean;", "", "avatar", "", "favorType", "", UserConstants.USER_PARAMS.b, "coverImg", "favorUserCode", "avatarFrameImgUrl", "messageTime", "", "readFlag", "", RemoteMessageConst.MSGID, yj7.g.WORKS_NO, yj7.g.BROADCAST_QUOTE_NO, "broadcastName", "postNo", "postLabel", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getAvatarFrameImgUrl", "getBroadcastName", "getCoverImg", "getFavorType", "()I", "getFavorUserCode", "getMessageTime", "()J", "getMsgId", "getNickName", "getPostLabel", "getPostNo", "getQuoteNo", "getReadFlag", "()Z", "setReadFlag", "(Z)V", "getWorksNo", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "formatterContent", "hashCode", "showFavorType", "toString", "Companion", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NotifyFavoritesBean {
    public static final int TYPE_COLLECT = 2;
    public static final int TYPE_LIKE = 1;

    @NotNull
    private final String avatar;

    @NotNull
    private final String avatarFrameImgUrl;

    @NotNull
    private final String broadcastName;

    @NotNull
    private final String coverImg;
    private final int favorType;

    @NotNull
    private final String favorUserCode;
    private final long messageTime;

    @NotNull
    private final String msgId;

    @NotNull
    private final String nickName;

    @NotNull
    private final String postLabel;

    @NotNull
    private final String postNo;

    @NotNull
    private final String quoteNo;
    private boolean readFlag;

    @NotNull
    private final String worksNo;

    public NotifyFavoritesBean() {
        this(null, 0, null, null, null, null, 0L, false, null, null, null, null, null, null, 16383, null);
    }

    public NotifyFavoritesBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, boolean z, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str3, "coverImg");
        Intrinsics.checkNotNullParameter(str4, "favorUserCode");
        Intrinsics.checkNotNullParameter(str5, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(str6, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(str7, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(str8, yj7.g.BROADCAST_QUOTE_NO);
        Intrinsics.checkNotNullParameter(str9, "broadcastName");
        Intrinsics.checkNotNullParameter(str10, "postNo");
        Intrinsics.checkNotNullParameter(str11, "postLabel");
        this.avatar = str;
        this.favorType = i;
        this.nickName = str2;
        this.coverImg = str3;
        this.favorUserCode = str4;
        this.avatarFrameImgUrl = str5;
        this.messageTime = j;
        this.readFlag = z;
        this.msgId = str6;
        this.worksNo = str7;
        this.quoteNo = str8;
        this.broadcastName = str9;
        this.postNo = str10;
        this.postLabel = str11;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getWorksNo() {
        return this.worksNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getQuoteNo() {
        return this.quoteNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBroadcastName() {
        return this.broadcastName;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPostNo() {
        return this.postNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPostLabel() {
        return this.postLabel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFavorType() {
        return this.favorType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFavorUserCode() {
        return this.favorUserCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getMessageTime() {
        return this.messageTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final NotifyFavoritesBean copy(@NotNull String avatar, int favorType, @NotNull String nickName, @NotNull String coverImg, @NotNull String favorUserCode, @NotNull String avatarFrameImgUrl, long messageTime, boolean readFlag, @NotNull String msgId, @NotNull String worksNo, @NotNull String quoteNo, @NotNull String broadcastName, @NotNull String postNo, @NotNull String postLabel) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(favorUserCode, "favorUserCode");
        Intrinsics.checkNotNullParameter(avatarFrameImgUrl, "avatarFrameImgUrl");
        Intrinsics.checkNotNullParameter(msgId, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        Intrinsics.checkNotNullParameter(quoteNo, yj7.g.BROADCAST_QUOTE_NO);
        Intrinsics.checkNotNullParameter(broadcastName, "broadcastName");
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(postLabel, "postLabel");
        return new NotifyFavoritesBean(avatar, favorType, nickName, coverImg, favorUserCode, avatarFrameImgUrl, messageTime, readFlag, msgId, worksNo, quoteNo, broadcastName, postNo, postLabel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyFavoritesBean)) {
            return false;
        }
        NotifyFavoritesBean notifyFavoritesBean = (NotifyFavoritesBean) other;
        return Intrinsics.areEqual(this.avatar, notifyFavoritesBean.avatar) && this.favorType == notifyFavoritesBean.favorType && Intrinsics.areEqual(this.nickName, notifyFavoritesBean.nickName) && Intrinsics.areEqual(this.coverImg, notifyFavoritesBean.coverImg) && Intrinsics.areEqual(this.favorUserCode, notifyFavoritesBean.favorUserCode) && Intrinsics.areEqual(this.avatarFrameImgUrl, notifyFavoritesBean.avatarFrameImgUrl) && this.messageTime == notifyFavoritesBean.messageTime && this.readFlag == notifyFavoritesBean.readFlag && Intrinsics.areEqual(this.msgId, notifyFavoritesBean.msgId) && Intrinsics.areEqual(this.worksNo, notifyFavoritesBean.worksNo) && Intrinsics.areEqual(this.quoteNo, notifyFavoritesBean.quoteNo) && Intrinsics.areEqual(this.broadcastName, notifyFavoritesBean.broadcastName) && Intrinsics.areEqual(this.postNo, notifyFavoritesBean.postNo) && Intrinsics.areEqual(this.postLabel, notifyFavoritesBean.postLabel);
    }

    @NotNull
    public final String formatterContent() {
        if (!TextUtils.isEmpty(this.quoteNo)) {
            String strF = ys8.f(R.string.channel_broad_build_like, this.broadcastName);
            Intrinsics.checkNotNullExpressionValue(strF, "{\n            StringUtil… broadcastName)\n        }");
            return strF;
        }
        if (TextUtils.isEmpty(this.postNo)) {
            String strE = ys8.e(this.favorType == 1 ? R.string.channel_notify_work_like : R.string.channel_notify_work_collected);
            Intrinsics.checkNotNullExpressionValue(strE, "{\n            StringUtil…work_collected)\n        }");
            return strE;
        }
        String strF2 = ys8.f(R.string.channel_post_like, this.postLabel);
        Intrinsics.checkNotNullExpressionValue(strF2, "{\n            StringUtil…ike, postLabel)\n        }");
        return strF2;
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
    public final String getBroadcastName() {
        return this.broadcastName;
    }

    @NotNull
    public final String getCoverImg() {
        return this.coverImg;
    }

    public final int getFavorType() {
        return this.favorType;
    }

    @NotNull
    public final String getFavorUserCode() {
        return this.favorUserCode;
    }

    public final long getMessageTime() {
        return this.messageTime;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public final String getPostLabel() {
        return this.postLabel;
    }

    @NotNull
    public final String getPostNo() {
        return this.postNo;
    }

    @NotNull
    public final String getQuoteNo() {
        return this.quoteNo;
    }

    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    public final String getWorksNo() {
        return this.worksNo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.avatar.hashCode() * 31) + Integer.hashCode(this.favorType)) * 31) + this.nickName.hashCode()) * 31) + this.coverImg.hashCode()) * 31) + this.favorUserCode.hashCode()) * 31) + this.avatarFrameImgUrl.hashCode()) * 31) + Long.hashCode(this.messageTime)) * 31;
        boolean z = this.readFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((((iHashCode + r1) * 31) + this.msgId.hashCode()) * 31) + this.worksNo.hashCode()) * 31) + this.quoteNo.hashCode()) * 31) + this.broadcastName.hashCode()) * 31) + this.postNo.hashCode()) * 31) + this.postLabel.hashCode();
    }

    public final void setReadFlag(boolean z) {
        this.readFlag = z;
    }

    public final boolean showFavorType() {
        return (TextUtils.isEmpty(this.quoteNo) && TextUtils.isEmpty(this.worksNo)) ? false : true;
    }

    @NotNull
    public String toString() {
        return "NotifyFavoritesBean(avatar=" + this.avatar + ", favorType=" + this.favorType + ", nickName=" + this.nickName + ", coverImg=" + this.coverImg + ", favorUserCode=" + this.favorUserCode + ", avatarFrameImgUrl=" + this.avatarFrameImgUrl + ", messageTime=" + this.messageTime + ", readFlag=" + this.readFlag + ", msgId=" + this.msgId + ", worksNo=" + this.worksNo + ", quoteNo=" + this.quoteNo + ", broadcastName=" + this.broadcastName + ", postNo=" + this.postNo + ", postLabel=" + this.postLabel + ')';
    }

    public /* synthetic */ NotifyFavoritesBean(String str, int i, String str2, String str3, String str4, String str5, long j, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? 0L : j, (i2 & 128) == 0 ? z : false, (i2 & 256) != 0 ? "" : str6, (i2 & 512) != 0 ? "" : str7, (i2 & 1024) != 0 ? "" : str8, (i2 & 2048) != 0 ? "" : str9, (i2 & 4096) != 0 ? "" : str10, (i2 & 8192) == 0 ? str11 : "");
    }
}

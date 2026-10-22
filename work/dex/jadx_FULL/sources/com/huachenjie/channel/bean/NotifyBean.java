package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0005J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/channel/bean/NotifyBean;", "", "messageType", "", "content", "", "redDot", "", "(ILjava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getMessageType", "()I", "getRedDot", "()Z", "setRedDot", "(Z)V", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "formatIcon", "formatName", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class NotifyBean {

    @NotNull
    private String content;
    private final int messageType;
    private boolean redDot;

    public NotifyBean() {
        this(0, null, false, 7, null);
    }

    public NotifyBean(int i, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.messageType = i;
        this.content = str;
        this.redDot = z;
    }

    public static /* synthetic */ NotifyBean copy$default(NotifyBean notifyBean, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = notifyBean.messageType;
        }
        if ((i2 & 2) != 0) {
            str = notifyBean.content;
        }
        if ((i2 & 4) != 0) {
            z = notifyBean.redDot;
        }
        return notifyBean.copy(i, str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMessageType() {
        return this.messageType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRedDot() {
        return this.redDot;
    }

    @NotNull
    public final NotifyBean copy(int messageType, @NotNull String content, boolean redDot) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new NotifyBean(messageType, content, redDot);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotifyBean)) {
            return false;
        }
        NotifyBean notifyBean = (NotifyBean) other;
        return this.messageType == notifyBean.messageType && Intrinsics.areEqual(this.content, notifyBean.content) && this.redDot == notifyBean.redDot;
    }

    public final int formatIcon() {
        switch (this.messageType) {
            case 2:
                return R.drawable.channel_ic_notify_world_letters;
            case 3:
            default:
                return R.drawable.channel_ic_notify_post;
            case 4:
                return R.drawable.channel_ic_notify_like_collect;
            case 5:
                return R.drawable.channel_ic_notify_comment_at;
            case 6:
                return R.drawable.channel_ic_notify_fans;
            case 7:
                return R.drawable.channel_ic_notify_mailbox;
            case 8:
                return R.drawable.channel_ic_notify_friend_apply;
            case 9:
                return R.drawable.channel_ic_notify_broadcast;
            case 10:
                return R.drawable.channel_ic_notify_post;
            case 11:
                return R.drawable.channel_ic_notify_shopping;
        }
    }

    @NotNull
    public final String formatName() {
        switch (this.messageType) {
            case 2:
                return "世界信件";
            case 3:
            default:
                return "";
            case 4:
                return "点赞收藏";
            case 5:
                return "评论和@我";
            case 6:
                return "粉丝";
            case 7:
                return "闪信箱";
            case 8:
                return "新朋友";
            case 9:
                return "广播楼";
            case 10:
                return "帖子消息";
            case 11:
                return "购物消息";
        }
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.messageType) * 31) + this.content.hashCode()) * 31;
        boolean z = this.redDot;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setRedDot(boolean z) {
        this.redDot = z;
    }

    @NotNull
    public String toString() {
        return "NotifyBean(messageType=" + this.messageType + ", content=" + this.content + ", redDot=" + this.redDot + ')';
    }

    public /* synthetic */ NotifyBean(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z);
    }
}

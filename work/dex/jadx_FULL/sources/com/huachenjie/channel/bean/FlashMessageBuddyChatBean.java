package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0010HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006#"}, d2 = {"Lcom/huachenjie/channel/bean/FlashMessageBuddyChatBean;", "Lcom/huachenjie/channel/bean/FlashMessageItem;", RemoteMessageConst.Notification.ICON, "", "redDot", "", "title", "content", "buddyCode", "roomId", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuddyCode", "()Ljava/lang/String;", "getContent", "getIcon", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getRedDot", "()Z", "getRoomId", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlashMessageBuddyChatBean implements FlashMessageItem {

    @NotNull
    private final String buddyCode;

    @NotNull
    private final String content;

    @NotNull
    private final String icon;
    private final int itemType;
    private final boolean redDot;

    @NotNull
    private final String roomId;

    @NotNull
    private final String title;

    public FlashMessageBuddyChatBean() {
        this(null, false, null, null, null, null, 63, null);
    }

    public FlashMessageBuddyChatBean(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.ICON);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str4, "buddyCode");
        Intrinsics.checkNotNullParameter(str5, "roomId");
        this.icon = str;
        this.redDot = z;
        this.title = str2;
        this.content = str3;
        this.buddyCode = str4;
        this.roomId = str5;
        this.itemType = 1;
    }

    public static /* synthetic */ FlashMessageBuddyChatBean copy$default(FlashMessageBuddyChatBean flashMessageBuddyChatBean, String str, boolean z, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = flashMessageBuddyChatBean.icon;
        }
        if ((i & 2) != 0) {
            z = flashMessageBuddyChatBean.redDot;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = flashMessageBuddyChatBean.title;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = flashMessageBuddyChatBean.content;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = flashMessageBuddyChatBean.buddyCode;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = flashMessageBuddyChatBean.roomId;
        }
        return flashMessageBuddyChatBean.copy(str, z2, str6, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRedDot() {
        return this.redDot;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final FlashMessageBuddyChatBean copy(@NotNull String icon, boolean redDot, @NotNull String title, @NotNull String content, @NotNull String buddyCode, @NotNull String roomId) {
        Intrinsics.checkNotNullParameter(icon, RemoteMessageConst.Notification.ICON);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return new FlashMessageBuddyChatBean(icon, redDot, title, content, buddyCode, roomId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlashMessageBuddyChatBean)) {
            return false;
        }
        FlashMessageBuddyChatBean flashMessageBuddyChatBean = (FlashMessageBuddyChatBean) other;
        return Intrinsics.areEqual(this.icon, flashMessageBuddyChatBean.icon) && this.redDot == flashMessageBuddyChatBean.redDot && Intrinsics.areEqual(this.title, flashMessageBuddyChatBean.title) && Intrinsics.areEqual(this.content, flashMessageBuddyChatBean.content) && Intrinsics.areEqual(this.buddyCode, flashMessageBuddyChatBean.buddyCode) && Intrinsics.areEqual(this.roomId, flashMessageBuddyChatBean.roomId);
    }

    @NotNull
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    public int hashCode() {
        int iHashCode = this.icon.hashCode() * 31;
        boolean z = this.redDot;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((iHashCode + r1) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.buddyCode.hashCode()) * 31) + this.roomId.hashCode();
    }

    @NotNull
    public String toString() {
        return "FlashMessageBuddyChatBean(icon=" + this.icon + ", redDot=" + this.redDot + ", title=" + this.title + ", content=" + this.content + ", buddyCode=" + this.buddyCode + ", roomId=" + this.roomId + ')';
    }

    public /* synthetic */ FlashMessageBuddyChatBean(String str, boolean z, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5);
    }
}

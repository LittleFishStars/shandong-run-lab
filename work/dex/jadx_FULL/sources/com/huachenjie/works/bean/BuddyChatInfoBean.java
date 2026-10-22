package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/bean/BuddyChatInfoBean;", "", "buddyCode", "", "canEnter", "", "chatStatus", "memberCount", "roomID", "title", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V", "getBuddyCode", "()Ljava/lang/String;", "getCanEnter", "()I", "getChatStatus", "getMemberCount", "getRoomID", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyChatInfoBean {

    @NotNull
    private final String buddyCode;
    private final int canEnter;
    private final int chatStatus;
    private final int memberCount;

    @NotNull
    private final String roomID;

    @NotNull
    private final String title;

    public BuddyChatInfoBean() {
        this(null, 0, 0, 0, null, null, 63, null);
    }

    public BuddyChatInfoBean(@NotNull String str, int i, int i2, int i3, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "buddyCode");
        Intrinsics.checkNotNullParameter(str2, "roomID");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.buddyCode = str;
        this.canEnter = i;
        this.chatStatus = i2;
        this.memberCount = i3;
        this.roomID = str2;
        this.title = str3;
    }

    public static /* synthetic */ BuddyChatInfoBean copy$default(BuddyChatInfoBean buddyChatInfoBean, String str, int i, int i2, int i3, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = buddyChatInfoBean.buddyCode;
        }
        if ((i4 & 2) != 0) {
            i = buddyChatInfoBean.canEnter;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = buddyChatInfoBean.chatStatus;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = buddyChatInfoBean.memberCount;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            str2 = buddyChatInfoBean.roomID;
        }
        String str4 = str2;
        if ((i4 & 32) != 0) {
            str3 = buddyChatInfoBean.title;
        }
        return buddyChatInfoBean.copy(str, i5, i6, i7, str4, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCanEnter() {
        return this.canEnter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getChatStatus() {
        return this.chatStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRoomID() {
        return this.roomID;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final BuddyChatInfoBean copy(@NotNull String buddyCode, int canEnter, int chatStatus, int memberCount, @NotNull String roomID, @NotNull String title) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(roomID, "roomID");
        Intrinsics.checkNotNullParameter(title, "title");
        return new BuddyChatInfoBean(buddyCode, canEnter, chatStatus, memberCount, roomID, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyChatInfoBean)) {
            return false;
        }
        BuddyChatInfoBean buddyChatInfoBean = (BuddyChatInfoBean) other;
        return Intrinsics.areEqual(this.buddyCode, buddyChatInfoBean.buddyCode) && this.canEnter == buddyChatInfoBean.canEnter && this.chatStatus == buddyChatInfoBean.chatStatus && this.memberCount == buddyChatInfoBean.memberCount && Intrinsics.areEqual(this.roomID, buddyChatInfoBean.roomID) && Intrinsics.areEqual(this.title, buddyChatInfoBean.title);
    }

    @NotNull
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    public final int getCanEnter() {
        return this.canEnter;
    }

    public final int getChatStatus() {
        return this.chatStatus;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    @NotNull
    public final String getRoomID() {
        return this.roomID;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.buddyCode.hashCode() * 31) + Integer.hashCode(this.canEnter)) * 31) + Integer.hashCode(this.chatStatus)) * 31) + Integer.hashCode(this.memberCount)) * 31) + this.roomID.hashCode()) * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyChatInfoBean(buddyCode=" + this.buddyCode + ", canEnter=" + this.canEnter + ", chatStatus=" + this.chatStatus + ", memberCount=" + this.memberCount + ", roomID=" + this.roomID + ", title=" + this.title + ')';
    }

    public /* synthetic */ BuddyChatInfoBean(String str, int i, int i2, int i3, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) == 0 ? i3 : 0, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? "" : str3);
    }
}

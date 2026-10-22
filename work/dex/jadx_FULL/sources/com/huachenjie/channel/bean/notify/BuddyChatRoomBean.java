package com.huachenjie.channel.bean.notify;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/channel/bean/notify/BuddyChatRoomBean;", "", "buddyCode", "", "title", "description", "roomId", "creatorAvatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuddyCode", "()Ljava/lang/String;", "getCreatorAvatar", "getDescription", "getRoomId", "getTitle", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BuddyChatRoomBean {

    @NotNull
    private final String buddyCode;

    @NotNull
    private final String creatorAvatar;

    @NotNull
    private final String description;

    @NotNull
    private final String roomId;

    @NotNull
    private final String title;

    public BuddyChatRoomBean() {
        this(null, null, null, null, null, 31, null);
    }

    public BuddyChatRoomBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "buddyCode");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "roomId");
        Intrinsics.checkNotNullParameter(str5, "creatorAvatar");
        this.buddyCode = str;
        this.title = str2;
        this.description = str3;
        this.roomId = str4;
        this.creatorAvatar = str5;
    }

    public static /* synthetic */ BuddyChatRoomBean copy$default(BuddyChatRoomBean buddyChatRoomBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buddyChatRoomBean.buddyCode;
        }
        if ((i & 2) != 0) {
            str2 = buddyChatRoomBean.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = buddyChatRoomBean.description;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = buddyChatRoomBean.roomId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = buddyChatRoomBean.creatorAvatar;
        }
        return buddyChatRoomBean.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCreatorAvatar() {
        return this.creatorAvatar;
    }

    @NotNull
    public final BuddyChatRoomBean copy(@NotNull String buddyCode, @NotNull String title, @NotNull String description, @NotNull String roomId, @NotNull String creatorAvatar) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(creatorAvatar, "creatorAvatar");
        return new BuddyChatRoomBean(buddyCode, title, description, roomId, creatorAvatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuddyChatRoomBean)) {
            return false;
        }
        BuddyChatRoomBean buddyChatRoomBean = (BuddyChatRoomBean) other;
        return Intrinsics.areEqual(this.buddyCode, buddyChatRoomBean.buddyCode) && Intrinsics.areEqual(this.title, buddyChatRoomBean.title) && Intrinsics.areEqual(this.description, buddyChatRoomBean.description) && Intrinsics.areEqual(this.roomId, buddyChatRoomBean.roomId) && Intrinsics.areEqual(this.creatorAvatar, buddyChatRoomBean.creatorAvatar);
    }

    @NotNull
    public final String getBuddyCode() {
        return this.buddyCode;
    }

    @NotNull
    public final String getCreatorAvatar() {
        return this.creatorAvatar;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((this.buddyCode.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.creatorAvatar.hashCode();
    }

    @NotNull
    public String toString() {
        return "BuddyChatRoomBean(buddyCode=" + this.buddyCode + ", title=" + this.title + ", description=" + this.description + ", roomId=" + this.roomId + ", creatorAvatar=" + this.creatorAvatar + ')';
    }

    public /* synthetic */ BuddyChatRoomBean(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }
}

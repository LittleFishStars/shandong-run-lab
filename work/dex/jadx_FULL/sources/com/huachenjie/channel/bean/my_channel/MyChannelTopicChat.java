package com.huachenjie.channel.bean.my_channel;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006%"}, d2 = {"Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicChat;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", TeamMemberManageActivity.z, "", "subjectGroupName", "tid", "message", "messageCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getMessageCount", "()I", "setMessageCount", "(I)V", "getSubjectGroupName", "getSubjectGroupNo", "getTid", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyChannelTopicChat extends BaseNode {

    @NotNull
    private String message;
    private int messageCount;

    @NotNull
    private final String subjectGroupName;

    @NotNull
    private final String subjectGroupNo;

    @NotNull
    private final String tid;

    public MyChannelTopicChat() {
        this(null, null, null, null, 0, 31, null);
    }

    public /* synthetic */ MyChannelTopicChat(String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? 0 : i);
    }

    public static /* synthetic */ MyChannelTopicChat copy$default(MyChannelTopicChat myChannelTopicChat, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = myChannelTopicChat.subjectGroupNo;
        }
        if ((i2 & 2) != 0) {
            str2 = myChannelTopicChat.subjectGroupName;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = myChannelTopicChat.tid;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = myChannelTopicChat.message;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = myChannelTopicChat.messageCount;
        }
        return myChannelTopicChat.copy(str, str5, str6, str7, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectGroupNo() {
        return this.subjectGroupNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectGroupName() {
        return this.subjectGroupName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTid() {
        return this.tid;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMessageCount() {
        return this.messageCount;
    }

    @NotNull
    public final MyChannelTopicChat copy(@NotNull String subjectGroupNo, @NotNull String subjectGroupName, @NotNull String tid, @NotNull String message, int messageCount) {
        Intrinsics.checkNotNullParameter(subjectGroupNo, TeamMemberManageActivity.z);
        Intrinsics.checkNotNullParameter(subjectGroupName, "subjectGroupName");
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(message, "message");
        return new MyChannelTopicChat(subjectGroupNo, subjectGroupName, tid, message, messageCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyChannelTopicChat)) {
            return false;
        }
        MyChannelTopicChat myChannelTopicChat = (MyChannelTopicChat) other;
        return Intrinsics.areEqual(this.subjectGroupNo, myChannelTopicChat.subjectGroupNo) && Intrinsics.areEqual(this.subjectGroupName, myChannelTopicChat.subjectGroupName) && Intrinsics.areEqual(this.tid, myChannelTopicChat.tid) && Intrinsics.areEqual(this.message, myChannelTopicChat.message) && this.messageCount == myChannelTopicChat.messageCount;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getMessageCount() {
        return this.messageCount;
    }

    @NotNull
    public final String getSubjectGroupName() {
        return this.subjectGroupName;
    }

    @NotNull
    public final String getSubjectGroupNo() {
        return this.subjectGroupNo;
    }

    @NotNull
    public final String getTid() {
        return this.tid;
    }

    public int hashCode() {
        return (((((((this.subjectGroupNo.hashCode() * 31) + this.subjectGroupName.hashCode()) * 31) + this.tid.hashCode()) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.messageCount);
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setMessageCount(int i) {
        this.messageCount = i;
    }

    @NotNull
    public String toString() {
        return "MyChannelTopicChat(subjectGroupNo=" + this.subjectGroupNo + ", subjectGroupName=" + this.subjectGroupName + ", tid=" + this.tid + ", message=" + this.message + ", messageCount=" + this.messageCount + ')';
    }

    public MyChannelTopicChat(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i) {
        Intrinsics.checkNotNullParameter(str, TeamMemberManageActivity.z);
        Intrinsics.checkNotNullParameter(str2, "subjectGroupName");
        Intrinsics.checkNotNullParameter(str3, "tid");
        Intrinsics.checkNotNullParameter(str4, "message");
        this.subjectGroupNo = str;
        this.subjectGroupName = str2;
        this.tid = str3;
        this.message = str4;
        this.messageCount = i;
    }
}

package com.huachenjie.channel.bean.manage_topic_chat;

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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopicChat;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", TeamMemberManageActivity.z, "", "subjectGroupName", "tid", "teamCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "childNode", "", "getChildNode", "()Ljava/util/List;", "getSubjectGroupName", "()Ljava/lang/String;", "getSubjectGroupNo", "getTeamCount", "()I", "setTeamCount", "(I)V", "getTid", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ManageTopicChat extends BaseNode {

    @NotNull
    private final String subjectGroupName;

    @NotNull
    private final String subjectGroupNo;
    private int teamCount;

    @NotNull
    private final String tid;

    public ManageTopicChat() {
        this(null, null, null, 0, 15, null);
    }

    public /* synthetic */ ManageTopicChat(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i);
    }

    public static /* synthetic */ ManageTopicChat copy$default(ManageTopicChat manageTopicChat, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = manageTopicChat.subjectGroupNo;
        }
        if ((i2 & 2) != 0) {
            str2 = manageTopicChat.subjectGroupName;
        }
        if ((i2 & 4) != 0) {
            str3 = manageTopicChat.tid;
        }
        if ((i2 & 8) != 0) {
            i = manageTopicChat.teamCount;
        }
        return manageTopicChat.copy(str, str2, str3, i);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    public final ManageTopicChat copy(@NotNull String subjectGroupNo, @NotNull String subjectGroupName, @NotNull String tid, int teamCount) {
        Intrinsics.checkNotNullParameter(subjectGroupNo, TeamMemberManageActivity.z);
        Intrinsics.checkNotNullParameter(subjectGroupName, "subjectGroupName");
        Intrinsics.checkNotNullParameter(tid, "tid");
        return new ManageTopicChat(subjectGroupNo, subjectGroupName, tid, teamCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageTopicChat)) {
            return false;
        }
        ManageTopicChat manageTopicChat = (ManageTopicChat) other;
        return Intrinsics.areEqual(this.subjectGroupNo, manageTopicChat.subjectGroupNo) && Intrinsics.areEqual(this.subjectGroupName, manageTopicChat.subjectGroupName) && Intrinsics.areEqual(this.tid, manageTopicChat.tid) && this.teamCount == manageTopicChat.teamCount;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    @NotNull
    public final String getSubjectGroupName() {
        return this.subjectGroupName;
    }

    @NotNull
    public final String getSubjectGroupNo() {
        return this.subjectGroupNo;
    }

    public final int getTeamCount() {
        return this.teamCount;
    }

    @NotNull
    public final String getTid() {
        return this.tid;
    }

    public int hashCode() {
        return (((((this.subjectGroupNo.hashCode() * 31) + this.subjectGroupName.hashCode()) * 31) + this.tid.hashCode()) * 31) + Integer.hashCode(this.teamCount);
    }

    public final void setTeamCount(int i) {
        this.teamCount = i;
    }

    @NotNull
    public String toString() {
        return "ManageTopicChat(subjectGroupNo=" + this.subjectGroupNo + ", subjectGroupName=" + this.subjectGroupName + ", tid=" + this.tid + ", teamCount=" + this.teamCount + ')';
    }

    public ManageTopicChat(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, TeamMemberManageActivity.z);
        Intrinsics.checkNotNullParameter(str2, "subjectGroupName");
        Intrinsics.checkNotNullParameter(str3, "tid");
        this.subjectGroupNo = str;
        this.subjectGroupName = str2;
        this.tid = str3;
        this.teamCount = i;
    }
}

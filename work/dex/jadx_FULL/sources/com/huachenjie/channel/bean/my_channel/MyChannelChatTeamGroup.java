package com.huachenjie.channel.bean.my_channel;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÂ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "teamGroupCode", "", "teamGroupTitle", "teamList", "", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode", "()Ljava/util/List;", "setChildNode", "(Ljava/util/List;)V", "getTeamGroupCode", "()Ljava/lang/String;", "getTeamGroupTitle", "setTeamGroupTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyChannelChatTeamGroup extends BaseExpandNode {

    @Nullable
    private List<BaseNode> childNode;

    @NotNull
    private final String teamGroupCode;

    @NotNull
    private String teamGroupTitle;

    @NotNull
    private final List<MyChannelChatTeam> teamList;

    public MyChannelChatTeamGroup() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ MyChannelChatTeamGroup(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    private final List<MyChannelChatTeam> component3() {
        return this.teamList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyChannelChatTeamGroup copy$default(MyChannelChatTeamGroup myChannelChatTeamGroup, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = myChannelChatTeamGroup.teamGroupCode;
        }
        if ((i & 2) != 0) {
            str2 = myChannelChatTeamGroup.teamGroupTitle;
        }
        if ((i & 4) != 0) {
            list = myChannelChatTeamGroup.teamList;
        }
        return myChannelChatTeamGroup.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeamGroupCode() {
        return this.teamGroupCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamGroupTitle() {
        return this.teamGroupTitle;
    }

    @NotNull
    public final MyChannelChatTeamGroup copy(@NotNull String teamGroupCode, @NotNull String teamGroupTitle, @NotNull List<MyChannelChatTeam> teamList) {
        Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
        Intrinsics.checkNotNullParameter(teamGroupTitle, "teamGroupTitle");
        Intrinsics.checkNotNullParameter(teamList, "teamList");
        return new MyChannelChatTeamGroup(teamGroupCode, teamGroupTitle, teamList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyChannelChatTeamGroup)) {
            return false;
        }
        MyChannelChatTeamGroup myChannelChatTeamGroup = (MyChannelChatTeamGroup) other;
        return Intrinsics.areEqual(this.teamGroupCode, myChannelChatTeamGroup.teamGroupCode) && Intrinsics.areEqual(this.teamGroupTitle, myChannelChatTeamGroup.teamGroupTitle) && Intrinsics.areEqual(this.teamList, myChannelChatTeamGroup.teamList);
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        if (this.childNode == null) {
            this.childNode = CollectionsKt.toMutableList(this.teamList);
        }
        return this.childNode;
    }

    @NotNull
    public final String getTeamGroupCode() {
        return this.teamGroupCode;
    }

    @NotNull
    public final String getTeamGroupTitle() {
        return this.teamGroupTitle;
    }

    public int hashCode() {
        return (((this.teamGroupCode.hashCode() * 31) + this.teamGroupTitle.hashCode()) * 31) + this.teamList.hashCode();
    }

    public void setChildNode(@Nullable List<BaseNode> list) {
        this.childNode = list;
    }

    public final void setTeamGroupTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teamGroupTitle = str;
    }

    @NotNull
    public String toString() {
        return "MyChannelChatTeamGroup(teamGroupCode=" + this.teamGroupCode + ", teamGroupTitle=" + this.teamGroupTitle + ", teamList=" + this.teamList + ')';
    }

    public MyChannelChatTeamGroup(@NotNull String str, @NotNull String str2, @NotNull List<MyChannelChatTeam> list) {
        Intrinsics.checkNotNullParameter(str, "teamGroupCode");
        Intrinsics.checkNotNullParameter(str2, "teamGroupTitle");
        Intrinsics.checkNotNullParameter(list, "teamList");
        this.teamGroupCode = str;
        this.teamGroupTitle = str2;
        this.teamList = list;
    }
}

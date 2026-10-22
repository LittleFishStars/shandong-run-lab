package com.huachenjie.channel.bean.manage_topic_chat;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.yj7;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopic;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", yj7.b.SUBJECT_NO, "", "subjectName", "subjectGroupList", "", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopicChat;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode", "()Ljava/util/List;", "setChildNode", "(Ljava/util/List;)V", "getSubjectGroupList", "getSubjectName", "()Ljava/lang/String;", "getSubjectNo", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ManageTopic extends BaseExpandNode {

    @Nullable
    private List<BaseNode> childNode;

    @NotNull
    private final List<ManageTopicChat> subjectGroupList;

    @NotNull
    private final String subjectName;

    @NotNull
    private final String subjectNo;

    public ManageTopic() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ ManageTopic(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ManageTopic copy$default(ManageTopic manageTopic, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = manageTopic.subjectNo;
        }
        if ((i & 2) != 0) {
            str2 = manageTopic.subjectName;
        }
        if ((i & 4) != 0) {
            list = manageTopic.subjectGroupList;
        }
        return manageTopic.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final List<ManageTopicChat> component3() {
        return this.subjectGroupList;
    }

    @NotNull
    public final ManageTopic copy(@NotNull String subjectNo, @NotNull String subjectName, @NotNull List<ManageTopicChat> subjectGroupList) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        Intrinsics.checkNotNullParameter(subjectGroupList, "subjectGroupList");
        return new ManageTopic(subjectNo, subjectName, subjectGroupList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageTopic)) {
            return false;
        }
        ManageTopic manageTopic = (ManageTopic) other;
        return Intrinsics.areEqual(this.subjectNo, manageTopic.subjectNo) && Intrinsics.areEqual(this.subjectName, manageTopic.subjectName) && Intrinsics.areEqual(this.subjectGroupList, manageTopic.subjectGroupList);
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        if (this.childNode == null) {
            this.childNode = CollectionsKt.toMutableList(this.subjectGroupList);
        }
        return this.childNode;
    }

    @NotNull
    public final List<ManageTopicChat> getSubjectGroupList() {
        return this.subjectGroupList;
    }

    @NotNull
    public final String getSubjectName() {
        return this.subjectName;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    public int hashCode() {
        return (((this.subjectNo.hashCode() * 31) + this.subjectName.hashCode()) * 31) + this.subjectGroupList.hashCode();
    }

    public void setChildNode(@Nullable List<BaseNode> list) {
        this.childNode = list;
    }

    @NotNull
    public String toString() {
        return "ManageTopic(subjectNo=" + this.subjectNo + ", subjectName=" + this.subjectName + ", subjectGroupList=" + this.subjectGroupList + ')';
    }

    public ManageTopic(@NotNull String str, @NotNull String str2, @NotNull List<ManageTopicChat> list) {
        Intrinsics.checkNotNullParameter(str, yj7.b.SUBJECT_NO);
        Intrinsics.checkNotNullParameter(str2, "subjectName");
        Intrinsics.checkNotNullParameter(list, "subjectGroupList");
        this.subjectNo = str;
        this.subjectName = str2;
        this.subjectGroupList = list;
    }
}

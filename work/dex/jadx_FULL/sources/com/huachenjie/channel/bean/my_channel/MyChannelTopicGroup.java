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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "subjectCategoryNo", "", "subjectCategoryName", "subjectList", "", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopic;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode", "()Ljava/util/List;", "setChildNode", "(Ljava/util/List;)V", "getSubjectCategoryName", "()Ljava/lang/String;", "setSubjectCategoryName", "(Ljava/lang/String;)V", "getSubjectCategoryNo", "getSubjectList", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyChannelTopicGroup extends BaseExpandNode {

    @Nullable
    private List<BaseNode> childNode;

    @NotNull
    private String subjectCategoryName;

    @NotNull
    private final String subjectCategoryNo;

    @NotNull
    private final List<MyChannelTopic> subjectList;

    public MyChannelTopicGroup() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ MyChannelTopicGroup(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyChannelTopicGroup copy$default(MyChannelTopicGroup myChannelTopicGroup, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = myChannelTopicGroup.subjectCategoryNo;
        }
        if ((i & 2) != 0) {
            str2 = myChannelTopicGroup.subjectCategoryName;
        }
        if ((i & 4) != 0) {
            list = myChannelTopicGroup.subjectList;
        }
        return myChannelTopicGroup.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectCategoryNo() {
        return this.subjectCategoryNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectCategoryName() {
        return this.subjectCategoryName;
    }

    @NotNull
    public final List<MyChannelTopic> component3() {
        return this.subjectList;
    }

    @NotNull
    public final MyChannelTopicGroup copy(@NotNull String subjectCategoryNo, @NotNull String subjectCategoryName, @NotNull List<MyChannelTopic> subjectList) {
        Intrinsics.checkNotNullParameter(subjectCategoryNo, "subjectCategoryNo");
        Intrinsics.checkNotNullParameter(subjectCategoryName, "subjectCategoryName");
        Intrinsics.checkNotNullParameter(subjectList, "subjectList");
        return new MyChannelTopicGroup(subjectCategoryNo, subjectCategoryName, subjectList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyChannelTopicGroup)) {
            return false;
        }
        MyChannelTopicGroup myChannelTopicGroup = (MyChannelTopicGroup) other;
        return Intrinsics.areEqual(this.subjectCategoryNo, myChannelTopicGroup.subjectCategoryNo) && Intrinsics.areEqual(this.subjectCategoryName, myChannelTopicGroup.subjectCategoryName) && Intrinsics.areEqual(this.subjectList, myChannelTopicGroup.subjectList);
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        if (this.childNode == null) {
            this.childNode = CollectionsKt.toMutableList(this.subjectList);
        }
        return this.childNode;
    }

    @NotNull
    public final String getSubjectCategoryName() {
        return this.subjectCategoryName;
    }

    @NotNull
    public final String getSubjectCategoryNo() {
        return this.subjectCategoryNo;
    }

    @NotNull
    public final List<MyChannelTopic> getSubjectList() {
        return this.subjectList;
    }

    public int hashCode() {
        return (((this.subjectCategoryNo.hashCode() * 31) + this.subjectCategoryName.hashCode()) * 31) + this.subjectList.hashCode();
    }

    public void setChildNode(@Nullable List<BaseNode> list) {
        this.childNode = list;
    }

    public final void setSubjectCategoryName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectCategoryName = str;
    }

    @NotNull
    public String toString() {
        return "MyChannelTopicGroup(subjectCategoryNo=" + this.subjectCategoryNo + ", subjectCategoryName=" + this.subjectCategoryName + ", subjectList=" + this.subjectList + ')';
    }

    public MyChannelTopicGroup(@NotNull String str, @NotNull String str2, @NotNull List<MyChannelTopic> list) {
        Intrinsics.checkNotNullParameter(str, "subjectCategoryNo");
        Intrinsics.checkNotNullParameter(str2, "subjectCategoryName");
        Intrinsics.checkNotNullParameter(list, "subjectList");
        this.subjectCategoryNo = str;
        this.subjectCategoryName = str2;
        this.subjectList = list;
    }
}

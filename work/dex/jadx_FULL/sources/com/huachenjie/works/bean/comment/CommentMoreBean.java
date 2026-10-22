package com.huachenjie.works.bean.comment;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/comment/CommentMoreBean;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bizNo", "", "commentNo", "isLoading", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBizNo", "()Ljava/lang/String;", "childNode", "", "getChildNode", "()Ljava/util/List;", "getCommentNo", "()Z", "setLoading", "(Z)V", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "other", "", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommentMoreBean extends BaseNode {

    @NotNull
    private final String bizNo;

    @NotNull
    private final String commentNo;
    private boolean isLoading;

    public CommentMoreBean() {
        this(null, null, false, 7, null);
    }

    public /* synthetic */ CommentMoreBean(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ CommentMoreBean copy$default(CommentMoreBean commentMoreBean, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentMoreBean.bizNo;
        }
        if ((i & 2) != 0) {
            str2 = commentMoreBean.commentNo;
        }
        if ((i & 4) != 0) {
            z = commentMoreBean.isLoading;
        }
        return commentMoreBean.copy(str, str2, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCommentNo() {
        return this.commentNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    @NotNull
    public final CommentMoreBean copy(@NotNull String bizNo, @NotNull String commentNo, boolean isLoading) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        return new CommentMoreBean(bizNo, commentNo, isLoading);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentMoreBean)) {
            return false;
        }
        CommentMoreBean commentMoreBean = (CommentMoreBean) other;
        return Intrinsics.areEqual(this.bizNo, commentMoreBean.bizNo) && Intrinsics.areEqual(this.commentNo, commentMoreBean.commentNo) && this.isLoading == commentMoreBean.isLoading;
    }

    @NotNull
    public final String getBizNo() {
        return this.bizNo;
    }

    @Override // com.chad.library.adapter.base.entity.node.BaseNode
    @Nullable
    public List<BaseNode> getChildNode() {
        return null;
    }

    @NotNull
    public final String getCommentNo() {
        return this.commentNo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.bizNo.hashCode() * 31) + this.commentNo.hashCode()) * 31;
        boolean z = this.isLoading;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    @NotNull
    public String toString() {
        return "CommentMoreBean(bizNo=" + this.bizNo + ", commentNo=" + this.commentNo + ", isLoading=" + this.isLoading + ')';
    }

    public CommentMoreBean(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bizNo");
        Intrinsics.checkNotNullParameter(str2, "commentNo");
        this.bizNo = str;
        this.commentNo = str2;
        this.isLoading = z;
    }
}

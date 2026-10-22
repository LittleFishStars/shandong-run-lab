package com.huachenjie.works.bean.comment;

import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/bean/comment/TargetComment;", "", "targetCommentNo", "", "userInfo", "Lcom/huachenjie/works/bean/comment/CommentUserBean;", "(Ljava/lang/String;Lcom/huachenjie/works/bean/comment/CommentUserBean;)V", "getTargetCommentNo", "()Ljava/lang/String;", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/works/bean/comment/CommentUserBean;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TargetComment {

    @NotNull
    private final String targetCommentNo;

    @NotNull
    private final CommentUserBean userInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public TargetComment() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public TargetComment(@NotNull String str, @NotNull CommentUserBean commentUserBean) {
        Intrinsics.checkNotNullParameter(str, "targetCommentNo");
        Intrinsics.checkNotNullParameter(commentUserBean, "userInfo");
        this.targetCommentNo = str;
        this.userInfo = commentUserBean;
    }

    public static /* synthetic */ TargetComment copy$default(TargetComment targetComment, String str, CommentUserBean commentUserBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = targetComment.targetCommentNo;
        }
        if ((i & 2) != 0) {
            commentUserBean = targetComment.userInfo;
        }
        return targetComment.copy(str, commentUserBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTargetCommentNo() {
        return this.targetCommentNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CommentUserBean getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    public final TargetComment copy(@NotNull String targetCommentNo, @NotNull CommentUserBean userInfo) {
        Intrinsics.checkNotNullParameter(targetCommentNo, "targetCommentNo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new TargetComment(targetCommentNo, userInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TargetComment)) {
            return false;
        }
        TargetComment targetComment = (TargetComment) other;
        return Intrinsics.areEqual(this.targetCommentNo, targetComment.targetCommentNo) && Intrinsics.areEqual(this.userInfo, targetComment.userInfo);
    }

    @NotNull
    public final String getTargetCommentNo() {
        return this.targetCommentNo;
    }

    @NotNull
    public final CommentUserBean getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        return (this.targetCommentNo.hashCode() * 31) + this.userInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "TargetComment(targetCommentNo=" + this.targetCommentNo + ", userInfo=" + this.userInfo + ')';
    }

    public /* synthetic */ TargetComment(String str, CommentUserBean commentUserBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new CommentUserBean(null, null, null, null, 15, null) : commentUserBean);
    }
}

package com.huachenjie.works.bean.comment;

import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.o0a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010!\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f¢\u0006\u0002\u0010\u0019J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\fHÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\t\u0010O\u001a\u00020\u0010HÆ\u0003J£\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\fHÆ\u0001J\u0013\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020\fHÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001e\u00106\u001a\u0004\u0018\u00010\u00038FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010/R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006V"}, d2 = {"Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bizNo", "", "bizAuthorNo", "commentNo", "content", "textContent", "", "submitTime", "", "likeCount", "", "liked", "", "userInfo", "Lcom/huachenjie/works/bean/comment/CommentUserBean;", "targetRootFlag", "targetComment", "Lcom/huachenjie/works/bean/comment/TargetComment;", "image", "Lcom/huachenjie/works/bean/comment/CommentImageBean;", "atUserList", "", "publishStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;JIZLcom/huachenjie/works/bean/comment/CommentUserBean;ZLcom/huachenjie/works/bean/comment/TargetComment;Lcom/huachenjie/works/bean/comment/CommentImageBean;Ljava/util/List;I)V", "getAtUserList", "()Ljava/util/List;", "setAtUserList", "(Ljava/util/List;)V", "getBizAuthorNo", "()Ljava/lang/String;", "getBizNo", "childNode", "", "getChildNode", "getCommentNo", "getContent", "setContent", "(Ljava/lang/String;)V", "getImage", "()Lcom/huachenjie/works/bean/comment/CommentImageBean;", "getLikeCount", "()I", "setLikeCount", "(I)V", "getLiked", "()Z", "setLiked", "(Z)V", "getPublishStatus", "setPublishStatus", "getSubmitTime", "()J", "submitTimeStr", "getSubmitTimeStr", "setSubmitTimeStr", "getTargetComment", "()Lcom/huachenjie/works/bean/comment/TargetComment;", "getTargetRootFlag", "getTextContent", "()Ljava/lang/CharSequence;", "setTextContent", "(Ljava/lang/CharSequence;)V", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/works/bean/comment/CommentUserBean;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommentReplyBean extends BaseNode {

    @Nullable
    private List<String> atUserList;

    @NotNull
    private final String bizAuthorNo;

    @NotNull
    private final String bizNo;

    @NotNull
    private final String commentNo;

    @NotNull
    private String content;

    @Nullable
    private final CommentImageBean image;
    private int likeCount;
    private boolean liked;
    private int publishStatus;
    private final long submitTime;

    @Nullable
    private String submitTimeStr;

    @Nullable
    private final TargetComment targetComment;
    private final boolean targetRootFlag;

    @Nullable
    private CharSequence textContent;

    @NotNull
    private final CommentUserBean userInfo;

    public CommentReplyBean() {
        this(null, null, null, null, null, 0L, 0, false, null, false, null, null, null, 0, 16383, null);
    }

    public /* synthetic */ CommentReplyBean(String str, String str2, String str3, String str4, CharSequence charSequence, long j, int i, boolean z, CommentUserBean commentUserBean, boolean z2, TargetComment targetComment, CommentImageBean commentImageBean, List list, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) == 0 ? str4 : "", (i3 & 16) != 0 ? null : charSequence, (i3 & 32) != 0 ? 0L : j, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? new CommentUserBean(null, null, null, null, 15, null) : commentUserBean, (i3 & 512) != 0 ? false : z2, (i3 & 1024) != 0 ? null : targetComment, (i3 & 2048) != 0 ? null : commentImageBean, (i3 & 4096) != 0 ? null : list, (i3 & 8192) == 0 ? i2 : 0);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getTargetRootFlag() {
        return this.targetRootFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final TargetComment getTargetComment() {
        return this.targetComment;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final CommentImageBean getImage() {
        return this.image;
    }

    @Nullable
    public final List<String> component13() {
        return this.atUserList;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getPublishStatus() {
        return this.publishStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBizAuthorNo() {
        return this.bizAuthorNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCommentNo() {
        return this.commentNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CommentUserBean getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    public final CommentReplyBean copy(@NotNull String bizNo, @NotNull String bizAuthorNo, @NotNull String commentNo, @NotNull String content, @Nullable CharSequence textContent, long submitTime, int likeCount, boolean liked, @NotNull CommentUserBean userInfo, boolean targetRootFlag, @Nullable TargetComment targetComment, @Nullable CommentImageBean image, @Nullable List<String> atUserList, int publishStatus) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        Intrinsics.checkNotNullParameter(bizAuthorNo, "bizAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new CommentReplyBean(bizNo, bizAuthorNo, commentNo, content, textContent, submitTime, likeCount, liked, userInfo, targetRootFlag, targetComment, image, atUserList, publishStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentReplyBean)) {
            return false;
        }
        CommentReplyBean commentReplyBean = (CommentReplyBean) other;
        return Intrinsics.areEqual(this.bizNo, commentReplyBean.bizNo) && Intrinsics.areEqual(this.bizAuthorNo, commentReplyBean.bizAuthorNo) && Intrinsics.areEqual(this.commentNo, commentReplyBean.commentNo) && Intrinsics.areEqual(this.content, commentReplyBean.content) && Intrinsics.areEqual(this.textContent, commentReplyBean.textContent) && this.submitTime == commentReplyBean.submitTime && this.likeCount == commentReplyBean.likeCount && this.liked == commentReplyBean.liked && Intrinsics.areEqual(this.userInfo, commentReplyBean.userInfo) && this.targetRootFlag == commentReplyBean.targetRootFlag && Intrinsics.areEqual(this.targetComment, commentReplyBean.targetComment) && Intrinsics.areEqual(this.image, commentReplyBean.image) && Intrinsics.areEqual(this.atUserList, commentReplyBean.atUserList) && this.publishStatus == commentReplyBean.publishStatus;
    }

    @Nullable
    public final List<String> getAtUserList() {
        return this.atUserList;
    }

    @NotNull
    public final String getBizAuthorNo() {
        return this.bizAuthorNo;
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

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final CommentImageBean getImage() {
        return this.image;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final int getPublishStatus() {
        return this.publishStatus;
    }

    public final long getSubmitTime() {
        return this.submitTime;
    }

    @Nullable
    public final String getSubmitTimeStr() {
        if (this.submitTimeStr == null) {
            this.submitTimeStr = o0a.f43642a.a(this.submitTime);
        }
        return this.submitTimeStr;
    }

    @Nullable
    public final TargetComment getTargetComment() {
        return this.targetComment;
    }

    public final boolean getTargetRootFlag() {
        return this.targetRootFlag;
    }

    @Nullable
    public final CharSequence getTextContent() {
        return this.textContent;
    }

    @NotNull
    public final CommentUserBean getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        int iHashCode = ((((((this.bizNo.hashCode() * 31) + this.bizAuthorNo.hashCode()) * 31) + this.commentNo.hashCode()) * 31) + this.content.hashCode()) * 31;
        CharSequence charSequence = this.textContent;
        int iHashCode2 = (((((iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + Long.hashCode(this.submitTime)) * 31) + Integer.hashCode(this.likeCount)) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r1) * 31) + this.userInfo.hashCode()) * 31;
        boolean z2 = this.targetRootFlag;
        int i = (iHashCode3 + (z2 ? 1 : z2)) * 31;
        TargetComment targetComment = this.targetComment;
        int iHashCode4 = (i + (targetComment == null ? 0 : targetComment.hashCode())) * 31;
        CommentImageBean commentImageBean = this.image;
        int iHashCode5 = (iHashCode4 + (commentImageBean == null ? 0 : commentImageBean.hashCode())) * 31;
        List<String> list = this.atUserList;
        return ((iHashCode5 + (list != null ? list.hashCode() : 0)) * 31) + Integer.hashCode(this.publishStatus);
    }

    public final void setAtUserList(@Nullable List<String> list) {
        this.atUserList = list;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setLikeCount(int i) {
        this.likeCount = i;
    }

    public final void setLiked(boolean z) {
        this.liked = z;
    }

    public final void setPublishStatus(int i) {
        this.publishStatus = i;
    }

    public final void setSubmitTimeStr(@Nullable String str) {
        this.submitTimeStr = str;
    }

    public final void setTextContent(@Nullable CharSequence charSequence) {
        this.textContent = charSequence;
    }

    @NotNull
    public String toString() {
        return "CommentReplyBean(bizNo=" + this.bizNo + ", bizAuthorNo=" + this.bizAuthorNo + ", commentNo=" + this.commentNo + ", content=" + this.content + ", textContent=" + ((Object) this.textContent) + ", submitTime=" + this.submitTime + ", likeCount=" + this.likeCount + ", liked=" + this.liked + ", userInfo=" + this.userInfo + ", targetRootFlag=" + this.targetRootFlag + ", targetComment=" + this.targetComment + ", image=" + this.image + ", atUserList=" + this.atUserList + ", publishStatus=" + this.publishStatus + ')';
    }

    public CommentReplyBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable CharSequence charSequence, long j, int i, boolean z, @NotNull CommentUserBean commentUserBean, boolean z2, @Nullable TargetComment targetComment, @Nullable CommentImageBean commentImageBean, @Nullable List<String> list, int i2) {
        Intrinsics.checkNotNullParameter(str, "bizNo");
        Intrinsics.checkNotNullParameter(str2, "bizAuthorNo");
        Intrinsics.checkNotNullParameter(str3, "commentNo");
        Intrinsics.checkNotNullParameter(str4, "content");
        Intrinsics.checkNotNullParameter(commentUserBean, "userInfo");
        this.bizNo = str;
        this.bizAuthorNo = str2;
        this.commentNo = str3;
        this.content = str4;
        this.textContent = charSequence;
        this.submitTime = j;
        this.likeCount = i;
        this.liked = z;
        this.userInfo = commentUserBean;
        this.targetRootFlag = z2;
        this.targetComment = targetComment;
        this.image = commentImageBean;
        this.atUserList = list;
        this.publishStatus = i2;
    }
}

package com.huachenjie.works.bean.comment;

import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.o0a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f¢\u0006\u0002\u0010\u001bJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\t\u0010I\u001a\u00020\u0014HÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010L\u001a\u00020\fHÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\t\u0010U\u001a\u00020\u000eHÆ\u0003J\t\u0010V\u001a\u00020\u000eHÂ\u0003J»\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\f2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u001a\u001a\u00020\fHÆ\u0001J\u0013\u0010X\u001a\u00020\u000e2\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\fHÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R$\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u00106R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00101\"\u0004\b8\u00103R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001dR\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001e\u0010>\u001a\u0004\u0018\u00010\u00038FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010#\"\u0004\b@\u0010-R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006]"}, d2 = {"Lcom/huachenjie/works/bean/comment/CommentBean;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "bizNo", "", "bizAuthorNo", "commentNo", "content", "textContent", "", "submitTime", "", "likeCount", "", "liked", "", "subCommentHasMore", "subComment", "", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "userInfo", "Lcom/huachenjie/works/bean/comment/CommentUserBean;", "authorFlag", "image", "Lcom/huachenjie/works/bean/comment/CommentImageBean;", "subCommentPageNum", "atUserList", "publishStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;JIZZLjava/util/List;Lcom/huachenjie/works/bean/comment/CommentUserBean;ZLcom/huachenjie/works/bean/comment/CommentImageBean;ILjava/util/List;I)V", "getAtUserList", "()Ljava/util/List;", "setAtUserList", "(Ljava/util/List;)V", "getAuthorFlag", "()Z", "getBizAuthorNo", "()Ljava/lang/String;", "getBizNo", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getChildNode", "setChildNode", "getCommentNo", "getContent", "setContent", "(Ljava/lang/String;)V", "getImage", "()Lcom/huachenjie/works/bean/comment/CommentImageBean;", "getLikeCount", "()I", "setLikeCount", "(I)V", "getLiked", "setLiked", "(Z)V", "getPublishStatus", "setPublishStatus", "getSubComment", "getSubCommentPageNum", "setSubCommentPageNum", "getSubmitTime", "()J", "submitTimeStr", "getSubmitTimeStr", "setSubmitTimeStr", "getTextContent", "()Ljava/lang/CharSequence;", "setTextContent", "(Ljava/lang/CharSequence;)V", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/works/bean/comment/CommentUserBean;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommentBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentBean.kt\ncom/huachenjie/works/bean/comment/CommentBean\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n1549#2:82\n1620#2,3:83\n*S KotlinDebug\n*F\n+ 1 CommentBean.kt\ncom/huachenjie/works/bean/comment/CommentBean\n*L\n66#1:82\n66#1:83,3\n*E\n"})
public final /* data */ class CommentBean extends BaseExpandNode {

    @Nullable
    private List<String> atUserList;
    private final boolean authorFlag;

    @NotNull
    private final String bizAuthorNo;

    @NotNull
    private final String bizNo;

    @Nullable
    private List<BaseNode> childNode;

    @NotNull
    private final String commentNo;

    @NotNull
    private String content;

    @Nullable
    private final CommentImageBean image;
    private int likeCount;
    private boolean liked;
    private int publishStatus;

    @NotNull
    private final List<CommentReplyBean> subComment;
    private final boolean subCommentHasMore;
    private int subCommentPageNum;
    private final long submitTime;

    @Nullable
    private String submitTimeStr;

    @Nullable
    private CharSequence textContent;

    @NotNull
    private final CommentUserBean userInfo;

    public CommentBean() {
        this(null, null, null, null, null, 0L, 0, false, false, null, null, false, null, 0, null, 0, 65535, null);
    }

    public /* synthetic */ CommentBean(String str, String str2, String str3, String str4, CharSequence charSequence, long j, int i, boolean z, boolean z2, List list, CommentUserBean commentUserBean, boolean z3, CommentImageBean commentImageBean, int i2, List list2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) == 0 ? str4 : "", (i4 & 16) != 0 ? null : charSequence, (i4 & 32) != 0 ? 0L : j, (i4 & 64) != 0 ? 0 : i, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? false : z2, (i4 & 512) != 0 ? CollectionsKt.emptyList() : list, (i4 & 1024) != 0 ? new CommentUserBean(null, null, null, null, 15, null) : commentUserBean, (i4 & 2048) != 0 ? false : z3, (i4 & 4096) != 0 ? null : commentImageBean, (i4 & 8192) != 0 ? 1 : i2, (i4 & 16384) != 0 ? null : list2, (i4 & 32768) != 0 ? 0 : i3);
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final boolean getSubCommentHasMore() {
        return this.subCommentHasMore;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    @NotNull
    public final List<CommentReplyBean> component10() {
        return this.subComment;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final CommentUserBean getUserInfo() {
        return this.userInfo;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getAuthorFlag() {
        return this.authorFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final CommentImageBean getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getSubCommentPageNum() {
        return this.subCommentPageNum;
    }

    @Nullable
    public final List<String> component15() {
        return this.atUserList;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
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
    public final CommentBean copy(@NotNull String bizNo, @NotNull String bizAuthorNo, @NotNull String commentNo, @NotNull String content, @Nullable CharSequence textContent, long submitTime, int likeCount, boolean liked, boolean subCommentHasMore, @NotNull List<CommentReplyBean> subComment, @NotNull CommentUserBean userInfo, boolean authorFlag, @Nullable CommentImageBean image, int subCommentPageNum, @Nullable List<String> atUserList, int publishStatus) {
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        Intrinsics.checkNotNullParameter(bizAuthorNo, "bizAuthorNo");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(subComment, "subComment");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new CommentBean(bizNo, bizAuthorNo, commentNo, content, textContent, submitTime, likeCount, liked, subCommentHasMore, subComment, userInfo, authorFlag, image, subCommentPageNum, atUserList, publishStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentBean)) {
            return false;
        }
        CommentBean commentBean = (CommentBean) other;
        return Intrinsics.areEqual(this.bizNo, commentBean.bizNo) && Intrinsics.areEqual(this.bizAuthorNo, commentBean.bizAuthorNo) && Intrinsics.areEqual(this.commentNo, commentBean.commentNo) && Intrinsics.areEqual(this.content, commentBean.content) && Intrinsics.areEqual(this.textContent, commentBean.textContent) && this.submitTime == commentBean.submitTime && this.likeCount == commentBean.likeCount && this.liked == commentBean.liked && this.subCommentHasMore == commentBean.subCommentHasMore && Intrinsics.areEqual(this.subComment, commentBean.subComment) && Intrinsics.areEqual(this.userInfo, commentBean.userInfo) && this.authorFlag == commentBean.authorFlag && Intrinsics.areEqual(this.image, commentBean.image) && this.subCommentPageNum == commentBean.subCommentPageNum && Intrinsics.areEqual(this.atUserList, commentBean.atUserList) && this.publishStatus == commentBean.publishStatus;
    }

    @Nullable
    public final List<String> getAtUserList() {
        return this.atUserList;
    }

    public final boolean getAuthorFlag() {
        return this.authorFlag;
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
        if (this.childNode == null) {
            List<CommentReplyBean> list = this.subComment;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((CommentReplyBean) it.next());
            }
            List<BaseNode> mutableList = CollectionsKt.toMutableList(arrayList);
            this.childNode = mutableList;
            if (this.subCommentHasMore && mutableList != null) {
                mutableList.add(new CommentMoreBean(this.bizNo, this.commentNo, false));
            }
        }
        return this.childNode;
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

    @NotNull
    public final List<CommentReplyBean> getSubComment() {
        return this.subComment;
    }

    public final int getSubCommentPageNum() {
        return this.subCommentPageNum;
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
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
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
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.subCommentHasMore;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode3 = (((((i + r2) * 31) + this.subComment.hashCode()) * 31) + this.userInfo.hashCode()) * 31;
        boolean z3 = this.authorFlag;
        int i2 = (iHashCode3 + (z3 ? 1 : z3)) * 31;
        CommentImageBean commentImageBean = this.image;
        int iHashCode4 = (((i2 + (commentImageBean == null ? 0 : commentImageBean.hashCode())) * 31) + Integer.hashCode(this.subCommentPageNum)) * 31;
        List<String> list = this.atUserList;
        return ((iHashCode4 + (list != null ? list.hashCode() : 0)) * 31) + Integer.hashCode(this.publishStatus);
    }

    public final void setAtUserList(@Nullable List<String> list) {
        this.atUserList = list;
    }

    public void setChildNode(@Nullable List<BaseNode> list) {
        this.childNode = list;
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

    public final void setSubCommentPageNum(int i) {
        this.subCommentPageNum = i;
    }

    public final void setSubmitTimeStr(@Nullable String str) {
        this.submitTimeStr = str;
    }

    public final void setTextContent(@Nullable CharSequence charSequence) {
        this.textContent = charSequence;
    }

    @NotNull
    public String toString() {
        return "CommentBean(bizNo=" + this.bizNo + ", bizAuthorNo=" + this.bizAuthorNo + ", commentNo=" + this.commentNo + ", content=" + this.content + ", textContent=" + ((Object) this.textContent) + ", submitTime=" + this.submitTime + ", likeCount=" + this.likeCount + ", liked=" + this.liked + ", subCommentHasMore=" + this.subCommentHasMore + ", subComment=" + this.subComment + ", userInfo=" + this.userInfo + ", authorFlag=" + this.authorFlag + ", image=" + this.image + ", subCommentPageNum=" + this.subCommentPageNum + ", atUserList=" + this.atUserList + ", publishStatus=" + this.publishStatus + ')';
    }

    public CommentBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable CharSequence charSequence, long j, int i, boolean z, boolean z2, @NotNull List<CommentReplyBean> list, @NotNull CommentUserBean commentUserBean, boolean z3, @Nullable CommentImageBean commentImageBean, int i2, @Nullable List<String> list2, int i3) {
        Intrinsics.checkNotNullParameter(str, "bizNo");
        Intrinsics.checkNotNullParameter(str2, "bizAuthorNo");
        Intrinsics.checkNotNullParameter(str3, "commentNo");
        Intrinsics.checkNotNullParameter(str4, "content");
        Intrinsics.checkNotNullParameter(list, "subComment");
        Intrinsics.checkNotNullParameter(commentUserBean, "userInfo");
        this.bizNo = str;
        this.bizAuthorNo = str2;
        this.commentNo = str3;
        this.content = str4;
        this.textContent = charSequence;
        this.submitTime = j;
        this.likeCount = i;
        this.liked = z;
        this.subCommentHasMore = z2;
        this.subComment = list;
        this.userInfo = commentUserBean;
        this.authorFlag = z3;
        this.image = commentImageBean;
        this.subCommentPageNum = i2;
        this.atUserList = list2;
        this.publishStatus = i3;
    }
}

package com.huachenjie.works.bean;

import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.h46;
import com.zj.adlib.s72;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0011HÆ\u0003J\t\u0010+\u001a\u00020\u0011HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\u007f\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011HÆ\u0001J\u0013\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0011H\u0002J\u0006\u00109\u001a\u00020\u0003J\u0006\u0010:\u001a\u00020\u0003J\t\u0010;\u001a\u00020\u0011HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0013\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/huachenjie/works/bean/PostDetailBean;", "", "postNo", "", "userInfo", "Lcom/huachenjie/base/bean/UserInfoBean;", "content", "tag", "redPacket", "submitTime", "", "imageList", "", "Lcom/huachenjie/base/bean/ImageBean;", "liked", "", "likeCount", "", "shareCount", "commentCount", "(Ljava/lang/String;Lcom/huachenjie/base/bean/UserInfoBean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;ZIII)V", "getCommentCount", "()I", "setCommentCount", "(I)V", "getContent", "()Ljava/lang/String;", "getImageList", "()Ljava/util/List;", "getLikeCount", "setLikeCount", "getLiked", "()Z", "getPostNo", "getRedPacket", "getShareCount", "getSubmitTime", "()J", "getTag", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/base/bean/UserInfoBean;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "formatCount", "count", "formatShareCount", "formatSubmitTime", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostDetailBean {
    private int commentCount;

    @NotNull
    private final String content;

    @Nullable
    private final List<ImageBean> imageList;
    private int likeCount;
    private final boolean liked;

    @NotNull
    private final String postNo;

    @NotNull
    private final String redPacket;
    private final int shareCount;
    private final long submitTime;

    @NotNull
    private final String tag;

    @NotNull
    private final UserInfoBean userInfo;

    public PostDetailBean() {
        this(null, null, null, null, null, 0L, null, false, 0, 0, 0, 2047, null);
    }

    public PostDetailBean(@NotNull String str, @NotNull UserInfoBean userInfoBean, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @Nullable List<ImageBean> list, boolean z, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "postNo");
        Intrinsics.checkNotNullParameter(userInfoBean, "userInfo");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "tag");
        Intrinsics.checkNotNullParameter(str4, "redPacket");
        this.postNo = str;
        this.userInfo = userInfoBean;
        this.content = str2;
        this.tag = str3;
        this.redPacket = str4;
        this.submitTime = j;
        this.imageList = list;
        this.liked = z;
        this.likeCount = i;
        this.shareCount = i2;
        this.commentCount = i3;
    }

    private final String formatCount(int count) {
        if (count < 10000) {
            return String.valueOf(count);
        }
        return h46.f42049a.j(Float.valueOf(count / 10000.0f), 1) + 'W';
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPostNo() {
        return this.postNo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getShareCount() {
        return this.shareCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRedPacket() {
        return this.redPacket;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    @Nullable
    public final List<ImageBean> component7() {
        return this.imageList;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final PostDetailBean copy(@NotNull String postNo, @NotNull UserInfoBean userInfo, @NotNull String content, @NotNull String tag, @NotNull String redPacket, long submitTime, @Nullable List<ImageBean> imageList, boolean liked, int likeCount, int shareCount, int commentCount) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(redPacket, "redPacket");
        return new PostDetailBean(postNo, userInfo, content, tag, redPacket, submitTime, imageList, liked, likeCount, shareCount, commentCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostDetailBean)) {
            return false;
        }
        PostDetailBean postDetailBean = (PostDetailBean) other;
        return Intrinsics.areEqual(this.postNo, postDetailBean.postNo) && Intrinsics.areEqual(this.userInfo, postDetailBean.userInfo) && Intrinsics.areEqual(this.content, postDetailBean.content) && Intrinsics.areEqual(this.tag, postDetailBean.tag) && Intrinsics.areEqual(this.redPacket, postDetailBean.redPacket) && this.submitTime == postDetailBean.submitTime && Intrinsics.areEqual(this.imageList, postDetailBean.imageList) && this.liked == postDetailBean.liked && this.likeCount == postDetailBean.likeCount && this.shareCount == postDetailBean.shareCount && this.commentCount == postDetailBean.commentCount;
    }

    @NotNull
    public final String formatShareCount() {
        int i = this.shareCount;
        return i == 0 ? "分享" : formatCount(i);
    }

    @NotNull
    public final String formatSubmitTime() {
        String strC = s72.c(this.submitTime * ((long) 1000), "yyyy-MM-dd HH:mm:ss");
        Intrinsics.checkNotNullExpressionValue(strC, "formatDateTimeByFormat(s…0, \"yyyy-MM-dd HH:mm:ss\")");
        return strC;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final List<ImageBean> getImageList() {
        return this.imageList;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    public final String getPostNo() {
        return this.postNo;
    }

    @NotNull
    public final String getRedPacket() {
        return this.redPacket;
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    public final long getSubmitTime() {
        return this.submitTime;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    public int hashCode() {
        int iHashCode = ((((((((((this.postNo.hashCode() * 31) + this.userInfo.hashCode()) * 31) + this.content.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.redPacket.hashCode()) * 31) + Long.hashCode(this.submitTime)) * 31;
        List<ImageBean> list = this.imageList;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode2 + r1) * 31) + Integer.hashCode(this.likeCount)) * 31) + Integer.hashCode(this.shareCount)) * 31) + Integer.hashCode(this.commentCount);
    }

    public final void setCommentCount(int i) {
        this.commentCount = i;
    }

    public final void setLikeCount(int i) {
        this.likeCount = i;
    }

    @NotNull
    public String toString() {
        return "PostDetailBean(postNo=" + this.postNo + ", userInfo=" + this.userInfo + ", content=" + this.content + ", tag=" + this.tag + ", redPacket=" + this.redPacket + ", submitTime=" + this.submitTime + ", imageList=" + this.imageList + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", shareCount=" + this.shareCount + ", commentCount=" + this.commentCount + ')';
    }

    public /* synthetic */ PostDetailBean(String str, UserInfoBean userInfoBean, String str2, String str3, String str4, long j, List list, boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? new UserInfoBean(null, null, null, null, null, null, null, null, 0, false, 0, null, null, false, false, 32767, null) : userInfoBean, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) == 0 ? str4 : "", (i4 & 32) != 0 ? 0L : j, (i4 & 64) != 0 ? null : list, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? 0 : i, (i4 & 512) != 0 ? 0 : i2, (i4 & 1024) == 0 ? i3 : 0);
    }
}

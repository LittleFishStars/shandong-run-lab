package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.ipd.dsp.internal.e1.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u000fHÆ\u0003J\u0081\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001J\u0013\u00102\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0007HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001e¨\u00066"}, d2 = {"Lcom/huachenjie/college/bean/PostInfoBean;", "", "content", "", "image", "Lcom/huachenjie/college/bean/PostImageBean;", "likeCount", "", "commentCount", "shareCount", "liked", "", "postNo", "redPacket", "submitTime", "", "intervalTime", "tag", f.l, "(Ljava/lang/String;Lcom/huachenjie/college/bean/PostImageBean;IIIZLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Z)V", "getCommentCount", "()I", "getContent", "()Ljava/lang/String;", "getImage", "()Lcom/huachenjie/college/bean/PostImageBean;", "getIntervalTime", "()J", "getLikeCount", "getLiked", "()Z", "getPostNo", "getRedPacket", "getShareCount", "getSubmitTime", "getTag", "getTop", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostInfoBean {
    private final int commentCount;

    @NotNull
    private final String content;

    @NotNull
    private final PostImageBean image;
    private final long intervalTime;
    private final int likeCount;
    private final boolean liked;

    @NotNull
    private final String postNo;

    @NotNull
    private final String redPacket;
    private final int shareCount;
    private final long submitTime;

    @NotNull
    private final String tag;
    private final boolean top;

    public PostInfoBean() {
        this(null, null, 0, 0, 0, false, null, null, 0L, 0L, null, false, 4095, null);
    }

    public PostInfoBean(@NotNull String str, @NotNull PostImageBean postImageBean, int i, int i2, int i3, boolean z, @NotNull String str2, @NotNull String str3, long j, long j2, @NotNull String str4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(postImageBean, "image");
        Intrinsics.checkNotNullParameter(str2, "postNo");
        Intrinsics.checkNotNullParameter(str3, "redPacket");
        Intrinsics.checkNotNullParameter(str4, "tag");
        this.content = str;
        this.image = postImageBean;
        this.likeCount = i;
        this.commentCount = i2;
        this.shareCount = i3;
        this.liked = z;
        this.postNo = str2;
        this.redPacket = str3;
        this.submitTime = j;
        this.intervalTime = j2;
        this.tag = str4;
        this.top = z2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getIntervalTime() {
        return this.intervalTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getTop() {
        return this.top;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PostImageBean getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCommentCount() {
        return this.commentCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getShareCount() {
        return this.shareCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPostNo() {
        return this.postNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRedPacket() {
        return this.redPacket;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    @NotNull
    public final PostInfoBean copy(@NotNull String content, @NotNull PostImageBean image, int likeCount, int commentCount, int shareCount, boolean liked, @NotNull String postNo, @NotNull String redPacket, long submitTime, long intervalTime, @NotNull String tag, boolean top) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(redPacket, "redPacket");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new PostInfoBean(content, image, likeCount, commentCount, shareCount, liked, postNo, redPacket, submitTime, intervalTime, tag, top);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostInfoBean)) {
            return false;
        }
        PostInfoBean postInfoBean = (PostInfoBean) other;
        return Intrinsics.areEqual(this.content, postInfoBean.content) && Intrinsics.areEqual(this.image, postInfoBean.image) && this.likeCount == postInfoBean.likeCount && this.commentCount == postInfoBean.commentCount && this.shareCount == postInfoBean.shareCount && this.liked == postInfoBean.liked && Intrinsics.areEqual(this.postNo, postInfoBean.postNo) && Intrinsics.areEqual(this.redPacket, postInfoBean.redPacket) && this.submitTime == postInfoBean.submitTime && this.intervalTime == postInfoBean.intervalTime && Intrinsics.areEqual(this.tag, postInfoBean.tag) && this.top == postInfoBean.top;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final PostImageBean getImage() {
        return this.image;
    }

    public final long getIntervalTime() {
        return this.intervalTime;
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

    public final boolean getTop() {
        return this.top;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.content.hashCode() * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.likeCount)) * 31) + Integer.hashCode(this.commentCount)) * 31) + Integer.hashCode(this.shareCount)) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((iHashCode + r1) * 31) + this.postNo.hashCode()) * 31) + this.redPacket.hashCode()) * 31) + Long.hashCode(this.submitTime)) * 31) + Long.hashCode(this.intervalTime)) * 31) + this.tag.hashCode()) * 31;
        boolean z2 = this.top;
        return iHashCode2 + (z2 ? 1 : z2);
    }

    @NotNull
    public String toString() {
        return "PostInfoBean(content=" + this.content + ", image=" + this.image + ", likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", shareCount=" + this.shareCount + ", liked=" + this.liked + ", postNo=" + this.postNo + ", redPacket=" + this.redPacket + ", submitTime=" + this.submitTime + ", intervalTime=" + this.intervalTime + ", tag=" + this.tag + ", top=" + this.top + ')';
    }

    public /* synthetic */ PostInfoBean(String str, PostImageBean postImageBean, int i, int i2, int i3, boolean z, String str2, String str3, long j, long j2, String str4, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? new PostImageBean(null, 0, 0, 7, null) : postImageBean, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? false : z, (i4 & 64) != 0 ? "" : str2, (i4 & 128) != 0 ? "" : str3, (i4 & 256) != 0 ? 0L : j, (i4 & 512) == 0 ? j2 : 0L, (i4 & 1024) == 0 ? str4 : "", (i4 & 2048) == 0 ? z2 : false);
    }
}

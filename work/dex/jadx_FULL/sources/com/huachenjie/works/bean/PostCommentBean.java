package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.o0a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0010HÆ\u0003Jc\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\u0006\u0010/\u001a\u00020\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Lcom/huachenjie/works/bean/PostCommentBean;", "Landroid/os/Parcelable;", "content", "", "likeCount", "", "liked", "", "commentNo", "userInfo", "Lcom/huachenjie/works/bean/PostCommentUserBean;", "submitTime", "", "authorFlag", "bizNo", "image", "Lcom/huachenjie/base/bean/ImageBean;", "(Ljava/lang/String;IZLjava/lang/String;Lcom/huachenjie/works/bean/PostCommentUserBean;JZLjava/lang/String;Lcom/huachenjie/base/bean/ImageBean;)V", "getAuthorFlag", "()Z", "getBizNo", "()Ljava/lang/String;", "getCommentNo", "getContent", "getImage", "()Lcom/huachenjie/base/bean/ImageBean;", "getLikeCount", "()I", "getLiked", "getSubmitTime", "()J", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/works/bean/PostCommentUserBean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "formatTime", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PostCommentBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PostCommentBean> CREATOR = new Creator();
    private final boolean authorFlag;

    @NotNull
    private final String bizNo;

    @NotNull
    private final String commentNo;

    @NotNull
    private final String content;

    @NotNull
    private final ImageBean image;
    private final int likeCount;
    private final boolean liked;
    private final long submitTime;

    @NotNull
    private final PostCommentUserBean userInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PostCommentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostCommentBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PostCommentBean(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), PostCommentUserBean.CREATOR.createFromParcel(parcel), parcel.readLong(), parcel.readInt() != 0, parcel.readString(), (ImageBean) parcel.readParcelable(PostCommentBean.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostCommentBean[] newArray(int i) {
            return new PostCommentBean[i];
        }
    }

    public PostCommentBean() {
        this(null, 0, false, null, null, 0L, false, null, null, 511, null);
    }

    public PostCommentBean(@NotNull String str, int i, boolean z, @NotNull String str2, @NotNull PostCommentUserBean postCommentUserBean, long j, boolean z2, @NotNull String str3, @NotNull ImageBean imageBean) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "commentNo");
        Intrinsics.checkNotNullParameter(postCommentUserBean, "userInfo");
        Intrinsics.checkNotNullParameter(str3, "bizNo");
        Intrinsics.checkNotNullParameter(imageBean, "image");
        this.content = str;
        this.likeCount = i;
        this.liked = z;
        this.commentNo = str2;
        this.userInfo = postCommentUserBean;
        this.submitTime = j;
        this.authorFlag = z2;
        this.bizNo = str3;
        this.image = imageBean;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getLiked() {
        return this.liked;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCommentNo() {
        return this.commentNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PostCommentUserBean getUserInfo() {
        return this.userInfo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAuthorFlag() {
        return this.authorFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ImageBean getImage() {
        return this.image;
    }

    @NotNull
    public final PostCommentBean copy(@NotNull String content, int likeCount, boolean liked, @NotNull String commentNo, @NotNull PostCommentUserBean userInfo, long submitTime, boolean authorFlag, @NotNull String bizNo, @NotNull ImageBean image) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(commentNo, "commentNo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(bizNo, "bizNo");
        Intrinsics.checkNotNullParameter(image, "image");
        return new PostCommentBean(content, likeCount, liked, commentNo, userInfo, submitTime, authorFlag, bizNo, image);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostCommentBean)) {
            return false;
        }
        PostCommentBean postCommentBean = (PostCommentBean) other;
        return Intrinsics.areEqual(this.content, postCommentBean.content) && this.likeCount == postCommentBean.likeCount && this.liked == postCommentBean.liked && Intrinsics.areEqual(this.commentNo, postCommentBean.commentNo) && Intrinsics.areEqual(this.userInfo, postCommentBean.userInfo) && this.submitTime == postCommentBean.submitTime && this.authorFlag == postCommentBean.authorFlag && Intrinsics.areEqual(this.bizNo, postCommentBean.bizNo) && Intrinsics.areEqual(this.image, postCommentBean.image);
    }

    @NotNull
    public final String formatTime() {
        return o0a.f43642a.a(this.submitTime * ((long) 1000));
    }

    public final boolean getAuthorFlag() {
        return this.authorFlag;
    }

    @NotNull
    public final String getBizNo() {
        return this.bizNo;
    }

    @NotNull
    public final String getCommentNo() {
        return this.commentNo;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final ImageBean getImage() {
        return this.image;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final long getSubmitTime() {
        return this.submitTime;
    }

    @NotNull
    public final PostCommentUserBean getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.content.hashCode() * 31) + Integer.hashCode(this.likeCount)) * 31;
        boolean z = this.liked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((iHashCode + r1) * 31) + this.commentNo.hashCode()) * 31) + this.userInfo.hashCode()) * 31) + Long.hashCode(this.submitTime)) * 31;
        boolean z2 = this.authorFlag;
        return ((((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.bizNo.hashCode()) * 31) + this.image.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostCommentBean(content=" + this.content + ", likeCount=" + this.likeCount + ", liked=" + this.liked + ", commentNo=" + this.commentNo + ", userInfo=" + this.userInfo + ", submitTime=" + this.submitTime + ", authorFlag=" + this.authorFlag + ", bizNo=" + this.bizNo + ", image=" + this.image + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.content);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.liked ? 1 : 0);
        parcel.writeString(this.commentNo);
        this.userInfo.writeToParcel(parcel, flags);
        parcel.writeLong(this.submitTime);
        parcel.writeInt(this.authorFlag ? 1 : 0);
        parcel.writeString(this.bizNo);
        parcel.writeParcelable(this.image, flags);
    }

    public /* synthetic */ PostCommentBean(String str, int i, boolean z, String str2, PostCommentUserBean postCommentUserBean, long j, boolean z2, String str3, ImageBean imageBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? new PostCommentUserBean(null, null, null, null, 15, null) : postCommentUserBean, (i2 & 32) != 0 ? 0L : j, (i2 & 64) == 0 ? z2 : false, (i2 & 128) == 0 ? str3 : "", (i2 & 256) != 0 ? new ImageBean(null, null, 0, 0, 0, 31, null) : imageBean);
    }
}

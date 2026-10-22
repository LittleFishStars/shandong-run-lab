package com.huachenjie.works.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.zj.adlib.s72;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u0004J\u0019\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/huachenjie/works/bean/PostItemBean;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "postType", "", "postInfo", "Lcom/huachenjie/works/bean/PostInfoBean;", "comment", "Lcom/huachenjie/works/bean/CommentListBean;", "userInfo", "Lcom/huachenjie/works/bean/PostUserBean;", "(ILcom/huachenjie/works/bean/PostInfoBean;Lcom/huachenjie/works/bean/CommentListBean;Lcom/huachenjie/works/bean/PostUserBean;)V", "getComment", "()Lcom/huachenjie/works/bean/CommentListBean;", CollegeTownItemFragment.ITEM_TYPE, "getItemType", "()I", "getPostInfo", "()Lcom/huachenjie/works/bean/PostInfoBean;", "getPostType", "setPostType", "(I)V", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/works/bean/PostUserBean;", "describeContents", "findCommentUse", "Lcom/huachenjie/works/bean/PostCommentBean;", "index", "findImageUrl", "", "formatPublishTime", "onTop", "", "setLiked", "", "liked", "quantity", "showCommentUser", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PostItemBean implements Parcelable, MultiItemEntity {

    @NotNull
    public static final Parcelable.Creator<PostItemBean> CREATOR = new Creator();

    @NotNull
    private final CommentListBean comment;

    @NotNull
    private final PostInfoBean postInfo;
    private int postType;

    @NotNull
    private final PostUserBean userInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PostItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PostItemBean(parcel.readInt(), PostInfoBean.CREATOR.createFromParcel(parcel), CommentListBean.CREATOR.createFromParcel(parcel), PostUserBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostItemBean[] newArray(int i) {
            return new PostItemBean[i];
        }
    }

    public PostItemBean() {
        this(0, null, null, null, 15, null);
    }

    public PostItemBean(int i, @NotNull PostInfoBean postInfoBean, @NotNull CommentListBean commentListBean, @NotNull PostUserBean postUserBean) {
        Intrinsics.checkNotNullParameter(postInfoBean, "postInfo");
        Intrinsics.checkNotNullParameter(commentListBean, "comment");
        Intrinsics.checkNotNullParameter(postUserBean, "userInfo");
        this.postType = i;
        this.postInfo = postInfoBean;
        this.comment = commentListBean;
        this.userInfo = postUserBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final PostCommentBean findCommentUse(int index) {
        CommentListBean commentListBean = this.comment;
        if (commentListBean == null || commentListBean.getList() == null) {
            return new PostCommentBean(null, 0, false, null, null, 0L, false, null, null, 511, null);
        }
        boolean z = false;
        if (index >= 0 && index < this.comment.getList().size()) {
            z = true;
        }
        return !z ? new PostCommentBean(null, 0, false, null, null, 0L, false, null, null, 511, null) : this.comment.getList().get(index);
    }

    @NotNull
    public final String findImageUrl() {
        List<PostImageBean> imageList;
        PostInfoBean postInfoBean = this.postInfo;
        return (postInfoBean == null || (imageList = postInfoBean.getImageList()) == null || imageList.isEmpty()) ? "" : imageList.get(0).getPath();
    }

    @NotNull
    public final String formatPublishTime() {
        PostInfoBean postInfoBean = this.postInfo;
        if (postInfoBean == null) {
            return "";
        }
        String strG = s72.g(Long.valueOf(postInfoBean.getIntervalTime() * ((long) 1000)));
        Intrinsics.checkNotNullExpressionValue(strG, "formatPublishTime(postInfo.intervalTime * 1000)");
        return strG;
    }

    @NotNull
    public final CommentListBean getComment() {
        return this.comment;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    /* JADX INFO: renamed from: getItemType, reason: from getter */
    public int getPostType() {
        return this.postType;
    }

    @NotNull
    public final PostInfoBean getPostInfo() {
        return this.postInfo;
    }

    public final int getPostType() {
        return this.postType;
    }

    @NotNull
    public final PostUserBean getUserInfo() {
        return this.userInfo;
    }

    public final boolean onTop() {
        PostInfoBean postInfoBean = this.postInfo;
        if (postInfoBean == null) {
            return false;
        }
        return postInfoBean.getTop();
    }

    public final void setLiked(boolean liked, int quantity) {
        this.postInfo.setLiked(liked);
        this.postInfo.setLikeCount(quantity);
    }

    public final void setPostType(int i) {
        this.postType = i;
    }

    public final boolean showCommentUser(int index) {
        CommentListBean commentListBean = this.comment;
        if (commentListBean == null || commentListBean.getList() == null) {
            return false;
        }
        return index >= 0 && index < this.comment.getList().size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.postType);
        this.postInfo.writeToParcel(parcel, flags);
        this.comment.writeToParcel(parcel, flags);
        this.userInfo.writeToParcel(parcel, flags);
    }

    public /* synthetic */ PostItemBean(int i, PostInfoBean postInfoBean, CommentListBean commentListBean, PostUserBean postUserBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new PostInfoBean(null, null, 0L, 0L, null, null, null, false, 0, false, 1023, null) : postInfoBean, (i2 & 4) != 0 ? new CommentListBean(0, null, 3, null) : commentListBean, (i2 & 8) != 0 ? new PostUserBean(null, null, null, null, false, 31, null) : postUserBean);
    }
}

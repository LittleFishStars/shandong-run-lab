package com.huachenjie.college.bean;

import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/college/bean/CollegePostBean;", "", "postInfo", "Lcom/huachenjie/college/bean/PostInfoBean;", "userInfo", "Lcom/huachenjie/college/bean/PostUserBean;", "(Lcom/huachenjie/college/bean/PostInfoBean;Lcom/huachenjie/college/bean/PostUserBean;)V", "getPostInfo", "()Lcom/huachenjie/college/bean/PostInfoBean;", JSApiCachePoint.GET_USER_INFO, "()Lcom/huachenjie/college/bean/PostUserBean;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CollegePostBean {

    @NotNull
    private final PostInfoBean postInfo;

    @NotNull
    private final PostUserBean userInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public CollegePostBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public CollegePostBean(@NotNull PostInfoBean postInfoBean, @NotNull PostUserBean postUserBean) {
        Intrinsics.checkNotNullParameter(postInfoBean, "postInfo");
        Intrinsics.checkNotNullParameter(postUserBean, "userInfo");
        this.postInfo = postInfoBean;
        this.userInfo = postUserBean;
    }

    public static /* synthetic */ CollegePostBean copy$default(CollegePostBean collegePostBean, PostInfoBean postInfoBean, PostUserBean postUserBean, int i, Object obj) {
        if ((i & 1) != 0) {
            postInfoBean = collegePostBean.postInfo;
        }
        if ((i & 2) != 0) {
            postUserBean = collegePostBean.userInfo;
        }
        return collegePostBean.copy(postInfoBean, postUserBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PostInfoBean getPostInfo() {
        return this.postInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PostUserBean getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    public final CollegePostBean copy(@NotNull PostInfoBean postInfo, @NotNull PostUserBean userInfo) {
        Intrinsics.checkNotNullParameter(postInfo, "postInfo");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new CollegePostBean(postInfo, userInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollegePostBean)) {
            return false;
        }
        CollegePostBean collegePostBean = (CollegePostBean) other;
        return Intrinsics.areEqual(this.postInfo, collegePostBean.postInfo) && Intrinsics.areEqual(this.userInfo, collegePostBean.userInfo);
    }

    @NotNull
    public final PostInfoBean getPostInfo() {
        return this.postInfo;
    }

    @NotNull
    public final PostUserBean getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        return (this.postInfo.hashCode() * 31) + this.userInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "CollegePostBean(postInfo=" + this.postInfo + ", userInfo=" + this.userInfo + ')';
    }

    public /* synthetic */ CollegePostBean(PostInfoBean postInfoBean, PostUserBean postUserBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PostInfoBean(null, null, 0, 0, 0, false, null, null, 0L, 0L, null, false, 4095, null) : postInfoBean, (i & 2) != 0 ? new PostUserBean(false, null, null, null, null, 31, null) : postUserBean);
    }
}

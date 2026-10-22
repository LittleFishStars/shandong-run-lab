package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.video.VideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/huachenjie/works/bean/AlumniWorkDetailBean;", "", "avatar", "", UserConstants.USER_PARAMS.b, "type", "", "imageList", "", "Lcom/huachenjie/works/bean/MediaBean;", VideoPlayerActivity.t, "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/huachenjie/works/bean/MediaBean;)V", "getAvatar", "()Ljava/lang/String;", "getImageList", "()Ljava/util/List;", "getNickName", "getType", "()I", "getVideoUrl", "()Lcom/huachenjie/works/bean/MediaBean;", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AlumniWorkDetailBean {

    @NotNull
    private final String avatar;

    @NotNull
    private final List<MediaBean> imageList;

    @NotNull
    private final String nickName;
    private final int type;

    @NotNull
    private final MediaBean videoUrl;

    public AlumniWorkDetailBean() {
        this(null, null, 0, null, null, 31, null);
    }

    public AlumniWorkDetailBean(@NotNull String str, @NotNull String str2, int i, @NotNull List<MediaBean> list, @NotNull MediaBean mediaBean) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(list, "imageList");
        Intrinsics.checkNotNullParameter(mediaBean, VideoPlayerActivity.t);
        this.avatar = str;
        this.nickName = str2;
        this.type = i;
        this.imageList = list;
        this.videoUrl = mediaBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlumniWorkDetailBean copy$default(AlumniWorkDetailBean alumniWorkDetailBean, String str, String str2, int i, List list, MediaBean mediaBean, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = alumniWorkDetailBean.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = alumniWorkDetailBean.nickName;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            i = alumniWorkDetailBean.type;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = alumniWorkDetailBean.imageList;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            mediaBean = alumniWorkDetailBean.videoUrl;
        }
        return alumniWorkDetailBean.copy(str, str3, i3, list2, mediaBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final List<MediaBean> component4() {
        return this.imageList;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MediaBean getVideoUrl() {
        return this.videoUrl;
    }

    @NotNull
    public final AlumniWorkDetailBean copy(@NotNull String avatar, @NotNull String nickName, int type, @NotNull List<MediaBean> imageList, @NotNull MediaBean videoUrl) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        Intrinsics.checkNotNullParameter(videoUrl, VideoPlayerActivity.t);
        return new AlumniWorkDetailBean(avatar, nickName, type, imageList, videoUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlumniWorkDetailBean)) {
            return false;
        }
        AlumniWorkDetailBean alumniWorkDetailBean = (AlumniWorkDetailBean) other;
        return Intrinsics.areEqual(this.avatar, alumniWorkDetailBean.avatar) && Intrinsics.areEqual(this.nickName, alumniWorkDetailBean.nickName) && this.type == alumniWorkDetailBean.type && Intrinsics.areEqual(this.imageList, alumniWorkDetailBean.imageList) && Intrinsics.areEqual(this.videoUrl, alumniWorkDetailBean.videoUrl);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final List<MediaBean> getImageList() {
        return this.imageList;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final MediaBean getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        return (((((((this.avatar.hashCode() * 31) + this.nickName.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + this.imageList.hashCode()) * 31) + this.videoUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "AlumniWorkDetailBean(avatar=" + this.avatar + ", nickName=" + this.nickName + ", type=" + this.type + ", imageList=" + this.imageList + ", videoUrl=" + this.videoUrl + ')';
    }

    public /* synthetic */ AlumniWorkDetailBean(String str, String str2, int i, List list, MediaBean mediaBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new ArrayList() : list, (i2 & 16) != 0 ? new MediaBean(null, null, 0, 0, 15, null) : mediaBean);
    }
}

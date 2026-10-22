package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006("}, d2 = {"Lcom/huachenjie/works/bean/PublishPostRequestBean;", "", "requestId", "", "attachmentType", "", "content", "postType", "tagNo", "redPacket", "anonymous", "imageList", "", "Lcom/huachenjie/works/bean/PublishPostRequestImgBean;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getAnonymous", "()I", "getAttachmentType", "getContent", "()Ljava/lang/String;", "getImageList", "()Ljava/util/List;", "getPostType", "getRedPacket", "getRequestId", "getTagNo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PublishPostRequestBean {
    private final int anonymous;
    private final int attachmentType;

    @NotNull
    private final String content;

    @Nullable
    private final List<PublishPostRequestImgBean> imageList;

    @NotNull
    private final String postType;

    @Nullable
    private final String redPacket;

    @NotNull
    private final String requestId;

    @NotNull
    private final String tagNo;

    public PublishPostRequestBean(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, int i2, @Nullable List<PublishPostRequestImgBean> list) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "postType");
        Intrinsics.checkNotNullParameter(str4, "tagNo");
        this.requestId = str;
        this.attachmentType = i;
        this.content = str2;
        this.postType = str3;
        this.tagNo = str4;
        this.redPacket = str5;
        this.anonymous = i2;
        this.imageList = list;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPostType() {
        return this.postType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTagNo() {
        return this.tagNo;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRedPacket() {
        return this.redPacket;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getAnonymous() {
        return this.anonymous;
    }

    @Nullable
    public final List<PublishPostRequestImgBean> component8() {
        return this.imageList;
    }

    @NotNull
    public final PublishPostRequestBean copy(@NotNull String requestId, int attachmentType, @NotNull String content, @NotNull String postType, @NotNull String tagNo, @Nullable String redPacket, int anonymous, @Nullable List<PublishPostRequestImgBean> imageList) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(postType, "postType");
        Intrinsics.checkNotNullParameter(tagNo, "tagNo");
        return new PublishPostRequestBean(requestId, attachmentType, content, postType, tagNo, redPacket, anonymous, imageList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishPostRequestBean)) {
            return false;
        }
        PublishPostRequestBean publishPostRequestBean = (PublishPostRequestBean) other;
        return Intrinsics.areEqual(this.requestId, publishPostRequestBean.requestId) && this.attachmentType == publishPostRequestBean.attachmentType && Intrinsics.areEqual(this.content, publishPostRequestBean.content) && Intrinsics.areEqual(this.postType, publishPostRequestBean.postType) && Intrinsics.areEqual(this.tagNo, publishPostRequestBean.tagNo) && Intrinsics.areEqual(this.redPacket, publishPostRequestBean.redPacket) && this.anonymous == publishPostRequestBean.anonymous && Intrinsics.areEqual(this.imageList, publishPostRequestBean.imageList);
    }

    public final int getAnonymous() {
        return this.anonymous;
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final List<PublishPostRequestImgBean> getImageList() {
        return this.imageList;
    }

    @NotNull
    public final String getPostType() {
        return this.postType;
    }

    @Nullable
    public final String getRedPacket() {
        return this.redPacket;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getTagNo() {
        return this.tagNo;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.requestId.hashCode() * 31) + Integer.hashCode(this.attachmentType)) * 31) + this.content.hashCode()) * 31) + this.postType.hashCode()) * 31) + this.tagNo.hashCode()) * 31;
        String str = this.redPacket;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.anonymous)) * 31;
        List<PublishPostRequestImgBean> list = this.imageList;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PublishPostRequestBean(requestId=" + this.requestId + ", attachmentType=" + this.attachmentType + ", content=" + this.content + ", postType=" + this.postType + ", tagNo=" + this.tagNo + ", redPacket=" + this.redPacket + ", anonymous=" + this.anonymous + ", imageList=" + this.imageList + ')';
    }

    public /* synthetic */ PublishPostRequestBean(String str, int i, String str2, String str3, String str4, String str5, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 1 : i, str2, str3, str4, str5, i2, list);
    }
}

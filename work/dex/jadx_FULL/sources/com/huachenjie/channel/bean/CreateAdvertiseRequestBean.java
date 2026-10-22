package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006%"}, d2 = {"Lcom/huachenjie/channel/bean/CreateAdvertiseRequestBean;", "", "channelNo", "", "coverUrl", "content", "linkType", "", "linkUrl", "channelAdCode", "imgList", "", "Lcom/huachenjie/channel/bean/CreateImageBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChannelAdCode", "()Ljava/lang/String;", "getChannelNo", "getContent", "getCoverUrl", "getImgList", "()Ljava/util/List;", "getLinkType", "()Z", "getLinkUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "other", "hashCode", "", "toString", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CreateAdvertiseRequestBean {

    @Nullable
    private final String channelAdCode;

    @NotNull
    private final String channelNo;

    @NotNull
    private final String content;

    @NotNull
    private final String coverUrl;

    @Nullable
    private final List<CreateImageBean> imgList;
    private final boolean linkType;

    @Nullable
    private final String linkUrl;

    public CreateAdvertiseRequestBean(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @Nullable String str4, @Nullable String str5, @Nullable List<CreateImageBean> list) {
        Intrinsics.checkNotNullParameter(str, "channelNo");
        Intrinsics.checkNotNullParameter(str2, "coverUrl");
        Intrinsics.checkNotNullParameter(str3, "content");
        this.channelNo = str;
        this.coverUrl = str2;
        this.content = str3;
        this.linkType = z;
        this.linkUrl = str4;
        this.channelAdCode = str5;
        this.imgList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateAdvertiseRequestBean copy$default(CreateAdvertiseRequestBean createAdvertiseRequestBean, String str, String str2, String str3, boolean z, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createAdvertiseRequestBean.channelNo;
        }
        if ((i & 2) != 0) {
            str2 = createAdvertiseRequestBean.coverUrl;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = createAdvertiseRequestBean.content;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            z = createAdvertiseRequestBean.linkType;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str4 = createAdvertiseRequestBean.linkUrl;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = createAdvertiseRequestBean.channelAdCode;
        }
        String str9 = str5;
        if ((i & 64) != 0) {
            list = createAdvertiseRequestBean.imgList;
        }
        return createAdvertiseRequestBean.copy(str, str6, str7, z2, str8, str9, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getLinkType() {
        return this.linkType;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getChannelAdCode() {
        return this.channelAdCode;
    }

    @Nullable
    public final List<CreateImageBean> component7() {
        return this.imgList;
    }

    @NotNull
    public final CreateAdvertiseRequestBean copy(@NotNull String channelNo, @NotNull String coverUrl, @NotNull String content, boolean linkType, @Nullable String linkUrl, @Nullable String channelAdCode, @Nullable List<CreateImageBean> imgList) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        return new CreateAdvertiseRequestBean(channelNo, coverUrl, content, linkType, linkUrl, channelAdCode, imgList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateAdvertiseRequestBean)) {
            return false;
        }
        CreateAdvertiseRequestBean createAdvertiseRequestBean = (CreateAdvertiseRequestBean) other;
        return Intrinsics.areEqual(this.channelNo, createAdvertiseRequestBean.channelNo) && Intrinsics.areEqual(this.coverUrl, createAdvertiseRequestBean.coverUrl) && Intrinsics.areEqual(this.content, createAdvertiseRequestBean.content) && this.linkType == createAdvertiseRequestBean.linkType && Intrinsics.areEqual(this.linkUrl, createAdvertiseRequestBean.linkUrl) && Intrinsics.areEqual(this.channelAdCode, createAdvertiseRequestBean.channelAdCode) && Intrinsics.areEqual(this.imgList, createAdvertiseRequestBean.imgList);
    }

    @Nullable
    public final String getChannelAdCode() {
        return this.channelAdCode;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final List<CreateImageBean> getImgList() {
        return this.imgList;
    }

    public final boolean getLinkType() {
        return this.linkType;
    }

    @Nullable
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.channelNo.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.content.hashCode()) * 31;
        boolean z = this.linkType;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        String str = this.linkUrl;
        int iHashCode2 = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelAdCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<CreateImageBean> list = this.imgList;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CreateAdvertiseRequestBean(channelNo=" + this.channelNo + ", coverUrl=" + this.coverUrl + ", content=" + this.content + ", linkType=" + this.linkType + ", linkUrl=" + this.linkUrl + ", channelAdCode=" + this.channelAdCode + ", imgList=" + this.imgList + ')';
    }
}

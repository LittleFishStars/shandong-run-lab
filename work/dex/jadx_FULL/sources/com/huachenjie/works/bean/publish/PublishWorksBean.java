package com.huachenjie.works.bean.publish;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.base.bean.RichSubjectBean;
import com.huachenjie.base.bean.RichUserBean;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\u0018\u00002\u00020\u0001B¡\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0002\u0010\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010+R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0018R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001a\u0010\u0011\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 ¨\u00069"}, d2 = {"Lcom/huachenjie/works/bean/publish/PublishWorksBean;", "", "atUserList", "", "Lcom/huachenjie/base/bean/RichUserBean;", "title", "", "content", RequestParameters.SUBRESOURCE_LOCATION, "Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "subjectList", "Lcom/huachenjie/base/bean/RichSubjectBean;", "channelNo", "attachmentType", "", "attachmentInfo", "Lcom/huachenjie/works/bean/publish/PubWorksAttachmentInfo;", "visit", "requestId", "goodsList", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "tagNo", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;Ljava/util/List;Ljava/lang/String;ILcom/huachenjie/works/bean/publish/PubWorksAttachmentInfo;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAtUserList", "()Ljava/util/List;", "getAttachmentInfo", "()Lcom/huachenjie/works/bean/publish/PubWorksAttachmentInfo;", "setAttachmentInfo", "(Lcom/huachenjie/works/bean/publish/PubWorksAttachmentInfo;)V", "getAttachmentType", "()I", "setAttachmentType", "(I)V", "getCategoryNo", "()Ljava/lang/String;", "setCategoryNo", "(Ljava/lang/String;)V", "getChannelNo", "setChannelNo", "getContent", "setContent", "getGoodsList", "setGoodsList", "(Ljava/util/List;)V", "getLocation", "()Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "setLocation", "(Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;)V", "getRequestId", "setRequestId", "getSubjectList", "getTagNo", "setTagNo", "getTitle", d.p, "getVisit", "setVisit", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PublishWorksBean {

    @NotNull
    private final List<RichUserBean> atUserList;

    @Nullable
    private PubWorksAttachmentInfo attachmentInfo;
    private int attachmentType;

    @NotNull
    private String categoryNo;

    @Nullable
    private String channelNo;

    @NotNull
    private String content;

    @NotNull
    private List<String> goodsList;

    @Nullable
    private PubWorkLocationItemBean location;

    @Nullable
    private String requestId;

    @NotNull
    private final List<RichSubjectBean> subjectList;

    @NotNull
    private String tagNo;

    @NotNull
    private String title;
    private int visit;

    public PublishWorksBean() {
        this(null, null, null, null, null, null, 0, null, 0, null, null, null, null, 8191, null);
    }

    public PublishWorksBean(@NotNull List<RichUserBean> list, @NotNull String str, @NotNull String str2, @Nullable PubWorkLocationItemBean pubWorkLocationItemBean, @NotNull List<RichSubjectBean> list2, @Nullable String str3, int i, @Nullable PubWorksAttachmentInfo pubWorksAttachmentInfo, int i2, @Nullable String str4, @NotNull List<String> list3, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(list, "atUserList");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(list2, "subjectList");
        Intrinsics.checkNotNullParameter(list3, "goodsList");
        Intrinsics.checkNotNullParameter(str5, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
        Intrinsics.checkNotNullParameter(str6, "tagNo");
        this.atUserList = list;
        this.title = str;
        this.content = str2;
        this.location = pubWorkLocationItemBean;
        this.subjectList = list2;
        this.channelNo = str3;
        this.attachmentType = i;
        this.attachmentInfo = pubWorksAttachmentInfo;
        this.visit = i2;
        this.requestId = str4;
        this.goodsList = list3;
        this.categoryNo = str5;
        this.tagNo = str6;
    }

    @NotNull
    public final List<RichUserBean> getAtUserList() {
        return this.atUserList;
    }

    @Nullable
    public final PubWorksAttachmentInfo getAttachmentInfo() {
        return this.attachmentInfo;
    }

    public final int getAttachmentType() {
        return this.attachmentType;
    }

    @NotNull
    public final String getCategoryNo() {
        return this.categoryNo;
    }

    @Nullable
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<String> getGoodsList() {
        return this.goodsList;
    }

    @Nullable
    public final PubWorkLocationItemBean getLocation() {
        return this.location;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final List<RichSubjectBean> getSubjectList() {
        return this.subjectList;
    }

    @NotNull
    public final String getTagNo() {
        return this.tagNo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getVisit() {
        return this.visit;
    }

    public final void setAttachmentInfo(@Nullable PubWorksAttachmentInfo pubWorksAttachmentInfo) {
        this.attachmentInfo = pubWorksAttachmentInfo;
    }

    public final void setAttachmentType(int i) {
        this.attachmentType = i;
    }

    public final void setCategoryNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryNo = str;
    }

    public final void setChannelNo(@Nullable String str) {
        this.channelNo = str;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setGoodsList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.goodsList = list;
    }

    public final void setLocation(@Nullable PubWorkLocationItemBean pubWorkLocationItemBean) {
        this.location = pubWorkLocationItemBean;
    }

    public final void setRequestId(@Nullable String str) {
        this.requestId = str;
    }

    public final void setTagNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagNo = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setVisit(int i) {
        this.visit = i;
    }

    public /* synthetic */ PublishWorksBean(List list, String str, String str2, PubWorkLocationItemBean pubWorkLocationItemBean, List list2, String str3, int i, PubWorksAttachmentInfo pubWorksAttachmentInfo, int i2, String str4, List list3, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? null : pubWorkLocationItemBean, (i3 & 16) != 0 ? new ArrayList() : list2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? null : pubWorksAttachmentInfo, (i3 & 256) == 0 ? i2 : 0, (i3 & 512) == 0 ? str4 : null, (i3 & 1024) != 0 ? new ArrayList() : list3, (i3 & 2048) != 0 ? "" : str5, (i3 & 4096) == 0 ? str6 : "");
    }
}

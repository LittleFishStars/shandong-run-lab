package com.huachenjie.mall.bean;

import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mall.page.comment.list.CommodityCommentListFragment;
import com.zj.adlib.s72;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\u0006\u0010'\u001a\u00020 J\u000e\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020\fJ\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/huachenjie/mall/bean/CommodityCommentBean;", "", UserConstants.USER_PARAMS.b, "", "avatar", "attachment", "", "Lcom/huachenjie/mall/bean/AttachmentBean;", "submitTime", "", "content", CommodityCommentListFragment.EVALUATE, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;I)V", "getAttachment", "()Ljava/util/List;", "getAvatar", "()Ljava/lang/String;", "getContent", "getEvaluate", "()I", "getNickName", "getSubmitTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "formatComment", "formatImageUrl", "index", "formatSubmitTime", "hashCode", "showComment", "showImage", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommodityCommentBean {

    @Nullable
    private final List<AttachmentBean> attachment;

    @NotNull
    private final String avatar;

    @NotNull
    private final String content;
    private final int evaluate;

    @NotNull
    private final String nickName;
    private final long submitTime;

    public CommodityCommentBean() {
        this(null, null, null, 0L, null, 0, 63, null);
    }

    public CommodityCommentBean(@NotNull String str, @NotNull String str2, @Nullable List<AttachmentBean> list, long j, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, "content");
        this.nickName = str;
        this.avatar = str2;
        this.attachment = list;
        this.submitTime = j;
        this.content = str3;
        this.evaluate = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommodityCommentBean copy$default(CommodityCommentBean commodityCommentBean, String str, String str2, List list, long j, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commodityCommentBean.nickName;
        }
        if ((i2 & 2) != 0) {
            str2 = commodityCommentBean.avatar;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            list = commodityCommentBean.attachment;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            j = commodityCommentBean.submitTime;
        }
        long j2 = j;
        if ((i2 & 16) != 0) {
            str3 = commodityCommentBean.content;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            i = commodityCommentBean.evaluate;
        }
        return commodityCommentBean.copy(str, str4, list2, j2, str5, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final List<AttachmentBean> component3() {
        return this.attachment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSubmitTime() {
        return this.submitTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getEvaluate() {
        return this.evaluate;
    }

    @NotNull
    public final CommodityCommentBean copy(@NotNull String nickName, @NotNull String avatar, @Nullable List<AttachmentBean> attachment, long submitTime, @NotNull String content, int evaluate) {
        Intrinsics.checkNotNullParameter(nickName, UserConstants.USER_PARAMS.b);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(content, "content");
        return new CommodityCommentBean(nickName, avatar, attachment, submitTime, content, evaluate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommodityCommentBean)) {
            return false;
        }
        CommodityCommentBean commodityCommentBean = (CommodityCommentBean) other;
        return Intrinsics.areEqual(this.nickName, commodityCommentBean.nickName) && Intrinsics.areEqual(this.avatar, commodityCommentBean.avatar) && Intrinsics.areEqual(this.attachment, commodityCommentBean.attachment) && this.submitTime == commodityCommentBean.submitTime && Intrinsics.areEqual(this.content, commodityCommentBean.content) && this.evaluate == commodityCommentBean.evaluate;
    }

    @NotNull
    public final String formatComment() {
        if (!TextUtils.isEmpty(this.content)) {
            return this.content;
        }
        List<AttachmentBean> list = this.attachment;
        return (list == null || list.isEmpty()) ? "此用户未填写评价内容" : "";
    }

    @NotNull
    public final String formatImageUrl(int index) {
        List<AttachmentBean> list = this.attachment;
        if (list == null || list.isEmpty()) {
            return "";
        }
        return index >= 0 && index < this.attachment.size() ? this.attachment.get(index).getUrl() : "";
    }

    @NotNull
    public final String formatSubmitTime() {
        long j = this.submitTime;
        if (j == 0) {
            return "";
        }
        try {
            String strC = s72.c(j, "yyyy.MM.dd");
            Intrinsics.checkNotNullExpressionValue(strC, "{\n            DateUtil.f…, \"yyyy.MM.dd\")\n        }");
            return strC;
        } catch (Exception unused) {
            return "";
        }
    }

    @Nullable
    public final List<AttachmentBean> getAttachment() {
        return this.attachment;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getEvaluate() {
        return this.evaluate;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    public final long getSubmitTime() {
        return this.submitTime;
    }

    public int hashCode() {
        int iHashCode = ((this.nickName.hashCode() * 31) + this.avatar.hashCode()) * 31;
        List<AttachmentBean> list = this.attachment;
        return ((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Long.hashCode(this.submitTime)) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.evaluate);
    }

    public final boolean showComment() {
        return !TextUtils.isEmpty(formatComment());
    }

    public final boolean showImage(int index) {
        List<AttachmentBean> list = this.attachment;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return index >= 0 && index < this.attachment.size();
    }

    @NotNull
    public String toString() {
        return "CommodityCommentBean(nickName=" + this.nickName + ", avatar=" + this.avatar + ", attachment=" + this.attachment + ", submitTime=" + this.submitTime + ", content=" + this.content + ", evaluate=" + this.evaluate + ')';
    }

    public /* synthetic */ CommodityCommentBean(String str, String str2, List list, long j, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? new ArrayList() : list, (i2 & 8) != 0 ? 0L : j, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? 0 : i);
    }
}

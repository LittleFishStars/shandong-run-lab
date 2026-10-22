package com.huachenjie.mall.bean;

import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006&"}, d2 = {"Lcom/huachenjie/mall/bean/WriteReviewRequestBean;", "", "orderNo", "", "content", "attachmentList", "", "Lcom/huachenjie/base/bean/ImageBean;", "descScore", "", "expressScore", "serviceScore", "anonymous", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IIIZ)V", "getAnonymous", "()Z", "getAttachmentList", "()Ljava/util/List;", "getContent", "()Ljava/lang/String;", "getDescScore", "()I", "getExpressScore", "getOrderNo", "getServiceScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WriteReviewRequestBean {
    private final boolean anonymous;

    @NotNull
    private final List<ImageBean> attachmentList;

    @NotNull
    private final String content;
    private final int descScore;
    private final int expressScore;

    @NotNull
    private final String orderNo;
    private final int serviceScore;

    public WriteReviewRequestBean(@NotNull String str, @NotNull String str2, @NotNull List<ImageBean> list, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "orderNo");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(list, "attachmentList");
        this.orderNo = str;
        this.content = str2;
        this.attachmentList = list;
        this.descScore = i;
        this.expressScore = i2;
        this.serviceScore = i3;
        this.anonymous = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WriteReviewRequestBean copy$default(WriteReviewRequestBean writeReviewRequestBean, String str, String str2, List list, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = writeReviewRequestBean.orderNo;
        }
        if ((i4 & 2) != 0) {
            str2 = writeReviewRequestBean.content;
        }
        String str3 = str2;
        if ((i4 & 4) != 0) {
            list = writeReviewRequestBean.attachmentList;
        }
        List list2 = list;
        if ((i4 & 8) != 0) {
            i = writeReviewRequestBean.descScore;
        }
        int i5 = i;
        if ((i4 & 16) != 0) {
            i2 = writeReviewRequestBean.expressScore;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = writeReviewRequestBean.serviceScore;
        }
        int i7 = i3;
        if ((i4 & 64) != 0) {
            z = writeReviewRequestBean.anonymous;
        }
        return writeReviewRequestBean.copy(str, str3, list2, i5, i6, i7, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrderNo() {
        return this.orderNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<ImageBean> component3() {
        return this.attachmentList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDescScore() {
        return this.descScore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getExpressScore() {
        return this.expressScore;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getServiceScore() {
        return this.serviceScore;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAnonymous() {
        return this.anonymous;
    }

    @NotNull
    public final WriteReviewRequestBean copy(@NotNull String orderNo, @NotNull String content, @NotNull List<ImageBean> attachmentList, int descScore, int expressScore, int serviceScore, boolean anonymous) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(attachmentList, "attachmentList");
        return new WriteReviewRequestBean(orderNo, content, attachmentList, descScore, expressScore, serviceScore, anonymous);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WriteReviewRequestBean)) {
            return false;
        }
        WriteReviewRequestBean writeReviewRequestBean = (WriteReviewRequestBean) other;
        return Intrinsics.areEqual(this.orderNo, writeReviewRequestBean.orderNo) && Intrinsics.areEqual(this.content, writeReviewRequestBean.content) && Intrinsics.areEqual(this.attachmentList, writeReviewRequestBean.attachmentList) && this.descScore == writeReviewRequestBean.descScore && this.expressScore == writeReviewRequestBean.expressScore && this.serviceScore == writeReviewRequestBean.serviceScore && this.anonymous == writeReviewRequestBean.anonymous;
    }

    public final boolean getAnonymous() {
        return this.anonymous;
    }

    @NotNull
    public final List<ImageBean> getAttachmentList() {
        return this.attachmentList;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getDescScore() {
        return this.descScore;
    }

    public final int getExpressScore() {
        return this.expressScore;
    }

    @NotNull
    public final String getOrderNo() {
        return this.orderNo;
    }

    public final int getServiceScore() {
        return this.serviceScore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((((((this.orderNo.hashCode() * 31) + this.content.hashCode()) * 31) + this.attachmentList.hashCode()) * 31) + Integer.hashCode(this.descScore)) * 31) + Integer.hashCode(this.expressScore)) * 31) + Integer.hashCode(this.serviceScore)) * 31;
        boolean z = this.anonymous;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    @NotNull
    public String toString() {
        return "WriteReviewRequestBean(orderNo=" + this.orderNo + ", content=" + this.content + ", attachmentList=" + this.attachmentList + ", descScore=" + this.descScore + ", expressScore=" + this.expressScore + ", serviceScore=" + this.serviceScore + ", anonymous=" + this.anonymous + ')';
    }
}

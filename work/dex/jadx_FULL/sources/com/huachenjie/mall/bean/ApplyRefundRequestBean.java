package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/huachenjie/mall/bean/ApplyRefundRequestBean;", "", "orderItemNo", "", "afterSaleType", "", "refundReason", "refundAmount", "applyDesc", "attachmentList", "", "Lcom/huachenjie/mall/bean/AttachmentBean;", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAfterSaleType", "()I", "getApplyDesc", "()Ljava/lang/String;", "getAttachmentList", "()Ljava/util/List;", "getOrderItemNo", "getRefundAmount", "getRefundReason", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ApplyRefundRequestBean {
    private final int afterSaleType;

    @NotNull
    private final String applyDesc;

    @NotNull
    private final List<AttachmentBean> attachmentList;

    @NotNull
    private final String orderItemNo;

    @NotNull
    private final String refundAmount;
    private final int refundReason;

    public ApplyRefundRequestBean(@NotNull String str, int i, int i2, @NotNull String str2, @NotNull String str3, @NotNull List<AttachmentBean> list) {
        Intrinsics.checkNotNullParameter(str, "orderItemNo");
        Intrinsics.checkNotNullParameter(str2, "refundAmount");
        Intrinsics.checkNotNullParameter(str3, "applyDesc");
        Intrinsics.checkNotNullParameter(list, "attachmentList");
        this.orderItemNo = str;
        this.afterSaleType = i;
        this.refundReason = i2;
        this.refundAmount = str2;
        this.applyDesc = str3;
        this.attachmentList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplyRefundRequestBean copy$default(ApplyRefundRequestBean applyRefundRequestBean, String str, int i, int i2, String str2, String str3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = applyRefundRequestBean.orderItemNo;
        }
        if ((i3 & 2) != 0) {
            i = applyRefundRequestBean.afterSaleType;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = applyRefundRequestBean.refundReason;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = applyRefundRequestBean.refundAmount;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            str3 = applyRefundRequestBean.applyDesc;
        }
        String str5 = str3;
        if ((i3 & 32) != 0) {
            list = applyRefundRequestBean.attachmentList;
        }
        return applyRefundRequestBean.copy(str, i4, i5, str4, str5, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOrderItemNo() {
        return this.orderItemNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAfterSaleType() {
        return this.afterSaleType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRefundReason() {
        return this.refundReason;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRefundAmount() {
        return this.refundAmount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getApplyDesc() {
        return this.applyDesc;
    }

    @NotNull
    public final List<AttachmentBean> component6() {
        return this.attachmentList;
    }

    @NotNull
    public final ApplyRefundRequestBean copy(@NotNull String orderItemNo, int afterSaleType, int refundReason, @NotNull String refundAmount, @NotNull String applyDesc, @NotNull List<AttachmentBean> attachmentList) {
        Intrinsics.checkNotNullParameter(orderItemNo, "orderItemNo");
        Intrinsics.checkNotNullParameter(refundAmount, "refundAmount");
        Intrinsics.checkNotNullParameter(applyDesc, "applyDesc");
        Intrinsics.checkNotNullParameter(attachmentList, "attachmentList");
        return new ApplyRefundRequestBean(orderItemNo, afterSaleType, refundReason, refundAmount, applyDesc, attachmentList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplyRefundRequestBean)) {
            return false;
        }
        ApplyRefundRequestBean applyRefundRequestBean = (ApplyRefundRequestBean) other;
        return Intrinsics.areEqual(this.orderItemNo, applyRefundRequestBean.orderItemNo) && this.afterSaleType == applyRefundRequestBean.afterSaleType && this.refundReason == applyRefundRequestBean.refundReason && Intrinsics.areEqual(this.refundAmount, applyRefundRequestBean.refundAmount) && Intrinsics.areEqual(this.applyDesc, applyRefundRequestBean.applyDesc) && Intrinsics.areEqual(this.attachmentList, applyRefundRequestBean.attachmentList);
    }

    public final int getAfterSaleType() {
        return this.afterSaleType;
    }

    @NotNull
    public final String getApplyDesc() {
        return this.applyDesc;
    }

    @NotNull
    public final List<AttachmentBean> getAttachmentList() {
        return this.attachmentList;
    }

    @NotNull
    public final String getOrderItemNo() {
        return this.orderItemNo;
    }

    @NotNull
    public final String getRefundAmount() {
        return this.refundAmount;
    }

    public final int getRefundReason() {
        return this.refundReason;
    }

    public int hashCode() {
        return (((((((((this.orderItemNo.hashCode() * 31) + Integer.hashCode(this.afterSaleType)) * 31) + Integer.hashCode(this.refundReason)) * 31) + this.refundAmount.hashCode()) * 31) + this.applyDesc.hashCode()) * 31) + this.attachmentList.hashCode();
    }

    @NotNull
    public String toString() {
        return "ApplyRefundRequestBean(orderItemNo=" + this.orderItemNo + ", afterSaleType=" + this.afterSaleType + ", refundReason=" + this.refundReason + ", refundAmount=" + this.refundAmount + ", applyDesc=" + this.applyDesc + ", attachmentList=" + this.attachmentList + ')';
    }
}

package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/mall/bean/OrderCountBean;", "", "waitPayCount", "", "waitDeliveryCount", "waitReceiptCount", "waitCommentCount", "afterSaleCount", "(IIIII)V", "getAfterSaleCount", "()I", "getWaitCommentCount", "getWaitDeliveryCount", "getWaitPayCount", "getWaitReceiptCount", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderCountBean {
    private final int afterSaleCount;
    private final int waitCommentCount;
    private final int waitDeliveryCount;
    private final int waitPayCount;
    private final int waitReceiptCount;

    public OrderCountBean() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public OrderCountBean(int i, int i2, int i3, int i4, int i5) {
        this.waitPayCount = i;
        this.waitDeliveryCount = i2;
        this.waitReceiptCount = i3;
        this.waitCommentCount = i4;
        this.afterSaleCount = i5;
    }

    public static /* synthetic */ OrderCountBean copy$default(OrderCountBean orderCountBean, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = orderCountBean.waitPayCount;
        }
        if ((i6 & 2) != 0) {
            i2 = orderCountBean.waitDeliveryCount;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = orderCountBean.waitReceiptCount;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = orderCountBean.waitCommentCount;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = orderCountBean.afterSaleCount;
        }
        return orderCountBean.copy(i, i7, i8, i9, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWaitPayCount() {
        return this.waitPayCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWaitDeliveryCount() {
        return this.waitDeliveryCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWaitReceiptCount() {
        return this.waitReceiptCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWaitCommentCount() {
        return this.waitCommentCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAfterSaleCount() {
        return this.afterSaleCount;
    }

    @NotNull
    public final OrderCountBean copy(int waitPayCount, int waitDeliveryCount, int waitReceiptCount, int waitCommentCount, int afterSaleCount) {
        return new OrderCountBean(waitPayCount, waitDeliveryCount, waitReceiptCount, waitCommentCount, afterSaleCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderCountBean)) {
            return false;
        }
        OrderCountBean orderCountBean = (OrderCountBean) other;
        return this.waitPayCount == orderCountBean.waitPayCount && this.waitDeliveryCount == orderCountBean.waitDeliveryCount && this.waitReceiptCount == orderCountBean.waitReceiptCount && this.waitCommentCount == orderCountBean.waitCommentCount && this.afterSaleCount == orderCountBean.afterSaleCount;
    }

    public final int getAfterSaleCount() {
        return this.afterSaleCount;
    }

    public final int getWaitCommentCount() {
        return this.waitCommentCount;
    }

    public final int getWaitDeliveryCount() {
        return this.waitDeliveryCount;
    }

    public final int getWaitPayCount() {
        return this.waitPayCount;
    }

    public final int getWaitReceiptCount() {
        return this.waitReceiptCount;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.waitPayCount) * 31) + Integer.hashCode(this.waitDeliveryCount)) * 31) + Integer.hashCode(this.waitReceiptCount)) * 31) + Integer.hashCode(this.waitCommentCount)) * 31) + Integer.hashCode(this.afterSaleCount);
    }

    @NotNull
    public String toString() {
        return "OrderCountBean(waitPayCount=" + this.waitPayCount + ", waitDeliveryCount=" + this.waitDeliveryCount + ", waitReceiptCount=" + this.waitReceiptCount + ", waitCommentCount=" + this.waitCommentCount + ", afterSaleCount=" + this.afterSaleCount + ')';
    }

    public /* synthetic */ OrderCountBean(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5);
    }
}

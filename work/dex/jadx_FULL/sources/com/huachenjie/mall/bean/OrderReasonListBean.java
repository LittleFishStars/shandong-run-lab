package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/bean/OrderReasonListBean;", "", GoodsSpecificationPreviewActivity.z, "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/OrderReasonBean;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderReasonListBean {

    @NotNull
    private final ArrayList<OrderReasonBean> list;

    /* JADX WARN: Illegal instructions before constructor call */
    public OrderReasonListBean() {
        ArrayList arrayList = null;
        this(arrayList, 1, arrayList);
    }

    public OrderReasonListBean(@NotNull ArrayList<OrderReasonBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, GoodsSpecificationPreviewActivity.z);
        this.list = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderReasonListBean copy$default(OrderReasonListBean orderReasonListBean, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = orderReasonListBean.list;
        }
        return orderReasonListBean.copy(arrayList);
    }

    @NotNull
    public final ArrayList<OrderReasonBean> component1() {
        return this.list;
    }

    @NotNull
    public final OrderReasonListBean copy(@NotNull ArrayList<OrderReasonBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new OrderReasonListBean(list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OrderReasonListBean) && Intrinsics.areEqual(this.list, ((OrderReasonListBean) other).list);
    }

    @NotNull
    public final ArrayList<OrderReasonBean> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "OrderReasonListBean(list=" + this.list + ')';
    }

    public /* synthetic */ OrderReasonListBean(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }
}

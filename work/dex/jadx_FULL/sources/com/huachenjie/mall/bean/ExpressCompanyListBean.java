package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/bean/ExpressCompanyListBean;", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/mall/bean/ExpressCompanyBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExpressCompanyListBean {

    @NotNull
    private final List<ExpressCompanyBean> list;

    public ExpressCompanyListBean(@NotNull List<ExpressCompanyBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpressCompanyListBean copy$default(ExpressCompanyListBean expressCompanyListBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = expressCompanyListBean.list;
        }
        return expressCompanyListBean.copy(list);
    }

    @NotNull
    public final List<ExpressCompanyBean> component1() {
        return this.list;
    }

    @NotNull
    public final ExpressCompanyListBean copy(@NotNull List<ExpressCompanyBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        return new ExpressCompanyListBean(list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExpressCompanyListBean) && Intrinsics.areEqual(this.list, ((ExpressCompanyListBean) other).list);
    }

    @NotNull
    public final List<ExpressCompanyBean> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExpressCompanyListBean(list=" + this.list + ')';
    }
}

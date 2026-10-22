package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/bean/SportTestPeriodBean;", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/sport/bean/YearPeriod;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SportTestPeriodBean {

    @Nullable
    private final List<YearPeriod> list;

    /* JADX WARN: Illegal instructions before constructor call */
    public SportTestPeriodBean() {
        List list = null;
        this(list, 1, list);
    }

    public SportTestPeriodBean(@Nullable List<YearPeriod> list) {
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportTestPeriodBean copy$default(SportTestPeriodBean sportTestPeriodBean, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sportTestPeriodBean.list;
        }
        return sportTestPeriodBean.copy(list);
    }

    @Nullable
    public final List<YearPeriod> component1() {
        return this.list;
    }

    @NotNull
    public final SportTestPeriodBean copy(@Nullable List<YearPeriod> list) {
        return new SportTestPeriodBean(list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SportTestPeriodBean) && Intrinsics.areEqual(this.list, ((SportTestPeriodBean) other).list);
    }

    @Nullable
    public final List<YearPeriod> getList() {
        return this.list;
    }

    public int hashCode() {
        List<YearPeriod> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "SportTestPeriodBean(list=" + this.list + ')';
    }

    public /* synthetic */ SportTestPeriodBean(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}

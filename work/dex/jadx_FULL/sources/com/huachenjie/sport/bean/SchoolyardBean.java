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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/bean/SchoolyardBean;", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/sport/bean/HuodongBean;", "hasNext", "", "pageSize", "", "pageNum", "total", "(Ljava/util/List;ZIII)V", "getHasNext", "()Z", "getList", "()Ljava/util/List;", "getPageNum", "()I", "getPageSize", "getTotal", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SchoolyardBean {
    private final boolean hasNext;

    @Nullable
    private final List<HuodongBean> list;
    private final int pageNum;
    private final int pageSize;
    private final int total;

    public SchoolyardBean() {
        this(null, false, 0, 0, 0, 31, null);
    }

    public SchoolyardBean(@Nullable List<HuodongBean> list, boolean z, int i, int i2, int i3) {
        this.list = list;
        this.hasNext = z;
        this.pageSize = i;
        this.pageNum = i2;
        this.total = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SchoolyardBean copy$default(SchoolyardBean schoolyardBean, List list, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = schoolyardBean.list;
        }
        if ((i4 & 2) != 0) {
            z = schoolyardBean.hasNext;
        }
        boolean z2 = z;
        if ((i4 & 4) != 0) {
            i = schoolyardBean.pageSize;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = schoolyardBean.pageNum;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = schoolyardBean.total;
        }
        return schoolyardBean.copy(list, z2, i5, i6, i3);
    }

    @Nullable
    public final List<HuodongBean> component1() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final SchoolyardBean copy(@Nullable List<HuodongBean> list, boolean hasNext, int pageSize, int pageNum, int total) {
        return new SchoolyardBean(list, hasNext, pageSize, pageNum, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SchoolyardBean)) {
            return false;
        }
        SchoolyardBean schoolyardBean = (SchoolyardBean) other;
        return Intrinsics.areEqual(this.list, schoolyardBean.list) && this.hasNext == schoolyardBean.hasNext && this.pageSize == schoolyardBean.pageSize && this.pageNum == schoolyardBean.pageNum && this.total == schoolyardBean.total;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    @Nullable
    public final List<HuodongBean> getList() {
        return this.list;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotal() {
        return this.total;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        List<HuodongBean> list = this.list;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z = this.hasNext;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode + r1) * 31) + Integer.hashCode(this.pageSize)) * 31) + Integer.hashCode(this.pageNum)) * 31) + Integer.hashCode(this.total);
    }

    @NotNull
    public String toString() {
        return "SchoolyardBean(list=" + this.list + ", hasNext=" + this.hasNext + ", pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", total=" + this.total + ')';
    }

    public /* synthetic */ SchoolyardBean(List list, boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : list, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? 10 : i, (i4 & 8) != 0 ? 1 : i2, (i4 & 16) == 0 ? i3 : 0);
    }
}
